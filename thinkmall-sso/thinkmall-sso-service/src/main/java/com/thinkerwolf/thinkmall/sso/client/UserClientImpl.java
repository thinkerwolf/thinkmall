package com.thinkerwolf.thinkmall.sso.client;

import com.thinkerwolf.thinkmall.common.OpResult;
import com.thinkerwolf.thinkmall.sso.IUserClient;
import com.thinkerwolf.thinkmall.sso.vo.UserVo;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserClientImpl implements IUserClient {

    @Override
    public OpResult login(UserVo userVo) {
        return OpResult.ok();
    }


}
