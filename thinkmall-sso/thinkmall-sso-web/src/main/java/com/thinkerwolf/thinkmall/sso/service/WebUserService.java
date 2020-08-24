package com.thinkerwolf.thinkmall.sso.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.thinkerwolf.thinkmall.common.OpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WebUserService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloFallback")
    public OpResult hello(String name) {
        ResponseEntity<OpResult> re = restTemplate.getForEntity("http://thinkmall-sso-service/user/hello?name={1}", OpResult.class, name);
        return re.getBody();
    }

    public OpResult helloFallback(String name) {
        return OpResult.fail("服务宕机");
    }

}
