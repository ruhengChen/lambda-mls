package com.yatop.lambda.core.mgr.workflow.node;

import com.yatop.lambda.base.model.WfFlowNode;
import com.yatop.lambda.base.model.WfFlowNodeParameter;
import com.yatop.lambda.base.model.WfFlowNodeParameterExample;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.mgr.base.BaseMgr;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.enums.IsDuplicatedEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.core.utils.SystemTimeUtil;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NodeParameterMgr extends BaseMgr {

    /*
     *
     *   插入新节点参数（节点ID、规格类型、组件特征ID、是否为全局参数 ...）
     *   返回插入记录
     *
     * */
    public WfFlowNodeParameter insertNodeParameter(WfFlowNodeParameter nodeParameter, String operId) {
        if( DataUtil.isNull(nodeParameter) ||
                nodeParameter.isNodeIdNotColoured() ||
                nodeParameter.isSpecTypeNotColoured() ||
                nodeParameter.isCharIdNotColoured() ||
                nodeParameter.isIsGlobalParameterNotColoured() ||
                DataUtil.isEmpty(operId) ) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Insert node parameter failed -- invalid insert data.", "无效插入数据");
        }

        WfFlowNodeParameter insertNodeParameter = new WfFlowNodeParameter();
        try {
            Date dtCurrentTime = SystemTimeUtil.getCurrentTime();
            insertNodeParameter.copyProperties(nodeParameter);
            insertNodeParameter.setIsDuplicated(IsDuplicatedEnum.NO.getMark());
            insertNodeParameter.setStatus(DataStatusEnum.NORMAL.getStatus());
            insertNodeParameter.setLastUpdateTime(dtCurrentTime);
            insertNodeParameter.setLastUpdateOper(operId);
            insertNodeParameter.setCreateTime(dtCurrentTime);
            insertNodeParameter.setCreateOper(operId);
            wfFlowNodeParameterMapper.insertSelective(insertNodeParameter);
            return insertNodeParameter;
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Insert node parameter failed.", "插入节点参数失败", e);
        }
    }

    /*
     *
     *   逻辑删除节点参数（按节点删除）
     *   返回删除数量
     *
     * */
    public int deleteNodeParameter(WfFlowNode node, String operId) {
        if(DataUtil.isNull(node) || node.isNodeIdColoured() || DataUtil.isEmpty(operId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Delete node parameter -- invalid delete condition.", "无效删除条件");
        }

        try {
            WfFlowNodeParameter deleteNodeParameter = new WfFlowNodeParameter();
            deleteNodeParameter.setStatus(DataStatusEnum.INVALID.getStatus());
            deleteNodeParameter.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            deleteNodeParameter.setLastUpdateOper(operId);
            WfFlowNodeParameterExample example = new WfFlowNodeParameterExample();
            example.createCriteria().andNodeIdEqualTo(node.getNodeId()).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            return wfFlowNodeParameterMapper.updateByExampleSelective(deleteNodeParameter, example);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Delete node parameter failed.", "删除节点参数失败", e);
        }
    }

    /*
     *
     *   恢复节点参数（按节点恢复）
     *   返回删除数量
     *
     * */
    public int recoverNodeParameter(WfFlowNode node, String operId) {
        if(DataUtil.isNull(node) || node.isNodeIdColoured() || DataUtil.isEmpty(operId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Recover node parameter -- invalid recover condition.", "无效恢复条件");
        }

        try {
            WfFlowNodeParameter recoverNodeParameter = new WfFlowNodeParameter();
            recoverNodeParameter.setStatus(DataStatusEnum.NORMAL.getStatus());
            recoverNodeParameter.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            recoverNodeParameter.setLastUpdateOper(operId);
            WfFlowNodeParameterExample example = new WfFlowNodeParameterExample();
            example.createCriteria().andNodeIdEqualTo(node.getNodeId()).andStatusEqualTo(DataStatusEnum.INVALID.getStatus());
            return wfFlowNodeParameterMapper.updateByExampleSelective(recoverNodeParameter, example);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Recover node parameter failed.", "恢复节点参数失败", e);
        }
    }

    /*
     *
     *   更新节点参数（特征值、是否为全局参数、是否被复制、警告消息、描述）
     *   返回更新数量
     *
     * */
    public int updateNodeParameter(WfFlowNodeParameter nodeParameter, String operId) {
        if( DataUtil.isNull(nodeParameter) || nodeParameter.isNodeIdColoured() || nodeParameter.isCharIdNotColoured() || DataUtil.isEmpty(operId)) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Update node parameter failed -- invalid update condition.", "无效更新条件");
        }

        if(nodeParameter.isCharValueNotColoured() &&
                nodeParameter.isIsGlobalParameterNotColoured() &&
                nodeParameter.isLastGlobalParameterIdNotColoured() &&
                nodeParameter.isIsDuplicatedNotColoured() &&
                nodeParameter.isWarningMsgNotColoured() &&
                nodeParameter.isDescriptionNotColoured()) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Update node parameter failed -- invalid update data.", "无效更新内容");
        }

        WfFlowNodeParameter updateNodeParameter = new WfFlowNodeParameter();
        try {
            if(nodeParameter.isCharValueColoured())
                updateNodeParameter.setCharValue(nodeParameter.getCharValue());
            if(nodeParameter.isIsGlobalParameterColoured())
                updateNodeParameter.setIsGlobalParameter(nodeParameter.getIsGlobalParameter());
            if(nodeParameter.isLastGlobalParameterIdColoured())
                updateNodeParameter.setLastGlobalParameterId(nodeParameter.getLastGlobalParameterId());
            if(nodeParameter.isIsDuplicatedColoured())
                updateNodeParameter.setIsDuplicated(nodeParameter.getIsDuplicated());
            if(nodeParameter.isWarningMsgColoured())
                updateNodeParameter.setWarningMsg(nodeParameter.getWarningMsg());
            if(nodeParameter.isDescriptionColoured())
                updateNodeParameter.setDescription(nodeParameter.getDescription());
            updateNodeParameter.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            updateNodeParameter.setLastUpdateOper((operId));

            WfFlowNodeParameterExample example = new WfFlowNodeParameterExample();
            example.createCriteria().andNodeIdEqualTo(nodeParameter.getNodeId()).andCharIdEqualTo(nodeParameter.getCharId()).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            return wfFlowNodeParameterMapper.updateByExampleSelective(updateNodeParameter, example);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Update node parameter failed.", "更新节点参数失败", e);
        }
    }

    /*
     *
     *   查询节点参数（按节点ID）
     *   返回结果
     *
     * */
    public List<WfFlowNodeParameter> queryNodeParameter(Long nodeId) {
        return queryNodeParameterExt(nodeId, null);
    }

    /*
     *
     *   查询节点参数（按节点ID + [特征ID]）
     *   返回结果
     *
     * */
    public WfFlowNodeParameter queryNodeParameter(Long nodeId, String charId) {
        if(DataUtil.isNull(nodeId) || DataUtil.isEmpty(charId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query node parameter failed -- invalid query condition.", "无效查询条件");
        }

        List<WfFlowNodeParameter> resultList = queryNodeParameterExt(nodeId, charId);
        return DataUtil.isNotEmpty(resultList) ? resultList.get(0) : null;
    }

    /*
     *
     *   查询节点参数（按节点ID + [特征ID]）
     *   返回结果
     *
     * */
    public List<WfFlowNodeParameter> queryNodeParameterExt(Long nodeId, String charId) {
        if(DataUtil.isNull(nodeId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query node parameter failed -- invalid query condition.", "无效查询条件");
        }

        try {
            WfFlowNodeParameterExample example = new WfFlowNodeParameterExample();
            WfFlowNodeParameterExample.Criteria cond = example.createCriteria().andNodeIdEqualTo(nodeId);
            if(DataUtil.isEmpty(charId))
                cond.andCharIdEqualTo(charId);
            cond.andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            example.setOrderByClause("CREATE_TIME ASC");
            return wfFlowNodeParameterMapper.selectByExample(example);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query node parameter failed.", "查询节点参数失败", e);
        }
    }

    /*
     *
     *   是否已存在节点参数
     *   返回结果集
     *
     * */
    public boolean existsNodeParameter(Long nodeId, String charId) {
        if(DataUtil.isNull(nodeId) || DataUtil.isEmpty(charId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Check node parameter exists failed -- invalid check condition.", "无效检查条件");
        }

        try {
            WfFlowNodeParameterExample example = new WfFlowNodeParameterExample();
            example.createCriteria().andNodeIdEqualTo(nodeId).andCharIdEqualTo(charId).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            return wfFlowNodeParameterMapper.countByExample(example) > 0 ? true : false;
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Check node parameter exists failed.", "检查节点参数是否已存在失败", e);
        }
    }
}
