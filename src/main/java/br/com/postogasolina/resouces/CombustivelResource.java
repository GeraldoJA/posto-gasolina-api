package br.com.postogasolina.resouces;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.postogasolina.domain.Combustivel;
import br.com.postogasolina.service.CombustivelService;


@CrossOrigin("*")
@RestController
@RequestMapping(value = "/combustiveis")
public class CombustivelResource {

	@Autowired
	private CombustivelService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Combustivel> findById(@PathVariable Long id) {	
		
		Combustivel obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity< List<Combustivel> > findAll( ) {
		
		List<Combustivel> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Combustivel> update( @PathVariable Long id, @Valid @RequestBody Combustivel obj ) {
		
		Combustivel newObj = service.update(id, obj);
		return ResponseEntity.ok().body( newObj );
	}
	
	@PatchMapping(value = "/{id}")
	public ResponseEntity<Combustivel> updatePatch( @PathVariable Long id, @Valid @RequestBody Combustivel obj ) {
		
		Combustivel newObj = service.update(id, obj);
		return ResponseEntity.ok().body( newObj );
	}
	
	@PostMapping
	public ResponseEntity<Combustivel> create ( @Valid @RequestBody Combustivel obj ) {
		
		Combustivel newObj = service.create( obj );
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/combustiveis/{id}")
				  .buildAndExpand( newObj.getId() ).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete( @PathVariable Long id ){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
