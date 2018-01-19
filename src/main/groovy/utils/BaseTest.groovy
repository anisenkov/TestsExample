package utils

import context.TestCaseContext
import groovy.util.logging.Slf4j
import org.junit.After
import org.junit.Before

/**
 * Created by aniae on 17.01.2018.
 */
@Slf4j
public class BaseTest extends TestCaseContext {

    @Before
    public void before() {
        log.info("Open the browser")
        System.setProperty("selenide.browser", "chrome");
        open()
    }

    @After
    public void after() {
        log.info("Close the browser")
        ctx.quit()
    }
}
