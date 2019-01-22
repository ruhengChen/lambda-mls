package com.yatop.lambda.workflow.core.context;

import com.yatop.lambda.core.enums.*;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.mgr.warehouse.DataWarehouseHelper;
import com.yatop.lambda.workflow.core.mgr.warehouse.ModelWarehouseHelper;
import com.yatop.lambda.workflow.core.mgr.workflow.analyzer.SchemaAnalyzer;
import com.yatop.lambda.workflow.core.mgr.workflow.analyzer.SchemaAnalyzerHelper;
import com.yatop.lambda.workflow.core.mgr.workflow.node.port.schema.SchemaHelper;
import com.yatop.lambda.workflow.core.mgr.workflow.snapshot.SnapshotHelper;
import com.yatop.lambda.workflow.core.richmodel.data.table.DataWarehouse;
import com.yatop.lambda.workflow.core.richmodel.data.model.ModelWarehouse;
import com.yatop.lambda.workflow.core.richmodel.experiment.Experiment;
import com.yatop.lambda.workflow.core.richmodel.experiment.ExperimentTemplate;
import com.yatop.lambda.workflow.core.richmodel.workflow.execution.ExecutionJob;
import com.yatop.lambda.workflow.core.richmodel.workflow.execution.ExecutionTask;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.*;
import com.yatop.lambda.workflow.core.richmodel.workflow.snapshot.Snapshot;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;
import com.yatop.lambda.workflow.core.richmodel.project.Project;
import com.yatop.lambda.workflow.core.richmodel.workflow.Workflow;

import java.util.*;

public class WorkflowContext implements IWorkContext {

    private boolean lazyLoadMode;           //标识是否为懒加载模式，否则视为节点和链接的相关信息都已经一次性读取到上下文中
    private boolean executionWorkMode;      //标识是否为运行工作模式
    private boolean enableFlushWorkflow;    //控制是否可执行flush更新工作流相关信息
    private boolean loadNodeParameter;      //控制是否查询带出节点参数信息
    private boolean loadDataPortSchema;     //控制是否查询带出数据输出端口schema信息
    private AnalyzeTypeEnum schemaAnalyze;  //触发的schema分析类型
    private Workflow workflow;              //操作关联工作流
    private TreeMap<Long, Node> nodes = new TreeMap<Long, Node>();      //操作关联节点，key=nodeId
    private TreeMap<Long, NodeLink> links = new TreeMap<Long, NodeLink>();  //操作关联节点链接，key=linkId
    private TreeMap<Long, TreeSet<NodeLink>> inputLinks = new TreeMap<Long, TreeSet<NodeLink>>();  //操作关联节点链接，key=dstPortId
    private TreeMap<Long, TreeSet<NodeLink>> outputLinks = new TreeMap<Long, TreeSet<NodeLink>>();  //操作关联节点链接，key=srcPortId
    private TreeMap<Long, NodePortInput> inputPorts = new TreeMap<Long, NodePortInput>();  //操作关联节点输入端口，key=nodePortId
    private TreeMap<Long, NodePortOutput> outputPorts = new TreeMap<Long, NodePortOutput>();  //操作关联节点输出端口，key=nodePortId
  //private TreeMap<Long, GlobalParameter> globalParameters = new TreeMap<Long, GlobalParameter>();  //操作关联节点全局参数，key=globalParameterId

    private TreeMap<Long, DataWarehouse>  dataWarehouses = new TreeMap<Long, DataWarehouse>();   //操作关联数据仓库，key=dwId
    private TreeMap<String, DataWarehouse> dataWarehousesOrderByCode = new TreeMap<String, DataWarehouse>();   //操作关联数据仓库，key=dwName
    private TreeMap<Long, ModelWarehouse> modelWarehouses = new TreeMap<Long, ModelWarehouse>();  //操作关联模型仓库，key=mwId

    private ExecutionJob currentJob;        //操作关联的当前运行作业
    private TreeMap<Long, ExecutionJob> jobs = new TreeMap<Long, ExecutionJob>();   //操作关联运行作业
    private TreeMap<Long, ExecutionTask> tasks = new TreeMap<Long, ExecutionTask>();    //操作关联运行任务

    private Deque<Node> analyzeNodes = new LinkedList<Node>();      //待分析节点，key=nodeId
    private Deque<NodeLink> analyzeLinks = new LinkedList<NodeLink>();  //待分析节点链接，key=linkId
    private String operId;

    //工作流新建使用（无需加载）
    public static WorkflowContext BuildWorkflowContext4Create(Experiment experiment, String operId) {
        WorkflowContext context = new WorkflowContext(experiment.getWorkflow(), operId);
        context.initialize(false);
        return context;
    }

    //工作流编辑使用（创建节点、删除节点和删除链接，增量加载）
    public static WorkflowContext BuildWorkflowContext4Edit(Experiment experiment, String operId) {
        WorkflowContext context = new WorkflowContext(experiment.getWorkflow(), operId);
        context.lazyLoadMode = true;
        context.initialize(false);
        return context;
    }

