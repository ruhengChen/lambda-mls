package com.yatop.lambda.core.mgr.workflow;

import com.yatop.lambda.base.model.WfUserFavoriteTable;
import com.yatop.lambda.base.model.WfUserFavoriteTableExample;
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
public class UserFavoriteTableMgr extends BaseMgr {

    /*
     *
     *   插入用户收藏记录（项目ID、用户ID、数据表ID ...）
     *   返回插入记录
     *
     * */
    public WfUserFavoriteTable insertUserFavoriteTable(WfUserFavoriteTable favorite, String operId) {
        if( DataUtil.isNull(favorite) ||
                favorite.isProjectIdNotColoured() ||
                favorite.isOperIdNotColoured() ||
                favorite.isTableIdNotColoured() ||
                DataUtil.isEmpty(operId) ) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Insert user favorite table failed -- invalid insert data.", "无效插入数据");
        }

        if(existsUserFavoriteTable(favorite.getProjectId(), favorite.getOperId(), favorite.getTableId())) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Insert user favorite table failed -- user favorite table existed.", "用户收藏记录已存在");
        }

        WfUserFavoriteTable insertFavorite = new WfUserFavoriteTable();
        try {
            Date dtCurrentTime = SystemTimeUtil.getCurrentTime();
            insertFavorite.copyProperties(favorite);
            insertFavorite.setStatus(DataStatusEnum.NORMAL.getStatus());
            insertFavorite.setLastUpdateTime(dtCurrentTime);
            insertFavorite.setLastUpdateOper(operId);
            insertFavorite.setCreateTime(dtCurrentTime);
            insertFavorite.setCreateOper(operId);
            wfUserFavoriteTableMapper.insertSelective(insertFavorite);
            return insertFavorite;
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Insert user favorite table failed.", "插入用户收藏记录失败", e);
        }
    }

    /*
     *
     *   逻辑删除用户收藏记录
     *   返回删除数量
     *
     * */
    public int deleteUserFavoriteTable(WfUserFavoriteTable favorite, String operId)  {
        if(DataUtil.isNull(favorite) ||
                favorite.isProjectIdNotColoured() ||
                favorite.isOperIdNotColoured() ||
                favorite.isTableIdNotColoured() ||
                DataUtil.isEmpty(operId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Delete user favorite table failed -- invalid delete condition.", "无效删除条件");
        }

        if(!existsUserFavoriteTable(favorite.getProjectId(), favorite.getOperId(), favorite.getTableId())) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Delete user favorite table failed -- user favorite table not found.", "用户收藏记录未找到");
        }

        try {
            WfUserFavoriteTable deleteFavorite = new WfUserFavoriteTable();
            deleteFavorite.setStatus(DataStatusEnum.INVALID.getStatus());
            deleteFavorite.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            deleteFavorite.setLastUpdateOper(operId);

            WfUserFavoriteTableExample example = new WfUserFavoriteTableExample();
            example.createCriteria().andProjectIdEqualTo(favorite.getProjectId()).andOperIdEqualTo(favorite.getOperId()).andTableIdEqualTo(favorite.getTableId())
                    .andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            return wfUserFavoriteTableMapper.updateByExampleSelective(deleteFavorite, example);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Delete user favorite table exists failed.", "删除用户收藏记录失败", e);
        }
    }

    /*
     *
     *   查询用户收藏记录（项目ID + 用户ID）
     *   返回结果集
     *
     * */
    public List<WfUserFavoriteTable> queryUserFavoriteTable(Long projectId, String operId, PagerUtil pager) {
        if(DataUtil.isNull(projectId) || DataUtil.isNull(operId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query user favorite table failed -- invalid query condition.", "无效查询条件");
        }

        try {
            PagerUtil.startPage(pager);
            WfUserFavoriteTableExample example = new  WfUserFavoriteTableExample();
            example.createCriteria().andProjectIdEqualTo(projectId).andOperIdEqualTo(operId).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            return wfUserFavoriteTableMapper.selectByExample(example);
        } catch (Throwable e) {
            PagerUtil.clearPage(pager);
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query user favorite table failed.", "查询用户收藏记录失败", e);
        }
    }

    /*
     *
     *   检查用户收藏是否已存在
     *   返回是否已存在
     *
     * */
    public boolean existsUserFavoriteTable(Long projectId, String OperId, Long tableId)  {
        if(DataUtil.isNull(projectId) || DataUtil.isEmpty(OperId) || DataUtil.isNull(tableId))
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Check user favorite table exists failed -- invalid check condition.", "无效检查条件");

        try {
            WfUserFavoriteTableExample example = new WfUserFavoriteTableExample();
            example.createCriteria().andProjectIdEqualTo(projectId).andOperIdEqualTo(OperId).andTableIdEqualTo(tableId).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            return wfUserFavoriteTableMapper.countByExample(example) > 0 ? true : false;
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Check user favorite table exists failed.", "检查用户收藏是否已存在失败", e);
        }
    }
}
