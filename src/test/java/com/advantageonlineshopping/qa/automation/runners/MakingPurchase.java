package com.advantageonlineshopping.qa.automation.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features ="src/test/resources/features/making_purchase.feature",
        glue = {"com.advantageonlineshopping.qa.automation.stepdefinitions"},
        snippets= SnippetType.CAMELCASE )

public class MakingPurchase {
}