    //工作流编辑使用（创建链接、更新节点参数，全量预加载）
    public static WorkflowContext BuildWorkflowContext4EditPreload(Experiment experiment, String operId) {
        WorkflowContext context = new WorkflowContext(experiment.getWorkflow(), operId);
        context.initialize(true);
        return context;
    }

    //工作流编辑使用（验证链接，增量加载）
    public static WorkflowContext BuildWorkflowContext4EditValidateLink(Experiment experiment, String operId) {
        WorkflowContext context = new WorkflowContext(experiment.getWorkflow(), operId);
        context.lazyLoadMode = true;
        context.enableFlushWorkflow = false;
        context.loadNodeParameter = false;
        context.loadDataPortSchema = false;
        context.initialize(false);
        return context;
    }

    //工作流查询使用，用于实验图形查询（全量预加载）
    public static WorkflowContext BuildWorkflowContext4OnlyGraph(Experiment experiment, String operId) {
        WorkflowContext context = new WorkflowContext(experiment.getWorkflow(), operId);
        context.enableFlushWorkflow = false;
        context.loadNodeParameter = false;
        context.loadDataPortSchema = false;
        context.initialize(true);
        return context;
    }

    //工作流查询使用，用于实验删除、实验刷新、实验复制、构建快照、构建作业等场景使用（全量预加载）
    public static WorkflowContext BuildWorkflowContext4FullContent(Experiment experiment, String operId) {
        WorkflowContext context = new WorkflowContext(experiment.getWorkflow(), operId);
        context.initialize(true);
        return context;
    }

    //实验模版查看使用
    public static WorkflowContext BuildWorkflowContext4ViewTemplate(ExperimentTemplate template, String operId) {
        return BuildWorkflowContext4Snapshot(SnapshotHelper.simulateSnapshot4Template(template), operId);
    }

    //快照查看使用
    public static WorkflowContext BuildWorkflowContext4ViewSnapshot(Long snapshotId, String operId) {
        return BuildWorkflowContext4Snapshot(SnapshotHelper.querySnapshot4View(snapshotId), operId);
    }

    private static WorkflowContext BuildWorkflowContext4Snapshot(Snapshot snapshot, String operId) {
        WorkflowContext context = new WorkflowContext(snapshot.getWorkflow(), operId);
        context.initialize(snapshot);
        return context;
    }

    //作业查看使用（作业任务运行、作业运行查看）
    public static WorkflowContext BuildWorkflowContext4Execution(ExecutionJob currentJob, String operId) {
        WorkflowContext context = BuildWorkflowContext4Snapshot(currentJob.getSnapshot(), operId);
        context.initialize(currentJob);
        return context;
    }

    private WorkflowContext(Workflow workflow, String operId) {
        this.workflow = workflow;
        this.operId = operId;
        this.schemaAnalyze = AnalyzeTypeEnum.NONE;

        this.lazyLoadMode = false;
        this.executionWorkMode = false;
        this.enableFlushWorkflow = true;
        this.loadNodeParameter = true;
        this.loadDataPortSchema = true;
    }

    private void initialize(boolean preload) {
        if(preload) {
            WorkflowContextHelper.loadAllNodes(this);
            WorkflowContextHelper.loadAllLinks(this);

            //if(WorkflowContextHelper.existDirectedCyclicGraph(this)) {
            //    throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Workflow context error -- Workflow exists directed cyclic graph.", "工作流数据异常，请联系管理员");
            //}
        }
    }

    private void initialize(Snapshot snapshot) {
        this.enableFlushWorkflow = false;
        this.loadNodeParameter = false;
        this.loadDataPortSchema = false;
        snapshot.syncSnapshot2WorkflowContext(this);
    }

    private void initialize(ExecutionJob currentJob) {
        this.executionWorkMode = !currentJob.isViewMode();
        this.enableFlushWorkflow = currentJob.enableFlushWorkflow();
        this.currentJob = currentJob;
        this.putExecutionJob(currentJob);

        if(!currentJob.enableFlushSnapshot()) {
            //TODO Clear [workflow & Node]'s execution information by job type

            //TODO loadAllTasks and set [workflow state & last job id] & [node state & last task id]
        }
    }

    @Override
    public void clear() {
        workflow = null;
        operId = null;
        CollectionUtil.enhancedClear(nodes);
        CollectionUtil.enhancedClear(links);
        CollectionUtil.clear(inputLinks);
        CollectionUtil.clear(outputLinks);
        CollectionUtil.clear(inputPorts);
        CollectionUtil.clear(outputPorts);
        //CollectionUtil.clear(globalParameters);

        CollectionUtil.enhancedClear(dataWarehouses);
        CollectionUtil.clear(dataWarehousesOrderByCode);
        CollectionUtil.enhancedClear(modelWarehouses);

        if(DataUtil.isNotNull(currentJob)) {
            currentJob.clear();
            currentJob = null;
        }

        CollectionUtil.enhancedClear(jobs);
        CollectionUtil.enhancedClear(tasks);

        CollectionUtil.clear(analyzeNodes);
        CollectionUtil.clear(analyzeLinks);
    }

