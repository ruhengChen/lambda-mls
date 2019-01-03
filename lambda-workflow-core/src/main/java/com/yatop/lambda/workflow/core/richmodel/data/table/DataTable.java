package com.yatop.lambda.workflow.core.richmodel.data.table;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.DwDataTable;
import com.yatop.lambda.workflow.core.codec.TaskContextCodec;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;

public class DataTable extends DwDataTable implements IRichModel {

    public DataTable(DwDataTable data) {
        super.copyProperties(data);
        this.clearColoured();
    }

    @Override
    public JSONObject toJSON() {
        JSONObject jsonObject = super.toJSON();
        jsonObject.put(TaskContextCodec.JSON_CLASS_NAME_KEY, DataTable.class.getName());
        return jsonObject;
    }

    @Override
    public void clear() {
        super.clear();
    }
}
