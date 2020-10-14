package edu.sumdu.labwork3.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GoodsType {
    private int id;
    private Integer parent_id;
    private String name;
    private String vendorCode;

   public GoodsType(String vendorCode) {
       this.vendorCode = vendorCode;
   }
}
