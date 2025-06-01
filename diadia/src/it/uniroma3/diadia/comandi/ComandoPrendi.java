package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi extends AbstractComando {
	
	public ComandoPrendi() {
		super("prendi");
	}

	@Override
	public void esegui(Partita partita, IO io) {
		if(this.getParametro()!=null) {
			//controlla se l'attrezzo nomeAttrezzo é presente nella stanza
			if(partita.getStanzaCorrente().getAttrezzo(this.getParametro())!=null) {
				//mi salvo l'attrezzo nella variabile AttrezzoDaCancellare
				Attrezzo AttrezzoDaCancellare = partita.getStanzaCorrente().getAttrezzo(this.getParametro());
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
			io.mostraMessaggio("devi scegliere un oggetto da prendere");
	}


}