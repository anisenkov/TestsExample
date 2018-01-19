package pageobjects

import static com.codeborne.selenide.Selenide.$

/**
 * Created by aniae on 17.01.2018.
 */
public class ProfilePage extends Page {

    public String getPersonalInfoName()
    {
        return $(".personal-info-name").getText()
    }

}
