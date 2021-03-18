package org.ncq.commons;

import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.Test;

import java.time.*;
import java.util.Date;

/**
 * @author niuchangqing
 */
public class LocalDateTimeUtilTest {

    @Test
    public void currentTimeMillisTest() {
        long l = LocalDateTimeUtil.currentTimeMillis();
        long l1 = LocalDateTimeUtil.currentTimeMillis(ZoneId.of("America/New_York"));
        long l2 = LocalDateTimeUtil.currentTimeMillis(ZoneOffset.UTC);
        long l3 = LocalDateTimeUtil.currentTimeMillis(ZoneOffset.ofHours(-8));
        System.out.println(l);
        System.out.println(l1);
        System.out.println(l2);
        System.out.println(l3);

        System.out.println(new Date(l));
        System.out.println(new Date(l1));
        System.out.println(new Date(l2));
        System.out.println(new Date(l3));
    }


    @Test
    public void timestampToLocalDateTimeTest() {
        long l = LocalDateTimeUtil.currentTimeMillis();
        System.out.println(l);
        LocalDateTime localDateTime = LocalDateTimeUtil.ofMillis(l);
        Ta ta = new Ta();
        ta.date = localDateTime;
        ta.localDate = LocalDate.now();
        ta.localTime = LocalTime.now();
        String s = JsonUtil.toString(ta);
        System.out.println(s);
        Ta t = JsonUtil.toObj(s, new TypeReference<Ta>() {});
        System.out.println(t.localDate.toString());
        System.out.println(t.date.toString());


        long timestamp = LocalDateTimeUtil.currentTimeMillis();
        LocalDateTime localDateTime1 = LocalDateTimeUtil.ofMillis(timestamp);
        System.out.println(localDateTime1.toString());
        localDateTime1 = LocalDateTimeUtil.ofMillis(timestamp,ZoneId.of("America/New_York"));
        System.out.println(localDateTime1.toString());

        timestamp = LocalDateTimeUtil.currentTimeSecond();
        localDateTime1 = LocalDateTimeUtil.ofSecond(timestamp);
        System.out.println(localDateTime1.toString());
        localDateTime1 = LocalDateTimeUtil.ofSecond(timestamp,ZoneId.of("America/New_York"));
        System.out.println(localDateTime1.toString());
    }

    @Test
    public void dateToStrTest() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(LocalDateTimeUtil.toString(now));
        System.out.println(LocalDateTimeUtil.toString(now,LocalDateTimeUtil.YYYY_MM_DD_HH_MM_SS_SSS));
    }

    @Test
    public void strToDateTest() {
        LocalDateTime now = LocalDateTime.now();
        String s = LocalDateTimeUtil.toString(now);
        LocalDateTime localDateTime = LocalDateTimeUtil.ofString(s, LocalDateTimeUtil.YYYY_MM_DD_HH_MM_SS);
        System.out.println(localDateTime.toString());
        System.out.println(LocalDateTimeUtil.toString(now,LocalDateTimeUtil.YYYY_MM_DD_HH_MM_SS_SSS));
    }


    public static class Ta {
        public LocalDateTime date;

        public LocalDate localDate;

        public LocalTime localTime;
    }
}
