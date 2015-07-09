package br.com.elo7.exploracaomarte.modelo;

public class Y {

	public static Y ZERO = new Y(0);
	private int valor;
	
	public  Y (int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}
	
	public int incrementa() {
		return ++valor;
	}
	
	public int decrementa() {
		return --valor;
	}
	
	public boolean maiorQue(Y y) {
		return this.valor > y.valor;
	}
	
	public boolean menorQue(Y y) {
		return this.valor < y.valor;
	}
	
	@Override
	public String toString() {
		return String.valueOf(valor);
	}
}
