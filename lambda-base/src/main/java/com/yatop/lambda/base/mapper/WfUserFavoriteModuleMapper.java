package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.WfUserFavoriteModule;
import com.yatop.lambda.base.model.WfUserFavoriteModuleExample;
import com.yatop.lambda.base.utils.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WfUserFavoriteModuleMapper extends MyMapper<WfUserFavoriteModule> {
    int countByExample(WfUserFavoriteModuleExample example);

    int deleteByExample(WfUserFavoriteModuleExample example);

    List<WfUserFavoriteModule> selectByExample(WfUserFavoriteModuleExample example);

    int updateByExampleSelective(@Param("record") WfUserFavoriteModule record, @Param("example") WfUserFavoriteModuleExample example);

    int updateByExample(@Param("record") WfUserFavoriteModule record, @Param("example") WfUserFavoriteModuleExample example);
}