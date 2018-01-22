

import io.qameta.allure.Step
import org.junit.Test
import pageobjects.base.Form
import utils.BaseTest

import static org.junit.Assert.assertEquals;

/**
 * Created by aniae on 17.01.2018.
 */
class TestPersonalInfoForm extends BaseTest {

    @Test
    void personalInfoTest() {
        ctx.login("testloginsbt1", "Qwerty123")
        ctx.page.dropdownMenu.clickItem("Управление аккаунтом")
        ctx.page.clickLink("Изменить персональные данные")
        assertEquals("Проверка имени пользователя на странице профиля", page.profilePage.getPersonalInfoName(), "Василий Тестов")
        fillForm()
        print(page.profilePage.getPersonalInfoName())
        ctx.quit()
    }

    @Step("Проверка и заполнение формы персональных данных")
    void fillForm() {
        assertEquals("Проверка текущего имени пользователя", form.getField("firstname"), "Василий")
        assertEquals("Проверка текущей фамилии пользователя", form.getField("lastname"), "Тестов")

        ctx.form.setField("firstname", "Vasily")
        ctx.form.setField("lastname", "Testov")
        ctx.form.setField("birthday-day", "15")
        ctx.form.selectMonth(Form.Months.MARCH)
        ctx.form.setField("birthday-year", "1990")
        ctx.form.setField("city", "Moscow")
        ctx.form.clickButton("Мужской")
        ctx.form.selectCountry("Сингапур")
        ctx.form.clickButton("Отменить")
    }
}
