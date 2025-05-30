package it.uniroma3.diadia.ambienti;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilder {

	private Labirinto labirinto;
	private Map<String, Stanza> nome2stanza;
	private Stanza ultimaStanza;

	public LabirintoBuilder() {
		this.labirinto = new Labirinto();
		this.nome2stanza = new HashMap<>();
	}

	public LabirintoBuilder addStanza(String nome) {
		Stanza stanza = new Stanza(nome);
		this.addStanza2Map(stanza);
		this.ultimaStanza = stanza;
		return this;
	}

	public void addStanza2Map(Stanza stanza) {
		nome2stanza.put(stanza.getNome(), stanza);
	}
	
	public LabirintoBuilder addStanzaIniziale(String nome) {
		Stanza stanza = new Stanza(nome);
		this.labirinto.setStanzaIniziale(stanza);
		this.addStanza2Map(stanza);
		this.ultimaStanza = stanza;
		return this;
	}
	
	public LabirintoBuilder addStanzaVincente(String nome) {
		Stanza stanza = new Stanza(nome);
		this.labirinto.setStanzaFinale(stanza);
		this.addStanza2Map(stanza);
		this.ultimaStanza = stanza;
		return this;
	}
	
	public LabirintoBuilder addAttrezzo(String nomeAttrezzo, int weight) {
		Attrezzo attrezzo = new Attrezzo(nomeAttrezzo, weight);
		this.ultimaStanza.addAttrezzo(attrezzo);
		return this;
	}
	
	public LabirintoBuilder addAdiacenza(String stanzaDiPartenza, String stanzaDiArrivo, String direzione) {
		Stanza stanzaIn = this.nome2stanza.get(stanzaDiPartenza);
		if(stanzaIn.getDirezioni().size()>=4 || stanzaIn==null) {
			return this;
		}
		Stanza stanzaArrivo = this.nome2stanza.get(stanzaDiArrivo);
		if(stanzaArrivo!=null) {
			stanzaIn.impostaStanzaAdiacente(direzione, stanzaArrivo);			
		}
		return this;
	}
	
	public LabirintoBuilder addStanzaMagica(String nomeStanzaMagica, int sogliaMagica) {
		Stanza stanzaMagica = new StanzaMagica(nomeStanzaMagica, sogliaMagica);
		this.addStanza2Map(stanzaMagica);
		this.ultimaStanza = stanzaMagica;
		return this;
	}
	
	public LabirintoBuilder addStanzaBuia(String nomeStanzaBuia) {
		Stanza stanzaBuia = new StanzaBuia(nomeStanzaBuia);
		this.addStanza2Map(stanzaBuia);
		this.ultimaStanza = stanzaBuia;
		return this;
	}
	
	public LabirintoBuilder addStanzaBloccata(String nomeStanzaBloccata, String direzioneBloccata, String chiave) {
		Stanza stanzaBloccata = new StanzaBloccata(nomeStanzaBloccata, direzioneBloccata, chiave);
		this.addStanza2Map(stanzaBloccata);
		this.ultimaStanza = stanzaBloccata;
		return this;
	}

	public Labirinto getLabirinto() {
		return labirinto;
	}

	public Map<String, Stanza> getNome2stanza() {
		return nome2stanza;
	}

	public Map<String, Stanza> getListaStanze() {
		return nome2stanza;
	}

	
	
	
	
	
	

}
