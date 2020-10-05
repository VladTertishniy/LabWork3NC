package edu.sumdu.labwork3.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Consumer {
    private String name;
    private String phoneNumber;
    private Goods goods;
    private ConsumerType consumerType;
}
