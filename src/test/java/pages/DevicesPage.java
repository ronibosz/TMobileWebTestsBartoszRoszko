package pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

@Getter
public class DevicesPage {
    private final SelenideElement firstGridElementLink =
        $x("//div[starts-with(@class, 'styles__StyledDevicesAndSummary')]//div[@class='grid-child']//a");
}
