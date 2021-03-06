package org.ncq.commons;

import org.junit.Test;
import org.ncq.commons.base.Stopwatch;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author niuchangqing
 */
public final class DateUtilTest {
    @Test
    public void stringToDateTest() {
        String dateStr = "2021-03-25 18:30:31";
        Date date = DateUtil.of(dateStr, DateUtil.YYYY_MM_DD_HH_MM_SS);
        System.out.println(date.toString());
    }

    @Test
    public void dateAddTest() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        Date date = new Date();
        for (int i = 0; i < 10000; i++) {
            DateUtil.add(date, Calendar.HOUR, 1);
        }
        System.out.println(stopwatch.toString());
        System.out.println(stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }

    @Test
    public void addYearTest() {
        Date date = DateUtil.addYears(new Date(), -1);
        System.out.println(DateUtil.toString(date, DateUtil.YYYY_MM_DD_HH_MM_SS));
    }

    @Test
    public void addMonthTest() {
        Date date = DateUtil.of("2021-01-29 00:00:00", DateUtil.YYYY_MM_DD_HH_MM_SS);
        Date date1 = DateUtil.addMonths(date, 1);
        System.out.println(DateUtil.toString(date1));
    }

    @Test
    public void addWeeksTest() {
        Date date = DateUtil.of("2020-12-29 00:00:00", DateUtil.YYYY_MM_DD_HH_MM_SS);
        Date date1 = DateUtil.addWeeks(date, 1);
        System.out.println(DateUtil.toString(date1));
    }

    @Test
    public void addDaysTest() {
        Date date = DateUtil.of("2021-02-28 00:00:00", DateUtil.YYYY_MM_DD_HH_MM_SS);
        Date date1 = DateUtil.addDays(date, 1);
        System.out.println(DateUtil.toString(date1));
    }

    @Test
    public void addHoursTest() {
        Date date = DateUtil.of("2021-02-28 23:30:00", DateUtil.YYYY_MM_DD_HH_MM_SS);
        Date date1 = DateUtil.addHours(date, 1);
        System.out.println(DateUtil.toString(date1));
        Date date2 = DateUtil.addHours(date, -1);
        System.out.println(DateUtil.toString(date2));
    }

    @Test
    public void addMinutesTest() {
        Date date = DateUtil.of("2021-02-28 23:59:10", DateUtil.YYYY_MM_DD_HH_MM_SS);
        Date date1 = DateUtil.addMinutes(date, 1);
        System.out.println(DateUtil.toString(date1));
    }

    @Test
    public void addSecondsTest() {
        Date date = DateUtil.of("2021-02-28 23:59:30", DateUtil.YYYY_MM_DD_HH_MM_SS);
        Date date1 = DateUtil.addSeconds(date, 30);
        System.out.println(DateUtil.toString(date1));
    }

    @Test
    public void addMillisecondsTest() {
        Date date = DateUtil.of("2021-02-28 23:59:30.100", DateUtil.YYYY_MM_DD_HH_MM_SS_SSS);
        Date date1 = DateUtil.addMilliseconds(date, 200);
        System.out.println(DateUtil.toString(date1, DateUtil.YYYY_MM_DD_HH_MM_SS_SSS));
    }
}
