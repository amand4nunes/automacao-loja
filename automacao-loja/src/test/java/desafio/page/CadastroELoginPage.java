package desafio.page;

import desafio.page.cadastroCliente.FormularioDeCadastroPage;
import desafio.page.cadastroCliente.MinhaContaPage;
import junit.framework.Assert;

import org.openqa.selenium.JavascriptExecutor;


public class CadastroELoginPage extends BasePage {

    private static final String URL_HOME = "http://automationpractice.com/index.php";
    private static final String URL_CADASTRO = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
    public CadastroELoginPage() {
        super(null);
        driver.manage().window().maximize();
        driver.navigate().to(URL_HOME);
    }

    public void clicarEmEntrar() throws InterruptedException {
       esperaCarregarTexto("Sign in").click();
    }

    public FormularioDeCadastroPage cadastrarNovoClienteParteEmail(String email) throws InterruptedException{
        JavascriptExecutor scroll = (JavascriptExecutor) driver;
        scroll.executeScript("window.scrollBy(0,400)");
        escrever("email_create", email);
        elemetoId("SubmitCreate").click();
        Thread.sleep(2000);
        return new FormularioDeCadastroPage(driver);
    }

    public MinhaContaPage logar(String email, String senha) throws InterruptedException {
    	Thread.sleep(1000);
    	JavascriptExecutor scroll = (JavascriptExecutor) driver;
        scroll.executeScript("window.scrollBy(0,500)");
        elemetoId("email").sendKeys(email);
        elemetoId("passwd").sendKeys(senha);
        elemetoId("SubmitLogin").click();
        return new MinhaContaPage(driver);
    }
    
    public boolean isCadastroLogin() {
    	return driver.getCurrentUrl().equals(URL_CADASTRO);
    }
    public String mensagemDeEmailJaCadastrado() {
    	return elemetoId("create_account_error").getText();
 	
    }
    

    
}
