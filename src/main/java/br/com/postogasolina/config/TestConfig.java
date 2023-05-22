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
/*	
	@Autowired
	private PostoService postoService;
	
	@Autowired
	private VeiculoService veiculoService;
	
	@Autowired
	private CombustivelService combustivelService;
	
	@Autowired
	private BombaService bombaService;
	
	@Autowired
	private AbastecimentoService abastecimentoService;
	*/
	@Bean
	public void instanciaBD() {
	
		this.ordemExecucaoTests.iniciarTestIntegracaoBaseDados();
		
		//iniciarTela();
	}
	/*
	private void iniciarTela() {
		
		System.setProperty("java.awt.headless", "false");
		SwingUtilities.invokeLater(() -> {
	
			TelaCard frame = new TelaCard(postoService, veiculoService, combustivelService, bombaService, abastecimentoService);
			frame.setDefaultCloseOperation(TelaCard.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}
	*/
}
