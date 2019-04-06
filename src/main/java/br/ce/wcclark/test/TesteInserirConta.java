package br.ce.wcclark.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcclark.core.BaseTest;
import br.ce.wcclark.pages.MenuPage;

public class TesteInserirConta extends BaseTest {
	
	private MenuPage page = new MenuPage();
	
	
	@Test
	public void testeInsercaoConta() {
		
		String conta = "Conta 1";
		
		page.navegarAdicionarConta();
		page.escreverCampo("nome", conta);
		page.clicarBotaoSalvar();
		//page.listarConta();
		//WebDriverWait wait = new WebDriverWait(getDriver(), 5);
	//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@role='alert']")));
		Assert.assertEquals("Conta adicionada com sucesso!", page.obterMensagemValidada());
	}

}
