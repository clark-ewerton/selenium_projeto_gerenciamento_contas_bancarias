package br.ce.wcclark.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcclark.core.BasePage;
import br.ce.wcclark.core.BaseTest;
import br.ce.wcclark.pages.MenuPage;

public class TesteRemoverContacomMovimentacao extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private BasePage page = new BasePage();
	
	@Test
	public void testeRemoverContacomMovimentacao() {
		menu.navegarListarConta();
		Assert.assertEquals("Conta para movimentacoes", page.validarContaTabelaConta("Conta para movimentacoes"));
		page.clicarRemoverContaMovimentacao("Conta para movimentacoes");
		Assert.assertEquals("Conta removida com sucesso!", page.obterMensagemValidada());
	}

}
