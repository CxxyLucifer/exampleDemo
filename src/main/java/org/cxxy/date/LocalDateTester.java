package org.cxxy.date;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Author:liuhui
 * Description:
 * Date: 3:02 PM 2018/12/19
 */
public class LocalDateTester {

    public static void main(String[] args) {
        Clock clock = Clock.systemUTC();

        LocalDate localDate = LocalDate.now();
        LocalDate datefromClock = LocalDate.now(clock);


        System.out.println(localDate);
        System.out.println(datefromClock);


        LocalTime localTime = LocalTime.now();
        LocalTime timefromClock = LocalTime.now(clock);


        System.out.println(localTime);
        System.out.println(timefromClock);


        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime datetimefromClock = LocalDateTime.now(clock);

        System.out.println(localDateTime);
        System.out.println(datetimefromClock);
    }
}
