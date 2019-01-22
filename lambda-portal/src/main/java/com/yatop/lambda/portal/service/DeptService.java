package com.yatop.lambda.portal.service;


import com.yatop.lambda.portal.common.domain.Tree;
import com.yatop.lambda.portal.common.service.IService;
import com.yatop.lambda.portal.model.Dept;

import java.util.List;

public interface DeptService extends IService<Dept> {

	Tree<Dept> getDeptTree();

	List<Dept> findAllDepts(Dept dept);

	Dept findByName(String deptName);

	Dept findById(Long deptId);
	
	void addDept(Dept dept);
	
	void updateDept(Dept dept);

	void deleteDepts(String deptIds);
}
