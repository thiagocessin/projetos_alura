package br.com.tcessin.forum.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tcessin.forum.controller.dto.TopicoDto;
import br.com.tcessin.forum.modelo.Curso;
import br.com.tcessin.forum.modelo.Topico;

@RestController
public class TopicosController {
	
	
	@RequestMapping("/topicos")
	public List<TopicoDto> lista() {
		
		Topico t = new Topico("Titulo 1", "Duvida conteúdo", new Curso("Java", "Programação"));
				
		return TopicoDto.converter(Arrays.asList(t,t,t));
	}

}
