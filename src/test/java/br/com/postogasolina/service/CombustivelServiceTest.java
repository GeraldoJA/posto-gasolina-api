package br.com.postogasolina.service;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.postogasolina.domain.Combustivel;
import br.com.postogasolina.domain.TipoCombustivel;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT )
class CombustivelServiceTest {

	@Autowired
	private CombustivelService service;
	
	@Test
	@DisplayName("Deve criar um combustível.")
	public void deveCriarUmCombustivel() {
		
		Combustivel c1 = new Combustivel(null, TipoCombustivel.GASOLINA_COMUM);
		c1 = service.create(c1);
	
		Assertions.assertNotNull(c1);
	}
	
	@Test
	@DisplayName("Deve buscar todos os combustíveis.")
	private void deveBuscarTodosOsCombustiveis() {
		
		List<Combustivel> list = this.service.findAll();

		Assertions.assertEquals(3, list.size());
	}
	
}
