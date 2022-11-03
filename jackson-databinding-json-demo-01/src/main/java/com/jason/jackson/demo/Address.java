package com.jason.jackson.demo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class Address {
    private String street;
    private String city;
    private String state;
    private String zip;
    private String country;
}