    public void flush() {

        if(this.isEnableFlushWorkflow() && this.workflow.data().getFlowId() > 0) {

            if (loadNodeParameter && loadDataPortSchema) {
                SchemaAnalyzer.dealAnalyzeSchema(this);
            }

            if (this.nodeCount() > 0) {
                for (Node node : this.getNodes()) {
                    node.flush(this.isLoadNodeParameter(), this.isLoadDataPortSchema(), this.getOperId());
                }
            }
            this.workflow.flush(this.getOperId());
        }

        if(this.isExecutionWorkMode()) {
            if(tasks.size() > 0) {
                for(ExecutionTask task : CollectionUtil.toList(tasks)) {
                    task.flush(this.getOperId());
                }
            }
            this.getCurrentJob().flush(this);
        }
    }

    /*
     *
     * Editor Transaction Done Section
     *
     */

    public void doneCreateNode(Node node) {
        node.downgradeState2Ready();
        this.putNode(node);
        this.workflow.changeState2Draft();
        this.markAnalyzeWithCreateNode(node);
    }

    public void doneCreateLink(NodeLink link) {
        this.putLink(link);
        this.workflow.changeState2Draft();
        this.markAnalyzeWithCreateLink(link);
    }

    public void doneUpdateNodeParameter(Node node, NodeParameter parameter) {
        node.downgradeState2Ready();
        this.workflow.changeState2Draft();
        if(parameter.getCmptChar().data().getSpecType() == SpecTypeEnum.PARAMETER.getType())
            this.markAnalyzeWithUpdateNodeParameter(node, parameter);
    }

    public void doneDeleteNode(Node node) {
        node.markDeleted();
        this.workflow.changeState2Draft();
        this.markAnalyzeWithDeleteNode(node);
    }

    public void doneRecoverNode(Node node) {
        this.doneCreateNode(node);
    }

    public void doneDeleteLink(NodeLink link) {
        link.markDeleted();
        this.workflow.changeState2Draft();
        this.markAnalyzeWithDeleteLink(link);
    }

    /*
     *
     * Schema Analyze Section
     *
     */

    public AnalyzeTypeEnum getAnalyzeType() {
        return schemaAnalyze;
    }

    public boolean isAnalyzeWithNone() {
        return this.schemaAnalyze.getType() == AnalyzeTypeEnum.NONE.getType();
    }

    public boolean isAnalyzeWithCreateNode() {
        return this.schemaAnalyze.getType() == AnalyzeTypeEnum.CREATE_NODE.getType();
    }

    public boolean isAnalyzeWithCreateLink() {
        return this.schemaAnalyze.getType() == AnalyzeTypeEnum.CREATE_LINK.getType();
    }

    public boolean isAnalyzeWithUpdateNodeParameter() {
        return this.schemaAnalyze.getType() == AnalyzeTypeEnum.UPDATE_NODE_PARAMETER.getType();
    }

    public boolean isAnalyzeWithDeleteNode() {
        return this.schemaAnalyze.getType() == AnalyzeTypeEnum.DELETE_NODE.getType();
    }

    public boolean isAnalyzeWithDeleteLink() {
        return this.schemaAnalyze.getType() == AnalyzeTypeEnum.DELETE_LINK.getType();
    }

    public boolean isAnalyzeWithRefreshSchema() {
        return this.schemaAnalyze.getType() == AnalyzeTypeEnum.REFRESH_SCHEMA.getType();
    }

    private void markAnalyzeWithCreateNode(Node node) {
        //TODO 对于异常情况是否抛出错误
        if(this.isAnalyzeWithNone() || this.isAnalyzeWithCreateNode()) {
            if(SchemaAnalyzerHelper.needAnalyzeNode(node)) {
                this.schemaAnalyze = AnalyzeTypeEnum.CREATE_NODE;
                this.pushAnalyzeNode(node);
            }
        }
    }

    private void markAnalyzeWithCreateLink(NodeLink link) {
        //TODO 对于异常情况是否抛出错误
        if(this.isAnalyzeWithNone()) {
            if(!link.isWebLink()) {
                this.schemaAnalyze = AnalyzeTypeEnum.CREATE_LINK;
                this.pushAnalyzeLink(link);
            }
        }
    }

    private void markAnalyzeWithUpdateNodeParameter(Node node, NodeParameter parameter) {
        //TODO 对于异常情况是否抛出错误
        if(this.isAnalyzeWithNone()) {
            if(SchemaAnalyzerHelper.needAnalyzeNode(node, parameter)) {
                this.schemaAnalyze = AnalyzeTypeEnum.UPDATE_NODE_PARAMETER;
                this.pushAnalyzeNode(node);
            }
        }
    }

