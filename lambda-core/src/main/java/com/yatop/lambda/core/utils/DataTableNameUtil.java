package com.yatop.lambda.core.utils;

import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.exception.LambdaException;

public class DataTableNameUtil {

    public static boolean existsDatabaseName(String tableFullName) {
        return tableFullName.indexOf(".") > 0 ? true : false;
    }

    //Array[0]:database name, Array[1]:table name
    public static String[] parseTableFullName(String tableFullName) {
        String [] partitions = tableFullName.split("\\.");
        if(partitions.length != 2) {
            throw new LambdaException(LambdaExceptionEnum.D_DATA_DEFAULT_ERROR, "Parse data table full name failed -- Illegal full name.", String.format("非法数据表全名:%s", tableFullName));
        }
        return partitions;
    }
}
