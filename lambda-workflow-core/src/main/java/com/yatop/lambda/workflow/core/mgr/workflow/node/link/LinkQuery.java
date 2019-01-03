package com.yatop.lambda.workflow.core.mgr.workflow.node.link;

import com.yatop.lambda.base.model.WfFlowNodeLink;
import com.yatop.lambda.core.mgr.workflow.node.NodeLinkMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LinkQuery {

    @Autowired
    NodeLinkMgr nodeLinkMgr;

    public void queryLinks(WorkflowContext workflowContext) {
        List<WfFlowNodeLink> nodeLinks = nodeLinkMgr.queryLink(workflowContext.getWorkflow().getFlowId(), null);
        if(DataUtil.isEmpty(nodeLinks)) {
            return;
        }

        for(WfFlowNodeLink nodeLink : nodeLinks) {
            NodeLink richNodeLink = new NodeLink(nodeLink);
            workflowContext.putLink(richNodeLink);
        }
    }

    public List<NodeLink> queryOutLinks(WorkflowContext workflowContext, Node srcNode) {
        List<WfFlowNodeLink> nodeLinks = nodeLinkMgr.queryLinkBySrcNodeId(srcNode.getNodeId());
        if(DataUtil.isEmpty(nodeLinks)) {
            return null;
        }

        List<NodeLink> outLinks = new ArrayList<NodeLink>(nodeLinks.size());
        for(WfFlowNodeLink nodeLink : nodeLinks) {
            NodeLink richNodeLink = workflowContext.getLink(nodeLink.getLinkId());
            if(DataUtil.isNotNull(richNodeLink)) {
                outLinks.add(richNodeLink);
                continue;
            }

            richNodeLink = new NodeLink(nodeLink);
            workflowContext.putLink(richNodeLink);
            outLinks.add(richNodeLink);
        }
        return outLinks;
    }

    public List<NodeLink> queryInLinks(WorkflowContext workflowContext, Node dstNode) {
        List<WfFlowNodeLink> nodeLinks = nodeLinkMgr.queryLinkByDstNodeId(dstNode.getNodeId());
        if(DataUtil.isEmpty(nodeLinks)) {
            return null;
        }

        List<NodeLink> inLinks = new ArrayList<NodeLink>(nodeLinks.size());
        for(WfFlowNodeLink nodeLink : nodeLinks) {
            NodeLink richNodeLink = workflowContext.getLink(nodeLink.getLinkId());
            if(DataUtil.isNotNull(richNodeLink)) {
                inLinks.add(richNodeLink);
                continue;
            }

            richNodeLink = new NodeLink(nodeLink);
            workflowContext.putLink(richNodeLink);
            inLinks.add(richNodeLink);
        }
        return inLinks;
    }
}
