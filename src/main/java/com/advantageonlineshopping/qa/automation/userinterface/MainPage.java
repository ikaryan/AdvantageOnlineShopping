package com.advantageonlineshopping.qa.automation.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MainPage {

    public static final Target PRODUCT = Target.the("product").locatedBy("//div[@id='{0}Img']");
    public static final Target FILTERS = Target.the("price filter").locatedBy("//h4[@id='accordion{0}']");
    public static final Target PRICE_SLIDER = Target.the("price slider").located(By.id("slider"));
    public static final Target DISPLAY_TYPE = Target.the("display type").locatedBy("//input[@id='display_{0}']");
    public static final Target OPERATING_SYSTEM_TYPE= Target.the("operating system type").locatedBy("//input[@id='operating_system_{0}']");
    public static final Target PROCESSOR_TYPE = Target.the("processor type").locatedBy("//input[@id='processor_{0}']");
    public static final Target COLOR_TYPE = Target.the("color type").locatedBy("//a[@id='productsColors{0}']");
    public static final Target PRODUCT_SELECTED = Target.the("product").locatedBy("//img[@id='{0}']");
    public static final Target QUANTITY = Target.the("quantity").located(By.name("quantity"));
    public static final Target ADD_TO_CART = Target.the("add to cart").located(By.name("save_to_cart"));
    public static final Target MENU_CART = Target.the("menu cart").located(By.id("menuCart"));
    public static final Target CHECKOUT_BUTTON = Target.the("checkout button").located(By.id("checkOutButton"));
    public static final Target PAYMENT_NEXT_BUTTON = Target.the("payment next button").located(By.id("next_btn"));
    public static final Target PAYMENT_SAFEPAY_NAME = Target.the("payment safepay name").located(By.name("safepay_username"));
    public static final Target PAYMENT_SAFEPAY_PASS = Target.the("payment safepay password").located(By.name("safepay_password"));
    public static final Target PAYMENT_NOW_BUTTON = Target.the("payment now button").located(By.id("pay_now_btn_SAFEPAY"));
    public static final Target THANKS_PAYMENT_LABEL = Target.the("thanks payment label").locatedBy("//span[@class='roboto-regular ng-scope']");
}

