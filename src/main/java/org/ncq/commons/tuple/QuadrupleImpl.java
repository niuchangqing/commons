package org.ncq.commons.tuple;

/**
 * 4个参数元数组实现
 */
class QuadrupleImpl<F, S, T,FH> extends Quadruple<F, S, T,FH> {

    private QuadrupleImpl() {}

    public QuadrupleImpl(F first, S second, T third, FH fourth) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
    }


    public static <F, S, T,FH> QuadrupleImpl<F, S, T,FH> of(final F first, final S second, final T third, final FH fourth) {
        return new QuadrupleImpl<>(first, second, third, fourth);
    }
}
