package com.ts.user.kafka.producer;

import com.ts.user.kafka.event.v1.MessageReceivedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class ProducerConfig {

    @Autowired
    private KafkaProperties kafkaProperties;

    @Bean
    public ProducerFactory<String, MessageReceivedEvent> ticketCreationEmailEventProducerFactory() {
        return new DefaultKafkaProducerFactory<>(kafkaProperties.buildProducerProperties());
    }

    @Bean
    public KafkaTemplate<String, MessageReceivedEvent> ticketCreationEmailEventKafkaTemplate() {
        KafkaTemplate<String, MessageReceivedEvent> kafkaTemplate = new KafkaTemplate(ticketCreationEmailEventProducerFactory());
        kafkaTemplate.setDefaultTopic("Messagereceived");
        return kafkaTemplate;
    }

    @Bean
    public HelloWorldEventSender ticketCreationEmailEventSender() {
        return new HelloWorldEventSender();
    }

}
