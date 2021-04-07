package org.ncq.commons.tuple;

/**
 * 三个参数的元数组,支持3个不同参数对象
 * @author niuchangqing
 */
public abstract class Triple<F, S, T> extends Pair<F, S>{

    /**
     * 元数组第三个参数
     */
    protected T third;

    public static <F, S, T> Triple<F, S, T> of(final F first, final S second, final T third) {
        return TripleImpl.of(first,second, third);
    }

    public T getThird() {
        return third;
    }

    public void setThird(T third) {
        this.third = third;
    }

    @Override
    public String toString() {
        return "(" + getFirst() + "," + getSecond() + "," + getThird() + ")";
    }
}
