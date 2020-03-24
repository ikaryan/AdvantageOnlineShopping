package com.advantageonlineshopping.qa.automation.stepdefinitions;

import com.advantageonlineshopping.qa.automation.questions.TheReplyMessage;
import com.advantageonlineshopping.qa.automation.model.ProductModel;
import com.advantageonlineshopping.qa.automation.model.UserRegisterModel;
import com.advantageonlineshopping.qa.automation.questions.TheProductToBuy;
import com.advantageonlineshopping.qa.automation.tasks.BuyProduct;
import com.advantageonlineshopping.qa.automation.tasks.CreateNewUser;
import com.advantageonlineshopping.qa.automation.tasks.LoginShooper;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static com.advantageonlineshopping.qa.automation.userinterface.MainPage.PRODUCT;
import static com.advantageonlineshopping.qa.automation.userinterface.UserLoginPage.*;
import static com.advantageonlineshopping.qa.automation.util.Messages.SUCCESS_PURCHASE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class MakingPurchaseStepDefinitions {

    @Before
    public void setTheStage() {

        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Shooper");
    }

    @Given("^a new user needs access to buy a new product$")
    public void aNewUserNeedsAccessToBuyANewProduct(List<List<String>> userInfo) {

        String userStatus = "Not active";
        LoginShooper access = new LoginShooper(userInfo.get(1).get(0),userInfo.get(1).get(1), userStatus);
        access.startSessionWithUsernameNotRegistered();
    }

    @When("^the user is not registered and require being created$")
    public void theUserIsNotRegisteredAndRequireBeingCreated(List<UserRegisterModel> data) {

        theActorInTheSpotlight().attemptsTo(CreateNewUser.withData(data));
        theActorInTheSpotlight().remember("userDataRegister",data.get(0).getUserName());
    }

    @Then("^the new user is created successfully$")
    public void theNewUserIsCreatedSuccessfully()  {

        String userName = theActorInTheSpotlight().recall("userDataRegister");
        theActorInTheSpotlight().should(seeThat(TheReplyMessage.is(PERSONAL_NAME),
                equalToIgnoringCase(userName)));
        theActorInTheSpotlight().wasAbleTo(Click.on(USER_MENU),
                Click.on(USER_SIGN_OUT));
    }

    @Given("^an active user needs access to buy a new product$")
    public void anActiveUserNeedsAccessToBuyANewProduct() {

        LoginShooper access = new LoginShooper();
        access.startSessionWithUsernameAndPassword();
    }

    @When("^the product to buy is selected$")
    public void theProductToBuyIsSelected(List<ProductModel> dataProduct) {

        theActorInTheSpotlight().attemptsTo(Click.on(PRODUCT.of(
                dataProduct.get(0).getProductName()).getCssOrXPathSelector()));
        theActorInTheSpotlight().attemptsTo(BuyProduct.withSpecifications(dataProduct));
    }

    @Then("^the product is bought$")
    public void theProductIsBought(List<List<String>> payData)  {

        theActorInTheSpotlight().should(seeThat(TheProductToBuy.isPaid(payData.get(1).get(0),payData.get(1).get(1)),
                equalToIgnoringCase(SUCCESS_PURCHASE)));
    }
}
