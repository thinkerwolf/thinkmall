package com.thinkerwolf.thinkmall.sso.controller;

import com.thinkerwolf.thinkmall.common.OpResult;
import com.thinkerwolf.thinkmall.sso.service.WebHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RefreshScope
public class HelloController {

    @Autowired
    WebHelloService webHelloService;

    @RequestMapping(value = "/hello")
    @ResponseBody
    public OpResult hello(@RequestParam(value = "name", required = false) String name) {
        return webHelloService.hello(name);
    }

}
