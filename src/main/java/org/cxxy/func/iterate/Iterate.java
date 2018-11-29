package org.cxxy.func.iterate;

import java.util.stream.Stream;

/**
 * Created by LiuHui on 2017/4/18.
 */
public class Iterate {
    /**
     * iterate 跟 reduce 操作很像，接受一个种子值，和一个 UnaryOperator（例如 f）。
     * 然后种子值成为 Stream 的第一个元素，f(seed) 为第二个，f(f(seed)) 第三个，以此类推。
     * 在 iterate 时候管道必须有 limit 这样的操作来限制 Stream 大小
     *
     * @param args
     */
    public static void main(String[] args) {
        Stream.iterate(1, n -> n = n * 3).limit(10).forEach(m -> System.out.println(m));
    }
}
