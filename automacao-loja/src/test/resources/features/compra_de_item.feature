#language: pt

Funcionalidade: Efetuar compra de item na loja
  Cenario: Usuario já cadastrato efetua compra de item e realiza pagamento
    Dado que o usuaio digite efetue o login com o <email> e <senha>
    E escolha o produto
    E escolha a <quantidade>, <tamanho> e <cor>
    E veja o resumo dacompra
    E valide o endereco
    E escolha a forma de entrega
    E escolha a forma de pagamento
    Entao apos confirmar o pagamento deve conter o <texto>


    Exemplos:
    |email|senha|quantidade|tamanho|cor|
    |     |     |           |       |   |