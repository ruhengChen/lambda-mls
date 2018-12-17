package com.yatop.lambda.core.mgr.component.characteristic;

import com.yatop.lambda.base.model.CfCmptCharEnum;
import com.yatop.lambda.base.model.CfCmptCharEnumExample;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.mgr.base.BaseMgr;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.exception.LambdaException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CmptCharEnumMgr extends BaseMgr {

    /*
     *
     *   查询特征枚举信息
     *   返回结果集
     *
     * */
    public List<CfCmptCharEnum> queryCharTypeEnum() {

        try {
            CfCmptCharEnumExample example = new CfCmptCharEnumExample();
            example.createCriteria().andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            return  cfCmptCharEnumMapper.selectByExample(example);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.G_COMPUTE_DEFAULT_ERROR, "Query characteristic enumeration info failed.", "查询特征枚举信息失败", e);
        }
    }
}
