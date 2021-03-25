package acceptance.steps;

import org.junit.Assert;

import desafio.page.CadastroELoginPage;
import desafio.page.IndexPage;
import desafio.page.cadastroCliente.FormularioDeCadastroPage;
import desafio.page.cadastroCliente.MinhaContaPage;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class CriandoNovoUsuarioSteps {
	
	  CadastroELoginPage cadastroOuLogin = new CadastroELoginPage();
	  FormularioDeCadastroPage formularioDeCadastro;
	  MinhaContaPage minhaConta;
	  
@Dado("que o usuario esteja na index e clique em entrar")
public void que_o_usuario_esteja_na_index_e_clique_em_entrar() throws InterruptedException {
	cadastroOuLogin.clicarEmEntrar();
  
}


@Entao("ele sera redirecionado para tela de login e cadastro")
public void ele_sera_redirecionado_para_tela_de_login_e_cadastro() {
   Assert.assertTrue(cadastroOuLogin.isCadastroLogin());
}
@Quando("um usuario digitar um {string} valido que nao esteja cadastrado ele sera redirecionado para o formulario de cadastro")
public void um_usuario_digitar_um_email_valido_que_nao_esteja_cadastrado_ele_sera_redirecionado_para_o_formulario_de_cadastro(String email) throws InterruptedException {
	formularioDeCadastro = cadastroOuLogin.cadastrarNovoClienteParteEmail(email);
}

@Quando("o usuario preencher o formulario de cadastro com {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
public void o_usuario_preencher_o_formulario_de_cadastro_com(String genero,String primeiroNome,String sobreNome, String email, String senha, String diaNascimento, String mesNascimento, String anoNascimento ) throws InterruptedException{
	formularioDeCadastro
    .preencherDadosPessoais(genero, primeiroNome, sobreNome, email, senha, diaNascimento, mesNascimento, anoNascimento);
}

@Quando("preencher os dados de endereco com {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
public void preencher_os_dados_de_endereco_com(
		String primeiroNome,
		String sobreNome,
		String companhia,
		String endereco,
		String endereco2,
		String cidade,
		String estado,
		String cep,
		String pais,
		String infoAdicionais,
		String telefoneResidencial,
		String telefoneCelular,
		String enderecoAlternativos) {
  minhaConta = formularioDeCadastro
              .preencherEndereco(primeiroNome, sobreNome, companhia, endereco, endereco2, cidade, estado, cep, pais, infoAdicionais, telefoneResidencial, telefoneCelular, enderecoAlternativos);
}

@Entao("ele sera redirecionado para tela de minha pagina")
public void ele_sera_redirecionado_para_tela_de_minha_pagina() {
   Assert.assertTrue(minhaConta.isMinhaContaPage());
   
}

@Entao("ao clicar no logo retorna para a index")
public void ao_clicar_no_logo_retorna_para_a_index () {
	 IndexPage home = minhaConta.irParaIndexPage();
     Assert.assertTrue(home.isIndexPage());
     home.fechar();
}

@Quando("um usuario digitar um {string} invalido que ja esta cadastrado")
public void um_usuario_digitar_um_email_invalido_que_ja_esta_cadastrado(String email) throws InterruptedException {
	cadastroOuLogin.cadastrarNovoClienteParteEmail(email);
}

@Entao("ele recebera uma menssagem de erro")
public void ele_revebera_uma_menssagem_de_erro () {
	String msg = "An account using this email address has already been registered. Please enter a valid password or request a new one. ";
	Assert.assertEquals(msg,cadastroOuLogin.mensagemDeEmailJaCadastrado());
	cadastroOuLogin.fechar();
}

}
