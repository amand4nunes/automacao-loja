package desafio.test;

import desafio.page.*;
import desafio.page.cadastroCliente.FormularioDeCadastroPage;
import desafio.page.cadastroCliente.MinhaContaPage;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "CadastroDeCliente.csv")
public class CadastroDeClienteTest {

    CadastroELoginPage cadastroOuLogin = new CadastroELoginPage();

    @Before
    public void before() throws InterruptedException {
        cadastroOuLogin.clicarEmEntrar();
        Thread.sleep(1000);
    }

    @After
    public void after() {
        cadastroOuLogin.fechar();
    }

    @Test
    public void cadastrarCliente(@Param(name = "genero") String genero,
                                 @Param(name = "primeiroNome") String primeiroNome,
                                 @Param(name = "sobreNome") String sobreNome,
                                 @Param(name = "email") String email,
                                 @Param(name = "senha") String senha,
                                 @Param(name = "diaNascimento") String diaNascimento,
                                 @Param(name = "mesNascimento") String mesNascimento,
                                 @Param(name = "anoNascimento") String anoNascimento,
                                 @Param(name = "companhia") String companhia,
                                 @Param(name = "endereco") String endereco,
                                 @Param(name = "endereco2") String endereco2,
                                 @Param(name = "cidade") String cidade,
                                 @Param(name = "estado") String estado,
                                 @Param(name = "cep") String cep,
                                 @Param(name = "pais") String pais,
                                 @Param(name = "infoAdicionais") String infoAdicionais,
                                 @Param(name = "telefoneResidencial") String telefoneResidencial,
                                 @Param(name = "telefoneCelular") String telefoneCelular,
                                 @Param(name = "enderecoAlternativos") String enderecoAlternativos)

            throws InterruptedException {
        FormularioDeCadastroPage formularioDeCadastro = cadastroOuLogin.cadastrarNovoClienteParteEmail(email);
        Thread.sleep(2000);

        formularioDeCadastro
                .preencherDadosPessoais(genero, primeiroNome, sobreNome, email, senha, diaNascimento, mesNascimento, anoNascimento);

        MinhaContaPage minhaConta = formularioDeCadastro
                .preencherEndereco(primeiroNome, sobreNome, companhia, endereco, endereco2, cidade, estado, cep, pais, infoAdicionais, telefoneResidencial, telefoneCelular, enderecoAlternativos);
        Assert.assertTrue(minhaConta.isMinhaContaPage());
        Thread.sleep(1000);
        IndexPage home = minhaConta.irParaIndexPage();
        Assert.assertTrue(home.isIndexPage());

    }



}
