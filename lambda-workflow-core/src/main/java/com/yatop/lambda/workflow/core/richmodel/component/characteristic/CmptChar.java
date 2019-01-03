package com.yatop.lambda.workflow.core.richmodel.component.characteristic;

import com.yatop.lambda.base.model.CfCmptChar;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;

import java.util.List;
import java.util.TreeMap;

public class CmptChar extends CfCmptChar implements IRichModel {

    private CmptCharType type;      //特征类型
    private TreeMap<String, CmptCharEnum> enums = new TreeMap<String, CmptCharEnum>();  //特征枚举值
    private TreeMap<Integer, CmptCharEnum> enumsOrderbySequence = new TreeMap<Integer, CmptCharEnum>();     //特征枚举值按序号排序

    public CmptChar(CfCmptChar data, CmptCharType type) {
        super.copyProperties(data);
        this.type = type;
        this.clearColoured();
    }

    @Override
    public void clear() {
        type = null;
        enums.clear();
        enums = null;
        CollectionUtil.clear(enumsOrderbySequence);
        enumsOrderbySequence = null;
        super.clear();
    }

    public CmptCharType getType() {
        return type;
    }

    public boolean containsEnum(String value) {
        return CollectionUtil.containsKey(enums, value);
    }

    public int enumCount() {
        return enums.size();
    }

    public List<CmptCharEnum> getEnums() {
        return CollectionUtil.toList(enumsOrderbySequence);
    }

    public void putEnum(CmptCharEnum charEnum) {
        CollectionUtil.put(enums, charEnum.getEnumValue(), charEnum);
        CollectionUtil.put(enumsOrderbySequence, charEnum.getSequence(), charEnum);
    }
}
