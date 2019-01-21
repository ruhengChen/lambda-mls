package com.yatop.lambda.core.mgr.workflow.global;

import com.yatop.lambda.base.model.WfFlowGlobalParameter;
import com.yatop.lambda.base.model.WfFlowGlobalParameterExample;
import com.yatop.lambda.base.model.WfFlowNodeParameter;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.mgr.base.BaseMgr;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.enums.IsGlobalParameterEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.core.utils.PagerUtil;
import com.yatop.lambda.core.utils.SystemTimeUtil;
import com.yatop.lambda.core.mgr.workflow.node.NodeParameterMgr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class GlobalParameterMgr extends BaseMgr {

    @Autowired
    NodeParameterMgr nodeParameterMgr;

    /*
     *
     *   插入新全局参数（名称、关联工作流ID、关联节点ID、关联特征ID、特征默认值 ...）
     *   返回插入记录
     *
     * */
    public WfFlowGlobalParameter insertGlobalParameter(WfFlowGlobalParameter globalParameter, String operId) {
        if( DataUtil.isNull(globalParameter) ||
                globalParameter.isGlobalParamNameNotColoured() ||
                globalParameter.isRelFlowIdNotColoured() ||
                globalParameter.isRelNodeIdNotColoured() ||
                globalParameter.isRelCharIdNotColoured() ||
                globalParameter.isDefaultValueNotColoured() ||
                DataUtil.isEmpty(operId) ) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Insert global parameter failed -- invalid insert data.", "无效插入数据");
        }

        if(existsGlobalParameter(globalParameter.getRelNodeId(), globalParameter.getRelCharId())) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Insert global parameter failed -- global parameter existed.", "全局参数已存在");
        }