    private void markAnalyzeWithDeleteNode(Node node) {
        //TODO 对于异常情况是否抛出错误
        if(this.isAnalyzeWithNone() || this.isAnalyzeWithDeleteNode() || this.isAnalyzeWithDeleteLink()) {
            if(SchemaAnalyzerHelper.needAnalyzeNode(node)) {
                this.schemaAnalyze = AnalyzeTypeEnum.DELETE_NODE;
                this.pushAnalyzeNode(node);
            }
        }
    }

    private void markAnalyzeWithDeleteLink(NodeLink link) {
        //TODO 对于异常情况是否抛出错误
        if(this.isAnalyzeWithNone() || this.isAnalyzeWithDeleteLink()) {
            if(!link.isWebLink()) {
                this.schemaAnalyze = AnalyzeTypeEnum.DELETE_LINK;
                this.pushAnalyzeLink(link);
            }
        }
    }

    public void markAnalyzeWithRefreshSchema() {
        //TODO 对于异常情况是否抛出错误
        if(this.isAnalyzeWithNone())
            this.schemaAnalyze = AnalyzeTypeEnum.REFRESH_SCHEMA;
    }

    /*
     *
     * Common Section
     *
     */

    public boolean isLazyLoadMode() {
        return lazyLoadMode;
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
        return getWorkflow().getProject();
    }

    public Experiment getExperiment() {
        return getWorkflow().getExperiment();
    }

    public Workflow getWorkflow() {
        return workflow;
    }

    public DataWarehouse getDataWarehouse() {
        return getDataWarehouse(getProject().data().getDwId());
    }

    public ModelWarehouse getModelWarehouse() {
        return getModelWarehouse(getProject().data().getMwId());
    }

    public DataWarehouse getDataWarehouse(Long dataWarehouseId) {
        DataWarehouse dataWarehouse = CollectionUtil.get(dataWarehouses, dataWarehouseId);
        if(DataUtil.isNull(dataWarehouse)) {
            dataWarehouse = DataWarehouseHelper.queryDataWarehouse(dataWarehouseId);
            this.putDataWarehouse(dataWarehouse);
        }
        return dataWarehouse;
    }

    public DataWarehouse getDataWarehouse(String dataWarehouseCode) {
        DataWarehouse dataWarehouse = CollectionUtil.get(dataWarehousesOrderByCode, dataWarehouseCode);
        if(DataUtil.isNull(dataWarehouse)) {
            dataWarehouse = DataWarehouseHelper.queryDataWarehouse(dataWarehouseCode);
            this.putDataWarehouse(dataWarehouse);
        }
        return dataWarehouse;
    }

    public List<DataWarehouse> getDataWarehouses() {
        return CollectionUtil.toList(dataWarehouses);
    }

    public ModelWarehouse getModelWarehouse(Long modelWarehouseId) {
        ModelWarehouse modelWarehouse = CollectionUtil.get(modelWarehouses, modelWarehouseId);
        if(DataUtil.isNull(modelWarehouse)) {
            modelWarehouse = ModelWarehouseHelper.queryModelWarehouse(modelWarehouseId);
            this.putModelWarehouse(modelWarehouse);
        }
        return modelWarehouse;
    }

    public List<ModelWarehouse> getModelWarehouses() {
        return CollectionUtil.toList(modelWarehouses);
    }

    public ExecutionJob getCurrentJob() {
        if(DataUtil.isNull(currentJob)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Workflow context error -- Missing current execution job.", "系统内部发生错误，请联系管理员");
        }

        return currentJob;
    }

    public ExecutionJob getExecutionJob(Long jobId) {
        ExecutionJob job = CollectionUtil.get(jobs, jobId);
        if(DataUtil.isNull(job)) {
            //TODO query job
            //job = xxx
            this.putExecutionJob(job);
        }
        return job;
    }

    public ExecutionJob getExecutionJob(ExecutionTask task) {
        return getExecutionJob(task.data().getOwnerJobId());
    }

    public ExecutionTask getExecutionTask(Node node) {
        if(DataUtil.isNull(node.data().getLastTaskId()))
            return null;

        ExecutionTask task = CollectionUtil.get(tasks, node.data().getLastTaskId());
        if(DataUtil.isNull(task)) {
            //TODO query task
            //task = xxx
            this.putExecutionTask(task);
        }
        return task;
    }

    public String getOperId() {
        return operId;
    }

    /*
    *
    * Node Section
    *
    */

    public int nodeCount() {
        return nodes.size();
    }

    public List<Node> getNodes() {
        return CollectionUtil.toList(nodes);
    }

    public Node getNode(Long nodeId) {
        return CollectionUtil.get(nodes, nodeId);
    }

    public Node getUpstreamNode(NodeLink nodeLink) {
        return getNode(nodeLink.data().getSrcNodeId());
    }

