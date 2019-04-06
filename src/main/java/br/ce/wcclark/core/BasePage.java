package br.ce.wcclark.core;

import static br.ce.wcclark.core.DriverFactory.getDriver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage  {
	
	/********************** TextField ************************/
	public void escreverCampo(String id, String valor) {
		getDriver().findElement(By.id(id)).clear();
		getDriver().findElement(By.id(id)).sendKeys(valor);
	}
	

	/************************ Combobox **********************/
	public Select clicarValorCombobox(By by) {
		Select combo = new Select(getDriver().findElement(by));
		return combo;
	}
	
	public void clicarValorCombobox(String id, String valor_escolhido) {
		 Select combo = clicarValorCombobox(By.id(id));
		    List<WebElement> options = combo.getOptions();
		    combo.selectByVisibleText(valor_escolhido);
	}
	
	public String retornarValorComboBox(String id) {
		Select combo = new Select(getDriver().findElement(By.id(id)));
	    List<WebElement> options = combo.getOptions();
	    return combo.getFirstSelectedOption().getText();
	    
	}
	
	
	
	/********************** Botoes *****************************/
	public void clicarBotaoSalvar() {
		getDriver().findElement(By.xpath("//*[.='Salvar']")).click();

	}
	
	public void clicarBotaoBuscar() {
		getDriver().findElement(By.xpath("//*[@value='Buscar']")).click();

	}

	public void clicarRadio(String id) {
		getDriver().findElement(By.id(id)).click();

	}
	
public void clicarRemoverMovimentacao(String movimentacao) {
	 WebElement element = escolherElementoDuasColunasTabela("Descrição", movimentacao, "Ações", "tabelaExtrato");
	 element.findElement(By.xpath(".//span[@class='glyphicon glyphicon-remove-circle']")).click();
	}
	
public void clicarRemoverContaMovimentacao(String conta) {
	WebElement element = escolherElementoDuasColunasTabela("Conta", conta, "Ações", "tabelaContas");
	 element.findElement(By.xpath(".//span[@class='glyphicon glyphicon-remove-circle']")).click();
	}
	
	public void clicarAlterar() {
		getDriver().findElement(By.xpath("//*[@class='glyphicon glyphicon-edit']")).click();

	}
	
	
	
	
	/****************** validacoes ***************************/
	public String obterMensagemValidada(By by) {
		return getDriver().findElement(By.xpath("//*[@role='alert']")).getText();
	}
	
	//sobrecarga de metodo
	public String obterMensagemValidada() {
		return obterMensagemValidada(By.xpath("//*[@role='alert']"));
	}
	
	public List<WebElement> obterListaMensagens(){
		return getDriver().findElements(By.xpath("//div[@class='alert alert-danger']//li"));
	}
	
	public List<String> obterListaErros() {
		List<WebElement> erros = getDriver().findElements(By.xpath("//div[@class='alert alert-danger']//li"));
		List<String> retorno = new ArrayList<String>();
		for(WebElement erro: erros) {
			retorno.add(erro.getText());
		}
		return retorno;
		
	}
	
	public Boolean validarRadioSelecionada(String id) {
		return getDriver().findElement(By.id(id)).isSelected();
	}
	
	
	
	
	
	/******************************** Tabela ***************************************/
	
	public List<WebElement> verificarTabelaVazia(String id_tabela) {
		return getDriver().findElements(By.xpath("//*[@id='"+ id_tabela +"']/tbody/tr"));
	}
	
	public String validarContaTabelaConta(String conta) {
		//return getDriver().findElement(By.xpath("//*[.='"+ conta +"']")).getText();
		return escolherElementoUmaColunaTabela("Conta", conta, "tabelaContas").getText();
	}
	
	public String validarContaTabelaSaldo(String conta) {
		//return getDriver().findElement(By.xpath("//*[.='"+ conta +"']")).getText();
		return escolherElementoUmaColunaTabela("Conta", conta, "tabelaSaldo").getText();
	}
	
	public String validarContaTabelaMovimentacao(String conta) {
		//o alvo é sempre o terceiro parametro aqui de baixo, ou seja, descriçao
		//o gettext sera em cima do descricao
		return escolherElementoDuasColunasTabela("Conta", conta, "Descrição", "tabelaExtrato").getText();
	}
	
	public String obterSaldoConta(String conta) {
		return escolherElementoDuasColunasTabela("Conta", conta, "Saldo", "tabelaSaldo").getText();
	}
	
	
	
	public WebElement escolherElementoUmaColunaTabela(String colunaBusca, String valor, String idTabela) {
		//captura a tabela desejada
		WebElement tabela = getDriver().findElement(By.xpath("//*[@id='"+ idTabela +"']"));
		//procurar coluna do registro
		int idColuna = obterIndiceColuna(colunaBusca, tabela);
		//procura linha do registro
		int idLinha = obterIndiceLinha(valor, tabela, idColuna);
		
		//clicar no botao da celular encontrada
		WebElement celula = tabela.findElement(By.xpath(".//tr["+idLinha+"]//td["+idColuna+"]"));
		
		return celula;
		//celula.findElement(By.xpath(".//input")).getText();
	}
	
	public WebElement escolherElementoDuasColunasTabela(String colunaBusca, String valor, String colunaBusca2, String idTabela) {
		//captura a tabela desejada
		WebElement tabela = getDriver().findElement(By.xpath("//*[@id='"+ idTabela +"']"));
		//procurar coluna do registro
		int idColuna = obterIndiceColuna(colunaBusca, tabela);
		//procura linha do registro
		int idLinha = obterIndiceLinha(valor, tabela, idColuna);
		//procurar coluna do botao
		int idColunaDesejada = obterIndiceColuna(colunaBusca2, tabela);
		
		//clicar no botao da celular encontrada
		WebElement celula = tabela.findElement(By.xpath(".//tr["+idLinha+"]//td["+idColunaDesejada+"]"));
		
		return celula;
		//celula.findElement(By.xpath(".//input")).getText();
	}

	
	protected int obterIndiceColuna(String colunaBusca, WebElement tabela) {
		//pega o título de cada coluna
				List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
				//se for -1, quer dizer que eu nao encontrei
				int idColuna = -1;
				//se o valor do int for de 0 para cima, quer dizer que eu encontrei o que estava procurando
				for(int i = 0; i < colunas.size(); i++) {
					if(colunas.get(i).getText().equals(colunaBusca)) {
						//i+1 porque o indice no xpath nao começa em 0
						idColuna = i+1;
						break;
					}
				}
				return idColuna;
	}

	private int obterIndiceLinha(String valor, WebElement tabela, int idColuna) {
		//encontrar linha do registro
		List<WebElement> linhas = tabela.findElements(By.xpath("./tbody/tr/td["+idColuna+"]"));
		int idLinha = -1;
		//se o valor do int for de 0 para cima, quer dizer que eu encontrei o que estava procurando
		for(int i = 0; i < linhas.size(); i++) {
			if(linhas.get(i).getText().equals(valor)) {
				//i+1 porque o indice no xpath nao começa em 0
				idLinha = i+1;
				break;
			}
		}
		return idLinha;
	}
	
	
	
}
