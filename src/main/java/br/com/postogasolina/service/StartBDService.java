package br.com.postogasolina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.postogasolina.domain.Bomba;
import br.com.postogasolina.domain.Combustivel;
import br.com.postogasolina.domain.Posto;
import br.com.postogasolina.domain.TipoCombustivel;
import br.com.postogasolina.domain.Veiculo;

/**
 * Classe com objetivo de iniciar o BD com alguns dados.
 * 
 * @author Geraldo jorge - candidato5
 * 		   email: geraldo.gja@gmail.com
 */
@Service
public class StartBDService {
	
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
	
	public void iniciarBancoDeDados() {
		
		createVeiculo();
		createCombustivel();
		createPosto();
		createBomba();
		createAbastecimento();
	}
	
	private void createPosto() {
		
		Posto p1 = new Posto( null, "Posto Logus" );
		postoService.create(p1);
	}
	
	private void createCombustivel() {
		
		Combustivel c1 = new Combustivel(null, TipoCombustivel.GASOLINA_COMUM);
		Combustivel c2 = new Combustivel(null, TipoCombustivel.ALCOOL);
		combustivelService.create(c1);
		combustivelService.create(c2);
	}
	
	private void createVeiculo() {

		Veiculo v1 = new Veiculo(null, "Fiat", "Uno", "AAA111",10.0, 0.0);
		this.veiculoService.create(v1);
		
		Veiculo v2 = new Veiculo(null, "Fiat", "Palio", "BBB2222", 20.0, 0.0);
		this.veiculoService.create(v2);
		
		Veiculo v3 = new Veiculo(null, "Honda", "Civic", "CCC3333", 30.0, 0.0);
		this.veiculoService.create(v3);
		
		Veiculo v4 = new Veiculo(null, "Peugeot", "408", "DDD4444", 40.0, 0.0);
		this.veiculoService.create(v4);
		
		Veiculo v5 = new Veiculo(null, "Toyota", "Corola", "EEE5555", 50.0, 0.0);
		this.veiculoService.create(v5);
		
		Veiculo v6 = new Veiculo(null, "Toyota", "Hilux", "FFF6666", 60.0, 0.0);
		this.veiculoService.create(v6);
	}
	
	private void createBomba() {

		final Integer  VELOCIDADE_GASOLINA = 10; //PROVA: Velocidade de abastecimento da bomba de gasolina:10 litros / minuto
		final Integer  VELOCIDADE_ALCOOL = 12;  //PROVA: Velocidade de abastecimento da bomba de álcool:12 litros / minuto
		final Double  PRECO_GASOLINA = 2.90;  //PROVA: O preço do litro de gasolina:R$ 2.90
		final Double  PRECO_ALCOOL = 2.27;  //PROVA: O preço do litro de  álcool: R$ 2.27
		
		Combustivel c1 = combustivelService.findById(1L);
		Combustivel c2 = combustivelService.findById(2L);
		
		Posto p = postoService.findById(1L);
		
		if( c1.getTipoCombustivel() ==  TipoCombustivel.GASOLINA_COMUM  ) {
			Bomba b1 = new Bomba(null, PRECO_GASOLINA, VELOCIDADE_GASOLINA, c1, p);			
			this.bombaService.create(b1, c1, p);
		}
		if( c2.getTipoCombustivel() ==  TipoCombustivel.ALCOOL  ) {
			Bomba b2 = new Bomba(null, PRECO_ALCOOL, VELOCIDADE_ALCOOL, c2, p);
			this.bombaService.create(b2, c2, p);
		}	
	}
	
	private void createAbastecimento() {

		List<Veiculo> carros = this.veiculoService.findAll();	
		
		Bomba b1 = bombaService.findById(1L);
		Bomba b2 = bombaService.findById(2L);

		for ( int i = 0; i < carros.size(); i++ ) {
			Veiculo veiculo = carros.get(i);
			if(i == 2 )   //LIMITA EM 2 ABASTECIMENTOS
				break;
			
			double random = Math.random();
			
			if(random > 0.0 && random < 0.5)			
				this.abastecimentoService.create(b1, veiculo, Double.valueOf( veiculo.getCapacidadeTanque() ) );
			else if(random > 0.5 && random < 1.0)
				this.abastecimentoService.create(b2, veiculo, Double.valueOf( veiculo.getCapacidadeTanque() ));
			else {
				this.abastecimentoService.create(b1, veiculo, Double.valueOf( veiculo.getCapacidadeTanque() / 2) );
				this.abastecimentoService.create(b2, veiculo, Double.valueOf( veiculo.getCapacidadeTanque() / 2) );
			}
			
			veiculo.setQtdCombustivel( veiculo.getCapacidadeTanque() );
			veiculoService.update(veiculo.getId(), veiculo);
		}
	}	
	
}
