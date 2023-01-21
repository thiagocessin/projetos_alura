package br.com.tcessin.banheiro;

public class Banheiro {

	public void fazNumero1() {

		String nome = Thread.currentThread().getName();
		
		System.out.println(nome + " batendo na porta");

		synchronized (this) {
			System.out.println(nome + " entrando no banheiro");
			System.out.println(nome + " fazendo coisa rapida");

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println(nome + " Dando descarga");
			System.out.println(nome + " Lavando mao");
			System.out.println(nome + " Saindo do banheiro");
		}

	}

	public void fazNumero2() {
		String nome = Thread.currentThread().getName();
		
		System.out.println(nome + " batendo na porta");

		synchronized (this) {
			System.out.println(nome + " entrando no banheiro");
			System.out.println(nome + " fazendo coisa demorada");

			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println(nome + " Dando descarga");
			System.out.println(nome + " Lavando mao");
			System.out.println(nome + " Saindo do banheiro");
		}
	}

}
