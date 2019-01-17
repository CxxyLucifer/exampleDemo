package org.cxxy.func.calcTotalPrice;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.IntStream.range;

public class SumTester {

    public static void main(String[] args) {

        List<Goods> list = new ArrayList<>();

        range(0, 10).forEach(i -> {
            list.add(Goods.builder()
                    .name("name" + i)
                    .price(Double.valueOf(i + 1))
                    .count(2)
                    .Color("color" + i)
                    .build()
            );
        });

        Double totalPrice = list.stream().mapToDouble(Goods::getTotalPrice).sum();

        System.out.println("====totalPrice:" + totalPrice);
    }
}
