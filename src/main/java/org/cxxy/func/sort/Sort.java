package org.cxxy.func.sort;

import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

/**
 * Created by LiuHui on 2017/4/12.
 */
public class Sort {

    /**
     * parallelStream是创建一个并行的Stream,不具备线程传播性
     *
     * @param args
     */
    public static void main(String[] args) {
        List<Transaction> transactions = new ArrayList<Transaction>();

        List<Integer> list = transactions.parallelStream().filter(t -> t.getType().equals("greed")).
                sorted(comparing(Transaction::getValue).reversed()).
                map(Transaction::getId).collect(toList());
    }
}
