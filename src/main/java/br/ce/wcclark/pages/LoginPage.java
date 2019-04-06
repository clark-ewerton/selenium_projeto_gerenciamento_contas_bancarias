package br.ce.wcclark.pages;

import static br.ce.wcclark.core.DriverFactory.getDriver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.ce.wcclark.core.BasePage;

public class LoginPage extends BasePage {
	
	/********************** Botoes *****************************/
	public void logar() {
		getDriver().findElement(By.xpath("//*[.='Entrar']")).click();
	}
	
	public void resetar() {
		getDriver().findElement(By.linkText("reset")).click();
	}
	
	//validacoes
	public List<String> obterListaErrosLogin() {
		List<WebElement> erros = getDriver().findElements(By.xpath("//div[@class='alert alert-danger']"));
		List<String> retorno = new ArrayList<String>();
		for(WebElement erro: erros) {
			retorno.add(erro.getText());
		}
		return retorno;
		
	}
	
	
	
}
