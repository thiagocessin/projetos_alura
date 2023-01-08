package br.com.alura.alurator.playground.reflexao;

import br.com.alura.alurator.playground.anotacoes.NomeTagXml;
import br.com.alura.alurator.playground.modelo.Produto;

public class TesteManipuladorDeAnotacoes {

	public static void main(String[] args) {
		
		Produto produto = new Produto("Produto 1", 20.0, "Marca 1");
		
		Class<?> classe = produto.getClass();
		
		System.out.println(classe.getDeclaredAnnotation(NomeTagXml.class).value());
		
		

	}

}
