package org.cxxy.func.methodreferrance;

import java.time.LocalDate;

/**
 * Created by LiuHui on 2017/4/14.
 */
public class Person {

    private String name;

    private LocalDate birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public static int compareByage(Person p1,Person p2){

        return p1.birthday.compareTo(p2.birthday);
    }
}
