package com.yatop.lambda.core.mgr.workflow;

import com.yatop.lambda.base.model.WfCodeScript;
import com.yatop.lambda.base.model.WfCodeScriptExample;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.mgr.base.BaseMgr;
import com.yatop.lambda.core.enums.CodeScriptTypeEnum;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.core.utils.PagerUtil;
import com.yatop.lambda.core.utils.SystemTimeUtil;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CodeScriptMgr extends BaseMgr {
    
    /*
     *
     *   插入新代码脚本（名称、脚本类型、所属项目ID、关联实验ID、关联工作流ID、关联快照版本号、关联运行作业ID、关联节点ID、关联特征ID、脚本状态 ...）
     *   返回插入记录
     *
     * */
    public WfCodeScript insertCodeScript(WfCodeScript codeScript, String operId) {
        if( DataUtil.isNull(codeScript) ||
                codeScript.isScriptNameNotColoured() ||
                codeScript.isScriptTypeNotColoured() ||
                codeScript.isOwnerProjectIdNotColoured() ||
                codeScript.isRelExperimentIdNotColoured() ||
                codeScript.isRelFlowIdNotColoured() ||
                codeScript.isRelSnapshotVersionNotColoured() ||
                codeScript.isRelJobIdNotColoured() ||
                codeScript.isRelNodeIdNotColoured() ||
                codeScript.isRelCharIdNotColoured() ||
                codeScript.isScriptStateNotColoured() ||
                DataUtil.isEmpty(operId) ) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Insert code script failed -- invalid insert data.", "无效插入数据");
        }

        WfCodeScript insertCodeScript = new WfCodeScript();
        try {
            Date dtCurrentTime = SystemTimeUtil.getCurrentTime();
            insertCodeScript.copyProperties(codeScript);
            insertCodeScript.setScriptIdColoured(false);
            insertCodeScript.setStatus(DataStatusEnum.NORMAL.getStatus());
            insertCodeScript.setLastUpdateTime(dtCurrentTime);
            insertCodeScript.setLastUpdateOper(operId);
            insertCodeScript.setCreateTime(dtCurrentTime);
            insertCodeScript.setCreateOper(operId);
            wfCodeScriptMapper.insertSelective(insertCodeScript);
            return insertCodeScript;
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Insert code script failed.", "插入代码脚本失败", e);
        }
    }

    /*
     *
     *   逻辑删除代码脚本
     *   返回删除数量
     *
     * */
    public int deleteCodeScript(WfCodeScript codeScript, String operId) {
        if(DataUtil.isNull(codeScript) || codeScript.isScriptIdNotColoured() || DataUtil.isEmpty(operId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Delete code script -- invalid delete condition.", "无效删除条件");
        }

        try {
            WfCodeScript deleteCodeScript = new WfCodeScript();
            deleteCodeScript.setScriptId(codeScript.getScriptId());
            deleteCodeScript.setStatus(DataStatusEnum.INVALID.getStatus());
            deleteCodeScript.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            deleteCodeScript.setLastUpdateOper(operId);
            return wfCodeScriptMapper.updateByPrimaryKeySelective(deleteCodeScript);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Delete code script failed.", "删除代码脚本失败", e);
        }
    }

    /*
     *
     *   恢复代码脚本
     *   返回恢复数量
     *
     * */
    public int recoverCodeScript(WfCodeScript codeScript, String operId) {
        if(DataUtil.isNull(codeScript) || codeScript.isScriptIdNotColoured() || DataUtil.isEmpty(operId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Recover code script -- invalid recover condition.", "无效恢复条件");
        }

        try {
            WfCodeScript recoverCodeScript = new WfCodeScript();
            recoverCodeScript.setScriptId(codeScript.getScriptId());
            recoverCodeScript.setStatus(DataStatusEnum.NORMAL.getStatus());
            recoverCodeScript.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            recoverCodeScript.setLastUpdateOper(operId);
            return wfCodeScriptMapper.updateByPrimaryKeySelective(recoverCodeScript);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Recover code script failed.", "恢复代码脚本失败", e);
        }
    }

    /*
     *
     *   更新代码脚本（名称、脚本内容、脚本状态、描述）
     *   返回更新数量
     *
     * */
    public int updateCodeScript(WfCodeScript codeScript, String operId) {
        if( DataUtil.isNull(codeScript) || codeScript.isScriptIdNotColoured() || DataUtil.isEmpty(operId)) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Update code script failed -- invalid update condition.", "无效更新条件");
        }

        if(codeScript.isScriptNameNotColoured() &&
                codeScript.isScriptContentNotColoured() &&
                codeScript.isScriptStateNotColoured() &&
                codeScript.isDescriptionNotColoured()) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Update code script failed -- invalid update data.", "无效更新内容");
        }

        WfCodeScript updateCodeScript = new WfCodeScript();
        try {
            updateCodeScript.setScriptId(codeScript.getScriptId());
            if(codeScript.isScriptNameColoured())
                updateCodeScript.setScriptName(codeScript.getScriptName());
            if(codeScript.isScriptContentColoured())
                updateCodeScript.setScriptContent(codeScript.getScriptName());
            if(codeScript.isScriptStateColoured())
                updateCodeScript.setScriptState(codeScript.getScriptState());
            if(codeScript.isDescriptionColoured())
                updateCodeScript.setDescription(codeScript.getDescription());

            updateCodeScript.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            updateCodeScript.setLastUpdateOper((operId));
            return wfCodeScriptMapper.updateByPrimaryKeySelective(updateCodeScript);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Update code script failed.", "更新代码脚本失败", e);
        }
    }

    /*
     *
     *   查询代码脚本（按ID）
     *   返回结果
     *
     * */
    public WfCodeScript queryCodeScript(Long id) {
        if(DataUtil.isNull(id)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query code script failed -- invalid query condition.", "无效查询条件");
        }

        WfCodeScript codeScript;
        try {
            codeScript = wfCodeScriptMapper.selectByPrimaryKey(id);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query code script failed.", "查询代码脚本失败", e);
        }

        if(DataUtil.isNull(codeScript) || (codeScript.getStatus() == DataStatusEnum.INVALID.getStatus()))
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query code script failed -- invalid status or not found.", "已删除或未查找到");

        return codeScript;
    }

    /*
     *
     *   查询代码脚本（项目ID + [脚本类型]）
     *   返回结果集
     *
     * */
    public List<WfCodeScript> queryCodeScript(Long projectId, CodeScriptTypeEnum typeEnum, PagerUtil pager) {
        if(DataUtil.isNull(projectId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query code script failed -- invalid query condition.", "无效查询条件");
        }

        try {
            PagerUtil.startPage(pager);
            WfCodeScriptExample example = new WfCodeScriptExample();
            WfCodeScriptExample.Criteria cond = example.createCriteria().andOwnerProjectIdEqualTo(projectId);

            if(DataUtil.isNotNull(typeEnum))
                cond.andScriptTypeEqualTo(typeEnum.getType());

            cond.andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            example.setOrderByClause("CREATE_TIME ASC");
            return wfCodeScriptMapper.selectByExample(example);
        } catch (Throwable e) {
            PagerUtil.clearPage(pager);
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query code script failed.", "查询代码脚本失败", e);
        }
    }
}
