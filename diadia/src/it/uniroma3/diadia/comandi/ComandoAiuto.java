package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;

import it.uniroma3.diadia.Partita;

public class ComandoAiuto extends AbstractComando {
	static final private String[] elencoComandi = {"vai", "aiuto" , "fine" , "prendi", "posa", "guarda", "interagisci", "saluta"};
	
	public ComandoAiuto() {
		super("aiuto");
	}
	
	@Override
	public void esegui(Partita partita, IO io) {
		StringBuilder s = new StringBuilder();
		for(int i=0; i< elencoComandi.length; i++) 
			s.append(elencoComandi[i]+"\n");
		io.mostraMessaggio(s.toString());
	}

}
