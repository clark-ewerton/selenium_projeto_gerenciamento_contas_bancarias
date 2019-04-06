package br.ce.wcclark.pages;

import static br.ce.wcclark.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

import br.ce.wcclark.core.BasePage;

public class MenuPage extends BasePage {
	
	/************************ navegacao ****************************/
	public void navegarHome() {
		getDriver().findElement(By.xpath("//a[.='Home']")).click();

	}
	
	public void navegarCriarMovimentacao() {
		getDriver().findElement(By.xpath("//a[.='Criar Movimentação']")).click();

	}
	
	public void navegarResumoMensal() {
		getDriver().findElement(By.xpath("//a[.='Resumo Mensal']")).click();
	}
	
	public void navegarAdicionarConta() {
		getDriver().findElement(By.xpath("//*[.='Contas ']")).click();
	//	WebDriverWait wait = new WebDriverWait(getDriver(), 5);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Adicionar")));
		getDriver().findElement(By.linkText("Adicionar")).click();
	}
	
	public void navegarListarConta() {
		getDriver().findElement(By.xpath("//*[.='Contas ']")).click();
	//	WebDriverWait wait = new WebDriverWait(getDriver(), 5);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Adicionar")));
		getDriver().findElement(By.linkText("Listar")).click();
	}

}
