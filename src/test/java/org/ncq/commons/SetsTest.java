package org.ncq.commons;

import org.junit.Test;
import org.ncq.commons.collect.Lists;
import org.ncq.commons.collect.Sets;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author niuchangqing
 */
public final class SetsTest {
    @Test
    public void newConcurrentHashSetTest() {
        ConcurrentHashMap<String, Boolean> stringBooleanConcurrentHashMap = new ConcurrentHashMap<>();
        Set<String> strings = Collections.newSetFromMap(stringBooleanConcurrentHashMap);
        strings.add("1");
        strings.add("2");
        System.out.println(JsonUtil.toString(strings));
        System.out.println(JsonUtil.toString(stringBooleanConcurrentHashMap));

        Set<String> set1 = Sets.newConcurrentHashSet(10);
        set1.add("3");
        set1.add("4");
        set1.add("5");
        System.out.println(JsonUtil.toString(set1));

        Set<String> strings1 = Sets.newConcurrentHashSet("3","2","1");
        System.out.println(JsonUtil.toString(strings1));

        List<String> list = Lists.newArrayList("9","7","8");
        Set<String> strings2 = Sets.newConcurrentHashSet(list);
        System.out.println(JsonUtil.toString(strings2));
    }

    @Test
    public void treeSetTest() {
        TreeSet<String> treeSet = Sets.newTreeSet();
        treeSet.add("2");
        treeSet.add("1");
        System.out.println(JsonUtil.toString(treeSet));
    }
}
