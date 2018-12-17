package com.yatop.lambda.core.mgr.experiment;

import com.yatop.lambda.base.model.EmExperiment;
import com.yatop.lambda.base.model.EmExperimentExample;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.mgr.base.BaseMgr;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.enums.ExperimentTypeEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.core.utils.PagerUtil;
import com.yatop.lambda.core.utils.SystemTimeUtil;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ExperimentMgr extends BaseMgr {

    /*
     *
     *   插入新实验信息（名称、类型、所属项目ID ...）
     *   返回插入记录
     *
     * */
    public EmExperiment insertExperiment(EmExperiment experiment, String operId) {
        if( DataUtil.isNull(experiment) ||
                experiment.isExperimentNameNotColoured() ||
                experiment.isExperimentTypeNotColoured() ||
                experiment.isOwnerProjectIdNotColoured() ||
                DataUtil.isEmpty(operId) ) {
            throw new LambdaException(LambdaExceptionEnum.C_EXPERMNT_DEFAULT_ERROR, "Insert experiment info failed -- invalid insert data.", "无效插入数据");
        }

        if(experiment.getExperimentType() == ExperimentTypeEnum.PREDICTION.getType()) {
            if(experiment.isMainExperimentIdNotColoured())
                throw new LambdaException(LambdaExceptionEnum.C_EXPERMNT_DEFAULT_ERROR, "Insert experiment info failed -- missing main-experiment-id.", "主实验ID缺失");

            if(experiment.isMainExperimentIdColoured() && existsPredictionExperiment(experiment.getOwnerProjectId(), experiment.getMainExperimentId())) {
                throw new LambdaException(LambdaExceptionEnum.C_EXPERMNT_DEFAULT_ERROR, "Insert experiment info failed -- prediction experiment existed.", "预测实验已存在");
            } else if(experiment.isMainExperimentIdColoured() && !existsProjectMember(experiment.getMainExperimentId())) {
                throw new LambdaException(LambdaExceptionEnum.C_EXPERMNT_DEFAULT_ERROR, "Insert experiment info failed -- main experiment not exists.", "主实验信息不存在");
            }
        }

        EmExperiment insertExperiment = new EmExperiment();
        try {
            Date dtCurrentTime = SystemTimeUtil.getCurrentTime();
            insertExperiment.copyProperties(experiment);
            insertExperiment.setExperimentIdColoured(false);
            insertExperiment.setStatus(DataStatusEnum.NORMAL.getStatus());
            insertExperiment.setLastUpdateTime(dtCurrentTime);
            insertExperiment.setLastUpdateOper(operId);
            insertExperiment.setCreateTime(dtCurrentTime);
            insertExperiment.setCreateOper(operId);
            emExperimentMapper.insertSelective(insertExperiment);

            if(experiment.getExperimentType() == ExperimentTypeEnum.MAIN.getType()) {
                EmExperiment updateExperiment = new EmExperiment();
                updateExperiment.setExperimentId(insertExperiment.getExperimentId());
                updateExperiment.setMainExperimentId(insertExperiment.getExperimentId());
                emExperimentMapper.updateByPrimaryKeySelective(updateExperiment);
            }
            return insertExperiment;
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.C_EXPERMNT_DEFAULT_ERROR, "Insert experiment info failed.", "插入实验信息失败", e);
        }
    }

    /*
     *
     *   逻辑删除实验信息
     *   返回删除数量
     *
     * */
    public int deleteExperiment(EmExperiment experiment, String operId) {
        if(DataUtil.isNull(experiment) || experiment.isExperimentIdNotColoured() || DataUtil.isEmpty(operId)){
            throw new LambdaException(LambdaExceptionEnum.C_EXPERMNT_DEFAULT_ERROR, "Delete experiment info failed -- invalid delete condition.", "无效删除条件");
        }

        try {
            EmExperiment deleteExperiment = new EmExperiment();
            deleteExperiment.setExperimentId(experiment.getExperimentId());
            deleteExperiment.setStatus(DataStatusEnum.INVALID.getStatus());
            deleteExperiment.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            deleteExperiment.setLastUpdateOper(operId);
            return emExperimentMapper.updateByPrimaryKeySelective(deleteExperiment);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.C_EXPERMNT_DEFAULT_ERROR, "Delete experiment info failed.", "删除实验信息失败", e);
        }
    }

    /*
     *
     *   更新实验信息（实验名称、DFS实验目录、本地实验目录）
     *   返回更新数量
     *
     * */
    public int updateExperiment(EmExperiment experiment, String operId) {
        if( DataUtil.isNull(experiment) || experiment.isExperimentIdNotColoured() || DataUtil.isEmpty(operId)) {
            throw new LambdaException(LambdaExceptionEnum.C_EXPERMNT_DEFAULT_ERROR, "Update experiment info failed -- invalid update condition.", "无效更新条件");
        }

        if(experiment.isExperimentNameNotColoured() &&
                experiment.isExperimentDfsDirNotColoured() &&
                experiment.isExperimentLocalDirNotColoured() &&
                experiment.isSummaryNotColoured() &&
                experiment.isDescriptionNotColoured() ) {
            throw new LambdaException(LambdaExceptionEnum.C_EXPERMNT_DEFAULT_ERROR, "Update experiment info failed -- invalid update data.", "无效更新内容");
        }

        EmExperiment updateExperiment = new EmExperiment();
        try {
            updateExperiment.setExperimentId(experiment.getExperimentId());
            if(experiment.isExperimentNameColoured())
                updateExperiment.setExperimentName(experiment.getExperimentName());
            if(experiment.isExperimentDfsDirColoured())
                updateExperiment.setExperimentDfsDir(experiment.getExperimentDfsDir());
            if(experiment.isExperimentLocalDirColoured())
                updateExperiment.setExperimentLocalDir(experiment.getExperimentLocalDir());
            if(experiment.isSummaryColoured())
                updateExperiment.setSummary(experiment.getSummary());
            if(experiment.isDescriptionColoured())
                updateExperiment.setDescription(experiment.getDescription());

            updateExperiment.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            updateExperiment.setLastUpdateOper((operId));
            return emExperimentMapper.updateByPrimaryKeySelective(updateExperiment);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.C_EXPERMNT_DEFAULT_ERROR, "Update experiment info failed.", "更新实验信息失败", e);
        }
    }

    /*
     *
     *   查询实验信息（按ID）
     *   返回结果
     *
     * */
    public EmExperiment queryExperiment(Long id) {
        if(DataUtil.isNull(id)){
            throw new LambdaException(LambdaExceptionEnum.C_EXPERMNT_DEFAULT_ERROR, "Query experiment info failed -- invalid query condition.", "无效查询条件");
        }

        EmExperiment experiment;
        try {
            experiment = emExperimentMapper.selectByPrimaryKey(id);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.C_EXPERMNT_DEFAULT_ERROR, "Query experiment info failed.", "查询实验信息失败", e);
        }

        if(DataUtil.isNull(experiment) || (experiment.getStatus() == DataStatusEnum.INVALID.getStatus()))
            throw new LambdaException(LambdaExceptionEnum.C_EXPERMNT_DEFAULT_ERROR, "Query experiment info failed -- invalid status or not found.", "已删除或未查找到");

        return experiment;
    }

    /*
     *
     *   查询实验信息（仅主实验类型）
     *   返回结果集
     *
     * */
    public List<EmExperiment> queryExperiment(Long projectId, PagerUtil pager) {
        if(DataUtil.isNull(projectId)){
            throw new LambdaException(LambdaExceptionEnum.C_EXPERMNT_DEFAULT_ERROR, "Query experiment info failed -- invalid query condition.", "无效查询条件");
        }

        try {
            PagerUtil.startPage(pager);
            EmExperimentExample example = new EmExperimentExample();
            example.createCriteria().andOwnerProjectIdEqualTo(projectId).andExperimentTypeEqualTo(ExperimentTypeEnum.MAIN.getType()).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            example.setOrderByClause("CREATE_TIME ASC");
            return emExperimentMapper.selectByExample(example);
        } catch (Throwable e) {
            PagerUtil.clearPage(pager);
            throw new LambdaException(LambdaExceptionEnum.C_EXPERMNT_DEFAULT_ERROR, "Query experiment info failed.", "查询实验信息失败", e);
        }
    }

    /*
     *
     *   查询实验信息（仅主实验类型）（按关键字）
     *   返回结果集
     *
     * */
    public List<EmExperiment> queryExperiment(Long projectId, String keyword, PagerUtil pager) {
        if(DataUtil.isNull(projectId) || DataUtil.isEmpty(keyword)){
            throw new LambdaException(LambdaExceptionEnum.C_EXPERMNT_DEFAULT_ERROR, "Query experiment info failed -- invalid query condition.", "无效查询条件");
        }

        try {
            PagerUtil.startPage(pager);
            String keywordLike = "%" + keyword + "%";
            EmExperimentExample example = new EmExperimentExample();
            example.createCriteria().andOwnerProjectIdEqualTo(projectId).andExperimentTypeEqualTo(ExperimentTypeEnum.MAIN.getType()).andExperimentNameLike(keywordLike).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            example.setOrderByClause("CREATE_TIME ASC");
            return emExperimentMapper.selectByExample(example);
        } catch (Throwable e) {
            PagerUtil.clearPage(pager);
            throw new LambdaException(LambdaExceptionEnum.C_EXPERMNT_DEFAULT_ERROR, "Query experiment info failed.", "查询实验信息失败", e);
        }
    }

    /*
     *
     *   查询预测实验信息
     *   返回结果集
     *
     * */
    public EmExperiment queryPredictionExperiment(Long projectId, Long mainExperimentId) {
        if(DataUtil.isNull(projectId) || DataUtil.isNull(mainExperimentId)){
            throw new LambdaException(LambdaExceptionEnum.C_EXPERMNT_DEFAULT_ERROR, "Query prediction experiment info failed -- invalid query condition.", "无效查询条件");
        }

        try {
            EmExperimentExample example = new EmExperimentExample();
            example.createCriteria().andOwnerProjectIdEqualTo(projectId).andExperimentTypeEqualTo(ExperimentTypeEnum.PREDICTION.getType()).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            List<EmExperiment> resultList = emExperimentMapper.selectByExample(example);
            return DataUtil.isNotEmpty(resultList) ? resultList.get(0) : null;
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.C_EXPERMNT_DEFAULT_ERROR, "Query prediction experiment info failed.", "查询预测实验信息失败", e);
        }
    }

    /*
     *
     *   检查实验是否已存在
     *   返回是否已存在
     *
     * */
    public boolean existsProjectMember(Long ExperimentId)  {
        if(DataUtil.isNull(ExperimentId))
            throw new LambdaException(LambdaExceptionEnum.C_EXPERMNT_DEFAULT_ERROR, "Check experiment exists failed -- invalid check condition.", "无效检查条件");

        try {
            EmExperimentExample example = new EmExperimentExample();
            example.createCriteria().andExperimentIdEqualTo(ExperimentId).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            return emExperimentMapper.countByExample(example) > 0 ? true : false;
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.C_EXPERMNT_DEFAULT_ERROR, "Check experiment exists failed.", "检查已存在实验失败", e);
        }
    }

    /*
     *
     *   检查预测实验是否已存在
     *   返回是否存在
     *
     * */
    public boolean existsPredictionExperiment(Long projectId, Long mainExperimentId)  {
        if(DataUtil.isNull(projectId) && DataUtil.isNull(mainExperimentId))
            throw new LambdaException(LambdaExceptionEnum.C_EXPERMNT_DEFAULT_ERROR, "Check prediction experiment exists failed -- invalid check condition.", "无效检查条件");

        try {
            EmExperimentExample example = new EmExperimentExample();
            example.createCriteria().andOwnerProjectIdEqualTo(projectId)
                    .andMainExperimentIdEqualTo(mainExperimentId).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            return emExperimentMapper.countByExample(example) > 0 ? true : false;
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.C_EXPERMNT_DEFAULT_ERROR, "Check prediction experiment exists failed.", "检查已存在预测实验失败", e);
        }
    }
}
