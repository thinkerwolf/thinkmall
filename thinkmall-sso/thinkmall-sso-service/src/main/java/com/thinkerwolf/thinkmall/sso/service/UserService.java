package com.thinkerwolf.thinkmall.sso.service;

import com.thinkerwolf.thinkmall.common.OpResult;
import com.thinkerwolf.thinkmall.sso.IUserService;
import com.thinkerwolf.thinkmall.sso.vo.UserVo;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserService implements IUserService {

    @Override
    public OpResult login(UserVo userVo) {
        return OpResult.ok();
    }

    @Override
    public OpResult hello(String name) {
        Map<String, Object> data = new HashMap<>();
        data.put("say", "Hello " + name);
        return OpResult.ok(data);
    }
}
