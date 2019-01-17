package org.cxxy.func.calcTotalPrice;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Goods {

    private String name;

    private Double price;

    private Integer count;

    private String Color;


    public Double getTotalPrice(){
        return this.price * this.count;
    }
}