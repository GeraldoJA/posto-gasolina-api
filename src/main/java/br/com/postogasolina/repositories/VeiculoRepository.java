package br.com.postogasolina.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.postogasolina.domain.Veiculo;

/**
 * Interface para acessos aos métodos JPA referente à entidade Veículo.
 * 
 * @author Geraldo jorge - candidato5
 * 		   email: geraldo.gja@gmail.com
 */
@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long>{
	
	@Query("select v from Veiculo v where v.qtdCombustivel < v.capacidadeTanque")
    List<Veiculo> buscarTodosNaoAbastecidos();

}
