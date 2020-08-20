package com.thinkerwolf.thinkmall.sso.controller;

import com.thinkerwolf.thinkmall.common.OpResult;
import com.thinkerwolf.thinkmall.sso.IUserService;
import com.thinkerwolf.thinkmall.sso.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@RefreshScope
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/user/login")
    @ResponseBody
    public OpResult login(UserVo userVo) {
        return userService.login(userVo);
    }

    @RequestMapping(value = "/user/hello")
    @ResponseBody
    public OpResult hello(@RequestParam(value = "name", required = false) String name) {
        ResponseEntity<OpResult> re = restTemplate.getForEntity("http://thinkmall-sso-service/user/hello?name={1}", OpResult.class, name);
        return re.getBody();
    }

}
