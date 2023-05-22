package br.com.postogasolina.service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.postogasolina.domain.Abastecimento;
import br.com.postogasolina.domain.Bomba;
import br.com.postogasolina.domain.TipoCombustivel;
import br.com.postogasolina.domain.Veiculo;
import br.com.postogasolina.dto.AbastecimentoDTO;
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
	
	
	public List<String> relatorioCompletoAbastecimento() {
			
		Double totalLitrosEtanal = 0.0;
		Double totalVendidoEtanal = 0.0;
		Double totalTempoAbastecendoEtanol = 0.0;
		
		Double totalLitrosGasolina = 0.0;
		Double totalVendidoGasolina = 0.0;
		Double totalTempoAbastecendoGasolina = 0.0;
			
		Double totalLitrosOutros = 0.0;
		Double totalVendidoOutros = 0.0;
		Double totalTempoAbastecendoOutros = 0.0;
		
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
			}else {
				totalLitrosOutros += a.getQuantidadeLitros();
				totalVendidoOutros += a.getValor();
				totalTempoAbastecendoOutros += a.getQuantidadeLitros() / a.getBomba().getVelocidadeAbastecimento();
			}
		}
		
		list.add("\n ##### RESUMO DA SIMULAÇÃO ##### \n ");
		list.add("Total de litros de ETANOL abasteido = " + totalLitrosEtanal);
		list.add("Total de vendido de ETANOL = " + totalVendidoEtanal);
		list.add("Tempoo abastecendo ETANOL = " + totalTempoAbastecendoEtanol);
		
		list.add("Total de litros de GASOLINA abasteido = " + totalLitrosGasolina);
		list.add("Total de vendido de GASOLINA = " + totalVendidoGasolina);
		list.add("Tempo abastecendo GASOLINA = " + totalTempoAbastecendoGasolina);		
		
		list.add("Total de litros de OUTROS COMBUSTÍVEIS abasteido = " + totalLitrosOutros);
		list.add("Total de vendido de OUTROS COMBUSTÍVEIS = " + totalVendidoOutros);
		list.add("Tempo abastecendo OUTROS COMBUSTÍVEIS = " + totalTempoAbastecendoOutros);	

		return list;
	}
	
	
	
	public HashMap<String,Object> resumoAbastecimento() {
		
		Double totalLitrosEtanal = 0.0;
		Double totalVendidoEtanal = 0.0;
		Double totalTempoAbastecendoEtanol = 0.0;
		
		Double totalLitrosGasolina = 0.0;
		Double totalVendidoGasolina = 0.0;
		Double totalTempoAbastecendoGasolina = 0.0;
		
		Double totalLitrosOutros = 0.0;
		Double totalVendidoOutros = 0.0;
		Double totalTempoAbastecendoOutros = 0.0;
			
		HashMap<String,Object> params = new HashMap<String,Object>();	
						
		List<Abastecimento> listA = findAll();
		for (Abastecimento a : listA) {	
			
			if(a.getBomba().getCombustivel().getTipoCombustivel() == TipoCombustivel.ALCOOL ){
				totalLitrosEtanal += a.getQuantidadeLitros();
				totalVendidoEtanal += a.getValor();
				totalTempoAbastecendoEtanol =+ a.getQuantidadeLitros() / a.getBomba().getVelocidadeAbastecimento(); 
			}else if(a.getBomba().getCombustivel().getTipoCombustivel() == TipoCombustivel.GASOLINA_COMUM ) {
				totalLitrosGasolina += a.getQuantidadeLitros();
				totalVendidoGasolina += a.getValor();
				totalTempoAbastecendoGasolina =+ a.getQuantidadeLitros() / a.getBomba().getVelocidadeAbastecimento();
			}else {
				totalLitrosOutros += a.getQuantidadeLitros();
				totalVendidoOutros += a.getValor();
				totalTempoAbastecendoOutros += a.getQuantidadeLitros() / a.getBomba().getVelocidadeAbastecimento();
			}
		}
		
		params.put( "totalLitrosEtanal", 
				"Total de litros de ETANOL abasteido = " + new DecimalFormat(".##").format(totalLitrosEtanal) );
		params.put( "totalVendidoEtanal", 
				"Total de vendido de ETANOL = " + new DecimalFormat(".##").format(totalVendidoEtanal) );
		params.put( "totalTempoAbastecendoEtanol", 
				"Tempo abastecendo ETANOL = " + new DecimalFormat(".##").format(totalTempoAbastecendoEtanol)  + " minutos");
		
		params.put( "totalLitrosGasolina", 
				"Total de litros de GASOLINA abasteido = " + new DecimalFormat(".##").format(totalLitrosGasolina) );
		params.put( "totalVendidoGasolina", 
				"Total de vendido de GASOLINA = " + new DecimalFormat(".##").format(totalVendidoGasolina) );
		params.put( "totalTempoAbastecendoGasolina", 
				"Tempo abastecendo GASOLINA = " + new DecimalFormat(".##").format(totalTempoAbastecendoGasolina)  + " minutos");		
		
		params.put( "totalLitrosOutros", 
				"Total de litros de OUTROS COMBUSTÍVEIS abasteido = " + new DecimalFormat(".##").format(totalLitrosOutros) );
		params.put( "totalVendidoOutros", 
				"Total de vendido de OUTROS COMBUSTÍVEIS = " + new DecimalFormat(".##").format(totalVendidoOutros) );
		params.put( "totalTempoAbastecendoOutros", 
				"Tempo abastecendo OUTROS COMBUSTÍVEIS = " + new DecimalFormat(".##").format(totalTempoAbastecendoOutros)  + " minutos");	

		return params;
	}
	
	public List<AbastecimentoDTO> prepararAbastecimentoDTO() {

		List<AbastecimentoDTO> listaAbastecimentoDTO = new ArrayList<AbastecimentoDTO>();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");	

		List<Abastecimento> listA = findAll();
		for (Abastecimento a : listA) {	
					
			String data = formatter.format(a.getDate());
			String placa = a.getVeiculo().getPlaca();
			String infoCarro = a.getVeiculo().getModelo() + " " + a.getVeiculo().getNome() + ", placa " + placa;
			String descricao = " Abasteceu " + a.getQuantidadeLitros() + " de litros de " + a.getBomba().getCombustivel().getTipoCombustivel();
		
			AbastecimentoDTO dto = new AbastecimentoDTO();
			dto.setData(data);
			dto.setInfoCarro(infoCarro);
			dto.setPlaca(placa);
			dto.setDescricao(descricao);
			dto.setValorGasto( a.getValor() );
				
			if(a.getBomba().getCombustivel().getTipoCombustivel() == TipoCombustivel.ALCOOL ){
				dto.setQtdAlcool(a.getQuantidadeLitros());
				dto.setQtdGasolina( 0.0 );
			}else if(a.getBomba().getCombustivel().getTipoCombustivel() == TipoCombustivel.GASOLINA_COMUM ) {
				dto.setQtdAlcool( 0.0 );
				dto.setQtdGasolina(a.getQuantidadeLitros());
			}

			listaAbastecimentoDTO.add(dto);
		}
		
		return listaAbastecimentoDTO;
	}

}
