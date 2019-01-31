package com.yatop.lambda.portal.controller;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.portal.common.annotation.Log;
import com.yatop.lambda.portal.common.config.FebsProperties;
import com.yatop.lambda.portal.common.controller.BaseController;
import com.yatop.lambda.portal.common.domain.JsonResponse;
import com.yatop.lambda.portal.common.shiro.ShiroRealm;
import com.yatop.lambda.portal.common.util.MD5Utils;
import com.yatop.lambda.portal.model.User;
import com.yatop.lambda.portal.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Controller
public class LoginController extends BaseController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    private static final String CODE_KEY = "_code";

    @Autowired
    private ShiroRealm shiroRealm;


    @Autowired
    private FebsProperties febsProperties;

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public JsonResponse login(@RequestBody JSONObject jsonObject) {
//        String username, String password, String code, Boolean rememberMe
        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");
        String code = jsonObject.getString("code");
        Boolean rememberMe = jsonObject.getBoolean("rememberMe");

//        if (!StringUtils.isNotBlank(code)) {
//            return ResponseBo.warn("验证码不能为空！");
//        }
//        shiroRealm.setCachingEnabled(true);
//       shiroRealm.setAuthenticationCachingEnabled(true);

        try {
            password = MD5Utils.encrypt(username.toLowerCase(), password);
            UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
            Subject subject = getSubject();
            if (subject != null)
                subject.logout();
            super.login(token);
            this.userService.updateLoginTime(username);
//        PrincipalCollection principal = (PrincipalCollection) SecurityUtils.getSubject().getPrincipal();
            AuthorizationInfo simpleAuthorizationInfo = shiroRealm.doGetAuthorizationInfo(SecurityUtils.getSubject().getPrincipals());

            User user = this.userService.findByName(username);
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("userId", user.getUserId());
            hashMap.put("userName", user.getUsername());
            hashMap.put("roles", simpleAuthorizationInfo.getRoles());
            hashMap.put("stringPermissions", simpleAuthorizationInfo.getStringPermissions());


//        AuthorizationInfo simpleAuthorizationInfo = shiroRealm.getAuthorizationCache().get(SecurityUtils.getSubject().getPrincipals());
            return JsonResponse.build(hashMap);
        } catch (UnknownAccountException | IncorrectCredentialsException | LockedAccountException e) {
            return JsonResponse.build(e);
        } catch (AuthenticationException e) {
            return JsonResponse.build(new Exception("认证失败！"));
        }
//        String sessionCode = (String) session.getAttribute(CODE_KEY);
//        if (!code.equalsIgnoreCase(sessionCode)) {
//            return ResponseBo.warn("验证码错误！");
//        }
//        // 密码 MD5 加密
//        password = MD5Utils.encrypt(username.toLowerCase(), password);
//        UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
//        try {
//            Subject subject = getSubject();
//            if (subject != null)
//                subject.logout();
//            super.login(token);
//            this.userService.updateLoginTime(username);
//            return ResponseBo.ok();
//        } catch (UnknownAccountException | IncorrectCredentialsException | LockedAccountException e) {
//            return ResponseBo.error(e.getMessage());
//        } catch (AuthenticationException e) {
//            return ResponseBo.error("认证失败！");
//        }
    }

//    @GetMapping(value = "gifCode")
//    public void getGifCode(HttpServletResponse response, HttpServletRequest request) {
//        try {
//            response.setHeader("Pragma", "No-cache");
//            response.setHeader("Cache-Control", "no-cache");
//            response.setDateHeader("Expires", 0);
//            response.setContentType("image/gif");
//
//            Captcha captcha = new GifCaptcha(
//                    febsProperties.getValidateCode().getWidth(),
//                    febsProperties.getValidateCode().getHeight(),
//                    febsProperties.getValidateCode().getLength());
//            HttpSession session = request.getSession(true);
//            captcha.out(response.getOutputStream());
//            session.removeAttribute(CODE_KEY);
//            session.setAttribute(CODE_KEY, captcha.text().toLowerCase());
//        } catch (Exception e) {
//            log.error("图形验证码生成失败", e);
//        }
//    }

    @RequestMapping("/")
    public String redirectIndex() {
        return "redirect:/index";
    }

    @GetMapping("/403")
    public String forbid() {
        return "403";
    }

    @Log("访问系统")
    @RequestMapping("/index")
    public String index(@RequestBody Model model) {
        // 登录成后，即可通过 Subject 获取登录的用户信息
        User user = super.getCurrentUser();
        model.addAttribute("user", user);
        return "index";
    }
}
