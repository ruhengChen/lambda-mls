package com.yatop.lambda.workflow.core.context;

import com.yatop.lambda.core.enums.SpecTypeEnum;
import com.yatop.lambda.workflow.core.richmodel.workflow.value.CharValue;
import com.yatop.lambda.workflow.core.richmodel.component.Component;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.component.specification.CmptSpec;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;

public class CharValueContext implements IWorkContext {

    //private boolean isTaskReturn;   //是否为运行任务返回后的特征值更新操作
    private WorkflowContext workflowContext;    //操作关联工作流
    private Node node;
    private Component component;    //操作关联组件
    private CmptSpec cmptSpec;      //操作关联组件规格
    private CmptChar cmptChar;      //操作关联组件特征
    private CharValue charValue;    //特征值的传入传出

    /*public CharValueContext(WorkflowContext workflowContext, Node node, CharValue charValue) {
        this(workflowContext, node, charValue, false);
    }*/

    public CharValueContext(WorkflowContext workflowContext, Node node, CharValue charValue/*, boolean isTaskReturn*/) {
        //this.isTaskReturn = isTaskReturn;
        this.workflowContext = workflowContext;
        this.node = node;
        this.charValue = charValue;

        this.component = this.node.getModule().getComponent();
        this.cmptSpec = this.component.getCmptSpec(SpecTypeEnum.valueOf(this.charValue.getSpecType()));
        this.cmptChar = this.charValue.getCmptChar();
    }

    @Override
    public void clear() {
        //isTaskReturn = false;
        workflowContext = null;
        node = null;
        component = null;
        cmptSpec = null;
        cmptChar = null;
        charValue = null;
    }

/*    public boolean isTaskReturn() {
        return isTaskReturn;
    }*/

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
        return cmptChar;
    }

    public CharValue getCharValue() {
        return charValue;
    }
}
