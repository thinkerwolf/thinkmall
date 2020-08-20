package com.thinkerwolf.thinkmall.sso.controller;

import com.thinkerwolf.thinkmall.common.OpResult;
import com.thinkerwolf.thinkmall.sso.service.ISystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SystemController {

    @Autowired
    ISystemService systemService;

    @RequestMapping("/info")
    public OpResult info() {
        return systemService.info();
    }


}
