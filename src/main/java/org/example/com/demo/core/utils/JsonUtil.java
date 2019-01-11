package org.example.com.demo.core.utils;

import flexjson.JSONSerializer;
import org.springframework.stereotype.Component;
import java.util.Collection;


/**
 * @author :Amr Abdeldayem
 */


@Component
public class JsonUtil {

    public static <T> String toJson(T obj) {
        return toJson(obj,new String[0],new String[0]);
    }

    public static <T> String toJsonArray(Collection<T> collection) {
        return toJsonArray(collection, new String[0],new String[0]);
    }

    public static <T> String toJsonArray(Collection<T> collection, String[] includes,String[] excludes) {
        return  new JSONSerializer()
                .include(includes).exclude("*.class").exclude(excludes).serialize(collection);
    }

    public static  <T> String toJson(T obj,String[] includes,String[] excludes) {
        return new JSONSerializer()
                .include(includes).exclude("*.class").exclude(excludes).serialize(obj);
    }
    
}
