package br.com.postogasolina.service;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.postogasolina.domain.Abastecimento;
import br.com.postogasolina.domain.Bomba;
import br.com.postogasolina.domain.Veiculo;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT )
class AbastecimentoServiceTest {

	@Autowired
	private BombaService bombaService;
	
	@Autowired
	private VeiculoService veiculoService;
	
	@Autowired
	private AbastecimentoService service;

	@Test
	@DisplayName("Deve criar uma bomba.")
	public void deveCriarUmaBomba() {
		
		List<Bomba> listB = bombaService.findAll();
		Bomba bomba = listB.get(0);
		
		List<Veiculo> listV = veiculoService.findAll();
		Veiculo veiculo = listV.get( listV.size() - 1 );
		Double qtdLitros = Double.valueOf( veiculo.getCapacidadeTanque() );
		
		Abastecimento obj =service.create(bomba, veiculo, qtdLitros);
		
		Assertions.assertNotNull(obj);
	}
	
	@Test
	@DisplayName("Deve buscar todas as bombas.")
	private void deveBuscarTodosAsBombas() {
		
		List<Abastecimento> list = this.service.findAll();

		Assertions.assertEquals(3, list.size());
	}
}
