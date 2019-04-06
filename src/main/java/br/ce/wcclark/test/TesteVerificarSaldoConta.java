package br.ce.wcclark.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcclark.core.BasePage;
import br.ce.wcclark.core.BaseTest;
import br.ce.wcclark.pages.MenuPage;

public class TesteVerificarSaldoConta extends BaseTest {
	
	private BasePage page = new BasePage();
	private MenuPage menu = new MenuPage();
	
	@Test
	public void testeVerificarSaldo() {
		//Assert.assertEquals("Bem vindo, Clark!", page.obterMensagemValidada());
		menu.navegarHome();
		Assert.assertEquals("Conta para saldo", page.validarContaTabelaSaldo("Conta para saldo"));
		Assert.assertEquals("534.00", page.obterSaldoConta("Conta para saldo"));
	}
}
