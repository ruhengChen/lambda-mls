package com.yatop.lambda.core.mgr.experiment;

import com.yatop.lambda.base.mapper.extend.ExperimentTemplateMapper;
import com.yatop.lambda.base.model.EmExperimentTemplate;
import com.yatop.lambda.base.model.EmExperimentTemplateExample;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.mgr.base.BaseMgr;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.core.utils.PagerUtil;
import com.yatop.lambda.core.utils.SystemTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ExperimentTemplateMgr extends BaseMgr {

    @Autowired
    ExperimentTemplateMapper experimentTemplateMapper;

    /*
     *
     *   插入新实验模版信息（名称、序号、内容、概要、描述）
     *   返回插入记录
     *
     * */
    public EmExperimentTemplate insertExperimentTemplate(EmExperimentTemplate template, String operId) {
        if( DataUtil.isNull(template) ||
                template.isTemplateNameNotColoured() ||
                template.isSequenceNotColoured() ||
                template.isTemplateContentNotColoured() ||
                template.isSummaryNotColoured() ||
                template.isDescriptionNotColoured() ||
                DataUtil.isEmpty(operId) ) {
            throw new LambdaException(LambdaExceptionEnum.C_EXPERMNT_DEFAULT_ERROR, "Insert experiment template info failed -- invalid insert data.", "无效插入数据");
        }

        EmExperimentTemplate insertTemplate = new EmExperimentTemplate();
        try {
            Date dtCurrentTime = SystemTimeUtil.getCurrentTime();
            insertTemplate.copyProperties(template);
            insertTemplate.setTemplateIdColoured(false);
            insertTemplate.setTemplateCount(0L);
            insertTemplate.setStatus(DataStatusEnum.NORMAL.getStatus());
            insertTemplate.setLastUpdateTime(dtCurrentTime);
            insertTemplate.setLastUpdateOper(operId);
            insertTemplate.setCreateTime(dtCurrentTime);
            insertTemplate.setCreateOper(operId);
            emExperimentTemplateMapper.insertSelective(insertTemplate);
            return insertTemplate;
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.C_EXPERMNT_DEFAULT_ERROR, "Insert experiment template info failed.", "插入实验模版信息失败", e);
        }
    }

    /*
     *
     *   逻辑删除实验模版信息
     *   返回删除数量
     *
     * */
    public int deleteDataTemplate(Long templateId, String operId) {
        if(DataUtil.isNull(templateId) || DataUtil.isEmpty(operId)){
            throw new LambdaException(LambdaExceptionEnum.C_EXPERMNT_DEFAULT_ERROR, "Delete experiment template info failed -- invalid delete condition.", "无效删除条件");
        }

        try {
            EmExperimentTemplate deleteTemplate = new EmExperimentTemplate();
            deleteTemplate.setTemplateId(templateId);
            deleteTemplate.setStatus(DataStatusEnum.INVALID.getStatus());
            deleteTemplate.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            deleteTemplate.setLastUpdateOper(operId);
            return emExperimentTemplateMapper.updateByPrimaryKeySelective(deleteTemplate);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.C_EXPERMNT_DEFAULT_ERROR, "Delete experiment template info failed.", "删除实验模版信息失败", e);
        }
    }

    /*
     *
     *   更新实验模版信息（名称、序号、模版内容、概要、描述）
     *   返回更新数量
     *
     * */
    public int updateDataTemplate(EmExperimentTemplate template, String operId) {
        if( DataUtil.isNull(template) || DataUtil.isNull(template.getTemplateId()) || DataUtil.isEmpty(operId)) {
            throw new LambdaException(LambdaExceptionEnum.C_EXPERMNT_DEFAULT_ERROR, "Update experiment template info failed -- invalid update condition.", "无效更新条件");
        }

        if(template.isTemplateNameNotColoured() &&
                template.isSequenceNotColoured() &&
                template.isTemplateContentNotColoured() &&
                template.isSummaryNotColoured() &&
                template.isDescriptionNotColoured()) {
            throw new LambdaException(LambdaExceptionEnum.C_EXPERMNT_DEFAULT_ERROR, "Update experiment template info failed -- invalid update data.", "无效更新内容");
        }

        EmExperimentTemplate updateTemplate = new EmExperimentTemplate();
        try {
            updateTemplate.setTemplateId(template.getTemplateId());
            if(template.isTemplateNameColoured())
                updateTemplate.setTemplateName(template.getTemplateName());
            if(template.isSequenceColoured())
                updateTemplate.setSequence(template.getSequence());
            if(template.isTemplateContentColoured())
                updateTemplate.setTemplateContent(template.getTemplateContent());
            if(template.isSummaryColoured())
                updateTemplate.setSummary(template.getSummary());
            if(template.isDescriptionColoured())
                updateTemplate.setDescription(template.getDescription());

            updateTemplate.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            updateTemplate.setLastUpdateOper((operId));

            template.setLastUpdateTime(updateTemplate.getLastUpdateTime());
            template.setLastUpdateOper(updateTemplate.getLastUpdateOper());
            return emExperimentTemplateMapper.updateByPrimaryKeySelective(updateTemplate);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.C_EXPERMNT_DEFAULT_ERROR, "Update experiment template info failed.", "更新实验模版信息失败", e);
        }
    }

    /*
     *
     *   查询实验模版信息（按ID）
     *   返回结果
     *
     * */
    public EmExperimentTemplate queryDataTemplate(Long id) {
        if(DataUtil.isNull(id)){
            throw new LambdaException(LambdaExceptionEnum.C_EXPERMNT_DEFAULT_ERROR, "Query experiment template info failed -- invalid query condition.", "无效查询条件");
        }

        EmExperimentTemplate template;
        try {
            template = emExperimentTemplateMapper.selectByPrimaryKey(id);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.C_EXPERMNT_DEFAULT_ERROR, "Query experiment template info failed.", "查询实验模版信息失败", e);
        }

        if(DataUtil.isNull(template) || (template.getStatus() == DataStatusEnum.INVALID.getStatus()))
            throw new LambdaException(LambdaExceptionEnum.C_EXPERMNT_DEFAULT_ERROR, "Query experiment template info failed -- invalid status or not found.", "已删除或未查找到");

        return template;
    }

    /*
     *
     *   查询实验模版信息（按关键字）
     *   返回结果集
     *
     * */
    public List<EmExperimentTemplate> queryDataTemplate(String keyword, PagerUtil pager) {
        if(DataUtil.isEmpty(keyword)){
            throw new LambdaException(LambdaExceptionEnum.C_EXPERMNT_DEFAULT_ERROR, "Query experiment template info failed -- invalid query condition.", "无效查询条件");
        }

        try {
            PagerUtil.startPage(pager);
            String keywordLike = "%" + keyword + "%";
            EmExperimentTemplateExample example = new EmExperimentTemplateExample();
            example.createCriteria().andTemplateNameLike(keywordLike).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            example.setOrderByClause("CREATE_TIME ASC");
            return emExperimentTemplateMapper.selectByExample(example);
        } catch (Throwable e) {
            PagerUtil.clearPage(pager);
            throw new LambdaException(LambdaExceptionEnum.C_EXPERMNT_DEFAULT_ERROR, "Query experiment template info failed.", "查询实验模版信息失败", e);
        }
    }

    /*
     *
     *   实验模版计数增加
     *   返回更新数量
     *
     * */
    public int increaseTemplateCount(Long templateId, String operId) {
        if(DataUtil.isNull(templateId) || DataUtil.isEmpty(operId)){
            throw new LambdaException(LambdaExceptionEnum.C_EXPERMNT_DEFAULT_ERROR, "Experiment template count plus one -- invalid plus condition.", "无效计数条件");
        }

        try {
           return experimentTemplateMapper.increaseTemplateCount(templateId, SystemTimeUtil.getCurrentTime(), operId);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.C_EXPERMNT_DEFAULT_ERROR, "Experiment template count plus one.", "实验模版计数加一失败", e);
        }
    }
}
