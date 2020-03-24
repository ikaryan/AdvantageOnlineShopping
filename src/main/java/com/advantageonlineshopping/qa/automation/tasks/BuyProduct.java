package com.advantageonlineshopping.qa.automation.tasks;

import com.advantageonlineshopping.qa.automation.model.ProductModel;
import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.util.List;

import static com.advantageonlineshopping.qa.automation.userinterface.MainPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class BuyProduct implements Task {

    private List<ProductModel> productInfo;

    public BuyProduct(List<ProductModel> productInfo) {

        this.productInfo = productInfo;
    }

    @Override  @SneakyThrows
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Click.on(FILTERS.of("Price").getCssOrXPathSelector()),
                        Click.on(PRICE_SLIDER),
                        Click.on(FILTERS.of("Attrib0").getCssOrXPathSelector()),
                        Click.on(DISPLAY_TYPE.of(productInfo.get(0).getDisplayType()).getCssOrXPathSelector()),
                        Click.on(FILTERS.of("Attrib0").getCssOrXPathSelector()),
                        Click.on(FILTERS.of("Attrib1").getCssOrXPathSelector()),
                        Click.on(OPERATING_SYSTEM_TYPE.of(productInfo.get(0).getOperatingSysType()).getCssOrXPathSelector()),
                        Click.on(FILTERS.of("Attrib1").getCssOrXPathSelector()),
                        Click.on(FILTERS.of("Attrib2").getCssOrXPathSelector()),
                        Click.on(PROCESSOR_TYPE.of(productInfo.get(0).getProcessorType()).getCssOrXPathSelector()),
                        Click.on(FILTERS.of("Attrib2").getCssOrXPathSelector()),
                        Click.on(FILTERS.of("Color").getCssOrXPathSelector()),
                        Click.on(COLOR_TYPE.of(productInfo.get(0).getColorType()).getCssOrXPathSelector()));
         actor.attemptsTo(Click.on(PRODUCT_SELECTED.of(productInfo.get(0).getProductSelected()).getCssOrXPathSelector()));
         actor.attemptsTo(Enter.theValue(productInfo.get(0).getQuantity()).into(QUANTITY));
         actor.attemptsTo(Click.on(ADD_TO_CART), Click.on(MENU_CART));
    }

    public static BuyProduct withSpecifications(List<ProductModel> dataProduct) {
        return instrumented(BuyProduct.class, dataProduct);
    }
}
