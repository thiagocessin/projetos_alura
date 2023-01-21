package br.com.tcessin;

import br.com.tcessin.banheiro.Banheiro;
import br.com.tcessin.banheiro.TarefaNumero1;
import br.com.tcessin.banheiro.TarefaNumero2;

public class Main {

	public static void main(String[] args) {
		
		Banheiro banheiro = new Banheiro();
		
		Thread convidado1 = new Thread(new TarefaNumero1(banheiro), "Joao");
		Thread convidado2 = new Thread(new TarefaNumero2(banheiro), "Pedro");
		Thread convidado3 = new Thread(new TarefaNumero1(banheiro), "Maria");
		Thread convidado4 = new Thread(new TarefaNumero2(banheiro), "Ana");
		
		convidado1.start();
		convidado2.start();
		convidado3.start();
		convidado4.start();
		
		

	}

}
