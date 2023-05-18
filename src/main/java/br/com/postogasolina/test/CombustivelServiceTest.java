package br.com.postogasolina.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.postogasolina.domain.Combustivel;
import br.com.postogasolina.domain.TipoCombustivel;
import br.com.postogasolina.service.CombustivelService;

/**
 * Classe para testar aos serviços referente ao service Combustivel.
 * 
 * OBS: Deveria ser classes jUnit, mas tive problema com a IDE/versão Java.
 * 
 * @author Geraldo jorge - candidato5
 * 		   email: geraldo.gja@gmail.com
 */
@Service
public class CombustivelServiceTest {

	@Autowired
	private CombustivelService combustivelService;
	
	public void iniciar() {
		
		testaCreateCombustivel();
		testaBuscaDeCombustivel(); 
	}
	
	private void testaCreateCombustivel() {
		
		Combustivel c1 = new Combustivel(null, TipoCombustivel.GASOLINA_COMUM);
		Combustivel c2 = new Combustivel(null, TipoCombustivel.ALCOOL);
		this.combustivelService.create(c1);
		this.combustivelService.create(c2);
		
		System.out.println("testa Create Combustivel");
		System.out.println("");
	}
	
	private void testaBuscaDeCombustivel() {
		
		List<Combustivel> list = this.combustivelService.findAll();
		System.out.println("Busca todos");
		for (Combustivel c : list) {
			System.out.println( c.getTipoCombustivel() );			
		}
		
		Combustivel c = combustivelService.findById(1L);
		
		System.out.println("testa Busca De Combustivel");
		System.out.println("Busca por ID");
		System.out.println(c.getTipoCombustivel());
	}
}
