package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai extends AbstractComando {

	public ComandoVai() {
		super("vai");
	}

	/**
	 * esecuzione del comando
	 */
	@Override
	public void esegui(Partita partita, IO io) {
		Direzione direzione;
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Stanza prossimaStanza = null;
		if (this.getParametro()==null) {
			io.mostraMessaggio("Dove vuoi andare?\nDevi specificare una direzione");
			return;
		}
		try {
			direzione = Direzione.valueOf(getParametro().trim().toUpperCase());
		}catch(IllegalArgumentException e){
			io.mostraMessaggio("la direzione scelta non è valida");
			return;
		}
		prossimaStanza = stanzaCorrente.getStanzaAdiacente(direzione);


		if (prossimaStanza==null) {
			io.mostraMessaggio("Direzione inesistente");
			return;
		}
		partita.setStanzaCorrente(prossimaStanza);
		if(prossimaStanza!=stanzaCorrente) {
			partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		}
		io.mostraMessaggio(partita.toString());
	}

}