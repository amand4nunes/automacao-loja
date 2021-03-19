package desafio.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IndexPage extends BasePage{
    private static final String URL_INDEX = "http://automationpractice.com/index.php";

    public IndexPage(WebDriver driver) {
        super(driver);
    }


    public boolean  isIndexPage(){
        return driver.getCurrentUrl().equals(URL_INDEX);
    }

public DetalhesProdutoPage selecionarProduto() {
        elementoExpath("//*[@id=\"homefeatured\"]/li[2]/div/div[2]/h5/a").click();
       return new DetalhesProdutoPage(driver);
    }
}
