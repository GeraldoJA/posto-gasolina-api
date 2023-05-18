package br.com.postogasolina.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.postogasolina.domain.Bomba;
import br.com.postogasolina.domain.Combustivel;
import br.com.postogasolina.domain.Posto;
import br.com.postogasolina.repositories.BombaRepository;
import br.com.postogasolina.service.exception.ObjectNotFoundException;

/**
 * 
 * Classe para acessos aos serviços referente à entidade Bomba.
 * 
 * @author Geraldo jorge - candidato5
 * 		   email: geraldo.gja@gmail.com
 */
@Service
public class BombaService {

	@Autowired
	private BombaRepository bombaRepository;
	
	/**
	 * Busca uma Bomba por Id
	 * 
	 * @param id
	 * @return Bomba
	 */
	public Bomba findById( Long id )  {	
		Optional<Bomba> obj = bombaRepository.findById(id);	
		return obj.orElseThrow( () -> new ObjectNotFoundException(
				"Objeto n�o encontrato! Id: " + id + ", Tipo: " + Bomba.class.getName()) );
	}
	
	/**
	 * Busca todos as bombas
	 * 
	 * @return List<Bomba> 
	 */
	public List<Bomba> findAll() {
		return bombaRepository.findAll();
	}
	
	/**
	 * Cria uma Bomba
	 * 
	 * @param bomba
	 * @param conbustivel
	 * @param posto
	 * @return
	 */
	public Bomba create( Bomba bomba, Combustivel conbustivel, Posto posto  ) {
		bomba.setCombustivel(conbustivel);
		bomba.setPosto(posto);
		return this.bombaRepository.save(bomba);
	}
}
