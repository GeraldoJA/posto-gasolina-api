package br.com.postogasolina.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.postogasolina.domain.Combustivel;
import br.com.postogasolina.domain.TipoCombustivel;
import br.com.postogasolina.service.CombustivelService;

/**
 * @author Geraldo jorge - candidato5
 * 		   email: geraldo.gja@gmail.com
 */
@Service
public class CombustivelServiceTest {

	@Autowired
	private CombustivelService combustivelService;
	
	public void iniciar() {
		createCombustivel();
	}
	
	private void createCombustivel() {
		
		Combustivel c1 = new Combustivel(null, TipoCombustivel.GASOLINA_COMUM);
		Combustivel c2 = new Combustivel(null, TipoCombustivel.ALCOOL);
		this.combustivelService.create(c1);
		this.combustivelService.create(c2);
	}
	
}
