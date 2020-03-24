package com.advantageonlineshopping.qa.automation.questions;

import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.advantageonlineshopping.qa.automation.userinterface.MainPage.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class TheProductToBuy implements Question<String> {

    private String safePayUser;
    private String safePayPass;

    public TheProductToBuy(String safePayUser, String safePayPass) {

        this.safePayUser = safePayUser;
        this.safePayPass = safePayPass;
    }

    @Override @SneakyThrows
    public String answeredBy(Actor actor) {
        WebDriver driver = BrowseTheWeb.as(theActorInTheSpotlight()).getDriver();
        WebDriverWait wait = new WebDriverWait(driver, 40);
        theActorInTheSpotlight().attemptsTo(Click.on(CHECKOUT_BUTTON));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("next_btn")));
        theActorInTheSpotlight().attemptsTo(Click.on(PAYMENT_NEXT_BUTTON));
        theActorInTheSpotlight().attemptsTo(Enter.theValue(safePayUser).into(PAYMENT_SAFEPAY_NAME),
                Enter.theValue(safePayPass).into(PAYMENT_SAFEPAY_PASS));
        theActorInTheSpotlight().attemptsTo(Click.on(PAYMENT_NOW_BUTTON));
        return THANKS_PAYMENT_LABEL.resolveFor(actor).getText().trim();
    }

    public static TheProductToBuy isPaid(String safePayUser, String safePayPass) {
        return new TheProductToBuy(safePayUser,safePayPass);
    }
}
