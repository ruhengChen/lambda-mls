package com.yatop.lambda.core.mgr.workflow.unstructured;

import com.yatop.lambda.base.model.WfJsonObject;
import com.yatop.lambda.base.model.WfJsonObjectExample;
import com.yatop.lambda.core.enums.JsonObjectStateEnum;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.mgr.base.BaseMgr;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.enums.JsonObjectTypeEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.core.utils.PagerUtil;
import com.yatop.lambda.core.utils.SystemTimeUtil;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class JsonObjectMgr extends BaseMgr {

    /*
     *
     *   插入新Json对象（名称、对象类型、来源、所属项目ID、关联实验ID、关联工作流ID、关联运行作业ID、关联节点ID、关联特征ID、存储位置、对象状态 ...）
     *   返回插入记录
     *
     * */
    public WfJsonObject insertJsonObject(WfJsonObject jsonObject, String operId) {
        if( DataUtil.isNull(jsonObject) ||
                jsonObject.isObjectNameNotColoured() ||
                jsonObject.isObjectTypeNotColoured() ||
                jsonObject.isObjectSrcNotColoured() ||
                jsonObject.isOwnerProjectIdNotColoured() ||
                jsonObject.isRelFlowIdNotColoured() ||
                jsonObject.isRelNodeIdNotColoured() ||
                jsonObject.isRelCharIdNotColoured() ||
                jsonObject.isRelTaskIdNotColoured() ||
                jsonObject.isStorageLocationNotColoured() ||
                jsonObject.isObjectStateNotColoured() ||
                DataUtil.isEmpty(operId) ) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Insert json object failed -- invalid insert data.", "无效插入数据");
        }

        WfJsonObject insertJsonObject = new WfJsonObject();
        try {
            Date dtCurrentTime = SystemTimeUtil.getCurrentTime();
            insertJsonObject.copyProperties(jsonObject);
            insertJsonObject.setObjectIdColoured(false);
            insertJsonObject.setStatus(DataStatusEnum.NORMAL.getStatus());
            insertJsonObject.setLastUpdateTime(dtCurrentTime);
            insertJsonObject.setLastUpdateOper(operId);
            insertJsonObject.setCreateTime(dtCurrentTime);
            insertJsonObject.setCreateOper(operId);
            wfJsonObjectMapper.insertSelective(insertJsonObject);
            return insertJsonObject;
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Insert json object failed.", "插入Json对象失败", e);
        }
    }

    public int deleteJsonObject(Long jsonObjectId, String operId) {
        return deleteJsonObject(jsonObjectId, false, operId);
    }

    /*
     *
     *   逻辑删除Json对象
     *   返回删除数量
     *
     * */
    public int deleteJsonObject(Long jsonObjectId, boolean clearData, String operId) {
        if(DataUtil.isNull(jsonObjectId) || DataUtil.isEmpty(operId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Delete json object -- invalid delete condition.", "无效删除条件");
        }

        try {
            WfJsonObject deleteJsonObject = new WfJsonObject();
            deleteJsonObject.setObjectId(jsonObjectId);
            if(clearData) {
                deleteJsonObject.setObjectContent(null);
                deleteJsonObject.setObjectState(JsonObjectStateEnum.EMPTY.getState());
            }
            deleteJsonObject.setStatus(DataStatusEnum.INVALID.getStatus());
            deleteJsonObject.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            deleteJsonObject.setLastUpdateOper(operId);
            return wfJsonObjectMapper.updateByPrimaryKeySelective(deleteJsonObject);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Delete json object failed.", "删除Json对象失败", e);
        }
    }

    /*
     *
     *   恢复Json对象
     *   返回恢复数量
     *
     * */
    public int recoverJsonObject(Long id, String operId) {
        if(DataUtil.isNull(id) || DataUtil.isEmpty(operId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Recover json object -- invalid recover condition.", "无效恢复条件");
        }

        try {
            WfJsonObject recoverJsonObject = new WfJsonObject();
            recoverJsonObject.setObjectId(id);
            recoverJsonObject.setStatus(DataStatusEnum.NORMAL.getStatus());
            recoverJsonObject.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            recoverJsonObject.setLastUpdateOper(operId);
            return wfJsonObjectMapper.updateByPrimaryKeySelective(recoverJsonObject);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Recover json object failed.", "恢复Json对象失败", e);
        }
    }

    /*
     *
     *   更新Json对象（名称、对象内容、DFS对象文件名、本地对象文件名、对象状态、描述）
     *   返回更新数量
     *
     * */
    public int updateJsonObject(WfJsonObject jsonObject, String operId) {
        if( DataUtil.isNull(jsonObject) || DataUtil.isNull(jsonObject.getObjectId()) || DataUtil.isEmpty(operId)) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Update json object failed -- invalid update condition.", "无效更新条件");
        }

        if(jsonObject.isObjectNameNotColoured() &&
                jsonObject.isObjectContentNotColoured() &&
                jsonObject.isObjectDfsFileNotColoured() &&
                jsonObject.isObjectLocalFileNotColoured() &&
                jsonObject.isObjectStateNotColoured() &&
                jsonObject.isDescriptionNotColoured()) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Update json object failed -- invalid update data.", "无效更新内容");
        }

        WfJsonObject updateJsonObject = new WfJsonObject();
        try {
            updateJsonObject.setObjectId(jsonObject.getObjectId());
            if(jsonObject.isObjectNameColoured())
                updateJsonObject.setObjectName(jsonObject.getObjectName());
            if(jsonObject.isObjectContentColoured())
                updateJsonObject.setObjectContent(jsonObject.getObjectContent());
            if(jsonObject.isObjectDfsFileColoured())
                updateJsonObject.setObjectDfsFile(jsonObject.getObjectDfsFile());
            if(jsonObject.isObjectLocalFileColoured())
                updateJsonObject.setObjectLocalFile(jsonObject.getObjectLocalFile());
            if(jsonObject.isObjectStateColoured())
                updateJsonObject.setObjectState(jsonObject.getObjectState());
            if(jsonObject.isDescriptionColoured())
                updateJsonObject.setDescription(jsonObject.getDescription());

            updateJsonObject.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            updateJsonObject.setLastUpdateOper((operId));

            jsonObject.setLastUpdateTime(updateJsonObject.getLastUpdateTime());
            jsonObject.setLastUpdateOper(updateJsonObject.getLastUpdateOper());
            return wfJsonObjectMapper.updateByPrimaryKeySelective(updateJsonObject);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Update json object failed.", "更新Json对象失败", e);
        }
    }

    /*
     *
     *   查询Json对象（按ID）
     *   返回结果
     *
     * */
    public WfJsonObject queryJsonObject(Long objectId) {
        if(DataUtil.isNull(objectId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query json object failed -- invalid query condition.", "无效查询条件");
        }

        WfJsonObject jsonObject;
        try {
            jsonObject = wfJsonObjectMapper.selectByPrimaryKey(objectId);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query json object failed.", "查询Json对象失败", e);
        }

        if(DataUtil.isNull(jsonObject) || (jsonObject.getStatus() == DataStatusEnum.INVALID.getStatus()))
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query json object failed -- invalid status or not found.", "已删除或未查找到");

        return jsonObject;
    }

    /*
     *
     *   查询Json对象（项目ID + [对象类型]）
     *   返回结果集
     *
     * */
    public List<WfJsonObject> queryJsonObject(Long projectId, JsonObjectTypeEnum typeEnum, PagerUtil pager) {
        if(DataUtil.isNull(projectId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query json object failed -- invalid query condition.", "无效查询条件");
        }

        try {
            PagerUtil.startPage(pager);
            WfJsonObjectExample example = new WfJsonObjectExample();
            WfJsonObjectExample.Criteria cond = example.createCriteria().andOwnerProjectIdEqualTo(projectId);

            if(DataUtil.isNotNull(typeEnum))
                cond.andObjectTypeEqualTo(typeEnum.getType());

            cond.andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            example.setOrderByClause("CREATE_TIME ASC");
            return wfJsonObjectMapper.selectByExample(example);
        } catch (Throwable e) {
            PagerUtil.clearPage(pager);
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query json object failed.", "查询Json对象失败", e);
        }
    }
}
