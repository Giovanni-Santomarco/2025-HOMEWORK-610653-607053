package it.uniroma3.diadia;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.comandi.ComandoPrendi;

class ComandoPrendiTest {
	
	private Partita partita;
	private IOConsole console;
	private ComandoPrendi prendi;

	@BeforeEach
	void setUp() throws Exception {
		this.prendi = new ComandoPrendi();
		this.prendi.setParametro("lancia");
		this.partita = new Partita();
		this.console = new IOConsole();
	}

	@Test
	void eseguiTest() {
		prendi.esegui(partita, console);
		//"oggetto preso"
		this.prendi.setParametro("scudo");
		prendi.esegui(partita, console);
		//"borsa piena"
		this.prendi.setParametro("pork");
		prendi.esegui(partita, console);
		this.prendi.setParametro(null);
		//"oggetto non trovato nella stanza"
		prendi.esegui(partita, console);
		//"comando inesistente"
	}

}
