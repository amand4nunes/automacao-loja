package desafio.page.compraDeItem;

import desafio.page.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ResumoDoCarrinhodeCompraPage extends BasePage {
    public ResumoDoCarrinhodeCompraPage(WebDriver driver) {
        super(driver);
    }

    public void sumario(){
        JavascriptExecutor scroll = (JavascriptExecutor) driver;
        scroll.executeScript("window.scrollBy(0,1000)");
        esperaCarregar("//*[@id=\"center_column\"]/p[2]/a[1]").click();
    }
    public void endereco(){
        JavascriptExecutor scroll = (JavascriptExecutor) driver;
        scroll.executeScript("window.scrollBy(0,1000)");
        esperaCarregarName("processAddress").click();
        //elementoExpath("//*[@id=\"center_column\"]/form/p/button/span/text()").click();
    }
    public void frete(){
        JavascriptExecutor scroll = (JavascriptExecutor) driver;
        scroll.executeScript("window.scrollBy(0,1000)");
        elemetoId("cgv").click();
        esperaCarregarName("processCarrier").click();
    }
    public void pagamento(){
    	esperaCarregar("//*[@id=\"HOOK_PAYMENT\"]/div[1]/div").click();
    	esperaCarregar("//*[@id=\"cart_navigation\"]/button").click();
    }

}
