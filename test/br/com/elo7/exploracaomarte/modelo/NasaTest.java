package br.com.elo7.exploracaomarte.modelo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NasaTest {

	private String instrucoes;
	private Nasa nasa;

	@Before
	public void setUp() {
		nasa = new Nasa();
		instrucoes = "5 5\n"+
	              "1 2 N\n"+
		  		  "LMLMLMLMM";
	}
	
	@Test
	public void envioDeSonda() {
		String localizacaoEsperada = "1 3 N";
		nasa.adicionarSondas(instrucoes);
		nasa.controlarSondas();
		assertEquals(localizacaoEsperada, nasa.localizarSondas());
	}
}
