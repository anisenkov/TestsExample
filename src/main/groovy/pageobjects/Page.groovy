package pageobjects

import org.openqa.selenium.By

import static com.codeborne.selenide.Selectors.byText
import static com.codeborne.selenide.Selenide.$

/**
 * Created by aniae on 19.01.2018.
 */
class Page {

    public void clickLink(String link)
    {
        $(By.xpath("//a[contains(text(),'$link')]")).click()
    }

    public AccountDropdownMenu getDropdownMenu(){ return new AccountDropdownMenu() }

    void clickButton(String buttonName)
    {
        $(byText(buttonName)).click()
    }

    public ProfilePage getProfilePage(){return new ProfilePage()}

    public MailSendingPage getMailSendingPage(){return new MailSendingPage()}
}
