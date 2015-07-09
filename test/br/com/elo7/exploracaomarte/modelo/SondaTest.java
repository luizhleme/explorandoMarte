package br.com.elo7.exploracaomarte.modelo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SondaTest {

	private static Superficie superficie;
	private static int idSonda;
	private Coordenada coordenadaDaSonda;

	@BeforeClass
	public static void setUp() {
		superficie = new Superficie(new Coordenada(5, 5));
		idSonda = 0;
	}
	
	@Before
	public void inicializaCoordenadaSonda() {
		coordenadaDaSonda = new Coordenada(1, 2);
	}
	
	@Test
	public void moverSondaParaNorte() {
		Sonda sonda = new Sonda(idSonda, coordenadaDaSonda, Direcao.N, superficie);
		sonda.executarAcao(Acao.M);
		String posicaoEsperada = "1 3 N";
		assertEquals(posicaoEsperada, sonda.getPosicaoAtual());
	}
	
	@Test
	public void moverSondaParaSul() {
		Sonda sonda = new Sonda(idSonda, coordenadaDaSonda, Direcao.S, superficie);
		sonda.executarAcao(Acao.M);
		String posicaoEsperada = "1 1 S";
		assertEquals(posicaoEsperada, sonda.getPosicaoAtual());
	}
	
	@Test
	public void moverSondaParaLeste() {
		Sonda sonda = new Sonda(idSonda, coordenadaDaSonda, Direcao.E, superficie);
		sonda.executarAcao(Acao.M);
		String posicaoEsperada = "2 2 E";
		assertEquals(posicaoEsperada, sonda.getPosicaoAtual());
	}
	
	@Test
	public void moverSondaParaOeste() {
		Sonda sonda = new Sonda(idSonda, coordenadaDaSonda, Direcao.W, superficie);
		sonda.executarAcao(Acao.M);
		String posicaoEsperada = "0 2 W";
		assertEquals(posicaoEsperada, sonda.getPosicaoAtual());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void moverSondaParaForaDaSuperficieAoNorte() {
		Sonda sonda = new Sonda(idSonda, coordenadaDaSonda, Direcao.N, superficie);
		sonda.executarAcao(Acao.M);
		sonda.executarAcao(Acao.M);
		sonda.executarAcao(Acao.M);
		sonda.executarAcao(Acao.M);
		sonda.executarAcao(Acao.M);
		sonda.executarAcao(Acao.M);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void moverSondaParaForaDaSuperficieAoSul() {
		Sonda sonda = new Sonda(idSonda, coordenadaDaSonda, Direcao.S, superficie);
		sonda.executarAcao(Acao.M);
		sonda.executarAcao(Acao.M);
		sonda.executarAcao(Acao.M);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void moverSondaParaForaDaSuperficieALeste() {
		Sonda sonda = new Sonda(idSonda, coordenadaDaSonda, Direcao.E, superficie);
		sonda.executarAcao(Acao.M);
		sonda.executarAcao(Acao.M);
		sonda.executarAcao(Acao.M);
		sonda.executarAcao(Acao.M);
		sonda.executarAcao(Acao.M);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void moverSondaParaForaDaSuperficieAOeste() {
		Sonda sonda = new Sonda(idSonda, coordenadaDaSonda, Direcao.W, superficie);
		sonda.executarAcao(Acao.M);
		sonda.executarAcao(Acao.M);
	}
	
	@Test
	public void girarSondaParaLeste() {
		Sonda sonda = new Sonda(idSonda, coordenadaDaSonda, Direcao.N, superficie);
		sonda.executarAcao(Acao.R);
		assertEquals(Direcao.E, sonda.getDirecao());
	}
	
	@Test
	public void girarSondaParaOeste() {
		Sonda sonda = new Sonda(idSonda, coordenadaDaSonda, Direcao.N, superficie);
		sonda.executarAcao(Acao.L);
		assertEquals(Direcao.W, sonda.getDirecao());
	}
	
	@Test
	public void girarSondaParaSul() {
		Sonda sonda = new Sonda(idSonda, coordenadaDaSonda, Direcao.N, superficie);
		sonda.executarAcao(Acao.L);
		sonda.executarAcao(Acao.L);
		assertEquals(Direcao.S, sonda.getDirecao());
	}
}
