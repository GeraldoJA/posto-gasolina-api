package br.com.postogasolina.service;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.postogasolina.domain.Bomba;
import br.com.postogasolina.domain.Combustivel;
import br.com.postogasolina.domain.Posto;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT )
class BombaServiceTest {
	
	@Autowired
	private CombustivelService combustivelService;
	
	@Autowired
	private PostoService postoService;
	
	@Autowired
	private BombaService service;

	@Test
	@DisplayName("Deve criar uma bomba.")
	public void deveCriarUmaBomba() {
		
		List<Posto> listP = postoService.findAll();
		Posto posto = listP.get(0);
		
		List<Combustivel> listC = combustivelService.findAll();
		Combustivel combustivel = listC.get(0);
		
		Bomba obj = new Bomba(null, 5.0, 5, combustivel, posto);
		obj = service.create(obj, combustivel, posto);
	
		Assertions.assertNotNull(obj);
	}
	
	@Test
	@DisplayName("Deve buscar todas as bombas.")
	private void deveBuscarTodosAsBombas() {
		
		List<Bomba> list = this.service.findAll();

		Assertions.assertEquals(3, list.size());
	}
	
}
