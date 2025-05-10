package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;

import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando {
	static final private String[] elencoComandi = {"vai", "aiuto" , "fine" , "prendi", "posa", "guarda"};
	
	@Override
	public void esegui(Partita partita, IO io) {
		StringBuilder s = new StringBuilder();
		for(int i=0; i< elencoComandi.length; i++) 
			s.append(elencoComandi[i]+"\n");
		io.mostraMessaggio(s.toString());
	}

	@Override
	public String getParametro() {
		return null;
	}

	@Override
	public String getNome() {
		return null;
	}

	@Override
	public void setParametro(String parametro) {
	}

}
