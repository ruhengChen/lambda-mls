package com.yatop.lambda.core.mgr.workflow.node;

import com.yatop.lambda.base.model.WfFlowNodeLink;
import com.yatop.lambda.base.model.WfFlowNodeLinkExample;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.mgr.base.BaseMgr;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.core.utils.PagerUtil;
import com.yatop.lambda.core.utils.SystemTimeUtil;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NodeLinkMgr extends BaseMgr {

    /*
     *
     *   插入新节点链接（名称、所属工作流ID、是否为web组件流出链接、流出节点端口ID、流入节点端口ID ...）
     *   返回插入记录
     *
     * */
    public WfFlowNodeLink insertLink(WfFlowNodeLink link, String operId) {
        if( DataUtil.isNull(link) ||
                link.isLinkNameNotColoured() ||
                link.isOwnerFlowIdNotColoured() ||
                link.isIsWebLinkNotColoured() ||
                link.isSrcPortIdNotColoured() ||
                link.isDstPortIdNotColoured() ||
                DataUtil.isEmpty(operId) ) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Insert node link failed -- invalid insert data.", "无效插入数据");
        }

        WfFlowNodeLink insertLink = new WfFlowNodeLink();
        try {
            Date dtCurrentTime = SystemTimeUtil.getCurrentTime();
            insertLink.copyProperties(link);
            insertLink.setLinkIdColoured(false);
            insertLink.setStatus(DataStatusEnum.NORMAL.getStatus());
            insertLink.setLastUpdateTime(dtCurrentTime);
            insertLink.setLastUpdateOper(operId);
            insertLink.setCreateTime(dtCurrentTime);
            insertLink.setCreateOper(operId);
            wfFlowNodeLinkMapper.insertSelective(insertLink);
            return insertLink;
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Insert node link failed.", "插入节点链接失败", e);
        }
    }

    /*
     *
     *   逻辑删除节点链接（是否考虑物理删除）
     *   返回删除数量
     *
     * */
    public int deleteLink(WfFlowNodeLink link, String operId) {
        if(DataUtil.isNull(link) || link.isLinkIdNotColoured() || DataUtil.isEmpty(operId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Delete node link -- invalid delete condition.", "无效删除条件");
        }

        try {
            WfFlowNodeLink deleteLink = new WfFlowNodeLink();
            deleteLink.setLinkId(link.getLinkId());
            deleteLink.setStatus(DataStatusEnum.INVALID.getStatus());
            deleteLink.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            deleteLink.setLastUpdateOper(operId);
            return wfFlowNodeLinkMapper.updateByPrimaryKeySelective(deleteLink);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Delete node link failed.", "删除节点链接失败", e);
        }
    }

    /*
     *
     *   查询节点链接（按ID）
     *   返回结果
     *
     * */
    public WfFlowNodeLink queryLink(Long id) {
        if(DataUtil.isNull(id)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query node link failed -- invalid query condition.", "无效查询条件");
        }

        WfFlowNodeLink link;
        try {
            link = wfFlowNodeLinkMapper.selectByPrimaryKey(id);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query node link failed.", "查询节点链接失败", e);
        }

        if(DataUtil.isNull(link) || (link.getStatus() == DataStatusEnum.INVALID.getStatus()))
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query node link failed -- invalid status or not found.", "已删除或未查找到");

        return link;
    }

    /*
     *
     *   查询节点链接（按工作流ID）
     *   返回结果集
     *
     * */
    public List<WfFlowNodeLink> queryLink(Long flowId, PagerUtil pager) {
        if(DataUtil.isNull(flowId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query node link failed -- invalid query condition.", "无效查询条件");
        }

        try {
            PagerUtil.startPage(pager);
            WfFlowNodeLinkExample example = new WfFlowNodeLinkExample();
            example.createCriteria().andOwnerFlowIdEqualTo(flowId).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            example.setOrderByClause("CREATE_TIME ASC");
            return wfFlowNodeLinkMapper.selectByExample(example);
        } catch (Throwable e) {
            PagerUtil.clearPage(pager);
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query node link failed.", "查询节点链接失败", e);
        }
    }

    /*
     *
     *   查询节点链接（按输出节点端口ID）
     *   返回结果集
     *
     * */
    public List<WfFlowNodeLink> queryLinkBySrcPortId(Long nodePortId, PagerUtil pager) {
        if(DataUtil.isNull(nodePortId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query node link failed -- invalid query condition.", "无效查询条件");
        }

        try {
            PagerUtil.startPage(pager);
            WfFlowNodeLinkExample example = new WfFlowNodeLinkExample();
            example.createCriteria().andSrcPortIdEqualTo(nodePortId).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            example.setOrderByClause("CREATE_TIME ASC");
            return wfFlowNodeLinkMapper.selectByExample(example);
        } catch (Throwable e) {
            PagerUtil.clearPage(pager);
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query node link failed.", "查询节点链接失败", e);
        }
    }

    /*
     *
     *   查询节点链接（按输入节点端口）
     *   返回结果集
     *
     * */
    public List<WfFlowNodeLink> queryLinkByDstPortId(Long nodePortId, PagerUtil pager) {
        if(DataUtil.isNull(nodePortId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query node link failed -- invalid query condition.", "无效查询条件");
        }

        try {
            PagerUtil.startPage(pager);
            WfFlowNodeLinkExample example = new WfFlowNodeLinkExample();
            example.createCriteria().andDstPortIdEqualTo(nodePortId).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            example.setOrderByClause("CREATE_TIME ASC");
            return wfFlowNodeLinkMapper.selectByExample(example);
        } catch (Throwable e) {
            PagerUtil.clearPage(pager);
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query node link failed.", "查询节点链接失败", e);
        }
    }
}
