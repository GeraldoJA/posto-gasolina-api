package br.com.postogasolina.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdemExecucaoTests {
	
	@Autowired
	private VeiculoServiceTest veiculoServiceTest;
	
	@Autowired
	private CombustivelServiceTest combustivelServiceTest;
	
	@Autowired
	private PostoServiceTest postoServiceTest;
	
	@Autowired
	private BombaServiceTest bombaServiceTest;
	
	@Autowired
	private AbastecimentoServiceTest abastecimentoServiceTest;
	
	
	public void iniciarTestIntegracaoBaseDados() {
		
		this.veiculoServiceTest.iniciar();
		this.combustivelServiceTest.iniciar();
		this.postoServiceTest.iniciar();
		this.bombaServiceTest.iniciar();
		this.abastecimentoServiceTest.iniciar();
	}
	

}
