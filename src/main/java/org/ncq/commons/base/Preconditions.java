package org.ncq.commons.base;

/**
 * @author niuchangqing
 */
public final class Preconditions {
    private Preconditions(){}

    /**
     * 判断是否为空,为空抛出NullPointerException
     * @param t             参数
     * @param <T>           参数类型
     * @return              不为空,直接返回入参数
     */
    public static <T extends Object> T checkNotNull(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        return t;
    }
}
