package com.yatop.lambda.portal.service;

import com.yatop.lambda.portal.common.domain.Tree;
import com.yatop.lambda.portal.common.service.impl.BaseService;
import com.yatop.lambda.portal.common.util.TreeUtils;
import com.yatop.lambda.portal.dao.DeptMapper;
import com.yatop.lambda.portal.model.Dept;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("deptService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class DeptService extends BaseService<Dept> {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private DeptMapper deptMapper;

	public Tree<Dept> getDeptTree() {
		List<Tree<Dept>> trees = new ArrayList<>();
		List<Dept> depts = this.findAllDepts(new Dept());
		depts.forEach(dept -> {
			Tree<Dept> tree = new Tree<>();
			tree.setId(dept.getDeptId().toString());
			tree.setParentId(dept.getParentId().toString());
			tree.setText(dept.getDeptName());
			trees.add(tree);
		});
		return TreeUtils.build(trees);
	}

	public List<Dept> findAllDepts(Dept dept) {
		try {
			Example example = new Example(Dept.class);
			if (StringUtils.isNotBlank(dept.getDeptName())) {
				example.createCriteria().andCondition("dept_name=", dept.getDeptName());
			}
			example.setOrderByClause("dept_id");
			return this.selectByExample(example);
		} catch (Exception e) {
			log.error("获取部门列表失败", e);
			return new ArrayList<>();
		}

	}

	public Dept findByName(String deptName) {
		Example example = new Example(Dept.class);
		example.createCriteria().andCondition("lower(dept_name) =", deptName.toLowerCase());
		List<Dept> list = this.selectByExample(example);
		return list.isEmpty() ? null : list.get(0);
	}

	@Transactional
	public void addDept(Dept dept) {
		Long parentId = dept.getParentId();
		if (parentId == null)
			dept.setParentId(0L);
		dept.setCreateTime(new Date());
		this.save(dept);
	}

	@Transactional
	public void deleteDepts(List<String> deptIds) {
		this.batchDelete(deptIds, "deptId", Dept.class);
		this.deptMapper.changeToTop(deptIds);
	}

	public Dept findById(Long deptId) {
		return this.selectByKey(deptId);
	}

	@Transactional
	public void updateDept(Dept dept) {
		this.updateNotNull(dept);
	}

}
