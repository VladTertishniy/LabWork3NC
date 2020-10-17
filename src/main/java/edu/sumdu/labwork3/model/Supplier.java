package edu.sumdu.labwork3.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Supplier {
    private User user;
    private String firstname;
    private String lastname;
    private String phoneNumber;
    private String email;
    private String organization;
}
