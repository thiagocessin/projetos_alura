package br.com.alura.alurator.playground.reflexao;

import java.lang.reflect.InvocationTargetException;

public class TesteInstaciaObjetoCorretamente {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, NoSuchMethodException, SecurityException {

		// teste new Instance
		Class<?> controle1 = Class.forName("br.com.alura.alurator.playground.controle.Controle");

		try {
			controle1.getDeclaredConstructor().newInstance();
		} catch (InvocationTargetException e) {
			
			Throwable targetException = e.getTargetException();
			System.out.println(targetException);
			e.printStackTrace();
		}

		// controle1.newInstance();

	}

	
	/*
	private static void m1() throws ClassNotFoundException, NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		Class<SubControle> subControleClasse1 = SubControle.class;
		Class<?> subControleClasse2 = Class.forName("br.com.alura.alurator.playground.controle.SubControle");
		Class<?> controleClasse2 = Class.forName("br.com.alura.alurator.playground.controle.Controle");

		Constructor<SubControle> constructorSubControle = subControleClasse1.getDeclaredConstructor();

		System.out.println(constructorSubControle);

		constructorSubControle.setAccessible(true);
		SubControle subControle = constructorSubControle.newInstance();

		System.out.println(subControle);

	}
*/
}
