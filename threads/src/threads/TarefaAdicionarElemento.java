package threads;

import java.util.List;

public class TarefaAdicionarElemento implements Runnable {

	private List<String> lista;
	private int numeroThread;

	public TarefaAdicionarElemento(List<String>lista, int numeroThread) {
		this.numeroThread = numeroThread;
		this.lista = lista;
	}

	@Override
	public void run() {

		for (int i = 0; i < 100; i++) {
			lista.add("Thread "+ numeroThread+ " - " + i);
		}

	}

}
