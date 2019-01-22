package com.yatop.lambda.workflow.core.richmodel.workflow.value;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.utils.LambdaRootModel;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.framework.chartype.ICharTypeClazz;
import com.yatop.lambda.workflow.core.framework.chartype.clazz.algorithm.CharTypeAlgorithmGeneric;
import com.yatop.lambda.workflow.core.framework.chartype.clazz.basic.CharTypeBasicGeneric;
import com.yatop.lambda.workflow.core.framework.chartype.clazz.json.CharTypeJsonGeneric;
import com.yatop.lambda.workflow.core.framework.chartype.clazz.model.CharTypeModelGeneric;
import com.yatop.lambda.workflow.core.framework.chartype.clazz.report.CharTypeReportGeneric;
import com.yatop.lambda.workflow.core.framework.chartype.clazz.script.CharTypeScriptGeneric;
import com.yatop.lambda.workflow.core.framework.chartype.clazz.table.CharTypeTableGeneric;
import com.yatop.lambda.workflow.core.framework.chartype.clazz.tune.CharTypeTuneGeneric;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.data.model.Model;
import com.yatop.lambda.workflow.core.richmodel.data.table.DataTable;
import com.yatop.lambda.workflow.core.richmodel.data.unstructured.JsonObject;

public class CharValue extends LambdaRootModel implements IRichModel {
    private CmptChar cmptChar;
    private String charValue;	    //特征值内容
    private String inText;		    //传入文本内容，仅限组件参数、调用执行、运行调优参数，以文本内容方式进行传入传出
    private String outText;		    //传出文本内容
    private IRichModel inObject;    //传入对象内容，仅限输入内容、输出内容，以对象内容方式进行传入传出（算法参数、数据表、模型、报告）
    private IRichModel outObject;	//传出对象内容

    public CharValue(CmptChar cmptChar) {
        this(cmptChar, null);
    }

    public CharValue(CmptChar cmptChar, String charValue) {
        this.cmptChar = cmptChar;
        this.charValue = charValue;
        this.clearColoured();
    }

    @Override
    public JSONObject toJSON() {
        JSONObject jsonObject = cmptChar.toJSON();
        jsonObject.put("charValue", charValue);
        jsonObject.put("textValue", getTextValue());
        jsonObject.put("objectValue", getObjectValue());
        return jsonObject;
    }

    @Override
    public void clear() {
        cmptChar = null;
        charValue = null;
        inText = null;
        outText = null;
        inObject = null;
        outObject = null;
    }

    @Override
    public void clearColoured() {

    }

    @Override
    public boolean isColoured() {
        return false;
    }

    public CmptChar getCmptChar() {
        return cmptChar;
    }

    public Integer getSpecType() {
        return this.getCmptChar().data().getSpecType();
    }

    public String getCharValue() {
        return charValue;
    }

    public void setCharValue(String charValue) {
        this.charValue = charValue;
    }

    public String getInText() {
        return inText;
    }

    public void setInText(String inText) {
        this.setOutText(null);
        this.inText = inText;
    }

    public String getOutText() {
        return outText;
    }

    public void setOutText(String outText) {
        this.outText = outText;
    }

    public IRichModel getInObject() {
        return inObject;
    }

    public void setInObject(IRichModel inObject) {
        this.setOutObject(null);
        this.inObject = inObject;
    }

    public IRichModel getOutObject() {
        return outObject;
    }

    public void setOutObject(IRichModel outObject) {
        this.outObject = outObject;
    }

    public ICharTypeClazz getCharTypeClazzBean() {
        return this.cmptChar.getCharTypeClazzBean();
    }

    public boolean isBasicDataType() {
        return getCharTypeClazzBean() instanceof CharTypeBasicGeneric;
    }

    public boolean isTuneDataType() {
        return getCharTypeClazzBean() instanceof CharTypeTuneGeneric;
    }

    public boolean isJsonDataType() {
        return getCharTypeClazzBean() instanceof CharTypeJsonGeneric;
    }

    public boolean isScriptDataType() {
        return getCharTypeClazzBean() instanceof CharTypeScriptGeneric;
    }

    public boolean isAlgorithmDataType() {
        return getCharTypeClazzBean() instanceof CharTypeAlgorithmGeneric;
    }

    public boolean isReportDataType() {
        return getCharTypeClazzBean() instanceof CharTypeReportGeneric;
    }

    public boolean isTableDataType() {
        return getCharTypeClazzBean() instanceof CharTypeTableGeneric;
    }

    public boolean isModelDataType() {
        return getCharTypeClazzBean() instanceof CharTypeModelGeneric;
    }

    public String getTextValue() {
        return DataUtil.isNotNull(getOutText()) ? getOutText() : getInText();
    }

    public IRichModel getObjectValue() {
        return DataUtil.isNotNull(getOutObject()) ? getOutObject() : getInObject();
    }

    public String getBasicValue() {
        return isBasicDataType() ? getTextValue() : null;
    }

    public String getTuneValue() {
        return isTuneDataType() ? getTextValue() : null;
    }

    public String getScriptValue() {
        return isScriptDataType() ? getTextValue() : null;
    }

    public String getJsonValue() {
        return isJsonDataType() ? getTextValue() : null;
    }

    public JsonObject getAlgorithmValue() {
        return isAlgorithmDataType() ? (JsonObject) getObjectValue() : null;
    }

    public JsonObject getReportValue() {
        return isReportDataType() ? (JsonObject) getObjectValue() : null;
    }

    public DataTable getTableValue() {
        return isTableDataType() ? (DataTable) getObjectValue() : null;
    }

    public Model getModelValue() {
        return isModelDataType() ? (Model) getObjectValue() : null;
    }
}
