package com.yatop.lambda.workflow.core.context;

import com.yatop.lambda.core.enums.IsWebLinkEnum;
import com.yatop.lambda.core.enums.JobTypeEnum;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.richmodel.data.table.DataWarehouse;
import com.yatop.lambda.workflow.core.richmodel.data.model.ModelWarehouse;
import com.yatop.lambda.workflow.core.richmodel.workflow.execution.ExecutionJob;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodePortOutput;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;
import com.yatop.lambda.workflow.core.richmodel.project.Project;
import com.yatop.lambda.workflow.core.richmodel.workflow.Workflow;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeLink;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodePortInput;

import java.util.*;

public class WorkflowContext implements IWorkContext {

    /**
     *  工作流、节点、节点参数、节点数据端口schema等信息采用延迟更新，由flush方法发起提交
     * */

    private boolean executionWorkMode;      //标识是否为运行工作模式，否则视为编辑器模式（用于特征CharValue增删改查等事件内部判断用）
    private boolean enableFlushWorkflow;    //控制是否可执行flush更新工作流相关信息
    private boolean loadNodeParameter;      //控制是否查询带出节点参数信息
    private boolean loadDataPortSchema;     //控制是否查询带出数据输出端口schema信息
    private Project project;                //操作关联项目
    private Workflow workflow;              //操作关联工作流
    private ExecutionJob job;
    private TreeMap<Long, DataWarehouse>  dataWarehouses = new TreeMap<Long, DataWarehouse>();   //操作关联数据仓库，key=dwId
    private TreeMap<Long, ModelWarehouse> modelWarehouses = new TreeMap<Long, ModelWarehouse>();  //操作关联模型仓库，key=mwId
    private TreeMap<Long, Node> nodes = new TreeMap<Long, Node>();      //操作关联节点，key=nodeId
    private TreeMap<Long, NodeLink> links = new TreeMap<Long, NodeLink>();  //操作关联节点链接，key=linkId
    private TreeMap<Long, TreeSet<NodeLink>> inputLinks = new TreeMap<Long, TreeSet<NodeLink>>();  //操作关联节点链接，key=dstPortId
    private TreeMap<Long, TreeSet<NodeLink>> outputLinks = new TreeMap<Long, TreeSet<NodeLink>>();  //操作关联节点链接，key=srcPortId
    private TreeMap<Long, NodePortInput> inputPorts = new TreeMap<Long, NodePortInput>();  //操作关联节点输入端口，key=nodePortId
    private TreeMap<Long, NodePortOutput> outputPorts = new TreeMap<Long, NodePortOutput>();  //操作关联节点输出端口，key=nodePortId
  //private TreeMap<Long, GlobalParameter> globalParameters = new TreeMap<Long, GlobalParameter>();  //操作关联节点全局参数，key=globalParameterId
    private String operId;

    private TreeMap<Long, Node> changedNodes = new TreeMap<Long, Node>();      //变更节点（节点创建、节点参数更新），key=nodeId
    private TreeMap<Long, NodeLink> changedLinks = new TreeMap<Long, NodeLink>();  //变更节点链接（节点链接创建），key=linkId

    private TreeMap<Long, Node> deleteNodes = new TreeMap<Long, Node>();      //删除节点，key=nodeId
    private TreeMap<Long, NodeLink> deleteLinks = new TreeMap<Long, NodeLink>();  //删除节点链接，key=linkId

    //工作流编辑用
    public static WorkflowContext BuildWorkflowContext(Project project, Workflow workflow, String operId) {
        WorkflowContext context = new WorkflowContext(project, workflow, operId);
        context.executionWorkMode = false;
        context.enableFlushWorkflow = true;
        context.loadNodeParameter = true;
        context.loadDataPortSchema = true;
        return context;
    }

    //仅查询画布图形信息用
    public static WorkflowContext BuildWorkflowContext4OnlyGraph(Project project, Workflow workflow, String operId) {
        WorkflowContext context = new WorkflowContext(project, workflow, operId);
        context.executionWorkMode = false;
        context.enableFlushWorkflow = false;
        context.loadNodeParameter = false;
        context.loadDataPortSchema = false;
        return context;
    }

    //查询工作流内容构建快照内容和作业内容用
    public static WorkflowContext BuildWorkflowContext4NoSchema(Project project, Workflow workflow, String operId) {
        WorkflowContext context = new WorkflowContext(project, workflow, operId);
        context.executionWorkMode = false;
        context.enableFlushWorkflow = false;
        context.loadNodeParameter = true;
        context.loadDataPortSchema = false;
        return context;
    }

