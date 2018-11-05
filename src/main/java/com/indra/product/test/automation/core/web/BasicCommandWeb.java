package com.indra.product.test.automation.core.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.indra.product.test.automation.core.exception.CommandException;
// import com.indra.product.test.automation.core.promise.WebDriver;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Paulo Lobo Neto
 * @param <WebDriver>
 * @Descricao Classe responsável por conter comandos que executam interações com
 *            a página da web. Os métodos contidos na classe são todos públicos
 *            e para utilizá-la, é necessário passar o WebDriver como parâmetro
 */
/// - annotation:
///		logo:
/// 	title: BasicCommandWeb (classe)
/// 	text_description:
/// 		- Classe responsável por por conter comandos que executam interações em páginas web. 
///			- Os métodos contidos na classe são todos públicos e para utiliza-los, não é necessário passar o WebDriver como parametro.
public class BasicCommandWeb {

	private static Logger log = Logger.getLogger(BasicCommandWeb.class.getName());
	private static final String VALUE = "value";
	private static final String SCREENSHOT_REPORT = "./evidences/screenshot/";
	protected WebDriver driver;
	private JavascriptExecutor executor;

	/**
	 * @Descricao Método construtor, define que sempre que a classe for instanciada,
	 *            é necessário passar o driver como parâmetro
	 * @param WebDriver
	 */
	/// - annotation:
	/// 	title: BasicCommandWeb (construtor)
	/// 	text_description:
	/// 		- Método construtor da classe.
	/// 	parameters:
	///			- WebDriver: driver
	/// 	ex:
	/// 		- java: BasicCommandWeb comBasico = new BasicCommandWeb(driver);
	/// 	return: 
	///			- void: método não tem retorno.
	public BasicCommandWeb(WebDriver driver) {
		this.driver = driver;
		this.executor = (JavascriptExecutor) driver;
	}

