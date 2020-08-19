package com.thinkerwolf.thinkmall.sso.service;

import com.thinkerwolf.thinkmall.common.OpResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SystemService implements ISystemService {

    private static final Logger logger = LoggerFactory.getLogger(SystemService.class);

    @Override
    public OpResult info() {
        Map<String, Object> data = new HashMap<>();
        data.put("pic", "avi");
        return OpResult.ok(data);
    }
}
