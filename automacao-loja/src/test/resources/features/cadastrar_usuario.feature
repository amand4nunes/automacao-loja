#language: pt
@cadastro
Funcionalidade: Cadastrar novo usuario

  Esquema do Cenario: Cadastrando de um novo usuario
    Dado que o usuario esteja na index e clique em entrar
    Entao ele sera redirecionado para tela de login e cadastro
    Quando um usuario digitar um <email> valido que nao esteja cadastrado ele sera redirecionado para o formulario de cadastro
    Quando o usuario preencher o formulario de cadastro com <genero>, <primeiroNome>, <sobreNome>, <email>, <senha>, <diaNascimento>, <mesNascimento>, <anoNascimento>
    E preencher os dados de endereco com <primeiroNome>, <sobreNome>, <companhia>, <endereco>, <endereco2>, <cidade>, <estado>, <cep>, <pais>, <infoAdicionais>, <telefoneResidencial>, <telefoneCelular>, <enderecoAlternativos>
    Entao ele sera redirecionado para tela de minha pagina
    E ao clicar no logo retorna para a index
    
   Esquema do Cenario: Cadastrando de um novo usuario com email ja cadastrado
    Dado que o usuario esteja na index e clique em entrar
    Entao ele sera redirecionado para tela de login e cadastro
    Quando um usuario digitar um <email> invalido que ja esta cadastrado
    Entao ele recebera uma menssagem de erro



    Exemplos:
      | genero 	 | primeiroNome | sobreNome | email               		| senha      | diaNascimento | mesNascimento | anoNascimento | companhia | endereco 								  	| endereco2 | cidade | estado | cep | pais 				| infoAdicionais | telefoneResidencial | telefoneCelular | enderecoAlternativos				 |
			|"mulher"	 |"ivana"				|"silva"		|"email2503v1@email.com"|"amarelo04" |"8"						 |"December"		 |"1998"	 |"empresa"	 |"Av. José Barbosa de Siqueira"|"n 000"			|"osasco"	 |"Florida"	|"00000"|"United States"|"infoAdicionais"	 |"40028922"						 |"11970207070"			 |"Av. Josão Barbosa de Siqueira"|

