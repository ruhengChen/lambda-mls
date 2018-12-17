package com.yatop.lambda.core.utils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yatop.lambda.base.mapper.CfComponentMapper;
import com.yatop.lambda.base.model.CfComponent;
import com.yatop.lambda.base.model.CfComponentExample;
import com.yatop.lambda.FramewrokApplication;
import com.yatop.lambda.core.utils.DataUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FramewrokApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@AutoConfigureMockMvc
public class PageHelperTest {

    @Autowired
    private CfComponentMapper cfComponentMapper;

    @Test
    public void testQueryComponents() {

        PageHelper.startPage(1, 10, false);
        List<CfComponent> components =  cfComponentMapper.selectByExample(new CfComponentExample());
        System.out.println("components: " + DataUtil.prettyFormat(DataUtil.toJSONArray(components)));



        Page page = PageHelper.startPage(2, 10, true);
        components =  cfComponentMapper.selectByExample(new CfComponentExample());
        System.out.println("total component count: " + page.getTotal());
    }
}
