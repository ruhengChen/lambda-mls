package com.yatop.lambda.core.mgr.component.specification;

import com.yatop.lambda.base.model.CfCmptSpec;
import com.yatop.lambda.base.model.CfCmptSpecExample;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.mgr.base.BaseMgr;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.exception.LambdaException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CmptSpecMgr extends BaseMgr {

    /*
     *
     *   查询规格信息
     *   返回结果集
     *
     * */
    public List<CfCmptSpec> querySpecification() {

        try {
            CfCmptSpecExample example = new CfCmptSpecExample();
            example.createCriteria().andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            return  cfCmptSpecMapper.selectByExample(example);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.G_COMPUTE_DEFAULT_ERROR, "Query specification info failed.", "查询规格信息失败", e);
        }
    }
}
