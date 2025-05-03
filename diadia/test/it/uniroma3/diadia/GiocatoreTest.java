package it.uniroma3.diadia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.giocatore.Giocatore;

class GiocatoreTest {
	private Giocatore giocatore;
	private int cfu;
	
	@BeforeEach
	void setUp() throws Exception{
		this.giocatore = new Giocatore();
		this.cfu=5;
	}
	@Test
	void testgetCfuandset() {
		this.giocatore.setCfu(cfu);
		assertEquals(cfu,this.giocatore.getCfu());
	}
	@Test
	void testGiocatoreIsVivo() {
		assertTrue(this.giocatore.giocatoreIsVivo());
		this.giocatore.setCfu(0);
		assertFalse(this.giocatore.giocatoreIsVivo());
	}
}