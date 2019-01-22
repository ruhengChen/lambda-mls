package com.yatop.lambda.portal.dao;


import com.yatop.lambda.portal.common.config.MyMapper;
import com.yatop.lambda.portal.model.Dept;

import java.util.List;

public interface DeptMapper extends MyMapper<Dept> {
	
	// 删除父节点，子节点变成顶级节点（根据实际业务调整）
	void changeToTop(List<String> deptIds);
}