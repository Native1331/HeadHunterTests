package tests;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.*;

    @Tag("hhTests")
    public class HHTests extends TestBase {

        @Test
        void openMainPage() {
            $(".supernova-icon-services-dynamic").click();
            $(".supernova-overlay__content").shouldHave(text("Сервисы для соискателей"));
        }

        @Test
        void choseTown() {
            $(".supernova-navi-item_area-switcher-button").click();
            $(byLinkText("Санкт-Петербург")).click();
            $(".supernova-navi").shouldHave(text("Санкт-Петербург"));
        }
        @ValueSource(strings = {
                "Тестировщик",
                "Аналитик"})

        @ParameterizedTest(name="Поиск вакансий по словам{0}")
        void searchVacancies(String vacancy) {
            $(".bloko-input_scale-large").setValue(vacancy);
            $(".bloko-button_stretched").submit();
            $(".vacancy-serp-content").shouldHave(text(vacancy));
        }

        @CsvSource({
                "Тестировщик ПО",
                "Системный аналитик"
        })

        @ParameterizedTest(name = "Проверка поиска вакансий по слову {0}, ожидаем результат {1}" )
        void chooseAVacancyInMyTown(String vacancy, String expectedVacancies) {
            Selenide.open("https://spb.hh.ru/?customDomain=1");
            $$("ul.multiple-column-list_narrow li").get(11).$("a").click();
            $(".bloko-input").setValue(vacancy);
            $$(".vacancy-serp-content")
                    .find(Condition.text(expectedVacancies))
                        .shouldBe(Condition.visible);
        }

        @Test
        void selectNews() {
            $("kind-tertiary").pressEnter();
            $(".cms-header-content ").shouldHave(text("Что такое «сильные стороны» и как их определить"));
        }
    }
