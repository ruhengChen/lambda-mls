package com.yatop.lambda.core.utils;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.yatop.lambda.base.utils.LambdaRootModel;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.Collection;
import java.util.Map;

public class DataUtil {

    public static boolean isNull(Object obj) {
        return obj == null;
    }

    public static boolean isNotNull(Object obj) {
        return obj != null;
    }

    public static boolean isEmpty(String str) {
        return StringUtils.isEmpty(str);
    }

    public static boolean isNotEmpty(String str) {
        return StringUtils.isNotEmpty(str);
    }

    public static boolean isBlank(String str) {
        return StringUtils.isBlank(str);
    }

    public static boolean isNotBlank(String str) {
        return StringUtils.isNotBlank(str);
    }

    public static boolean equals(String lhs, String rhs) {
        return StringUtils.equals(lhs, rhs);
    }

    public static boolean equalsIgnoreCase(String lhs, String rhs) {
        return StringUtils.equalsIgnoreCase(lhs, rhs);
    }

    public static String trim(String str) {
        return StringUtils.trim(str);
    }

    public static String trimToNull(String str) {
        return StringUtils.trimToNull(str);
    }

    public static boolean isNumberic(String str) {
        return NumberUtils.isDigits(str);
    }

    public static boolean isNotNumberic(String str) {
        return !NumberUtils.isDigits(str);
    }

    public static boolean isDigits(String str) {
        return NumberUtils.isDigits(str);
    }

    public static boolean isNotDigits(String str) {
        return !NumberUtils.isDigits(str);
    }

    public static String prettyFormat(JSON json) {
        return JSON.toJSONString(json, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
    }

    public static String prettyFormat(LambdaRootModel model) {
        return JSON.toJSONString(DataUtil.toJSONObject(model), SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
    }

    public static String prettyFormat(Collection<? extends LambdaRootModel> models) {
        return JSON.toJSONString(DataUtil.toJSONArray(models), SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
    }

    public static JSONObject toJSONObject(LambdaRootModel model) {
        return DataUtil.isNotNull(model) ? model.toJSON() : null;
    }

    public static JSONArray toJSONArray(Collection<? extends LambdaRootModel> models) {
        if(DataUtil.isNull(models))
            return null;

        JSONArray jsonArray = new JSONArray();
        for(LambdaRootModel model : models) {
            jsonArray.add(model.toJSON());
        }
        return jsonArray;
    }

    public static boolean isEmpty(Collection<? extends Object> list) {
        return (DataUtil.isNotNull(list)  ? list.isEmpty() : true);
    }

    public static boolean isNotEmpty(Collection<? extends Object> list) {
        return !DataUtil.isEmpty(list);
    }

    public static boolean isEmpty(Map map) {
        return (DataUtil.isNotNull(map)  ? map.isEmpty() : true);
    }

    public static boolean isNotEmpty(Map map) {
        return !DataUtil.isEmpty(map);
    }

    public static <D extends LambdaRootModel> void clear(D data) {
        if(DataUtil.isNull(data))
            return;

        data.clear();
    }

    public static String format(String message, LambdaRootModel m1) {
        return String.format("%s\n%s",message, DataUtil.prettyFormat(m1));
    }

    public static String format(String message, LambdaRootModel m1, LambdaRootModel m2) {
        return String.format("%s\n%s\n%s",message, DataUtil.prettyFormat(m1), DataUtil.prettyFormat(m2));
    }
}
