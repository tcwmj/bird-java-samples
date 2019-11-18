package com.bird.eventbus.sample.service;

import com.bird.eventbus.handler.EventHandler;
import com.bird.eventbus.sample.model.AnotherEvent;
import com.bird.eventbus.sample.model.TestEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author liuxx
 * @date 2019/8/28
 */
@Service
@Slf4j
public class ConsumerService {

    /**
     * 事件监听
     * <p>
     * 经过消息队列发送的事件，可在各个微服务之间进行传递
     *
     * @param event
     */
    @EventHandler
    public void handleEvent1(TestEvent event) {
        log.info("{} handleEvent1 接收到 {} {}", this.getClass().getSimpleName(), event.getClass().getSimpleName(), event.getName());
    }

    @EventHandler
    public void handleEvent2(TestEvent event) {
        log.info("{} handleEvent2 接收到 {} {}", this.getClass().getSimpleName(), event.getClass().getSimpleName(), event.getName());
    }

    @EventHandler
    public void handleEvent3(AnotherEvent event) {
        log.info("{} handleEvent3 接收到 {} {}", this.getClass().getSimpleName(), event.getClass().getSimpleName(), event.getDescription());
    }
}
