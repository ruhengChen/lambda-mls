package com.yatop.lambda.workflow.core.richmodel;

import com.alibaba.fastjson.JSONObject;

public interface IRichModel {
    JSONObject toJSON();
    void clear();
}
