package org.ncq.commons;

import org.junit.Test;
import org.ncq.commons.base.Joiner;
import org.ncq.commons.collect.Iterators;
import org.ncq.commons.collect.Lists;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author niuchangqing
 */
public final class JoinerTest {

    @Test
    public void arrayToStringTest() {
        List<String> list = Lists.newLinkedList("2","3","1");
        String join = Joiner.on(",").join(list, 2, 100);
        System.out.println(join);

        List<User> userList = Lists.newArrayList();
        User user = new User("张三");
        userList.add(user);
        user = new User("李四");
        userList.add(user);
        String join1 = Joiner.on("|").join(userList, 0, userList.size());
        System.out.println(join1);

        String[] strings = new String[]{"2","3","1"};
        String join2 = Joiner.on(',').join(strings, 0, 2);
        System.out.println(join2);
    }

    @Test
    public void arrayToStringTest1() {
        String[] strings = new String[]{"2","3","1"};
        System.out.println(Joiner.on(",").join(strings));

        List<String> list = Lists.newLinkedList("3","2","1");
        System.out.println(Joiner.on("-").join(list));
        System.out.println(Joiner.on(",").join(list,1,3));

        System.out.println(Joiner.on(",").join(list.iterator(), 0, Iterators.size(list.iterator())));
    }

    public static class User {
        public String name;

        public User(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return JsonUtil.toString(this);
        }
    }
}
