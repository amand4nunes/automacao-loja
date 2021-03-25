#language: pt

Funcionalidade: Efetuar compra de item na loja
@compra
  Esquema do Cenario: Usuario ja cadastrato efetua compra de item e realiza pagamento
    Dado que o usuario esteja na tela de login e efetue o login com o <email> e <senha>
    Entao ele sera redirecionado para a pagina pessoal
    Quando o usuario for para a pagina index e escolher o produto
    E informar a <quantidade>, <tamanho>, <cor> e adicionar ao carrinho de compra
    E ver o resumo da compra
    E validar o endereco
    E escolher a forma de entrega
    E escolher a forma de pagamento
    Entao apos confirmar o pagamento deve conter a confirmacao da compra


    Exemplos:
    |email									|senha				|quantidade		|tamanho|cor		 |
    |"email2503v1@email.com"|"amarelo04"  |"2"          |"L"    |"black" |