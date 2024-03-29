package allure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

/**
 * Три вариации тестов
 * Состоящих из шагов:
 * 1. Открыть страницу https://github.com
 * 2. Ввести по поисковую строку текст "selenide"
 * 3. Найти на странице репозиторий "selenide/selenide"
 * 4. Перейти во вкладку issues
 * 5. Проверить что на странице присутствует текст "Milestones"
 */
public class SelenideTest extends BaseTest {


    @Test
    @DisplayName("Шаги с аннотацией @Step")
    public void testGitHubStep() {
        Steps steps = new Steps();
    //    steps.openUrl(ADDRESS);
        steps.searchValue(INPUT_VALUE);
        steps.checkValue(CHECK_ELEMENT);
        steps.clickElement();
        steps.checkText(VALUE);
    }

    @Test
    @DisplayName("Лямбда шаги через step")
    public void testGitHubLambda() {
//        step("Открыть главную страницу", () -> {
//            open(ADDRESS);
//        });
        step("Ввести в поисковую строку название репозитория и найти его", () -> {
            $("[aria-label=\"Search GitHub\"]")
                    .setValue(INPUT_VALUE).pressEnter();
            $$(".v-align-middle").filter(text("selenide/selenide"))
                    .get(0).click();
        });
        step("перейти во вкладку issues", () -> {
            $("#issues-tab").click();
        });
        step("проверить что на странице присутствует текст " + VALUE, () -> {
            $(byText(VALUE)).shouldBe(visible);
        });
    }

    @Test
    @DisplayName("Чистый селенид")
    public void testGitHub() {
     //   open(ADDRESS);
        $("[aria-label=\"Search GitHub\"]").setValue(INPUT_VALUE).pressEnter();
        $$(".v-align-middle").filter(text("selenide/selenide")).get(0).click();
        $("#issues-tab").click();
        $(byText(VALUE)).shouldBe(visible);
    }
}