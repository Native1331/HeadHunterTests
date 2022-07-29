package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

@Tag("hhTests")
public class ParametrizedTests extends TestBase {
    @ValueSource(strings = {
            "Тестировщик",
            "Аналитик"})

    @ParameterizedTest(name = "Поиск вакансий по словам{0}")
    void searchVacancies(String vacancy) {
        open();
        $(".bloko-input_scale-large").setValue(vacancy);
        $(".bloko-button_stretched").submit();
        $(".vacancy-serp-content").shouldHave(text(vacancy));
    }

    @CsvSource(value = {
            "Тестировщик, Опыт тестирования веб-приложений не менее двух лет",
            "Аналитик, Участие в процессе формирования заказов в информационных системах"
    })
    
    @ParameterizedTest(name = "Проверка поиска вакансий по словам{0}, ожидаем результат{1}")
    void chooseAVacancyInMyTown(String vacancy, String expectedText) {
        open();
        $(".bloko-input_scale-large").setValue(vacancy);
        $(".bloko-button_stretched").submit();
        $(".vacancy-serp-content").shouldHave(text(expectedText));
    }
}
