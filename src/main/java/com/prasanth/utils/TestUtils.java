package com.prasanth.utils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class TestUtils {

    public static String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder randomString = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = new Random().nextInt(characters.length());
            randomString.append(characters.charAt(index));
        }

        return randomString.toString();
    }

    // Get current milliseconds since epoch
    public static long getCurrentMilliseconds() {
        return System.currentTimeMillis();
    }

    // Get current date
    public static LocalDate getCurrentDate() {
        return LocalDate.now();
    }

    // Get current time
    public static LocalTime getCurrentTime() {
        return LocalTime.now();
    }

    // Get current date and time
    public static LocalDateTime getCurrentDateTime() {
        return LocalDateTime.now();
    }

    // Get day of the week for a given date
    public static DayOfWeek getDayOfWeek(LocalDate date) {
        return date.getDayOfWeek();
    }

    // Format a date using a specific pattern
    public static String formatDate(LocalDate date, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return date.format(formatter);
    }

}
