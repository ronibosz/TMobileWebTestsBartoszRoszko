package pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

@Getter
public class ItemPage {
    private final SelenideElement totalUpfront =
        $x("//span//div[@data-qa='PRD_TotalUpfront']//div[@class='dt_price_change']//div");
    private final SelenideElement totalMonthly =
        $x("//span//div[contains(@class, 'styles__StyledMonthly')]//div[@class='dt_price_change']//div");
    private final SelenideElement addToBasketButton =
        $x("//span//button[@data-qa='PRD_AddToBasket']");
}
