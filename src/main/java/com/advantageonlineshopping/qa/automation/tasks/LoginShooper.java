package com.advantageonlineshopping.qa.automation.tasks;

import com.advantageonlineshopping.qa.automation.model.UserBuilder;
import com.advantageonlineshopping.qa.automation.util.WaitLoadObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class LoginShooper implements Task{

    private String username;
    private String password;
    private String userRegistered;
    private String pass;
    private String userStatus;
    private static final String URL_WEBSITE = "https://www.advantageonlineshopping.com/#/";

    public LoginShooper(String user, String pass, String status) {

        this.username = user;
        this.password = pass;
        this.userStatus = status;
    }

    public LoginShooper() {

        this.userRegistered = "Charles";
        this.pass = "Karlox123++";
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        if("Not active".equals(userStatus)){
            startSessionWithUsernameNotRegistered();
        }else startSessionWithUsernameAndPassword();
    }

    public void startSessionWithUsernameAndPassword() {

        theActorInTheSpotlight().attemptsTo(Open.url(URL_WEBSITE));
        WaitLoadObject.wait("container");
        theActorInTheSpotlight().wasAbleTo(StartWith.authenticating(UserBuilder.theUser(userRegistered)
                .withPassword(pass)));
    }

    public void startSessionWithUsernameNotRegistered() {

        theActorInTheSpotlight().attemptsTo(Open.url(URL_WEBSITE));
        WaitLoadObject.wait("container");
        theActorInTheSpotlight().wasAbleTo(StartWith.notRegistering(username,password,userStatus));
    }
}
