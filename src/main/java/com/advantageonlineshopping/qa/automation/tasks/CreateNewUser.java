package com.advantageonlineshopping.qa.automation.tasks;

import com.advantageonlineshopping.qa.automation.model.UserRegisterModel;
import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

import static com.advantageonlineshopping.qa.automation.userinterface.UserLoginPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CreateNewUser implements Task {

    private List<UserRegisterModel> userData;

    public CreateNewUser(List<UserRegisterModel> userData) {

        this.userData = userData;
    }

    @SneakyThrows
    @Override
    public <T extends Actor> void performAs(T actor) {
        Robot robot =new Robot();
        actor.attemptsTo(Enter.theValue(userData.get(0).getUserName()).into(USERNAME),
                        Enter.theValue(userData.get(0).getEmail()).into(EMAIL),
                        Enter.theValue(userData.get(0).getPassword()).into(PASSWORD),
                        Enter.theValue(userData.get(0).getPassword()).into(CONFIRM_PASSWORD),
                        Enter.theValue(userData.get(0).getFirstName()).into(FIRST_NAME),
                        Enter.theValue(userData.get(0).getLastName()).into(LAST_NAME),
                        Enter.theValue(userData.get(0).getPhoneNumber()).into(PHONE_NUMBER),
                        SelectFromOptions.byVisibleText(userData.get(0).getCountry()).from(COUNTRY),
                        Enter.theValue(userData.get(0).getCity()).into(CITY),
                        Enter.theValue(userData.get(0).getAddress()).into(ADDRESS),
                        Enter.theValue(userData.get(0).getState()).into(STATE),
                        Enter.theValue(userData.get(0).getPostalCode()).into(POSTAL_CODE));
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        actor.attemptsTo(Click.on(IAGREE));
        actor.attemptsTo( Click.on(REGISTER_BUTTON));
    }

    public static CreateNewUser withData(List<UserRegisterModel> data) {
        return instrumented(CreateNewUser.class, data);
    }
}
