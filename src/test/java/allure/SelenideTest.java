package allure;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class SelenideTest {
    String ADDRESS = "https://github.com";
    String INPUT_VALUE = "selenide";
    String VALUE = "Milestones";

    @Test
    @Step("Поиск текста на странице \"Milestones\"")
    public void testGitHubStep() {
        open(ADDRESS);
        $("[aria-label=\"Search GitHub\"]").setValue(INPUT_VALUE).pressEnter();
        $$(".v-align-middle").filter(text("selenide/selenide")).get(0).click();
        $("#issues-tab").click();
        $(byText(VALUE)).shouldBe(visible);
    }

    @Test
    public void testGitHubLambda() {
        step("Открыть главную страницу", () -> {
            open(ADDRESS);
        });
        step("Ввести в поисковую строку название репозитория и найти его", () -> {
            $("[aria-label=\"Search GitHub\"]").setValue(INPUT_VALUE).pressEnter();
            $$(".v-align-middle").filter(text("selenide/selenide")).get(0).click();
        });
        step("перейти во вкладку issues", () -> {
            $("#issues-tab").click();
        });
        step("проверить что на странице присутствует текст "+VALUE, () -> {
            $(byText(VALUE)).shouldBe(visible);
        });
    }

    @Test
    public void testGitHub() {
        open(ADDRESS);
        $("[aria-label=\"Search GitHub\"]").setValue(INPUT_VALUE).pressEnter();
        $$(".v-align-middle").filter(text("selenide/selenide")).get(0).click();
        $("#issues-tab").click();
        $(byText(VALUE)).shouldBe(visible);
    }
}