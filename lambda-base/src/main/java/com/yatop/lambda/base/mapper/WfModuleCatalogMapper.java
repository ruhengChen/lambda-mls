package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.WfModuleCatalog;
import com.yatop.lambda.base.model.WfModuleCatalogExample;
import com.yatop.lambda.base.utils.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WfModuleCatalogMapper extends MyMapper<WfModuleCatalog> {
    int countByExample(WfModuleCatalogExample example);

    int deleteByExample(WfModuleCatalogExample example);

    List<WfModuleCatalog> selectByExample(WfModuleCatalogExample example);

    int updateByExampleSelective(@Param("record") WfModuleCatalog record, @Param("example") WfModuleCatalogExample example);

    int updateByExample(@Param("record") WfModuleCatalog record, @Param("example") WfModuleCatalogExample example);
}