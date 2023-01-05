package br.com.alura.alurator.reflexao;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.stream.Stream;

public class ManipuladorObjeto {

	private Object instancia;

	public ManipuladorObjeto(Object instancia) {
		this.instancia = instancia;
		
		
	}

	public ManipuladorMetodo getMetodo(String nomeMetodo, Map<String, Object> params) {

		Stream<Method> metodos = Stream.of(instancia.getClass().getDeclaredMethods());

		Method metodoSelecionado = metodos.filter(m -> filterMetodo(m, nomeMetodo, params)).findFirst()
				.orElseThrow(() -> new RuntimeException("Metodo não encontrado"));

		return new ManipuladorMetodo(instancia, metodoSelecionado, params);
	}
	
	private boolean filterMetodo(Method metodo, String nomeMetodo, Map<String, Object> mapParametros) {

		return metodo.getName().equals(nomeMetodo) 
				&& metodo.getParameterCount() == mapParametros.values().size()
				&& Stream.of(metodo.getParameters())
							.allMatch(
									parametroMetodo -> {
										
										System.out.println("NOME ARGUMENTO: " + parametroMetodo);
										
										return mapParametros.keySet().contains(parametroMetodo.getName()) 
										&& mapParametros.get(parametroMetodo.getName()).getClass().equals(parametroMetodo.getType());});

	}

}
