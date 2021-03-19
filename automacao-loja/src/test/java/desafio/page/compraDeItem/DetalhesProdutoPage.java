package desafio.page.compraDeItem;

import desafio.page.BasePage;
import desafio.page.compraDeItem.CardCheckoutPage;
import org.openqa.selenium.WebDriver;

public class DetalhesProdutoPage extends BasePage {
    public DetalhesProdutoPage(WebDriver driver) {
        super(driver);
    }

    public void selecionarQuantidade(String quantidade) {
        elemetoId("quantity_wanted").clear();
        escrever("quantity_wanted", quantidade);
    }

    public void selecionarTamanho(String tamanho) {
        escrever("group_1", tamanho);
    }

    public void selecionarCor(String cor) {

        if (cor == "White") {
            elemetoId("color_8").click();
        } else if (cor == "Black") {
            elemetoId("color_11").click();
        }

    }

    public CardCheckoutPage adicionarAoCarrinho() {
        elemetoId("add_to_cart").click();
        return new CardCheckoutPage(driver);
    }
}
