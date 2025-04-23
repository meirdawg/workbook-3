package com.pluralsight;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.ZoneId;
import java.math.BigDecimal;

class App {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();

        dateFormat1(now);
        dateFormat2(now);
        System.out.println(getFormat3(now));
        dateFormat4(now);
        dateFormat5(now);
        dateFormat6(now);
    }

    static void dateFormat1(LocalDateTime now) {
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("MM-dd-YYYY");
        System.out.println(now.format(format1));
    }

    static void dateFormat2(LocalDateTime now) {
        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        System.out.println(now.format(format2));
    }

    static String getFormat3(LocalDateTime now) {
        DateTimeFormatter format3 = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        System.out.println("This will never execute");
        return format3.format(now);

    }

    static void dateFormat4(LocalDateTime time) {
        DateTimeFormatter format4 = DateTimeFormatter.ofPattern("eee, MM d, yyyy");
        System.out.println(time.format(format4));
    }

    static void dateFormat5(LocalDateTime now) {
        DateTimeFormatter format5 = DateTimeFormatter.ofPattern("hh:mm");
        System.out.println(format5.format(now) + (" : display in GMT time"));
    }

    static void dateFormat6(LocalDateTime now) {
        DateTimeFormatter format6 = DateTimeFormatter.ofPattern("H:mm 'on' dd MMM yyyy");
        System.out.println(format6.format(now) + "  display in your local time zone");
    }
}
