package br.com.postogasolina.service;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.postogasolina.domain.Veiculo;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT )
class VeiculoServiceTest {

	@Autowired
	private VeiculoService service;
	
	@Test
	@DisplayName("Deve criar um veiculo.")
	public void deveCriarUmVeiculo() {
		
		Veiculo obj = new Veiculo(null, "Chevrolet", "Astra", "GGG7777", 55.0, 0.0);
		obj = service.create(obj);
	
		Assertions.assertNotNull(obj);
	}
	
	@Test
	@DisplayName("Deve buscar todos os veículos.")
	private void deveBuscarTodosOsVeiculos() {
		
		List<Veiculo> list = this.service.findAll();

		Assertions.assertEquals(7, list.size());
	}

}
