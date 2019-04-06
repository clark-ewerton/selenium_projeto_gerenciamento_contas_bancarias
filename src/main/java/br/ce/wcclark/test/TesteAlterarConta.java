package br.ce.wcclark.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcclark.core.BasePage;
import br.ce.wcclark.core.BaseTest;
import br.ce.wcclark.pages.MenuPage;


public class TesteAlterarConta extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private BasePage page = new BasePage();
	

	@Test
	public void testeAlteracaoConta() {
		menu.navegarListarConta();
		Assert.assertEquals("Conta 1", page.validarContaTabelaConta("Conta 1"));
		page.clicarAlterar();
		page.escreverCampo("nome", "Conta para alteração");
		page.clicarBotaoSalvar();
		Assert.assertEquals("Conta alterada com sucesso!", page.obterMensagemValidada());
		
	}

}
