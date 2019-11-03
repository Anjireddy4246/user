package com.ts.user.kafka.producer;

import com.ts.user.kafka.event.v1.MessageReceivedEvent;
import com.ts.user.model.v1.HelloWorldModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloWorldEventSender implements EventSender<String, MessageReceivedEvent, HelloWorldModel> {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldEventSender.class);

    @Autowired
    private KafkaTemplate<String, MessageReceivedEvent> kafkaTemplate;

    @Override
    public void send(String key, MessageReceivedEvent message) {
        ListenableFuture<SendResult<String, MessageReceivedEvent>> future = kafkaTemplate.sendDefault(key, message);

        future.addCallback(new ListenableFutureCallback<SendResult<String, MessageReceivedEvent>>() {

            @Override
            public void onSuccess(SendResult<String, MessageReceivedEvent> result) {
                LOGGER.info("sent message='{}' with offset={}", message, result.getRecordMetadata().offset());
            }

            @Override
            public void onFailure(Throwable ex) {
                LOGGER.error("unable to send message='{}'", message, ex);
            }
        });
    }

    @Override
    public void sendEventToKafka(String eventType, HelloWorldModel model) {
        MessageReceivedEvent event = new MessageReceivedEvent();
        event.setEventType(eventType);
        event.setTimestamp(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX").format(new Date()));
        event.setHelloWorldModel(model);
        send(model.getGuid(), event);
    }
}