	public void captura(String string) {
		File shot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destino = new File(SCREENSHOT_REPORT + string + ".png");
		try {
			FileUtils.copyFile(shot, destino);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @Descricao Mudar de aba do navegador
	 * @param indiceAba
	 *            da aba. Ex.: 0, 1, 2 ...
	 */
	/// - annotation:
	/// 	title: mudarAba
	/// 	text_description:
	/// 		- Método resposanvel por mudar a aba atual do navegador recebe um <code>**int**</code> como parâmetro, as abas são lidas em um array dessa forma, são zero indexadas, ou seja, 
	///			- os números passados como parâmetros vão de 0 à quantidade de abas abertas no momento menos 1.
	/// 	parameters:
	/// 		- int: indiceAba
	/// 	ex:
	/// 		- java: BasicCommandWeb comBasico = new BasicCommandWeb(driver);
	///			- java: comBasico.mudarAba(0);
	/// 	return: 
	/// 		- void: método não tem retorno.
	public void mudarAba(int indiceAba) {
		driver.switchTo().window((String) driver.getWindowHandles().toArray()[indiceAba]);
		// driver.getDriver().switchTo().window((String)
		// driver.getDriver().getWindowHandles().toArray()[numero]);
	}

	/**
	 * @Descricao Trocar de Janela
	 * @param seletorElemento
	 */
	/// - annotation:
	/// 	title: trocarJanela
	/// 	text_description:
	/// 		- Método responsável trocar a janela ativa do navegador que recebe uma <code>**String**</code> como parâmetro, 
	/// 		- as janelas são lidas em um array dessa forma, são zero indexadas, ou seja, 
	///			- os números passados vão de 0 à quantidade de janelas abertas no momento menos 1.
	/// 	parameters:
	/// 		- String: seletorElemento
	/// 	ex:
	/// 		- java: BasicCommandWeb comBasico = new BasicCommandWeb(driver);
	/// 		- java: comBasico.trocarJanela("elemento");
	/// 	return:	
	///			- void: método não tem retorno.
	public void trocarJanela(String seletorElemento) {
		try {
			driver.switchTo().window(seletorElemento);
			// driver.getDriver().switchTo().window(elemento);
		} catch (NoSuchElementException | TimeoutException | ElementNotVisibleException e) {

		}
	}

	public static int getRandomValue() {
		return new Random().nextInt(10000);
	}

	// public WebElement encontra(String name) throws CommandException {
	// WebElement elemento = null;
	// try {
	// driver.then(name).thenAccept(data -> {
	// // log.info("Your total price is: {} ", (price + shippingPrice));
	// return data;
	// System.out.println("Your total price is: $" + data);
	// }).get();
	// // CompletableFuture<WebElement> promise =
	// // CompletableFuture.supplyAsync(find(name))
	// // .thenAccept(el -> {
	// // System.out.println("Your total price is: " + el.getText());
	// // });
	// return elemento;
	// } catch (InterruptedException e) {
	// throw new CommandException(e.getMessage());
	// }

	// // return promise.get();
	// }

	/**
	 * @Descricao Procurar um elemento específico na página. Para utiliza-lo é
	 *            necessário informar um localizador (id, className, cssSelector,
	 *            Xpath, etc) afim de identificá-lo na página.
	 * @param elemento
	 */
	/// - annotation:
	/// 	title: encontra
	/// 	text_description:
	/// 		- Método responsável por encontrar um elemento no navegador,
	/// 		- o método recebe uma <code>**String**</code> como parâmetro e busca o elementro através dos seguintes seletores 
	/// 		- <code>**id**</code>, <code>**name**</code>, <code>**tagName**</code>, <code>**cssSelector**</code>, <code>**linkText**</code>, 
	///         - <code>**partialLinkText**</code>, <code>**xpath**</code>.
	/// 	parameters:
	/// 		- String: seletorElemento
	/// 	ex:
	/// 		- java: BasicCommandWeb comBasico = new BasicCommandWeb(driver);
	/// 		- java: comBasico.encontra("elemento");
	/// 	return:	
	///			- WebElement: método retorna o elemento buscado, caso o mesmo exista na página.
	public WebElement encontra(String name) {
		WebElement elemento = null;

		try {
			elemento = driver.findElement(By.id(name));
		} catch (Exception e) {

		}
		try {
			elemento = driver.findElement(By.name(name));
		} catch (Exception e) {

		}
		try {
			elemento = driver.findElement(By.tagName(name));
		} catch (Exception e) {

		}
		try {
			elemento = driver.findElement(By.linkText(name));
		} catch (Exception e) {

		}
		try {
			elemento = driver.findElement(By.partialLinkText(name));
		} catch (Exception e) {

		}
		try {
			elemento = driver.findElement(By.xpath(name));
		} catch (Exception e) {

		}
		try {
			elemento = driver.findElement(By.className(name));
		} catch (Exception e) {
		}
		borda(elemento);
		return elemento;
	}

	/// - annotation:
	/// 	title: borda
	/// 	text_description:
	/// 		- Método responsável por localizar um elemento no navegador e destacar 
	///			- o mesmo com um borda vermelha para exibir qual fluxo ou ação está sendo realizado, 
	///			- recebe um <code>**WebElement**</code> como parâmetro.
	/// 	parameters:
	/// 		- WebElement: elemento
	/// 	ex:
	/// 		- java: BasicCommandWeb comBasico = new BasicCommandWeb(driver);
	/// 		- java: WebElement menuLink = comBasico.findElement(By.id("menu-link"));
	/// 		- java: comBasico.borda(menuLink);
	/// 	return:	
	///			- void: método não tem retorno.
	public void borda(WebElement elemento) {
		if (elemento != null) {
			executor.executeScript("arguments[0].style.border = 'medium solid red';", elemento);
		}
	}

	/// - annotation:
	/// 	title: elementoExiste
	/// 	text_description:
	/// 		- Método responsável por validar se um elemento existe no *DOM* (Document Object Model), 
	///			- recebe uma <code>**String**</code> 
	/// 		- como parâmetro que é o seletor do elemento.
	/// 	parameters:
	///			- String: seletorElemento
	/// 	ex:
	/// 		- java: BasicCommandWeb comBasico = new BasicCommandWeb(driver);
	/// 		- java: comBasico.elementoExiste("menu-link");
	/// 	return: 
	///			- void: método não tem retorno.
	public void elementoExiste(String seletorElemento) {
		assertEquals(true, encontra(seletorElemento).isDisplayed());
	}

	/// - annotation:
	/// 	title: elementoEstaHabilitado
	/// 	text_description:
	/// 		- Método responsável por validar se um elemento está habilitado, 
	///			- recebe uma <code>**String**</code> 
	/// 		- como parâmetro que é o seletor do elemento.
	/// 	parameters:
	///			- String: seletorElemento
	/// 	ex:
	/// 		- java: BasicCommandWeb comBasico = new BasicCommandWeb(driver);
	/// 		- java: comBasico.elementoEstaHabilitado("menu-link");
	/// 	return: 
	///			- void: método não tem retorno.
	public void elementoEstaHabilitado(String seletorElemento) {
		assertEquals(true, encontra(seletorElemento).isEnabled());
	}

	/**
	 * @Descricao Escrever em algum campo
	 * @param elemento
	 * @param texto
	 */
	/// - annotation:
	/// 	title: escrever
	/// 	text_description:
	/// 		- Método responsável por escrever em elementos que permitam a entrada de dados, 
	///			- recebe 2 parâmetrosdo tipo <code>**String**</code> 
	/// 	parameters:
	///			- String: seletorElemento
	///			- String: texto
	/// 	ex:
	/// 		- java: BasicCommandWeb comBasico = new BasicCommandWeb(driver);
	///			- java: comBasico.escrever("input-exemplo", "texto de exemplo");
	/// 	return: 
	///			- void: método não tem retorno.
	public void escrever(String seletorElemento, String texto) {
		WebElement e = encontra(seletorElemento);
		e.clear();
		e.sendKeys(texto);
	}

	/**
	 * @Descricao Limpar campo
	 * @param elemento
	 */
	/// - annotation:
	/// 	title: limpar
	/// 	text_description:
	/// 		- Método responsável por limpar um elemnto que recebe entrada de dados, 
	///			- recebe um parâmetro do tipo <code>**String**</code> 
	/// 	parameters:
	///			- String: seletorElemento
	/// 	ex:
	/// 		- java: BasicCommandWeb comBasico = new BasicCommandWeb(driver);
	///			- java: comBasico.limpar("input-exemplo");
	/// 	return: 
	///			- void: método não tem retorno.
	public void limpar(String elemento) throws CommandException {
		try {
			encontra(elemento).clear();
		} catch (Exception e) {
			throw new CommandException(e);
		}
	}

	/**
	 * @Descricao Clicar em um elemento
	 * @param elemento
	 */
	/// - annotation:
	/// 	title: clicar
	/// 	text_description:
	/// 		- Método responsável por clicar em um elemento, 
	///			- recebe um parâmetro do tipo <code>**String**</code> 
	/// 	parameters:
	///			- String: seletorElemento
	/// 	ex:
	/// 		- java: BasicCommandWeb comBasico = new BasicCommandWeb(driver);
	///			- java: comBasico.clicar("exemplo");
	/// 	return: 
	///			- void: método não tem retorno.
	public void clicar(String elemento) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(encontra(elemento)));
		webElement.click();
	}

	/**
	 * @Descricao Clicar em um ou mais elementos
	 * @param elementos
	 */
	/// - annotation:
	/// 	title: clicarElementos
	/// 	text_description:
	/// 		- Método responsável por clicar em todos os elementos das lista de elementos passada 
	///			- como parâmetro. 
	/// 	parameters:
	///			- List <String>: seletorElementos
	/// 	ex:
	/// 		- java: BasicCommandWeb comBasico = new BasicCommandWeb(driver);
	/// 		- java: List String elementos = Arrays.asList("elemento1","elemento2");
	/// 		- java: comBasico.clicarElementos(elementos);
	/// 	return: 
	///			- void: método não tem retorno.
	public void clicarElementos(List<String> seletorElementos) throws CommandException {
		try {
			for (String elemento : seletorElementos) {
				encontra(elemento).click();
			}
		} catch (Exception e) {
			throw new CommandException(e);
		}
	}

