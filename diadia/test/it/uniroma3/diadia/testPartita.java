package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;
import it.uniroma3.diadia.Partita;

class testPartita {
	private Partita Tpartita;
	private Labirinto Tlabirinto;
    private Stanza TstanzaCorrente;		//fixture
    private boolean Tfinita;
    private Giocatore Tgiocatore;
	
    
    @BeforeEach
    public void setUp() {
    	this.Tpartita = new Partita();
    	this.Tlabirinto = new Labirinto();
    	this.TstanzaCorrente = Tlabirinto.getStanzaIniziale();
    	this.Tgiocatore = new Giocatore();
    }
    
	
	@Test
	public void testVinta() {
		assertTrue(Tpartita.vinta());
		fail("Not yet implemented");
	}

}
