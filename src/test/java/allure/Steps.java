package allure;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Steps {
    /**
     * Элементы на странице
     */
    private final SelenideElement searchInput
            = $("[aria-label=\"Search GitHub\"]");
    private final
    ElementsCollection value
            = $$(".v-align-middle");
    private final SelenideElement element
            = $("#issues-tab");

    /**
     * Открытие в браузере url
     *
     * @param url - ссылка на ресурс
     */
    @Step
    public void openUrl(String url) {
        open(url);
    }

    /**
     * Ввод в поисковую строку необходимое значение
     *
     * @param value- искомое значение
     */
    @Step
    public void searchValue(String value) {
        searchInput.setValue(value).pressEnter();
    }


    /**
     * Поиск необходимого элемента на странице и нажатие по нему
     *
     * @param element элемент на странице
     */
    @Step
    public void checkValue(String element) {
        value.filter(text(element)).get(0).click();
    }

    /**
     * Нажатие по элементу issues-tab
     */
    @Step
    public void clickElement() {
        element.click();
    }

    /**
     * Проверка наличия на странице нужного текста
     *
     * @param value элемент на странице
     */
    @Step
    public void checkText(String value) {
        $(byText(value)).shouldBe(visible);
    }
}