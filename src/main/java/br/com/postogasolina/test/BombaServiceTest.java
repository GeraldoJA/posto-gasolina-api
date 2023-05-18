package br.com.postogasolina.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.postogasolina.domain.Bomba;
import br.com.postogasolina.domain.Combustivel;
import br.com.postogasolina.domain.Posto;
import br.com.postogasolina.domain.TipoCombustivel;
import br.com.postogasolina.service.BombaService;
import br.com.postogasolina.service.CombustivelService;
import br.com.postogasolina.service.PostoService;

/**
 * Classe para testar aos serviços referente ao service Bomba.
 * 
 * OBS: Deveria ser classes jUnit, mas tive problema com a IDE/versão Java.
 * 
 * @author Geraldo jorge - candidato5
 * 		   email: geraldo.gja@gmail.com
 */
@Service
public class BombaServiceTest {
	
	//PROVA: Velocidade de abastecimento da bomba de gasolina:10 litros / minuto
	private final Integer  VELOCIDADE_GASOLINA = 10; 
	//PROVA: Velocidade de abastecimento da bomba de álcool:12 litros / minuto
	private final Integer  VELOCIDADE_ALCOOL = 12; 
	
	//PROVA: O preço do litro de gasolina:R$ 2.90
	private final Double  PRECO_GASOLINA = 2.90; 
	//PROVA: O preço do litro de  álcool: R$ 2.27
	private final Double  PRECO_ALCOOL = 2.27; 
	
	@Autowired
	private BombaService bombaService;
	
	@Autowired
	private CombustivelService combustivelService;
	
	@Autowired
	private PostoService postoService;
	
	public void iniciar() {
		
		testaCreateBomba();
		testaBuscaDeBomba(); 
	}
	
	private void testaCreateBomba() {

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
		
		System.out.println("testa Create Bomba");
		System.out.println("");
		
	}
	
	private void testaBuscaDeBomba() {
		
		List<Bomba> list = this.bombaService.findAll();
		System.out.println("Busca todos");
		
		Bomba b1 = bombaService.findById(1L);
		
		System.out.println("testa Busca De Bombas");
		for (Bomba b : list) {
			System.out.println( b.getCombustivel().getTipoCombustivel() + " preço: " + b.getPreco() + " - posto: " + b.getPosto().getNome());			
		}
		System.out.println("Busca por ID");
		System.out.println( b1.getCombustivel().getTipoCombustivel() );
	}

}
