package br.com.tcessin.forum.controller.dto;

import br.com.tcessin.forum.modelo.Topico;
import br.com.tcessin.forum.repository.TopicoRepository;

public class AtualizacaoTopicoForm {

	private String titulo;

	private String mensagem;

	// para atualizacao não é necessário chamar nenhum método update, ao commitar a
	// transação o spring já detecta a alteração automaticamente
	public Topico atualizar(Long id, TopicoRepository topicoRepository) {

		Topico topico = topicoRepository.getOne(id);

		topico.setTitulo(this.titulo);
		topico.setMensagem(this.mensagem);

		return topico;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
