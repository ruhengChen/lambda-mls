package com.yatop.lambda.core.utils;

import org.junit.Test;

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = FramewrokApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@AutoConfigureMockMvc
public class CommonTest {

    //@Autowired
    //ProjectMgr projectMgr;

    @Test
    public void testMethod() {
/*        try {
            //StackTraceElement[] e = Thread.currentThread().getStackTrace();
            //System.out.println(Thread.currentThread() .getStackTrace()[1].getClassName() + "." + Thread.currentThread() .getStackTrace()[1].getMethodName());
            System.out.println(ErrorMessage.generateErrorMessage("test"));
            throw new Exception("hahaha");
        } catch (Throwable e) {
            System.out.println(ErrorMessage.generateErrorMessage("exception"));
        }*/

        /*try {
            projectMgr.createProject(null);
        } catch (Throwable e) {
            e.printStackTrace();
        }*/

        System.out.println("substring: " + "abc".substring(0,0).length());
    }
}
