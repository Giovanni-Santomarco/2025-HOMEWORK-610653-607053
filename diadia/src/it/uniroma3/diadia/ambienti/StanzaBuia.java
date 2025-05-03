package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza {

	public StanzaBuia(String nome) {
		super(nome);
	}
	
	@Override
	public String getDescrizione() {
		if(this.hasAttrezzo("lanterna"))
			return this.toString();
		return "qui c'è buio pesto";
	}
	
}
