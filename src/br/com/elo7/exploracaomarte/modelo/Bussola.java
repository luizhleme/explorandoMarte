package br.com.elo7.exploracaomarte.modelo;

import java.util.HashMap;
import java.util.Map;

public final class Bussola {

	private static Map<Direcao, ProximaDirecao> rosaDosVentos;
	
	static {
		rosaDosVentos = new HashMap<Direcao, ProximaDirecao>();
		rosaDosVentos.put(Direcao.N, new ProximaDirecao(Direcao.E, Direcao.W));
		rosaDosVentos.put(Direcao.S, new ProximaDirecao(Direcao.W, Direcao.E));
		rosaDosVentos.put(Direcao.E, new ProximaDirecao(Direcao.S, Direcao.N));
		rosaDosVentos.put(Direcao.W, new ProximaDirecao(Direcao.N, Direcao.S));
	}
	
	private Bussola() {
	}
	
	public static Direcao getDireitaDe(Direcao direcaoAtual) {
		return rosaDosVentos.get(direcaoAtual).getDireita();
	}
	
	public static Direcao getEsquerdaDe(Direcao direcaoAtual) {
		return rosaDosVentos.get(direcaoAtual).getEsquerda();
	}
	
	private static class ProximaDirecao {
		private Direcao direita;
		private Direcao esquerda;
		
		public ProximaDirecao(Direcao posicaoDaDireita, Direcao posicaoDaEsquerda) {
			this.direita = posicaoDaDireita;
			this.esquerda = posicaoDaEsquerda;
		}

		private Direcao getDireita() {
			return direita;
		}

		private Direcao getEsquerda() {
			return esquerda;
		}
	}
}
