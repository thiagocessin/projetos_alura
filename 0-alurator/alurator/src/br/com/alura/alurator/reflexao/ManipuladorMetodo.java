package br.com.alura.alurator.reflexao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class ManipuladorMetodo {

	private Object instancia;
	private Method metodo;
	private Map<String, Object> mapParams;

	public ManipuladorMetodo(Object instancia, Method metodo, Map<String, Object> mapParams) {
		this.instancia = instancia;
		this.metodo = metodo;
		this.mapParams = mapParams;
	}

	public Object invocar() {
		try {
			
			List<Object> listaParametros = new ArrayList<>();
			Stream.of(metodo.getParameters())
				.forEach(p -> listaParametros.add(mapParams.get(p.getName())));
			
			return metodo.invoke(instancia, listaParametros.toArray());
		} catch (IllegalAccessException | IllegalArgumentException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			throw new RuntimeException("Erro no método", e);
		}
	}

}
