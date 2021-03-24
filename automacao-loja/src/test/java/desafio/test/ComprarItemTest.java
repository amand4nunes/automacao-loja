package desafio.test;

import desafio.page.*;
import desafio.page.cadastroCliente.MinhaContaPage;
import desafio.page.compraDeItem.CardCheckoutPage;
import desafio.page.compraDeItem.DetalhesProdutoPage;
import desafio.page.compraDeItem.ResumoDoCarrinhodeCompraPage;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "detalhesCompra.csv")
public class ComprarItemTest {

    CadastroELoginPage cadastroELogin = new CadastroELoginPage();

    @Before
    public void before() throws InterruptedException {
        cadastroELogin.clicarEmEntrar();
        Thread.sleep(1000);
    }

    @After
    public void after() {
        cadastroELogin.fechar();
    }

    @Test
    public void adicionarItemAoCarrinhoEFinalizarCompra(
            @Param(name = "email") String email,
            @Param(name = "senha") String senha,
            @Param(name = "quantidade") String quantidade,
            @Param(name = "tamanho") String tamanho,
            @Param(name = "cor") String cor) throws InterruptedException {

        MinhaContaPage minhaConta = cadastroELogin.logar(email, senha);
        IndexPage home = minhaConta.irParaIndexPage();
        DetalhesProdutoPage detalheProduto = home.selecionarProduto();
        detalheProduto.selecionarQuantidade(quantidade);
        detalheProduto.selecionarTamanho(tamanho);
        detalheProduto.selecionarCor(cor);
        Thread.sleep(1000);
        CardCheckoutPage checkoutPage = detalheProduto.adicionarAoCarrinho();
        Thread.sleep(2000);
        ResumoDoCarrinhodeCompraPage resumoDeCompra = checkoutPage.proseguirCheckout();
        Thread.sleep(2000);
        resumoDeCompra.sumario();
        Thread.sleep(2000);
        resumoDeCompra.endereco();
        Thread.sleep(2000);
        resumoDeCompra.frete();
        Thread.sleep(2000);
        resumoDeCompra.pagamento();
        Assert.assertTrue(resumoDeCompra.buscarTextoNaPagina("Your order on My Store is complete."));


    }
}
