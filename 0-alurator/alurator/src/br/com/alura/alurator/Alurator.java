package br.com.alura.alurator;

import br.com.alura.alurator.protocolo.Request;
import br.com.alura.alurator.reflexao.Reflexao;

public class Alurator {

	private String pacoteBase;

	public Alurator(String pacoteBase) {
		this.pacoteBase = pacoteBase;
	}

	public Object executa(String url) {

		// /produto/lista
		// /nomeControle/nomeMetodo
		
		Request request = new Request(url);
		String nomeControle = request.getNomeControle();
		String nomeMetodo = request.getNomeMetodo();

//		Object instanciaControle = new Reflexao()
//									.refleteClasse(pacoteBase + nomeControle)
//									.getConstrutorPadrao()
//									.invocar();
		
		
		Object retornoMetodo = new Reflexao()
							.refleteClasse(pacoteBase + nomeControle)
							.criaInstancia()
							.getMetodo(nomeMetodo)
							.invocar();
		
		
		System.out.println(retornoMetodo);
		
		return retornoMetodo;
	}
}
