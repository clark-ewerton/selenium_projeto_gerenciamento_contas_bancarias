package br.ce.wcclark.regrasValidacoes;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import br.ce.wcclark.core.BasePage;
import br.ce.wcclark.core.BaseTest;
import br.ce.wcclark.pages.MenuPage;

@RunWith(Parameterized.class)
public class TesteRegrasAlterarConta extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private BasePage page = new BasePage();
	
	//parametros padrões do teste
		@Parameter
		public String conta;
		@Parameter(value=1)
		public String msg;
			
		//como os dados serão inseridos?
		@Parameters
		public static Collection<Object[]> getCollection(){
			return Arrays.asList(new Object[][] {
				{"", "Informe o nome da conta"}
			});
		}

		@Test
		public void deveValidarRegrasAlterarConta(){
			menu.navegarListarConta();
			page.clicarAlterar();
			page.escreverCampo("nome", conta);
			page.clicarBotaoSalvar();
			Assert.assertEquals(msg, page.obterMensagemValidada());

}
}
