package com.yatop.lambda.workflow.core.richmodel.data.model;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.MwModel;
import com.yatop.lambda.workflow.core.codec.TaskContextCodec;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;

public class Model extends MwModel implements IRichModel {

    public Model(MwModel data) {
        super.copyProperties(data);
        this.clearColoured();
    }

    @Override
    public JSONObject toJSON() {
        JSONObject jsonObject = super.toJSON();
        jsonObject.put(TaskContextCodec.JSON_CLASS_NAME_KEY, Model.class.getName());
        return jsonObject;
    }

    @Override
    public void clear() {
        super.clear();
    }
}
