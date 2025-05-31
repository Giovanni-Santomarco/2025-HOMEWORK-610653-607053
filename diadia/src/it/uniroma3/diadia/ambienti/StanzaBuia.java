package it.uniroma3.diadia.ambienti;

/*
 * 	questa stanza non ti permette di vedere le uscite solo c'è una lanterna nella stanza
 * 
 */

public class StanzaBuia extends Stanza {
	
	final static private String ATTREZZO_PER_VEDERE_DEFAULT = "lanterna";
	private String attrezzoPerVedere;

	public StanzaBuia(String nome, String attrezzoPerVedere) {
		super(nome);
		this.attrezzoPerVedere = attrezzoPerVedere;
	}
	
	
	public StanzaBuia(String nome) {
		this(nome, ATTREZZO_PER_VEDERE_DEFAULT);
	}
	
	@Override
	public String getDescrizione() {
		if(this.hasAttrezzo(attrezzoPerVedere))
			return this.toString();
		return "qui c'è buio pesto";
	}
	
}