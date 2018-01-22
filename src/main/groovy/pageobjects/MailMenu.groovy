package pageobjects

import com.codeborne.selenide.Condition
import org.openqa.selenium.By

import java.util.concurrent.locks.LockSupport

import static com.codeborne.selenide.Selenide.$
import static context.TestCaseContext.timeout

/**
 * Created by aniae on 22.01.2018.
 */
class MailMenu {
    public void selectMenu(String menu) {
        LockSupport.parkNanos(1 * 1000 * 1000 * 1000)
        $(By.xpath("//span[contains(@class, 'mail-NestedList-Item-Name js-folders-item-name') and text()='$menu']"))
                .waitUntil(Condition.visible, timeout).click();
    }
}
