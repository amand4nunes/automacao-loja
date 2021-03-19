package desafio.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CadastroELoginPage extends BasePage {

    private static final String URL_HOME = "http://automationpractice.com/index.php";
    public CadastroELoginPage() {
        super(null);
        driver.manage().window().maximize();
        driver.navigate().to(URL_HOME);
    }

    public void clicarEmEntrar() {
        elementoText("Sign in").click();
    }

    public FormularioDeCadastroPage cadastrarNovoClienteParteEmail(String email){
        JavascriptExecutor scroll = (JavascriptExecutor) driver;
        scroll.executeScript("window.scrollBy(0,400)");
        escrever("email_create", email);
        elemetoId("SubmitCreate").click();
        return new FormularioDeCadastroPage(driver);
    }

    public MinhaContaPage logar(String email, String senha) {
        JavascriptExecutor scroll = (JavascriptExecutor) driver;
        scroll.executeScript("window.scrollBy(0,400)");
        elemetoId("email").sendKeys(email);
        elemetoId("passwd").sendKeys(senha);
        elemetoId("SubmitLogin").click();
        return new MinhaContaPage(driver);
    }
}
