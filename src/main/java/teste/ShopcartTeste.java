package teste;

import static core.DriverFactory.getDriver;
import static core.DriverFactory.killDriver;

import java.io.File;
import java.io.IOException;
//import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import core.DSL;
import page.ShopcartPage;

public class ShopcartTeste {

	private ShopcartPage pageShopcart;

	@Before
	public void inicializa() {
		getDriver().get("https://shopcart-challenge.4all.com/");
		pageShopcart = new ShopcartPage();
	}

	@After
	public void finalizar() throws IOException {
		TakesScreenshot ts = (TakesScreenshot) getDriver();
		File arquivo = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File("." + File.separator + "ScreenShots" + File.separator
				+ testName.getMethodName() + "_" + DSL.timestamp() + ".png"));

		killDriver();
	}

	@Rule
	public TestName testName = new TestName();

	@Test
	public void desafio1() throws Exception {
		pageShopcart.aguardarTelaInicial();
		pageShopcart.setCategoria("Doces");
		pageShopcart.setItensLista();
		pageShopcart.aguardarAlertAddProduto();
		pageShopcart.setCategoria("Todos");
		pageShopcart.clicarCarrinho();
		pageShopcart.esperarTelaCarrinho();
		int adicionarItem = 4;
		for (int i = 0; i < adicionarItem; i++) {
			pageShopcart.botaoAdicionarBrigadeiro();
		}
		pageShopcart.clicarBotaoFinalizarCompra();
		pageShopcart.esperarFinalizacao();
		pageShopcart.assertMensagem("Pedido realizado com sucesso!");
		pageShopcart.clicarbotaoFechar();
	}

	@Test
	public void desafio2() throws Exception {
		pageShopcart.aguardarTelaInicial();
		pageShopcart.setCategoria("Bebidas");
		pageShopcart.setItensLista();
		pageShopcart.aguardarAlertAddProduto();
		pageShopcart.setCategoria("Todos");
		pageShopcart.clicarbotaoRissole();
		pageShopcart.aguardarAlertAddProduto();
		pageShopcart.clicarCarrinho();
		pageShopcart.esperarTelaCarrinho();
		int adicionarItem = 9;
		for (int i = 0; i < adicionarItem; i++) {
			pageShopcart.botaoAdicionarRissole();
		}
		pageShopcart.assertQuantidadeRissole("10");
		int removerItem = 5;
		for (int i = 0; i < removerItem; i++) {
			pageShopcart.botaoRemoverRissole();
		}
		pageShopcart.assertQuantidadeRissole("5");
		pageShopcart.assertValorTotal("R$ 36,00");
		pageShopcart.clicarBotaoFinalizarCompra();
		pageShopcart.esperarFinalizacao();
		pageShopcart.assertMensagem("Pedido realizado com sucesso!");
		pageShopcart.clicarbotaoFechar();
	}

}
