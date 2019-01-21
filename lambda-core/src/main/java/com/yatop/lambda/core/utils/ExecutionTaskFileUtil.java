package com.yatop.lambda.core.utils;

public class ExecutionTaskFileUtil {

    public static String getFilePath4SubmitFile(String jobDir, Long taskId, String moduleCode) {
        return String.format("%s/submit_%d_%s.json", jobDir, taskId, moduleCode);
    }

    public static String getFilePath4ReturnFile(String jobDir, Long taskId, String moduleCode) {
        return String.format("%s/return_%d_%s.json", jobDir, taskId, moduleCode);
    }

    public static String getFilePath4LogFile(String jobDir, Long taskId, String moduleCode) {
        return String.format("%s/log_%d_%s.json", jobDir, taskId, moduleCode);
    }
}
