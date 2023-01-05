package br.com.alura.alurator.protocolo;

import java.util.HashMap;
import java.util.Map;

public class Request {

	private String nomeControle;
	private String nomeMetodo;
	private Map<String, Object> queryParams;
	
	public Request(String url) {
		
		// /controlador/metodo ? param1=valor1&param2=valor2
		// controlador/metodo , param1=valor1&param2=valor2
		// ControladorController, metodo
		
		String[] partesUrl = url.replaceFirst("/", "").split("[?]");
		String[] controleEMetodo = partesUrl[0].split("/");
		
		nomeControle = Character.toUpperCase(controleEMetodo[0].charAt(0)) + controleEMetodo[0].substring(1) + "Controller";
		nomeMetodo = controleEMetodo[1];
		
		queryParams = partesUrl.length > 1 ? new QueryParamsBuilder().withParams(partesUrl[1]).build() : new HashMap<>();

	}

	public String getNomeControle() {

		return nomeControle;

	}
	
	public String getNomeMetodo() {
		return nomeMetodo;
	}

	public Map<String, Object> getQueryParams() {
		return queryParams;
	}
	
	
}
