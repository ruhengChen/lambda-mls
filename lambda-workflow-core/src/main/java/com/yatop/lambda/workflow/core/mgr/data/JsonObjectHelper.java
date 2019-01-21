package com.yatop.lambda.workflow.core.mgr.data;

import com.yatop.lambda.base.model.WfJsonObject;
import com.yatop.lambda.core.enums.*;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.mgr.workflow.unstructured.JsonObjectMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.core.utils.JsonObjectFileUtil;
import com.yatop.lambda.workflow.core.context.CharValueContext;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.data.unstructured.JsonObject;
import com.yatop.lambda.workflow.core.richmodel.workflow.execution.ExecutionJob;
import com.yatop.lambda.workflow.core.richmodel.workflow.execution.ExecutionTask;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JsonObjectHelper {

    private static JsonObjectMgr JSON_OBJECT_MGR;

    @Autowired
    public void setJsonObjectMgr(JsonObjectMgr jsonObjectMgr) {
        JSON_OBJECT_MGR = jsonObjectMgr;
    }

    public static JsonObject createJsonObject4General(CharValueContext context) {
        return createJsonObject4General(context, null);
    }

    public static JsonObject createJsonObject4General(CharValueContext context, String defaultObjectContent) {
        WorkflowContext workflowContext = context.getWorkflowContext();
        Node node = context.getNode();
        CmptChar cmptChar = context.getCmptChar();

        WfJsonObject jsonObject = new WfJsonObject();
        jsonObject.setObjectName(String.format("general_%d_%s", node.data().getNodeId(), cmptChar.data().getCharId()));
        jsonObject.setObjectType(JsonObjectTypeEnum.ALGORITHM_PARAMETERS.getType());
        jsonObject.setObjectSrc(JsonObjectSourceEnum.EDITOR.getSource());
        jsonObject.setOwnerProjectId(workflowContext.getProject().data().getProjectId());
        jsonObject.setRelFlowId(workflowContext.getWorkflow().data().getFlowId());
        jsonObject.setRelNodeId(node.data().getNodeId());
        jsonObject.setRelCharId(cmptChar.data().getCharId());
        jsonObject.setRelTaskId(-1L);
        jsonObject.setStorageLocation(StorageLocationEnum.TABLE_FIELD.getLocation());
        if(DataUtil.isNotEmpty(defaultObjectContent)) {
            jsonObject.setObjectContent(defaultObjectContent);
            jsonObject.setObjectState(JsonObjectStateEnum.NORMAL.getState());
        } else {
            jsonObject.setObjectState(JsonObjectStateEnum.EMPTY.getState());
        }
        jsonObject = JSON_OBJECT_MGR.insertJsonObject(jsonObject, workflowContext.getOperId());
        return new JsonObject(jsonObject);
    }

    public static JsonObject createJsonObject4Algorithm(CharValueContext context) {
        WorkflowContext workflowContext = context.getWorkflowContext();
        Node node = context.getNode();
        CmptChar cmptChar = context.getCmptChar();
        ExecutionJob job = workflowContext.getCurrentJob();
        ExecutionTask task = workflowContext.getExecutionTask(node);

        WfJsonObject jsonObject = new WfJsonObject();
        jsonObject.setObjectName(String.format("algorithm_parameters_%d_%s_%d", node.data().getNodeId(), cmptChar.data().getCharId(), job.data().getJobId()));
        jsonObject.setObjectType(JsonObjectTypeEnum.ALGORITHM_PARAMETERS.getType());
        jsonObject.setObjectSrc(JsonObjectSourceEnum.EXECUTION.getSource());
        jsonObject.setOwnerProjectId(workflowContext.getProject().data().getProjectId());
        jsonObject.setRelFlowId(workflowContext.getWorkflow().data().getFlowId());
        jsonObject.setRelNodeId(node.data().getNodeId());
        jsonObject.setRelCharId(cmptChar.data().getCharId());
        jsonObject.setRelTaskId(task.data().getTaskId());
        jsonObject.setStorageLocation(StorageLocationEnum.TABLE_FIELD.getLocation());
        jsonObject.setObjectState(JsonObjectStateEnum.EMPTY.getState());
        jsonObject = JSON_OBJECT_MGR.insertJsonObject(jsonObject, workflowContext.getOperId());
        return new JsonObject(jsonObject);
    }

    public static JsonObject createJsonObject4Report(CharValueContext context, JsonObjectTypeEnum jsonObjectType) {
        WorkflowContext workflowContext = context.getWorkflowContext();
        Node node = context.getNode();
        CmptChar cmptChar = context.getCmptChar();
        ExecutionJob job = workflowContext.getCurrentJob();
        ExecutionTask task = workflowContext.getExecutionTask(node);

        String reportNamePrefix = null;
        switch (jsonObjectType) {
            case MODEL_EVALUATION_REPORT:
                reportNamePrefix = "model_evaluation_report";
                break;
            case STATISTICAL_ANALYSIS_REPORT:
                reportNamePrefix = "statistical_analysis_report";
                break;
            case TUNE_PARAMETERS_REPORT:
                reportNamePrefix = "tune_parameters_report";
                break;
            case GENERATE_RULES_REPORT:
                reportNamePrefix = "generate_rules_report";
                break;
            default:
                throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Create json object failed -- unexpected report type.", "未知报告类型");
        }

        WfJsonObject jsonObject = new WfJsonObject();
        jsonObject.setObjectName(String.format("%s_%d_%s_%d", reportNamePrefix, node.data().getNodeId(), cmptChar.data().getCharId(), job.data().getJobId()));
        jsonObject.setObjectType(jsonObjectType.getType());
        jsonObject.setObjectSrc(JsonObjectSourceEnum.EXECUTION.getSource());
        jsonObject.setOwnerProjectId(workflowContext.getProject().data().getProjectId());
        jsonObject.setRelFlowId(workflowContext.getWorkflow().data().getFlowId());
        jsonObject.setRelNodeId(node.data().getNodeId());
        jsonObject.setRelCharId(cmptChar.data().getCharId());
        jsonObject.setRelTaskId(task.data().getTaskId());
        jsonObject.setStorageLocation(StorageLocationEnum.FILE_SYSTEM.getLocation());
        jsonObject.setObjectState(JsonObjectStateEnum.EMPTY.getState());
        jsonObject = JSON_OBJECT_MGR.insertJsonObject(jsonObject, workflowContext.getOperId());

        String jobDfsDir = job.data().getJobDfsDir();
        String jobLocalDir = job.data().getJobLocalDir();
        jsonObject.setObjectDfsFile(JsonObjectFileUtil.getFilePath4Report(jobDfsDir, reportNamePrefix, jsonObject.getObjectId()));
        jsonObject.setObjectLocalFile(JsonObjectFileUtil.getFilePath4Report(jobLocalDir, reportNamePrefix, jsonObject.getObjectId()));
        JSON_OBJECT_MGR.updateJsonObject(jsonObject, workflowContext.getOperId());
        return new JsonObject(jsonObject);
    }

    public static void deleteJsonObject(CharValueContext context, JsonObject jsonObject) {
        WorkflowContext workflowContext = context.getWorkflowContext();

        if(jsonObject.data().getStorageLocation() == StorageLocationEnum.FILE_SYSTEM.getLocation()) {
            JSON_OBJECT_MGR.deleteJsonObject(jsonObject.data().getObjectId(), workflowContext.getOperId());
            //TODO ignore object state
            //TODO clear objectFile
        } else {
            JSON_OBJECT_MGR.deleteJsonObject(jsonObject.data().getObjectId(), workflowContext.getOperId());
        }
    }

    public static void recoverJsonObject(CharValueContext context, Long jsonObjectId) {
        WorkflowContext workflowContext = context.getWorkflowContext();
        JSON_OBJECT_MGR.recoverJsonObject(jsonObjectId, workflowContext.getOperId());
    }

    public static void completeJsonObject(CharValueContext context, JsonObject jsonObject) {
        WorkflowContext workflowContext = context.getWorkflowContext();

        if(jsonObject.data().getStorageLocation() == StorageLocationEnum.TABLE_FIELD.getLocation()) {
            jsonObject.data().setObjectContentColoured(true);
        }
        jsonObject.data().setObjectState(JsonObjectStateEnum.NORMAL.getState());
        JSON_OBJECT_MGR.updateJsonObject(jsonObject.data(), workflowContext.getOperId());
    }

    public static void updateJsonObject4General(CharValueContext context, JsonObject jsonObject) {
        WorkflowContext workflowContext = context.getWorkflowContext();

        if(DataUtil.isNotEmpty(jsonObject.data().getObjectContent())) {
            jsonObject.data().setObjectState(JsonObjectStateEnum.NORMAL.getState());
        } else {
            jsonObject.data().setObjectState(JsonObjectStateEnum.EMPTY.getState());
        }
        JSON_OBJECT_MGR.updateJsonObject(jsonObject.data(), workflowContext.getOperId());
    }

    public static JsonObject queryJsonObject(Long jsonObjectId) {
        WfJsonObject jsonObject = JSON_OBJECT_MGR.queryJsonObject(jsonObjectId);
        return new JsonObject(jsonObject);
    }
}
