package br.com.alura.alurator.reflexao;

import java.lang.reflect.Method;
import java.util.Map;

public class ManipuladorObjeto {

	private Object instancia;

	public ManipuladorObjeto(Object instancia) {
		this.instancia = instancia;
		
		
	}

	public ManipuladorMetodo getMetodo(String nomeMetodo, Map<String, Object> params) {
		
		try {
			Method metodo = instancia.getClass().getDeclaredMethod(nomeMetodo);
			return new ManipuladorMetodo(instancia,metodo);
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

}
