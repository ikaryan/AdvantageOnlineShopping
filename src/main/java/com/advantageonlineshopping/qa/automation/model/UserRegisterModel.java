package com.advantageonlineshopping.qa.automation.model;

import lombok.Data;

@Data
public class UserRegisterModel {

    private String userName;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String country;
    private String city;
    private String address;
    private String state;
    private String postalCode;
    private static UserRegisterModel instanceUserRegister;
}
