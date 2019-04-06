package br.ce.wcclark.regrasValidacoes;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import br.ce.wcclark.core.BaseTest;
import br.ce.wcclark.pages.InserirMovimentacaoPage;
import br.ce.wcclark.pages.MenuPage;

@RunWith(Parameterized.class)
public class TesteRegrasCriarMovimentacao extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private InserirMovimentacaoPage page = new InserirMovimentacaoPage();
	
	//parametros padrões do teste
	@Parameter
	public String data_movimentacao;
	@Parameter(value=1)
	public String data_pagamento;
	@Parameter(value=2)
	public String descricao;
	@Parameter(value=3)
	public String interessado;
	@Parameter(value=4)
	public String valor;
	@Parameter(value=5)
	public List<String> msg;

		
	//como os dados serão inseridos?
	@Parameters
	public static Collection<Object[]> getCollection(){
		return Arrays.asList(new Object[][] {
			//nao digita nenhum campo
			{"", "", "", "", "", Arrays.asList("Data da Movimentação é obrigatório", "Data do pagamento é obrigatório",  
					"Descrição é obrigatório", "Interessado é obrigatório", "Valor é obrigatório", "Valor deve ser um número")},
			
			//digita data movimentacao invalida
			{"texto", "", "", "", "", Arrays.asList("Data da Movimentação inválida (DD/MM/YYYY)", 
					"Data da Movimentação deve ser menor ou igual à data atual", "Data do pagamento é obrigatório",
					"Descrição é obrigatório", "Interessado é obrigatório", "Valor é obrigatório", "Valor deve ser um número")},
			
			//digita data maior que permitida
			{"17/11/2018", "", "", "", "", Arrays.asList("Data da Movimentação deve ser menor ou igual à data atual", 
					"Data do pagamento é obrigatório", "Descrição é obrigatório", 
					"Interessado é obrigatório", "Valor é obrigatório", "Valor deve ser um número")},
			
			//digita data pagamento invalida
			{"16/11/2018", "texto", "", "", "", Arrays.asList("Data do pagamento inválida (DD/MM/YYYY)", "Descrição é obrigatório", 
					"Interessado é obrigatório", "Valor é obrigatório", "Valor deve ser um número")},
			
			{"16/11/2018", "30/11/2018", "", "", "", Arrays.asList("Descrição é obrigatório", 
					"Interessado é obrigatório", "Valor é obrigatório", "Valor deve ser um número")},
			
			{"16/11/2018", "30/11/2018", "movimentacao doacao", "", "", Arrays.asList("Interessado é obrigatório", 
					"Valor é obrigatório", "Valor deve ser um número")},
			
			{"16/11/2018", "30/11/2018", "movimentacao doacao", "Lula", "", Arrays.asList("Valor é obrigatório", "Valor deve ser um número")},
			
			//digita texto no campo valor
			{"16/11/2018", "30/11/2018", "movimentacao doacao", "Lula", "texto",  Arrays.asList("Valor deve ser um número")}
			
		});
	}

	@Test
	public void deveValidarRegrasCriarMovimentacao(){
		menu.navegarCriarMovimentacao();
		page.escreverCampodataMovimentacao(data_movimentacao);
		page.escreverCampodataPagamento(data_pagamento);
		page.escreverCampo("descricao", descricao);
		page.escreverCampo("interessado", interessado);
		page.escreverCampo("valor", valor);
		page.clicarBotaoSalvar();
		
		
		//validacao dos erros
		//msg = new ArrayList<String>();
		List<String> retorno = page.obterListaErros();
		//for(WebElement erro: page.obterListaMensagens()) {
			//for(int i=0; i < 4; i ++) {
		/*Assert.assertTrue(retornos.containsAll(Arrays.asList(
				"Data da Movimentação é obrigatório", "Data do pagamento é obrigatório",
				"Descrição é obrigatório", "Interessado é obrigatório", 
				"Valor é obrigatório", "Valor deve ser um número")));*/
		Assert.assertEquals(msg.size(), retorno.size());
		//Assert.assertTrue(retorno.containsAll(Arrays.asList("Descrição é obrigatório", 
			//	"Interessado é obrigatório", "Valor é obrigatório", "Valor deve ser um número")));

	//	}

}
}
