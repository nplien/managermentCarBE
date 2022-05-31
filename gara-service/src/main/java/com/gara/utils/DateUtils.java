package com.gara.utils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class DateUtils {

    private static final ZoneId ZONE_ID_HCM = ZoneId.of("Asia/Ho_Chi_Minh");
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static LocalDateTime now() {
        return LocalDateTime.now(ZONE_ID_HCM);
    }

    public static ZonedDateTime zonedNow() {
        return ZonedDateTime.now(ZONE_ID_HCM);
    }

    public static LocalDateTime atStartOfCurrentDay() {
        return zonedNow().toLocalDateTime().with(LocalTime.MIN);
    }

    public static LocalDateTime atEndOfCurrentDay() {
        return zonedNow().toLocalDateTime().with(LocalTime.MAX);
    }

    public static Long toMilli(LocalDateTime value) {
        return value.atZone(ZONE_ID_HCM).toInstant().toEpochMilli();
    }

    public static LocalDateTime atStart(Long value) {
        return of(value).with(LocalTime.MIN);
    }

    public static LocalDateTime atEnd(Long value) {
        return of(value).with(LocalTime.MAX);
    }

    public static LocalDateTime atEndOfDay() {
        return now().with(LocalTime.MAX);
    }

    public static LocalDateTime of(Long value) {
        return Instant.ofEpochMilli(value).atZone(ZONE_ID_HCM).toLocalDateTime();
    }

    public static LocalDateTime of(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZONE_ID_HCM);
    }

    public static Date toJavaUtilDate(LocalDateTime value) {
        return Date.from(value.atZone(ZONE_ID_HCM).toInstant());
    }

    public static String format(LocalDateTime time) {
        if (time == null) {
            return "";
        }
        return DATE_TIME_FORMATTER.format(time);
    }

}
