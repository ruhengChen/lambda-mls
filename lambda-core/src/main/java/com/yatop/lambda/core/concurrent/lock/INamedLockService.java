package com.yatop.lambda.core.concurrent.lock;

public interface INamedLockService {
    boolean requestResource(Long resourceId);
    void releaseResource();
}
