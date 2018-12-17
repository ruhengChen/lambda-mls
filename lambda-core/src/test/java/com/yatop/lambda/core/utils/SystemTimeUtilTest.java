package com.yatop.lambda.core.utils;

import com.yatop.lambda.FramewrokApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FramewrokApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@AutoConfigureMockMvc
public class SystemTimeUtilTest {

    @Autowired
    private SystemTimeUtil systemTimeUtil;

    @Test
    public void testDatabaseTime() {
        Timestamp timestamp = systemTimeUtil.getCurrentTimeMillis();
        System.out.println("getCurrentTimeMillis: " + timestamp);

        Date date = systemTimeUtil.getCurrentTime();
        System.out.println("getCurrentTime: " + date);
    }
}