	/**
	 * @Descricao Verificar se o Radio Button está selecionado
	 * @param seletorElemento
	 * @return boolean
	 */
	/// - annotation:
	/// 	title: verificarSeRadioEstaMarcado
	/// 	text_description:
	/// 		- Método responsável por verificar se um elemento do tipo radio está selecionado 
	///			- recebe uma <code>**String**</code> como parâmetro. 
	/// 	parameters:
	///			- String: seletorElemento
	/// 	ex:
	/// 		- java: BasicCommandWeb comBasico = new BasicCommandWeb(driver);
	/// 		- java: comBasico.verificarSeRadioEstaMarcado("elemento");
	/// 	return: 
	///			- void: método não tem retorno.
	public void verificarSeRadioEstaMarcado(String seletorElemento) {
		assertTrue(encontra(seletorElemento).isSelected());
	}

	/**
	 * @Descricao Obter texto do elemento. O texto é retornado como uma String
	 * @param seletorElemento
	 * @return String
	 */
	/// - annotation:
	/// 	title: obterTexto
	/// 	text_description:
	/// 		- Método responsável por obter o texto de um elemento
	///			- recebe uma <code>**String**</code> como parâmetro. 
	/// 	parameters:
	///			- String: seletorElemento
	/// 	ex:
	/// 		- java: BasicCommandWeb comBasico = new BasicCommandWeb(driver);
	/// 		- java: comBasico.obterTexto("elemento");
	/// 	return: 
	///			- String: método retorna o texto obtido do elemento, caso o mesmo seja encontrado.
	public String obterTexto(String elemento) {
		return encontra(elemento).getText();
	}

	/**
	 * @Descricao limpar valor com backspace
	 * @param elemento
	 */
	/// - annotation:
	/// 	title: limparValorComBackspace
	/// 	text_description:
	/// 		- Método responsável por limpar um elemento que recebe entrada de dados mas
	///			- como se fosse um usuário usando a tecla backspace recebe um <code>**WebElement**</code> como parâmetro. 
	/// 	parameters:
	///			- WebElement: elemento
	/// 	ex:
	/// 		- java: BasicCommandWeb comBasico = new BasicCommandWeb(driver);
	/// 		- java: WebElement elemento = comBasico.encontra("elemento"); 
	/// 		- java: comBasico.verificarSeRadioEstaMarcado(elemento);
	/// 	return: 
	///			- void: método não tem retorno.
	public void limparValorComBackspace(WebElement elemento) {
		while (elemento.getAttribute(VALUE).length() > 0) {
			elemento.sendKeys(Keys.BACK_SPACE);
		}
	}

	/**
	 * @Descricao Limpar Campo
	 * @param seletorElemento
	 */
	/// - annotation:
	/// 	title: limlimparCampopar
	/// 	text_description:
	/// 		- Método responsável por limpar um elemnto que recebe entrada de dados, 
	///			- recebe um parâmetro do tipo <code>**String**</code> 
	/// 	parameters:
	///			- String: seletorElemento
	/// 	ex:
	/// 		- java: BasicCommandWeb comBasico = new BasicCommandWeb(driver);
	///			- java: comBasico.limpar("input-exemplo");
	/// 	return: 
	///			- void: método não tem retorno.
	public void limparCampo(String seletorElemento) {
		encontra(seletorElemento).clear();
	}

	/**
	 * @Descricao Pegar Valor do CSS. elementoCss: nome do elemento CSS a ser obtido
	 *            o valor. Ex. Display
	 * @param seletorElemento
	 * @param elementoCss
	 * @return String
	 */
	/// - annotation:
	/// 	title: pegarValorCss
	/// 	text_description:
	/// 		- Método responsável por pegar o valor de uma propriedade 
	///			- CSS de um determinado elemento, recebe 2 parâmetros do tipo <code>**String**</code>. 
	/// 	parameters:
	///			- String: seletorElemento
	///			- String: elementoCss
	/// 	ex:
	/// 		- java: BasicCommandWeb comBasico = new BasicCommandWeb(driver);
	///			- java: comBasico.pegarValorCss("elemento-exemplo", "color");
	/// 	return: 
	///			- String: método retorna o valor do atrituto CSS buscado.
	public String pegarValorCss(String seletorElemento, String elementoCss) {
		return encontra(seletorElemento).getCssValue(elementoCss);
	}

	/**
	 * @Descricao Obter valor do "Attribute"
	 * @param seletorElemento
	 * @param attribute
	 * @return String
	 */
	/// - annotation:
	/// 	title: obterValorDoElementoAttribute
	/// 	text_description:
	/// 		- Método responsável por pegar o valor de uma propriedade 
	///			- de um determinado elemento, recebe 2 parâmetros do tipo <code>**String**</code>. 
	/// 	parameters:
	///			- String: seletorElemento
	///         - String: attribute
	/// 	ex:
	/// 		- java: BasicCommandWeb comBasico = new BasicCommandWeb(driver);
	///			- java: comBasico.obterValorDoElementoAttribute("elemento-exemplo", "value");
	/// 	return: 
	///			- String: método retorna o valor do atrituto buscado.
	public String obterValorDoElementoAttribute(String seletorElemento, String attribute) {
		return encontra(seletorElemento).getAttribute(attribute);
	}

