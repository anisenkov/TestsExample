package pageobjects.base

import com.codeborne.selenide.Condition
import com.codeborne.selenide.SelenideElement
import org.openqa.selenium.By

import static com.codeborne.selenide.Selectors.byText
import static com.codeborne.selenide.Selenide.$
import static context.TestCaseContext.timeout

/**
 * Created by aniae on 17.01.2018.
 */
public class Form {

    public void setField(String fieldName, String value) {
        SelenideElement elem = $("[name='" + fieldName + "']").waitUntil(Condition.visible, timeout);
        elem.clear();
        elem.sendKeys(value);
    }

    public String getField(String fieldName) {
        return $("[name='" + fieldName + "']").getValue()
    }

    public void clickButton(String buttonName) {
        $(By.xpath("//span[contains(@class, 'button__text') and text()='$buttonName']")).click();
    }

    public void selectCountry(String country){
        $(By.xpath("//span[contains(@class, 'button__text') and text()='Россия']")).click()
        SelenideElement element = $(byText(country))
        element.scrollTo().click()
    }

    public void selectMonth(Months months) {
        $(byText("Месяц")).click()
        $(byText(months.month)).waitUntil(Condition.visible, timeout).click()
    }

    public enum Months {
        JANUARY("Январь"),
        FEBRUARY("Февраль"),
        MARCH("Март");

        private String month

        Months(String month) {
            this.month = month
        }
    }

    public void ok() {
    }

    public void cancel() {
        clickButton("Отмена")
    }

    public void save() {
        clickButton("Сохранить")
    }

}
