package br.com.postogasolina.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.postogasolina.domain.Posto;
import br.com.postogasolina.repositories.PostoRepository;
import br.com.postogasolina.service.exception.ObjectNotFoundException;

/**
 * 
 * Classe para acessos aos serviços referente à entidade Posto.
 * 
 * @author Geraldo jorge - candidato5
 * 		   email: geraldo.gja@gmail.com
 */
@Service
public class PostoService {

	@Autowired
	private PostoRepository repository;
	
	/**
	 * Busca um Posto por Id
	 * 
	 * @param id
	 * @return Posto
	 */
	public Posto findById( Long id )  {	
		Optional<Posto> obj = repository.findById(id);	
		return obj.orElseThrow( () -> new ObjectNotFoundException(
				"Objeto não encontrato! Id: " + id + ", Tipo: " + Posto.class.getName()) );
	}
	
	/**
	 * Busca todos os Postos
	 * 
	 * @return List<Posto> 
	 */
	public List<Posto> findAll() {
		return repository.findAll();
	}
	
	/**
	 * Cria um Posto
	 * 
	 * @param Posto
	 * @return Posto
	 */
	public Posto create( Posto posto ) {
		return this.repository.save(posto);
	}
	
	/**
	 * Atualiza uma Posto
	 * 
	 * @param id
	 * @param posto
	 * @return Posto
	 */
	public Posto update(Long id, Posto posto) {
		
		Posto obj = findById(id);
		obj.setBombas(posto.getBombas());
		obj.setNome(posto.getNome());
		
		return repository.save(obj);
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
