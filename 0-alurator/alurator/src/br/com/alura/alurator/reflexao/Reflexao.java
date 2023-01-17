package br.com.alura.alurator.reflexao;

public class Reflexao {

	public ManipuladorClasse refleteClasse(String fullyQualifiedName) {
		Class<?> classe = getClasse(fullyQualifiedName);

		return new ManipuladorClasse(classe);

	}

	public Class<?> getClasse(String fullyQualifiedName) {
		try {
			Class<?> classe = Class.forName(fullyQualifiedName);

			return classe;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
