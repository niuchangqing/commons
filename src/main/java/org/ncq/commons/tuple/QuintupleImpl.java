package org.ncq.commons.tuple;

/**
 * 五个参数元数组实现
 * @author niuchangqing
 */
class QuintupleImpl<F, S, T, FH, FF> extends Quintuple<F, S, T, FH, FF> {
    private QuintupleImpl() {}

    public QuintupleImpl(F first, S second, T third, FH fourth, FF fifth) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
        this.fifth = fifth;
    }

    public static <F, S, T, FH, FF> QuintupleImpl<F, S, T, FH, FF> of(final F first, final S second, final T third, final FH fourth, final FF fifth) {
        return new QuintupleImpl<>(first, second, third, fourth, fifth);
    }
}
