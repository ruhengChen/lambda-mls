package com.yatop.lambda.workflow.core.richmodel;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.utils.LambdaRootModel;

public abstract class RichModel<T extends LambdaRootModel> extends LambdaRootModel implements IRichModel {

    private T data;

    public RichModel(T data) {
        this.data = data;
        this.clearColoured();
    }

    public T data() {
        return data;
    }

    @Override
    public boolean equals(Object that) {
        return data.equals(that);
    }

    @Override
    public int hashCode() {
        return data.hashCode();
    }

    @Override
    public JSONObject toJSON() {
        return this.data.toJSON();
    }

    @Override
    public void clear() {
        data.clear();
    }

    @Override
    public void clearColoured() {
        data.clearColoured();
    }

    @Override
    public boolean isColoured() {
        return data.isColoured();
    }
}
