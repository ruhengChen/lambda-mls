package com.yatop.lambda.workflow.core.mgr.workflow.snapshot;

import com.yatop.lambda.core.mgr.workflow.snapshot.SnapshotMgr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SnapshotQuery {

    @Autowired
    SnapshotMgr snapshotMgr;

}
