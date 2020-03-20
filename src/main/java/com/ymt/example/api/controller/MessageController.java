package com.ymt.example.api.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@EnableBinding(Source.class)
@Slf4j
public class MessageController {

    private Source source;

    @Autowired
    public MessageController(Source source) {
        this.source = source;
    }

    @PostMapping("/messages")
    public String postMessage(@RequestParam(value = "message") String message) {
        log.info("Received message {}", message);
        this.source.output().send(new GenericMessage<>(message));
        return message;
    }
}
