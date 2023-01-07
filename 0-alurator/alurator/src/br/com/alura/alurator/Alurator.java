package br.com.alura.alurator;

import java.util.Map;

import br.com.alura.alurator.protocolo.Request;
import br.com.alura.alurator.reflexao.Reflexao;

public class Alurator {

	private String pacoteBase;

	public Alurator(String pacoteBase) {
		this.pacoteBase = pacoteBase;
	}

	public Object executa(String url) {

		
		Request request = new Request(url);
		String nomeControle = request.getNomeControle();
		String nomeMetodo = request.getNomeMetodo();
		Map<String, Object> params = request.getQueryParams();

		
		Object retornoMetodo = new Reflexao()
							.refleteClasse(pacoteBase + nomeControle)
							.criaInstancia()
							.getMetodo(nomeMetodo, params)
							.comTratamentoDeExcessao((metodo, ex)->{
								  System.out.println("Erro no método " + metodo.getName() + " da classe " + 
								   metodo.getDeclaringClass().getName() + ".\n\n");
				                   throw new RuntimeException("ERRO!");
								
							})
							.invocar();
		
		
		System.out.println(retornoMetodo);
		
		return retornoMetodo;
	}
}
