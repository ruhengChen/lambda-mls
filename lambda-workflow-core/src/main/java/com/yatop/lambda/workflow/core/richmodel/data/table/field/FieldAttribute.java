package com.yatop.lambda.workflow.core.richmodel.data.table.field;

import com.yatop.lambda.core.enums.FieldDataTypeEnum;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;

public class FieldAttribute implements IRichModel {

    private String name;
    private String type;

    public FieldAttribute() {}

    public FieldAttribute(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public void clear() {
        name = null;
        type = null;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if(!(that instanceof FieldAttribute)) {
            return false;
        }

        FieldAttribute other = (FieldAttribute) that;
        return this.name.equals(other.name) ? this.type.equals(other.type) : false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSparkType() {
        FieldDataTypeEnum dataTypeEnum = FieldDataTypeEnum.valueOfPlatform(type);
        return DataUtil.isNotNull(dataTypeEnum) ? dataTypeEnum.getSpark() : null;
    }
}
