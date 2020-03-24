package com.advantageonlineshopping.qa.automation.util;

import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class WaitLoadObject {

	private String locator;

	private WaitLoadObject(String locator) {this.locator = locator;	}

	public static void wait(String locator) {

		WebDriver driver = BrowseTheWeb.as(theActorInTheSpotlight()).getDriver();
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(By.className(locator)));
	}
}
