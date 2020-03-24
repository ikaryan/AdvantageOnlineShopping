package com.advantageonlineshopping.qa.automation.tasks;

import com.advantageonlineshopping.qa.automation.model.UserLogin;
import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.advantageonlineshopping.qa.automation.userinterface.UserLoginPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class StartWith implements Task {

    private String username;
    private String pass;
    private String status;
    private UserLogin user;

    public StartWith(String user, String pass, String status) {

        this.username = user;
        this.pass = pass;
        this.status = status;
    }

    public StartWith(UserLogin user) {this.user = user; }

    @Override
    public <T extends Actor> void performAs(T actor) {

        if("Not active".equals(this.status)) {
            notRegisteredUser(actor);
            actor.attemptsTo(Click.on(CREATE_NEW_ACCOUNT));
        }else authenticateUser(actor);
    }

    public static StartWith authenticating(UserLogin user) {
        return instrumented(StartWith.class, user);
    }

    public static StartWith notRegistering(String username, String pass, String status) {
        return instrumented(StartWith.class, username,pass, status);
    }

    @SneakyThrows
    private <T extends Actor> void authenticateUser(T actor) {

        actor.attemptsTo(Click.on(USER_MENU),
                        Enter.theValue(user.getUsername()).into(USER_NAME_LOGIN),
                        Enter.theValue(user.getPassword()).into(PASSWORD_LOGIN),
                        Click.on(SIGN_IN_BUTTON));
    }

    @SneakyThrows
    private <T extends Actor> void notRegisteredUser(T actor) {

        actor.attemptsTo(Click.on(USER_MENU));
        actor.attemptsTo(Enter.theValue(username).into(USER_NAME_LOGIN),
                Enter.theValue(pass).into(PASSWORD_LOGIN),
                Click.on(SIGN_IN_BUTTON));
    }
}
