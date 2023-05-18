package br.com.postogasolina.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.postogasolina.domain.Abastecimento;
import br.com.postogasolina.domain.Bomba;
import br.com.postogasolina.domain.TipoCombustivel;
import br.com.postogasolina.domain.Veiculo;
import br.com.postogasolina.repositories.AbastecimentoRepository;
import br.com.postogasolina.service.exception.ObjectNotFoundException;

/**
 * 
 * Classe para acessos aos serviÃ§os referente Ã  entidade Abastecimento.
 * 
 * @author Geraldo jorge - candidato5
 * 		   email: geraldo.gja@gmail.com
 */
@Service
public class AbastecimentoService {
	
	@Autowired
	private AbastecimentoRepository abastecimentoRepository;
	
	/**
	 * Busca uma Abastecimento por Id
	 * 
	 * @param id
	 * @return Abastecimento
	 */
	public Abastecimento findById( Long id )  {	
		Optional<Abastecimento> obj = abastecimentoRepository.findById(id);	
		return obj.orElseThrow( () -> new ObjectNotFoundException(
				"Objeto não encontrato! Id: " + id + ", Tipo: " + Abastecimento.class.getName()) );
	}
	
	/**
	 * Busca todos os abastecimentos
	 * 
	 * @return List<Abastecimento> 
	 */
	public List<Abastecimento> findAll() {
		return abastecimentoRepository.findAll();
	}
	
	/**
	 * Cria um Abastecimento
	 * 
	 * @param abastecimento
	 * @return Abastecimento
	 */
	public Abastecimento create( Bomba bomba, Veiculo veiculo, Double qtdLitros ) {
		
		Abastecimento abastecimento = new Abastecimento();
		abastecimento.setBomba(bomba);
		abastecimento.setVeiculo(veiculo);
		abastecimento.setDate( new Date() );
		abastecimento.setQuantidadeLitros(qtdLitros);
		abastecimento.setValor(qtdLitros * bomba.getPreco());
		
		return this.abastecimentoRepository.save(abastecimento);
	}
	
	public List<String> resumoAbastecimento() {
			
		Double totalLitrosEtanal = 0.0;
		Double totalVendidoEtanal = 0.0;
		Double totalTempoAbastecendoEtanol = 0.0;
		
		Double totalLitrosGasolina = 0.0;
		Double totalVendidoGasolina = 0.0;
		Double totalTempoAbastecendoGasolina = 0.0;
			
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy-hh:mm");	
		List<String> list = new ArrayList<String>();
		list.add("\n ##### ABASTECIMETNOS ##### \n");
				
		List<Abastecimento> listA = findAll();
		for (Abastecimento a : listA) {	
			
			String data = "Data: " + formatter.format(a.getDate());
			String infoCarro = a.getVeiculo().getModelo() + " " + a.getVeiculo().getNome() + ", placa " +  a.getVeiculo().getPlaca();
			String infoConbustivel = " foi abastecido com " + a.getQuantidadeLitros() + " de " + a.getBomba().getCombustivel().getTipoCombustivel();
			list.add(data + " - Veículo: " + infoCarro + infoConbustivel);
			
			if(a.getBomba().getCombustivel().getTipoCombustivel() == TipoCombustivel.ALCOOL ){
				totalLitrosEtanal += a.getValor();
				totalVendidoEtanal += a.getQuantidadeLitros();
				totalTempoAbastecendoEtanol =+ a.getQuantidadeLitros() / a.getBomba().getVelocidadeAbastecimento(); 
			}else if(a.getBomba().getCombustivel().getTipoCombustivel() == TipoCombustivel.GASOLINA_COMUM ) {
				totalLitrosGasolina += a.getValor();
				totalVendidoGasolina += a.getQuantidadeLitros();
				totalTempoAbastecendoGasolina =+ a.getQuantidadeLitros() / a.getBomba().getVelocidadeAbastecimento();
			}
		}
		
		list.add("\n ##### RESUMO DA SIMULAÇÃO ##### \n ");
		list.add("Total de litros de ETANOL abasteido = " + totalLitrosEtanal);
		list.add("Total de vendido de ETANOL = " + totalVendidoEtanal);
		list.add("Total de duranção abastecendo ETANOL = " + totalTempoAbastecendoEtanol);
		
		list.add("Total de litros de GASOLINA abasteido = " + totalLitrosGasolina);
		list.add("Total de vendido de GASOLINA = " + totalVendidoGasolina);
		list.add("Total de duranção abastecendo GASOLINA = " + totalTempoAbastecendoGasolina);		

		return list;
	}

}
