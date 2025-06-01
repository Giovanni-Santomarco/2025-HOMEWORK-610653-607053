package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPosa;

class ComandoPosaTest {
	private ComandoPosa posa;
	private Partita partita;
	private IOConsole console;
	private String att;
	private Attrezzo corno;
	
	@BeforeEach
	void setUp() throws Exception{
		this.posa = new ComandoPosa();
		this.partita = new Partita(new LabirintoBuilder().build().getLabirinto());
		this.console = new IOConsole();
		this.corno = new Attrezzo("corno", 1);
		this.att= "corno";
		this.partita.getGiocatore().getBorsa().addAttrezzo(corno);
		
		
		
	}
	@Test
	void testEsegui() {
		posa.setParametro(att);
		posa.esegui(partita, console);
		assertTrue(this.partita.getStanzaCorrente().hasAttrezzo(att));
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo(att));
		
	}
	
}