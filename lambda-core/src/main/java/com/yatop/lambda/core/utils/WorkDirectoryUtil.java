package com.yatop.lambda.core.utils;

import com.yatop.lambda.core.enums.SystemParameterEnum;

public class WorkDirectoryUtil {

    public static String getWorkFLowDfsDirectory(Long projectId, Long flowId) {
        String dfsWorkRoot = SystemParameterUtil.find4String(SystemParameterEnum.CF_HDFS_WORK_ROOT);
        String flowFileDir = SystemParameterUtil.find4String(SystemParameterEnum.CF_FLOW_FILE_DIR_NAME);
        return String.format("%s/%s/%d/%d", dfsWorkRoot, flowFileDir, projectId, flowId);
    }

    public static String getWorkFLowLocalDirectory(Long projectId, Long flowId) {
        String localWorkRoot = SystemParameterUtil.find4String(SystemParameterEnum.CF_LOCAL_WORK_ROOT);
        String flowFileDir = SystemParameterUtil.find4String(SystemParameterEnum.CF_FLOW_FILE_DIR_NAME);
        return String.format("%s/%s/%d/%d", localWorkRoot, flowFileDir, projectId, flowId);
    }
}
