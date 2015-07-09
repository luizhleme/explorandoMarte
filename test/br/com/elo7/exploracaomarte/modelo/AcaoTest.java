package br.com.elo7.exploracaomarte.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class AcaoTest {

	private static final String R = "R";
	private static final String L= "L";
	private static final String M = "M";
	
	@Test
	public void acaoR() {
		Acao acao = Acao.get(R);
		assertEquals(Acao.R, acao);
	}
	
	@Test
	public void acaoL() {
		Acao acao = Acao.get(L);
		assertEquals(Acao.L, acao);
	}
	
	@Test
	public void acaoM() {
		Acao acao = Acao.get(M);
		assertEquals(Acao.M, acao);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void acaoInvalida() {
		Acao.get("A");
	}
}
