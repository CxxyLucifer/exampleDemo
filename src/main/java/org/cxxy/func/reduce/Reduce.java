package org.cxxy.func.reduce;

import java.util.stream.Stream;

/**
 * Created by LiuHui on 2017/4/18.
 */
public class Reduce {

    /**
     * Stream主要作用是把 Stream 元素组合起来
     * @param args
     */
    public static void main(String[] args) {
        // 字符串连接，concat = "ABCD"
        System.out.println(Stream.of("A", "B", "C", "D").reduce("", String::concat));

        // 求最小值，minValue = -3.0
        System.out.println(Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(Double.MAX_VALUE, Double::min));

        // 求和，sumValue = 10, 有起始值
        System.out.println(Stream.of(1, 2, 3, 4).reduce(0, Integer::sum));

        // 求和，sumValue = 10, 无起始值
        System.out.println(Stream.of(1, 2, 3, 4).reduce(Integer::sum).get());

        // 过滤，字符串连接，concat = "ace"
        System.out.println(Stream.of("a", "B", "c", "D", "e", "F").
                filter(x -> x.compareTo("Z") > 0).
                reduce("", String::concat));
    }

}
