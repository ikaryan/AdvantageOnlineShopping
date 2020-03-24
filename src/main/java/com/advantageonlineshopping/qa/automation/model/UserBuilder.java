package com.advantageonlineshopping.qa.automation.model;

import com.advantageonlineshopping.qa.automation.exceptions.UserModelCreationException;
import javafx.util.Builder;
import lombok.Getter;

@Getter
public class UserBuilder implements Builder<UserLogin> {

    private String username;
    private String password;

    private UserBuilder(String username){ this.username = username; }

    public static UserBuilder username(String username) { return new UserBuilder(username); }

    public static UserBuilder password(String password) { return  new UserBuilder(password); }

    public UserLogin withPassword(String password) throws UserModelCreationException {
        this.password = password;
        return this.build();
    }

    @Override
    public UserLogin build() throws UserModelCreationException {

        return new UserLogin(this);
    }

    public static UserBuilder theUser(String username){

        return new UserBuilder(username);
    }
}
