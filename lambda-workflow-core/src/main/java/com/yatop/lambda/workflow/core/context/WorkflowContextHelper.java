package com.yatop.lambda.workflow.core.context;

import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.mgr.workflow.node.NodeQuery;
import com.yatop.lambda.workflow.core.mgr.workflow.node.link.LinkQuery;
import com.yatop.lambda.workflow.core.mgr.workflow.node.port.NodePortQuery;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeLink;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodePortInput;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodePortOutput;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class WorkflowContextHelper {

    private static NodeQuery NODE_QUERY;
    private static LinkQuery LINK_QUERY;
    private static NodePortQuery NODE_PORT_QUERY;

    @Autowired
    void setNodeQuery(NodeQuery nodeQuery) {
        WorkflowContextHelper.NODE_QUERY = nodeQuery;
    }
    @Autowired
    void setLinkQuery(LinkQuery linkQuery) {
        WorkflowContextHelper.LINK_QUERY = linkQuery;
    }
    @Autowired
    void setNodePortQuery(NodePortQuery nodePortQuery) {
        WorkflowContextHelper.NODE_PORT_QUERY = nodePortQuery;
    }
    

    protected static void loadAllNodes(WorkflowContext workflowContext) {
        if(!workflowContext.isLazyLoadMode()) {
            WorkflowContextHelper.NODE_QUERY.queryNodes(workflowContext);
        }
    }

    protected static void loadOneNode(WorkflowContext workflowContext, Long nodeId) {
        if(workflowContext.isLazyLoadMode()) {
            WorkflowContextHelper.NODE_QUERY.queryNode(workflowContext, nodeId);
        }
    }

    protected static void loadUpstreamNodes(WorkflowContext workflowContext, Node node) {
        if(workflowContext.isLazyLoadMode()) {
            List<NodeLink> nodeLinks = workflowContext.fetchInLinks(node);
            if (DataUtil.isNotEmpty(nodeLinks)) {
                for (NodeLink nodeLink : nodeLinks) {
                    loadOneNode(workflowContext, nodeLink.data().getSrcNodeId());
                }
            }
        }
    }

    protected static void loadDownstreamNodes(WorkflowContext workflowContext, Node node) {
        if(workflowContext.isLazyLoadMode()) {
            List<NodeLink> nodeLinks = workflowContext.fetchOutLinks(node);
            if (DataUtil.isNotEmpty(nodeLinks)) {
                for (NodeLink nodeLink : nodeLinks) {
                    loadOneNode(workflowContext, nodeLink.data().getDstNodeId());
                }
            }
        }
    }

    protected static void loadAllLinks(WorkflowContext workflowContext) {
        if(!workflowContext.isLazyLoadMode()) {
            WorkflowContextHelper.LINK_QUERY.queryLinks(workflowContext);
        }
    }

    protected static void loadOneLink(WorkflowContext workflowContext, Long linkId) {
        if(workflowContext.isLazyLoadMode()) {
            WorkflowContextHelper.LINK_QUERY.queryLink(workflowContext, linkId);
        }
    }

    protected static void loadInLinks(WorkflowContext workflowContext, Long dstNodePortId) {
        if(workflowContext.isLazyLoadMode()) {
            WorkflowContextHelper.LINK_QUERY.queryInLinks(workflowContext, dstNodePortId);
        }
    }

    protected static void loadInLinks(WorkflowContext workflowContext, Node dstNode) {
        if(workflowContext.isLazyLoadMode()) {
            WorkflowContextHelper.LINK_QUERY.queryInLinks(workflowContext, dstNode);
        }
    }

    protected static void loadOutLinks(WorkflowContext workflowContext, Long srcNodePortId) {
        if(workflowContext.isLazyLoadMode()) {
            WorkflowContextHelper.LINK_QUERY.queryOutLinks(workflowContext, srcNodePortId);
        }
    }

    protected static void loadOutLinks(WorkflowContext workflowContext, Node srcNode) {
        if(workflowContext.isLazyLoadMode()) {
            WorkflowContextHelper.LINK_QUERY.queryOutLinks(workflowContext, srcNode);
        }
    }

    protected static void loadInputPort(WorkflowContext workflowContext, Long portId) {
        if(workflowContext.isLazyLoadMode()) {
            WorkflowContextHelper.NODE_PORT_QUERY.queryInputNodePort(workflowContext, portId);
        }
    }

    protected static void loadOutputPort(WorkflowContext workflowContext, Long portId) {
        if(workflowContext.isLazyLoadMode()) {
            WorkflowContextHelper.NODE_PORT_QUERY.queryOutputNodePort(workflowContext, portId);
        }
    }

    protected static void loadUpstreamPorts(WorkflowContext workflowContext, NodePortInput inputNodePort) {
        if(workflowContext.isLazyLoadMode()) {
            List<NodeLink> nodeLinks = workflowContext.fetchInLinks(inputNodePort);
            if(DataUtil.isNotEmpty(nodeLinks)) {
                for(NodeLink nodeLink : nodeLinks) {
                    WorkflowContextHelper.loadOutputPort(workflowContext, nodeLink.data().getSrcPortId());
                }
            }
        }
    }

    protected static void loadDownstreamPorts(WorkflowContext workflowContext, NodePortOutput outputNodePort) {
        if(workflowContext.isLazyLoadMode()) {
            List<NodeLink> nodeLinks = workflowContext.fetchOutLinks(outputNodePort);
            if(DataUtil.isNotEmpty(nodeLinks)) {
                for(NodeLink nodeLink : nodeLinks) {
                    WorkflowContextHelper.loadInputPort(workflowContext, nodeLink.data().getDstPortId());
                }
            }
        }
    }

    protected static void loadUpstreamPorts(WorkflowContext workflowContext, Node node) {
        if(workflowContext.isLazyLoadMode()) {
            List<NodeLink> nodeLinks = workflowContext.fetchInLinks(node);
            if (DataUtil.isNotEmpty(nodeLinks)) {
                for (NodeLink nodeLink : nodeLinks) {
                    loadOutputPort(workflowContext, nodeLink.data().getSrcPortId());
                }
            }
        }
    }

    protected static void loadDownstreamPorts(WorkflowContext workflowContext, Node node) {
        if(workflowContext.isLazyLoadMode()) {
            List<NodeLink> nodeLinks = workflowContext.fetchOutLinks(node);
            if (DataUtil.isNotEmpty(nodeLinks)) {
                for (NodeLink nodeLink : nodeLinks) {
                    loadInputPort(workflowContext, nodeLink.data().getDstPortId());
                }
            }
        }
    }

    public static List<Node> searchHeadNodes(WorkflowContext workflowContext) {
        if(workflowContext.nodeCount() == 0)
            return null;

        List<Node> headNodes = new ArrayList<Node>();
        for(Node node : workflowContext.getNodes()) {
            if(node.isHeadNode()) {
                headNodes.add(node);
            }
        }
        return headNodes;
    }

    public static List<Node> searchReadTableHeadNodes(WorkflowContext workflowContext) {
        if(workflowContext.nodeCount() == 0)
            return null;

        List<Node> headNodes = new ArrayList<Node>();
        for(Node node : workflowContext.getNodes()) {
            if(node.isHeadNode() && node.haveOutputDataTablePort()) {
                headNodes.add(node);
            }
        }
        return headNodes;
    }

    //检测是否存在有向循环图，排除web工作流节点
    public static boolean existDirectedCyclicGraph(WorkflowContext workflowContext) {

        if(workflowContext.nodeCount() == 0)
            return false;

        //initialize node indegree & zero indegree stack
        int totalCount = 0;
        LinkedList<Node> zeroIndegreeStack = new LinkedList<Node>();
        {
            for(Node node : workflowContext.getNodes()) {
                if(node.isWebNode())
                    continue;

                totalCount++;
                if(node.isHeadNode()) {
                    node.setIndegree(0);
                    CollectionUtil.offerLast(zeroIndegreeStack, node);
                    continue;
                }

                List<NodeLink> inLinks = workflowContext.fetchNonWebInLinks(node);
                if(DataUtil.isEmpty(inLinks)) {
                    node.setIndegree(0);
                    CollectionUtil.offerLast(zeroIndegreeStack, node);
                }
                else {
                    node.setIndegree(inLinks.size());
                }
            }
        }

        int zeroCount = 0;
        Node zeroNode = null;
        while(DataUtil.isNotNull(zeroNode = CollectionUtil.pollLast(zeroIndegreeStack))) {
            zeroCount++;

            if(zeroNode.outputNodePortCount() > 0) {
                Map<Long, List<Node>> downstreamNodes = workflowContext.fetchDownstreamNodes(zeroNode);
                if(DataUtil.isNotEmpty(downstreamNodes)) {
                    for (List<Node> chainList : CollectionUtil.toList(downstreamNodes)) {
                        for(Node downstreamNode : chainList) {
                            if(downstreamNode.isWebNode())
                                continue;

                            if(downstreamNode.decreaseIndegree() == 0)
                                CollectionUtil.offerLast(zeroIndegreeStack, downstreamNode);
                        }
                    }
                }
                CollectionUtil.clear(downstreamNodes);
            }
        }

        return zeroCount < totalCount;
    }
}
