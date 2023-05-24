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

import br.com.postogasolina.domain.Bomba;
import br.com.postogasolina.domain.Combustivel;
import br.com.postogasolina.domain.Posto;
import br.com.postogasolina.service.BombaService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/bombas")
public class BombaResource {

	@Autowired
	private BombaService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Bomba> findById(@PathVariable Long id) {	
		
		Bomba obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity< List<Bomba> > findAll() {
		
		List<Bomba> list = service.findAll();

		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<Bomba> create( @Valid @RequestBody Bomba obj, 
										 @RequestBody Combustivel combustivel, 
										 @RequestBody Posto posto ) {
		
		obj= service.create(obj, combustivel, posto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand( obj.getId() ).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Bomba> update( @Valid @RequestBody Bomba objDto ) {
		
		Bomba newObj = service.update(objDto);
		
		return ResponseEntity.ok().body( newObj );
	}
	
	@PatchMapping(value = "/{id}")
	public ResponseEntity<Bomba> updatePatch( @Valid @RequestBody Bomba obj ) {
		
		Bomba newObj = service.update(obj);
		
		return ResponseEntity.ok().body( newObj );
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete( @PathVariable Long id ){
		
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
}
