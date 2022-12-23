package br.com.alura.alurator.reflexao;

public class Reflexao {

	public ManipuladorClasse refleteClasse(String fullyQualifiedName) {

		try {
			Class<?> classe = Class.forName(fullyQualifiedName);

			return new ManipuladorClasse(classe);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

}
