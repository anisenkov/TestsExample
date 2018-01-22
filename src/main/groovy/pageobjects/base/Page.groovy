package pageobjects.base

import com.codeborne.selenide.Condition
import org.openqa.selenium.By
import pageobjects.AccountDropdownMenu
import pageobjects.MailMenu
import pageobjects.MailSendingPage
import pageobjects.ProfilePage

import static com.codeborne.selenide.Selectors.byClassName
import static com.codeborne.selenide.Selectors.byText
import static com.codeborne.selenide.Selenide.$
import static context.TestCaseContext.timeout

/**
 * Created by aniae on 19.01.2018.
 */
class Page {

    public void clickLink(String link) {
        $(By.xpath("//a[contains(text(),'$link')]")).click()
    }

    public AccountDropdownMenu getDropdownMenu() { return new AccountDropdownMenu() }

    void clickButton(String buttonName) {
        $(byText(buttonName)).click()
    }

    public String getMessage(){
        return $(byClassName("mail-Message-Body-Content")).waitUntil(Condition.visible, timeout).getText()
    }

    public ProfilePage getProfilePage() { return new ProfilePage() }

    public MailSendingPage getMailSendingPage() { return new MailSendingPage() }

    public MailMenu getMailMenu() { return new MailMenu() }
}