    //快照内容查看用
    public static WorkflowContext BuildWorkflowContext4Snapshot(Project project, Workflow workflow, String operId) {
        WorkflowContext context = new WorkflowContext(project, workflow, operId);
        context.executionWorkMode = false;
        context.enableFlushWorkflow = false;
        context.loadNodeParameter = false;  //WorkflowContextCodec中填入
        context.loadDataPortSchema = false;
        return context;
    }

    //工作流作业内容查看用
    public static WorkflowContext BuildWorkflowContext4Execution(Project project, Workflow workflow, ExecutionJob job, String operId) {
        WorkflowContext context = new WorkflowContext(project, workflow, operId);
        context.job = job;
        context.executionWorkMode = true;
        context.enableFlushWorkflow = JobTypeEnum.enableFlushWorkflow(JobTypeEnum.valueOf(job.getJobType()));
        context.loadNodeParameter = false;  //WorkflowContextCodec中填入
        context.loadDataPortSchema = false;
        return context;
    }

    private WorkflowContext(Project project, Workflow workflow, String operId) {
        this.project = project;
        this.workflow = workflow;
        this.operId = operId;
    }

    public void flush() {
        if(!this.isEnableFlushWorkflow())
            return;

        for (Node node : this.getNodes()) {
            node.flush(this.isLoadNodeParameter(), this.isLoadDataPortSchema(), this.operId);
        }
        this.workflow.flush(this.operId);
    }

    public boolean isExecutionWorkMode() {
        return executionWorkMode;
    }

    public boolean isEnableFlushWorkflow() {
        return enableFlushWorkflow;
    }

    public boolean isLoadNodeParameter() {
        return loadNodeParameter;
    }

    public boolean isLoadDataPortSchema() {
        return loadDataPortSchema;
    }

    public Project getProject() {
        return project;
    }

    public Workflow getWorkflow() {
        return workflow;
    }

    public ExecutionJob getJob() {
        if(executionWorkMode && DataUtil.isNull(job)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Workflow context error -- Execution work mode missing job info.", "工作流上下文错误");
        }
        return job;
    }

    public DataWarehouse getDataWarehouse(Long dataWarehouseId) {
        return dataWarehouses.get(dataWarehouseId);
    }

    public List<DataWarehouse> getDataWarehouses() {
        return CollectionUtil.toList(dataWarehouses);
    }

    public ModelWarehouse getModelWarehouse(Long modelWarehouseId) {
        return modelWarehouses.get(modelWarehouseId);
    }

    public List<ModelWarehouse> getModelWarehouses() {
        return CollectionUtil.toList(modelWarehouses);
    }

    public int nodeCount() {
        return nodes.size() - deleteNodes.size();
    }

    public Node getNode(Long nodeId) {
        return nodes.get(nodeId);
    }

    public List<Node> getNodes() {
        if(nodeCount() > 0) {
            List<Node> nodeList = new ArrayList<Node>(nodeCount());
            for (Map.Entry<Long, Node> entry : nodes.entrySet()) {
                if (!entry.getValue().isDeleted()) {
                    nodeList.add(entry.getValue());
                }
            }
            return nodeList;
        }
        return null;
    }

    public int linkCount() {
        return links.size() - deleteLinks.size();
    }

    public NodeLink getLink(Long linkId) {
        return links.get(linkId);
    }

    public List<NodeLink> getInLinks(Long dstPortId) {
        return CollectionUtil.toList(inputLinks.get(dstPortId));
    }

    public NodeLink getNonWebInLink(Long dstPortId) {
        List<NodeLink> linkList = this.getInLinks(dstPortId);
        if(DataUtil.isNotNull(linkList)) {
            for (NodeLink link : linkList) {
                if (link.getIsWebLink() == IsWebLinkEnum.NO.getMark()) {
                    return link;
                }
            }
        }
        return null;
    }

    public NodeLink getWebInLink(Long dstPortId) {
        List<NodeLink> linkList = this.getInLinks(dstPortId);
        if(DataUtil.isNotNull(linkList)) {
            for (NodeLink link : linkList) {
                if (link.getIsWebLink() == IsWebLinkEnum.YES.getMark()) {
                    return link;
                }
            }
        }
        return null;
    }

    public List<NodeLink> getOutLinks(Long srcPortId) {
        return CollectionUtil.toList(outputLinks.get(srcPortId));
    }

