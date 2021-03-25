package acceptance.steps;

import java.util.ArrayList;

import org.junit.Assert;


import desafio.page.CadastroELoginPage;
import desafio.page.IndexPage;
import desafio.page.cadastroCliente.MinhaContaPage;
import desafio.page.compraDeItem.CardCheckoutPage;
import desafio.page.compraDeItem.DetalhesProdutoPage;
import desafio.page.compraDeItem.ResumoDoCarrinhodeCompraPage;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class EfetuandoCompraSteps {
	CadastroELoginPage cadastroOuLogin = new CadastroELoginPage();
	MinhaContaPage minhaConta;
	IndexPage home;
	DetalhesProdutoPage detalheProduto;
	CardCheckoutPage checkoutPage;
	ResumoDoCarrinhodeCompraPage resumoDeCompra;
	
@Dado("que o usuario esteja na tela de login e efetue o login com o {string} e {string}")
public void que_o_usuario_esteja_na_tela_de_login_e_efetue_o_login_com_o_e(String email, String senha) throws InterruptedException {
	cadastroOuLogin.clicarEmEntrar();
	minhaConta = cadastroOuLogin.logar(email, senha); 
}

@Entao("ele sera redirecionado para a pagina pessoal")
public void ele_sera_redirecionado_para_a_pagina_pessoal() {
  Assert.assertTrue(minhaConta.isMinhaContaPage());
}
@Quando("o usuario for para a pagina index e escolher o produto")
public void o_usuario_for_para_a_pagina_index_e_escolher_o_produto() {
   home = minhaConta.irParaIndexPage();
   detalheProduto = home.selecionarProduto();
   
}
@Quando("informar a {string}, {string}, {string} e adicionar ao carrinho de compra")
public void informar_a_e_adicionar_ao_carrinho_de_compra(String quantidade, String tamanho, String cor) throws InterruptedException {
	detalheProduto.selecionarQuantidade(quantidade);
    detalheProduto.selecionarTamanho(tamanho);
    detalheProduto.selecionarCor(cor);
    checkoutPage = detalheProduto.adicionarAoCarrinho();
    resumoDeCompra =  checkoutPage.proseguirCheckout();
}
@Quando("ver o resumo da compra")
public void ver_o_resumo_dacompra() {
	resumoDeCompra.sumario();
}
@Quando("validar o endereco")
public void validar_o_endereco() {
	 resumoDeCompra.endereco();
}
@Quando("escolher a forma de entrega")
public void escolher_a_forma_de_entrega() {
	resumoDeCompra.frete();
}
@Quando("escolher a forma de pagamento")
public void escolher_a_forma_de_pagamento() {
	resumoDeCompra.pagamento();;
}
@Entao("apos confirmar o pagamento deve conter a confirmacao da compra")
public void apos_confirmar_o_pagamento_deve_conter_a_confirma_o_da_compra() {
	 Assert.assertTrue(resumoDeCompra.buscarTextoNaPagina("Your order on My Store is complete."));
	 resumoDeCompra.fechar();
}


}
