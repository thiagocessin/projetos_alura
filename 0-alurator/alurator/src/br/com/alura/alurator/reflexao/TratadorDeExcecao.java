package br.com.alura.alurator.reflexao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@FunctionalInterface
public interface TratadorDeExcecao {

	
	public ManipuladorMetodo tratar(Method method, InvocationTargetException e);
	
}
