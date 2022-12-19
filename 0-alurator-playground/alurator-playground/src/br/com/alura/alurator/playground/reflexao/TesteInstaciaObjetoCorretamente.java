package br.com.alura.alurator.playground.reflexao;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import br.com.alura.alurator.playground.controle.SubControle;

public class TesteInstaciaObjetoCorretamente {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		
		
		Class<SubControle> subControleClasse1 = SubControle.class;
		Class<?> subControleClasse2 = Class.forName("br.com.alura.alurator.playground.controle.SubControle");
		Class<?> controleClasse2 = Class.forName("br.com.alura.alurator.playground.controle.Controle");
		
		
		Constructor<SubControle> constructorSubControle = subControleClasse1.getDeclaredConstructor();
		
		System.out.println(constructorSubControle);
		
		constructorSubControle.setAccessible(true);
		SubControle subControle = constructorSubControle.newInstance();
		
		System.out.println(subControle);
		
		
		
	}

}
