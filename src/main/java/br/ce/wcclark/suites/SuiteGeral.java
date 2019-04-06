package br.ce.wcclark.suites;

import static br.ce.wcclark.core.DriverFactory.getDriver;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.ce.wcclark.core.DriverFactory;
import br.ce.wcclark.pages.LoginPage;
import br.ce.wcclark.test.TesteAlterarConta;
import br.ce.wcclark.test.TesteCriarMovimentacao;
import br.ce.wcclark.test.TesteInserirConta;
import br.ce.wcclark.test.TesteRemoverContacomMovimentacao;
import br.ce.wcclark.test.TesteRemoverMovimentacao;
import br.ce.wcclark.test.TesteVerificarSaldoConta;

@RunWith(Suite.class)
@SuiteClasses({
	TesteInserirConta.class,
	TesteAlterarConta.class,
	TesteCriarMovimentacao.class,
	TesteRemoverMovimentacao.class,
	TesteRemoverContacomMovimentacao.class,
	TesteVerificarSaldoConta.class
	
})
public class SuiteGeral {
	
	private static LoginPage page = new LoginPage();
	
	@BeforeClass
	public static void reset() {
		getDriver().get("https://seubarriga.wcaquino.me/login");
		
		String usuario = "clarkewerton@hotmail.com";
	String senha = "casado123";
	page.escreverCampo("email", usuario);
	page.escreverCampo("senha", senha);
	page.logar();
	
	page.resetar();
	//reset validado
	Assert.assertEquals("Dados resetados com sucesso!", page.obterMensagemValidada());
	
	DriverFactory.killDriver();
	
	}
	
	//antes de cada teste, execute o conte�do deste m�todo
		/*@BeforeClass
		public static void inicializa() {
				getDriver().get("https://seubarriga.wcaquino.me/login");
				
				/*String usuario = "clarkewerton@hotmail.com";
				String senha = "casado123";
				page.escreverCampo("email", usuario);
				page.escreverCampo("senha", senha);
				page.logar();
				
				//validacao pagina logada
				Assert.assertEquals("Bem vindo, Clark!", page.obterMensagemValidada());*/
				//	}
	


}
