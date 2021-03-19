package desafio.page;

import org.openqa.selenium.WebDriver;

public class CardCheckoutPage extends BasePage{
    public CardCheckoutPage(WebDriver driver) {
        super(driver);
    }

    public ResumoDoCarrinhodeCompraPage proseguirCheckout(){
        elementoExpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a").click();
        return new ResumoDoCarrinhodeCompraPage(driver);
    }
}
