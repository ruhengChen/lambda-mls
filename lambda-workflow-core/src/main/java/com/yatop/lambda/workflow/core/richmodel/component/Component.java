package com.yatop.lambda.workflow.core.richmodel.component;

import com.yatop.lambda.base.model.CfComponent;
import com.yatop.lambda.core.enums.*;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.core.utils.SystemParameterUtil;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.component.specification.CmptSpec;
import com.yatop.lambda.workflow.core.richmodel.component.specification.CmptSpecCharValue;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;

import java.util.TreeMap;

public class Component extends CfComponent implements IRichModel {

    private CmptAlgorithm algorithm;    //组件关联算法
    private CmptSpec input;             //组件输入内容规格
    private CmptSpec output;            //组件输出内容规格
    private CmptSpec execution;         //组件调用执行规格
    private CmptSpec optimizeExecution; //组件执行调优参数规格
    private CmptSpec parameter;         //组件参数规格
    private TreeMap<String, CmptCharValue> charValues = new TreeMap<String, CmptCharValue>();   //组件配置特征值

    public Component(CfComponent data) {
        super.copyProperties(data);
        this.clearColoured();
    }

    @Override
    public void clear() {
        algorithm = null;
        input = null;
        output = null;
        execution = null;
        optimizeExecution = null;
        parameter = null;
        CollectionUtil.clear(charValues);
        charValues = null;
        super.clear();
    }

    public boolean isWebComponent() {
        return this.getCmptType() == CmptTypeEnum.WEB_CMPT.getType();
    }

    public CmptAlgorithm getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(CmptAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public CmptSpec getInput() {
        return input;
    }

    private void setInput(CmptSpec input) {
        this.input = input;
    }

    public CmptSpec getOutput() {
        return output;
    }

    private void setOutput(CmptSpec output) {
        this.output = output;
    }

    public CmptSpec getExecution() {
        return execution;
    }

    private void setExecution(CmptSpec execution) {
        this.execution = execution;
    }

    public CmptSpec getOptimizeExecution() {
        return optimizeExecution;
    }

    private void setOptimizeExecution(CmptSpec optimizeExecution) {
        this.optimizeExecution = optimizeExecution;
    }

    public CmptSpec getParameter() {
        return parameter;
    }

    private void setParameter(CmptSpec parameter) {
        this.parameter = parameter;
    }

    public int charValueCount() {
        return charValues.size();
    }

    public CmptCharValue getCharValue(String charId) {
        return CollectionUtil.get(charValues, charId);
    }

    public String getConfigCharValue(CmptChar cmptChar) {

        if(cmptChar.getSrcLevel() != SourceLevelEnum.SPECIFICATION.getSource()) {
            CmptCharValue cmptCharValue = this.getCharValue(cmptChar.getCharId());
            if (DataUtil.isNotNull(cmptCharValue)) {
                if (cmptCharValue.getIsSystemParam() == IsSystemParamEnum.YES.getMark())
                    return DataUtil.trimToNull(SystemParameterUtil.find(cmptCharValue.getCharValue()));
                else
                    return DataUtil.trimToNull(cmptCharValue.getCharValue());
            }
        }

        CmptSpecCharValue specCharValue = null;
        switch (SpecTypeEnum.valueOf(cmptChar.getSpecType())) {
            case INPUT:
                if(DataUtil.isNotNull(input)) {
                    specCharValue = this.input.getCharValue(cmptChar.getCharId());
                }
                break;
            case OUTPUT:
                if(DataUtil.isNotNull(output)) {
                    specCharValue = this.output.getCharValue(cmptChar.getCharId());
                }
                break;
            case EXECUTION:
                if(DataUtil.isNotNull(execution)) {
                    specCharValue = this.execution.getCharValue(cmptChar.getCharId());
                }
                break;
            case OPTIMIZE_EXECUTION:
                if(DataUtil.isNotNull(optimizeExecution)) {
                    specCharValue = this.optimizeExecution.getCharValue(cmptChar.getCharId());
                }
                break;
            case PARAMETER:
                if(DataUtil.isNotNull(parameter)) {
                    specCharValue = this.parameter.getCharValue(cmptChar.getCharId());
                }
                break;
        }
        if(DataUtil.isNotNull(specCharValue)) {
            if(specCharValue.getIsSystemParam() == IsSystemParamEnum.YES.getMark())
                return DataUtil.trimToNull(SystemParameterUtil.find(specCharValue.getCharValue()));
            else
                return DataUtil.trimToNull(specCharValue.getCharValue());
        }
        return DataUtil.trimToNull(cmptChar.getDefaultValue());
    }

    public void putCharValue(CmptCharValue charValue) {
        CollectionUtil.put(charValues, charValue.getCharId(), charValue);
    }

    public void setCmptSpec(CmptSpec cmptSpec) {
        switch (SpecTypeEnum.valueOf(cmptSpec.getSpecType())) {
            case INPUT:
                this.setInput(cmptSpec);
                break;
            case OUTPUT:
                this.setOutput(cmptSpec);
                break;
            case EXECUTION:
                this.setExecution(cmptSpec);
                break;
            case OPTIMIZE_EXECUTION:
                this.setOptimizeExecution(cmptSpec);
                break;
            case PARAMETER:
                this.setParameter(cmptSpec);
                break;
        }
    }

    public CmptSpec getCmptSpec(SpecTypeEnum typeEnum) {
        switch (typeEnum) {
            case INPUT:
                return this.getInput();
            case OUTPUT:
                return this.getOutput();
            case EXECUTION:
                return this.getExecution();
            case OPTIMIZE_EXECUTION:
                return this.getOptimizeExecution();
            case PARAMETER:
                return this.getParameter();
        }
        return null;
    }

    public boolean existsCmptChar(CmptChar cmptChar) {
        switch (SpecTypeEnum.valueOf(cmptChar.getSpecType())) {
            case INPUT:
                return DataUtil.isNotNull(this.getInput().getCmptChar(cmptChar.getCharId()));
            case OUTPUT:
                return DataUtil.isNotNull(this.getOutput().getCmptChar(cmptChar.getCharId()));
            case EXECUTION:
                return DataUtil.isNotNull(this.getExecution().getCmptChar(cmptChar.getCharId()));
            case OPTIMIZE_EXECUTION:
                return DataUtil.isNotNull(this.getOptimizeExecution().getCmptChar(cmptChar.getCharId()));
            case PARAMETER:
                return DataUtil.isNotNull(this.getParameter().getCmptChar(cmptChar.getCharId()));
        }
        return false;
    }

    public boolean missingConfigCharValue(CmptChar cmptChar) {
        switch (SourceLevelEnum.valueOf(cmptChar.getSrcLevel())) {
            case SPECIFICATION:
            case COMPONENT:
                if(cmptChar.getIsRequired() == IsRequiredEnum.YES.getMark() && DataUtil.isEmpty(this.getConfigCharValue(cmptChar)))
                    return true;
          //case WORKFLOW:
        }
        return false;
    }
}
