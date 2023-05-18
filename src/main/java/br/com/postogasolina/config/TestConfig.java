package br.com.postogasolina.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.postogasolina.test.OrdemExecucaoTests;

/**
 * Interface para acessos aos métodos JPA referente à entidade Veículo.
 * 
 * @author Geraldo jorge - candidato5
 * 		   email: geraldo.gja@gmail.com
 */
@Configuration
@Profile("test")
public class TestConfig {


	@Autowired
	private OrdemExecucaoTests ordemExecucaoTests;
	
	@Bean
	public void instanciaBD() {
	
		this.ordemExecucaoTests.iniciarTestIntegracaoBaseDados();
	}
}