	/**
	 * @Descricao Verificar se o check box está marcado
	 * @param seletorElemento
	 * @return boolean
	 */
	/// - annotation:
	/// 	title: verificarSeOcheckBoxEstaMarcado
	/// 	text_description:
	/// 		- Método responsável por verificar se um checkbox está marcado 
	///			- recebe um parâmetro do tipo <code>**String**</code>. 
	/// 	parameters:
	///			- String: seletorElemento
	/// 	ex:
	/// 		- java: BasicCommandWeb comBasico = new BasicCommandWeb(driver);
	///			- java: comBasico.verificarSeOcheckBoxEstaMarcado("elemento-exemplo");
	/// 	return: 
	///			- boolean: método retorna **true** caso o elemento esteja marcado e **false** caso negativo.
	public boolean verificarSeOcheckBoxEstaMarcado(String seletorElemento) {
		return encontra(seletorElemento).isSelected();
	}

	/*
	 * ***********************************
	 * 
	 * 
	 * 
	 * **************** Urls ***********
	 * 
	 * 
	 * 
	 ***********************************/

	/**
	 * @Descricao Abrir uma nova URL em um novo browser.
	 * @param url
	 * 
	 */
	/// - annotation:
	/// 	title: abrirUrl
	/// 	text_description:
	/// 		- Método responsável por abrir uma determinada url, recebe um parâmetro do tipo <code>**String**</code>. 
	/// 	parameters:
	///			- String: url
	/// 	ex:
	/// 		- java: BasicCommandWeb comBasico = new BasicCommandWeb(driver);
	///			- java: comBasico.abrirUrl("https://www.google.com.br");
	/// 	return: 
	///			- void: método não tem retorno.
	public void abrirUrl(String url) {
		driver.get(url);
	}

	/**
	 * @Descricao Navegar para outra URL, permanecendo na mesma aba do browser
	 * @param url
	 */
	/// - annotation:
	/// 	title: navegarUrl
	/// 	text_description:
	/// 		- Método responsável por navegar até uma determinada url, recebe um parâmetro do tipo <code>**String**</code>. 
	/// 	parameters:
	///			- String: url
	/// 	ex:
	/// 		- java: BasicCommandWeb comBasico = new BasicCommandWeb(driver);
	///			- java: comBasico.navegarUrl("https://www.google.com.br");
	/// 	return: 
	///			- void: método não tem retorno.
	public void navegarUrl(String url) {
		driver.navigate().to(url);
	}

	/**
	 * @Descricao Valida título da aba do browser
	 * @param tituloPagina
	 */
	/// - annotation:
	/// 	title: validarTituloDoBrowser
	/// 	text_description:
	/// 		- Método responsável por validar o titulo browser, recebe um parâmetro do tipo <code>**String**</code>. 
	/// 	parameters:
	///			- String: tituloPagina
	/// 	ex:
	/// 		- java: BasicCommandWeb comBasico = new BasicCommandWeb(driver);
	///			- java: comBasico.validarTituloDoBrowser("Google");
	/// 	return: 
	///			- void: método não tem retorno.
	public void validarTituloDoBrowser(String tituloPagina) {
		assertEquals(tituloPagina, driver.getTitle());
	}

	/// - annotation:
	/// 	title: validaTexto
	/// 	text_description:
	/// 		- Método responsável por validar o o texto de um determinado elemento, recebe um parâmetro do tipo <code>**String**</code>
	///			- e uma parâmetro do tipo <code>**WebElement**</code>. 
	/// 	parameters:
	///			- WebElement: elemento 
	///			- String: texto
	/// 	ex:
	/// 		- java: BasicCommandWeb comBasico = new BasicCommandWeb(driver);
	///			- java: WebElement elemento = comBasico.encontra("elemento-exemplo");
	///			- java: comBasico.validaTexto(elemento, "texto-exemplo");
	/// 	return: 
	///			- void: método não tem retorno.
	public void validaTexto(WebElement elemento, String texto) {
		System.out.println(elemento.getText());
		assertTrue(elemento.getText().contains(texto));
	}

	/**
	 * @Descricao Valida a URL atual
	 * @param url
	 * 
	 */
	/// - annotation:
	/// 	title: validarUrlAtual
	/// 	text_description:
	/// 		- Método responsável por validar a url atual, recebe um parâmetro do tipo <code>**String**</code>. 
	/// 	parameters:
	///			- String: url
	/// 	ex:
	/// 		- java: BasicCommandWeb comBasico = new BasicCommandWeb(driver);
	///			- java: comBasico.validarUrlAtual("https://www.google.com.br");
	/// 	return: 
	///			- void: método não tem retorno.
	public void validarUrlAtual(String url) {
		assertEquals(url, driver.getCurrentUrl());
	}

	/*
	 * ***********************************
	 * 
	 * 
	 * 
	 * **************** Combos ***********
	 * 
	 * 
	 * 
	 ***********************************/

	/**
	 * @Descricao Selecionar combo por texto visível
	 * @param seletorElemento
	 * @param valor
	 */
	/// - annotation:
	/// 	title: selecionarComboPorTextoVisivel
	/// 	text_description:
	/// 		- Método responsável por selecionar uma opção com combobox através do texto visivel, 
	///			- recebe 2 parâmetro do tipo <code>**String**</code>. 
	/// 	parameters:
	///			- String: seletorElemento
	///			- String: valor
	/// 	ex:
	/// 		- java: BasicCommandWeb comBasico = new BasicCommandWeb(driver);
	///			- java: comBasico.selecionarComboPorTextoVisivel("elemento-exemplo", "texto-exemplo");
	/// 	return: 
	///			- void: método não tem retorno.
	public void selecionarComboPorTextoVisivel(String seletorElemento, String valor) throws NoSuchElementException {
		WebElement webElement = encontra(seletorElemento);
		Select combo = new Select(webElement);
		try {
			combo.selectByValue(valor);
		} catch (Exception e) {
			combo.selectByIndex(Integer.parseInt(valor));
		}
	}

