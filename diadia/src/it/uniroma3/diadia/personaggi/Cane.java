package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio {
	
	private static final String NOME_CIBO_PREFERITO = "osso";
	private Attrezzo attrezzoDelCane;

	public Cane(String nome, String presentaz ,Attrezzo attr) {
		super(nome, presentaz);
		this.attrezzoDelCane = attr;
	}

	@Override
	public String agisci(Partita partita) {
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		
		return "il cane ti ha morso il deretano, ferendoti, facendoti così perdere un cfu";
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		
		if(attrezzo.getNome().equals(NOME_CIBO_PREFERITO)) {
			partita.getStanzaCorrente().addAttrezzo(attrezzoDelCane);
			return "hai dato al cane il suo cibo preferito! ti ringrazia lasciando nella stanza...";
		}
		
		else {
			return this.agisci(partita) + "\nquesto perchè non gli hai dato quello che bramava";
		}
	}
	
}
