package com.example.springdemo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="customer")
@Data
@NoArgsConstructor
@ToString
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    @NotEmpty(message = "Please provide a first name")
    private String firstName;

    @Column(name="last_name")
    @NotEmpty(message = "Please provide a last name")
    private String lastName;

    @Column(name="email")
    @NotEmpty(message = "Please provide an email")
    private String email;

}
