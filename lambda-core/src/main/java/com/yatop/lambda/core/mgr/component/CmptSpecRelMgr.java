package com.yatop.lambda.core.mgr.component;

import com.yatop.lambda.base.model.CfCmptSpecRel;
import com.yatop.lambda.base.model.CfCmptSpecRelExample;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.mgr.base.BaseMgr;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.exception.LambdaException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CmptSpecRelMgr extends BaseMgr {

    /*
     *
     *   查询组件使用规格
     *   返回结果集
     *
     * */
    public List<CfCmptSpecRel> queryCmptSpecRel() {

        try {
            CfCmptSpecRelExample example = new CfCmptSpecRelExample();
            example.createCriteria().andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            return  cfCmptSpecRelMapper.selectByExample(example);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.G_COMPUTE_DEFAULT_ERROR, "Query component specification relation failed.", "查询组件使用规格失败", e);
        }
    }
}
