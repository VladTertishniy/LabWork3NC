package edu.sumdu.labwork3.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BasketOfGoods {
    private Goods goods;
    private Order order;
    private int count;
    private float sum;
}
