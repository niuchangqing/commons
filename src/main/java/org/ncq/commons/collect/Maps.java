package org.ncq.commons.collect;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import static org.ncq.commons.base.Preconditions.checkNotNull;

/**
 * @author niuchangqing
 * map工具类
 */
public final class Maps {
    private Maps() {}

    /**
     * 创建HashMap
     * @return              a empty HashMap
     */
    public static <K, V> HashMap<K,V> newHashMap() {
        return new HashMap<>();
    }

    /**
     * 创建HashMap,并初始化数据
     * 可用与TreeMap,LinkedHashMap等转HashMap
     * @param map               HashMap,TreeMap等等Map实现
     * @return                  HashMap
     */
    public static <K, V> HashMap<K, V> newHashMap(Map<? extends K, ? extends V> map) {
        checkNotNull(map);
        return new HashMap<>(map);
    }

    /**
     * 创建指定大小的HashMap
     * @param size              大小
     * @return                  HashMap
     */
    public static <K, V> HashMap<K, V> newHashMapWithSize(int size) {
        return new HashMap<>(size);
    }

    /**
     * 创建LinkedHashMap
     * @return                  a empty LinkedHashMap
     */
    public static <K, V> LinkedHashMap<K, V> newLinkedHashMap() {
        return new LinkedHashMap<>();
    }

    /**
     * 创建LinkedHashMap,并初始化数据
     * 可用户HashMap,TreeMap等map转LinkedHashMap
     * @param map               HashMap,TreeMap等map参数
     * @return                  LinkedHashMap
     */
    public static <K, V> LinkedHashMap<K, V> newLinkedHashMap(Map<? extends K, ? extends V> map) {
        checkNotNull(map);
        return new LinkedHashMap<>(map);
    }

    /**
     * 创建指定大小的LinkedHashMap
     * @param size              大小参数
     * @return                  LinkedHashMap
     */
    public static <K, V> LinkedHashMap<K, V> newLinkedHashMap(int size) {
        return new LinkedHashMap<>(size);
    }

    /**
     * 创建ConcurrentMap
     * @return                  a empty ConcurrentMap
     */
    public static <K, V> ConcurrentMap<K, V> newConcurrentMap() {
        return new ConcurrentHashMap();
    }

    /**
     * 创建ConcurrentMap,并初始化数据
     * 可用于HashMap,LinkedHashMap等map转创建ConcurrentMap
     * @param map                       map参数
     * @return
     */
    public static <K, V> ConcurrentMap<K, V> newConcurrentMap(Map<? extends K, ? extends V> map) {
        return new ConcurrentHashMap<>(map);
    }

    /**
     * 创建指定大小的ConcurrentMap
     * @param size                  大小参数
     * @return                      ConcurrentMap
     */
    public static <K, V> ConcurrentMap<K, V> newConcurrentMapWithSize(int size) {
        return new ConcurrentHashMap<>(size);
    }

    /**
     * 创建TreeMap
     * @return                  a empty TreeMap
     */
    public static <K, V> TreeMap<K,V> newTreeMap() {
        return new TreeMap<>();
    }

    /**
     * 创建TreeMap,并初始化数据
     * 可用于HashMap,ConcurrentMap等map转TreeMap
     * @param map               HashMap,TreeMap等map参数
     * @return                  TreeMap
     */
    public static <K, V> TreeMap<K,V> newTreeMap(Map<? extends K, ? extends V> map) {
        checkNotNull(map);
        return new TreeMap<>(map);
    }
}
