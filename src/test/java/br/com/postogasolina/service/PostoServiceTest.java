package br.com.postogasolina.service;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.postogasolina.domain.Posto;



@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT )
class PostoServiceTest {

	@Autowired
	private PostoService service;
	
	@Test
	@DisplayName("Deve criar um posto.")
	public void deveCriarUmPosto() {
		
		Posto obj = new Posto(null, "Posto GJA");
		obj = service.create(obj);
	
		Assertions.assertNotNull(obj);
	}
	
	@Test
	@DisplayName("Deve buscar um posto.")
	private void deveBuscarUmPosto() {
		
		List<Posto> list = service.findAll();

		Assertions.assertEquals("Posto GJA", list.get(1).getNome());
	}
}
