package com.yatop.lambda.core.mgr.component.characteristic;

import com.yatop.lambda.base.model.CfCmptCharType;
import com.yatop.lambda.base.model.CfCmptCharTypeExample;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.mgr.base.BaseMgr;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.exception.LambdaException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CmptCharTypeMgr extends BaseMgr {

    /*
     *
     *   查询特征类型信息
     *   返回结果集
     *
     * */
    public List<CfCmptCharType> queryCharType() {

        try {
            CfCmptCharTypeExample example = new CfCmptCharTypeExample();
            example.createCriteria().andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            return  cfCmptCharTypeMapper.selectByExample(example);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.G_COMPUTE_DEFAULT_ERROR, "Query characteristic type info failed.", "查询特征类型信息失败", e);
        }
    }
}
