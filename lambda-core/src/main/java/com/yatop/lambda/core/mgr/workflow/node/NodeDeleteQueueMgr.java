package com.yatop.lambda.core.mgr.workflow.node;

import com.yatop.lambda.base.model.WfFlowNodeDeleteQueue;
import com.yatop.lambda.base.model.WfFlowNodeDeleteQueueExample;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.mgr.base.BaseMgr;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.core.utils.SystemTimeUtil;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NodeDeleteQueueMgr extends BaseMgr {

    /*
     *   注意：插入之前需先检查删除批次序号是否已存在，先移除此删除批次再插入
     *
     *   插入新节点删除（工作流ID、节点ID、删除批次序号 ...）
     *   返回插入记录
     *
     * */
    public WfFlowNodeDeleteQueue insertNodeDelete(WfFlowNodeDeleteQueue nodeDelete, String operId) {
        if( DataUtil.isNull(nodeDelete) ||
                nodeDelete.isFlowIdNotColoured() ||
                nodeDelete.isNodeIdNotColoured() ||
                nodeDelete.isSequenceNotColoured() ||
                DataUtil.isEmpty(operId) ) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Insert node delete failed -- invalid insert data.", "无效插入数据");
        }

        if(checkNodeDelete(nodeDelete.getFlowId(), nodeDelete.getNodeId())) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Insert node delete failed -- system error<node already in delete queue>.", "系统错误<节点已在删除队列中>");
        }

        WfFlowNodeDeleteQueue insertNodeDelete = new WfFlowNodeDeleteQueue();
        try {
            Date dtCurrentTime = SystemTimeUtil.getCurrentTime();
            insertNodeDelete.copyProperties(nodeDelete);
            insertNodeDelete.setCreateTime(dtCurrentTime);
            insertNodeDelete.setCreateOper(operId);
            wfFlowNodeDeleteQueueMapper.insertSelective(insertNodeDelete);
            return insertNodeDelete;
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Insert node delete failed.", "插入节点删除失败", e);
        }
    }

    /*
     *
     *   移除节点删除（按工作流ID + 删除批次序号）
     *   返回删除数量
     *
     * */
    public int removeNodeDelete(WfFlowNodeDeleteQueue nodeDelete) {
        if(DataUtil.isNull(nodeDelete) || nodeDelete.isFlowIdNotColoured() || nodeDelete.isSequenceNotColoured()){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Remove node delete -- invalid remove condition.", "无效移除条件");
        }

        try {
            WfFlowNodeDeleteQueueExample example = new WfFlowNodeDeleteQueueExample();
            example.createCriteria().andFlowIdEqualTo(nodeDelete.getFlowId()).andSequenceEqualTo(nodeDelete.getSequence());
            return wfFlowNodeDeleteQueueMapper.deleteByExample(example);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Remove node delete failed.", "移除节点删除失败", e);
        }
    }

    /*
     *
     *   查询节点删除（按工作流ID + 删除序号）
     *   返回结果
     *
     * */
    public List<WfFlowNodeDeleteQueue> queryNodeDelete(Long flowId, Long Sequnce) {
        if(DataUtil.isNull(flowId) || DataUtil.isNull(Sequnce)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query node delete failed -- invalid query condition.", "无效查询条件");
        }

        List<WfFlowNodeDeleteQueue> resultList;
        try {
            WfFlowNodeDeleteQueueExample example = new WfFlowNodeDeleteQueueExample();
            example.createCriteria().andFlowIdEqualTo(flowId).andSequenceEqualTo(Sequnce);
            return wfFlowNodeDeleteQueueMapper.selectByExample(example);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query node delete failed.", "查询节点删除失败", e);
        }
    }

    /*
     *
     *   查询节点删除（按工作流ID）
     *   返回结果集
     *
     * */
    public List<WfFlowNodeDeleteQueue> queryNodeDelete(Long flowId) {
        if(DataUtil.isNull(flowId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query node delete failed -- invalid query condition.", "无效查询条件");
        }

        try {
            WfFlowNodeDeleteQueueExample example = new WfFlowNodeDeleteQueueExample();
            example.createCriteria().andNodeIdEqualTo(flowId);
            example.setOrderByClause("CREATE_TIME ASC");
            return wfFlowNodeDeleteQueueMapper.selectByExample(example);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query node delete failed.", "查询节点删除失败", e);
        }
    }

    /*
     *
     *   检查节点是否已在删除队列中
     *   返回结果集
     *
     * */
    public boolean checkNodeDelete(Long flowId, Long nodeId) {
        if(DataUtil.isNull(flowId) || DataUtil.isNull(nodeId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Check node delete exists failed -- invalid check condition.", "无效检查条件");
        }

        try {
            WfFlowNodeDeleteQueueExample example = new WfFlowNodeDeleteQueueExample();
            example.createCriteria().andFlowIdEqualTo(flowId).andNodeIdEqualTo(nodeId);
            return wfFlowNodeDeleteQueueMapper.countByExample(example) > 0 ? true : false;
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Check node delete exists failed.", "检查节点是否已在删除队列中失败", e);
        }
    }

    /*
     *
     *   是否已存在节点删除批次序号
     *   返回结果集
     *
     * */
    public boolean existsNodeDeleteSequence(Long flowId, Long sequence) {
        if(DataUtil.isNull(flowId) || DataUtil.isNull(sequence)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Check node delete exists failed -- invalid check condition.", "无效检查条件");
        }

        try {
            WfFlowNodeDeleteQueueExample example = new WfFlowNodeDeleteQueueExample();
            example.createCriteria().andFlowIdEqualTo(flowId).andSequenceEqualTo(sequence);
            return wfFlowNodeDeleteQueueMapper.countByExample(example) > 0 ? true : false;
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Check node delete exists failed.", "检查是否已存在节点删除序号失败", e);
        }
    }
}
