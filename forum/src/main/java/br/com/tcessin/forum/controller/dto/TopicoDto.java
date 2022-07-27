package br.com.tcessin.forum.controller.dto;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;

import br.com.tcessin.forum.modelo.Topico;

public class TopicoDto {

	protected Long id;
	protected String titulo;
	protected String mensagem;
	protected LocalDateTime dataCriacao;
	
	
	public TopicoDto() {}
	
	public TopicoDto(Topico topico) {
		
		this.id = topico.getId();
		this.titulo = topico.getTitulo();
		this.mensagem = topico.getMensagem();
		this.dataCriacao = topico.getDataCriacao();
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public static Page<TopicoDto> converter(Page<Topico> topicos) {
		return topicos.map(TopicoDto::new);
	}

}
