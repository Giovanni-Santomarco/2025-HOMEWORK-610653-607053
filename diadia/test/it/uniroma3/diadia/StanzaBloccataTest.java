package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBloccata;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBloccataTest {

	private StanzaBloccata stanzaBloccata;
	private Stanza stanza;
	private Stanza stanza2;
	
	@BeforeEach
	void setUp() throws Exception {
		this.stanza = new Stanza("tugurio");
		this.stanza2 =new Stanza("sgabuzzino");
		this.stanzaBloccata = new StanzaBloccata("scale", Direzione.NORD, "chiave");
		this.stanza.impostaStanzaAdiacente(Direzione.SUD, stanzaBloccata);
		this.stanzaBloccata.impostaStanzaAdiacente(Direzione.NORD, stanza);
		this.stanza2.impostaStanzaAdiacente(Direzione.EST, stanzaBloccata);
		this.stanzaBloccata.impostaStanzaAdiacente(Direzione.OVEST, stanza2);
	}

	@Test
	void testGetStanzaAdiacente() {
		assertEquals(this.stanza2, this.stanzaBloccata.getStanzaAdiacente(Direzione.OVEST));
		assertEquals(this.stanzaBloccata, this.stanzaBloccata.getStanzaAdiacente(Direzione.NORD));
		Attrezzo chiave = new Attrezzo("chiave", 1);
		this.stanzaBloccata.addAttrezzo(chiave);
		assertEquals(this.stanza, this.stanzaBloccata.getStanzaAdiacente(Direzione.NORD));
	}
	
	@Test
	void testGetDescrizione() {
		String descrizione = this.stanzaBloccata.getDescrizione();
		assertEquals(descrizione, this.stanzaBloccata.toString()+"\nla porta a NORD è chiusa e per aprirla serve chiave");
	}

}
