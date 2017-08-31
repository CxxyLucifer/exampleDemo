package org.cxxy.func.methodreferrance;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by LiuHui on 2017/4/14.
 * <p>
 * 引用静态方法
 */
public class MethodReferStatic {

    public static void main(String[] args) {
        Person[] persons = new Person[5];

        //内部类
        Arrays.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getBirthday().compareTo(o2.getBirthday());
            }
        });

        //lambda
        //类的静态方法
        Arrays.sort(persons, (p1, p2) -> Person.compareByage(p1, p2));

        //method referrance
        //方法引用类的静态方法
        Arrays.sort(persons, Person::compareByage);
    }
}
