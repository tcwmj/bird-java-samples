package com.bird.eventbus.sample.controller;

import com.bird.eventbus.EventBus;
import com.bird.eventbus.sample.model.AnotherEvent;
import com.bird.eventbus.sample.model.TestEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuxx
 * @date 2019/8/28
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class ProducerController {

    @Autowired
    private EventBus eventBus;

    @GetMapping("/send")
    public void sendEvent(String name) {
        TestEvent event = new TestEvent(name);
        log.info("pushing event {} {}", event.getClass().getSimpleName(), event.getName());
        eventBus.push(event);
    }

    @GetMapping("/another/send")
    public void sendAnotherEvent(String description) {
        AnotherEvent event = new AnotherEvent(description);
        log.info("pushing event {} {}", event.getClass().getSimpleName(), event.getDescription());
        eventBus.push(event);
    }
}
