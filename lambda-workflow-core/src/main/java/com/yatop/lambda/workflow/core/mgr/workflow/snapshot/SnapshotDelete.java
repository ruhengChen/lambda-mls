package com.yatop.lambda.workflow.core.mgr.workflow.snapshot;

import com.yatop.lambda.core.mgr.workflow.snapshot.SnapshotMgr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SnapshotDelete {

    @Autowired
    SnapshotMgr snapshotMgr;

    //TODO 快照删除暂不考虑，涉及快照关联的资源删除，例如codeScript，jsonObject之类，需要判断当前工作流是否仍然引用这些资源
}
