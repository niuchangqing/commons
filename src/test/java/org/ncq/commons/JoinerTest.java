package org.ncq.commons;

import org.junit.Test;
import org.ncq.commons.base.Joiner;
import org.ncq.commons.collect.Iterators;
import org.ncq.commons.collect.Lists;

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
        String join1 = Joiner.on("|").join(userList);
        System.out.println(join1);

        String[] strings = new String[]{"2","3","1"};
        String join2 = Joiner.on(',').join(strings, 0, 2);
        System.out.println(join2);
        System.out.println(Joiner.on(",").join(userList.get(0),userList.get(1)) );
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

    @Test
    public void dataTypeToStringTest() {
        int[] ints = new int[]{1,2,3};
        System.out.println(Joiner.on(',').join(ints));
        System.out.println(Joiner.on(",").join(ints,0,2));
        byte[] bytes = new byte[]{3,2,3,4};
        System.out.println(Joiner.on(",").join(bytes));
        System.out.println(Joiner.on(",").join(bytes,1,3));

        short[] shorts = new short[]{2,5,1,3};
        System.out.println(Joiner.on(",").join(shorts));
        System.out.println(Joiner.on(",").join(shorts,2,3));

        long[] longs = new long[]{2,3,100,2981};
        System.out.println(Joiner.on(',').join(longs));
        System.out.println(Joiner.on(',').join(longs,0,3));

        float[] floats = new float[]{12.3f,98.1f,9873.1f};
        System.out.println(Joiner.on(",").join(floats));
        System.out.println(Joiner.on(",").join(floats,1,2));

        double[] doubles = new double[]{98,983,9173,881};
        System.out.println(Joiner.on(",").join(doubles));
        System.out.println(Joiner.on(",").join(doubles,1,4));

        char[] chars = new char[]{'a','b','d'};
        System.out.println(Joiner.on(",").join(chars));
        System.out.println(Joiner.on(",").join(chars,0,2));

        boolean[] booleans = new boolean[]{true,false,false,true};
        System.out.println(Joiner.on("-").join(booleans));
        System.out.println(Joiner.on("-").join(booleans,1,3));
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
