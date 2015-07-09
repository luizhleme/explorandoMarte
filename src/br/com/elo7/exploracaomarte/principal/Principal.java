package br.com.elo7.exploracaomarte.principal;

import java.io.IOException;

import br.com.elo7.exploracaomarte.modelo.Nasa;

public class Principal {

	public static void main(String[] args) throws IOException {
		String instrucoes =   "5 5\n"+
	              "1 2 N\n"+
		  		  "LMLMLMLMM\n"+
		  		  "3 3 E\n"+
		  		  "MMRMMRMRRM\n";
		try {
			Nasa nasa = new Nasa();
			nasa.adicionarSondas(instrucoes.toString());
			nasa.controlarSondas();
			System.out.println(nasa.localizarSondas());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
