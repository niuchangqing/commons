package org.ncq.commons.tuple;

/**
 * 可以直接使用该类进行new支持对于个数参数的对象
 * Pair<String, String> of = Tuple.of("", "");
 * Triple<Integer, BigDecimal, Double> of = Tuple.of(1, new BigDecimal("10"), 12.3D);
 */
public class Tuple extends Quintuple {
    private Tuple() {}
}
