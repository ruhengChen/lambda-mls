package com.yatop.lambda.core.mgr.workflow.execution;

import com.yatop.lambda.base.model.WfExecutionTask;
import com.yatop.lambda.base.model.WfExecutionTaskOutput;
import com.yatop.lambda.base.model.WfExecutionTaskOutputExample;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.mgr.base.BaseMgr;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.enums.OutputStateEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.core.utils.SystemTimeUtil;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ExecutionTaskOutputMgr extends BaseMgr {

    /*
     *
     *   插入新任务输出（任务ID、特征ID、特征值 ...）
     *   返回插入记录
     *
     * */
    public WfExecutionTaskOutput insertTaskOutput(WfExecutionTaskOutput taskOutput, String operId) {
        if( DataUtil.isNull(taskOutput) ||
                taskOutput.isTaskIdNotColoured() ||
                taskOutput.isCharIdNotColoured() ||
                DataUtil.isEmpty(operId) ) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Insert task output failed -- invalid insert data.", "无效插入数据");
        }

        WfExecutionTaskOutput insertTaskOutput = new WfExecutionTaskOutput();
        try {
            Date dtCurrentTime = SystemTimeUtil.getCurrentTime();
            insertTaskOutput.copyProperties(taskOutput);
            insertTaskOutput.setOutputState(OutputStateEnum.EMPTY.getState());
            insertTaskOutput.setStatus(DataStatusEnum.NORMAL.getStatus());
            insertTaskOutput.setLastUpdateTime(dtCurrentTime);
            insertTaskOutput.setLastUpdateOper(operId);
            insertTaskOutput.setCreateTime(dtCurrentTime);
            insertTaskOutput.setCreateOper(operId);
            wfExecutionTaskOutputMapper.insertSelective(insertTaskOutput);
            return insertTaskOutput;
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Insert task output failed.", "插入任务输出失败", e);
        }
    }

    /*
     *
     *   逻辑删除任务输出（按任务删除，删除实验是否需要删除运行信息待定）
     *   返回删除数量
     *
     * */
    public int deleteTaskOutput(WfExecutionTask task, String operId) {
        if(DataUtil.isNull(task) || task.isTaskIdNotColoured() || DataUtil.isEmpty(operId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Delete task output -- invalid delete condition.", "无效删除条件");
        }

        try {
            WfExecutionTaskOutput deleteTaskOutput = new WfExecutionTaskOutput();
            deleteTaskOutput.setStatus(DataStatusEnum.INVALID.getStatus());
            deleteTaskOutput.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            deleteTaskOutput.setLastUpdateOper(operId);
            WfExecutionTaskOutputExample example = new WfExecutionTaskOutputExample();
            example.createCriteria().andTaskIdEqualTo(task.getTaskId()).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            return wfExecutionTaskOutputMapper.updateByExampleSelective(deleteTaskOutput, example);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Delete task output failed.", "删除任务输出失败", e);
        }
    }

    /*
     *
     *   更新任务输出（特征值、输出状态、描述）
     *   返回更新数量
     *
     * */
    public int updateTaskOutput(WfExecutionTaskOutput taskOutput, String operId) {
        if( DataUtil.isNull(taskOutput) || taskOutput.isTaskIdNotColoured() || taskOutput.isCharIdNotColoured() || DataUtil.isEmpty(operId)) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Update task output failed -- invalid update condition.", "无效更新条件");
        }

        if(taskOutput.isCharValueNotColoured() &&
                taskOutput.isOutputStateNotColoured() &&
                taskOutput.isDescriptionNotColoured()) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Update task output failed -- invalid update data.", "无效更新内容");
        }

        WfExecutionTaskOutput updateTaskOutput = new WfExecutionTaskOutput();
        try {
            if(taskOutput.isCharValueColoured())
                updateTaskOutput.setCharValue(taskOutput.getCharValue());
            if(taskOutput.isOutputStateColoured())
                updateTaskOutput.setOutputState(taskOutput.getOutputState());
            if(taskOutput.isDescriptionColoured())
                updateTaskOutput.setDescription(taskOutput.getDescription());
            updateTaskOutput.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            updateTaskOutput.setLastUpdateOper((operId));

            WfExecutionTaskOutputExample example = new WfExecutionTaskOutputExample();
            example.createCriteria().andTaskIdEqualTo(taskOutput.getTaskId()).andCharIdEqualTo(taskOutput.getCharId()).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            return wfExecutionTaskOutputMapper.updateByExampleSelective(updateTaskOutput, example);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Update task output failed.", "更新任务输出失败", e);
        }
    }

    /*
     *
     *   查询任务输出（按任务ID + [特征ID]）
     *   返回结果
     *
     * */
    public List<WfExecutionTaskOutput> queryTaskOutput(Long taskId, String charId) {
        if(DataUtil.isNull(taskId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query task output failed -- invalid query condition.", "无效查询条件");
        }

        try {
            WfExecutionTaskOutputExample example = new WfExecutionTaskOutputExample();
            WfExecutionTaskOutputExample.Criteria cond = example.createCriteria().andTaskIdEqualTo(taskId);
            if(DataUtil.isEmpty(charId))
                cond.andCharIdEqualTo(charId);
            cond.andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            example.setOrderByClause("CREATE_TIME ASC");
            return wfExecutionTaskOutputMapper.selectByExample(example);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query task output failed.", "查询任务输出失败", e);
        }
    }

    /*
     *
     *   是否已存在任务输出
     *   返回结果集
     *
     * */
    public boolean existsTaskOutput(Long taskId, String charId) {
        if(DataUtil.isNull(taskId) || DataUtil.isEmpty(charId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Check task output exists failed -- invalid check condition.", "无效检查条件");
        }

        try {
            WfExecutionTaskOutputExample example = new WfExecutionTaskOutputExample();
            example.createCriteria().andTaskIdEqualTo(taskId).andCharIdEqualTo(charId).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            return wfExecutionTaskOutputMapper.countByExample(example) > 0 ? true : false;
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Check task output exists failed.", "检查任务输出是否已存在失败", e);
        }
    }
}
