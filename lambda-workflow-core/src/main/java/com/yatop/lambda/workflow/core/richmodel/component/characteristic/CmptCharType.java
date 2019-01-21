package com.yatop.lambda.workflow.core.richmodel.component.characteristic;

import com.yatop.lambda.base.model.CfCmptCharType;
import com.yatop.lambda.workflow.core.framework.chartype.ICharTypeClazz;
import com.yatop.lambda.workflow.core.richmodel.RichModel;
import com.yatop.lambda.workflow.core.utils.ClazzHelperUtil;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;

import java.util.*;

public class CmptCharType extends RichModel<CfCmptCharType> {

    //作为输出端时，所适配的输入端特征类型
    private TreeMap<Integer, CmptCharType> matchTargetTypes = new TreeMap<Integer, CmptCharType>();   //适配特征类型，用于节点连线时的校验

    public CmptCharType(CfCmptCharType data) {
        super(data);
    }

    @Override
    public void clear() {
        CollectionUtil.clear(matchTargetTypes);
        matchTargetTypes = null;
        super.clear();
    }

    public boolean matchTargetType(CmptCharType target) {
        return this.data().getCharTypeId().equals(target.data().getCharTypeId()) || CollectionUtil.containsKey(matchTargetTypes, target.data().getCharTypeId());
    }

    public int matchTargetTypeCount() {
        return matchTargetTypes.size();
    }

    public List<CmptCharType> getMatchTargetTypes() {
        return CollectionUtil.toList(matchTargetTypes);
    }

    public void putMatchTargetType(CmptCharType targetType) {
        CollectionUtil.put(matchTargetTypes, targetType.data().getCharTypeId(), targetType);
    }

    public void replaceMatchTargetTypes(TreeMap<Integer, CmptCharType> expandedTargetCharTypes) {
        matchTargetTypes.clear();
        this.matchTargetTypes = expandedTargetCharTypes;
    }

    public ICharTypeClazz getCharTypeClazzBean() {
        return ClazzHelperUtil.getCharTypeClazzBean(this);
    }
}
