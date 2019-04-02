package org.cxxy;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.Range;
import org.cxxy.util.UnicodeUtil;

import java.math.BigDecimal;
import java.net.URLDecoder;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.text.NumberFormat;
import java.util.*;

import static java.util.stream.IntStream.range;

/**
 * Created by LiuHui on 2017/4/14.
 */
public class test {

    public static void main(String[] args) throws Exception{

        BigDecimal a = BigDecimal.ZERO;

        System.out.println(a.setScale(0));
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
