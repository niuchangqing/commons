package org.ncq.commons.tuple;

/**
 * 3个参数伪元数组实现
 */
class TripleImpl<F, S, T> extends Triple<F, S, T> {
    private TripleImpl() {
    }

    private TripleImpl(F first, S second, T third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public static <F, S, T> TripleImpl<F, S, T> of(final F first, final S second, final T third) {
        return new TripleImpl<>(first, second, third);
    }
}
