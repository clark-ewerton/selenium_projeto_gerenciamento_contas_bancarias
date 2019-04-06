package br.ce.wcclark.core;

import static br.ce.wcclark.core.DriverFactory.*;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.ce.wcclark.pages.LoginPage;

public class BaseTest {

	private static LoginPage page = new LoginPage();

	@Rule
	public TestName testName = new TestName();

	// antes de cada teste, execute o conte�do deste m�todo
	@Before
	public void inicializa() {
		getDriver().get("https://seubarriga.wcaquino.me/login");

		String usuario = "clarkewerton@hotmail.com";
		String senha = "casado123";
		page.escreverCampo("email", usuario);
		page.escreverCampo("senha", senha);
		page.logar();

		// validacao pagina logada
		Assert.assertEquals("Bem vindo, Clark!", page.obterMensagemValidada());

	}

	@After
	public void termina() throws IOException {
		TakesScreenshot ss = (TakesScreenshot) getDriver();
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		// FileUtils.copyFile(arquivo, new File("screenshot.jpg"));
		FileUtils.copyFile(arquivo,
				new File("target" + File.separator + "screenshot" + testName.getMethodName() + ".jpg"));

		if (Propriedades.FECHAR_BROWSER) {
			DriverFactory.killDriver();
		}

	}

}
