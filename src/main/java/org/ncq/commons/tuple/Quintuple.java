package org.ncq.commons.tuple;

/**
 * 五个参数的元数组,支持5个不同参数对象
 * @author niuchangqing
 */
public abstract class Quintuple<F, S, T, FH, FF> extends Quadruple<F, S, T, FH> {
    /**
     * 元数组第五个参数
     */
    protected FF fifth;

    public static <F, S, T, FH, FF> Quintuple<F, S, T, FH, FF> of(final F first, final S second, final T third, final FH fourth, final FF fifth) {
        return QuintupleImpl.of(first, second, third, fourth, fifth);
    }

    public FF getFifth() {
        return fifth;
    }

    public void setFifth(FF fifth) {
        this.fifth = fifth;
    }

    @Override
    public String toString() {
        return "(" + getFirst() + "," + getSecond() + "," + getThird() + "," + getFourth() + "," + getFifth() + ")";
    }
}
