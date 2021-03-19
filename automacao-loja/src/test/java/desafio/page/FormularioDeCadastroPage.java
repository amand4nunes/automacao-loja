package desafio.page;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FormularioDeCadastroPage extends BasePage {
    private static final String URL_FORMULARIO_DE_CADASTRO = "http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation";

    public FormularioDeCadastroPage(WebDriver driver) {
        super(driver);
    }

    public boolean isFormularioDeCadastro() {
        return (driver.getCurrentUrl().equals(URL_FORMULARIO_DE_CADASTRO));
    }

    public void preencherDadosPessoais(String genero, String primeiroNome, String sobreNome, String email, String senha,
                                       String diaNascimento, String mesNascimento, String anoNascimento) throws InterruptedException {
        if (genero == "homem") {
            WebElement homem = elemetoId("id_gender1");
            homem.click();
        }
        if (genero == "mulher") {
            WebElement mulher = elemetoId("id_gender2");
            mulher.click();
        }
        escrever("customer_firstname", primeiroNome);
        escrever("customer_lastname", sobreNome);
        escrever("passwd", senha);
        selectValue("days", diaNascimento);
        Thread.sleep(1000);
        selectText("months", mesNascimento+" ");
        selectText("years", anoNascimento+"  ");

    }

    public MinhaContaPage preencherEndereco(String nome, String sobreNome, String companhia, String endereco, String endereco2,
                                            String cidade, String estado, String cep, String pais, String infoAdicionais,
                                            String telefoneResidencial, String telefoneCelular, String enderecoAlternativos) {

        escrever("firstname", nome);
        escrever("lastname", sobreNome);
        escrever("company", companhia);
        escrever("address1", endereco);
        escrever("address2", endereco2);
        escrever("city", cidade);
        selectText("id_state", estado);
        escrever("postcode", cep);
        selectText("id_country", pais);
        escrever("other", infoAdicionais);
        escrever("phone", telefoneResidencial);
        escrever("phone_mobile", telefoneCelular);
        elemetoId("alias").clear();
        escrever("alias", enderecoAlternativos);

        elemetoId("submitAccount").click();

        return new MinhaContaPage(driver);
    }

}