	/**
	 * @Descricao Obter texto da primeira posição do combo
	 * @param seletorElemento
	 * @return String
	 */
	/// - annotation:
	/// 	title: obterTextoDaPrimeiraPosicaoDoCombo
	/// 	text_description:
	/// 		- Método responsável por retornar o texto de primeira opção de um combobox através do texto visivel, 
	///			- recebe um parâmetro do tipo <code>**String**</code>. 
	/// 	parameters:
	///			- String: seletorElemento
	/// 	ex:
	/// 		- java: BasicCommandWeb comBasico = new BasicCommandWeb(driver);
	///			- java: comBasico.obterTextoDaPrimeiraPosicaoDoCombo("elemento-exemplo");
	/// 	return: 
	///			- String: método retorna o texto da primeira opção de um combobox.
	public String obterTextoDaPrimeiraPosicaoDoCombo(String elemento) {
		WebElement element = encontra(elemento);
		Select combo = new Select(element);
		return combo.getFirstSelectedOption().getText();
	}

	/**
	 * @Descricao Obter a quantidade de opções do combo
	 * @param seletorElemento
	 * @return Integer
	 */
	/// - annotation:
	/// 	title: obterQuantidadeOpcoesCombo
	/// 	text_description:
	/// 		- método reponsável por retornar a quantidade de opções de um combobox, recebe uma <code>**String**</code>
	///			- como parâmetro.
	/// 	parameters:
	///			- String: seletorElemento
	/// 	ex:
	/// 		- java: BasicCommandWeb comBasico = new BasicCommandWeb(driver);
	///			- java: comBasico.obterQuantidadeOpcoesCombo("elemento-exemplo");
	/// 	return: 
	///			- int: método retorna a quantidade de opções do combobox
	public Integer obterQuantidadeOpcoesCombo(String seletorElemento) {
		WebElement element = encontra(seletorElemento);
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		return options.size();
	}

	/**
	 * @Descricao Passar um texto e verificar se existe a opção no combo. Ex.: Se
	 *            quiser verificar num combo de cidade a opção "São Paulo", deverá
	 *            ser passado "São Paulo" como parâmetro
	 * @param seletorElemento
	 * @param texto
	 * @return boolean
	 */
	/// - annotation:
	/// 	title: verificarSeExisteOpcaoNoSelect
	/// 	text_description:
	/// 		- método reponsável por verificar se existe uma opção no combobox, recebe 2 parâmetros do tipo <code>**String**</code>
	/// 	parameters:
	///			- String: seletorElemento
	///			- String: texto
	/// 	ex:
	/// 		- java: BasicCommandWeb comBasico = new BasicCommandWeb(driver);
	///			- java: comBasico.verificarSeExisteOpcaoNoSelect("elemento-exemplo", "texto-exemplo");
	/// 	return: 
	///			- void: método não tem retorno
	public void verificarSeExisteOpcaoNoSelect(String seletorElemento, String texto) {
		boolean resultado = false;
		WebElement element = encontra(seletorElemento);
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		for (WebElement option : options) {
			if (option.getText().equals(texto)) {
				resultado = true;
				break;
			}
		}
		assertTrue(resultado);
	}

	/**
	 * @Descricao Desmarcar combo de acordo com o texto
	 * @param seletorElemento
	 * @param valor
	 */
	/// - annotation:
	/// 	title: desmarcarComboPorTextoVisivel 
	/// 	text_description:
	/// 		- método responsável por desmarcar um combobox através do texto que está visivel,
	///			- o mesmo recebe 2 parâmetros do tipo <code>**String**</code>
	/// 	parameters:
	///			- String: seletorElemento
	///			- String: valor
	/// 	ex:
	/// 		- java: BasicCommandWeb comBasico = new BasicCommandWeb(driver);
	///			- java: comBasico.desmarcarComboPorTextoVisivel("elemento-exemplo", "texto-exemplo");
	/// 	return: 
	///			- void: método não tem retorno.
	public void desmarcarComboPorTextoVisivel(String seletorElemento, String valor) {
		WebElement element = encontra(seletorElemento);
		Select combo = new Select(element);
		combo.deselectByVisibleText(valor);
	}

	/**
	 * @Descricao Obter todos os textos do combo
	 * @param seletorElemento
	 * @return List
	 */
	/// - annotation:
	/// 	title: obterTextosCombo
	/// 	text_description:
	/// 		- método reponsável por retornar uma lista com o texto das opções presentes em um combobox, 
	///			- recebe uma <code>**String**</code> como parâmetro.
	/// 	parameters:
	///			- String: seletorElemento
	/// 	ex:
	/// 		- java: BasicCommandWeb comBasico = new BasicCommandWeb(driver);
	///			- java: comBasico.obterTextosCombo("elemento-exemplo");
	/// 	return: 
	///			- List<String>: método uma lista do tipo <code>**String**</code> com o texto das opções do combobox
	public List<String> obterTextosCombo(String seletorElemento) {
		List<String> listaDeTexto = new ArrayList<String>();
		WebElement element = encontra(seletorElemento);
		Select combo = new Select(element);
		int quantidade = obterQuantidadeOpcoesCombo(seletorElemento);
		for (int i = 0; i <= quantidade; i++) {
			listaDeTexto.add(combo.getOptions().get(i).getText());
		}
		return listaDeTexto;
	}

	/// - annotation:
	/// 	title: envia
	/// 	text_description:
	/// 		- método responsável por dar um submit num formulário, recebe um parâmetro do tipo <code>**String**</code>.
	/// 	parameters:
	///			- String: seletorElemento
	/// 	ex:
	/// 		- java: BasicCommandWeb comBasico = new BasicCommandWeb(driver);
	///			- java: comBasico.envia("elemento-exemplo");
	/// 	return: 
	///			- void: método não tem retorno.
	public void envia(String seletorElemento) {
		WebElement e = encontra(seletorElemento);
		e.submit();
	}