/*        try {
            WfFlowNodeParameter refNodeParameter = new WfFlowNodeParameter();
            refNodeParameter.setNodeId(globalParameter.getRelNodeId());
            refNodeParameter.setCharId(globalParameter.getRelCharId());
            refNodeParameter.setIsGlobalParameter(IsGlobalParameterEnum.YES.getMark());
            nodeParameterMgr.updateNodeParameter(refNodeParameter, operId);
        } catch (LambdaException e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Insert global parameter failed -- synchronize node parameter failed.", "同步节点参数失败", e);
        }*/


        WfFlowGlobalParameter insertGlobalParameter = new WfFlowGlobalParameter();
        try {
            Date dtCurrentTime = SystemTimeUtil.getCurrentTime();
            insertGlobalParameter.copyProperties(globalParameter);
            insertGlobalParameter.setGlobalParamIdColoured(false);
            insertGlobalParameter.setStatus(DataStatusEnum.NORMAL.getStatus());
            insertGlobalParameter.setLastUpdateTime(dtCurrentTime);
            insertGlobalParameter.setLastUpdateOper(operId);
            insertGlobalParameter.setCreateTime(dtCurrentTime);
            insertGlobalParameter.setCreateOper(operId);
            wfFlowGlobalParameterMapper.insertSelective(insertGlobalParameter);
            return insertGlobalParameter;
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Insert global parameter failed.", "插入全局参数失败", e);
        }
    }

    /*
     *
     *   逻辑删除全局参数
     *   返回删除数量
     *
     * */
    public int deleteGlobalParameter(Long globalParameterId, String operId) {
        if(DataUtil.isNull(globalParameterId) || DataUtil.isEmpty(operId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Delete global parameter -- invalid delete condition.", "无效删除条件");
        }

        try {
            WfFlowGlobalParameter deleteGlobalParameter = new WfFlowGlobalParameter();
            deleteGlobalParameter.setGlobalParamId(globalParameterId);
            deleteGlobalParameter.setStatus(DataStatusEnum.INVALID.getStatus());
            deleteGlobalParameter.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            deleteGlobalParameter.setLastUpdateOper(operId);
            return wfFlowGlobalParameterMapper.updateByPrimaryKeySelective(deleteGlobalParameter);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Delete global parameter failed.", "删除全局参数失败", e);
        }
    }

    /*
     *
     *   恢复全局参数
     *   返回恢复数量
     *
     * */
/*    public int recoverGlobalParameter4RecoverNode(Long globalParameterId, String operId) {
        if(DataUtil.isNull(globalParameterId) || DataUtil.isEmpty(operId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Recover global parameter -- invalid recover condition.", "无效恢复条件");
        }

        try {
            WfFlowGlobalParameter recoverGlobalParameter = new WfFlowGlobalParameter();
            recoverGlobalParameter.setGlobalParamId(globalParameterId);
            recoverGlobalParameter.setStatus(DataStatusEnum.NORMAL.getStatus());
            recoverGlobalParameter.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            recoverGlobalParameter.setLastUpdateOper(operId);
            return wfFlowGlobalParameterMapper.updateByPrimaryKeySelective(recoverGlobalParameter);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Recover global parameter failed.", "恢复全局参数失败", e);
        }
    }
*/

    /*
     *
     *   更新全局参数（名称、特征默认值、警告消息、描述）
     *   返回更新数量
     *
     * */
    public int updateGlobalParameter(WfFlowGlobalParameter globalParameter, String operId) {
        if( DataUtil.isNull(globalParameter) || DataUtil.isNull(globalParameter.getGlobalParamId()) || DataUtil.isEmpty(operId)) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Update global parameter failed -- invalid update condition.", "无效更新条件");
        }

        if(globalParameter.isGlobalParamNameNotColoured() &&
                globalParameter.isDefaultValueNotColoured() &&
                globalParameter.isWarningMsgNotColoured() &&
                globalParameter.isDescriptionNotColoured()) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Update global parameter failed -- invalid update data.", "无效更新内容");
        }

        WfFlowGlobalParameter updateGlobalParameter = new WfFlowGlobalParameter();
        try {
            updateGlobalParameter.setGlobalParamId(globalParameter.getGlobalParamId());
            if(globalParameter.isGlobalParamNameColoured())
                updateGlobalParameter.setGlobalParamName(globalParameter.getGlobalParamName());
            if(globalParameter.isDefaultValueColoured())
                updateGlobalParameter.setDefaultValue(globalParameter.getDefaultValue());
            if(globalParameter.isWarningMsgColoured())
                updateGlobalParameter.setWarningMsg(globalParameter.getWarningMsg());
            if(globalParameter.isDescriptionColoured())
                updateGlobalParameter.setDescription(globalParameter.getDescription());

            updateGlobalParameter.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            updateGlobalParameter.setLastUpdateOper((operId));

            globalParameter.setLastUpdateTime(updateGlobalParameter.getLastUpdateTime());
            globalParameter.setLastUpdateOper(updateGlobalParameter.getLastUpdateOper());
            return wfFlowGlobalParameterMapper.updateByPrimaryKeySelective(updateGlobalParameter);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Update global parameter failed.", "更新全局参数失败", e);
        }
    }

    /*
     *
     *   查询全局参数（按ID）
     *   返回结果
     *
     * */
    public WfFlowGlobalParameter queryGlobalParameter(Long id) {
        if(DataUtil.isNull(id)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query global parameter failed -- invalid query condition.", "无效查询条件");
        }

        WfFlowGlobalParameter globalParameter;
        try {
            globalParameter = wfFlowGlobalParameterMapper.selectByPrimaryKey(id);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query global parameter failed.", "查询全局参数失败", e);
        }

        if(DataUtil.isNull(globalParameter) || (globalParameter.getStatus() == DataStatusEnum.INVALID.getStatus()))
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query global parameter failed -- invalid status or not found.", "已删除或未查找到");

        return globalParameter;
    }

    /*
     *
     *   查询全局参数（按工作流ID）
     *   返回结果集
     *
     * */
    public List<WfFlowGlobalParameter> queryGlobalParameterByFlowId(Long flowId, PagerUtil pager) {
        if(DataUtil.isNull(flowId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query global parameter failed -- invalid query condition.", "无效查询条件");
        }

        try {
            PagerUtil.startPage(pager);
            WfFlowGlobalParameterExample example = new WfFlowGlobalParameterExample();
            example.createCriteria().andRelFlowIdEqualTo(flowId).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            example.setOrderByClause("CREATE_TIME ASC");
            return wfFlowGlobalParameterMapper.selectByExample(example);
        } catch (Throwable e) {
            PagerUtil.clearPage(pager);
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query global parameter failed.", "查询全局参数失败", e);
        }
    }

    /*
     *
     *   是否已存在全局参数
     *   返回结果集
     *
     * */
    public boolean existsGlobalParameter(Long nodeId, String charId) {
        if(DataUtil.isNull(nodeId) || DataUtil.isEmpty(charId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Check global parameter exists failed -- invalid check condition.", "无效检查条件");
        }

        try {
            WfFlowGlobalParameterExample example = new WfFlowGlobalParameterExample();
            example.createCriteria().andRelNodeIdEqualTo(nodeId).andRelCharIdEqualTo(charId).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            return wfFlowGlobalParameterMapper.countByExample(example) > 0 ? true : false;
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Check global parameter exists failed.", "检查全局参数是否已存在失败", e);
        }
    }
}
