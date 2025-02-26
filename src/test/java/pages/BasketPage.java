package pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

@Getter
public class BasketPage {
    private final SelenideElement totalUpfront = $x("//span[@data-qa='BKT_TotalupFront']");
    private final SelenideElement totalUpfrontSymbol = $x("//span[@data-qa='BKT_TotalupFrontSymbol']");
    private final SelenideElement totalMonthly = $x("//span[@data-qa='BKT_TotalMonthly']");
    private final SelenideElement totalMonthlySymbol = $x("//span[@data-qa='BKT_TotalMonthlySymbol']");
}
