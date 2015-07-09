package br.com.elo7.exploracaomarte.modelo;

import java.util.ArrayList;
import java.util.List;

public class Sonda implements Controlavel {

	private Coordenada posicaoAtualDaSonda;
	private Direcao direcao;
	private int id;
	private Superficie superficieDeMarte;
	private List<Acao> acoesDaSonda;

	public Sonda(int id, Coordenada coordenadas, Direcao direcao,
			Superficie superficieDeMarte) {
		super();
		this.id = id;
		this.posicaoAtualDaSonda = coordenadas;
		this.direcao = direcao;
		this.superficieDeMarte = superficieDeMarte;
		this.acoesDaSonda = new ArrayList<Acao>();
	}
	
	public void inicializarAcoes(List<Acao> acoes) {
		this.acoesDaSonda = acoes;
	}

	public void executarAcoes(Acao... acoes) {
		for (Acao acao : acoes) {
			executarAcao(acao);
		}
	}

	@Override
	public void executarAcoes() {
		if (acoesDaSonda == null || acoesDaSonda.isEmpty()) {
			throw new IllegalArgumentException("Acoes desconhecidas.");
		}
		for (Acao acao : acoesDaSonda) {
			executarAcao(acao);
		}
	}

	public void executarAcao(Acao acao) {
		switch (acao) {
		case L:
		case R:
			girarSonda(acao);
			break;
		case M:
			moverSonda();
			break;
		default:
			throw new IllegalArgumentException("Acao desconhecida.");
		}
	}

	private void girarSonda(Acao acaoDeGiro) {
		if (Acao.L.equals(acaoDeGiro)) {
			this.direcao = Bussola.getEsquerdaDe(this.direcao);
		}
		if (Acao.R.equals(acaoDeGiro)) {
			this.direcao = Bussola.getDireitaDe(this.direcao);
		}
	}

	private void moverSonda() {
		Coordenada proximaPosicaoDaSonda = posicaoAtualDaSonda;

		switch (direcao) {
		case N:
			proximaPosicaoDaSonda.getY().incrementa();
			break;
		case S:
			proximaPosicaoDaSonda.getY().decrementa();
			break;
		case E:
			proximaPosicaoDaSonda.getX().incrementa();
			break;
		case W:
			proximaPosicaoDaSonda.getX().decrementa();
			break;
		default:
			throw new IllegalArgumentException("Direcoes desconhecidas.");
		}
		if (ePossivelMover(proximaPosicaoDaSonda) && ! proximaPosicaoDaSonda.isNegativa()) {
			this.posicaoAtualDaSonda = proximaPosicaoDaSonda;
		} else {
			throw new IllegalArgumentException(
					"Fora dos dominios de superficie.");
		}
	}

	private boolean ePossivelMover(Coordenada proximaPosicao) {
		return !proximaPosicao
				.maiorQue(this.superficieDeMarte.getCoordenadas())
				|| !proximaPosicao.menorQue(this.superficieDeMarte
						.getCoordenadas());
	}

	public Coordenada getCoordenadas() {
		return posicaoAtualDaSonda;
	}

	public Direcao getDirecao() {
		return direcao;
	}
	
	public String getPosicaoAtual() {
		StringBuilder posicaoAtual = new StringBuilder();
		posicaoAtual.append(posicaoAtualDaSonda.getX()).append(" ")
				.append(posicaoAtualDaSonda.getY()).append(" ").append(direcao);
		return posicaoAtual.toString();
	}

	public int getId() {
		return id;
	}
}
