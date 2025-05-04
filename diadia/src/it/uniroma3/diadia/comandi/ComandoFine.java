package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;

import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando {

	@Override
	public void esegui(Partita partita, IO io) {
		io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
		partita.setFinita();
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
