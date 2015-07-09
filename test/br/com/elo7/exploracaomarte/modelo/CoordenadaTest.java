package br.com.elo7.exploracaomarte.modelo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.com.elo7.exploracaomarte.modelo.Coordenada;

public class CoordenadaTest {
	private Coordenada coordenada = new Coordenada(0, 0);

	@Before
	public void setUp() {
		this.coordenada = null;
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void coordenadaComXXNegativo() {
		this.coordenada = new Coordenada(-1, 0);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void coordenadaComYNegativo() {
		this.coordenada = new Coordenada(0, -1);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void coordenadaComXYNegativos() {
		this.coordenada = new Coordenada(-5, -5);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void coordenadaComXInvalido() {
		this.coordenada = new Coordenada("A", "1");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void coordenadaComYInvalido() {
		this.coordenada = new Coordenada("1", "A");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void coordenadaComXYInvalidos() {
		this.coordenada = new Coordenada("A", "?");
	}
	
	@Test
	public void coordenadaComXYValidos() {
		Coordenada coordenadaEsperada = new Coordenada(5, 5);
		this.coordenada = new Coordenada(5, 5);
		assertEquals(coordenadaEsperada.getX().getValor(), this.coordenada.getX().getValor());
		assertEquals(coordenadaEsperada.getY().getValor(), this.coordenada.getY().getValor());
	}
	
	@Test
	public void coordenadaMaior() {
		Coordenada coordenadaMaior = new Coordenada(10, 60);
		this.coordenada = new Coordenada(5, 5);
		assertTrue(coordenadaMaior.maiorQue(coordenada));
	}
	
	@Test
	public void coordenadaMenor() {
		Coordenada coordenadaMaior = new Coordenada(3, 3);
		this.coordenada = new Coordenada(1, -1);
		assertTrue(coordenadaMaior.menorQue(coordenada));
	}
	
}
