package com.yatop.lambda.workflow.core.richmodel.component.specification;

import com.yatop.lambda.base.model.CfCmptSpec;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;

import java.util.List;
import java.util.TreeMap;

public class CmptSpec extends CfCmptSpec implements IRichModel {

    private TreeMap<String, CmptChar> cmptChars = new TreeMap<String, CmptChar>();              //规格关联特征
    private TreeMap<String, CmptSpecCharValue> charValues = new TreeMap<String, CmptSpecCharValue>();    //规格配置特征值

    public CmptSpec(CfCmptSpec data) {
        super.copyProperties(data);
        this.clearColoured();
    }

    @Override
    public void clear() {
        cmptChars.clear();
        cmptChars = null;
        CollectionUtil.clear(charValues);
        charValues = null;
        super.clear();
    }

    public int cmptCharCount() {
        return cmptChars.size();
    }

    public CmptChar getCmptChar(String charId) {
        return CollectionUtil.get(cmptChars, charId);
    }

    public List<CmptChar> getCmptChars() {
        return CollectionUtil.toList(cmptChars);
    }

    public void putCmptChar(CmptChar cmptChar) {
        CollectionUtil.put(cmptChars, cmptChar.getCharId(), cmptChar);
    }

    public int charValueCount() {
        return charValues.size();
    }

    public CmptSpecCharValue getCharValue(String charId) {
        return CollectionUtil.get(charValues, charId);
    }

    public void putCharValue(CmptSpecCharValue charValue) {
        CollectionUtil.put(charValues, charValue.getCharId(), charValue);
    }
}
