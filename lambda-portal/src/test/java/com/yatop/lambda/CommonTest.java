package com.yatop.lambda;

import com.yatop.lambda.portal.service.DeptService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LambdaApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class CommonTest {

    @Autowired
    DeptService deptService;

    @Test
    public void testMethod() {
        try {
            //StackTraceElement[] e = Thread.currentThread().getStackTrace();
            //System.out.println(Thread.currentThread() .getStackTrace()[1].getClassName() + "." + Thread.currentThread() .getStackTrace()[1].getMethodName());
            System.out.println(deptService.getDeptTree().toString());
        } catch (Throwable e) {
        }
    }
}
