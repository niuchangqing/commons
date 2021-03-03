package org.ncq.commons;

import org.junit.Test;

/**
 * @author niuchangqing
 */
public class RandomUtilTest {

    @Test
    public void randomTest(){
        int i1 = RandomUtil.randomInt(10);
        System.out.println(i1);
    }
}
