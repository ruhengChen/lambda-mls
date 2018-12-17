package com.yatop.lambda.core.concurrent;

import com.yatop.lambda.FramewrokApplication;
import com.yatop.lambda.core.concurrent.workflow.WorkflowNamedLockServiceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FramewrokApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WorkflowNamedLockServiceTest implements Runnable {

    @Autowired
    WorkflowNamedLockServiceService workflowNamedLock;

    private int generator = 0;

    @Override
    public void run(){

        try {
            Thread.sleep(500);
        } catch (Throwable e) {

        }

        long[] testArray = {11L, 22L, 33L, 44L, 55L, 66L, 77L, 88L};
        Random random =  new Random(++generator);
        int success = 0;
        int failed = 0;
        int iterator = 0;
        Long startm = System.currentTimeMillis();
        Date start = new Date(startm);

        for(int i = 0; i < 8192; i++){
            try {
                ++iterator;

                long resource = testArray[Math.abs(random.nextInt()%8)];
                if(workflowNamedLock.requestResource(resource))
                    ++success;
                 else
                     ++failed;
                //System.out.println("Request " + resource + " -- " +  (workflowNamedLock.requestResource(resource) ? "success" : "failed"));

                //this.wait(188);
                workflowNamedLock.releaseResource();
            }catch (Throwable e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
        ;
        Long endm = System.currentTimeMillis();
        Date end = new Date(endm);
        float cost = endm - startm;
        cost = cost / 1000;
        System.out.println("Iterator " + iterator + " -- " +"Success " + success + " -- " + "failed " + failed + " -- " + "cost " + cost + "second");
    }

    @Test
    public void testWorkflowNamedLock(){
        try {
            for(int i = 0; i < 20; i++) {
                Thread thread = new Thread(this);
                thread.start();
            }
            synchronized (this) {
                this.wait(10 * 1000);
            }
        } catch (Throwable e) {

        }
    }
}
