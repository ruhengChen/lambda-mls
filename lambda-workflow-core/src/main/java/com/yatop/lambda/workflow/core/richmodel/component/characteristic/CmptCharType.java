package com.yatop.lambda.workflow.core.richmodel.component.characteristic;

import com.yatop.lambda.base.model.CfCmptCharType;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;

import java.util.*;

public class CmptCharType extends CfCmptCharType implements IRichModel {

    //作为输出端时，所适配的输入端特征类型
    private TreeMap<Integer, CmptCharType> matchTargetTypes = new TreeMap<Integer, CmptCharType>();   //适配特征类型，用于节点连线时的校验

    public CmptCharType(CfCmptCharType data) {
        super.copyProperties(data);
        this.clearColoured();
    }

    @Override
    public void clear() {
        matchTargetTypes.clear();
        matchTargetTypes = null;
        super.clear();
    }

    public boolean matchTargetType(CmptCharType target) {
        return this.getCharTypeId().equals(target.getCharTypeId()) || CollectionUtil.containsKey(matchTargetTypes, target.getCharTypeId());
    }

    public int matchTargetTypeCount() {
        return matchTargetTypes.size();
    }

    public List<CmptCharType> getMatchTargetTypes() {
        return CollectionUtil.toList(matchTargetTypes);
    }

    public void putMatchTargetType(CmptCharType targetType) {
        CollectionUtil.put(matchTargetTypes, targetType.getCharTypeId(), targetType);
    }

    public void replaceMatchTargetTypes(TreeMap<Integer, CmptCharType> expandedTargetCharTypes) {
        matchTargetTypes.clear();
        this.matchTargetTypes = expandedTargetCharTypes;
    }
}
