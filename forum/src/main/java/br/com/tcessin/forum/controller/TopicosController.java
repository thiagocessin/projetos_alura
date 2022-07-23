package br.com.tcessin.forum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tcessin.forum.controller.dto.TopicoDto;
import br.com.tcessin.forum.repository.TopicoRepository;

@RestController
public class TopicosController {
	
	
	@Autowired
	private TopicoRepository topicoRepository;
	
	
	@RequestMapping("/topicos")
	public List<TopicoDto> lista() {
		return TopicoDto.converter(topicoRepository.findAll());
	}
	

}
