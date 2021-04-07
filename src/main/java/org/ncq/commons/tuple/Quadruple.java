package org.ncq.commons.tuple;

/**
 * 四个参数的元数组,支持4个不同的参数对象
 * @author niuchangqing
 */
public abstract class Quadruple<F, S, T, FH> extends Triple<F, S, T> {
    /**
     * 元数组第四个参数
     */
    protected FH fourth;

    public static <F, S, T, FH> Quadruple<F, S, T, FH> of(final F first, final S second, final T third, final FH fourth) {
        return QuadrupleImpl.of(first, second, third, fourth);
    }

    public FH getFourth() {
        return fourth;
    }

    public void setFourth(FH fourth) {
        this.fourth = fourth;
    }

    @Override
    public String toString() {
        return "(" + getFirst() + "," + getSecond() + "," + getThird() + "," + getFourth() + ")";
    }
}
