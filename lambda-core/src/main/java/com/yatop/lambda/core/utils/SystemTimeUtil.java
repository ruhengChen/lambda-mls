package com.yatop.lambda.core.utils;

import com.yatop.lambda.base.extend.mapper.DatabaseTimeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;

@Component
public class SystemTimeUtil {

    static private DatabaseTimeMapper databaseTimeMapper;

    @Autowired
    public void setDatabaseTimeMapper(DatabaseTimeMapper databaseTimeMapper) {
        SystemTimeUtil.databaseTimeMapper = databaseTimeMapper;
    }

    static public Timestamp getCurrentTimeMillis() {
        return databaseTimeMapper.getCurrentTimestamp();
    }

    static public Date getCurrentTime() {
        return databaseTimeMapper.getCurrentTime();
    }
}
