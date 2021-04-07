package org.ncq.commons.tuple;

/**
 * 2个参数伪元数组实现
 * @author niuchangqing
 */
class PairImpl<F, S> extends Pair<F, S>{

    private PairImpl() {
    }

    public PairImpl(F first, S second) {
        this.first = first;
        this.second = second;
    }

    public static <F, S> PairImpl<F, S> of(final F first, final S second){
        return new PairImpl<>(first, second);
    }
}
