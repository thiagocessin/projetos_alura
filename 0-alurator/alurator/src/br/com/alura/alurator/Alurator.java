package br.com.alura.alurator;

import java.lang.reflect.Constructor;

public class Alurator {

	private String pacoteBase;

	public Alurator(String pacoteBase) {
		this.pacoteBase = pacoteBase;
	}

	public Object executa(String url) {

		// /produto/lista

		String[] partesUrl = url.replaceFirst("/", "").split("/");

		String nomeControle = Character.toUpperCase(partesUrl[0].charAt(0)) +
				partesUrl[0].substring(1) + "Controller";

		try {
			Class<?> classeControle = Class.forName(pacoteBase + nomeControle);
			Object instanciaControle = classeControle.newInstance();
			
			
			System.out.println(instanciaControle);

		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return null;
	}
}
