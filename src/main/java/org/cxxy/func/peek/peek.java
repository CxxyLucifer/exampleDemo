package org.cxxy.func.peek;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by LiuHui on 2017/4/18.
 */
public class peek {
    /**
     * peek 对每个元素执行操作并返回一个新的 Stream
     */
    public static void main(String[] args) {

        Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("filtered value:" + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("maped value:" + e))
                .collect(Collectors.toList());
    }

}