    public Node getDownstreamNode(NodeLink nodeLink) {
        return getNode(nodeLink.data().getDstNodeId());
    }

    //key:inputNodePortId
    public TreeMap<Long, List<Node>> getUpstreamNodes(Node node) {
        if(node.isHeadNode())
            return null;

        List<NodeLink> inLinks = this.getInLinks(node);
        if(DataUtil.isNotEmpty(inLinks)) {
            TreeMap<Long, List<Node>> upstreamNodes = new TreeMap<Long, List<Node>>();
            for(NodeLink nodeLink : inLinks) {
                Node upstreamNode = this.getUpstreamNode(nodeLink);
                CollectionUtil.put4ChainMap(upstreamNodes, nodeLink.data().getDstPortId(), upstreamNode);
            }
            return upstreamNodes;
        }
        return null;
    }

    //key:outputNodePortId
    public TreeMap<Long, List<Node>> getDownstreamNodes(Node node) {
        if(node.isTailNode())
            return null;

        List<NodeLink> outLinks = this.getOutLinks(node);
        if(DataUtil.isNotEmpty(outLinks)) {
            TreeMap<Long, List<Node>> downstreamNodes = new TreeMap<Long, List<Node>>();
            for(NodeLink nodeLink : outLinks) {
                Node downstreamNode = this.getDownstreamNode(nodeLink);
                CollectionUtil.put4ChainMap(downstreamNodes, nodeLink.data().getSrcPortId(), downstreamNode);
            }
            return downstreamNodes;
        }
        return null;
    }

    public Node fetchNode(Long nodeId) {
        WorkflowContextHelper.loadOneNode(this, nodeId);
        return getNode(nodeId);
    }

    public Node fetchUpstreamNode(NodeLink nodeLink) {
        return fetchNode(nodeLink.data().getSrcNodeId());
    }

    public Node fetchDownstreamNode(NodeLink nodeLink) {
        return fetchNode(nodeLink.data().getDstNodeId());
    }

    //key:inputNodePortId
    public TreeMap<Long, List<Node>> fetchUpstreamNodes(Node node) {
        WorkflowContextHelper.loadUpstreamNodes(this, node);
        return getUpstreamNodes(node);
    }

    //key:outputNodePortId
    public TreeMap<Long, List<Node>> fetchDownstreamNodes(Node node) {
        WorkflowContextHelper.loadDownstreamNodes(this, node);
        return getDownstreamNodes(node);
    }

    //key:inputNodePortId
    public TreeMap<Long, Node> fetchNonWebUpstreamNodes(Node node) {
        List<NodeLink> inLinks = this.fetchNonWebInLinks(node);
        if(DataUtil.isNotEmpty(inLinks)) {
            TreeMap<Long, Node> upstreamNodes = new TreeMap<Long, Node>();
            for(NodeLink nodeLink : inLinks) {
                Node upstreamNode = this.fetchUpstreamNode(nodeLink);
                upstreamNodes.put(nodeLink.data().getDstPortId(), upstreamNode);
            }
            return upstreamNodes;
        }
        return null;
    }

    public List<Node> fetchDownstreamNodes(NodePortOutput outputNodePort) {
        List<NodeLink> outLinks = this.fetchOutLinks(outputNodePort);
        if(DataUtil.isNotEmpty(outLinks)) {
            List<Node> downstreamNodes = new LinkedList<Node>();
            for(NodeLink nodeLink : outLinks) {
                CollectionUtil.add(downstreamNodes, this.fetchDownstreamNode(nodeLink));
            }
            return downstreamNodes;
        }
        return null;
    }

    /*
     *
     * Link Section
     *
     */

    public int linkCount() {
        return links.size();
    }

    public List<NodeLink> getLinks() {
        return CollectionUtil.toList(links);
    }

    public NodeLink getLink(Long linkId) {
        return CollectionUtil.get(links, linkId);
    }

    public List<NodeLink> getInLinks(Long dstPortId) {
        return CollectionUtil.toList(CollectionUtil.get(inputLinks, dstPortId));
    }

    public List<NodeLink> getInLinks(NodePortInput inputNodePort) {
        return this.getInLinks(inputNodePort.data().getNodePortId());
    }

    public List<NodeLink> getInLinks(Node node) {
        if(!node.isHeadNode()) {
            List<NodeLink> inLinks = new ArrayList<NodeLink>();
            for (NodePortInput inputNodePort : node.getInputNodePorts()) {
                List<NodeLink> nodeLinks = this.getInLinks(inputNodePort);
                if(DataUtil.isNotEmpty(nodeLinks)) {
                    for(NodeLink nodeLink : nodeLinks)
                        inLinks.add(nodeLink);
                }
            }
            return DataUtil.isNotEmpty(inLinks) ? inLinks : null;
        }
        return null;
    }

