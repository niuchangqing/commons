package org.ncq.commons;

import org.junit.Test;

import java.util.Date;

/**
 * @author niuchangqing
 */
public final class DateUtilTest {
    @Test
    public void stringToDateTest() {
        String dateStr = "2021-03-25 18:30:31";
        Date date = DateUtil.stringToDate(dateStr, DateUtil.YYYY_MM_DD_HH_MM_SS);
        System.out.println(date.toString());
    }
}
