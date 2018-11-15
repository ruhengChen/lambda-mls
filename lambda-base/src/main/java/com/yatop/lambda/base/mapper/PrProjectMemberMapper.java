package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.PrProjectMember;
import com.yatop.lambda.base.model.PrProjectMemberExample;
import com.yatop.lambda.base.utils.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PrProjectMemberMapper extends MyMapper<PrProjectMember> {
    int countByExample(PrProjectMemberExample example);

    int deleteByExample(PrProjectMemberExample example);

    List<PrProjectMember> selectByExample(PrProjectMemberExample example);

    int updateByExampleSelective(@Param("record") PrProjectMember record, @Param("example") PrProjectMemberExample example);

    int updateByExample(@Param("record") PrProjectMember record, @Param("example") PrProjectMemberExample example);
}