package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

class BorsaTest {
	private Borsa borsa;
	private Attrezzo siringa;
	private Attrezzo lancia;
	private Attrezzo scudo;
	
	@BeforeEach
	void setUp() throws Exception {
		this.borsa = new Borsa();
		this.siringa = new Attrezzo("siringa", 1);
		this.lancia = new Attrezzo("lancia", 10);
		this.scudo = new Attrezzo("scudo", 5);
	}

	@Test
	void testAddAttrezzoInBorsa() {
		assertTrue(this.borsa.addAttrezzo(lancia));
		assertFalse(this.borsa.addAttrezzo(siringa));
	}
	
	@Test
	void testGetAttrezzoDaBorsa() {
		this.borsa.addAttrezzo(siringa);
		this.borsa.addAttrezzo(scudo);
		assertEquals(null, this.borsa.getAttrezzo("lancia"));
		assertEquals(scudo, this.borsa.getAttrezzo("scudo"));
		assertEquals(siringa, this.borsa.getAttrezzo("siringa"));
	}
	
	@Test
	void testGetPesoBorsa() {
		this.borsa.addAttrezzo(siringa);
		this.borsa.addAttrezzo(scudo);
		assertEquals(6, this.borsa.getPeso());
	}
	
	@Test
	void testRemoveAttrezzoDaBorsa() {
		assertEquals(null, this.borsa.removeAttrezzo("siringa"));
		this.borsa.addAttrezzo(siringa);
		this.borsa.addAttrezzo(scudo);
		assertEquals(siringa, this.borsa.removeAttrezzo("siringa"));
		assertEquals(scudo, this.borsa.removeAttrezzo("scudo"));
		
	}
	
}
