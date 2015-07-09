package br.com.elo7.exploracaomarte.utils;

import java.util.Map;

import br.com.elo7.exploracaomarte.modelo.Sonda;

public interface Interpretador {

	
	String separadorDeInstrucoes = "\n"; 
	String separadorEspaco = "\\s";
	String regexAcoes = "[L|M|R]+$";
	String regexPosicionamento = "[0-9]+\\s[0-9]+\\s[N|S|E|W]$";
	
	public Map<Integer, Sonda> obterSondasEnviadas(String instrucoesEnviadas);
}
