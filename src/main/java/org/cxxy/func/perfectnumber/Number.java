package org.cxxy.func.perfectnumber;

import java.util.stream.IntStream;
import static java.util.stream.IntStream.range;

/**
 * Created by LiuHui on 2017/4/13.
 */
public class Number {

    /**
     * 求一个数的所有约数
     *
     * @param number
     * @return IntStream
     */
    public static IntStream factors(int number) {
        return range(1, number + 1).filter(divisor -> number % divisor == 0);
    }

    /**
     * 求所有真约数之和
     *
     * @param number
     * @return
     */
    public static int getFactorSum(int number) {
        return factors(number).sum() - number;
    }

    /**
     * 判断一个数是否为完美数(真约数之和等于本身即完美数)
     *
     * @param number
     * @return
     */
    public static boolean isPerfectNumber(int number) {
        return getFactorSum(number) == number;
    }

    public static void main(String[] args) {
        System.out.println(isPerfectNumber(6));
    }

}
