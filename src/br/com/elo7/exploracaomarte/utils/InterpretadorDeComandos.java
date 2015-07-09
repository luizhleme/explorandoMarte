package br.com.elo7.exploracaomarte.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.elo7.exploracaomarte.modelo.Acao;
import br.com.elo7.exploracaomarte.modelo.Coordenada;
import br.com.elo7.exploracaomarte.modelo.Direcao;
import br.com.elo7.exploracaomarte.modelo.Sonda;
import br.com.elo7.exploracaomarte.modelo.Superficie;

public class InterpretadorDeComandos implements Interpretador {

	@Override
	public Map<Integer, Sonda> obterSondasEnviadas(String instrucoesEnviadas) {
		Integer idSonda = 0;
		Map<Integer,Sonda> sondas = new HashMap<Integer, Sonda>();
		
		if (instrucoesEnviadas == null) {
			throw new IllegalArgumentException("Instrucoes invalidas");
		}

		String[] instrucoesInterpretadas = obterInstrucoes(instrucoesEnviadas);
		
		Superficie superficieDeMarte = obterSuperficieDeMarte(instrucoesInterpretadas[0]);

		for (int i = 1; i < instrucoesInterpretadas.length; i = i + 2) {
			sondas.put(idSonda, obterSonda(idSonda, superficieDeMarte, instrucoesInterpretadas[i] , instrucoesInterpretadas[i+1]));
			idSonda++;
		}

		return sondas;
	}

	private Superficie obterSuperficieDeMarte(String dimensao) {
		String[] dimensoes = dimensao.split(separadorEspaco);
		if (dimensoes.length < 2) {
			throw new IllegalArgumentException("Dados de superficie invalidos "
					+ dimensao);
		}
		String valorDeX = dimensoes[0];
		String valorDeY = dimensoes[1];
		return new Superficie(new Coordenada(valorDeX, valorDeY));
	}

	private String[] obterInstrucoes(String instrucoesEnviadas) {
		String[] instrucoes = instrucoesEnviadas.split(separadorDeInstrucoes);
		if (instrucoes.length < 3 || (instrucoes.length % 2 != 1)) {
			throw new IllegalArgumentException("Numero de instrucoes invalidas");
		}
		return instrucoes;
	}

	private Sonda obterSonda(Integer id, Superficie superficieDeMarte,
			String posicaoDaSonda, String acoes) {

		String[] dadosDePosicionamento = obterDadosDePosicionamentoDaSonda(posicaoDaSonda);

		String valorDeX = dadosDePosicionamento[0];
		String valorDeY = dadosDePosicionamento[1];
		String direcao = dadosDePosicionamento[2];
		Sonda sonda = new Sonda(id, obterCoordenadaDaSonda(valorDeX, valorDeY),
				obterDirecaoDaSonda(direcao), superficieDeMarte);
		
		sonda.inicializarAcoes(obterAcoesDaSonda(acoes));
		
		return sonda;
	}

	private String[] obterDadosDePosicionamentoDaSonda(String posicaoDaSonda) {
		String[] dadosDePosicionamento = null;

		Pattern pattern = Pattern.compile(regexPosicionamento);
		Matcher matcher = pattern.matcher(posicaoDaSonda);
		if (!matcher.matches()) {
			throw new IllegalArgumentException("Posicionamento incorreto");
		}

		dadosDePosicionamento = posicaoDaSonda.split(separadorEspaco);

		if (dadosDePosicionamento.length < 3) {
			throw new IllegalArgumentException("Posicionamento incorreto");
		}
		return dadosDePosicionamento;
	}

	private Coordenada obterCoordenadaDaSonda(String coordenadaX,
			String coordenadaY) {
		return new Coordenada(coordenadaX, coordenadaY);
	}

	private Direcao obterDirecaoDaSonda(String direcao) {
		return Direcao.valueOf(direcao);
	}
	
	private List<Acao> obterAcoesDaSonda(String possiveisAcoes) {
		List<Acao> acoes = new ArrayList<Acao>();
		
		Pattern pattern = Pattern.compile(regexAcoes);
		Matcher matcher = pattern.matcher(possiveisAcoes);
		
		if (!matcher.matches()) {
			throw new IllegalArgumentException("Acoes desconhecidas.");
		}
		
		for (int i = 0; i < possiveisAcoes.length(); i++) {
			Acao acao = Acao.get(String.valueOf(possiveisAcoes.charAt(i)));
			acoes.add(acao);
		}
		return acoes;
	}
}
