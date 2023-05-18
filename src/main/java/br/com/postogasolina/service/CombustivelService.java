package br.com.postogasolina.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.postogasolina.domain.Combustivel;
import br.com.postogasolina.repositories.CombustivelRepository;
import br.com.postogasolina.service.exception.ObjectNotFoundException;

/**
 * Classe para acessos aos serviços referente à entidade Combustível.
 * 
 * @author Geraldo jorge - candidato5
 * 		   email: geraldo.gja@gmail.com
 */
@Service
public class CombustivelService {
	
	@Autowired
	private CombustivelRepository combustivelRepository;
	
	/**
	 * Busca um Combustivel por Id
	 * 
	 * @param id
	 * @return Combustivel
	 */
	public Combustivel findById( Long id )  {	
		Optional<Combustivel> obj = combustivelRepository.findById(id);	
		return obj.orElseThrow( () -> new ObjectNotFoundException(
				"Objeto n�o encontrato! Id: " + id + ", Tipo: " + Combustivel.class.getName()) );
	}
	
	/**
	 * Busca todos os combustivel
	 * 
	 * @return List<Combustivel> 
	 */
	public List<Combustivel> findAll() {
		return combustivelRepository.findAll();
	}
	
	/**
	 * Cria um Combustivel
	 * 
	 * @param vombustivel
	 * @return Combustivel
	 */
	public Combustivel create( Combustivel combustivel ) {
		return this.combustivelRepository.save(combustivel);
	}

}
