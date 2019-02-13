package com.yatop.lambda.portal.service;

import com.yatop.lambda.portal.common.domain.QueryRequest;
import com.yatop.lambda.portal.common.service.impl.BaseService;
import com.yatop.lambda.portal.model.Dict;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import java.util.ArrayList;
import java.util.List;

@Service("dictService")
@CacheConfig(cacheNames = "DictService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class DictService extends BaseService<Dict> {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Cacheable(key = "#p0.toString() + (#p1 != null ? #p1.toString() : '')")
	public List<Dict> findAllDicts(Dict dict, QueryRequest request) {
		try {
			Example example = new Example(Dict.class);
			Criteria criteria = example.createCriteria();
			if (StringUtils.isNotBlank(dict.getKeyy())) {
				criteria.andCondition("keyy=", Long.valueOf(dict.getKeyy()));
			}
			if (StringUtils.isNotBlank(dict.getValuee())) {
				criteria.andCondition("valuee=", dict.getValuee());
			}
			if (StringUtils.isNotBlank(dict.getTableName())) {
				criteria.andCondition("table_name=", dict.getTableName());
			}
			if (StringUtils.isNotBlank(dict.getFieldName())) {
				criteria.andCondition("field_name=", dict.getFieldName());
			}
			example.setOrderByClause("dict_id");
			return this.selectByExample(example);
		} catch (Exception e) {
			log.error("获取字典信息失败", e);
			return new ArrayList<>();
		}
	}

	@CacheEvict(allEntries = true)
	@Transactional
	public void addDict(Dict dict) {
		this.save(dict);
	}

	@CacheEvict(key = "#p0", allEntries = true)
	@Transactional
	public int deleteDicts(List<String> dictIds) {
		return this.batchDelete(dictIds, "dictId", Dict.class);

	}

	@CacheEvict(key = "#p0", allEntries = true)
	@Transactional
	public void updateDict(Dict dict) {
		this.updateNotNull(dict);
	}

	@Cacheable(key = "#p0")
	public Dict findById(Long dictId) {
		return this.selectByKey(dictId);
	}

}
