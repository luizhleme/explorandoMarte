package br.com.elo7.exploracaomarte.modelo;

public class X {

	public static X ZERO = new X(0);
	private int valor;
	
	public  X (int valor) {
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
	
	public boolean maiorQue(X x) {
		return this.valor > x.valor;
	}
	
	public boolean menorQue(X x) {
		return this.valor < x.valor;
	}
	
	@Override
	public String toString() {
		return String.valueOf(valor);
	}
}
