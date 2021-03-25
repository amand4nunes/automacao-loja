package desafio.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends PageObject{
    public BasePage(WebDriver driver) {
        super(driver);
    }

    public WebElement elemetoId(String id){
      return  driver.findElement(By.id(id));
    }
    public WebElement elementoExpath(String xpath){
        return driver.findElement(By.xpath(xpath));
    }
    public WebElement elementName(String name){
        return driver.findElement(By.name(name));
    }
    public WebElement elementoText(String texto){
      return  driver.findElement(By.linkText(texto));
    }
    public void escrever(String id, String texto){
        driver.findElement(By.id(id)).sendKeys(texto);
    }
    public void selectValue(String id,String valor){
        Select select = new Select(driver.findElement(By.id(id)));
        select.selectByValue(valor);
    }
    public void selectText(String id,String texto){
        Select select = new Select(driver.findElement(By.id(id)));
        select.selectByVisibleText(texto);
    }
    public void submit(String id){
        driver.findElement(By.id(id)).submit();
    }

    public boolean buscarTextoNaPagina(String texto){
       return driver.getPageSource().contains(texto);
    }
    
    public WebElement esperaCarregar(String xpath) {
		WebDriverWait wait = new WebDriverWait(driver,5);
		WebElement elemeto = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		return elemeto;
	}
    public WebElement esperaCarregarTexto(String texto) {
		WebDriverWait wait = new WebDriverWait(driver,5);
		WebElement elemeto = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(texto)));
		return elemeto;
	}
    public WebElement esperaCarregarId(String id) {
		WebDriverWait wait = new WebDriverWait(driver,5);
		WebElement elemeto = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
		return elemeto;
	}
    public WebElement esperaCarregarName(String name) {
		WebDriverWait wait = new WebDriverWait(driver,5);
		WebElement elemeto = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(name)));
		return elemeto;
	}
    

}
