package threads;

public class TarefaAdicionarElemento implements Runnable {

	private Lista lista;
	private int numeroThread;

	public TarefaAdicionarElemento(Lista lista, int numeroThread) {
		this.numeroThread = numeroThread;
		this.lista = lista;
	}

	@Override
	public void run() {

		for (int i = 0; i < 100; i++) {
			lista.adicionaElementos("Thread "+ numeroThread+ " - " + i);
		}

	}

}
