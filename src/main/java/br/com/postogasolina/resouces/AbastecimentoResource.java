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

import br.com.postogasolina.domain.Abastecimento;
import br.com.postogasolina.domain.Bomba;
import br.com.postogasolina.domain.Veiculo;
import br.com.postogasolina.service.AbastecimentoService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/abastecimentos")
public class AbastecimentoResource {

	@Autowired
	private AbastecimentoService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Abastecimento> findById(@PathVariable Long id) {	
		
		Abastecimento obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity< List<Abastecimento> > findAll() {
		
		List<Abastecimento> list = service.findAll();

		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<Abastecimento> create( @Valid @RequestBody Bomba bomba, 
										 @RequestBody Veiculo veiculo, 
										 @RequestBody Double qtdLitros ) {
		
		Abastecimento abt = service.create(bomba, veiculo, qtdLitros);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand( abt.getId() ).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Abastecimento> update( @Valid @RequestBody Abastecimento obj ) {
		
		Abastecimento newObj = service.update(obj);
		
		return ResponseEntity.ok().body( newObj );
	}
	
	@PatchMapping(value = "/{id}")
	public ResponseEntity<Abastecimento> updatePatch( @Valid @RequestBody Abastecimento obj ) {
		
		Abastecimento newObj = service.update(obj);
		
		return ResponseEntity.ok().body( newObj );
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete( @PathVariable Long id ){
		
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
}
