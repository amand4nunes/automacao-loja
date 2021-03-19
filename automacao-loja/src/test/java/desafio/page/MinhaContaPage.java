package desafio.page;

import org.openqa.selenium.WebDriver;

public class MinhaContaPage extends PageObject{
    private static final String URL_MY_ACCOUNT = "http://automationpractice.com/index.php?controller=my-account";
    public MinhaContaPage(WebDriver driver) {
        super(driver);
    }


    public boolean isMinhaContaPage() {
        return driver.getCurrentUrl().equals(URL_MY_ACCOUNT);
    }

}
