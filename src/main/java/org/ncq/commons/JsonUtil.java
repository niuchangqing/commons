package org.ncq.commons;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.ncq.commons.exception.JsonException;

/**
 * @author niuchangqing
 * json工具
 */
public class JsonUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    private JsonUtil() {};


    /**
     * 获取ObjectMapper对象
     * @return              ObjectMapper
     */
    public static ObjectMapper getObjectMapper(){
        return objectMapper;
    }

    /**
     * 对象转字符串
     * @param obj       参数
     * @return          返回字符串
     */
    public static String toString(final Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        }catch (JsonProcessingException e) {
            throw new JsonException("json obj to string error",e);
        }
    }


    /**
     * 字符串转javaBean
     * @param str       指定字符串
     * @param clazz     javaBean.class
     * @param <T>       javaBean
     * @return          返回指定转换的结果对象
     */
    public static <T> T toObj(final String str, Class<T> clazz) {
        try {
            return objectMapper.readValue(str, clazz);
        }catch (JsonProcessingException e) {
            throw new JsonException("string to object error",e);
        }
    }

    /**
     * 字符串转指定java对象
     * <p>
     *     嵌套对象使用,如:List<User>
     * </p>
     * @param str       指定字符串
     * @param reference TypeReference
     * @param <T>       java对象
     * @return          返回指定转换的结果对象
     */
    public static <T> T toObj(final String str, TypeReference<T> reference) {
        try {
            return objectMapper.readValue(str, reference);
        }catch (JsonProcessingException e) {
            throw new JsonException("string to object error",e);
        }
    }

    /**
     * 字符串转JsonNode
     * @param str       指定字符串
     * @return          返回JsonNode
     */
    public static JsonNode readNode(final String str) {
        try {
            return objectMapper.readTree(str);
        }catch (JsonProcessingException e) {
            throw new JsonException("string to jsonNode error",e);
        }
    }
}
