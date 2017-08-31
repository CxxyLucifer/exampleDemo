package org.cxxy.func.methodreferrance;

import java.util.Arrays;

/**
 * Created by LiuHui on 2017/4/14.
 * <p>
 * 引用对象的实例方法
 */
public class MethodReferInstance {

    public static void main(String[] args) {

        String[] stringArrays = new String[]{"hello", "world"};

        //使用lambda表达式和类型对象的实例方法
        Arrays.sort(stringArrays, (s1, s2) -> s1.compareToIgnoreCase(s2));

        //使用方法引用
        //引用的是类型对象的实例方法
        Arrays.sort(stringArrays, String::compareToIgnoreCase);
    }
}
