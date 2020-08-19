package com.thinkerwolf.thinkmall.sso.controller;

import com.thinkerwolf.thinkmall.common.OpResult;
import com.thinkerwolf.thinkmall.sso.IUserService;
import com.thinkerwolf.thinkmall.sso.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RefreshScope
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/user/login")
    @ResponseBody
    public OpResult login(UserVo userVo) {
        return userService.login(userVo);
    }

}
