package page;

import org.openqa.selenium.By;

import core.DSL;

public class ShopcartPage {

	private DSL dsl;

	public ShopcartPage() {
		dsl = new DSL();
	}

	public void aguardarTelaInicial() throws Exception {
		dsl.esperarElemento(By.xpath("//*[@id='open-categories-btn']"));
	}

	public void setCategoria(String categoria) throws Exception {
		dsl.selecionarCombos("//*[@id='open-categories-btn']//img", "//ul[@class='sc-eNQAEJ bBoBAk']/li", categoria);
	}

	public void setItensLista() {
		dsl.selecionarItensLista("//*[contains(@id,'add-product')]");
	}

	public void esperarElementNaoVisivel() throws Exception {
		dsl.esperarElementoNotInvisible(By.xpath(
				"//*[@class='Toastify__toast-container Toastify__toast-container--bottom-right']//*[contains(text(), 'O produto')]"));
	}

	public void clicarCarrinho() {
		dsl.clicarBotao("cart-btn");
	}

	public void esperarTelaCarrinho() throws Exception {
		dsl.esperarElemento("finish-checkout-button");
	}

	public void botaoAdicionarBrigadeiro() {
		dsl.clicarBotao("add-product-4-qtd");
	}

	public void botaoRemoverrBrigadeiro() {
		dsl.clicarBotao("remove-product-4-qtd");
	}

	public void botaoAdicionarRissole() {
		dsl.clicarBotao("add-product-3-qtd");
	}

	public void botaoRemoverRissole() {
		dsl.clicarBotao("remove-product-3-qtd");
	}

	public void clicarBotaoFinalizarCompra() {
		dsl.clicarBotao("finish-checkout-button");
	}

	public void esperarFinalizacao() throws Exception {
		dsl.esperarElemento(By.xpath("//*[.='Pedido realizado com sucesso!']"));
	}

	public void assertMensagem(String mensagem) throws Exception {
		dsl.assertEquals(mensagem, "//*[.='Pedido realizado com sucesso!']");
	}

	public void clicarbotaoFechar() {
		dsl.clicarBotaoXpath("//button[.='Fechar']");
	}

	public void esperarProduto() throws Exception {
		dsl.esperarElemento("add-product-3-btn");
	}

	public void SetEsperaFixa(int tempoMS) throws Exception {
		dsl.esperaFixa(tempoMS);
	}

	public void clicarbotaoRissole() {
		dsl.clicarBotaoXpath("//button[@id='add-product-3-btn']");
	}

	public void assertQuantidadeRissole(String quantidade) throws Exception {
		dsl.assertEquals(quantidade, "//*[@id='product-3-qtd']");
	}

	
	public void mostrarTotal() throws Exception {
		System.out.println(dsl.obterTexto(By.xpath("//*[@id='price-total-checkout']")));
	}

	public void assertValorTotal(String total) throws Exception {
		dsl.assertEquals(total, "//*[@id='price-total-checkout']/..//p[contains(.,'R$ 36,00')]");
	}

	public int contarAlertItemADD() {

		return dsl.contarArlert(
				"//*[@class='Toastify__toast-container Toastify__toast-container--bottom-right']/..//*[@class='Toastify__close-button Toastify__close-button--success']");

	}

	public void aguardarAlertAddProduto() {

		for (int i = 0; i < contarAlertItemADD(); i++) {
			if (contarAlertItemADD() > 0) {
				i = 0;
			}
		}
	}

}
