package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa extends AbstractComando {
	
	public ComandoPosa() {
		super("posa");
	}
	
	@Override
	public void esegui(Partita partita, IO io) {
		if(this.getParametro()!=null) {
			//se è presente l'attrezzo NomeAttrezzo in borsa
			if(partita.getGiocatore().getBorsa().getAttrezzo(this.getParametro())!=null) {
				//mi salvo l'attrezzo nella variabile attrezzoDaPosare
				Attrezzo attrezzoDaPosare = partita.getGiocatore().getBorsa().getAttrezzo(this.getParametro());
				//se riesco a posare l'attrezzo nella stanza perchè non piena
				if(partita.getStanzaCorrente().addAttrezzo(attrezzoDaPosare)) {
					//rimuovo allora l'oggetto dalla borsa
					partita.getGiocatore().getBorsa().removeAttrezzo(this.getParametro());
					io.mostraMessaggio("oggetto posato");
				}
				else
					io.mostraMessaggio("la stanza è piena di oggetti");
			}
			else
				io.mostraMessaggio("oggetto non presente in borsa");
		}
	}

}
