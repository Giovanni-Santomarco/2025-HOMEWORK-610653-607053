package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Labirinto.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.comandi.ComandoVai;

class ComandoVaiTest {
	private ComandoVai vai;
	private String direzione;
	private Partita partita;
	private IOConsole console;
	private Stanza stanzacorrente;
	private Stanza prossimastanza;
	
	
	@BeforeEach
	void setUp() throws Exception{
		this.vai = new ComandoVai();
		this.direzione = "nord";
		this.partita = new Partita(new LabirintoBuilder().build().getLabirinto());
		this.console = new IOConsole();
		this.stanzacorrente = new Stanza("atrio");
		this.prossimastanza = new Stanza("biblioteca");
		
		this.vai.setParametro(direzione);
		this.stanzacorrente.impostaStanzaAdiacente(Direzione.valueOf(direzione.trim().toUpperCase()), prossimastanza);
		this.partita.setStanzaCorrente(stanzacorrente);
	}

	@Test
	void testComandoVaiNormale() {
		vai.esegui(partita, console);
		assertEquals(prossimastanza,this.partita.getStanzaCorrente());
	}
}