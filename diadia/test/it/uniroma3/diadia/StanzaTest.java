package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class StanzaTest {
	private Stanza stanza;
	private Stanza stanzaAdiacente;
	private Attrezzo spada;
	private Attrezzo chiave;
	
	@BeforeEach
	void setUp() throws Exception{
		this.stanza = new Stanza("n11");
		this.stanzaAdiacente = new Stanza("n12");
		this.spada = new Attrezzo("spada",5);
		this.chiave = new Attrezzo("chiave", 1);
	}
	
	@Test
	void testHasAttrezzoStanzaVuota() {
		assertFalse(this.stanza.hasAttrezzo("spada"));
		this.stanza.addAttrezzo(this.spada);
		assertTrue(this.stanza.hasAttrezzo("spada"));
	}
	@Test
	void testRemoveAttrezzo() {
		assertFalse(this.stanza.removeAttrezzo(spada));
		this.stanza.addAttrezzo(this.spada);
		this.stanza.addAttrezzo(this.chiave);
		assertTrue(this.stanza.removeAttrezzo(spada));
		assertTrue(this.stanza.removeAttrezzo(chiave));
	}
	
	@Test
	void testGetAttrezzo() {
		assertEquals(null, this.stanza.getAttrezzo("spada"));
		this.stanza.addAttrezzo(this.spada);
		this.stanza.addAttrezzo(this.chiave);
		assertEquals(this.spada , this.stanza.getAttrezzo("spada"));
		assertEquals(this.chiave , this.stanza.getAttrezzo("chiave"));
	}
	
	@Test
	void testGetStanzaAdiacenteANDtestImpostaStanzaAdiacente() {
		assertEquals(null, this.stanza.getStanzaAdiacente("nord"));
		stanza.impostaStanzaAdiacente("nord", stanzaAdiacente);
		assertEquals(this.stanzaAdiacente, this.stanza.getStanzaAdiacente("nord"));
	}
	
}
