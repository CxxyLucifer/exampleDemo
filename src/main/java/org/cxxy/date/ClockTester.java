package org.cxxy.date;

import java.time.Clock;

/**
 * Author:liuhui
 * Description:
 * Date: 2:57 PM 2018/12/19
 */
public class ClockTester {

    public static void main(String[] args) {
        Clock clock = Clock.systemUTC();

        System.out.println(clock.instant());
        System.out.println(clock.millis());
    }
}
