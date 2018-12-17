package com.yatop.lambda.core.mgr.component;

import com.yatop.lambda.base.model.CfCmptCharValue;
import com.yatop.lambda.base.model.CfCmptCharValueExample;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.mgr.base.BaseMgr;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.exception.LambdaException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CmptCharValueMgr extends BaseMgr {

    /*
     *
     *   查询组件特征值
     *   返回结果集
     *
     * */
    public List<CfCmptCharValue> queryCmptCharValue() {

        try {
            CfCmptCharValueExample example = new CfCmptCharValueExample();
            example.createCriteria().andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            return  cfCmptCharValueMapper.selectByExample(example);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.G_COMPUTE_DEFAULT_ERROR, "Query component characteristic value failed.", "查询组件特征值失败", e);
        }
    }
}
