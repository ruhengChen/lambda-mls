package com.yatop.lambda.workflow.core.mgr.data;

import com.yatop.lambda.base.model.WfCodeScript;
import com.yatop.lambda.core.enums.CodeScriptSourceEnum;
import com.yatop.lambda.core.enums.CodeScriptStateEnum;
import com.yatop.lambda.core.enums.CodeScriptTypeEnum;
import com.yatop.lambda.core.mgr.workflow.unstructured.CodeScriptMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.CharValueContext;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.data.unstructured.CodeScript;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CodeScriptHelper {
    private static CodeScriptMgr CODE_SCRIPT_MGR;

    @Autowired
    public void setCodeScriptMgr(CodeScriptMgr codeScriptMgr) {
        CODE_SCRIPT_MGR = codeScriptMgr;
    }

    public static CodeScript createCodeScript4Sql(CharValueContext context, String defaultScriptContent) {
        WorkflowContext workflowContext = context.getWorkflowContext();
        Node node = context.getNode();
        CmptChar cmptChar = context.getCmptChar();

        WfCodeScript codeScript = new WfCodeScript();
        codeScript.setScriptName(String.format("sql_%d_%s", node.data().getNodeId(), cmptChar.data().getCharId()));
        codeScript.setScriptType(CodeScriptTypeEnum.SQL.getType());
        codeScript.setScriptSrc(CodeScriptSourceEnum.EDITOR.getSource());
        codeScript.setOwnerProjectId(workflowContext.getProject().data().getProjectId());
        codeScript.setRelFlowId(workflowContext.getWorkflow().data().getFlowId());
        codeScript.setRelNodeId(node.data().getNodeId());
        codeScript.setRelCharId(cmptChar.data().getCharId());
        codeScript.setRelTaskId(-1L);
        if(DataUtil.isNotEmpty(defaultScriptContent)) {
            codeScript.setScriptContent(defaultScriptContent);
            codeScript.setScriptState(CodeScriptStateEnum.NORMAL.getState());
        } else {
            codeScript.setScriptState(CodeScriptStateEnum.EMPTY.getState());
        }
        codeScript = CODE_SCRIPT_MGR.insertCodeScript(codeScript, workflowContext.getOperId());
        return new CodeScript(codeScript);
    }

    public static void deleteCodeScript(CharValueContext context, CodeScript codeScript) {
        WorkflowContext workflowContext = context.getWorkflowContext();
        CODE_SCRIPT_MGR.deleteCodeScript(codeScript.data().getScriptId(), workflowContext.getOperId());
    }

    public static void recoverCodeScript(CharValueContext context, Long codeScriptId) {
        WorkflowContext workflowContext = context.getWorkflowContext();
        CODE_SCRIPT_MGR.recoverCodeScript(codeScriptId, workflowContext.getOperId());
    }

    public static void updateCodeScript(CharValueContext context, CodeScript codeScript) {
        WorkflowContext workflowContext = context.getWorkflowContext();

        if(DataUtil.isNotEmpty(codeScript.data().getScriptContent())) {
            codeScript.data().setScriptState(CodeScriptStateEnum.NORMAL.getState());
        } else {
            codeScript.data().setScriptState(CodeScriptStateEnum.EMPTY.getState());
        }
        CODE_SCRIPT_MGR.updateCodeScript(codeScript.data(), workflowContext.getOperId());
    }

    public static CodeScript queryCodeScript(Long codeScriptId) {
        WfCodeScript codeScript = CODE_SCRIPT_MGR.queryCodeScript(codeScriptId);
        return new CodeScript(codeScript);
    }
}
