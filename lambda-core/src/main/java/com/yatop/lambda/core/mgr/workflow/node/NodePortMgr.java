package com.yatop.lambda.core.mgr.workflow.node;

import com.yatop.lambda.base.model.WfFlowNode;
import com.yatop.lambda.base.model.WfFlowNodePort;
import com.yatop.lambda.base.model.WfFlowNodePortExample;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.mgr.base.BaseMgr;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.core.utils.SystemTimeUtil;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NodePortMgr extends BaseMgr {

    /*
     *
     *   插入新节点端口（名称、所属节点ID、引用工作流组件端口ID、引用特征ID ...）
     *   返回插入记录
     *
     * */
    public WfFlowNodePort insertNodePort(WfFlowNodePort nodePort, String operId) {
        if( DataUtil.isNull(nodePort) ||
                nodePort.isNodePortNameNotColoured() ||
                nodePort.isOwnerNodeIdNotColoured() ||
                nodePort.isRefPortIdNotColoured() ||
                nodePort.isRefCharIdNotColoured() ||
                DataUtil.isEmpty(operId) ) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Insert node port failed -- invalid insert data.", "无效插入数据");
        }

        WfFlowNodePort insertNodePort = new WfFlowNodePort();
        try {
            Date dtCurrentTime = SystemTimeUtil.getCurrentTime();
            insertNodePort.copyProperties(nodePort);
            insertNodePort.setNodePortIdColoured(false);
            insertNodePort.setStatus(DataStatusEnum.NORMAL.getStatus());
            insertNodePort.setLastUpdateTime(dtCurrentTime);
            insertNodePort.setLastUpdateOper(operId);
            insertNodePort.setCreateTime(dtCurrentTime);
            insertNodePort.setCreateOper(operId);
            wfFlowNodePortMapper.insertSelective(insertNodePort);
            return insertNodePort;
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Insert node port failed.", "插入节点端口失败", e);
        }
    }

    /*
     *
     *   逻辑删除节点端口（按节点）
     *   返回删除数量
     *
     * */
    public int deleteNodePort(WfFlowNode node, String operId) {
        if(DataUtil.isNull(node) || node.isNodeIdNotColoured() || DataUtil.isEmpty(operId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Delete node port -- invalid delete condition.", "无效删除条件");
        }

        try {
            WfFlowNodePort deleteNodePort = new WfFlowNodePort();
            deleteNodePort.setStatus(DataStatusEnum.INVALID.getStatus());
            deleteNodePort.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            deleteNodePort.setLastUpdateOper(operId);
            WfFlowNodePortExample example = new WfFlowNodePortExample();
            example.createCriteria().andOwnerNodeIdEqualTo(node.getNodeId()).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            return wfFlowNodePortMapper.updateByExampleSelective(deleteNodePort, example);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Delete node port failed.", "删除节点端口失败", e);
        }
    }

    /*
     *
     *   恢复节点端口（按节点）
     *   返回恢复数量
     *
     * */
    public int recoverNodePort(WfFlowNode node, String operId) {
        if(DataUtil.isNull(node) || node.isNodeIdNotColoured() || DataUtil.isEmpty(operId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Recover node port -- invalid recover condition.", "无效恢复条件");
        }

        try {
            WfFlowNodePort recoverNodePort = new WfFlowNodePort();
            recoverNodePort.setStatus(DataStatusEnum.NORMAL.getStatus());
            recoverNodePort.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            recoverNodePort.setLastUpdateOper(operId);
            WfFlowNodePortExample example = new WfFlowNodePortExample();
            example.createCriteria().andOwnerNodeIdEqualTo(node.getNodeId()).andStatusEqualTo(DataStatusEnum.INVALID.getStatus());
            return wfFlowNodePortMapper.updateByExampleSelective(recoverNodePort, example);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Recover node port failed.", "恢复节点端口失败", e);
        }
    }

    /*
     *
     *   查询节点端口（按ID）
     *   返回结果
     *
     * */
    public WfFlowNodePort queryNodePort(Long id) {
        if(DataUtil.isNull(id)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query node port failed -- invalid query condition.", "无效查询条件");
        }

        WfFlowNodePort nodePort;
        try {
            nodePort = wfFlowNodePortMapper.selectByPrimaryKey(id);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query node port failed.", "查询节点端口失败", e);
        }

        if(DataUtil.isNull(nodePort) || (nodePort.getStatus() == DataStatusEnum.INVALID.getStatus()))
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query node port failed -- invalid status or not found.", "已删除或未查找到");

        return nodePort;
    }

    /*
     *
     *   查询节点端口（按节点ID）
     *   返回结果集
     *
     * */
    public List<WfFlowNodePort> queryNodePortByNodeId(Long nodeId) {
        if(DataUtil.isNull(nodeId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query node port failed -- invalid query condition.", "无效查询条件");
        }

        try {
            WfFlowNodePortExample example = new WfFlowNodePortExample();
            example.createCriteria().andOwnerNodeIdEqualTo(nodeId).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            example.setOrderByClause("CREATE_TIME ASC");
            return wfFlowNodePortMapper.selectByExample(example);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query node port failed.", "查询节点端口失败", e);
        }
    }
}
