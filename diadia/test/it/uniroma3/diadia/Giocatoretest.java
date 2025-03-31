package it.uniroma3.diadia;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.giocatore.Giocatore;

class Giocatoretest {
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
}