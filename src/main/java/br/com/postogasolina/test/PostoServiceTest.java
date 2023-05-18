package br.com.postogasolina.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.postogasolina.domain.Posto;
import br.com.postogasolina.service.PostoService;

/**
 * Classe para testar aos serviços referente ao service Posto.
 * 
 * OBS: Deveria ser classes jUnit, mas tive problema com a IDE/versão Java.
 * 
 * @author Geraldo jorge - candidato5
 * 		   email: geraldo.gja@gmail.com
 */
@Service
public class PostoServiceTest {

	@Autowired
	private PostoService postoService;
	
	public void iniciar() {
		
		testaCreatePosto();
		testaBuscaDePosto(); 
	}
	
	private void testaCreatePosto() {
		
		Posto p1 = new Posto( null, "posto Logus" );
		this.postoService.create(p1);
		
		System.out.println("testa Create Posto");
		System.out.println("");
	}
	
	private void testaBuscaDePosto() {
		
		Posto p = postoService.findById(1L);
		System.out.println("testa Busca De posto");
		System.out.println("Busca por ID");
		System.out.println( p.getId() + " nome: " + p.getNome()  );
	}

}
