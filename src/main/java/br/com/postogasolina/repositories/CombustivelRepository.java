package br.com.postogasolina.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.postogasolina.domain.Combustivel;

/**
 * Interface para acessos aos métodos JPA referente à entidade Combustível.
 * 
 * @author Geraldo jorge - candidato5
 * 		   email: geraldo.gja@gmail.com
 */
@Repository
public interface CombustivelRepository extends JpaRepository<Combustivel, Long>{

}
