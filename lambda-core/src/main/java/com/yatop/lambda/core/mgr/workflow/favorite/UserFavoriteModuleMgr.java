package com.yatop.lambda.core.mgr.workflow.favorite;

import com.yatop.lambda.base.model.WfUserFavoriteModule;
import com.yatop.lambda.base.model.WfUserFavoriteModuleExample;
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
public class UserFavoriteModuleMgr extends BaseMgr {

    /*
     *
     *   插入用户收藏记录（项目ID、用户ID、工作流模块ID ...）
     *   返回插入记录
     *
     * */
    public WfUserFavoriteModule insertUserFavoriteModule(WfUserFavoriteModule favorite, String operId) {
        if( DataUtil.isNull(favorite) ||
                favorite.isProjectIdNotColoured() ||
                favorite.isOperIdNotColoured() ||
                favorite.isModuleIdNotColoured() ||
                DataUtil.isEmpty(operId) ) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Insert user favorite module failed -- invalid insert data.", "无效插入数据");
        }

        if(existsUserFavoriteModule(favorite.getProjectId(), favorite.getOperId(), favorite.getModuleId())) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Insert user favorite module failed -- user favorite module existed.", "用户收藏记录已存在");
        }

        WfUserFavoriteModule insertFavorite = new WfUserFavoriteModule();
        try {
            Date dtCurrentTime = SystemTimeUtil.getCurrentTime();
            insertFavorite.copyProperties(favorite);
            insertFavorite.setStatus(DataStatusEnum.NORMAL.getStatus());
            insertFavorite.setLastUpdateTime(dtCurrentTime);
            insertFavorite.setLastUpdateOper(operId);
            insertFavorite.setCreateTime(dtCurrentTime);
            insertFavorite.setCreateOper(operId);
            wfUserFavoriteModuleMapper.insertSelective(insertFavorite);
            return insertFavorite;
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Insert user favorite module failed.", "插入用户收藏记录失败", e);
        }
    }

    /*
     *
     *   逻辑删除用户收藏记录
     *   返回删除数量
     *
     * */
    public int deleteUserFavoriteModule(Long projectId, String favoriteOper, Long moduleId, String operId)  {
        if(DataUtil.isNull(projectId) ||
                DataUtil.isEmpty(favoriteOper) ||
                DataUtil.isNull(moduleId) ||
                DataUtil.isEmpty(operId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Delete user favorite module failed -- invalid delete condition.", "无效删除条件");
        }

        if(!existsUserFavoriteModule(projectId, favoriteOper, moduleId)) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Delete user favorite module failed -- user favorite module not found.", "用户收藏记录未找到");
        }

        try {
            WfUserFavoriteModule deleteFavorite = new WfUserFavoriteModule();
            deleteFavorite.setStatus(DataStatusEnum.INVALID.getStatus());
            deleteFavorite.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            deleteFavorite.setLastUpdateOper(operId);

            WfUserFavoriteModuleExample example = new WfUserFavoriteModuleExample();
            example.createCriteria().andProjectIdEqualTo(projectId).andOperIdEqualTo(favoriteOper).andModuleIdEqualTo(moduleId)
                    .andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            return wfUserFavoriteModuleMapper.updateByExampleSelective(deleteFavorite, example);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Delete user favorite module exists failed.", "删除用户收藏记录失败", e);
        }
    }

    /*
     *
     *   查询用户收藏记录（项目ID + 用户ID）
     *   返回结果集
     *
     * */
    public List<WfUserFavoriteModule> queryUserFavoriteModule(Long projectId, String operId, PagerUtil pager) {
        if(DataUtil.isNull(projectId) || DataUtil.isNull(operId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query user favorite module failed -- invalid query condition.", "无效查询条件");
        }

        try {
            PagerUtil.startPage(pager);
            WfUserFavoriteModuleExample example = new  WfUserFavoriteModuleExample();
            example.createCriteria().andProjectIdEqualTo(projectId).andOperIdEqualTo(operId).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            return wfUserFavoriteModuleMapper.selectByExample(example);
        } catch (Throwable e) {
            PagerUtil.clearPage(pager);
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query user favorite module failed.", "查询用户收藏记录失败", e);
        }
    }

    /*
     *
     *   检查用户收藏是否已存在
     *   返回是否已存在
     *
     * */
    public boolean existsUserFavoriteModule(Long projectId, String favoriteOper, Long moduleId)  {
        if(DataUtil.isNull(projectId) || DataUtil.isEmpty(favoriteOper) || DataUtil.isNull(moduleId))
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Check user favorite module exists failed -- invalid check condition.", "无效检查条件");

        try {
            WfUserFavoriteModuleExample example = new WfUserFavoriteModuleExample();
            example.createCriteria().andProjectIdEqualTo(projectId).andOperIdEqualTo(favoriteOper).andModuleIdEqualTo(moduleId).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            return wfUserFavoriteModuleMapper.countByExample(example) > 0 ? true : false;
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Check user favorite module exists failed.", "检查用户收藏是否已存在失败", e);
        }
    }
}
