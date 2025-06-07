package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Mago extends AbstractPersonaggio {
	
//	private static final String MESSAGGIO_DONO = "Sei un vero simpaticone, " +
//			"con una mia magica azione, troverai un nuovo oggetto " +
//			"per il tuo borsone!";
//	
//	private static final String MESSAGGIO_SCUSE = "Mi spiace, ma non ho piu' nulla...";
	
	private Attrezzo attrezzo;
	
	public Mago(String nome, String presentazione, Attrezzo attrezzo) {
		super(nome, presentazione);
		this.attrezzo = attrezzo;
	}
	
	@Override
	public String agisci(Partita partita) {
		String msg;
		if (this.attrezzo!=null) {
			partita.getStanzaCorrente().addAttrezzo(this.attrezzo);
			this.attrezzo = null;
			msg = DiaDia.getMESSAGGIO_DONO_MAGO();
		}
		else {
			msg = DiaDia.getMESSAGGIO_SCUSE_MAGO();
		}
		return msg;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		
		partita.getGiocatore().getBorsa().removeAttrezzo(attrezzo.getNome());
		attrezzo.setPeso(attrezzo.getPeso()/2);
		partita.getStanzaCorrente().addAttrezzo(attrezzo);
		
		return "ti ringrazio del dono, ma io declino l'offerta, nonostante ciò ora sarà più leggero";
	}
	
}