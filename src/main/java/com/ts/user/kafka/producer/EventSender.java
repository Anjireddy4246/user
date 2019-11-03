package com.ts.user.kafka.producer;

public interface EventSender<K,V,T> {
    void send(String key, V message);
    void sendEventToKafka(String eventType, T clazz);
}
