package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.SysParameter;
import com.yatop.lambda.base.model.SysParameterExample;
import com.yatop.lambda.base.utils.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysParameterMapper extends MyMapper<SysParameter> {
    int countByExample(SysParameterExample example);

    int deleteByExample(SysParameterExample example);

    List<SysParameter> selectByExample(SysParameterExample example);

    int updateByExampleSelective(@Param("record") SysParameter record, @Param("example") SysParameterExample example);

    int updateByExample(@Param("record") SysParameter record, @Param("example") SysParameterExample example);
}