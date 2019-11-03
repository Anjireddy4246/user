package com.ts.user.kafka.event.v1;

import com.ts.user.model.v1.HelloWorldModel;

public class MessageReceivedEvent extends BaseEvent {
private HelloWorldModel helloWorldModel;
public MessageReceivedEvent(){

}
    public MessageReceivedEvent(String eventType, String timestamp, String locale, HelloWorldModel helloWorldModel) {
        super.setEventType(eventType);
        super.setTimestamp(timestamp);
        super.setLocale(locale);
        this.helloWorldModel = helloWorldModel;
    }

    public HelloWorldModel getHelloWorldModel() {
        return helloWorldModel;
    }

    public void setHelloWorldModel(HelloWorldModel helloWorldModel) {
        this.helloWorldModel = helloWorldModel;
    }
}
