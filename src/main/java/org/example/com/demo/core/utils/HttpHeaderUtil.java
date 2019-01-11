package org.example.com.demo.core.utils;

import org.springframework.http.HttpHeaders;


/**
 * @author :Amr Abdeldayem
 */


public class HttpHeaderUtil {

    public static HttpHeaders getHeadersObject() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        return headers;
    }

}
