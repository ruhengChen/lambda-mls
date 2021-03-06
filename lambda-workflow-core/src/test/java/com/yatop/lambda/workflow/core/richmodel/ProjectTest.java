package com.yatop.lambda.workflow.core.richmodel;

import com.yatop.lambda.LambdaApplication;
import com.yatop.lambda.core.mgr.table.DataWarehouseMgr;
import com.yatop.lambda.core.mgr.project.ProjectMgr;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LambdaApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProjectTest {

    @Autowired
    private ProjectMgr projectMgr;

    @Autowired
    private DataWarehouseMgr dataWarehouseMgr;

    @Test
    @Transactional
    @Rollback(true)
    public void testInsertProject() {
/*        PrProject project = projectMgr.queryProject(10002L);
        DwDataWarehouse dataWarehouse = dataWarehouseMgr.queryDataWarehouse(10000L);

        Project richProject = new Project(project);
        DataWarehouse richDataWarehouse = new DataWarehouse(dataWarehouse);
        richProject.setDataWarehouse(richDataWarehouse);

        String jsonStr = DataUtil.prettyFormat(richProject.toJSON());
        System.out.println("rich project: " + jsonStr);

        Project parseProject = JSON.parseObject(jsonStr, Project.class);
        System.out.println("parse project: " + DataUtil.prettyFormat(parseProject.toJSON()));*/
    }
}
