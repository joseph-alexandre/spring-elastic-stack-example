package br.com.helgardh.springelasticstack.controller;


import br.com.helgardh.springelasticstack.domain.v1.vo.PersonVO;
import br.com.helgardh.springelasticstack.service.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/persons")
public class PersonController {

	private PersonServiceImpl service;

	@Autowired
	public PersonController(PersonServiceImpl service) {
		this.service = service;
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<PersonVO>> findAll(Pageable pageable) {
		return ResponseEntity.ok(service.findAll(pageable));
	}

	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PersonVO> findById(@PathVariable String id) {
		return ResponseEntity.ok(service.findById(id));
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PersonVO> create(@RequestBody PersonVO vo){
		return ResponseEntity.ok().body(service.save(vo));
	}

	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PersonVO> update(@PathVariable String id, @RequestBody PersonVO vo) {
		return ResponseEntity.ok().body(service.update(id, vo));
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(path = "/{id}")
	public void delete(@PathVariable String id) {
		service.delete(id);
	}
}
