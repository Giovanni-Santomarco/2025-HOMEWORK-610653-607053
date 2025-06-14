package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;




import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto.LabirintoBuilder;



class PartitaTest {
	private Partita partita;
	
	
	@BeforeEach
	void setUp() throws Exception{
		this.partita = new Partita(new LabirintoBuilder().build().getLabirinto());
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
