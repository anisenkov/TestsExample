package context;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.awaitility.Awaitility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pageobjects.base.Form;
import pageobjects.base.Page;
import utils.PropertyUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by aniae on 17.01.2018.
 */
public class TestCaseContext {
    static final Logger LOGGER = LoggerFactory.getLogger(TestCaseContext.class);
    public static TestCaseContext ctx = new TestCaseContext();
    private String host = PropertyUtils.getProp("webdriver.base.url.host");
    public static int timeout = 3000;


    public void open() {
        Selenide.open(host);
    }

    public void quit() {
        WebDriverRunner.getWebDriver().quit();
    }

    public void login(String userName, String password) {
        SelenideElement loginField = $("input[name='login']").waitUntil(Condition.visible, timeout);
        SelenideElement passField = $("input[name='passwd']").waitUntil(Condition.visible, timeout);
        open();
        loginField.click();
        loginField.setValue(userName);
        passField.click();
        passField.setValue(password);
        passField.submit();
    }

    public Form getForm() {
        return new Form();
    }

    public Page getPage() {
        return new Page();
    }

    public WebElement waitElement(By by) {
        WebDriver driver = WebDriverRunner.getWebDriver();
        LOGGER.info("Looking for element with name " + by.toString());
        Awaitility.await().ignoreExceptions()
                .atMost(1, TimeUnit.MINUTES).until(() ->
                driver.findElement(by).isDisplayed()
        );
        return driver.findElement(by);
    }
}
