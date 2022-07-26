package br.com.tcessin.forum.controller.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.tcessin.forum.modelo.StatusTopico;
import br.com.tcessin.forum.modelo.Topico;

public class DetalhesTopicoDto extends TopicoDto {

	private String nomeAutor;
	private StatusTopico status;
	private List<RespostaDto> respostas;

	public DetalhesTopicoDto(Topico topico) {

		this.id = topico.getId();
		this.titulo = topico.getTitulo();
		this.mensagem = topico.getMensagem();
		this.dataCriacao = topico.getDataCriacao();
		this.nomeAutor = topico.getAutor().getNome();
		this.status = topico.getStatus();
		this.respostas = new ArrayList<>();
		this.respostas.addAll(topico.getRespostas().stream().map(RespostaDto::new).collect(Collectors.toList()));
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public StatusTopico getStatus() {
		return status;
	}

	public List<RespostaDto> getRespostas() {
		return respostas;
	}

}
