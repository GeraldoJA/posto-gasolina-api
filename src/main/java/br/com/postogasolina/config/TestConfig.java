package br.com.postogasolina.config;

import java.util.List;

import javax.swing.SwingUtilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.postogasolina.gui.TelaCard;
import br.com.postogasolina.service.AbastecimentoService;
import br.com.postogasolina.service.BombaService;
import br.com.postogasolina.service.CombustivelService;
import br.com.postogasolina.service.PostoService;
import br.com.postogasolina.service.StartBDService;
import br.com.postogasolina.service.VeiculoService;

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
	private StartBDService startBDService;
	
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
	
	@Bean
	public void instanciaBD() {
	
		startBDService.iniciarBancoDeDados();
		
		iniciarTela();
		
		resumoSimulacao();
	}
	
	private void iniciarTela() {
		
		System.setProperty("java.awt.headless", "false");
		SwingUtilities.invokeLater(() -> {
	
			TelaCard frame = new TelaCard(postoService, veiculoService, combustivelService, bombaService, abastecimentoService);
			frame.setDefaultCloseOperation(TelaCard.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}
	
	private void resumoSimulacao() {
		
		List<String> list = abastecimentoService.relatorioCompletoAbastecimento();

		for (String string : list) {
			System.out.println(string);
		}
		
		System.out.println(" ");
		System.out.println(" ");
	}
	
}
