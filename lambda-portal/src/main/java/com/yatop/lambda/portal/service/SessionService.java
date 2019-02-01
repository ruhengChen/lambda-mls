package com.yatop.lambda.portal.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yatop.lambda.portal.api.response.UserOnlineResp;
import com.yatop.lambda.portal.model.User;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//import com.yatop.lambda.portal.common.util.AddressUtils;

/**
 * Shiro Session 对象管理
 *
 * @author MrBird
 * @link https://mrbird.cc/Spring-Boot-Shiro%20session.html
 */
@Service("sessionService")
public class SessionService {

    @Autowired
    private SessionDAO sessionDAO;

    @Autowired
    ObjectMapper mapper;

    public List<UserOnlineResp> list() {
        List<UserOnlineResp> list = new ArrayList<>();
        Collection<Session> sessions = sessionDAO.getActiveSessions();
        for (Session session : sessions) {
            UserOnlineResp userOnlineResp = new UserOnlineResp();
            User user;
            SimplePrincipalCollection principalCollection;
            if (session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY) == null) {
                continue;
            } else {
                principalCollection = (SimplePrincipalCollection) session
                        .getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
                user = (User) principalCollection.getPrimaryPrincipal();
                userOnlineResp.setUsername(user.getUsername());
                userOnlineResp.setUserId(user.getUserId().toString());
            }
            userOnlineResp.setId((String) session.getId());
            userOnlineResp.setHost(session.getHost());
            userOnlineResp.setStartTimestamp(session.getStartTimestamp());
            userOnlineResp.setLastAccessTime(session.getLastAccessTime());
            long timeout = session.getTimeout();
            userOnlineResp.setStatus(timeout == 0L ? "0" : "1");
//            String address = AddressUtils.getCityInfo(userOnlineResp.getHost());
//            userOnlineResp.setLocation(address);
            userOnlineResp.setTimeout(timeout);
            list.add(userOnlineResp);
        }
        return list;
    }

    public boolean forceLogout(String sessionId) {
        Session session = sessionDAO.readSession(sessionId);
        session.setTimeout(0);
        session.stop();
        sessionDAO.delete(session);
        return true;
    }

}
