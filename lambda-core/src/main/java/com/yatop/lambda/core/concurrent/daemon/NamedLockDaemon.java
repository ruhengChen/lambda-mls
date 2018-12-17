package com.yatop.lambda.core.concurrent.daemon;

import com.yatop.lambda.core.concurrent.event.LambdaEvent;
import com.yatop.lambda.core.concurrent.lock.BaseNamedLockService;
import com.yatop.lambda.core.concurrent.lock.BaseNamedLockService.LockRequest;
import com.yatop.lambda.core.utils.DataUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

@Service
public class NamedLockDaemon implements DisposableBean, Runnable {

    public static Logger logger = LoggerFactory.getLogger(NamedLockDaemon.class);

    //负责完成串行加锁和过期锁清理
    private Thread daemonThread;
    private ConcurrentLinkedQueue<LockRequest> lockRequestQueue = new ConcurrentLinkedQueue<LockRequest>();
    private ConcurrentLinkedQueue<LockRequest> unlockRequestQueue = new ConcurrentLinkedQueue<LockRequest>();
    private TreeMap<String, BaseNamedLockService> registeredNamedLockMap = new TreeMap<String, BaseNamedLockService>();
    private LambdaEvent queueEvent = new LambdaEvent();
    private long counter = 0;
    private volatile boolean exit = false;

    NamedLockDaemon(){
        this.daemonThread = new Thread(this);
        this.daemonThread.start();
    }

    @Override
    public void run(){
        while(!exit){
            try {
                this.queueEvent.waitEvent(997, TimeUnit.NANOSECONDS);
                dealQueueRequest();
                this.queueEvent.resetEvent();
            } catch (InterruptedException e) {
                continue;
            } catch (Throwable e) {
                logger.error("Named-Lock-Daemon线程未知错误", e);
            }
        }
        clearQueueRequest();
    }

    @Override
    public void destroy(){
        this.exit = true;
        this.daemonThread.interrupt();
    }

    private void dealQueueRequest() {

        while(!this.unlockRequestQueue.isEmpty() || !this.lockRequestQueue.isEmpty()) {

            while(!this.unlockRequestQueue.isEmpty()) {
                LockRequest unlockRequest = this.unlockRequestQueue.poll();
                if(DataUtil.isNotNull(unlockRequest)) {
                    unlockRequest.unlockResource();
                    unlockRequest.getEvent().notifyEvent();
                }
            }

            LockRequest lockRequest = this.lockRequestQueue.poll();
            if(DataUtil.isNotNull(lockRequest)) {
                ++this.counter;
                registerNamedLock(lockRequest);
                lockRequest.lockResource();
                lockRequest.getEvent().notifyEvent();
            }
            clearExpireLock();
        }
    }

    private void registerNamedLock(LockRequest lockRequest) {
        if(DataUtil.isNull(this.registeredNamedLockMap.get(lockRequest.namedLockServiceId())))
            this.registeredNamedLockMap.put(lockRequest.namedLockServiceId(), lockRequest.getNamedLockService());
    }

    private void clearQueueRequest() {
        while (!this.lockRequestQueue.isEmpty()) {
            LockRequest lockRequest = this.lockRequestQueue.poll();
            if (DataUtil.isNotNull(lockRequest)) {
                lockRequest.getEvent().notifyEvent();
            }
        }
        while (!this.unlockRequestQueue.isEmpty()) {
            LockRequest lockRequest = this.lockRequestQueue.poll();
            if (DataUtil.isNotNull(lockRequest)) {
                lockRequest.getEvent().notifyEvent();
            }
        }
    }

    private void clearExpireLock() {
        if(this.counter > 69) {
            if(!this.registeredNamedLockMap.isEmpty()) {
                Iterator<Map.Entry<String, BaseNamedLockService>> iterator = this.registeredNamedLockMap.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry<String, BaseNamedLockService> entry = iterator.next();
                    entry.getValue().clearExpireLock();
                }
            }
            this.counter = 0;
        }
    }

    public boolean requestLock(LockRequest lockRequest) {
        if(DataUtil.isNotNull(lockRequest)) {
            if(lockRequest.isNotHold()) {
                if (lockRequest.isIdle()) {
                    this.lockRequestQueue.offer(lockRequest);
                    this.queueEvent.notifyEvent();

                    try {
                        lockRequest.getEvent().resetEvent();
                        lockRequest.getEvent().waitEvent(8, TimeUnit.SECONDS);
                    } catch (InterruptedException e) {
                        //TODO
                    } catch (Throwable e) {
                        logger.error("Named-Lock-Request[request lock]发生未知错误", e);
                    }
                }
                return lockRequest.isHold();
            }
            return true;
        }
        return false;
    }

    public void requestUnlock(LockRequest unlockRequest) {
        if(DataUtil.isNotNull(unlockRequest)) {
            this.unlockRequestQueue.offer(unlockRequest);
            this.queueEvent.notifyEvent();

            try {
                unlockRequest.getEvent().resetEvent();
                unlockRequest.getEvent().waitEvent(8, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                //TODO
            } catch (Throwable e) {
                logger.error("Named-Lock-Request[request unlock]发生未知错误", e);
            }
        }
    }
}