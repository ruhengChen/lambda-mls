package com.yatop.lambda.core.mgr.workflow.node;

import com.yatop.lambda.base.model.WfFlowNode;
import com.yatop.lambda.base.model.WfFlowNodeExample;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.mgr.base.BaseMgr;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.enums.NodeStateEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.core.utils.PagerUtil;
import com.yatop.lambda.core.utils.SystemTimeUtil;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NodeMgr extends BaseMgr {
    
    /*
     *
     *   插入新节点信息（名称、所属项目ID、所属工作流ID、引用工作流组件ID、序号 ...）
     *   返回插入记录
     *
     * */
    public WfFlowNode insertNode(WfFlowNode node, String operId) {
        if( DataUtil.isNull(node) ||
                node.isNodeNameNotColoured() ||
                node.isOwnerProjectIdNotColoured() ||
                node.isOwnerFlowIdNotColoured() ||
                node.isRefModuleIdNotColoured() ||
                node.isSequenceNotColoured() ||
                DataUtil.isEmpty(operId) ) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Insert node info failed -- invalid insert data.", "无效插入数据");
        }

        WfFlowNode insertNode = new WfFlowNode();
        try {
            Date dtCurrentTime = SystemTimeUtil.getCurrentTime();
            insertNode.copyProperties(node);
            insertNode.setNodeIdColoured(false);
            insertNode.setLastTaskIdColoured(false);
            insertNode.setNodeState(NodeStateEnum.NOT_READY.getState());
            insertNode.setStatus(DataStatusEnum.NORMAL.getStatus());
            insertNode.setLastUpdateTime(dtCurrentTime);
            insertNode.setLastUpdateOper(operId);
            insertNode.setCreateTime(dtCurrentTime);
            insertNode.setCreateOper(operId);
            wfFlowNodeMapper.insertSelective(insertNode);
            return insertNode;
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Insert node info failed.", "插入节点信息失败", e);
        }
    }

    /*
     *
     *   逻辑删除节点信息
     *   返回删除数量
     *
     * */
    public int deleteNode(Long nodeId, String operId) {
        if(DataUtil.isNull(nodeId) || DataUtil.isEmpty(operId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Delete node info -- invalid delete condition.", "无效删除条件");
        }

        try {
            WfFlowNode deleteNode = new WfFlowNode();
            deleteNode.setNodeId(nodeId);
            deleteNode.setStatus(DataStatusEnum.INVALID.getStatus());
            deleteNode.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            deleteNode.setLastUpdateOper(operId);
            return wfFlowNodeMapper.updateByPrimaryKeySelective(deleteNode);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Delete node info failed.", "删除节点信息失败", e);
        }
    }

    /*
     *
     *   恢复节点信息
     *   返回删除数量
     *
     * */
    public int recoverNode(Long nodeId, String operId) {
        if(DataUtil.isNull(nodeId) || DataUtil.isEmpty(operId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Recover node info -- invalid recover condition.", "无效恢复条件");
        }

        try {
            WfFlowNode recoverNode = new WfFlowNode();
            recoverNode.setNodeId(nodeId);
            recoverNode.setStatus(DataStatusEnum.NORMAL.getStatus());
            recoverNode.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            recoverNode.setLastUpdateOper(operId);
            return wfFlowNodeMapper.updateByPrimaryKeySelective(recoverNode);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Recover node info failed.", "恢复节点信息失败", e);
        }
    }

    /*
     *
     *   更新节点信息（名称、X坐标、Y坐标、最后任务ID、警告消息、节点状态、注释、概要、描述）
     *   返回更新数量
     *
     * */
    public int updateNode(WfFlowNode node, String operId) {
        if( DataUtil.isNull(node) || node.isNodeNameNotColoured() || DataUtil.isEmpty(operId)) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Update node info failed -- invalid update condition.", "无效更新条件");
        }

        if(node.isNodeNameNotColoured() &&
                node.isPositionXNotColoured() &&
                node.isPositionYNotColoured() &&
                node.isLastTaskIdNotColoured() &&
                node.isWarningMsgNotColoured() &&
                node.isNodeStateNotColoured() &&
                node.isCommentNotColoured() &&
                node.isSummaryNotColoured() &&
                node.isDescriptionNotColoured()) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Update node info failed -- invalid update data.", "无效更新内容");
        }

        try {
            WfFlowNode updateNode = new WfFlowNode();
            updateNode.setNodeId(node.getNodeId());
            if(node.isNodeNameColoured())
                updateNode.setNodeName(node.getNodeName());
            if(node.isPositionXColoured())
                updateNode.setPositionX(node.getPositionX());
            if(node.isPositionYColoured())
                updateNode.setPositionY(node.getPositionY());
            if(node.isLastTaskIdColoured())
                updateNode.setLastTaskId(node.getLastTaskId());
            if(node.isWarningMsgColoured())
                updateNode.setWarningMsg(node.getWarningMsg());
            if(node.isNodeStateColoured())
                updateNode.setNodeState(node.getNodeState());
            if(node.isCommentColoured())
                updateNode.setComment(node.getComment());
            if(node.isSummaryColoured())
                updateNode.setSummary(node.getSummary());
            if(node.isDescriptionColoured())
                updateNode.setDescription(node.getDescription());

            updateNode.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            updateNode.setLastUpdateOper(operId);

            node.setLastUpdateTime(updateNode.getLastUpdateTime());
            node.setLastUpdateOper(updateNode.getLastUpdateOper());
            return wfFlowNodeMapper.updateByPrimaryKeySelective(updateNode);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Update node info failed.", "更新节点信息失败", e);
        }
    }

    /*
     *
     *   查询节点信息（按ID）
     *   返回结果
     *
     * */
    public WfFlowNode queryNode(Long nodeId) {
        if(DataUtil.isNull(nodeId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query node info failed -- invalid query condition.", "无效查询条件");
        }

        WfFlowNode node;
        try {
            node = wfFlowNodeMapper.selectByPrimaryKey(nodeId);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query node info failed.", "查询节点信息失败", e);
        }

        if(DataUtil.isNull(node) || (node.getStatus() == DataStatusEnum.INVALID.getStatus()))
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query node info failed -- invalid status or not found.", "已删除或未查找到");

        return node;
    }

    /*
     *
     *   查询节点信息（按工作流ID）
     *   返回结果集
     *
     * */
    public List<WfFlowNode> queryNode(Long flowId, PagerUtil pager) {
        if(DataUtil.isNull(flowId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query node info failed -- invalid query condition.", "无效查询条件");
        }

        try {
            PagerUtil.startPage(pager);
            WfFlowNodeExample example = new WfFlowNodeExample();
            example.createCriteria().andOwnerFlowIdEqualTo(flowId).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            example.setOrderByClause("CREATE_TIME ASC");
            return wfFlowNodeMapper.selectByExample(example);
        } catch (Throwable e) {
            PagerUtil.clearPage(pager);
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query node info failed.", "查询节点信息失败", e);
        }
    }
}
