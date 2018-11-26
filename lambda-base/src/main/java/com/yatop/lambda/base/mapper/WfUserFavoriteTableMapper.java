package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.WfUserFavoriteTable;
import com.yatop.lambda.base.model.WfUserFavoriteTableExample;
import com.yatop.lambda.base.utils.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WfUserFavoriteTableMapper extends MyMapper<WfUserFavoriteTable> {
    int countByExample(WfUserFavoriteTableExample example);

    int deleteByExample(WfUserFavoriteTableExample example);

    List<WfUserFavoriteTable> selectByExample(WfUserFavoriteTableExample example);

    int updateByExampleSelective(@Param("record") WfUserFavoriteTable record, @Param("example") WfUserFavoriteTableExample example);

    int updateByExample(@Param("record") WfUserFavoriteTable record, @Param("example") WfUserFavoriteTableExample example);
}