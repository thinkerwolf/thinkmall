package com.thinkerwolf.thinkmall.sso;

import com.thinkerwolf.thinkmall.common.OpResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "sso-service-hello")
public interface IHelloClient {

    @RequestMapping(value = "/hello")
    OpResult hello(@RequestParam(value = "name", required = false) String name);

    @RequestMapping(value = "/hellos")
    List<OpResult> hellos(@RequestParam(value = "names") String names);

}


