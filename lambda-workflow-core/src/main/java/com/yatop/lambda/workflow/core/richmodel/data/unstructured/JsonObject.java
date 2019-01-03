package com.yatop.lambda.workflow.core.richmodel.data.unstructured;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.WfJsonObject;
import com.yatop.lambda.workflow.core.codec.TaskContextCodec;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;

public class JsonObject extends WfJsonObject implements IRichModel {

    public JsonObject(WfJsonObject data) {
        super.copyProperties(data);
        this.clearColoured();
    }

    @Override
    public JSONObject toJSON() {
        JSONObject jsonObject = super.toJSON();
        jsonObject.put(TaskContextCodec.JSON_CLASS_NAME_KEY, JsonObject.class.getName());
        return jsonObject;
    }

    @Override
    public void clear() {
        super.clear();
    }
}
