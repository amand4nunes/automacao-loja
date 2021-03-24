#language: pt
Funcionalidade: Cadastrar novo usuario

  Esquema do Cenário: Cadastrando de um novo usuario
    Dado um usuario digite um <email> valido que nao esteja cadastrado
    E preencha o formulario de cadastro com <genero>, <primeiroNome>, <sobreNome>, <email>, <senha>, <diaNascimento>, <mesNascimento>, <anoNascimento>
    E preencha dados de endereco com <primeiroNome>, <sobreNome>, <companhia>, <endereco>, <endereco2>, <cidade>, <estado>, <cep>, <pais>, <infoAdicionais>, <telefoneResidencial>, <telefoneCelular>, <enderecoAlternativos>
    Entao ele sera redirecionado para tela de minha pagina



    Exemplos:
      | genero | primeiroNome | sobreNome | email               | senha      | diaNascimento | mesNascimento | anoNascimento | companhia | endereco | endereco2 | cidade | estado | cep | pais | infoAdicionais | telefoneResidencial | telefoneCelular | enderecoAlternativos
      | mulher  |Maria        | Silva     | maria@email.com.br  | testeteste |  4            |               |               |           |          |           |        |        |     |      |                |                     |                 |


