package br.ce.wcclark.pages;

import br.ce.wcclark.core.BasePage;

public class InserirMovimentacaoPage extends BasePage {
	
	
	/************************* textfield *****************************/
	public void escreverCampodataMovimentacao(String data) {
		escreverCampo("data_transacao", data);
	}
	
	public void escreverCampodataPagamento(String data) {
		escreverCampo("data_pagamento", data);
	}
	
	

	

}
