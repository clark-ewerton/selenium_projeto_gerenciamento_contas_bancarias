package br.ce.wcclark.regrasValidacoes;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import br.ce.wcclark.core.BaseTest;
import br.ce.wcclark.pages.MenuPage;

@RunWith(Parameterized.class)
public class TesteRegrasInserirConta extends BaseTest {
	
	private MenuPage page = new MenuPage();
	
	//parametros padrões do teste
	@Parameter
	public String conta;
	@Parameter(value=1)
	public String msg;
		
	//como os dados serão inseridos?
	@Parameters
	public static Collection<Object[]> getCollection(){
		return Arrays.asList(new Object[][] {
			{"", "Informe o nome da conta"},
			{"Conta mesmo nome", "Já existe uma conta com esse nome!"}
		});
	}

	@Test
	public void deveValidarRegrasInserirConta(){
		page.navegarAdicionarConta();
		page.escreverCampo("nome", conta);
		page.clicarBotaoSalvar();
		System.out.println(msg);
		Assert.assertEquals(msg, page.obterMensagemValidada());
}

}
