package br.com.postogasolina.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.postogasolina.domain.Veiculo;
import br.com.postogasolina.repositories.VeiculoRepository;
import br.com.postogasolina.service.exception.ObjectNotFoundException;

/**
 * Classe para acessos aos serviços referente à entidade Veículo.
 * 
 * @author Geraldo jorge - candidato5
 * 		   email: geraldo.gja@gmail.com
 */
@Service
public class VeiculoService {
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	/**
	 * Busca um Veiculo por Id
	 * 
	 * @param id
	 * @return Veiculo
	 */
	public Veiculo findById( Long id )  {	
		Optional<Veiculo> obj = veiculoRepository.findById(id);	
		return obj.orElseThrow( () -> new ObjectNotFoundException(
				"Objeto n�o encontrato! Id: " + id + ", Tipo: " + Veiculo.class.getName()) );
	}
	
	/**
	 * Busca todos os Veiculos
	 * 
	 * @return List<Veiculo> 
	 */
	public List<Veiculo> findAll() {
		return veiculoRepository.findAll();
	}
	
	/**
	 * Cria um veiculo
	 * 
	 * @param veiculo
	 * @return Veiculo
	 */
	public Veiculo create( Veiculo veiculo ) {
		return this.veiculoRepository.save(veiculo);
	}
	
	/**
	 * Atualiza um veiculo
	 * 
	 * @param id
	 * @param veiculo
	 * @return Veiculo
	 */
	public Veiculo update(Long id, Veiculo veiculo) {
		
		Veiculo obj = findById(id);
		obj.setModelo( veiculo.getModelo() );
		obj.setNome( veiculo.getNome() );
		
		return veiculoRepository.save(obj);
	}
	
	/**
	 * Deleta um veiculo
	 * 
	 * @param id
	 */
	public void delete( Long id ) {
		findById(id);	
		veiculoRepository.deleteById(id);		
	}

}
