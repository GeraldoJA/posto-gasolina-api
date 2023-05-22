package br.com.postogasolina.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.postogasolina.domain.Veiculo;
import br.com.postogasolina.service.VeiculoService;

/**
 * Classe para testar aos serviços referente ao service Veiculo.
 * 
 * OBS: Deveria ser classes jUnit, mas tive problema com a IDE/versão Java.
 * 
 * @author Geraldo jorge - candidato5
 * 		   email: geraldo.gja@gmail.com
 */
@Service
public class VeiculoServiceTest {
	
	@Autowired
	private VeiculoService veiculoService;
	
	public void iniciar() {
		
		testaCreateVeiculo();
		testaBuscaDeVeiculos(); 
	}
	
	private void testaCreateVeiculo() {

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

		
		System.out.println("testa Create Veiculo");
		System.out.println("");
	}
	
	private void testaBuscaDeVeiculos() {
		
		List<Veiculo> list = this.veiculoService.findAll();
		System.out.println("Busca todos");
		for (Veiculo veiculo : list) {
			System.out.println(veiculo.getNome() + " placa: " + veiculo.getPlaca());			
		}
		
		Veiculo v = veiculoService.findById(1L);
		System.out.println("testa Busca De Veiculos");
		System.out.println("Busca por ID");
		System.out.println(v.getNome());
	}
	
}
