package desafio.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PageObject {
    protected WebDriver driver;

    public PageObject(WebDriver driver) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        if (driver == null) {
            this.driver = new ChromeDriver();
        } else {
            this.driver = driver;
        }
    }

    public void fechar() {
        this.driver.quit();
    }

    public IndexPage irParaIndexPage() {

        driver.findElement(By.id("header_logo")).click();
        driver.navigate().to("http://automationpractice.com/index.php");
        return new IndexPage(driver);
    }
}
