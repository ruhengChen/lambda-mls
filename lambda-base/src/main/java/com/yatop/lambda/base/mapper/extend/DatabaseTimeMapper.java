package com.yatop.lambda.base.mapper.extend;

import org.apache.ibatis.annotations.Select;

import java.sql.Timestamp;
import java.util.Date;


public interface DatabaseTimeMapper {
    /**
     * 获取数据库当前毫秒时间
     *
     * @return 数据库当前毫秒时间
     */
    @Select("select current_timestamp(3)")
    Timestamp getCurrentTimestamp();

    /**
     * 获取数据库当前时间
     *
     * @return 数据库当前时间
     */
    @Select("select now()")
    Date getCurrentTime();
}
