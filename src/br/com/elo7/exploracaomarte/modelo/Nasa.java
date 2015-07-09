package br.com.elo7.exploracaomarte.modelo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.com.elo7.exploracaomarte.utils.Interpretador;
import br.com.elo7.exploracaomarte.utils.InterpretadorDeComandos;

public class Nasa {

	Map<Integer, Sonda> sondas;
	Interpretador interpretadorDeComandos;

	public Nasa() {
		this.sondas = new HashMap<Integer, Sonda>();
		this.interpretadorDeComandos = new InterpretadorDeComandos();
	}

	public void adicionarSondas(String conjuntoDeInstrucoes) {
		if (conjuntoDeInstrucoes == null) {
			throw new IllegalArgumentException("Instrucoes invalidas "
					+ conjuntoDeInstrucoes);
		}

		Map<Integer, Sonda> sondasEnviadas = interpretadorDeComandos
				.obterSondasEnviadas(conjuntoDeInstrucoes);
		if (sondasEnviadas.isEmpty()) {
			throw new IllegalArgumentException(
					"Nenhum registro de Sonda enviada a Marte");
		}
		this.sondas.putAll(sondasEnviadas);

	}

	public void adicionarSonda(Integer id, Sonda sonda) {
		sondas.put(id, sonda);
	}

	public Sonda obterSonda(Integer id) {
		return sondas.get(id);
	}

	public Collection<Sonda> obterSondas() {
		return sondas.values();
	}

	public void controlarSondas() {
		for (Sonda sonda : this.sondas.values()) {
			sonda.executarAcoes();
		}
	}

	public String localizarSonda(Integer id) {
		return this.sondas.get(id).getPosicaoAtual();
	}

	public String localizarSondas() {
		StringBuffer localizacaoDasSondas = new StringBuffer();
		for (Sonda sonda : this.sondas.values()) {
			localizacaoDasSondas.append(sonda.getPosicaoAtual());
			if (this.sondas.values().size() > 1) {
				localizacaoDasSondas.append("\n");
			}
		}
		return localizacaoDasSondas.toString();
	}
}
