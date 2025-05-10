package com.jedi.syntax.date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoField;

public class Example1 {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2017, 9, 21);
        LocalDate date = localDate;
        int year = localDate.getYear(); // 2017
        Month month = localDate.getMonth(); // 9; September
        int day = localDate.getDayOfMonth(); // 21
        DayOfWeek dayOfWeek = localDate.getDayOfWeek(); // 목요일(THURSDAY)
        int len = localDate.lengthOfMonth();   // 31(3월의 일 수)
        boolean leap = localDate.isLeapYear(); // 운년

        int year1 = date.get(ChronoField.YEAR);
        int month1 = date.get(ChronoField.MONTH_OF_YEAR);
        int day1 = date.get(ChronoField.DAY_OF_MONTH);

        System.out.println(date);
        System.out.println(year);
        System.out.println(month1);
        System.out.println(day);

        LocalTime specificTime = LocalTime.of(23, 59, 59);
        int hour = specificTime.getHour();
        int minute = specificTime.getMinute();
        int second = specificTime.getSecond();
        System.out.println("h: " + hour + "\nm: " + minute + "\ns: " + second);


    }
}
