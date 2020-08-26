package com.thinkerwolf.thinkmall.sso.service;

import com.thinkerwolf.thinkmall.common.OpResult;
import com.thinkerwolf.thinkmall.sso.IUserService;
import com.thinkerwolf.thinkmall.sso.vo.UserVo;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserServiceImpl implements IUserService {

    @Override
    public OpResult login(UserVo userVo) {
        return OpResult.ok();
    }


}
