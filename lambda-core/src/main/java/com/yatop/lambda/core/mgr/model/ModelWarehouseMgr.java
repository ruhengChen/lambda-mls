package com.yatop.lambda.core.mgr.model;

import com.yatop.lambda.base.model.MwModelWarehouse;
import com.yatop.lambda.base.model.MwModelWarehouseExample;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.mgr.base.BaseMgr;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.enums.ModelWarehouseTypeEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.core.utils.PagerUtil;
import com.yatop.lambda.core.utils.SystemTimeUtil;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ModelWarehouseMgr extends BaseMgr {
    
    /*
     *
     *   插入新模型仓库信息（代码、名称、类型、所属项目ID、DFS数据目录、本地数据目录 ...）
     *   返回插入记录
     *
     * */
    public MwModelWarehouse insertDataWarehouse(MwModelWarehouse warehouse, String operId) {
        if( DataUtil.isNull(warehouse) ||
                warehouse.isMwCodeNotColoured() ||
                warehouse.isMwNameNotColoured() ||
                warehouse.isMwTypeNotColoured() ||
                warehouse.isOwnerProjectIdNotColoured() ||
                warehouse.isModelDfsDirNotColoured() ||
                warehouse.isModelLocalDirNotColoured() ||
                DataUtil.isEmpty(operId) ) {
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Insert model warehouse info failed -- invalid insert data.", "无效插入数据");
        }

        if(warehouse.getMwType() == ModelWarehouseTypeEnum.PUBLIC.getType()) {
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Insert model warehouse info failed -- public model warehouse not support.", "不支持公共模型库");
        }

        if(existsDataWarehouse(warehouse.getMwCode(), warehouse.getMwName(), null)) {
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Insert model warehouse info failed -- code or name conflict.", "模型库代码或名称冲突");
        }

        MwModelWarehouse insertWarehouse = new MwModelWarehouse();
        try {
            Date dtCurrentTime = SystemTimeUtil.getCurrentTime();
            insertWarehouse.copyProperties(warehouse);
            insertWarehouse.setMwIdColoured(false);
            insertWarehouse.setStatus(DataStatusEnum.NORMAL.getStatus());
            insertWarehouse.setLastUpdateTime(dtCurrentTime);
            insertWarehouse.setLastUpdateOper(operId);
            insertWarehouse.setCreateTime(dtCurrentTime);
            insertWarehouse.setCreateOper(operId);
            mwModelWarehouseMapper.insertSelective(insertWarehouse);
            return insertWarehouse;
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Insert model warehouse info failed.", "插入模型库信息失败", e);
        }
    }

    /*
     *
     *   逻辑删除模型仓库信息
     *   返回删除数量
     *
     * */
    public int deleteDataWarehouse(MwModelWarehouse warehouse, String operId) {
        if(DataUtil.isNull(warehouse) || warehouse.isMwIdNotColoured() || DataUtil.isEmpty(operId)){
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Delete model warehouse info failed -- invalid delete condition.", "无效删除条件");
        }

        try {
            MwModelWarehouse deleteWarehouse = new MwModelWarehouse();
            deleteWarehouse.setMwId(warehouse.getMwId());
            deleteWarehouse.setStatus(DataStatusEnum.INVALID.getStatus());
            deleteWarehouse.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            deleteWarehouse.setLastUpdateOper(operId);
            return mwModelWarehouseMapper.updateByPrimaryKeySelective(deleteWarehouse);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Delete model warehouse info failed.", "删除模型库信息失败", e);
        }
    }

    /*
     *
     *   更新模型仓库信息（代码、名称、DFS数据目录、本地数据目录、描述）
     *   返回更新数量
     *
     * */
    public int updateDataWarehouse(MwModelWarehouse warehouse, String operId) {
        if( DataUtil.isNull(warehouse) || warehouse.isMwIdNotColoured() || DataUtil.isEmpty(operId)) {
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Update model warehouse info failed -- invalid update condition.", "无效更新条件");
        }

        if(warehouse.isMwCodeNotColoured() &&
                warehouse.isMwNameNotColoured() &&
                warehouse.isModelDfsDirNotColoured() &&
                warehouse.isModelLocalDirNotColoured() &&
                warehouse.isDescriptionNotColoured()) {
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Update model warehouse info failed -- invalid update data.", "无效更新内容");
        }

        if((warehouse.isMwCodeColoured() || warehouse.isMwNameColoured()) &&
                existsDataWarehouse(warehouse.getMwCode(), warehouse.getMwName(), warehouse.getMwId())) {
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Update model warehouse info failed -- code or name conflict.", "代码或名称冲突");
        }

        MwModelWarehouse updateWarehouse = new MwModelWarehouse();
        try {
            updateWarehouse.setMwId(warehouse.getMwId());
            if(warehouse.isMwCodeColoured())
                updateWarehouse.setMwCode(warehouse.getMwCode());
            if(warehouse.isMwNameColoured())
                updateWarehouse.setMwName(warehouse.getMwName());
            if(warehouse.isModelDfsDirColoured())
                updateWarehouse.setModelDfsDir(warehouse.getModelDfsDir());
            if(warehouse.isModelDfsDirColoured())
                updateWarehouse.setModelLocalDir(warehouse.getModelLocalDir());
            if(warehouse.isDescriptionColoured())
                updateWarehouse.setDescription(warehouse.getDescription());

            updateWarehouse.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            updateWarehouse.setLastUpdateOper((operId));
            return mwModelWarehouseMapper.updateByPrimaryKeySelective(updateWarehouse);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Update model warehouse info failed.", "更新模型库信息失败", e);
        }
    }

    /*
     *
     *   查询模型仓库信息（按ID）
     *   返回结果
     *
     * */
    public MwModelWarehouse queryDataWarehouse(Long id) {
        if(DataUtil.isNull(id)){
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Query model warehouse info failed -- invalid query condition.", "无效查询条件");
        }

        MwModelWarehouse warehouse;

        try {
            warehouse = mwModelWarehouseMapper.selectByPrimaryKey(id);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Query model warehouse info failed.", "查询模型库信息失败", e);
        }

        if(DataUtil.isNull(warehouse) || (warehouse.getStatus() == DataStatusEnum.INVALID.getStatus()))
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Query model warehouse info failed -- invalid status or not found.", "已删除或未查找到");

        return warehouse;
    }

    /*
     *
     *   查询模型仓库信息（所有）
     *   返回结果集
     *
     * */
    public List<MwModelWarehouse> queryDataWarehouse(PagerUtil pager) {
        try {
            PagerUtil.startPage(pager);
            MwModelWarehouseExample example = new MwModelWarehouseExample();
            example.createCriteria().andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            example.setOrderByClause("CREATE_TIME ASC");
            return mwModelWarehouseMapper.selectByExample(example);
        } catch (Throwable e) {
            PagerUtil.clearPage(pager);
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Query model warehouse info failed.", "查询模型库信息失败", e);
        }
    }

    /*
     *
     *   查询模型仓库信息（按关键字）
     *   返回结果集
     *
     * */
    public List<MwModelWarehouse> queryDataWarehouse(String keyword, PagerUtil pager) {
        if(DataUtil.isEmpty(keyword)){
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Query model warehouse info failed -- invalid query condition.", "无效查询条件");
        }

        try {
            PagerUtil.startPage(pager);
            String keywordLike = "%" + keyword + "%";
            MwModelWarehouseExample example = new MwModelWarehouseExample();
            example.createCriteria().andMwCodeLike(keywordLike).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            example.or().andMwNameLike(keywordLike).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            example.setOrderByClause("CREATE_TIME ASC");
            return mwModelWarehouseMapper.selectByExample(example);
        } catch (Throwable e) {
            PagerUtil.clearPage(pager);
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Query model warehouse info failed.", "查询模型库信息失败", e);
        }
    }

    /*
     *
     *   查询模型仓库信息（按类型）
     *   返回结果集
     *
     * */
    public List<MwModelWarehouse> queryDataWarehouse(ModelWarehouseTypeEnum type, PagerUtil pager) {
        if(DataUtil.isNull(type)){
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Query model warehouse info failed -- invalid query condition.", "无效查询条件");
        }

        try {
            PagerUtil.startPage(pager);
            MwModelWarehouseExample example = new MwModelWarehouseExample();
            example.createCriteria().andMwTypeEqualTo(type.getType()).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            example.setOrderByClause("CREATE_TIME ASC");
            List<MwModelWarehouse> resultList = mwModelWarehouseMapper.selectByExample(example);
            return resultList;
        } catch (Throwable e) {
            PagerUtil.clearPage(pager);
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Query model warehouse info failed.", "查询模型库信息失败", e);
        }
    }

    /*
     *
     *   检查相同模型仓库代码或名称是否已存在（可排除原ID）
     *   返回是否存在
     *
     * */
    public boolean existsDataWarehouse(String code, String name, Long originalId)  {
        if(DataUtil.isEmpty(code) && DataUtil.isEmpty(name))
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Check model warehouse exists failed -- invalid check condition.", "无效检查条件");

        try {
            MwModelWarehouseExample example = new MwModelWarehouseExample();
            if(DataUtil.isNotEmpty(code)) {
                MwModelWarehouseExample.Criteria criteria = example.createCriteria().andMwCodeEqualTo(code).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
                if(DataUtil.isNotNull(originalId))
                    criteria.andMwIdNotEqualTo(originalId);
                if(mwModelWarehouseMapper.countByExample(example) > 0)
                    return true;
            }

            example.clear();
            if(DataUtil.isNotEmpty(name)) {
                MwModelWarehouseExample.Criteria criteria = example.createCriteria().andMwNameEqualTo(name).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
                if(DataUtil.isNotNull(originalId))
                    criteria.andMwIdNotEqualTo(originalId);
                if(mwModelWarehouseMapper.countByExample(example) > 0)
                    return true;
            }

            return false;
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.E_MODEL_DEFAULT_ERROR, "Check model warehouse exists failed.", "检查已存在模型库失败", e);
        }
    }
}
