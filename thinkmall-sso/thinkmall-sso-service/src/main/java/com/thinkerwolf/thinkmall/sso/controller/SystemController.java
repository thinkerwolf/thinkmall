package com.thinkerwolf.thinkmall.sso.controller;

import com.thinkerwolf.thinkmall.common.OpResult;
import com.thinkerwolf.thinkmall.sso.service.ISystemService;
import com.thinkerwolf.thinkmall.sso.stream.StreamInOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SystemController {

    @Autowired
    ISystemService systemService;

    @Autowired
    StreamInOut streamInOut;

    @RequestMapping("/info")
    public OpResult info() {
        return systemService.info();
    }

    @RequestMapping("/stream/sourceSend")
    public OpResult sourceSend(@RequestParam("msg") String msg) {
        Map<String, Object> headerMap = new HashMap<>();
        headerMap.put("sender", "wk-source");
        MessageHeaders headers = new MessageHeaders(headerMap);
        Message<String> message = MessageBuilder.createMessage(msg, headers);
        streamInOut.sourceSend(message);
        return OpResult.ok();
    }

    @RequestMapping("/stream/sinkSend")
    public OpResult sinkSend(@RequestParam("msg") String msg) {
        Map<String, Object> headerMap = new HashMap<>();
        headerMap.put("sender", "wk-sink");
        MessageHeaders headers = new MessageHeaders(headerMap);
        Message<String> message = MessageBuilder.createMessage(msg, headers);
        streamInOut.sinkSend(message);
        return OpResult.ok();
    }

}
