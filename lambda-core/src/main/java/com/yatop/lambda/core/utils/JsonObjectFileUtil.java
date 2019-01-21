package com.yatop.lambda.core.utils;

public class JsonObjectFileUtil {

    public static String getFilePath4Report(String jobDir, String reportNamePrefix, Long jsonObjectId) {
        return String.format("%s/%s_%d.json", jobDir, reportNamePrefix, jsonObjectId);
    }
}
