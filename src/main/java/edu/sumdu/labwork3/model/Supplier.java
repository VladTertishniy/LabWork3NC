package edu.sumdu.labwork3.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Supplier {
    private User user;
    private String firstname;
    private String lastname;
    private String phoneNumber;
    private String email;
    private String organization;
}
