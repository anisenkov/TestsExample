

import io.qameta.allure.Step
import org.junit.Test
import utils.BaseTest

/**
 * Created by aniae on 19.01.2018.
 */
class TestMailSending extends BaseTest {
    def login = "testloginsbt1"

    @Test
    void mailSendingTest() {
        newMessage()
    }

    @Step
    void newMessage()
    {
        ctx.login(login, "Qwerty123")
        ctx.page.clickButton("Написать")
        ctx.page.mailSendingPage.setToField("$login@yandex.ru")
        ctx.page.mailSendingPage.setSubject("Test")
        ctx.page.mailSendingPage.setMessage("Hello!")
        ctx.page.clickButton("Отправить")
        ctx.quit()
    }
}
