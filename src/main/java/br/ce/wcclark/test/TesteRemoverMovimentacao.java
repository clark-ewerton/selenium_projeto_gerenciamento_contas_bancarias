package br.ce.wcclark.test;

import static br.ce.wcclark.core.DriverFactory.getDriver;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcclark.core.BasePage;
import br.ce.wcclark.core.BaseTest;
import br.ce.wcclark.pages.MenuPage;

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TesteRemoverMovimentacao extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private BasePage page = new BasePage();
	
	@Test
	public void testeRemoverMovimentacao() {
		menu.navegarResumoMensal();
		//validar se a movimentacao realmente existe
		Assert.assertEquals("Movimentacao para exclusao", page.validarContaTabelaMovimentacao("Conta para movimentacoes"));
		
		page.clicarRemoverMovimentacao("Movimentacao para exclusao");
		
		//validar mensagem sucesso
		Assert.assertEquals("Movimentação removida com sucesso!", page.obterMensagemValidada());
		
	}
	
	@Test
	public void testeResumoMensal() {
		menu.navegarResumoMensal();
		
		Assert.assertEquals("Seu Barriga - Extrato", getDriver().getTitle());
		
		page.clicarValorCombobox("ano", "2017");
		page.clicarBotaoBuscar();
		Assert.assertEquals("2017", page.retornarValorComboBox("ano"));
		
		//verifica se a tabela esta vazia
		Assert.assertEquals(0, page.verificarTabelaVazia("tabelaExtrato").size());
		
	}

}
