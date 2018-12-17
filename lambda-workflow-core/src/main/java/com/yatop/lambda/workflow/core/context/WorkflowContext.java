package com.yatop.lambda.workflow.core.context;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.workflow.core.richmodel.data.DataWarehouse;
import com.yatop.lambda.workflow.core.richmodel.model.ModelWarehouse;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeSchema;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;
import com.yatop.lambda.workflow.core.richmodel.experiment.Experiment;
import com.yatop.lambda.workflow.core.richmodel.project.Project;
import com.yatop.lambda.workflow.core.richmodel.workflow.GlobalParameter;
import com.yatop.lambda.workflow.core.richmodel.workflow.Workflow;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeLink;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodePort;

import java.util.TreeMap;

public class WorkflowContext {

    private Project project;                //操作关联的项目
    private Experiment experiment;          //操作关联的实验
    private Workflow workflow;              //操作关联的工作流
    private TreeMap<Long, DataWarehouse>  dataWarehouses = new TreeMap<Long, DataWarehouse>();   //操作关联的数据仓库
    private TreeMap<Long, ModelWarehouse> modelWarehouses = new TreeMap<Long, ModelWarehouse>();  //操作关联的模型仓库
    private TreeMap<Long, Node> nodes = new TreeMap<Long, Node>();      //操作关联的节点
    private TreeMap<Long, NodeLink> links = new TreeMap<Long, NodeLink>();  //操作关联的节点链接
    private TreeMap<Long, NodePort> ports = new TreeMap<Long, NodePort>();  //操作关联的节点端口
    private TreeMap<Long, NodeSchema> schemas = new TreeMap<Long, NodeSchema>();  //操作关联的节点端口
    private TreeMap<Long, GlobalParameter> globalParameters = new TreeMap<Long, GlobalParameter>();  //操作关联的节点参数

    public WorkflowContext(Project project, Experiment experiment, Workflow workflow) {
        this.project = project;
        this.experiment = experiment;
        this.workflow = workflow;
    }

    public Project getProject() {
        return project;
    }

    public Experiment getExperiment() {
        return experiment;
    }

    public Workflow getWorkflow() {
        return workflow;
    }

    public DataWarehouse getDataWarehouse(Long dataWarehouseId) {
        return dataWarehouses.get(dataWarehouseId);
    }

    public ModelWarehouse getModelWarehouse(Long modelWarehouseId) {
        return modelWarehouses.get(modelWarehouseId);
    }

    public Node getNode(Long nodeId) {
        return nodes.get(nodeId);
    }

    public NodeLink getLink(Long linkId) {
        return links.get(linkId);
    }

    public NodePort getPort(Long portId) {
        return ports.get(portId);
    }

    public NodeSchema getSchema(Long schemaId) {
        return schemas.get(schemaId);
    }

    public GlobalParameter getGlobalParameter(Long globalParameterId) {
        return globalParameters.get(globalParameterId);
    }

    public void setDataWarehouse(Long dataWarehouseId, DataWarehouse warehouse) {
        CollectionUtil.put(dataWarehouses, dataWarehouseId, warehouse);
    }

    public void setModelWarehouse(Long modelWarehouseId, ModelWarehouse warehouse) {
        CollectionUtil.put(modelWarehouses, modelWarehouseId, warehouse);
    }

    public void setNode(Long nodeId, Node node) {
        CollectionUtil.put(nodes, nodeId, node);
    }

    public void setLink(Long linkId, NodeLink link) {
        CollectionUtil.put(links, linkId, link);
    }

    public void setPort(Long portId, NodePort port) {
        CollectionUtil.put(ports, portId, port);
    }

    public void setSchema(Long schemaId, NodeSchema schema) {
        CollectionUtil.put(schemas, schemaId, schema);
    }

    public void getGlobalParameter(Long globalParameterId, GlobalParameter globalParameter) {
        CollectionUtil.put(globalParameters, globalParameterId, globalParameter);
    }

    public JSONObject toJSON() {
        return null;
    }

    public void clear() {
        project.clear();
        experiment.clear();
        workflow.clear();

        CollectionUtil.clear(dataWarehouses);
        CollectionUtil.clear(modelWarehouses);
        CollectionUtil.clear(nodes);
        CollectionUtil.clear(links);
        CollectionUtil.clear(ports);
        CollectionUtil.clear(schemas);
        CollectionUtil.clear(globalParameters);
    }
}
