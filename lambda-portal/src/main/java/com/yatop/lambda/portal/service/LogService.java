package com.yatop.lambda.portal.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.yatop.lambda.portal.common.service.IService;
import com.yatop.lambda.portal.model.SysLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.scheduling.annotation.Async;

import java.util.List;

public interface LogService extends IService<SysLog> {
	
	List<SysLog> findAllLogs(SysLog log);
	
	void deleteLogs(String logIds);

	@Async
	void saveLog(ProceedingJoinPoint point, SysLog log) throws JsonProcessingException;
}
