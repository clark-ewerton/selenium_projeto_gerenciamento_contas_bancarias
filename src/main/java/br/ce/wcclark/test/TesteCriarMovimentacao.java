package br.ce.wcclark.test;

import static br.ce.wcclark.utils.DataUtils.obterDataFormatada;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcclark.core.BaseTest;
import br.ce.wcclark.pages.InserirMovimentacaoPage;
import br.ce.wcclark.pages.MenuPage;

public class TesteCriarMovimentacao extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private InserirMovimentacaoPage page = new InserirMovimentacaoPage();
	
	@Test
	public void testeCriarMovimentacaoPago() {
		String descricao = "Recebimento doacao";
		String interessado = "Lula";
		String valor = "2500";
		
		menu.navegarCriarMovimentacao();
		page.escreverCampodataMovimentacao(obterDataFormatada(new Date()));
		page.escreverCampodataPagamento(obterDataFormatada(new Date()));
		page.escreverCampo("descricao", descricao);
		page.escreverCampo("interessado", interessado);
		page.escreverCampo("valor",  valor);
		page.clicarValorCombobox("conta", "Conta para alteração");
		page.clicarRadio("status_pago");
		Assert.assertTrue(page.validarRadioSelecionada("status_pago"));
		page.clicarBotaoSalvar();
		Assert.assertEquals("Movimentação adicionada com sucesso!", page.obterMensagemValidada());
		
	}
	
	public void testeCriarMovimentacaoPendente() {
		String descricao = "Recebimento doacao";
		String interessado = "Lula";
		String valor = "2500";
		
		menu.navegarCriarMovimentacao();
		page.clicarValorCombobox("tipo", "Despesa");
		page.escreverCampodataMovimentacao(obterDataFormatada(new Date()));
		page.escreverCampodataPagamento(obterDataFormatada(new Date()));
		page.escreverCampo("descricao", descricao);
		page.escreverCampo("interessado", interessado);
		page.escreverCampo("valor",  valor);
		page.clicarRadio("status_pendente");
		page.clicarBotaoSalvar();
		Assert.assertTrue(page.validarRadioSelecionada("status_pendente"));
		Assert.assertEquals("Movimentação adicionada com sucesso!", page.obterMensagemValidada());
		
	}
	

}
