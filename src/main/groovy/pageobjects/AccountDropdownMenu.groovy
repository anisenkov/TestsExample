package pageobjects

import static com.codeborne.selenide.Condition.visible
import static com.codeborne.selenide.Selenide.$
import static context.TestCaseContext.timeout

/**
 * Created by aniae on 18.01.2018.
 */
public class AccountDropdownMenu {

    public void click() { $("div.mail-User-Name").click() }

    public void clickItem(String item) {
        def elem = $("[data-metric=\"$item\"]")
        if (!elem.isDisplayed()) {
            click()
        }
        elem.waitUntil(visible, timeout).click()
    }
}
