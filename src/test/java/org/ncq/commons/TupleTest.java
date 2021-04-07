package org.ncq.commons;

import org.junit.Test;
import org.ncq.commons.tuple.*;

import java.math.BigDecimal;

public final class TupleTest {

    @Test
    public void pairTest() {
        Pair<Integer, String> of = Pair.of(1, "1231231");
//        Pair<Integer, String> of = Pair.nullPair();
        of.setSecond("23213");
        Integer first = of.getFirst();
        String second = of.getSecond();
        System.out.println(first);
        System.out.println(second);
    }

    @Test
    public void tripleTest() {
        Triple<Integer, String, Long> of = Triple.of(1, "983", 10L);
        of.setFirst(2);
        System.out.println(JsonUtil.toString(of));
    }

    @Test
    public void quadrupleTest() {
        Quadruple<String, Integer, Double, BigDecimal> of = Quadruple.of("", 1, 12.3D, new BigDecimal("11"));
        System.out.println(of.getFourth());
    }

    @Test
    public void quintupleTest() {
        Quintuple<String, String, Integer, Long, Float> of = Quintuple.of("张三", "", 1, 10L, 10.355F);
        System.out.println(of.getFifth());
    }

    @Test
    public void tupleTest() {
        Pair<String, BigDecimal> of = Tuple.of("1", new BigDecimal("10"));
        Triple<Integer, BigDecimal, Double> of1 = Tuple.of(1, new BigDecimal("10"), 12.3D);
        of1.setFirst(10);
        System.out.println(of1.getFirst());
        System.out.println(JsonUtil.toString(of1));
    }
}
