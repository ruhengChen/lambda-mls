package com.yatop.lambda.workflow.core.richmodel.component.specification;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.CfCmptChar;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;

import java.util.List;
import java.util.TreeMap;

public class CmptSpec extends CfCmptChar implements IRichModel {

    private TreeMap<String, CmptChar> cmptChars = new TreeMap<String, CmptChar>();
    private TreeMap<String, CmptSpecCharValue> charValues = new TreeMap<String, CmptSpecCharValue>();

    public CmptSpec() {}

    public CmptSpec(CfCmptChar data) {super.copyProperties(data);}

    @Override
    public void clear() {
        cmptChars.clear();
        cmptChars = null;
        CollectionUtil.clear(charValues);
        charValues = null;
        super.clear();
    }

    public CmptChar getCmptChar(String charId) {
        return CollectionUtil.get(cmptChars, charId);
    }

    public List<CmptChar> getCmptChars() {
        return CollectionUtil.toList(cmptChars);
    }

    public void putCharChar(CmptChar cmptChar) {
        CollectionUtil.put(cmptChars, cmptChar.getCharId(), cmptChar);
    }

    public CmptSpecCharValue getCharValue(String charId) {
        return CollectionUtil.get(charValues, charId);
    }

    public void setCharValue(CmptSpecCharValue charValue) {
        CollectionUtil.put(charValues, charValue.getCharId(), charValue);
    }
}
