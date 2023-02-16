package allure;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Steps {

    private final SelenideElement searchInput
            = $("[aria-label=\"Search GitHub\"]");
    private final
    ElementsCollection value
            = $$(".v-align-middle");
    private final SelenideElement element
            = $("#issues-tab");

    @Step
    public void openUrl(String url) {
        open(url);
    }

    @Step
    public void searchValue(String value) {
        searchInput.setValue(value).pressEnter();
    }

    @Step
    public void checkValue() {
        value.filter(text("selenide/selenide")).get(0).click();
    }

    @Step
    public void clickElement() {
        element.click();
    }

    @Step
    public void checkText(String value) {
        $(byText(value)).shouldBe(visible);
    }


}
