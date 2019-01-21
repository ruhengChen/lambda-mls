package com.yatop.lambda.workflow.core.richmodel.data.unstructured;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.WfJsonObject;
import com.yatop.lambda.workflow.core.serialize.TaskContentSerializer;
import com.yatop.lambda.workflow.core.richmodel.RichModel;

public class JsonObject extends RichModel<WfJsonObject> {

    public JsonObject(WfJsonObject data) {
        super(data);
    }

    @Override
    public JSONObject toJSON() {
        JSONObject jsonObject = super.toJSON();
        jsonObject.put(TaskContentSerializer.JSON_CLASS_NAME_KEY, JsonObject.class.getName());
        return jsonObject;
    }
}
