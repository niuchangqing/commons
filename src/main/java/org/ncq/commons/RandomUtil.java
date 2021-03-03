package org.ncq.commons;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 随机相关工具类
 * @author niuchangqing
 */
public class RandomUtil {

    /**
     * 获取随机对象
     * @return          随机对象ThreadLocalRandom
     */
    public static ThreadLocalRandom getRandom() {
        return ThreadLocalRandom.current();
    }

    /**
     * 获取随机数字,范围[0,max]。不包含max
     * <p>
     *     max参数不能小于或等于0
     * </p>
     * @param max       随机数最大范围,不包含max
     * @return          随机数
     */
    public static int randomInt(int max) {
        return randomInt(0, max);
    }

    /**
     * 获取随机数据,范围[min,max]。不包含max
     * @param min
     * @param max
     * @return
     */
    public static int randomInt(int min, int max) {
        return getRandom().nextInt(min, max);
    }
}