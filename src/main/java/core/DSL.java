package core;

import static core.DriverFactory.getDriver;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DSL {

	public static String timestamp() {
		return new SimpleDateFormat("dd-MM-yyyy HH_mm_ss").format(new Date());
	}

	public void esperarElemento(By by) throws Exception {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}

	public void selecionarCombos(String pathCombo, String pathLista, String valor) throws Exception {
		clicarRadio(By.xpath(pathCombo));
		Thread.sleep(2000);
		List<WebElement> listOfElements = getDriver().findElements(By.xpath(pathLista));
		for (WebElement webElement : listOfElements) {
			if (webElement.getText().trim().equals(valor)) {
				webElement.click();
				break;
			}
		}
		Thread.sleep(1000);
	}

	public void selecionarItensLista(String path) {

		List<WebElement> listOfElements = getDriver().findElements(By.xpath(path));
		for (WebElement webElement : listOfElements) {
			webElement.click();
		}
	}

	public void clicarBotao(String id) {
		getDriver().findElement(By.id(id)).click();
	}

	public void clicarBotaoXpath(String path) {
		getDriver().findElement(By.xpath(path)).click();

	}

	public void esperaFixa(int valor) throws Exception {
		Thread.sleep(valor);
	}

	public String obterTexto(By by) throws Exception {
		return getDriver().findElement(by).getText();
	}

	public String obterTexto(String id) throws Exception {
		return obterTexto(By.id(id));
	}

	public void clicarLink(String link) throws Exception {
		getDriver().findElement(By.linkText(link)).click();
	}

	public void clicarRadio(By by) throws Exception {
		getDriver().findElement(by).click();
	}

	public void clicarRadio(String id) throws Exception {
		clicarRadio(By.id(id));
	}

	public void esperarBotaoClicavel(String id) throws Exception {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
	}

	public void esperarElemento(String id_campo) throws Exception {
		esperarElemento(By.id(id_campo));
	}

	public void esperarTexto(String path_msg, String texto) {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBe(By.xpath(path_msg), texto));
	}

	public void esperarElementoNotInvisible(By by) throws Exception {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated((by)));
	}

	public void esperarElementoNotInvisible(String id_campo) throws Exception {
		esperarElementoNotInvisible(By.id(id_campo));
	}

	public void assertEquals(String texto, String path) throws Exception {
		Assert.assertEquals(texto, obterTexto(By.xpath(path)));
	}

	public int contarArlert(String path) {

		List<WebElement> alert = getDriver().findElements(By.xpath(path));
		return alert.size();

	}
	
	

}
