package hhTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.*;


@Tag ("hhTests")
public class HHTests extends TestBase {

    @Test
    @DisplayName("Open main page")
    void openMainPage() {
        $(".supernova-icon-services-dynamic").click();
        $(".supernova-overlay__content").shouldHave(text("Сервисы для соискателей"));

    };

    @Test
    @DisplayName("Chose town")
    void moveToTheSection() {
        $(".supernova-navi-item_area-switcher-button").click();
        $(byLinkText("Санкт-Петербург")).click();
        $(".supernova-navi").shouldHave(text("Санкт-Петербург"));


    };

    @Test
    @DisplayName("Search for  vacancies")
    void searchVacancies() {
        $(".bloko-input_scale-large").setValue("Тестировщик");
        $(".bloko-button_stretched").submit();
        $(".vacancy-serp-content").shouldHave(text("Тестировщик"));
    }

    ;

    @Test
    @DisplayName("Choose a vacancy in my city")
    void chooseVacancy() {
        open("https://spb.hh.ru/?customDomain=1");
        $$("ul.multiple-column-list_narrow li").get(11).$("a").click();
        $(".bloko-input").setValue("Тестировщик").pressEnter();
        $(".vacancy-serp-content").shouldHave(text("Тестировщик"));
    };

    @Test
    @DisplayName("Select news")
    void selectNews() {
        $(byLinkText("Что такое «сильные стороны» и как их определить")).pressEnter();
        $(".cms-header-content ").shouldHave(text("Что такое «сильные стороны» и как их определить"));
    }
}








