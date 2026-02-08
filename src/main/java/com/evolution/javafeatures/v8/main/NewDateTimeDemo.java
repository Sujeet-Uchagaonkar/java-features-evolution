package com.evolution.javafeatures.v8.main;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class NewDateTimeDemo {

    public static void main(String[] args) {

        // Feature in new Java Date Time Package:
        // Thread safe: the new date-time API is immutable and doesn't have setter methods.
        //Lot of operations
        //Overcome confusing design: Mixing of date, time and timezone handling and util.date and sq.date package



        //Current date, time & zoned time
        System.out.println("Current LocalDate: "+LocalDate.now());//2026-02-03
        System.out.println("Current LocalTime: "+ LocalTime.now()); //18:43:21.737892700
        System.out.println("Current LocalDateTime: "+ LocalDateTime.now()); //2026-02-03T18:43:21.737892700
        System.out.println("Current LocalDateTime Indian format :"+
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"))); // 03-02-2026 18:43:21
        System.out.println("Current day of month: "+ LocalDateTime.now().getDayOfMonth()); // 3  //also supports like getMonth()/getYear() etc.
        System.out.println("Custom date defined as: "+
                LocalDateTime.of(2026, 01, 01, 00, 12, 33)); //2026-01-01T00:12:33




        //Zoned date time
        System.out.println("Current time along with timezone: "+ ZonedDateTime.now()); //2026-02-03T18:43:21.748063300-05:00[America/New_York]
        System.out.println("Current timezone: "+ ZonedDateTime.now().getZone()); //America/New_York
        System.out.println("Current timezone offset: "+ ZonedDateTime.now().getOffset()); //-05:00

        // Date time in different zone with current date time instance
        ZoneId istZone = ZoneId.of("Asia/Kolkata");
        System.out.println("Current time in IST zone: "+ZonedDateTime.now().withZoneSameInstant(istZone)); //2026-02-04T05:13:21.748063300+05:30[Asia/Kolkata]


        // Duration and Period
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime oldDate = LocalDateTime.of(2026, 01, 01, 00, 12, 33);
        System.out.println("Duration between now and old date given: "+Duration.between(now, oldDate)); //PT-810H-30M-48.7480633S
        System.out.println("Period between now and old date given: "+Period.between(now.toLocalDate(),oldDate.toLocalDate())); // P-1M-2D


        //ChronoUnit
        System.out.println("After adding 1 decade in current time: "+now.plus(1,ChronoUnit.DECADES)); //2036-02-03T18:49:37.468236400
        System.out.println("After adding 1 hour in current time: "+now.plus(1,ChronoUnit.HOURS)); //2026-02-03T19:49:37.468236400

    }
}