	/**
	 * @Descricao Obter uma lista das opções que estão selecionadas no combo
	 * @param seletorElemento
	 * @return lista de String
	 */
	/// - annotation:
	/// 	title: obterTodasAsOpcoesSelecionadasNoCombo
	/// 	text_description:
	/// 		- método responsável por obter todas as opções selecionadas no combobox, recebe
	///			- um parâmetro do tipo <code>**String**</code>.
	/// 	parameters:
	///			- String: seletorElemento
	/// 	ex:
	/// 		- java: BasicCommandWeb comBasico = new BasicCommandWeb(driver);
	///			- java: comBasico.obterTodasAsOpcoesSelecionadasNoCombo("elemento-exemplo");
	/// 	return: 
	///			- List<String>: método retorna uma lista do tipo <code>**String**</code> com todas as opções selecionadas num combobox.
	public List<String> obterTodasAsOpcoesSelecionadasNoCombo(String seletorElemento) {
		WebElement element = encontra(seletorElemento);
		Select combo = new Select(element);
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		List<String> valores = new ArrayList<String>();
		for (WebElement opcao : allSelectedOptions) {
			valores.add(opcao.getText());
		}
		return valores;
	}

	/*
	 * ***********************************
	 * 
	 * 
	 * 
	 * **************** Frames ***********
	 * 
	 * 
	 * 
	 ***********************************/

