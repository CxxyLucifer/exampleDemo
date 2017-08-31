package org.cxxy;

import java.text.DecimalFormat;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.text.NumberFormat;

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

        Double a = Double.valueOf(50) / Double.valueOf(2);

        DecimalFormat df = new DecimalFormat("#.##");

        System.out.println(df.format(a));

    }
}
