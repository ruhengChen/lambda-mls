package com.yatop.lambda.core.mgr.project;

import com.yatop.lambda.base.model.PrProjectMember;
import com.yatop.lambda.base.model.PrProjectMemberExample;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.mgr.base.BaseMgr;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.enums.ProjectRoleEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.core.utils.PagerUtil;
import com.yatop.lambda.core.utils.SystemTimeUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class ProjectMemberMgr extends BaseMgr {

    /*
     *
     *   插入项目成员记录（项目ID、是否为所有者、用户名 ...）
     *   返回插入记录
     *
     * */
    public PrProjectMember insertProjectMember(PrProjectMember member, String operId) {
        if( DataUtil.isNull(member) ||
                member.isProjectIdNotColoured() ||
                member.isProjectRoleNotColoured() ||
                member.isMemberUserNotColoured() ||
                DataUtil.isEmpty(operId) ) {
            throw new LambdaException(LambdaExceptionEnum.B_PROJECT_DEFAULT_ERROR, "Insert project member failed -- invalid insert data.", "无效插入数据");
        }

        if(existsProjectMember(member.getProjectId(), member.getMemberUser())) {
            throw new LambdaException(LambdaExceptionEnum.B_PROJECT_DEFAULT_ERROR, "Insert project member failed -- project member existed.", "项目成员记录已存在");
        }

        if(member.getProjectRole() == ProjectRoleEnum.PROJECT_OWNER.getRole() && existsProjectOwner(member.getProjectId())) {
            throw new LambdaException(LambdaExceptionEnum.B_PROJECT_DEFAULT_ERROR, "Insert project member failed -- project owner existed.", "已存在项目所有者");
        }

        PrProjectMember insertMember = new PrProjectMember();
        try {
            Date dtCurrentTime = SystemTimeUtil.getCurrentTime();
            insertMember.copyProperties(insertMember);
            insertMember.setStatus(DataStatusEnum.NORMAL.getStatus());
            insertMember.setLastUpdateTime(dtCurrentTime);
            insertMember.setLastUpdateOper(operId);
            insertMember.setCreateTime(dtCurrentTime);
            insertMember.setCreateOper(operId);
            prProjectMemberMapper.insertSelective(insertMember);
            return insertMember;
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.B_PROJECT_DEFAULT_ERROR, "Insert project member failed.", "插入项目成员记录失败", e);
        }
    }

    /*
     *
     *   逻辑删除项目成员记录
     *   返回删除数量
     *
     * */
    public int deleteProjectMember(Long projectId, String memberId, String operId)  {
        if(DataUtil.isNull(projectId) || DataUtil.isEmpty(memberId) || DataUtil.isEmpty(operId)){
            throw new LambdaException(LambdaExceptionEnum.B_PROJECT_DEFAULT_ERROR, "Delete project member failed -- invalid delete condition.", "无效删除条件");
        }

        if(!existsProjectMember(projectId, memberId)) {
            throw new LambdaException(LambdaExceptionEnum.B_PROJECT_DEFAULT_ERROR, "Delete project member failed -- project member not found.", "项目成员记录未找到");
        }

        PrProjectMember ownerMember = queryProjectOwner(projectId);
        long allCount = countProjectMember(projectId);
        if(ownerMember.getProjectRole() == ProjectRoleEnum.PROJECT_OWNER.getRole() && allCount > 1) {
            throw new LambdaException(LambdaExceptionEnum.B_PROJECT_DEFAULT_ERROR, "Delete project member failed -- owner should transfer before delete.", "项目转出后再操作删除");
        }

        try {
            PrProjectMember deleteMember = new PrProjectMember();
            deleteMember.setStatus(DataStatusEnum.INVALID.getStatus());
            deleteMember.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            deleteMember.setLastUpdateOper(operId);

            PrProjectMemberExample example = new PrProjectMemberExample();
            example.createCriteria().andProjectIdEqualTo(projectId).andMemberUserEqualTo(memberId).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            return prProjectMemberMapper.updateByExampleSelective(deleteMember, example);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.B_PROJECT_DEFAULT_ERROR, "Delete project member exists failed.", "删除项目成员记录失败", e);
        }
    }

    /*
     *
     *   更改项目所有者
     *   返回更新数量
     *
     * */
    public int changeProjectOwner(Long projectId, String srcOwner, String dstOwner, String operId)  {
        if(DataUtil.isNull(projectId) ||
                DataUtil.isEmpty(srcOwner) ||
                DataUtil.isEmpty(dstOwner) ||
                srcOwner.equals(dstOwner) ||
                DataUtil.isEmpty(operId)){
            throw new LambdaException(LambdaExceptionEnum.B_PROJECT_DEFAULT_ERROR, "Change project Owner failed -- invalid change condition.", "无效更改条件");
        }

        List<PrProjectMember> resultList;
        resultList = queryProjectMember(projectId, new ArrayList<String>(Arrays.asList(srcOwner, dstOwner)), null);

        if(DataUtil.isEmpty(resultList) || resultList.size() < 2)
            throw new LambdaException(LambdaExceptionEnum.B_PROJECT_DEFAULT_ERROR, "Change project member failed -- project member missing", "转出或转入成员记录缺失");

        PrProjectMember srcProjectMember;
        int srcProjectIdex = 1;
        if(resultList.get(0).getMemberUser() == srcOwner) {
            srcProjectIdex = 0;
        }
        srcProjectMember = resultList.get(srcProjectIdex);
        if(srcProjectMember.getProjectRole() != ProjectRoleEnum.PROJECT_OWNER.getRole())
            throw new LambdaException(LambdaExceptionEnum.B_PROJECT_DEFAULT_ERROR, "Change project member failed -- transfer party not project owner", "转出方不是项目所有者");

        try {
            int affectRows = 0;
            PrProjectMember updateMember = new PrProjectMember();
            PrProjectMemberExample example = new PrProjectMemberExample();
            Date dtCurrentTime = SystemTimeUtil.getCurrentTime();

            updateMember.setProjectRole(ProjectRoleEnum.GENERAL_MEMBER.getRole());
            updateMember.setLastUpdateTime(dtCurrentTime);
            updateMember.setLastUpdateOper(operId);
            example.createCriteria().andProjectIdEqualTo(projectId).andMemberUserEqualTo(srcOwner);
            affectRows += prProjectMemberMapper.updateByExampleSelective(updateMember, example);

            updateMember.clear();
            example.clear();
            updateMember.setProjectRole(ProjectRoleEnum.PROJECT_OWNER.getRole());
            updateMember.setLastUpdateTime(dtCurrentTime);
            updateMember.setLastUpdateOper(operId);
            example.createCriteria().andProjectIdEqualTo(projectId).andMemberUserEqualTo(dstOwner);
            affectRows += prProjectMemberMapper.updateByExampleSelective(updateMember, example);
            return affectRows;
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.B_PROJECT_DEFAULT_ERROR, "Change project member failed.", "更改项目所有者失败", e);
        }
    }

    /*
     *
     *   查询项目成员记录（所有）
     *   返回结果集
     *
     * */
    public List<PrProjectMember> queryProjectMember(PagerUtil pager) {
        try {
            PagerUtil.startPage(pager);
            PrProjectMemberExample example = new PrProjectMemberExample();
            example.createCriteria().andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            example.setOrderByClause("CREATE_TIME ASC");
            return prProjectMemberMapper.selectByExample(example);
        } catch (Throwable e) {
            PagerUtil.clearPage(pager);
            throw new LambdaException(LambdaExceptionEnum.B_PROJECT_DEFAULT_ERROR, "Query project member failed.", "查询项目成员记录失败", e);
        }
    }

    /*
     *
     *   查询项目成员记录（按项目ID）
     *   返回结果集
     *
     * */
    public List<PrProjectMember> queryProjectMember(Long projectId, PagerUtil pager) {
        return queryProjectMember(projectId, new ArrayList<String>(), pager);
    }

    /*
     *
     *   查询项目成员记录（按项目ID, 成员用户）
     *   1.项目所有成员（用户列表null）
     *   2.项目下对应成员
     *   返回结果集
     *
     * */
    public List<PrProjectMember> queryProjectMember(Long projectId, List<String> memberUsers, PagerUtil pager) {
        if(DataUtil.isNull(projectId)){
            throw new LambdaException(LambdaExceptionEnum.B_PROJECT_DEFAULT_ERROR, "Query project member failed -- invalid query condition.", "无效查询条件");
        }

        try {
            PagerUtil.startPage(pager);
            PrProjectMemberExample example = new  PrProjectMemberExample();
            PrProjectMemberExample.Criteria cond = example.createCriteria().andProjectIdEqualTo(projectId);
            if(DataUtil.isNotEmpty(memberUsers))
                cond.andMemberUserIn(memberUsers);
            cond.andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            return prProjectMemberMapper.selectByExample(example);
        } catch (Throwable e) {
            PagerUtil.clearPage(pager);
            throw new LambdaException(LambdaExceptionEnum.B_PROJECT_DEFAULT_ERROR, "Query project member failed.", "查询项目成员记录失败", e);
        }
    }

    /*
     *
     *   查询项目成员记录（按角色）
     *   返回结果集
     *
     * */
    public List<PrProjectMember> queryProjectMember(Long projectId, ProjectRoleEnum role, PagerUtil pager) {
        if(DataUtil.isNull(projectId) || DataUtil.isNull(role)) {
            throw new LambdaException(LambdaExceptionEnum.B_PROJECT_DEFAULT_ERROR, "Query project member failed -- invalid query condition.", "无效查询条件");
        }

        try {
            PagerUtil.startPage(pager);
            PrProjectMemberExample example = new  PrProjectMemberExample();
            example.createCriteria().andProjectIdEqualTo(projectId).andProjectRoleEqualTo(role.getRole())
                    .andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            return prProjectMemberMapper.selectByExample(example);
        } catch (Throwable e) {
            PagerUtil.clearPage(pager);
            throw new LambdaException(LambdaExceptionEnum.B_PROJECT_DEFAULT_ERROR, "Query project member failed.", "查询项目成员记录失败", e);
        }
    }

    /*
     *
     *   查询项目所有者记录
     *   返回记录
     *
     * */
    public PrProjectMember queryProjectOwner(Long projectId) {
        List<PrProjectMember> resultList = queryProjectMember(projectId, ProjectRoleEnum.PROJECT_OWNER, null);
        if(DataUtil.isEmpty(resultList)) {
            throw new LambdaException(LambdaExceptionEnum.B_PROJECT_DEFAULT_ERROR, "Query project Owner failed -- project owner not found.", "项目所有者未找到");
        }
        return resultList.get(0);
    }

    /*
     *
     *   计数项目成员数量
     *   返回数量
     *
     * */
    public long countProjectMember(Long projectId) {
        return countProjectMember(projectId, null);
    }

    /*
     *
     *   计数项目成员数量（可选成员列表）
     *   返回数量
     *
     * */
    public long countProjectMember(Long projectId, List<String> memberUsers) {
        if(DataUtil.isNull(projectId))
            throw new LambdaException(LambdaExceptionEnum.B_PROJECT_DEFAULT_ERROR, "Count project member failed -- invalid count condition.", "无效计数条件");

        try {
            PrProjectMemberExample example = new PrProjectMemberExample();
            PrProjectMemberExample.Criteria cond = example.createCriteria().andProjectIdEqualTo(projectId);
            if(DataUtil.isNotEmpty(memberUsers))
                cond.andMemberUserIn(memberUsers);
            cond.andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            return prProjectMemberMapper.countByExample(example);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.B_PROJECT_DEFAULT_ERROR, "Count project member failed.", "计数项目成员失败", e);
        }
    }

    /*
     *
     *   检查项目成员是否已存在
     *   返回是否已存在
     *
     * */
    public boolean existsProjectMember(Long projectId, String memberUser)  {
        if(DataUtil.isNull(projectId) || DataUtil.isEmpty(memberUser))
            throw new LambdaException(LambdaExceptionEnum.B_PROJECT_DEFAULT_ERROR, "Check project member exists failed -- invalid check condition.", "无效检查条件");

        try {
            PrProjectMemberExample example = new PrProjectMemberExample();
            example.createCriteria().andProjectIdEqualTo(projectId).andMemberUserEqualTo(memberUser).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            return prProjectMemberMapper.countByExample(example) > 0 ? true : false;
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.B_PROJECT_DEFAULT_ERROR, "Check project member exists failed.", "检查项目成员是否已存在失败", e);
        }
    }

    /*
     *
     *   检查项目所有者是否已存在
     *   返回是否已存在
     *
     * */
    public boolean existsProjectOwner(Long projectId)  {
        if(DataUtil.isNull(projectId))
            throw new LambdaException(LambdaExceptionEnum.B_PROJECT_DEFAULT_ERROR, "Check project owner exists failed -- invalid check condition.", "无效检查条件");

        try {
            PrProjectMemberExample example = new PrProjectMemberExample();
            example.createCriteria().andProjectIdEqualTo(projectId).andProjectRoleEqualTo(ProjectRoleEnum.PROJECT_OWNER.getRole())
                    .andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());

            return prProjectMemberMapper.countByExample(example) > 0 ? true : false;
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.B_PROJECT_DEFAULT_ERROR, "Check project owner exists failed.", "检查项目所有者是否已存在失败", e);
        }
    }
}
