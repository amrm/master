package org.example.com.demo.core.exception;

/**
 * @author :Amr Abdeldayem
 */

public class CustomNotFoundException extends Exception {

    public CustomNotFoundException(String msg){
        super(msg);
    }

    public CustomNotFoundException(String msg, Throwable t) {
        super(msg, t);
    }

}