	/**
	 * @Descricao Entrar no frame
	 * @param seletorElemento
	 */
	/// - annotation:
	/// 	title: entrarFrame
	/// 	text_description:
	/// 		- método Responsável por alterar o contexto da página para o contexto do iframe,
	///			- recebe uma parâmetro do tipo <code>**String**</code>
	/// 	parameters:
	///			- String: seletorElemento
	/// 	ex:
	/// 		- java: BasicCommandWeb comBasico = new BasicCommandWeb(driver);
	///			- java: comBasico.entrarFrame("elemento-exemplo");
	/// 	return: 
	///			- void: método não tem retorno.
	public void entrarFrame(String seletorElemento) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(seletorElemento);
	}

	/**
	 * @Descricao Sair do frame atual e voltar pra estrutura HTML padrão
	 */
	/// - annotation:
	/// 	title: sairFrame
	/// 	text_description:
	/// 		- método Responsável por alterar o contexto do iframe para o contexto da página,
	///			- não recebe parâmetro.
	/// 	parameters:
	/// 	ex:
	/// 		- java: BasicCommandWeb comBasico = new BasicCommandWeb(driver);
	///			- java: comBasico.sairFrame();
	/// 	return: 
	///			- void: método não tem retorno.
	public void sairFrame() {
		driver.switchTo().defaultContent();
	}

	/*
	 * ***********************************
	 * 
	 * 
	 * 
	 * **************** Alerts ***********
	 * 
	 * 
	 * 
	 ***********************************/

	/**
	 * @Descricao Aceitar o alerta
	 */
	/// - annotation:
	/// 	title: aceitarAlerta 
	/// 	text_description:
	/// 		- método responsável por aceitar um window.alert, não recebe parâmetro.
	/// 	parameters:
	/// 	ex:
	/// 		- java: BasicCommandWeb comBasico = new BasicCommandWeb(driver);
	///			- java: comBasico.aceitarAlerta();
	/// 	return: 
	///			- void: método não tem retorno.
	public void aceitarAlerta() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	/**
	 * @Descricao Obter texto do alerta
	 * @return String
	 */
	/// - annotation:
	/// 	title: obterTextoDoAlerta 
	/// 	text_description:
	/// 		- método responsável por obter o texto de um window.alert, não recebe parâmetro.
	/// 	parameters:
	/// 	ex:
	/// 		- java: BasicCommandWeb comBasico = new BasicCommandWeb(driver);
	///			- java: comBasico.obterTextoDoAlerta();
	/// 	return: 
	///			- String: método retorna o texto do window.alert.
	public String obterTextoDoAlerta() {
		Alert alert = driver.switchTo().alert();
		String texto = alert.getText();
		return texto;
	}

	/**
	 * @Descricao Negar Alerta
	 */
	/// - annotation:
	/// 	title: negarAlerta 
	/// 	text_description:
	/// 		- método responsável por negar um window.alert, não recebe parâmetro.
	/// 	parameters:
	/// 	ex:
	/// 		- java: BasicCommandWeb comBasico = new BasicCommandWeb(driver);
	///			- java: comBasico.negarAlerta();
	/// 	return: 
	///			- void: método não tem retorno.
	public void negarAlerta() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	/**
	 * @Descricao Escrever no Alerta
	 * @param conteudo
	 */
	/// - annotation:
	/// 	title: escreverNoAlerta 
	/// 	text_description:
	/// 		- método responsável por inserir um determinado texto em um window.alert, 
	///			- recebe um parâmetro do tipo <code>**String**</code>.
	/// 	parameters:
	///			- String: conteudo
	/// 	ex:
	/// 		- java: BasicCommandWeb comBasico = new BasicCommandWeb(driver);
	///			- java: comBasico.escreverNoAlerta("texto-exemplo");
	/// 	return: 
	///			- void: método não tem retorno.
	public void escreverNoAlerta(String conteudo) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(conteudo);
	}

	/*
	 * ***********************************
	 * 
	 * 
	 * 
	 * **************** Esperas **********
	 * 
	 * 
	 * 
	 ***********************************/

	/**
	 * @param seletorElemento
	 * @param tempo
	 *            limite de espera
	 * @return 
	 */
	/// - annotation:
	/// 	title: esperarElemento 
	/// 	text_description:
	/// 		- método responsável por esperar de forma explicita até que um elemento passe a existir
	///			- recebe um parâmetro do tipo <code>**String**</code> e um parâmetro do tipo <code>**int**</code.
	/// 	parameters:
	///			- String: seletorElemento
	///			- int: tempo
	/// 	ex:
	/// 		- java: BasicCommandWeb comBasico = new BasicCommandWeb(driver);
	///			- java: comBasico.esperarElemento("elemento-exemplo", 10);
	/// 	return: 
	///			- void: método não tem retorno.
	public WebElement esperarElemento(By seletorElemento, int tempo) {
		WebDriverWait wait = new WebDriverWait(driver, tempo);
		return wait.until(ExpectedConditions.presenceOfElementLocated(seletorElemento));
	}

	/**
	 * @param seletorElemento.
	 * @param tempo
	 *            limite de espera
	 */
	public void esperarSerClicavel(String seletorElemento, int tempo) {
		// WebDriverWait wait = new WebDriverWait(driver, time);
		// wait.until(ExpectedConditions.elementToBeClickable(find(seletorElemento)));
	}

	/// - annotation:
	/// 	title: esperarCarregar 
	/// 	text_description:
	/// 		- método responsável por esperar de forma explicita até que um elemento seja carregado
	///			- recebe 2 parâmetros do tipo <code>**String**</code>.
	/// 	parameters:
	///			- String: seletorElemento
	///			- String: texto
	/// 	ex:
	/// 		- java: BasicCommandWeb comBasico = new BasicCommandWeb(driver);
	///			- java: comBasico.esperarCarregar("elemento-exemplo", "texto-exemplo");
	/// 	return: 
	///			- void: método não tem retorno.
	public void esperarCarregar(String seletorElemento, String texto) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.textToBePresentInElement(encontra(seletorElemento), texto));
	}

	/**
	 * @Descricao
	 * @param seletorElemento
	 * @param tempo
	 */
	public void esperarSerSelecionavel(String seletorElemento, int tempo) {
		// WebDriverWait wait = new WebDriverWait(driver, tempo);
		// wait.until(ExpectedConditions.elementToBeSelected(find(seletorElemento)));
	}

	/**
	 * @Descricao Esperar a página estar na URL passada via parâmetro
	 * @param url
	 * @param tempo
	 */
	public void esperarUrlSerCarregada(String url, int tempo) {
		// WebDriverWait wait = new WebDriverWait(driver, tempo);
		// wait.until(ExpectedConditions.urlToBe(url));
	}

	/**
	 * @Descricao Esperar elemento ser clicável, clicar e escrever
	 * @param elemento
	 * @param texto
	 * @param tempoLimiteDeEspera
	 */
	public void esperarSerClicavelClicarEscrever(String elemento, String valor, int tempoLimiteDeEspera) {
		// WebDriverWait wait = new WebDriverWait(driver, tempoLimiteDeEspera);
		// WebElement e =
		// wait.until(ExpectedConditions.elementToBeClickable(find(elemento)));
		// e.clear();
		// e.sendKeys(valor);
	}

	/**
	 * @Descricao Esperar visibilidade do elemento
	 * @param seletorElemento
	 * @param tempo
	 */
	/// - annotation:
	/// 	title: esperarSerInvisivel 
	/// 	text_description:
	/// 		- método responsável por esperar de forma explicita até que um elemento esteja invisivel
	///			- recebe um parâmetros do tipo <code>**String**</code> e um parâmetro do tipo <code>int</code>.
	/// 	parameters:
	///			- String: seletorElemento
	///			- int: tempo
	/// 	ex:
	/// 		- java: BasicCommandWeb comBasico = new BasicCommandWeb(driver);
	///			- java: comBasico.esperarSerInvisivel("elemento-exemplo", "texto-exemplo");
	/// 	return: 
	///			- void: método não tem retorno.
	public void esperarSerInvisivel(String seletorElemento, int tempo) {
		WebDriverWait wait = new WebDriverWait(driver, tempo);
		wait.until(ExpectedConditions.invisibilityOf(encontra(seletorElemento)));
	}

	/**
	 * @Descricao Esperar elemento ser visível
	 * @param seletorElemento
	 * @param tempo
	 * @return 
	 */
	/// - annotation:
	/// 	title: esperarElementoSerVisivel 
	/// 	text_description:
	/// 		- método responsável por esperar de forma explicita até que um elemento esteja visivel
	///			- recebe um parâmetros do tipo <code>**String**</code> e um parâmetro do tipo <code>int</code>.
	/// 	parameters:
	///			- String: seletorElemento
	///			- int: tempo
	/// 	ex:
	/// 		- java: BasicCommandWeb comBasico = new BasicCommandWeb(driver);
	///			- java: comBasico.esperarElementoSerVisivel("elemento-exemplo", "texto-exemplo");
	/// 	return: 
	///			- void: método não tem retorno.
	public WebElement esperarElementoSerVisivel(String seletorElemento, int tempo) {
		WebDriverWait wait = new WebDriverWait(driver, tempo);
		return wait.until(ExpectedConditions.visibilityOf(encontra(seletorElemento)));
	}

	/**
	 * @Descricao Esperar elemento ser clicável, após, limpar o campo
	 * @param elemento
	 * @param tempoLimiteDeEspera
	 */
	public void esperarElementoSerClicavelLimparCampo(String elemento, int tempoLimiteDeEspera) {
		// WebDriverWait wait = new WebDriverWait(driver, tempoLimiteDeEspera);
		// WebElement input =
		// wait.until(ExpectedConditions.elementToBeClickable(find(elemento)));
		// while (input.getAttribute(VALUE).length() > 0) {
		// input.sendKeys(Keys.BACK_SPACE);
		// }
	}

	/// - annotation:
	/// 	title: navega
	/// 	text_description:
	/// 		- método responsável por navegar até uma determinada página,
	///			- recebe um parâmetro do tipo <code>**String**</code>
	/// 	parameters:
	///			- String: url
	/// 	ex:
	/// 		- java: BasicCommandWeb comBasico = new BasicCommandWeb(driver);
	///			- java: comBasico.navega("https://www.google.com.br");
	/// 	return: 
	///			- void: método não tem retorno.
	public void navega(String url) {
		// navegar para outros links
		driver.navigate().to(url);
	}

	/// - annotation:
	/// 	title: navega
	/// 	text_description:
	/// 		- método responsável por encerrar o navegador,
	///			- não recebe parâmetro.
	/// 	parameters:
	/// 	ex:
	/// 		- java: BasicCommandWeb comBasico = new BasicCommandWeb(driver);
	///			- java: comBasico.encerra();
	/// 	return: 
	///			- void: método não tem retorno.
	public void encerra() {
		// Encerra o driver
		try {
			driver.close();
			driver.quit();
		} catch (Exception e) {
			log.error("Nenhum Driver aberto", e);
		}
	}

	/// - annotation:
	/// 	title: navega
	/// 	text_description:
	/// 		- método responsável por encerrar o navegador,
	///			- não recebe parâmetro.
	/// 	parameters:
	/// 	ex:
	/// 		- java: BasicCommandWeb comBasico = new BasicCommandWeb(driver);
	///			- java: comBasico.encerra();
	/// 	return: 
	///			- void: método não tem retorno.
	public void clicar(By elemento) {
		try {
			WebElement element = driver.findElement(elemento);

			executor.executeScript("arguments[0].click();", element);
		} catch (NoSuchElementException | TimeoutException | ElementNotVisibleException e) {

		}
	}

	/// - annotation:
	/// 	title: clicarPorTexto
	/// 	text_description:
	/// 		- método responsável por clicar em um elemento através do texto, tag e seletor de um elemento,
	///			- recebe 3 parâmetros do tipo <code>**String**</code>.
	/// 	parameters:
	///			- String: seletorElemento
	///			- String: tag
	///			- String: texto
	/// 	ex:
	/// 		- java: BasicCommandWeb comBasico = new BasicCommandWeb(driver);
	///			- java: comBasico.clicarPorTexto("exemplo-teste", "h1", "texto-exemplo");
	/// 	return: 
	///			- void: método não tem retorno.
	public void clicarPorTexto(String seletorElemento, String tag, String texto) {
		try {
			WebElement foco = encontra(seletorElemento);
			List<WebElement> element = foco.findElements(By.tagName(tag));
			for (WebElement e : element) {
				if (e.getText().contentEquals(texto)) {
					borda(e);
					e.click();
					break;
				}
			}
		} catch (ElementNotVisibleException e) {

		}
	}

	/**
	 * @Descricao Rolar para baixo. O parâmetro "quantidade" define a quantidade de
	 *            rolagens
	 * @param posicao
	 */
	/// - annotation:
	/// 	title: rolarParaBaixo
	/// 	text_description:
	/// 		- método responsável por mover o scroll para baixo até um determinado ponto da página,
	///			- recebe um parâmetro do tipo <code>**int**</code>
	/// 	parameters:
	///			- int: posicao
	/// 	ex:
	/// 		- java: BasicCommandWeb comBasico = new BasicCommandWeb(driver);
	///			- java: comBasico.rolarParaBaixo(100);
	/// 	return: 
	///			- void: método não tem retorno.
	public void rolarParaBaixo(int posicao) {
		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0, " + posicao + ")");
		} catch (NoSuchElementException | TimeoutException | ElementNotVisibleException e) {

		}
	}

	/**
	 * @Descricao Rolar para cima. O parâmetro "quantidade" define a quantidade de
	 *            rolagens
	 * @param posicao
	 */
	/// - annotation:
	/// 	title: rolarParaCima
	/// 	text_description:
	/// 		- método responsável por mover o scroll para cima até um determinado ponto da página,
	///			- recebe um parâmetro do tipo <code>**int**</code>
	/// 	parameters:
	///			- int: posicao
	/// 	ex:
	/// 		- java: BasicCommandWeb comBasico = new BasicCommandWeb(driver);
	///			- java: comBasico.rolarParaCima(100);
	/// 	return: 
	///			- void: método não tem retorno.
	public void rolarParaCima(int posicao) {
		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0, " + posicao + ")");
		} catch (NoSuchElementException | TimeoutException | ElementNotVisibleException e) {

		}
	}

	/**
	 * @Descricao Pegar valor do CSS. O parâmetro esperar receber o ID do elemento.
	 *            VocÊ DEVE passa o parâmetro como um tipo String
	 * @param idDoElemento
	 * @return String: valor do css
	 */
	public String pegarValorCss(String idDoElemento) {
		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			String value = (String) jse.executeScript(
					"" + "if (document.getElementById('" + idDoElemento + "').style.display == 'none'){   }");
			return value;
		} catch (NoSuchElementException | TimeoutException | ElementNotVisibleException e) {
			return null;
		}
	}

	/**
	 * @Descricao Mover para o elemento
	 * @param sleletorElemento
	 */
	/// - annotation:
	/// 	title: moverParaOelemento
	/// 	text_description:
	/// 		- método responsável por mover o scroll da página até um determinado elemento na página usando javascript,
	///			- recebe um parâmetro do tipo <code>**By**</code>
	/// 	parameters:
	///			- By: seletorElemento
	/// 	ex:
	/// 		- java: BasicCommandWeb comBasico = new BasicCommandWeb(driver);
	///			- java: comBasico.moverParaOelemento("exemplo-teste");
	/// 	return: 
	///			- void: método não tem retorno.
	public void moverParaOelemento(By elemento) {
		WebElement element = driver.findElement(elemento);
		executor.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	/**
	 * @Descricao Escrever
	 * @param seletorElemento
	 * @param texto
	 */
	/// - annotation:
	/// 	title: escrever
	/// 	text_description:
	/// 		- método responsável por escrever em um elemento que recebe entrada de dados usando javascript,
	///			- recebe 2 parâmetros um do tipo <code>**By**</code> e um do tipo <code>**String**</code>.
	/// 	parameters:
	///			- By: seletorElemento
	///			- String: texto
	/// 	ex:
	/// 		- java: BasicCommandWeb comBasico = new BasicCommandWeb(driver);
	///			- java: comBasico.escrever("exemplo-teste", "texto-exemplo");
	/// 	return: 
	///			- void: método não tem retorno.
	public void escrever(By seletorElemento, String texto) {
		WebElement element = driver.findElement(seletorElemento);
		executor.executeScript("arguments[0].value=" + texto + ";", element);
	}

}