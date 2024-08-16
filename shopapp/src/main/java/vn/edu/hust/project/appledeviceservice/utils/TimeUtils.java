package vn.edu.hust.project.appledeviceservice.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;

public class TimeUtils {
    public static LocalDateTime convertUnixTimeToLocalDateTime(Long time) {
        if(time == null){
            return null;
        }
        return LocalDateTime.ofInstant(Instant.ofEpochSecond(time), ZoneId.systemDefault());
    }
    public static LocalDateTime getStartOfToday() {
        return LocalDateTime.of(LocalDateTime.now().toLocalDate(), LocalTime.MIN);
    }

    public static LocalDateTime getEndOfToday() {
        return LocalDateTime.of(LocalDateTime.now().toLocalDate(), LocalTime.MAX);
    }
    public static long convertLocalDateTimeToUnixTime(LocalDateTime dateTime) {
        if(dateTime == null){
            return 0;
        }
        return dateTime.atZone(ZoneId.systemDefault()).toEpochSecond();
    }
}
