package edu.sumdu.labwork3.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Goods {
    private int id;
    private String name;
    private float price;
    private GoodsType goodsType;
    private Supplier supplier;
}
