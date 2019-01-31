package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.WfExecutionTask;
import com.yatop.lambda.base.model.WfExecutionTaskExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WfExecutionTaskMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_task
     *
     * @mbg.generated Fri Jan 25 00:48:21 CST 2019
     */
    long countByExample(WfExecutionTaskExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_task
     *
     * @mbg.generated Fri Jan 25 00:48:21 CST 2019
     */
    int deleteByExample(WfExecutionTaskExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_task
     *
     * @mbg.generated Fri Jan 25 00:48:21 CST 2019
     */
    int deleteByPrimaryKey(Long taskId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_task
     *
     * @mbg.generated Fri Jan 25 00:48:21 CST 2019
     */
    int insert(WfExecutionTask record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_task
     *
     * @mbg.generated Fri Jan 25 00:48:21 CST 2019
     */
    int insertSelective(WfExecutionTask record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_task
     *
     * @mbg.generated Fri Jan 25 00:48:21 CST 2019
     */
    List<WfExecutionTask> selectByExampleWithBLOBs(WfExecutionTaskExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_task
     *
     * @mbg.generated Fri Jan 25 00:48:21 CST 2019
     */
    List<WfExecutionTask> selectByExample(WfExecutionTaskExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_task
     *
     * @mbg.generated Fri Jan 25 00:48:21 CST 2019
     */
    WfExecutionTask selectByPrimaryKey(Long taskId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_task
     *
     * @mbg.generated Fri Jan 25 00:48:21 CST 2019
     */
    int updateByExampleSelective(@Param("record") WfExecutionTask record, @Param("example") WfExecutionTaskExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_task
     *
     * @mbg.generated Fri Jan 25 00:48:21 CST 2019
     */
    int updateByExampleWithBLOBs(@Param("record") WfExecutionTask record, @Param("example") WfExecutionTaskExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_task
     *
     * @mbg.generated Fri Jan 25 00:48:21 CST 2019
     */
    int updateByExample(@Param("record") WfExecutionTask record, @Param("example") WfExecutionTaskExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_task
     *
     * @mbg.generated Fri Jan 25 00:48:21 CST 2019
     */
    int updateByPrimaryKeySelective(WfExecutionTask record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_task
     *
     * @mbg.generated Fri Jan 25 00:48:21 CST 2019
     */
    int updateByPrimaryKeyWithBLOBs(WfExecutionTask record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_execution_task
     *
     * @mbg.generated Fri Jan 25 00:48:21 CST 2019
     */
    int updateByPrimaryKey(WfExecutionTask record);
}