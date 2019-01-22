package com.yatop.lambda.portal.service;

import com.yatop.lambda.portal.model.UserOnline;

import java.util.List;

public interface SessionService {

	List<UserOnline> list();

	boolean forceLogout(String sessionId);
}
