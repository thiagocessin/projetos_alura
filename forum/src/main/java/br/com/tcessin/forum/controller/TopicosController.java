package br.com.tcessin.forum.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.tcessin.forum.controller.dto.AtualizacaoTopicoForm;
import br.com.tcessin.forum.controller.dto.DetalhesTopicoDto;
import br.com.tcessin.forum.controller.dto.TopicoDto;
import br.com.tcessin.forum.controller.form.TopicoForm;
import br.com.tcessin.forum.modelo.Topico;
import br.com.tcessin.forum.repository.CursoRepository;
import br.com.tcessin.forum.repository.TopicoRepository;

@RestController
@RequestMapping(value = "/topicos")
public class TopicosController {

	@Autowired
	private TopicoRepository topicoRepository;

	@Autowired
	private CursoRepository cursoRepository;

	@GetMapping
	public List<TopicoDto> lista() {
		return TopicoDto.converter(topicoRepository.findAll());
	}

	@PostMapping
	@Transactional
	public ResponseEntity<TopicoDto> cadastrar(@RequestBody @Valid TopicoForm form, UriComponentsBuilder uriBuilder) {

		Topico topico = form.toEntity(cursoRepository);
		topicoRepository.save(topico);

		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

		return ResponseEntity.created(uri).body(new TopicoDto(topico));

	}

	@GetMapping("/{id}")
	public DetalhesTopicoDto detalhar(@PathVariable Long id) {
		Topico topico = topicoRepository.getOne(id);
		return new DetalhesTopicoDto(topico);
	}
	
	
	@PutMapping("/{id}")
	@Transactional//commita a transação
	public ResponseEntity<TopicoDto> atualizar(@PathVariable Long id, @RequestBody AtualizacaoTopicoForm form){
		
		Topico topico = form.atualizar(id, topicoRepository);
		
		return ResponseEntity.ok(new TopicoDto(topico));
	}
	
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {

		topicoRepository.deleteById(id);

		return ResponseEntity.ok().build();

	}

}
