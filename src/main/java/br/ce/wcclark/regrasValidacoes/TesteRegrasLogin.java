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
import br.ce.wcclark.pages.LoginPage;

@RunWith(Parameterized.class)
public class TesteRegrasLogin extends BaseTest {

	private LoginPage page = new LoginPage();
	
	//parametros padr�es do teste
	@Parameter
	public String email;
	@Parameter(value=1)
	public String senha;
	@Parameter(value=2)
	public List<String> msg;
		
	//como os dados ser�o inseridos?
	@Parameters
	public static Collection<Object[]> getCollection(){
		return Arrays.asList(new Object[][] {
			{"", "", Arrays.asList("Email � um campo obrigat�rio", "Senha � um campo obrigat�rio")},
			{"", "teste", Arrays.asList("Email � um campo obrigat�rio")},
			{"teste@teste", "", Arrays.asList("Senha � um campo obrigat�rio")},
			{"clark@teste", "teste", Arrays.asList("Problemas com o login do usu�rio")}
		});
	}

	@Test
	public void deveValidarRegrasLogin(){
		page.escreverCampo("email", email);
		page.escreverCampo("senha", senha);
		page.logar();
		
		List<String> erros = page.obterListaErrosLogin();
		Assert.assertEquals(msg.size(), erros.size());
}
}
