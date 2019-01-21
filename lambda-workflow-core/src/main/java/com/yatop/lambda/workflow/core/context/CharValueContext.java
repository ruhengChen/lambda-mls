package com.yatop.lambda.workflow.core.context;

import com.yatop.lambda.core.enums.SpecTypeEnum;
import com.yatop.lambda.workflow.core.richmodel.workflow.value.CharValue;
import com.yatop.lambda.workflow.core.richmodel.component.Component;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.component.specification.CmptSpec;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;

public class CharValueContext implements IWorkContext {

    private WorkflowContext workflowContext;    //操作关联工作流上下文
    private Node node;              //操作关联节点
    private Component component;    //操作关联组件
    private CmptSpec cmptSpec;      //操作关联组件规格
    private CharValue charValue;    //特征值的传入传出

    public CharValueContext(WorkflowContext workflowContext, Node node, CharValue charValue) {
        this.workflowContext = workflowContext;
        this.node = node;
        this.charValue = charValue;

        this.component = this.node.getModule().getComponent();
        this.cmptSpec = this.component.getCmptSpec(SpecTypeEnum.valueOf(this.charValue.getSpecType()));
    }

    @Override
    public void clear() {
        workflowContext = null;
        node = null;
        component = null;
        cmptSpec = null;
        charValue = null;
    }

    public WorkflowContext getWorkflowContext() {
        return workflowContext;
    }

    public Node getNode() {
        return node;
    }

    public Component getComponent() {
        return component;
    }

    public CmptSpec getCmptSpec() {
        return cmptSpec;
    }

    public CmptChar getCmptChar() {
        return charValue.getCmptChar();
    }

    public CharValue getCharValue() {
        return charValue;
    }
}
