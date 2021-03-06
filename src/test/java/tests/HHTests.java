package tests;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.*;

 @Tag("hhTests")
 public class openWebsiteAndChooseTownTests extends TestBase {
 @Test
 void openMainPage() {
      open();
      $(".supernova-icon-services-dynamic").click();
      $(".supernova-overlay__content").shouldHave(text("Сервисы для соискателей"));
   }

 @Test
 void choseTown() {
      open();
      $(".supernova-navi-item_area-switcher-button").click();
      $(byLinkText("Санкт-Петербург")).click();
      $(".supernova-navi").shouldHave(text("Санкт-Петербург"));        }
    }
}
