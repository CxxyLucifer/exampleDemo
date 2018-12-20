package org.cxxy.date;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;

/**
 * Author:liuhui
 * Description:
 * Date: 3:11 PM 2018/12/19
 */
public class DurationTester {
    public static void main(String[] args) {
        final LocalDateTime from = LocalDateTime.of( 2014, Month.APRIL, 16, 0, 0, 0 );
        final LocalDateTime to = LocalDateTime.of( 2015, Month.APRIL, 16, 23, 59, 59 );

        final Duration duration = Duration.between( from, to );

        System.out.println( "Duration in days: " + duration.toDays() );
        System.out.println( "Duration in hours: " + duration.toHours() );

    }
}
