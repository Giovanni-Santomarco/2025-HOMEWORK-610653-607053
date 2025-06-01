package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoInteragisci;
import it.uniroma3.diadia.comandi.ComandoRegala;
import it.uniroma3.diadia.comandi.ComandoSaluta;
import it.uniroma3.diadia.personaggi.Strega;

class StregaTest {
	
	private LabirintoBuilder builder;
	private Labirinto labirinto;
	private Partita partita;
	private IO console;
	

	@BeforeEach
	void setUp() throws Exception {
		this.builder = new LabirintoBuilder();
		this.labirinto = builder.addStanzaIniziale("N10").addPersonaggio(new Strega("Strega", " Sono Bulabula la permalosa"))
		.addStanza("N11").addAttrezzo("martello", 1).addAttrezzo("maglio", 6)
		.addStanza("N12")
		.addStanza("N13").addAttrezzo("piccone", 7)
		.addStanza("N14").addAttrezzo("osso", 1).addAttrezzo("bazooka", 9).addAttrezzo("chiave", 1)
		.addAdiacenza("N10", "N11", "nord").addAdiacenza("N11", "N10", "sud")	//N11 2 
		.addAdiacenza("N10", "N12", "sud").addAdiacenza("N12", "N10", "nord")	//N12 0
		.addAdiacenza("N10", "N13", "est").addAdiacenza("N13", "N10", "ovest")	//N13 1
		.addAdiacenza("N10", "N14", "ovest").addAdiacenza("N14", "N10", "est")	//N14 3
		.getLabirinto();
		this.partita = new Partita(labirinto);
		this.console = new IOConsole();
	}

	@Test
	void testEseguiStregaSenzaSalutare() {
		ComandoInteragisci interact = new ComandoInteragisci();
		interact.esegui(partita, console);
		assertEquals(partita.getStanzaCorrente(), builder.getMappaStanze().get("N12"));
	}
	
	@Test
	void testEseguiStregaDopoSaluto() {
		ComandoSaluta saluta = new ComandoSaluta();
		ComandoInteragisci interact = new ComandoInteragisci();
		saluta.esegui(partita, console);
		interact.esegui(partita, console);
		assertEquals(partita.getStanzaCorrente(), builder.getMappaStanze().get("N14"));
	}
	
	@Test
	void testRiceviRegalo() {
		this.partita.getGiocatore().getBorsa().addAttrezzo(new Attrezzo("armatura", 9));
		
		ComandoRegala regala = new ComandoRegala();
		
		regala.setParametro("armatura");
		regala.esegui(partita, console);
		
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("armatura"));
		assertFalse(partita.getStanzaCorrente().hasAttrezzo("armatura"));
		
	}

}
