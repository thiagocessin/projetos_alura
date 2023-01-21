package br.com.tcessin.threads;

import br.com.tcessin.threads.tasks.TarefaBuscaTextual;

public class Main {
	
	public static void main(String[] args) {
		
		String nome = "da";
		
		Thread threadAssinaturas1 = new Thread(new TarefaBuscaTextual("assinaturas1.txt", nome));
		Thread threadAssinaturas2 = new Thread(new TarefaBuscaTextual("assinaturas2.txt", nome));
		Thread threadAutores = new Thread(new TarefaBuscaTextual("autores.txt", nome));
		
		
		threadAssinaturas1.start();
		threadAssinaturas2.start();
		threadAutores.start();
		
	}

}
