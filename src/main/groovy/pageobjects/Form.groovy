package pageobjects

import com.codeborne.selenide.Condition
import com.codeborne.selenide.SelenideElement
import org.openqa.selenium.By

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

    public void ok() {
    }

    public void cancel() {
    }

    public void save() {
    }


}
