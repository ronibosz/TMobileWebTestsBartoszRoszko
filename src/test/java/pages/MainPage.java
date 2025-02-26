package pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Getter
public class MainPage {
    private final SelenideElement cookiesAgreeButton = $(By.id("didomi-notice-agree-button"));
    private final SelenideElement devices = $x("//button[text()='Urządzenia']");
    private final SelenideElement smartwatches = $x("//a[@data-ga-ea='nav-links - Urządzenia/Bez abonamentu/Smartwatche']");
    private final SelenideElement basketSvgPath = $x("//a[@title='Koszyk']//*[name()='path']");   // todo: 2 wyniki
    private final SelenideElement basketItemsNumber = basketSvgPath.$x("../../div");
}
