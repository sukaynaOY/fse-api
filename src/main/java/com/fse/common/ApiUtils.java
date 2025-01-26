package com.fse.common;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ApiUtils {

    public static String formatDate(LocalDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
