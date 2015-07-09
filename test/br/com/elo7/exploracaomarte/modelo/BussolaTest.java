package br.com.elo7.exploracaomarte.modelo;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class BussolaTest {

	private static Direcao N;
	private static Direcao S;
	private static Direcao E;
	private static Direcao W;
	
	@BeforeClass
	public static void setUp() {
		N = Direcao.N;
		S = Direcao.S;
		E = Direcao.E;
		W = Direcao.W;
	}
	
	@Test
	public void direcaoValidaADireitaDeN() {
		assertEquals(Direcao.E,Bussola.getDireitaDe(N));
	}
	@Test
	public void direcaoValidaAEsquerdaDeN() {
		assertEquals(Direcao.W,Bussola.getEsquerdaDe(N));
	}
	
	@Test
	public void direcaoValidaADireitaDeS() {
		assertEquals(Direcao.W,Bussola.getDireitaDe(S));
	}
	@Test
	public void direcaoValidaAEsquerdaDeS() {
		assertEquals(Direcao.E,Bussola.getEsquerdaDe(S));
	}
	
	@Test
	public void direcaoValidaADireitaDeE() {
		assertEquals(Direcao.S,Bussola.getDireitaDe(E));
	}
	@Test
	public void direcaoValidaAEsquerdaDeE() {
		assertEquals(Direcao.N,Bussola.getEsquerdaDe(E));
	}
	
	@Test
	public void direcaoValidaADireitaDeW() {
		assertEquals(Direcao.N,Bussola.getDireitaDe(W));
	}
	@Test
	public void direcaoValidaAEsquerdaDeW() {
		assertEquals(Direcao.S,Bussola.getEsquerdaDe(W));
	}
}
