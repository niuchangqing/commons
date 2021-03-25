package org.ncq.commons;
import static org.ncq.commons.LocalDateTimeUtil.ofDate;
import static org.ncq.commons.base.Objects.isNull;
import static org.ncq.commons.base.Preconditions.checkNotNull;
import static org.ncq.commons.StringUtil.isEmpty;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author niuchangqing
 * Date工具类
 */
public class DateUtil {
    private DateUtil() {}

    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    public static final String YYYY_MM_DD_HH_MM_SS_SSS = "yyyy-MM-dd HH:mm:ss.SSS";

    public static final String YYYY_MM_DD = "yyyy-MM-dd";

    public static final String HH_MM_SS = "HH:mm:ss";

    public static final String YYYY_MM_DD_HH_MM_SS_FORMAT = "yyyy/MM/dd HH:mm:ss";

    public static final String YYYY_MM_DD_HH_MM_SS_SSS_FORMAT = "yyyy/MM/dd HH:mm:ss.SSS";

    public static final String YYYY_MM_DD_FORMAT = "yyyy/MM/dd";

    /**
     * 日期时间转字符串,默认yyyy-MM-dd HH:mm:ss格式
     * @param date              日期
     * @return                  日期时间字符串
     */
    public static String formatDate(Date date) {
        return formatDate(date,YYYY_MM_DD_HH_MM_SS);
    }

    /**
     * 日期时间转字符串
     * @param date          日期
     * @param format        字符串日期格式
     * @return              日期时间字符串
     */
    public static String formatDate(Date date, String format) {
        LocalDateTime localDateTime = ofDate(date);
        if (isNull(localDateTime)) {
            return null;
        }
        return LocalDateTimeUtil.toString(localDateTime, format);
    }

    /**
     * 字符串转日期格式
     * @param dateStr           日期时间字符串
     * @param format            日期格式化字符串
     * @return                  日期
     */
    public static Date stringToDate(String dateStr , String format){
        if (isEmpty(dateStr)) {
            return null;
        }
        checkNotNull(format);
        LocalDateTime localDateTime = LocalDateTimeUtil.ofString(dateStr, format);
        Date date = LocalDateTimeUtil.toDate(localDateTime);
        return date;
    }
}
