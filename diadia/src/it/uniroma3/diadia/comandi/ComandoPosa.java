package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando {

	private String NomeAttrezzo;
	
	@Override
	public void esegui(Partita partita, IO io) {
		if(NomeAttrezzo!=null) {
			//se è presente l'attrezzo NomeAttrezzo in borsa
			if(partita.getGiocatore().getBorsa().getAttrezzo(NomeAttrezzo)!=null) {
				//mi salvo l'attrezzo nella variabile attrezzoDaPosare
				Attrezzo attrezzoDaPosare = partita.getGiocatore().getBorsa().getAttrezzo(NomeAttrezzo);
				//se riesco a posare l'attrezzo nella stanza perchè non piena
				if(partita.getStanzaCorrente().addAttrezzo(attrezzoDaPosare)) {
					//rimuovo allora l'oggetto dalla borsa
					partita.getGiocatore().getBorsa().removeAttrezzo(NomeAttrezzo);
					io.mostraMessaggio("oggetto posato");
				}
				else
					io.mostraMessaggio("la stanza è piena di oggetti");
			}
			else
				io.mostraMessaggio("oggetto non presente in borsa");
		}
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
