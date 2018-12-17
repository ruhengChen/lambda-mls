package com.yatop.lambda.workflow.core.richmodel.component.characteristic;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.CfCmptCharType;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;

import java.util.*;

public class CmptCharType extends CfCmptCharType implements IRichModel {

    private TreeSet<Integer> matchTypes = new TreeSet<Integer>();

    public CmptCharType() {}

    public CmptCharType(CfCmptCharType data) {super.copyProperties(data);}

    @Override
    public void clear() {
        matchTypes.clear();
        matchTypes = null;
        super.clear();
    }

    public boolean isMatchType(Integer charTypeId) {
        return CollectionUtil.contains(matchTypes, charTypeId);
    }

    public List<Integer> getMatchTypes() {
        return CollectionUtil.toList(matchTypes);
    }

    public void addMatchType(Integer charTypeId) {
        CollectionUtil.add(matchTypes, charTypeId);
    }
}
