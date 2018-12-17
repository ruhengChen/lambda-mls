package com.yatop.lambda.core.mgr.project;

import com.yatop.lambda.FramewrokApplication;
import com.yatop.lambda.base.model.PrProject;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.core.utils.PagerUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = FramewrokApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@AutoConfigureMockMvc
public class ProjectMgrTest {

    @Autowired
    private ProjectMgr projectMgr;

    @Test
    @Transactional
    @Rollback(true)
    public void testInsertProject() {
        PrProject project = new PrProject();
        project.setProjectCode("XXOO");
        project.setProjectName("Alpha");
        project.setDwId(999L);
        project.setMwId(999L);

        project = projectMgr.insertProject(project, "admin");
        System.out.println("project: " + DataUtil.prettyFormat(project.toJSON()));
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testUpdateProject() {
/*        PrProject project = new PrProject();
        project.setProjectId(100091L);
        project.setProjectCode("XXOO71");
        project.setProjectName("Alpha71");
        project.setDwId(999L);
        project.setMwId(999L);
        project.setDescription("hohoho,agagaga");

        int affectRows = projectMgr.updateProjectById(project, "admin");
        List<PrProject> list = projectMgr.queryProject(new ArrayList(Arrays.asList(100091L)));
        System.out.println("project: " + DataUtil.prettyFormat(list));*/
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testQueryProject() {
/*        List<Long>  list = new ArrayList<Long>(Arrays.asList(10007L,10008L,10009L,100021L,100031L,100041L,100051L,100061L,100071L));

        List<PrProject> prList = projectMgr.queryProjectByIds(list);
        System.out.println("project: " + DataUtil.prettyFormat(prList));*/
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testDeleteProject() {
/*        List<Long>  list = new ArrayList<Long>(Arrays.asList(10007L,10008L,10009L,100021L,100031L,100041L,100051L,100061L,100071L));

        int affectRows = projectMgr.deleteProject(list, "admin");
        System.out.println("list: " + list.size() + ", affect rows: " + affectRows);*/
    }

/*    @Test
    @Transactional
    @Rollback(true)
    public void testPhysicalDeleteProject() {
        List<Long>  list = new ArrayList<Long>(Arrays.asList(10007L,10008L,10009L,100021L,100031L,100041L,100051L,100061L,100071L));

        int affectRows = projectMgr.physicalDeleteProject(list);
        System.out.println("list: " + list.size() + ", affect rows: " + affectRows);
    }*/

    @Test
    @Transactional
    @Rollback(true)
    public void testQueryProjectMixed() {

        PagerUtil page = new PagerUtil(1, 20);
        List<PrProject> prList= projectMgr.queryProjectExt("O", "", page);
        System.out.println("project: " + DataUtil.prettyFormat(prList));
        System.out.println("total count: " + page.getTotalCount());
    }
}
