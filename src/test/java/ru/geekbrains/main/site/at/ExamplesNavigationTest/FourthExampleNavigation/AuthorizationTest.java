package ru.geekbrains.main.site.at.ExamplesNavigationTest.FourthExampleNavigation;

import org.junit.jupiter.api.Test;
import ru.geekbrain.main.site.at.FourtExample.AuthorizationPage;
import ru.geekbrains.main.site.at.Base.Base;

public class AuthorizationTest extends Base {
    @Test
    void checkValidAuthorization() {
        driver.get("https://geekbrains.ru/");
        AuthorizationPage authorizationPage = new AuthorizationPage();
        authorizationPage.login("login","password")
                 .checkNamePage("Главная");
    }

}