    public List<NodeLink> getLinks() {
        if(linkCount() > 0) {
            List<NodeLink> linkList = new ArrayList<NodeLink>(linkCount());
            for (Map.Entry<Long, NodeLink> entry : links.entrySet()) {
                if (!entry.getValue().isDeleted()) {
                    linkList.add(entry.getValue());
                }
            }
            return linkList;
        }
        return null;
    }

    public NodePortInput getInputPort(Long portId) {
        return inputPorts.get(portId);
    }

    public List<NodePortInput> getInputPorts() {
        return CollectionUtil.toList(inputPorts);
    }

    public NodePortOutput getOutputPort(Long portId) {
        return outputPorts.get(portId);
    }

    public List<NodePortOutput> getOutPorts() {
        return CollectionUtil.toList(outputPorts);
    }

    public void putDataWarehouse(DataWarehouse warehouse) {
        CollectionUtil.put(dataWarehouses, warehouse.getDwId(), warehouse);
    }

    public void putModelWarehouse(ModelWarehouse warehouse) {
        CollectionUtil.put(modelWarehouses, warehouse.getMwId(), warehouse);
    }

    public void putNode(Node node) {
        CollectionUtil.put(nodes, node.getNodeId(), node);
    }

    public void putLink(NodeLink link) {
        CollectionUtil.put(links, link.getLinkId(), link);

        {
            TreeSet<NodeLink> inLinkSet = CollectionUtil.get(inputLinks, link.getLinkId());
            if (DataUtil.isNotNull(inLinkSet))
                CollectionUtil.add(inLinkSet, link);
            else {
                inLinkSet = new TreeSet<NodeLink>();
                CollectionUtil.add(inLinkSet, link);
                CollectionUtil.put(inputLinks, link.getDstPortId(), inLinkSet);
            }
        }

        {
            TreeSet<NodeLink> outLinkSet = CollectionUtil.get(outputLinks, link.getLinkId());
            if (DataUtil.isNotNull(outLinkSet))
                CollectionUtil.add(outLinkSet, link);
            else {
                outLinkSet = new TreeSet<NodeLink>();
                CollectionUtil.add(outLinkSet, link);
                CollectionUtil.put(outputLinks, link.getSrcPortId(), outLinkSet);
            }
        }
    }

    public void putInputPort(NodePortInput inputPort) {
        CollectionUtil.put(inputPorts, inputPort.getNodePortId(), inputPort);
    }

    public void putOutputPort(NodePortOutput outputPort) {
        CollectionUtil.put(outputPorts, outputPort.getNodePortId(), outputPort);
    }

/*    public GlobalParameter getGlobalParameter(Long globalParameterId) {
        return globalParameters.get(globalParameterId);
    }

    public List<GlobalParameter> getGlobalParameters() {
        return CollectionUtil.toList(globalParameters);
    }

    public void putGlobalParameter(GlobalParameter globalParameter) {
        CollectionUtil.put(globalParameters, globalParameter.getGlobalParamId(), globalParameter);

    }*/

    public String getOperId() {
        return operId;
    }

    public void markDeleted4Node(Node node) {
        node.markDeleted();
        deleteNodes.put(node.getNodeId(), node);
    }

    public void markDeleted4Link(NodeLink link) {
        link.markDeleted();
        deleteLinks.put(link.getLinkId(), link);
    }

    public List<Node> getChangedNodes() {
        return CollectionUtil.toList(deleteNodes);
    }

    public List<NodeLink> getChangedLinks() {
        return CollectionUtil.toList(deleteLinks);
    }

    public Node pollChangedNode() {
        return deleteNodes.pollFirstEntry().getValue();
    }

    public NodeLink pollChangedLink() {
        return deleteLinks.pollFirstEntry().getValue();
    }

    public List<Node> getDeletedNodes() {
        return CollectionUtil.toList(deleteNodes);
    }

    public List<NodeLink> getDeletedLinks() {
        return CollectionUtil.toList(deleteLinks);
    }

    public Node pollDeletedNode() {
        return deleteNodes.pollFirstEntry().getValue();
    }

    public NodeLink pollDeletedLink() {
        return deleteLinks.pollFirstEntry().getValue();
    }

    @Override
    public void clear() {
        project.clear();
        workflow.clear();

        CollectionUtil.clear(dataWarehouses);
        CollectionUtil.clear(modelWarehouses);
        CollectionUtil.clear(nodes);
        CollectionUtil.clear(links);
        inputLinks.clear();
        outputLinks.clear();
        inputPorts.clear();
        outputPorts.clear();
      //globalParameters.clear();
        deleteNodes.clear();
        deleteLinks.clear();
    }
}
