package it.uniroma3.diadia;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.comandi.ComandoPosa;
import it.uniroma3.diadia.comandi.ComandoPrendi;

class ComandoPosaTest {
	
	private Partita partita;
	private IOConsole console;
	private ComandoPosa posa;
	private ComandoPrendi prendi;

	@BeforeEach
	void setUp() throws Exception {
		this.partita = new Partita();
		this.console = new IOConsole();
		this.prendi = new ComandoPrendi();
		this.posa = new ComandoPosa();
		this.prendi.setParametro("lancia");
		prendi.esegui(partita, console);
		this.prendi.setParametro("osso");
		prendi.esegui(partita, console);
	}

	@Test
	void test() {
		this.posa.setParametro("osso");
		this.posa.esegui(partita, console);
		//
		this.posa.setParametro("scudo");
		this.posa.esegui(partita, console);
		//
		this.posa.setParametro("lancia");
		this.posa.esegui(partita, console);
		//
	}

}
