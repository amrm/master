package org.example.com.demo.core.security.dto;


/**
 * @author :Amr Abdeldayem
 */


public class ResponseMessage {
    private String message;

    public ResponseMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}