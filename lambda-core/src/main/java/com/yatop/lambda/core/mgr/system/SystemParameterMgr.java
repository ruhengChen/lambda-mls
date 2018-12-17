package com.yatop.lambda.core.mgr.system;

import com.yatop.lambda.base.model.SysParameter;
import com.yatop.lambda.base.model.SysParameterExample;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.mgr.base.BaseMgr;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.exception.LambdaException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SystemParameterMgr extends BaseMgr {

    /*
     *
     *   查询系统参数
     *   返回结果集
     *
     * */
    public List<SysParameter> querySystemParameter() {

        try {
            SysParameterExample example = new SysParameterExample();
            example.createCriteria().andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            return sysParameterMapper.selectByExample(example);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.A_SYSTEM_DEFAULT_ERROR, "Query algorithm info failed.", "查询算法信息失败", e);
        }
    }
}
