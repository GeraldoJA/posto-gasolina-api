package br.com.postogasolina.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.postogasolina.domain.Combustivel;
import br.com.postogasolina.repositories.CombustivelRepository;
import br.com.postogasolina.service.exception.ObjectNotFoundException;

/**
 * Classe de acesso aos serviçoss referente à entidade Combustível.
 * 
 * @author Geraldo jorge - candidato5
 * 		   email: geraldo.gja@gmail.com
 */
@Service
public class CombustivelService {
	
	@Autowired
	private CombustivelRepository repository;
	
	/**
	 * Busca um Combustivel por Id
	 * 
	 * @param id - Long
	 * @return Combustivel
	 */
	public Combustivel findById( Long id )  {	
		Optional<Combustivel> obj = repository.findById(id);	
		return obj.orElseThrow( () -> new ObjectNotFoundException(
				"Objeto não encontrato! Id: " + id + ", Tipo: " + Combustivel.class.getName()) );
	}
	
	/**
	 * Busca todos os combustivel
	 * 
	 * @return List<Combustivel> 
	 */
	public List<Combustivel> findAll() {
		return repository.findAll();
	}
	
	/**
	 * Cria um combustivel
	 * 
	 * @param combustivel - Combustivel
	 * @return Combustivel
	 */
	public Combustivel create( Combustivel combustivel ) {
		return this.repository.save(combustivel);
	}
	
	/**
	 * Atualiza um combustível
	 * 
	 * @param id - Long
	 * @param obj - Combustivel
	 * @return Combustivel
	 */
	public Combustivel update(Long id, Combustivel obj) {
		Combustivel newObj = findById(id);
		return repository.save(newObj);
	}
	
	/**
	 * Deleta um combustível
	 * @param id - Long
	 */
	public void delete(Long id) {
		Combustivel obj = findById(id);
		repository.delete(obj);
	}

}
