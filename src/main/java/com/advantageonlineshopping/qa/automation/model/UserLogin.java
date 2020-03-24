package com.advantageonlineshopping.qa.automation.model;

import com.advantageonlineshopping.qa.automation.exceptions.UserModelCreationException;
import lombok.Getter;

@Getter
public class UserLogin {

    private String username;
    private String password;

    public UserLogin(UserBuilder builder){

        this.username = builder.getUsername();
        this.password = builder.getPassword();
        isInvalid();
    }

    private void isInvalid(){

        if(isEmptyOrNull(username)||isEmptyOrNull(password)){
            throw new UserModelCreationException(
                    String.format("Invalid username (%s) or password (%s)", username,password));
        }
    }

    private static boolean isEmptyOrNull(String value){

        return value == null || value.isEmpty();
    }
}
