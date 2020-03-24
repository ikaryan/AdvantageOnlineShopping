package com.advantageonlineshopping.qa.automation.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class UserLoginPage {

    public static final Target USER_MENU = Target.the("user icon").located(By.id("menuUser"));
    public static final Target CREATE_NEW_ACCOUNT = Target.the("create new account button").locatedBy("//a[@class='create-new-account ng-scope']");
    public static final Target USERNAME = Target.the("user name").located(By.name("usernameRegisterPage"));
    public static final Target EMAIL = Target.the("user email").located(By.name("emailRegisterPage"));
    public static final Target PASSWORD = Target.the("user password").located(By.name("passwordRegisterPage"));
    public static final Target CONFIRM_PASSWORD = Target.the("user confirm password").located(By.name("confirm_passwordRegisterPage"));
    public static final Target FIRST_NAME = Target.the("user first name").located(By.name("first_nameRegisterPage"));
    public static final Target LAST_NAME = Target.the("user last name").located(By.name("last_nameRegisterPage"));
    public static final Target PHONE_NUMBER = Target.the("user phone number").located(By.name("phone_numberRegisterPage"));
    public static final Target COUNTRY = Target.the("user country").located(By.name("countryListboxRegisterPage"));
    public static final Target CITY = Target.the("user city").located(By.name("cityRegisterPage"));
    public static final Target ADDRESS = Target.the("user address").located(By.name("addressRegisterPage"));
    public static final Target STATE = Target.the("user state").located(By.name("state_/_province_/_regionRegisterPage"));
    public static final Target POSTAL_CODE = Target.the("user postal code").located(By.name("postal_codeRegisterPage"));
    public static final Target IAGREE = Target.the("i agree button").locatedBy("//*[@id=\"formCover\"]/sec-view/div/input");
    public static final Target REGISTER_BUTTON = Target.the("user register button").located(By.id("register_btnundefined"));
    public static final Target USER_SIGN_OUT = Target.the("user sign in button").locatedBy("//label[@class='option roboto-medium ng-scope'][contains(text(),'Sign out')]");
    public static final Target USER_NAME_LOGIN = Target.the("user name login").located(By.name("username"));
    public static final Target PASSWORD_LOGIN = Target.the("user password login").located(By.name("password"));
    public static final Target SIGN_IN_BUTTON = Target.the("user sign in button").located(By.id("sign_in_btnundefined"));
    public static final Target PERSONAL_NAME = Target.the("sign in result message").locatedBy("//span[@class='hi-user containMiniTitle ng-binding']");

}
