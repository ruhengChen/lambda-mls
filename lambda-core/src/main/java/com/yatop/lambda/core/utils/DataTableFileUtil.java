package com.yatop.lambda.core.utils;

public class DataTableFileUtil {

    public static String getFilePath4General(String warehouseDir, Long tableId) {
        return String.format("%s/table_%d.dat", warehouseDir, tableId);
    }

    public static String getSummaryFilePath4General(String warehouseDir, Long tableId) {
        return String.format("%s/table_summary_%d.json", warehouseDir, tableId);
    }

    public static String getFilePath4Cached(String jobDir, Long taskId, Long tableId) {
        return String.format("%s/table_%d_%d.dat", jobDir, taskId, tableId);
    }

    public static String getSummaryFilePath4Cached(String jobDir, Long taskId, Long tableId) {
        return String.format("%s/table_summary_%d_%d.json", jobDir, taskId, tableId);
    }
}
