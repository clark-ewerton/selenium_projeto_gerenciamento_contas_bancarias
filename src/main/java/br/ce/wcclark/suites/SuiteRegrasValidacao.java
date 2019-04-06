package br.ce.wcclark.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.ce.wcclark.regrasValidacoes.TesteRegrasAlterarConta;
import br.ce.wcclark.regrasValidacoes.TesteRegrasCriarMovimentacao;
import br.ce.wcclark.regrasValidacoes.TesteRegrasInserirConta;
import br.ce.wcclark.regrasValidacoes.TesteRegrasLogin;

@RunWith(Suite.class)
@SuiteClasses({
	TesteRegrasLogin.class,
	TesteRegrasAlterarConta.class,
	TesteRegrasInserirConta.class,
	TesteRegrasCriarMovimentacao.class
	
})
public class SuiteRegrasValidacao {

}
