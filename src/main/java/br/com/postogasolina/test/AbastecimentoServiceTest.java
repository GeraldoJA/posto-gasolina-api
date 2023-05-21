package br.com.postogasolina.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.postogasolina.domain.Abastecimento;
import br.com.postogasolina.domain.Bomba;
import br.com.postogasolina.domain.Veiculo;
import br.com.postogasolina.service.AbastecimentoService;
import br.com.postogasolina.service.BombaService;
import br.com.postogasolina.service.VeiculoService;

/**
 * Classe para testar aos serviços referente ao service Abastecimento.
 * 
 * OBS: Deveria ser classes jUnit, mas tive problema com a IDE/versão Java.
 * 
 * @author Geraldo jorge - candidato5
 * 		   email: geraldo.gja@gmail.com
 */
@Service
public class AbastecimentoServiceTest {
	
	//@Autowired
//	private PostoService postoService;
	
	@Autowired
	private BombaService bombaService;
	
	@Autowired
	private VeiculoService veiculoService;
	
	@Autowired
	private AbastecimentoService abastecimentoService;
	
	public void iniciar() {
		
		testaCreateAbastecimento();
		testaBuscaDeAbastecimentos(); 
		resumoSimulacao();
	}
	
	private void testaCreateAbastecimento() {

		List<Veiculo> carros = this.veiculoService.findAll();	
		
		Bomba b1 = bombaService.findById(1L);
		Bomba b2 = bombaService.findById(2L);

		for (Veiculo veiculo : carros) {
			double random = Math.random();
			
			if(random > 0.0 && random < 0.5)			
				this.abastecimentoService.create(b1, veiculo, Double.valueOf( veiculo.getCapacidadeTanque() ) );
			else if(random > 0.5 && random < 1.0)
				this.abastecimentoService.create(b2, veiculo, Double.valueOf( veiculo.getCapacidadeTanque() ));
			else {
				this.abastecimentoService.create(b1, veiculo, Double.valueOf( veiculo.getCapacidadeTanque() -5) );
				this.abastecimentoService.create(b2, veiculo, Double.valueOf( veiculo.getCapacidadeTanque() +5) );
			}
		}
			
		System.out.println("testa Create Abastecimento");
		System.out.println("");	
	}
	
	private void testaBuscaDeAbastecimentos() {
		
		List<Abastecimento> list = this.abastecimentoService.findAll();
		System.out.println("Busca todos");
		
		Abastecimento a1 = abastecimentoService.findById(1L);
		
		System.out.println("testa Busca De Bombas");
		for (Abastecimento a : list) {
			System.out.println( a1.getVeiculo() + " valor: " + a.getValor() + " quantidade: " + a1.getQuantidadeLitros());			
		}
		System.out.println("testa Busca De Abastecimentos");
		System.out.println( a1.getDate() + " quantidade: " + a1.getQuantidadeLitros() );
	}
	
	public void resumoSimulacao() {
		
		List<String> list = abastecimentoService.relatorioCompletoAbastecimento();

		for (String string : list) {
			System.out.println(string);
		}
		
		System.out.println(" ");
		System.out.println(" ");
	}

}
