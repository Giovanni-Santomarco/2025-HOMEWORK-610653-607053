package it.uniroma3.diadia;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPrendi;

class ComandoPrendiTest {
	private ComandoPrendi prendi;
	private Attrezzo attrezzo;
	private Partita partita;
	private IOConsole console;
	private String att;

	@BeforeEach
	void setUp() throws Exception {
		this.prendi = new ComandoPrendi();
		this.attrezzo = new Attrezzo("chiave", 1);
		this.partita = new Partita();
		this.console= new IOConsole();
		this.att = "chiave";
		partita.getStanzaCorrente().addAttrezzo(attrezzo);
		
	}

	@Test
	void eseguiTest() {
		prendi.setParametro(att);
		prendi.esegui(partita, console);
		assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo(this.attrezzo.getNome()));
		assertTrue(partita.getStanzaCorrente().hasAttrezzo(this.attrezzo.getNome()));
		
	}
}