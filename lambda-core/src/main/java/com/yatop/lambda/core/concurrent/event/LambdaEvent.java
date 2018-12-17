package com.yatop.lambda.core.concurrent.event;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LambdaEvent {
    private Lock lock;
    private Condition condition;
    //通知计数
    private long notifyCount = 0;
    //事件阈值
    private int releaseCount = 1;

    public LambdaEvent() {
        this.lock = new ReentrantLock();
        this.condition = this.lock.newCondition();
    }

    public long notifyEventCount() {
        return this.notifyCount;
    }

    public long releaseEventCount() {
        return this.releaseCount;
    }

    private void lock() {
        this.lock.lock();
    }

    private void unlock() {
        this.lock.unlock();
    }

    public void resetEvent(int releaseCount) {
        if(releaseCount > 0) {
            this.lock();
            this.notifyCount = 0;
            this.releaseCount = releaseCount;
            this.unlock();
        }
    }

    public void resetEvent() {
        this.lock();
        this.notifyCount = 0;
        this.unlock();
    }

    public void waitEvent() throws InterruptedException {
        this.lock();
        while(this.notifyCount < this.releaseCount) {
            try {
                this.condition.await();
            } catch(InterruptedException e) {
                this.unlock();
                throw e;
            } catch (Throwable e) {
            }
        }
        this.notifyCount -= this.releaseCount;
        this.unlock();
    }

    public void waitEvent(long millisecond) throws InterruptedException {
        waitEvent(millisecond, TimeUnit.MILLISECONDS);
    }

    public void waitEvent(long time, TimeUnit unit) throws InterruptedException {
        this.lock();
        if(this.notifyCount >= this.releaseCount) {
            this.notifyCount -= this.releaseCount;
            this.unlock();
            return;
        }

        try {
            this.condition.await(time, TimeUnit.MILLISECONDS);
        } catch(InterruptedException e) {
            this.unlock();
            throw e;
        } catch (Throwable e) {
        }

        if(this.notifyCount >= this.releaseCount) {
            this.notifyCount -= this.releaseCount;
        }
        this.unlock();
    }

    public void notifyEvent() {
        this.lock();
        this.notifyCount++;
        this.condition.signal();
        this.unlock();
    }
}
