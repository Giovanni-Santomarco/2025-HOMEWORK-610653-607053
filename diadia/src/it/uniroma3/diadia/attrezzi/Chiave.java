package it.uniroma3.diadia.attrezzi;

import it.uniroma3.diadia.ambienti.Porta;

public class Chiave extends Attrezzo {

	public Chiave(String nome, int peso) {
		super(nome, peso);
	}
	
	public boolean apriPorta(Porta porta) {
		if(porta.getChiaveAssociata().equals(nome)) {
			porta.setStatoPorta(true);
		}
		return false;
	}
}
