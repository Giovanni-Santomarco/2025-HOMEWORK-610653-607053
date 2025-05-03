package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {
	
	private String NomeAttrezzo;

	@Override
	public void esegui(Partita partita, IO io) {
		if(NomeAttrezzo!=null) {
			//controlla se l'attrezzo nomeAttrezzo é presente nella stanza
			if(partita.getStanzaCorrente().getAttrezzo(NomeAttrezzo)!=null) {
				//mi salvo l'attrezzo nella variabile AttrezzoDaCancellare
				Attrezzo AttrezzoDaCancellare = partita.getStanzaCorrente().getAttrezzo(NomeAttrezzo);
				//se riesco ad aggiungere l'oggetto in borsa
				if(partita.getGiocatore().getBorsa().addAttrezzo(AttrezzoDaCancellare)) {
					//lo rimuovo dalla stanza
					partita.getStanzaCorrente().removeAttrezzo(AttrezzoDaCancellare);
					io.mostraMessaggio("oggetto preso");
				}
				else
					io.mostraMessaggio("borsa piena");
			}
			else
				io.mostraMessaggio("oggetto non trovato nella stanza");
		}
		else
			io.mostraMessaggio("comando inesistente");
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
		this.NomeAttrezzo=parametro;
	}

}