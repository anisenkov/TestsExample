import io.qameta.allure.Step
import org.junit.Test
import org.openqa.selenium.By
import utils.BaseTest

import static org.junit.Assert.assertEquals

/**
 * Created by aniae on 19.01.2018.
 */
class TestMailSending extends BaseTest {
    def login = "testloginsbt1"
    def message = "Hello!"

    @Test
    void mailSendingTest() {
        newMessage()
        checkMessage()
        deleteMessage()
    }

    @Step
    void newMessage() {
        ctx.login(login, "Qwerty123")
        ctx.page.clickButton("Написать")
        ctx.page.mailSendingPage.setToField("$login@yandex.ru")
        ctx.page.mailSendingPage.setSubject("Test")
        ctx.page.mailSendingPage.setMessage(message)
        ctx.page.clickButton("Отправить")
    }

    @Step
    void checkMessage() {
        ctx.page.mailMenu.selectMenu("Входящие")
        ctx.waitElement(By.className("mail-MessageSnippet-FromText")).click()
        assertEquals("Проверка отправленного сообщения", ctx.page.getMessage(), message)
    }

    @Step
    void deleteMessage() {
        ctx.page.clickButton("Удалить")
    }
}
