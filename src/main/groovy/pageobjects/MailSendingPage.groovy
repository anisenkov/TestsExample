package pageobjects

import pageobjects.base.Page

import static com.codeborne.selenide.Selenide.$

/**
 * Created by aniae on 19.01.2018.
 */
class MailSendingPage extends Page {

    public void setToField(String value) {
        $("[name=\"to\"]").sendKeys(value)
    }

    public void setSubject(String value) {
        $("[name=\"subj\"]").sendKeys(value)
    }

    public void setMessage(String message) {
        $("[role=\"textbox\"]").sendKeys(message)
    }
}
