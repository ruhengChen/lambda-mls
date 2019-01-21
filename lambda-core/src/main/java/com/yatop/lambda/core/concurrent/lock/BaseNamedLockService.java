package com.yatop.lambda.core.concurrent.lock;

import com.yatop.lambda.core.concurrent.event.LambdaEvent;
import com.yatop.lambda.core.utils.DataUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class BaseNamedLockService {

    public static final long NAMED_LOCK_EXPIRE_MILLIS_DURATION = 60 * 1000;
    public static final long NAMED_LOCK_WAIT_EVENT_SECONDS = 8;

    public static Logger logger = LoggerFactory.getLogger(BaseNamedLockService.class);

    //加锁线程ID, 默认加锁请求（请求多个资源时，需另外new LockRequest）
    private ConcurrentHashMap<Long, LockRequest> defaultLockRequestHashMap = new ConcurrentHashMap<Long, LockRequest>();

    //加锁资源ID, 加锁请求
    private ConcurrentHashMap<Long, LockRequest> namedLockHashMap = new ConcurrentHashMap<Long, LockRequest>();

    //加锁线程ID，加锁请求链表
    private ConcurrentHashMap<Long, ConcurrentLinkedQueue<LockRequest>> threadChainHashMap = new ConcurrentHashMap<Long, ConcurrentLinkedQueue<LockRequest>>();

    //定期过期检测中未过期加锁请求缓存，过期时间，加锁请求链表
    private TreeMap<Long, ArrayList<LockRequest>> clearExpireCacheMap = new TreeMap<Long, ArrayList<LockRequest>>();

    private boolean isLocked(LockRequest lockRequest) {
        if(DataUtil.isNull(lockRequest))
            return false;

        LockRequest holdRequest = namedLockHashMap.get(lockRequest.getName());
        return DataUtil.isNotNull(holdRequest) ? holdRequest.getExpire() < System.currentTimeMillis() : false;
    }

    private void lockResource(LockRequest lockRequest) {
        lockRequest.setHold(true);
        this.namedLockHashMap.put(lockRequest.getName(), lockRequest);
        ConcurrentLinkedQueue<LockRequest> chainList = this.threadChainHashMap.get(lockRequest.getThread().getId());
        if(DataUtil.isNull(chainList)) {
            ConcurrentLinkedQueue<LockRequest> newChainList = new ConcurrentLinkedQueue<LockRequest>();
            newChainList.offer(lockRequest);
            this.threadChainHashMap.put(lockRequest.getThread().getId(), newChainList);
        } else {
            chainList.offer(lockRequest);
        }
    }

    private void unlockResource(LockRequest unlockRequest) {
        unlockRequest.setHold(false);
        LockRequest holdRequest = this.namedLockHashMap.get(unlockRequest.getName());
        if(holdRequest.getThread().getId() == unlockRequest.getThread().getId())
            this.namedLockHashMap.remove(unlockRequest.getName());
    }

    private LockRequest lock(LockRequest lockRequest) {
        if(DataUtil.isNotNull(lockRequest)) {
            if (lockRequest.getExpire() < System.currentTimeMillis())
                return null;

            LockRequest holdRequest = this.namedLockHashMap.get(lockRequest.getName());
            if (DataUtil.isNull(holdRequest)) {
                lockResource(lockRequest);
            } else if (holdRequest.isNotHold()) {
                holdRequest.setHold(false);
                lockResource(lockRequest);
            }
        }
        return lockRequest;
    }

    //解锁清理当前线程该类资源的所有占有
    private LockRequest unlock(LockRequest unlockRequest) {
        if(DataUtil.isNotNull(unlockRequest)) {
            Long unlockThreadId = unlockRequest.getThread().getId();
            ConcurrentLinkedQueue<LockRequest> chainList = this.threadChainHashMap.remove(unlockThreadId);
            if(DataUtil.isNotNull(chainList)) {
                for (LockRequest lockedRequest : chainList) {
                    unlockResource(lockedRequest);
                }
                chainList.clear();
            }
        }
        return unlockRequest;
    }

    private LockRequest prepareRequestLock(Long resourceId) {
        if(DataUtil.isNull(resourceId))
            return null;

        Long curThreadId = Thread.currentThread().getId();
        LockRequest defaultLockRequest = defaultLockRequestHashMap.get(curThreadId);
        if(DataUtil.isNull(defaultLockRequest)) {
            //new默认LockRequest
            defaultLockRequest = new LockRequest(this, resourceId);
            defaultLockRequestHashMap.put(curThreadId, defaultLockRequest);
            return defaultLockRequest;
        }

        if (defaultLockRequest.isHold()) {
            if (defaultLockRequest.getName() != resourceId) {
                //new新LockRequest
                return new LockRequest(defaultLockRequest, resourceId);
            } else {
                //续期
                defaultLockRequest.renewLockRequest();
                return defaultLockRequest;
            }
        } else {
            //循环使用
            return defaultLockRequest.recycleLockRequest(resourceId);
        }
    }

    public final LockRequest prepareDoLock(Long resourceId) {
        return prepareRequestLock(resourceId);
    }

    public final LockRequest prepareDoUnlock() {
        ConcurrentLinkedQueue<LockRequest> chainList = threadChainHashMap.get(Thread.currentThread().getId());
        return DataUtil.isNotNull(chainList) ? chainList.peek() : null;
    }

    //定期过期检测防止内存泄漏
    public final void clearExpireLock() {
        {
            if(!this.clearExpireCacheMap.isEmpty()) {
                Iterator<Map.Entry<Long, ArrayList<LockRequest>>> iterator = this.clearExpireCacheMap.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry<Long, ArrayList<LockRequest>> entry = iterator.next();
                    if (entry.getKey() < System.currentTimeMillis()) {
                        for (LockRequest cacheRequest : entry.getValue()) {
                            cacheRequest.setHold(false);
                            if(this.namedLockHashMap.get(cacheRequest.getName()).getThread().getId() == cacheRequest.getThread().getId())
                                this.namedLockHashMap.remove(cacheRequest.getName());
                        }
                        iterator.remove();
                    } else {
                        break;
                    }
                }
            }
        }

        for(Long curThreadId : this.threadChainHashMap.keySet()) {

            ConcurrentLinkedQueue<LockRequest> chainList = this.threadChainHashMap.get(curThreadId);
            if(DataUtil.isNotNull(chainList)) {
                LockRequest peekLock = chainList.peek();
                if(DataUtil.isNotNull(peekLock) && peekLock.isNotHold()) {

                    chainList = this.threadChainHashMap.remove(curThreadId);
                    if(DataUtil.isNotNull(chainList)) {
                        for (LockRequest threadRequest : chainList) {
                            if(threadRequest.isNotHold()) {
                                if(threadRequest.getHold()) {
                                    logger.error("Warning!!! Remove Expired Named Lock[NamedLock:{}, Resource ID{}, Thread ID{}, Expired Time{}, Remove Time{}]",
                                            threadRequest.namedLockServiceId(), threadRequest.getName(), threadRequest.getThread().getId(), new Timestamp(threadRequest.getExpire()), new Timestamp(System.currentTimeMillis()));
                                }
                                threadRequest.setHold(false);
                                LockRequest holdRequest = this.namedLockHashMap.get(threadRequest.getName());
                                if(DataUtil.isNotNull(holdRequest) && holdRequest.getThread().getId() == curThreadId)
                                    this.namedLockHashMap.remove(threadRequest.getName());

                            } else {
                                ArrayList<LockRequest> cacheList = this.clearExpireCacheMap.get(threadRequest.getExpire());
                                if(DataUtil.isNotNull(cacheList))
                                    cacheList.add(threadRequest);
                                else {
                                    cacheList = new ArrayList<LockRequest>();
                                    cacheList.add(threadRequest);
                                    this.clearExpireCacheMap.put(threadRequest.getExpire(), cacheList);
                                }
                            }
                        }
                        chainList.clear();
                    }
                }
            }
        }
    }

    protected abstract String namedLockServiceId();

    public static class LockRequest {
        private BaseNamedLockService namedLockService;
        private LambdaEvent event;
        private Long name;
        private Thread thread;
        private volatile Long expire;
        private volatile boolean hold;

        private LockRequest(BaseNamedLockService namedLockService, Long name) {
            this.namedLockService = namedLockService;
            this.event = new LambdaEvent();
            this.name = name;
            this.thread = Thread.currentThread();
            this.expire = generateExpireTime();
            this.hold = false;
        }

        private LockRequest(LockRequest defaultRequestLock, Long name) {
            this.namedLockService = defaultRequestLock.getNamedLockService();
            this.event = defaultRequestLock.getEvent();
            this.name = name;
            this.thread = defaultRequestLock.getThread();
            this.expire = generateExpireTime();
            this.hold = false;
        }

        private LockRequest recycleLockRequest(Long name) {
            this.name = name;
            this.expire = generateExpireTime();
            this.hold = false;
            return this;
        }

        private LockRequest renewLockRequest() {
            this.expire = generateExpireTime();
            return this;
        }

        private Long generateExpireTime() {
            return System.currentTimeMillis() + NAMED_LOCK_EXPIRE_MILLIS_DURATION;
        }

        public void lockResource() {
            this.namedLockService.lock(this);
        }

        public void unlockResource() {
            this.namedLockService.unlock(this);
        }

        public Long getName() {
            return this.name;
        }

        public Thread getThread() {
            return this.thread;
        }

        public Long getExpire() {
            return this.expire;
        }

        public BaseNamedLockService getNamedLockService() {
            return this.namedLockService;
        }

        public LambdaEvent getEvent() {
            return event;
        }

        public String namedLockServiceId() {
            return this.namedLockService.namedLockServiceId();
        }

        public boolean isIdle() {
            return !this.namedLockService.isLocked(this);
        }

        public boolean isHold() {
            return this.hold && (System.currentTimeMillis() < this.expire);
        }

        public boolean isNotHold() {
            return !isHold();
        }

        private void setHold(boolean hold) {
            this.hold = hold;
        }

        private boolean getHold() {
            return this.hold;
        }
    }
}
