package br.com.postogasolina.resouces;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.postogasolina.domain.Veiculo;
import br.com.postogasolina.service.VeiculoService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/veiculos")
public class VeiculoResource {
	
	@Autowired
	private VeiculoService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Veiculo> findById(@PathVariable Long id) {	
		
		Veiculo obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity< List<Veiculo> > findAll( ) {
		
		List<Veiculo> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/naoAbastecidos")
	public ResponseEntity< List<Veiculo> > buscarTodosNaoAbastecidos( ) {
		
		List<Veiculo> list = service.buscarTodosNaoAbastecidos();
		return ResponseEntity.ok().body(list);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Veiculo> update( @PathVariable Long id, @Valid @RequestBody Veiculo obj ) {
		
		Veiculo newObj = service.update(id, obj);
		return ResponseEntity.ok().body( newObj );
	}
	
	@PatchMapping(value = "/{id}")
	public ResponseEntity<Veiculo> updatePatch( @PathVariable Long id, @Valid @RequestBody Veiculo obj ) {
		
		Veiculo newObj = service.update(id, obj);
		return ResponseEntity.ok().body( newObj );
	}
	
	@PostMapping
	public ResponseEntity<Veiculo> create ( @Valid @RequestBody Veiculo obj ) {
		
		Veiculo newObj = service.create( obj );
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}")
				  .buildAndExpand( newObj.getId() ).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete( @PathVariable Long id ){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
