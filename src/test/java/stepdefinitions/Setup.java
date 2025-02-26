package stepdefinitions;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.BeforeAll;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Setup {

    @BeforeAll
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        Configuration.timeout = 5000;
        Configuration.browserSize = "1920x1080";
        Configuration.reportsFolder = "target/reports/screenshots";
    }
}
