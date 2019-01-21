package com.yatop.lambda.workflow.core.mgr.workflow.node.link;

import com.yatop.lambda.core.mgr.workflow.node.NodeLinkMgr;
import com.yatop.lambda.core.utils.DataUtil;
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

    public void deleteLinks(WorkflowContext workflowContext, List<NodeLink> links) {
        if(DataUtil.isNotEmpty(links)) {
            for (NodeLink link : links) {
                nodeLinkMgr.deleteLink(link.data().getLinkId(), workflowContext.getOperId());
                workflowContext.doneDeleteLink(link);
            }
        }
    }

    public void deleteAllLinks(WorkflowContext workflowContext) {

        if(workflowContext.linkCount() > 0) {
            nodeLinkMgr.deleteLinkByWorkflowId(workflowContext.getWorkflow().data().getFlowId(), workflowContext.getOperId());
            for(NodeLink link : workflowContext.getLinks()) {
                link.markDeleted();
            }
        }
    }
}
