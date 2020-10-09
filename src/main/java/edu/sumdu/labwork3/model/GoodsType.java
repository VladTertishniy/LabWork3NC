package edu.sumdu.labwork3.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GoodsType {
    private String name;
    private int id;
    private GoodsType parentGoodsType;

   public GoodsType(int id) {
       this.id = id;
   }
}
