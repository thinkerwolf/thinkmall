package com.thinkerwolf.thinkmall.sso.service;

import com.thinkerwolf.thinkmall.common.OpResult;
import com.thinkerwolf.thinkmall.sso.IHelloService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RefreshScope
@RestController
public class HelloServiceImpl implements IHelloService {

    @Value("${from:xxxx}")
    private String from;

    @Override
    public OpResult hello(String name) {
        Map<String, Object> data = new HashMap<>();
        data.put("say", "Hello " + name + " from " + from);
        return OpResult.ok(data);
    }

    @Override
    public List<OpResult> hellos(String names) {
        List<OpResult> ops = new ArrayList<>();
        String[] nns = StringUtils.split(names, ",");
        if (nns != null) {
            for (String name : nns) {
                ops.add(hello(name));
            }
        }
        return ops;
    }
}
