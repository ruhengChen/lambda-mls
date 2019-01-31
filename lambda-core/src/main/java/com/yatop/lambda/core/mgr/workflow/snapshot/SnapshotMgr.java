package com.yatop.lambda.core.mgr.workflow.snapshot;

import com.yatop.lambda.base.model.WfSnapshot;
import com.yatop.lambda.base.model.WfSnapshotExample;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.mgr.base.BaseMgr;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.enums.SnapshotTypeEnum;
import com.yatop.lambda.core.enums.SnapshotStateEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.core.utils.PagerUtil;
import com.yatop.lambda.core.utils.SystemTimeUtil;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SnapshotMgr extends BaseMgr {

    /*
     *
     *   插入新快照信息（名称、快照来源、所属项目ID、所属工作流ID、快照版本号 ...）
     *   返回插入记录
     *
     * */
    public WfSnapshot insertSnapshot(WfSnapshot snapshot, String operId) {
        if( DataUtil.isNull(snapshot) ||
                snapshot.isSnapshotNameNotColoured() ||
                snapshot.isSnapshotTypeNotColoured() ||
                snapshot.isOwnerProjectIdNotColoured() ||
                snapshot.isOwnerFlowIdNotColoured() ||
                snapshot.isSnapshotVersionNotColoured() ||
                snapshot.isSnapshotStateNotColoured() ||
                DataUtil.isEmpty(operId) ) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Insert snapshot info failed -- invalid insert data.", "无效插入数据");
        }

        WfSnapshot insertSnapshot = new WfSnapshot();
        try {
            Date dtCurrentTime = SystemTimeUtil.getCurrentTime();
            insertSnapshot.copyProperties(snapshot);
            insertSnapshot.setSnapshotIdColoured(false);
            insertSnapshot.setStatus(DataStatusEnum.NORMAL.getStatus());
            insertSnapshot.setLastUpdateTime(dtCurrentTime);
            insertSnapshot.setLastUpdateOper(operId);
            insertSnapshot.setCreateTime(dtCurrentTime);
            insertSnapshot.setCreateOper(operId);
            wfSnapshotMapper.insertSelective(insertSnapshot);
            return insertSnapshot;
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Insert snapshot info failed.", "插入快照信息失败", e);
        }
    }

    /*
     *
     *   逻辑删除快照信息
     *   返回删除数量
     *
     * */
    public int deleteSnapshot(Long snapshotId, String operId) {
        if(DataUtil.isNull(snapshotId) || DataUtil.isEmpty(operId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Delete snapshot info -- invalid delete condition.", "无效删除条件");
        }

        try {
            WfSnapshot deleteSnapshot = new WfSnapshot();
            deleteSnapshot.setSnapshotId(snapshotId);
            deleteSnapshot.setStatus(DataStatusEnum.INVALID.getStatus());
            deleteSnapshot.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            deleteSnapshot.setLastUpdateOper(operId);
            return wfSnapshotMapper.updateByPrimaryKeySelective(deleteSnapshot);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Delete snapshot info failed.", "删除快照信息失败", e);
        }
    }

    /*
     *
     *   逻辑删除快照信息
     *   返回删除数量
     *
     * */
    public int deleteSnapshot4Copy(Long snapshotId, String operId) {
        if(DataUtil.isNull(snapshotId) || DataUtil.isEmpty(operId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Delete snapshot info -- invalid delete condition.", "无效删除条件");
        }

        try {
            WfSnapshot deleteSnapshot = new WfSnapshot();
            deleteSnapshot.setSnapshotContent(null);
            deleteSnapshot.setStatus(DataStatusEnum.INVALID.getStatus());
            deleteSnapshot.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            deleteSnapshot.setLastUpdateOper(operId);

            WfSnapshotExample example = new WfSnapshotExample();
            example.createCriteria().andSnapshotIdEqualTo(snapshotId).andSnapshotTypeEqualTo(SnapshotTypeEnum.COPY.getType()).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            return wfSnapshotMapper.updateByExampleWithBLOBs(deleteSnapshot, example);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Delete snapshot info failed.", "删除快照信息失败", e);
        }
    }

    /*
     *
     *   逻辑删除快照信息（按工作流ID）
     *   返回删除数量
     *
     * */
/*    public int deleteSnapshotByWorkflowId(Long workflowId, String operId) {
        if(DataUtil.isNull(workflowId) || DataUtil.isEmpty(operId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Delete snapshot info -- invalid delete condition.", "无效删除条件");
        }

        try {
            WfSnapshot deleteSnapshot = new WfSnapshot();
            deleteSnapshot.setStatus(DataStatusEnum.INVALID.getStatus());
            deleteSnapshot.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            deleteSnapshot.setLastUpdateOper(operId);
            WfSnapshotExample example = new WfSnapshotExample();
            example.createCriteria().andOwnerFlowIdEqualTo(workflowId).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            return wfSnapshotMapper.updateByExampleSelective(deleteSnapshot, example);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Delete snapshot info failed.", "删除快照信息失败", e);
        }
    }
*/

    /*
     *
     *   更新快照信息（名称、快照内容、快照状态、描述）
     *   返回更新数量
     *
     * */
    public int updateSnapshot(WfSnapshot snapshot, String operId) {
        if( DataUtil.isNull(snapshot) || DataUtil.isNull(snapshot.getSnapshotId()) || DataUtil.isEmpty(operId)) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Update snapshot info failed -- invalid update condition.", "无效更新条件");
        }

        if(snapshot.isSnapshotNameColoured() &&
                snapshot.isSnapshotContentNotColoured() &&
                snapshot.isSnapshotStateNotColoured() &&
                snapshot.isDescriptionNotColoured()) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Update snapshot info failed -- invalid update data.", "无效更新内容");
        }

        WfSnapshot updateSnapshot = new WfSnapshot();
        try {
            updateSnapshot.setSnapshotId(snapshot.getSnapshotId());
            if(snapshot.isSnapshotNameColoured())
                updateSnapshot.setSnapshotName(snapshot.getSnapshotName());
            if(snapshot.isSnapshotContentColoured())
                updateSnapshot.setSnapshotContent(snapshot.getSnapshotContent());
            if(snapshot.isSnapshotStateColoured())
                updateSnapshot.setSnapshotState(snapshot.getSnapshotState());
            if(snapshot.isDescriptionColoured())
                updateSnapshot.setDescription(snapshot.getDescription());

            updateSnapshot.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            updateSnapshot.setLastUpdateOper((operId));

            snapshot.setLastUpdateTime(updateSnapshot.getLastUpdateTime());
            snapshot.setLastUpdateOper(updateSnapshot.getLastUpdateOper());
            return wfSnapshotMapper.updateByPrimaryKeySelective(updateSnapshot);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Update snapshot info failed.", "更新快照信息失败", e);
        }
    }

    /*
     *
     *   查询快照信息（按ID）
     *   返回结果
     *
     * */
    public WfSnapshot querySnapshot(Long id) {
        if(DataUtil.isNull(id)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query snapshot info failed -- invalid query condition.", "无效查询条件");
        }

        WfSnapshot snapshot;
        try {
            snapshot = wfSnapshotMapper.selectByPrimaryKey(id);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query snapshot info failed.", "查询快照信息失败", e);
        }

        if(DataUtil.isNull(snapshot) || (snapshot.getStatus() == DataStatusEnum.INVALID.getStatus()))
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query snapshot info failed -- invalid status or not found.", "已删除或未查找到");

        return snapshot;
    }

    /*
     *
     *   查询快照信息（按项目ID + [工作流ID] + [快照类型] + [快照状态]）
     *   返回结果集
     *
     * */
    public List<WfSnapshot> querySnapshot(Long projectId, Long flowId, SnapshotTypeEnum typeEnum, SnapshotStateEnum stateEnum, PagerUtil pager) {
        if(DataUtil.isNull(projectId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query snapshot info failed -- invalid query condition.", "无效查询条件");
        }

        try {
            PagerUtil.startPage(pager);
            WfSnapshotExample example = new WfSnapshotExample();
            WfSnapshotExample.Criteria cond = example.createCriteria().andOwnerProjectIdEqualTo(projectId);

            if(DataUtil.isNotNull(flowId))
                cond.andOwnerFlowIdEqualTo(flowId);
            if(DataUtil.isNotNull(typeEnum))
                cond.andSnapshotTypeEqualTo(typeEnum.getType());
            if(DataUtil.isNotNull(stateEnum))
                cond.andSnapshotStateEqualTo(stateEnum.getState());

            cond.andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            example.setOrderByClause("CREATE_TIME ASC");
            return wfSnapshotMapper.selectByExample(example);
        } catch (Throwable e) {
            PagerUtil.clearPage(pager);
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query snapshot info failed.", "查询快照信息失败", e);
        }
    }
}
