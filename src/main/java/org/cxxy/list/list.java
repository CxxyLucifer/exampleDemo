package org.cxxy.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class list {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        list.add(0, 3);

        list.forEach(v -> System.out.println(v));


        /**
         * （1）该方法不适用于基本数据类型（byte,short,int,long,float,double,boolean），可以是integer。
         * （2）该方法将数组与列表链接起来，当更新其中之一时，另一个自动更新
         * （3）最重要的一点就是，不支持add和remove，如果不需要改变长度可以使用Arrays.asList()。
         */
        List<String> names = Arrays.asList("jack","tom");
    }
}
