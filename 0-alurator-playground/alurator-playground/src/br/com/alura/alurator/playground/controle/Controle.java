package br.com.alura.alurator.playground.controle;

import java.util.List;

public class Controle {
	private List<String> lista = List.of("item 1", "item 2", "item 3");

	public Controle() {
	}

	public Controle(String s) {
	}

	public Controle(String s, String t) {
	}

	public List<String> getLista() {
		return lista;
	}

	private void metodoControle1() {

	}

	public void metodoControle2(String p1) {

		System.out.println("Controle.metodoControle2(String p1)");
		System.out.println("Parâmetro: " + p1);
	}

	public void metodoControle2(String p1, String p2) {

		System.out.println("Controle.metodoControle2(String p1, String p2)");
		System.out.println("P1" + p1);
		System.out.println("P2" + p2);
	}

	public void metodoControle2(String p1, Integer p2) {

		System.out.println("Controle.metodoControle2(String p1, Integer p2)");
		System.out.println("P1" + p1);
		System.out.println("P2" + p2);
	}

}
