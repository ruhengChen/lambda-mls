package com.yatop.lambda.base.utils;

import com.alibaba.fastjson.JSONObject;

public abstract class LambdaRootModel {
    public abstract JSONObject toJSON();
    public abstract void clear();
}
