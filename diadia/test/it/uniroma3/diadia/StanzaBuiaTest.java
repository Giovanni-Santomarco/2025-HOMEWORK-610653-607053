package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.StanzaBuia;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBuiaTest {

	private StanzaBuia stanzaBuia;
	
	@BeforeEach
	void setUp() throws Exception {
		this.stanzaBuia = new StanzaBuia("Backrooms");
	}

	@Test
	void test() {
		assertEquals("qui c'è buio pesto",this.stanzaBuia.getDescrizione());
		Attrezzo lanterna = new Attrezzo("lanterna", 3);
		this.stanzaBuia.addAttrezzo(lanterna);
		assertNotEquals("qui c'è buio pesto",this.stanzaBuia.getDescrizione());
	}

}
