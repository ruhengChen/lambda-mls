package com.yatop.lambda.core.mgr.model;

import com.yatop.lambda.base.model.MwModel;
import com.yatop.lambda.base.model.MwModelExample;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.mgr.base.BaseMgr;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.enums.ModelTypeEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.core.utils.PagerUtil;
import com.yatop.lambda.core.utils.SystemTimeUtil;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ModelMgr extends BaseMgr {

    /*
     *
     *   插入新模型信息（表名、类型、所属模型仓库ID、引用算法ID、模型状态 ...）
     *   返回插入记录
     *
     * */
    public MwModel insertModel(MwModel model, String operId) {
        if( DataUtil.isNull(model) ||
                model.isModelNameNotColoured() ||
                model.isModelTypeNotColoured() ||
                model.isOwnerMwIdNotColoured() ||
                model.isRefAlgorithmIdNotColoured() ||
                model.isModelStateNotColoured() ||
                DataUtil.isEmpty(operId) ) {
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Insert model info failed -- invalid insert data.", "无效插入数据");
        }

        if(existsModel(model.getOwnerMwId(), model.getModelName(), null)) {
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Insert model info failed -- name conflict.", "模型名称冲突");
        }

        MwModel insertModel = new MwModel();
        try {
            Date dtCurrentTime = SystemTimeUtil.getCurrentTime();
            insertModel.copyProperties(model);
            insertModel.setModelIdColoured(false);
            insertModel.setStatus(DataStatusEnum.NORMAL.getStatus());
            insertModel.setLastUpdateTime(dtCurrentTime);
            insertModel.setLastUpdateOper(operId);
            insertModel.setCreateTime(dtCurrentTime);
            insertModel.setCreateOper(operId);
            mwModelMapper.insertSelective(insertModel);
            return insertModel;
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Insert model info failed.", "插入模型信息失败", e);
        }
    }

    /*
     *
     *   逻辑删除模型信息
     *   返回删除数量
     *
     * */
    public int deleteModel(MwModel model, String operId) {
        if(DataUtil.isNull(model) || model.isModelIdNotColoured() || DataUtil.isEmpty(operId)){
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Delete model info failed -- invalid delete condition.", "无效删除条件");
        }

        try {
            MwModel deleteModel = new MwModel();
            deleteModel.setModelId(model.getModelId());
            deleteModel.setStatus(DataStatusEnum.INVALID.getStatus());
            deleteModel.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            deleteModel.setLastUpdateOper(operId);
            return mwModelMapper.updateByPrimaryKeySelective(deleteModel);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Delete model info failed.", "删除模型信息失败", e);
        }
    }

    /*
     *
     *   更新模型名称
     *   返回更新数量
     *
     * */
    public int updateModelName(MwModel model, String operId) {
        if( DataUtil.isNull(model) || model.isModelIdNotColoured() || DataUtil.isEmpty(operId)) {
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Update model name failed -- invalid update condition.", "无效更新条件");
        }

        if(model.isModelNameNotColoured()) {
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Update model name failed -- invalid update data.", "无效更新内容");
        }

        if(existsModel(model.getOwnerMwId(), model.getModelName(), model.getModelId())) {
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Update model name failed -- name conflict.", "名称冲突");
        }

        MwModel updateModel = new MwModel();
        try {
            updateModel.setModelId(model.getModelId());
            if(model.isModelNameColoured())
                updateModel.setModelName(model.getModelName());

            updateModel.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            updateModel.setLastUpdateOper((operId));
            return mwModelMapper.updateByPrimaryKeySelective(updateModel);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Update model name failed.", "更新模型名称失败", e);
        }
    }

    /*
     *
     *   更新模型信息（模型文件大小、模型文件名、模型概要文件名、模型状态、描述）
     *   返回更新数量
     *
     * */
    public int updateModel(MwModel model, String operId) {
        if( DataUtil.isNull(model) || model.isModelIdNotColoured() || DataUtil.isEmpty(operId)) {
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Update model info failed -- invalid update condition.", "无效更新条件");
        }

        if(model.isModelFileSizeNotColoured() &&
                model.isModelFileNotColoured() &&
                model.isModelSummaryFileNotColoured() &&
                model.isModelStateNotColoured() &&
                model.isDescriptionNotColoured()) {
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Update model info failed -- invalid update data.", "无效更新内容");
        }

        MwModel updateModel = new MwModel();
        try {
            updateModel.setModelId(model.getModelId());
            if(model.isModelFileSizeColoured())
                updateModel.setModelFileSize(model.getModelFileSize());
            if(model.isModelFileColoured())
                updateModel.setModelFile(model.getModelFile());
            if(model.isModelSummaryFileColoured())
                updateModel.setModelSummaryFile(model.getModelSummaryFile());
            if(model.isModelStateColoured())
                updateModel.setModelState(model.getModelState());
            if(model.isDescriptionColoured())
                updateModel.setDescription(model.getDescription());

            updateModel.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            updateModel.setLastUpdateOper((operId));
            return mwModelMapper.updateByPrimaryKeySelective(updateModel);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Update model info failed.", "更新模型信息失败", e);
        }
    }

    /*
     *
     *   查询模型信息（按ID）
     *   返回结果
     *
     * */
    public MwModel queryModel(Long id) {
        if(DataUtil.isNull(id)){
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Query model info failed -- invalid query condition.", "无效查询条件");
        }

        MwModel model;
        try {
            model = mwModelMapper.selectByPrimaryKey(id);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Query model info failed.", "查询模型信息失败", e);
        }

        if(DataUtil.isNull(model) || (model.getStatus() == DataStatusEnum.INVALID.getStatus()))
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Query model info failed -- invalid status or not found.", "已删除或未查找到");

        return model;
    }

    /*
     *
     *   查询模型信息
     *   返回结果集
     *
     * */
    public List<MwModel> queryModel(Long warehouseId, PagerUtil pager) {
        if(DataUtil.isNull(warehouseId)){
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Query model info failed -- invalid query condition.", "无效查询条件");
        }

        try {
            PagerUtil.startPage(pager);
            MwModelExample example = new MwModelExample();
            example.createCriteria().andOwnerMwIdEqualTo(warehouseId).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            example.setOrderByClause("CREATE_TIME ASC");
            return mwModelMapper.selectByExample(example);
        } catch (Throwable e) {
            PagerUtil.clearPage(pager);
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Query model info failed.", "查询模型信息失败", e);
        }
    }

    /*
     *
     *   查询模型信息（按关键字）
     *   返回结果集
     *
     * */
    public List<MwModel> queryModel(Long warehouseId, String keyword, PagerUtil pager) {
        if(DataUtil.isNull(warehouseId) || DataUtil.isEmpty(keyword)){
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Query model info failed -- invalid query condition.", "无效查询条件");
        }

        try {
            PagerUtil.startPage(pager);
            String keywordLike = "%" + keyword + "%";
            MwModelExample example = new MwModelExample();
            example.createCriteria().andOwnerMwIdEqualTo(warehouseId).andModelNameLike(keywordLike).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            example.setOrderByClause("CREATE_TIME ASC");
            return mwModelMapper.selectByExample(example);
        } catch (Throwable e) {
            PagerUtil.clearPage(pager);
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Query model info failed.", "查询模型信息失败", e);
        }
    }

    /*
     *
     *   查询模型信息（按类型）
     *   返回结果集
     *
     * */
    public List<MwModel> queryModel(Long warehouseId, ModelTypeEnum type, PagerUtil pager) {
        if(DataUtil.isNull(warehouseId) || DataUtil.isNull(type)){
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Query model info failed -- invalid query condition.", "无效查询条件");
        }

        try {
            PagerUtil.startPage(pager);
            MwModelExample example = new MwModelExample();
            example.createCriteria().andOwnerMwIdEqualTo(warehouseId).andModelTypeEqualTo(type.getType()).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            example.setOrderByClause("CREATE_TIME ASC");
            List<MwModel> resultList = mwModelMapper.selectByExample(example);
            return resultList;
        } catch (Throwable e) {
            PagerUtil.clearPage(pager);
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Query model info failed.", "查询模型信息失败", e);
        }
    }

    /*
     *
     *   检查相同名称是否已存在（可排除原ID）
     *   返回是否存在
     *
     * */
    public boolean existsModel(Long warehouseId, String modelName, Long originalId)  {
        if(DataUtil.isNull(warehouseId) && DataUtil.isEmpty(modelName))
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Check model exists failed -- invalid check condition.", "无效检查条件");

        try {
            MwModelExample example = new MwModelExample();
            MwModelExample.Criteria criteria = example.createCriteria().andOwnerMwIdEqualTo(warehouseId)
                    .andModelNameEqualTo(modelName).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            if(DataUtil.isNotNull(originalId))
                criteria.andModelIdNotEqualTo(originalId);
            return mwModelMapper.countByExample(example) > 0 ? true : false;
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Check model exists failed.", "检查已存在模型失败", e);
        }
    }
}