    private NodeLink filterPortInLinks4Port(List<NodeLink> nodeLinks, IsWebLinkEnum linkFilter) {
        if(DataUtil.isNotEmpty(nodeLinks)) {
            for (NodeLink nodeLink : nodeLinks) {
                if (nodeLink.data().getIsWebLink() == linkFilter.getMark())
                    return nodeLink;
            }
        }
        return null;
    }

    private List<NodeLink> filterPortInLinks4Node(List<NodeLink> nodeLinks, IsWebLinkEnum linkFilter) {
        if(DataUtil.isNotEmpty(nodeLinks)) {
            List<NodeLink> inLinks = new ArrayList<NodeLink>();
            for (NodeLink nodeLink : nodeLinks) {
                if (nodeLink.data().getIsWebLink() == linkFilter.getMark())
                    CollectionUtil.add(inLinks, nodeLink);
            }
            return inLinks;
        }
        return null;
    }

    public NodeLink getNonWebInLink(Long dstPortId) {
        List<NodeLink> nodeLinks = this.getInLinks(dstPortId);
        return filterPortInLinks4Port(nodeLinks, IsWebLinkEnum.NO);
    }

    public NodeLink getWebInLink(Long dstPortId) {
        List<NodeLink> nodeLinks = this.getInLinks(dstPortId);
        return filterPortInLinks4Port(nodeLinks, IsWebLinkEnum.YES);
    }

    public List<NodeLink> getNonWebInLinks(Node node) {
        List<NodeLink> nodeLinks = this.getInLinks(node);
        return filterPortInLinks4Node(nodeLinks, IsWebLinkEnum.NO);
    }

    public List<NodeLink> getOutLinks(Long srcPortId) {
        return CollectionUtil.toList(outputLinks.get(srcPortId));
    }

    public List<NodeLink> getOutLinks(NodePortOutput outputNodePort) {
        return this.getOutLinks(outputNodePort.data().getNodePortId());
    }

    public List<NodeLink> getOutLinks(Node node) {
        if(!node.isTailNode()) {
            List<NodeLink> outLinks = new ArrayList<NodeLink>();
            for (NodePortOutput outputNodePort : node.getOutputNodePorts()) {
                List<NodeLink> nodeLinks = this.getOutLinks(outputNodePort);
                if(DataUtil.isNotEmpty(nodeLinks)) {
                    for(NodeLink nodeLink : nodeLinks)
                        outLinks.add(nodeLink);
                }
            }
            return DataUtil.isNotEmpty(outLinks) ? outLinks : null;
        }
        return null;
    }

    public NodeLink fetchLink(Long linkId) {
        WorkflowContextHelper.loadOneLink(this, linkId);
        return getLink(linkId);
    }

    public List<NodeLink> fetchInLinks(Long dstPortId) {
        WorkflowContextHelper.loadInLinks(this, dstPortId);
        return getInLinks(dstPortId);
    }

    public List<NodeLink> fetchInLinks(NodePortInput inputNodePort) {
        return this.fetchInLinks(inputNodePort.data().getNodePortId());
    }

    public List<NodeLink> fetchInLinks(Node node) {
        WorkflowContextHelper.loadInLinks(this, node);
        return this.getInLinks(node);
    }

    public NodeLink fetchNonWebInLink(Long dstPortId) {
        WorkflowContextHelper.loadInLinks(this, dstPortId);
        return getNonWebInLink(dstPortId);
    }

    public NodeLink fetchWebInLink(Long dstPortId) {
        WorkflowContextHelper.loadInLinks(this, dstPortId);
        return getWebInLink(dstPortId);
    }

    public List<NodeLink> fetchNonWebInLinks(Node node) {
        WorkflowContextHelper.loadInLinks(this, node);
        return getNonWebInLinks(node);
    }

    public List<NodeLink> fetchOutLinks(Long srcPortId) {
        WorkflowContextHelper.loadOutLinks(this, srcPortId);
        return getOutLinks(srcPortId);
    }

    public List<NodeLink> fetchOutLinks(NodePortOutput outputNodePort) {
        return this.fetchOutLinks(outputNodePort.data().getNodePortId());
    }

    public List<NodeLink> fetchOutLinks(Node node) {
        WorkflowContextHelper.loadOutLinks(this, node);
        return this.getOutLinks(node);
    }

    /*
     *
     * Node Port Section
     *
     */

    public NodePortInput getInputPort(Long portId) {
        return CollectionUtil.get(inputPorts, portId);
    }

    public NodePortOutput getOutputPort(Long portId) {
        return CollectionUtil.get(outputPorts, portId);
    }

    public NodePortOutput getUpstreamPort(NodeLink nodeLink) {
        return this.getOutputPort(nodeLink.data().getSrcPortId());
    }

    public NodePortInput getDownstreamPort(NodeLink nodeLink) {
        return this.getInputPort(nodeLink.data().getDstPortId());
    }

