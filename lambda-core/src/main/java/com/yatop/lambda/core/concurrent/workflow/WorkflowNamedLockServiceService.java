package com.yatop.lambda.core.concurrent.workflow;

import com.yatop.lambda.core.concurrent.lock.INamedLockService;
import com.yatop.lambda.core.concurrent.daemon.NamedLockDaemon;
import com.yatop.lambda.core.concurrent.lock.BaseNamedLockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkflowNamedLockServiceService extends BaseNamedLockService implements INamedLockService {

    @Autowired
    NamedLockDaemon namedLockDaemon;

    @Override
    protected String namedLockServiceId() {
        return this.getClass().getName();
    }

    @Override
    public boolean requestResource(Long resourceId) {
        return namedLockDaemon.requestLock(super.prepareDoLock(resourceId));
    }

    @Override
    public void releaseResource() {
        namedLockDaemon.requestUnlock(super.prepareDoUnlock());
    }
}
