package com.yatop.lambda.workflow.core.mgr.workflow.node.link;

import com.yatop.lambda.core.enums.WorkflowStateEnum;
import com.yatop.lambda.core.mgr.workflow.node.NodeLinkMgr;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.mgr.workflow.node.NodeQuery;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkDelete {

    @Autowired
    NodeLinkMgr nodeLinkMgr;

    @Autowired
    NodeQuery nodeQuery;

    public void deleteLink(WorkflowContext workflowContext, NodeLink link) {
        nodeLinkMgr.deleteLink(link.getLinkId(), workflowContext.getOperId());
        workflowContext.markDeleted4Link(link);

        workflowContext.getWorkflow().changeWorkflowState2Draft();
    }

    public void deleteLink(WorkflowContext workflowContext, List<NodeLink> links) {
        for(NodeLink link : links)
            deleteLink(workflowContext, link);
    }
}