    public List<NodePortOutput> getUpstreamPorts(NodePortInput inputNodePort) {
        List<NodeLink> nodeLinks = this.getInLinks(inputNodePort.data().getNodePortId());
        if(DataUtil.isNotEmpty(nodeLinks)) {
            List<NodePortOutput> outputPorts = new ArrayList<NodePortOutput>(nodeLinks.size());
            for(NodeLink nodeLink : nodeLinks) {
                NodePortOutput outputNodePort = this.getOutputPort(nodeLink.data().getSrcPortId());
                outputPorts.add(outputNodePort);
            }
            return outputPorts;
        }
        return null;
    }

    public List<NodePortInput> getDownstreamPorts(NodePortOutput outputNodePort) {
        List<NodeLink> nodeLinks = this.getOutLinks(outputNodePort.data().getNodePortId());
        if(DataUtil.isNotEmpty(nodeLinks)) {
            List<NodePortInput> inputPorts = new ArrayList<NodePortInput>(nodeLinks.size());
            for(NodeLink nodeLink : nodeLinks) {
                NodePortInput inputNodePort = this.getInputPort(nodeLink.data().getDstPortId());
                inputPorts.add(inputNodePort);
            }
            return inputPorts;
        }
        return null;
    }

    //key:inputNodePortId
    public TreeMap<Long, List<NodePortOutput>> getUpstreamPorts(Node node) {
        if(node.isHeadNode())
            return null;

        List<NodeLink> inLinks = this.getInLinks(node);
        if(DataUtil.isNotEmpty(inLinks)) {
            TreeMap<Long, List<NodePortOutput>> upstreamPorts = new TreeMap<Long, List<NodePortOutput>>();
            for(NodeLink nodeLink : inLinks) {
                NodePortOutput upstreamPort = this.getUpstreamPort(nodeLink);
                CollectionUtil.put4ChainMap(upstreamPorts, nodeLink.data().getDstPortId(), upstreamPort);
            }
            return upstreamPorts;
        }
        return null;
    }

    //key:outputNodePortId
    public TreeMap<Long, List<NodePortInput>> getDownstreamPorts(Node node) {
        if(node.isTailNode())
            return null;

        List<NodeLink> outLinks = this.getOutLinks(node);
        if(DataUtil.isNotEmpty(outLinks)) {
            TreeMap<Long, List<NodePortInput>> downstreamPorts = new TreeMap<Long, List<NodePortInput>>();
            for(NodeLink nodeLink : outLinks) {
                NodePortInput downstreamPort = this.getDownstreamPort(nodeLink);
                CollectionUtil.put4ChainMap(downstreamPorts, nodeLink.data().getSrcPortId(), downstreamPort);
            }
            return downstreamPorts;
        }
        return null;
    }

    public NodePortInput fetchInputPort(Long portId) {
        WorkflowContextHelper.loadInputPort(this, portId);
        return this.getInputPort(portId);
    }

    public NodePortOutput fetchOutputPort(Long portId) {
        WorkflowContextHelper.loadOutputPort(this, portId);
        return this.getOutputPort(portId);
    }

    public NodePortOutput fetchUpstreamPort(NodeLink nodeLink) {
        return this.fetchOutputPort(nodeLink.data().getSrcPortId());
    }

    public NodePortInput fetchDownstreamPort(NodeLink nodeLink) {
        return this.fetchInputPort(nodeLink.data().getDstPortId());
    }

    public List<NodePortOutput> fetchUpstreamPorts(NodePortInput inputNodePort) {
        WorkflowContextHelper.loadUpstreamPorts(this, inputNodePort);
        return this.getUpstreamPorts(inputNodePort);
    }

    public List<NodePortInput> fetchDownstreamPorts(NodePortOutput outputNodePort) {
        WorkflowContextHelper.loadDownstreamPorts(this, outputNodePort);
        return this.getDownstreamPorts(outputNodePort);
    }

    public TreeMap<Long, List<NodePortOutput>> fetchUpstreamPorts(Node node) {
        WorkflowContextHelper.loadUpstreamPorts(this, node);
        return this.getUpstreamPorts(node);
    }

    public TreeMap<Long, List<NodePortInput>> fetchDownstreamPorts(Node node) {
        WorkflowContextHelper.loadDownstreamPorts(this, node);
        return this.getDownstreamPorts(node);
    }

    //key:inputNodePortId
    public TreeMap<Long, NodePortOutput> fetchNonWebUpstreamPorts(Node node) {
        List<NodeLink> inLinks = this.fetchNonWebInLinks(node);
        if(DataUtil.isNotEmpty(inLinks)) {
            TreeMap<Long, NodePortOutput> upstreamPorts = new TreeMap<Long, NodePortOutput>();
            for(NodeLink nodeLink : inLinks) {
                NodePortOutput upstreamPort = this.fetchUpstreamPort(nodeLink);
                upstreamPorts.put(nodeLink.data().getDstPortId(), upstreamPort);
            }
            return upstreamPorts;
        }
        return null;
    }

