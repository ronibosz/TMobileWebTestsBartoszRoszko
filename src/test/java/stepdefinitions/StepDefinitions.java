package stepdefinitions;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BasketPage;
import pages.DevicesPage;
import pages.ItemPage;
import pages.MainPage;
import utils.Price;
import utils.Utils;

import static com.codeborne.selenide.Selenide.open;
import static utils.Utils.PRICE_REGEX;

public class StepDefinitions {
    private static final String MAIN_PAGE_URL = "https://t-mobile.pl";

    private final MainPage mainPage = new MainPage();
    private final DevicesPage devicesPage = new DevicesPage();
    private final ItemPage itemPage = new ItemPage();
    private final BasketPage basketPage = new BasketPage();

    private Price storedItemTotalUpfront;
    private Price storedItemTotalMonthly;

    @Given("The main page is open")
    public void openPage() {
        open(MAIN_PAGE_URL);
    }

    @Given("User accepts cookies")
    public void acceptCookies() {
        mainPage.getCookiesAgreeButton().click();
    }

    @Given("User opens Smartwatche")
    public void openSmartwatches() {
        mainPage.getDevices().hover();
        mainPage.getSmartwatches().click();
    }

    @Given("User chooses the first item")
    public void chooseFirstItem() {
        devicesPage.getFirstGridElementLink().click();
    }

    @When("User adds the item to the basket")
    public void addItemToBasket() {
        itemPage.getTotalUpfront().should(Condition.matchText(PRICE_REGEX));
        itemPage.getTotalMonthly().should(Condition.matchText(PRICE_REGEX));
        storedItemTotalUpfront = Utils.parsePrice(itemPage.getTotalUpfront().getOwnText());
        storedItemTotalMonthly = Utils.parsePrice(itemPage.getTotalMonthly().getOwnText());
        itemPage.getAddToBasketButton().click();
    }

    @Then("The basket is shown with correct prices")
    public void checkBasketPrices() {
        basketPage.getTotalUpfront().shouldBe(Condition.exactOwnText(storedItemTotalUpfront.amount()));
        basketPage.getTotalUpfrontSymbol().shouldBe(Condition.exactOwnText(storedItemTotalUpfront.symbol()));
        basketPage.getTotalMonthly().shouldBe(Condition.exactOwnText(storedItemTotalMonthly.amount()));
        basketPage.getTotalMonthlySymbol().shouldBe(Condition.exactOwnText(storedItemTotalMonthly.symbol()));
    }

    @Then("The basket with {int} item(s) is visible on the main page")
    public void checkBasketOnMainPage(int noOfItems) {
        open(MAIN_PAGE_URL);
        mainPage.getBasketSvgPath().shouldHave(Condition.attributeMatching("d", ".*\\S+.*"));
        mainPage.getBasketItemsNumber().shouldBe(Condition.exactOwnText(Integer.toString(noOfItems)));
    }
}
