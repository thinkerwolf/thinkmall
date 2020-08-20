package com.thinkerwolf.thinkmall.sso;

import com.thinkerwolf.thinkmall.common.OpResult;
import com.thinkerwolf.thinkmall.sso.vo.UserVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "thinkmall-sso-service")
public interface IUserService {

    @RequestMapping(value = "/user/login")
    OpResult login(@RequestBody UserVo userVo);

    @RequestMapping(value = "/user/hello")
    OpResult hello(@RequestParam(value = "name", required = false) String name);

}
