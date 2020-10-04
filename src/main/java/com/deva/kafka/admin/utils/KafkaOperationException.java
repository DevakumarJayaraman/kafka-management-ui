package com.deva.kafka.admin.utils;

public class KafkaOperationException extends Exception{
    private Exception ex;
    private String message;

    public KafkaOperationException(String message, Exception ex){
        this.message=message;
        this.ex=ex;
    }

}
