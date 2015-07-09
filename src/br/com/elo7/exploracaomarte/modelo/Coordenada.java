package br.com.elo7.exploracaomarte.modelo;

public class Coordenada {

	private X x;
	private Y y;
	
	public Coordenada(String coordenadaX, String coordenadaY) {
		try {
			X valorX = new X(Integer.parseInt(coordenadaX));
			Y valorY = new Y(Integer.parseInt(coordenadaY));
			if (valorX.getValor() < 0 || valorY.getValor() < 0) {
				throw new IllegalArgumentException("As dimesoes devem ser positivas");
			}
			this.x = valorX;
			this.y = valorY;
		} catch (Exception e) {
			throw new IllegalArgumentException("Coordenadas invalidas " + coordenadaX + " " + coordenadaY);
		}
	}
	
	public Coordenada(int x, int y) {
		if (x < 0 || y < 0) {
			throw new IllegalArgumentException("As dimesoes devem ser positivas");
		}
		this.x = new X(x);
		this.y = new Y(y);
	}

	public X getX() {
		return x;
	}

	public Y getY() {
		return y;
	}
	
	public boolean maiorQue(Coordenada coordenada) {
		return this.x.maiorQue(coordenada.getX()) || this.y.maiorQue(coordenada.getY());
	}
	
	public boolean menorQue(Coordenada coordenada) {
		return this.x.menorQue(coordenada.getX()) || this.y.menorQue(coordenada.getY());
	}
	
	public boolean isNegativa() {
		return this.x.menorQue(X.ZERO) || this.y.menorQue(Y.ZERO);
	}
	
	@Override
	public String toString() {
		return x.toString().concat(" ").concat(y.toString());
	}
}
