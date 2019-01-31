package com.yatop.lambda.workflow.core.mgr.workflow.snapshot;

import com.yatop.lambda.core.mgr.workflow.snapshot.SnapshotMgr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SnapshotDelete {

    @Autowired
    SnapshotMgr snapshotMgr;

    //TODO 副本快照删除直接调用SnapshotMgr.deleteSnapshot4Copy, 其他类型快照删除暂时不考虑
}