    /*
     *
     * Put Data Warehouse, Model Warehouse, Job, Task, Node, Link, Node Port, etc. Section
     *
     */

    public void putDataWarehouse(DataWarehouse warehouse) {
        CollectionUtil.put(dataWarehouses, warehouse.data().getDwId(), warehouse);
        CollectionUtil.put(dataWarehousesOrderByCode, warehouse.data().getDwName(), warehouse);
    }

    public void putModelWarehouse(ModelWarehouse warehouse) {
        CollectionUtil.put(modelWarehouses, warehouse.data().getMwId(), warehouse);
    }

    public void putExecutionJob(ExecutionJob job) {
        CollectionUtil.put(jobs, job.data().getJobId(), job);
    }

    public void putExecutionTask(ExecutionTask task) {
        CollectionUtil.put(tasks, task.data().getTaskId(), task);
    }

    public void putNode(Node node) {
        CollectionUtil.put(nodes, node.data().getNodeId(), node);
    }

    public void putLink(NodeLink link) {
        CollectionUtil.put(links, link.data().getLinkId(), link);

        {
            TreeSet<NodeLink> inLinkSet = CollectionUtil.get(inputLinks, link.data().getLinkId());
            if (DataUtil.isNotNull(inLinkSet))
                CollectionUtil.add(inLinkSet, link);
            else {
                inLinkSet = new TreeSet<NodeLink>();
                CollectionUtil.add(inLinkSet, link);
                CollectionUtil.put(inputLinks, link.data().getDstPortId(), inLinkSet);
            }
        }

        {
            TreeSet<NodeLink> outLinkSet = CollectionUtil.get(outputLinks, link.data().getLinkId());
            if (DataUtil.isNotNull(outLinkSet))
                CollectionUtil.add(outLinkSet, link);
            else {
                outLinkSet = new TreeSet<NodeLink>();
                CollectionUtil.add(outLinkSet, link);
                CollectionUtil.put(outputLinks, link.data().getSrcPortId(), outLinkSet);
            }
        }
    }

    public void putInputPort(NodePortInput inputPort) {
        CollectionUtil.put(inputPorts, inputPort.data().getNodePortId(), inputPort);
    }

    public void putOutputPort(NodePortOutput outputPort) {
        CollectionUtil.put(outputPorts, outputPort.data().getNodePortId(), outputPort);
    }

/*    public GlobalParameter getGlobalParameter(Long globalParameterId) {
        return globalParameters.get(globalParameterId);
    }

    public List<GlobalParameter> getGlobalParameters() {
        return CollectionUtil.toList(globalParameters);
    }

    public void putGlobalParameter(GlobalParameter globalParameter) {
        CollectionUtil.put(globalParameters, globalParameter.data().getGlobalParamId(), globalParameter);

    }
*/

    /*
     *
     * Other Section
     *
     */

/*    public int analyzeNodeCount() {
        return analyzeNodes.size();
    }

    public int analyzeLinkCount() {
        return analyzeLinks.size();
    }*/

    public void pushAnalyzeNode(Node node) {
        CollectionUtil.offerLast(analyzeNodes, node);
    }

    public void pushAnalyzeLink(NodeLink link) {
        CollectionUtil.offerLast(analyzeLinks, link);
    }

    public Node popAnalyzeNode() {
        return CollectionUtil.pollLast(analyzeNodes);
    }

    public NodeLink popAnalyzeLink() {
        return CollectionUtil.pollLast(analyzeLinks);
    }

/*    public void clearAnalyzeNodes() {
        CollectionUtil.clear(analyzeNodes);
    }

    public void clearAnalyzeLinks() {
        CollectionUtil.clear(analyzeLinks);
    }*/

/*    public void eraseNode(Node node) {

        for(NodePortInput inputNodePort : node.getInputNodePorts()) {
            List<NodeLink> nodeLinks = this.getInLinks(inputNodePort.data().getNodePortId());
            if(DataUtil.isNotEmpty(nodeLinks)) {
                for(NodeLink link : nodeLinks)
                    CollectionUtil.remove(links, link.data().getLinkId());
                CollectionUtil.remove(inputLinks, inputNodePort.data().getNodePortId());
            }
            CollectionUtil.remove(inputPorts, inputNodePort.data().getNodePortId());
        }

        for(NodePortOutput outputNodePort : node.getOutputNodePorts()) {
            List<NodeLink> nodeLinks = this.getOutLinks(outputNodePort.data().getNodePortId());
            if(DataUtil.isNotEmpty(nodeLinks)) {
                for(NodeLink link : nodeLinks)
                    CollectionUtil.remove(links, link.data().getLinkId());
                CollectionUtil.remove(outputLinks, outputNodePort.data().getNodePortId());
            }
            CollectionUtil.remove(outputPorts, outputNodePort.data().getNodePortId());
        }
        CollectionUtil.remove(nodes, node.data().getNodeId());
    }*/
}
