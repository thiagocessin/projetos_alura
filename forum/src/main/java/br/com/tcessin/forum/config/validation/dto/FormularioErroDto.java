package br.com.tcessin.forum.config.validation.dto;

public class FormularioErroDto {

	private String campo;
	private String erro;

	public FormularioErroDto(String campo, String erro) {
		super();
		this.campo = campo;
		this.erro = erro;
	}

	public String getCampo() {
		return campo;
	}

	public String getErro() {
		return erro;
	}

}
