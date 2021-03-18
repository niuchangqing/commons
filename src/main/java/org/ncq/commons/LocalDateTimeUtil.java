package org.ncq.commons;
import static org.ncq.commons.base.Preconditions.checkNotNull;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * @author niuchangqing
 * LocalDateTime工具
 */
public class LocalDateTimeUtil {

    /**
     * yyyy-mm-dd格式
     * 2021-03-18
     */
    public static final DateTimeFormatter YYYY_MM_DD = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    /**
     * HH:mm:ss
     * 21:35:31
     */
    public static final DateTimeFormatter HH_MM_SS = DateTimeFormatter.ofPattern("HH:mm:ss");

    /**
     * yyyy-MM-dd HH:mm:ss
     * 2021-03-18 21:35:31
     */
    public static final DateTimeFormatter YYYY_MM_DD_HH_MM_SS = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * yyyy-MM-dd HH:mm:ss.SSS
     * 2021-03-18 21:36:28.760
     */
    public static final DateTimeFormatter YYYY_MM_DD_HH_MM_SS_SSS = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    /**
     * yyyy/MM/dd
     * 2021/03/18
     */
    public static final DateTimeFormatter YYYY_MM_DD_FORMAT = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    /**
     * yyyy/MM/dd HH:mm:ss
     * 2021/03/18 21:35:31
     */
    public static final DateTimeFormatter YYYY_MM_DD_HH_MM_SS_FORMAT = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    /**
     * yyyy/MM/dd HH:mm:ss.SSS
     * 2021/03/18 21:36:28.760
     */
    private static final DateTimeFormatter YYYY_MM_DD_HH_MM_SS_SSS_FORMAT = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSS");

    /**
     * 获取当前时间的毫秒时间戳,默认系统时区
     * @return          毫秒时间戳
     */
    public static long currentTimeMillis() {
        Instant instant = Instant.now();
        return instant.toEpochMilli();
    }

    /**
     * 获取指定时区当前时间毫秒时间戳
     * @param zoneId            时区
     * @return                  毫秒时间戳
     */
    public static long currentTimeMillis(ZoneId zoneId) {
        return LocalDateTime.now().atZone(zoneId).toInstant().toEpochMilli();
    }

    /**
     * 获取当前时间的秒时间戳,默认系统时区
     * @return              秒时间戳
     */
    public static long currentTimeSecond() {
        return currentTimeMillis() / 1000;
    }

    /**
     * 获取指定时区当前时间秒时间戳
     * @param zoneId            时区
     * @return                  秒时间戳
     */
    public static long currentTimeSecond(ZoneId zoneId) {
        return currentTimeMillis(zoneId) / 1000;
    }

    /**
     * 毫秒时间戳转LocalDateTime,默认系统时区
     * @param timestamp         毫秒时间戳
     * @return                  LocalDateTime
     */
    public static LocalDateTime ofMillis(long timestamp) {
        Instant instant = Instant.ofEpochMilli(timestamp);
        return LocalDateTime.ofInstant(instant,ZoneId.systemDefault());
    }

    /**
     * 毫秒时间戳转LocalDateTime,指定时区进行转换
     * @param timestamp         毫秒时间戳
     * @param zoneId            时区
     * @return                  LocalDateTime
     */
    public static LocalDateTime ofMillis(long timestamp, ZoneId zoneId) {
        Instant instant = Instant.ofEpochMilli(timestamp);
        return LocalDateTime.ofInstant(instant, zoneId);
    }

    /**
     * 秒时间戳转LocalDateTime,默认系统时区
     * @param timestamp         时间戳,单位秒
     * @return                  LocalDateTime
     */
    public static LocalDateTime ofSecond(long timestamp) {
        Instant instant = Instant.ofEpochSecond(timestamp);
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    }

    /**
     * 秒时间戳转LocalDateTime,指定时区
     * @param timestamp         时间戳,单位秒
     * @param zoneId            时区
     * @return                  LocalDateTime
     */
    public static LocalDateTime ofSecond(long timestamp, ZoneId zoneId) {
        Instant instant = Instant.ofEpochSecond(timestamp);
        return LocalDateTime.ofInstant(instant, zoneId);
    }

    /**
     * LocalDateTime日期转字符串,默认yyyy-MM-dd HH:mm:ss格式
     * @param localDateTime     时间
     * @return                  时间格式化后的字符串
     */
    public static String toString(LocalDateTime localDateTime) {
        if (localDateTime == null) {
            return null;
        }
        return localDateTime.format(YYYY_MM_DD_HH_MM_SS);
    }

    /**
     * LocalDateTime日期转字符串,指定字符串日期格式
     * @param localDateTime     时间
     * @param formatter         字符串日期格式
     * @return                  时间格式化后的字符串
     */
    public static String toString(LocalDateTime localDateTime, DateTimeFormatter formatter) {
        if (localDateTime == null) {
            return null;
        }
        if (formatter == null) {
            formatter = YYYY_MM_DD_HH_MM_SS;
        }
        return localDateTime.format(formatter);
    }

    /**
     * 日期格式字符串转LocalDateTime
     * @param str               日期字符串,如:yyyy-MM-dd HH:mm:ss
     * @param formatter         字符串日期格式
     * @return                  LocalDateTime
     */
    public static LocalDateTime ofString(String str, DateTimeFormatter formatter) {
        if (str == null) {
            return null;
        }
        checkNotNull(formatter);
        return LocalDateTime.parse(str, formatter);
    }
}
