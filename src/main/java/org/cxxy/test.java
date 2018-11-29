package org.cxxy;

import org.apache.commons.lang3.RandomStringUtils;

import java.text.DecimalFormat;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.text.NumberFormat;
import java.util.*;

/**
 * Created by LiuHui on 2017/4/14.
 */
public class test {

    public static void main(String[] args) {

//        String str = "jack tom h liuhui xiaoming sea talk boat tomot jackcaj";
//
//        StringTokenizer StrUtil = new StringTokenizer(str," ");
//
//        while (StrUtil.hasMoreTokens()){
//            System.out.println(StrUtil.nextToken());
//        }


//        Stream.of("one","two","three","four").filter(e-> e.length() > 3).peek(e -> System.out.println("filtered value:" + e))
//                .map(String::toUpperCase).peek(e -> System.out.println("maped value:" + e)).collect(Collectors.toList());

//        Double a = Double.valueOf(50) / Double.valueOf(2);
//
//        DecimalFormat df = new DecimalFormat("#.##");
//
//        System.out.println(df.format(a));


//        String pwd = RandomStringUtils.randomNumeric(6);
//        System.out.println(pwd);

//        DecimalFormat df = new DecimalFormat("0.00");
//        Double a = 1234.10;
//        System.out.println(convertDouble2Int(a));

//        int[] array = {1, 3, 6, 2};//定义静态数组
//
//        double a = 1.6;
//        Double b = 1.6;
//        String c = "1.6";
//
//        System.out.println(Double.doubleToLongBits(a) == Double.doubleToLongBits(b));

        System.out.println(22 << 1);
    }


    public int[] getMinAndMax(int[] array) {
        int[] result = new int[2];
        int max = array[0];//默认第一个最大
        int min = array[0];//默认第一个最小
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];//如果有比max大的数就让max记录下大的数
            }
            if (array[i] < min) {
                min = array[i];//如果有比min小的数就让min记录下小的数
            }

        }
        result[0] = min;
        result[1] = max;

        return result;
    }


    private static int convertDouble2Int(Double num) {
        DecimalFormat df = new DecimalFormat("0");

        Double monthCostRate = num * 100;

        return Integer.valueOf(df.format(monthCostRate).toString());
    }
}
