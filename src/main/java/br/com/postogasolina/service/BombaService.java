package br.com.postogasolina.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
	private BombaRepository repository;
	
	/**
	 * Busca uma Bomba por Id
	 * 
	 * @param id
	 * @return Bomba
	 */
	public Bomba findById( Long id )  {	
		Optional<Bomba> obj = repository.findById(id);	
		return obj.orElseThrow( () -> new ObjectNotFoundException(
				"Objeto n�o encontrato! Id: " + id + ", Tipo: " + Bomba.class.getName()) );
	}
	
	/**
	 * Busca todos as bombas
	 * 
	 * @return List<Bomba> 
	 */
	public List<Bomba> findAll() {
		return repository.findAll();
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
		return this.repository.save(bomba);
	}
	
	/**
	 * Atualiza uma Bomba
	 * 
	 * @param id - Long
	 * @param obj - Bomba
	 * @return Bomba
	 */
	public Bomba update( Bomba obj ) {
		Bomba newObj = findById(obj.getId());
		return repository.save(newObj);
	}
	
	/**
	 * Deleta um Posto
	 * 
	 * @param id
	 */
	public void delete( Long id ) {
		findById(id);
		try {
			repository.deleteById(id);
		} catch ( DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException
			( "Posto não pode ser deletado! Possue Abastecimentos associados." );
		}
	}

}
