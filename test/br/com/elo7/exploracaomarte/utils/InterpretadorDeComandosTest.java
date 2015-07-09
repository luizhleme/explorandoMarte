package br.com.elo7.exploracaomarte.utils;

import org.junit.BeforeClass;
import org.junit.Test;

public class InterpretadorDeComandosTest {
	
	private static Interpretador interpretadorDeComandos;

	@BeforeClass
	public static void setUp() {
		interpretadorDeComandos = new InterpretadorDeComandos();
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void nenhumaInstrucaoInformada() {
		interpretadorDeComandos.obterSondasEnviadas("");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void instrucoesNulas() {
		interpretadorDeComandos.obterSondasEnviadas(null);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void somenteCoordenadasDaSuperficie() {
		String instrucoes = "5 5";
		interpretadorDeComandos.obterSondasEnviadas(instrucoes);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void somenteCoordenadasDaSuperficieEPosicionamentoInvalido() {
		String instrucoes = "5 5 \n 1 2";
		interpretadorDeComandos.obterSondasEnviadas(instrucoes);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void somenteCoordenadasDaSuperficieEPosicionamento() {
		String instrucoes = "5 5 \n 1 2 N";
		interpretadorDeComandos.obterSondasEnviadas(instrucoes);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void somentePosicionamento() {
		String instrucoes = "\n 1 2 N";
		interpretadorDeComandos.obterSondasEnviadas(instrucoes);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void somentePosicionamentoEAcoes() {
		String instrucoes = "\n 1 2 N \n LMLMLMLMM";
		interpretadorDeComandos.obterSondasEnviadas(instrucoes);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void somenteAcoes() {
		String instrucoes = "LMLMLMLMM";
		interpretadorDeComandos.obterSondasEnviadas(instrucoes);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void somenteCoordenadasDaSuperficieInvalidas() {
		String instrucoes = "A B \n 1 2 N \n LMLMLMLMM";
		interpretadorDeComandos.obterSondasEnviadas(instrucoes);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void somenteCoordenadasDaSuperficieNegativas() {
		String instrucoes = "-5 -5 \n 1 2 N \n LMLMLMLMM";
		interpretadorDeComandos.obterSondasEnviadas(instrucoes);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void somenteCoordenadasDaSondaInvalidas() {
		String instrucoes = "5 5 \n A B N \n LMLMLMLMM";
		interpretadorDeComandos.obterSondasEnviadas(instrucoes);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void somenteCoordenadasDaSondaNegativas() {
		String instrucoes = "5 5 \n -1 -2 N \n LMLMLMLMM";
		interpretadorDeComandos.obterSondasEnviadas(instrucoes);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void somenteDirecaoDaSondaNegativas() {
		String instrucoes = "5 5 \n -1 -2 L \n LMLMLMLMM";
		interpretadorDeComandos.obterSondasEnviadas(instrucoes);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void somenteAcoesInvalidas() {
		String instrucoes = "5 5 \n -1 -2 L \n NASANASAA";
		interpretadorDeComandos.obterSondasEnviadas(instrucoes);
	}
}
