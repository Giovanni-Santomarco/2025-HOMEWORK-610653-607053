package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza {

	private Direzione direzioneBloccata;
	private String chiave;

	public StanzaBloccata(String nome, Direzione direzioneBloccata, String chiave) {
		super(nome);
		this.direzioneBloccata = direzioneBloccata;
		this.chiave = chiave;
	}
	
	@Override
	public Stanza getStanzaAdiacente(Direzione direzione) {
		Stanza stanza = this;
		
		if(!direzione.equals(this.direzioneBloccata)) {
			stanza = super.getStanzaAdiacente(direzione);
		}
		
		if(direzione.equals(this.direzioneBloccata)) {
			if(super.hasAttrezzo(chiave)) {
				stanza = super.getStanzaAdiacente(direzione);
			}
		}

		return stanza;
	}

	public Direzione getDirezioneBloccata() {
		return direzioneBloccata;
	}

	public String getChiave() {
		return chiave;
	}

	@Override
	public String getDescrizione() {
		return super.toString()+"\nla porta a "+this.direzioneBloccata+" è chiusa e per aprirla serve "+this.chiave;
	}
}
