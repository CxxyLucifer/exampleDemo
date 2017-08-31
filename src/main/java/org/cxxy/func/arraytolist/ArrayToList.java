package org.cxxy.func.arraytolist;

import java.util.Arrays;
import java.util.List;

/**
 * Created by LiuHui on 2017/4/12.
 */
public class ArrayToList {

    /**
     * asList方法输入的参数是一个泛型变长参数,8个基本类型不能作为泛型参数，想要作为泛型必须使用其包装类
     *
     * @param args
     */
    public static void main(String[] args) {

        int[] a = new int[]{1, 2, 3};
        List list = Arrays.asList(a);
        System.out.println(list.size());//1

        //int类型的数组，数组是一个对象，所以可以泛型化，也就是说int类型数组作T类型，泛型化
        System.out.println(list.get(0) == a);//true


        Integer[] b = new Integer[]{1, 2, 3};
        List list1 = Arrays.asList(b);
        System.out.println(list1.size());//3
    }
}
