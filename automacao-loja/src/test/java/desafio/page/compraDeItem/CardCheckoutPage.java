package desafio.page.compraDeItem;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import desafio.page.BasePage;

public class CardCheckoutPage extends BasePage {
    public CardCheckoutPage(WebDriver driver) {
        super(driver);
    }

    public ResumoDoCarrinhodeCompraPage proseguirCheckout() throws InterruptedException{
       esperaCarregar("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a").click();
        return new ResumoDoCarrinhodeCompraPage(driver);
    }
    
}
