package com.thinkerwolf.thinkmall.sso.stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@EnableBinding({Sink.class, Source.class, SinkSender.class})
@SuppressWarnings({"rawtypes"})
public class StreamInOut {

    @Autowired
    Sink sink;

    @Autowired
    Source source;

    @Autowired
    SinkSender sinkSender;

    @StreamListener(value = Sink.INPUT)
    public void sinkReceive(Message message) {
        System.out.println("sink receive:" + message);
    }

    @StreamListener(value = Source.OUTPUT)
    public void sourceReceive(Message message) {
        System.out.println("source receive:" + message);
    }


    public void sourceSend(Message message) {
        source.output().send(message);
    }

    public void sinkSend(Message message) {
        sinkSender.output().send(message);
    }

}
