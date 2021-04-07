package org.ncq.commons.tuple;

import java.io.Serializable;

/**
 * 俩个参数的元数组,支持俩个不同参数对象
 * @author niuchangqing
 */
public abstract class Pair<F, S> implements Serializable {

    /**
     * 元数组第一个参数
     */
    protected F first;

    /**
     * 元数组第二个参数
     */
    protected S second;


    /**
     * 获取一个支持俩个参数的伪元数组对象
     * @param first                 第一个参数
     * @param second                第二个参数
     * @return                      Pair
     */
    public static <F, S> Pair<F, S> of(final F first, final S second) {
        return PairImpl.of(first, second);
    }

    public F getFirst() {
        return first;
    }

    public S getSecond() {
        return second;
    }

    public void setFirst(F first) {
        this.first = first;
    }

    public void setSecond(S second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "(" + getFirst() + "," + getSecond() + ")";
    }
}
