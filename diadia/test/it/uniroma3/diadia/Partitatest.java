package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class Partitatest {
	private Partita partita;
	
	
	@BeforeEach
	void setUp() throws Exception{
		this.partita = new Partita();
	}
	
	@Test
	void testPartitaNonVinta() {
		assertFalse(this.partita.isFinita());
	}
	
	@Test
	void testPartitaVinta() {
		this.partita.setStanzaCorrente(this.partita.getLabirinto().getStanzaFinale());
		assertTrue(this.partita.isFinita());
	}
	
	@Test
	void testPartitaNonFinitaPoiFinita() {
		assertFalse(this.partita.isFinita());
		this.partita.setStanzaCorrente(this.partita.getLabirinto().getStanzaFinale());
		assertTrue(this.partita.isFinita());
	}
}
