package com.ts.user.kafka.serde;

import com.google.gson.Gson;
import org.apache.kafka.common.serialization.Deserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class JsonDeserializer<T> implements Deserializer<T> {

//    private ErrorEventSender errorEventSender;
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonDeserializer.class);

    private Gson gson = new Gson();
    private Class<T> deserializeClass;

//    public JsonDeserializer(Class<T> deserializeClass, ErrorEventSender errorEventSender) {
//        this.deserializeClass = deserializeClass;
//        this.setErrorEventSender(errorEventSender);
//    }

    public JsonDeserializer() {
        //Constructor
    }

    @Override
    @SuppressWarnings("unchecked")
    public void configure(Map<String, ?> map, boolean b) {
        if(deserializeClass == null) {
            deserializeClass = (Class<T>) map.get("serializedClass");
        }
    }

    @Override
    public T deserialize(String s, byte[] bytes) {
        if(bytes == null){
            return null;
        }

        try {
            return gson.fromJson(new String(bytes), deserializeClass);
        } catch (Exception e) {
//            MDCUtils.put(e);
//            LOGGER.error(e.getMessage() + "\nUnable to parse Message => " + new String(bytes) + "\nTo " + deserializeClass);
//            errorEventSender.send(s,new ErrorEvent().setTopic(s).setValue(new String(bytes)).setErrorTypeId(4L)
//                    .setErrorTypeName("Unable to parse to " + deserializeClass).setEventType("DeserializerErrorEvent")
//                    .setErrorMessage(e.getMessage()));
            return null;
        }

    }

//    public void setErrorEventSender(ErrorEventSender errorEventSender) {
//        this.errorEventSender = errorEventSender;
//    }

    @Override
    public void close() {
        // close method
    }
}
