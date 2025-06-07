package it.uniroma3.diadia;

import static org.junit.Assert.*;


import java.io.StringReader;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Stanza;

public class CaricatoreLabirintoTest {

	private CaricatoreLabirinto caricatore;

	@Before
	public void setUp() {
		String labirintoStr = 
				"Stanze: biblioteca, N11\n" 
				+ "StanzeBuie: N10 lanterna\n"
				+ "StanzeMagiche: Laboratorio-Campus 3\n"
				+ "StanzeBloccate: atrio nord chiave\n"
				+ "Inizio: atrio\n"
				+ "Vincente: biblioteca\n" 
				+ "Attrezzi: osso 1 atrio, lancia 4 atrio, scudo 7 atrio, lanterna 3 N10, chiave 1 N11\n"
				+ "Personaggi: strega N10 Sono-Bulabula-la-permalosa, mago Laboratorio-Campus Sono-il-mago-dei-polli pollo 4, cane N11 Sono-Buld-il-cane-parlante escrementi 1\n"
				+ "Uscite: atrio nord biblioteca, atrio est N11, atrio sud N10, atrio ovest Laboratorio-Campus\n";
		
		caricatore = new CaricatoreLabirinto(new StringReader(labirintoStr));
	}

	@Test
	public void testLeggiECreaStanze() throws Exception {
		caricatore.leggiECreaStanze();
		Map<String, Stanza> stanze = caricatore.getNome2stanza();
		assertEquals(2, stanze.size());
		assertTrue(stanze.containsKey("biblioteca"));
		assertTrue(stanze.containsKey("N11"));
	}

	@Test
	public void testLeggiECreaStanzeBuie() throws Exception {
		caricatore.leggiECreaStanze();
		caricatore.leggiECreaStanzeBuie();
		Map<String, Stanza> stanze = caricatore.getNome2stanza();
		assertEquals(3, stanze.size());
		assertTrue(stanze.containsKey("biblioteca"));
		assertTrue(stanze.containsKey("N11"));
		assertTrue(stanze.containsKey("N10"));
	}
	
	@Test
	public void testLeggiECreaStanzeMagiche() throws Exception {
		caricatore.leggiECreaStanze();
		caricatore.leggiECreaStanzeBuie();
		caricatore.leggiECreaStanzeMagiche();
		Map<String, Stanza> stanze = caricatore.getNome2stanza();
		assertEquals(4, stanze.size());
		assertTrue(stanze.containsKey("biblioteca"));
		assertTrue(stanze.containsKey("N11"));
		assertTrue(stanze.containsKey("N10"));
		assertTrue(stanze.containsKey("Laboratorio Campus"));
	}
	
	@Test
	public void testLeggiECreaStanzeBloccate() throws Exception {
		caricatore.leggiECreaStanze();
		caricatore.leggiECreaStanzeBuie();
		caricatore.leggiECreaStanzeMagiche();
		caricatore.leggiECreaStanzeBloccate();
		Map<String, Stanza> stanze = caricatore.getNome2stanza();
		assertEquals(5, stanze.size());
		assertTrue(stanze.containsKey("biblioteca"));
		assertTrue(stanze.containsKey("N11"));
		assertTrue(stanze.containsKey("N10"));
		assertTrue(stanze.containsKey("Laboratorio Campus"));
		assertTrue(stanze.containsKey("atrio"));
	}
	
	@Test
	public void testLeggiInizialeEVincente() throws Exception {
		caricatore.leggiECreaStanze();
		caricatore.leggiECreaStanzeBuie();
		caricatore.leggiECreaStanzeMagiche();
		caricatore.leggiECreaStanzeBloccate();
		caricatore.leggiInizialeEvincente();
		assertEquals("atrio", caricatore.getStanzaIniziale().getNome());
		assertEquals("biblioteca", caricatore.getStanzaVincente().getNome());
	}

	@Test
	public void testLeggiECollocaAttrezzi() throws Exception {
		caricatore.leggiECreaStanze();
		caricatore.leggiECreaStanzeBuie();
		caricatore.leggiECreaStanzeMagiche();
		caricatore.leggiECreaStanzeBloccate();
		caricatore.leggiInizialeEvincente();
		caricatore.leggiECollocaAttrezzi();
		
		Stanza atrio = caricatore.getNome2stanza().get("atrio");
		Stanza n10 = caricatore.getNome2stanza().get("N10");
		Stanza n11 = caricatore.getNome2stanza().get("N11");

		assertNotNull(atrio.getAttrezzo("osso"));
		assertEquals(1, atrio.getAttrezzo("osso").getPeso());
		
		assertNotNull(atrio.getAttrezzo("lancia"));
		assertEquals(4, atrio.getAttrezzo("lancia").getPeso());
		
		assertNotNull(atrio.getAttrezzo("scudo"));
		assertEquals(7, atrio.getAttrezzo("scudo").getPeso());

		assertNotNull(n10.getAttrezzo("lanterna"));
		assertEquals(3, n10.getAttrezzo("lanterna").getPeso());
		
		assertNotNull(n11.getAttrezzo("chiave"));
		assertEquals(1, n11.getAttrezzo("chiave").getPeso());
	}
	
	@Test
	public void testLeggiEAggiungiPersonaggio() throws Exception {
		caricatore.leggiECreaStanze();
		caricatore.leggiECreaStanzeBuie();
		caricatore.leggiECreaStanzeMagiche();
		caricatore.leggiECreaStanzeBloccate();
		caricatore.leggiInizialeEvincente();
		caricatore.leggiECollocaAttrezzi();
		caricatore.leggiEAggiungiPersonaggio();
		
		Stanza n10 = caricatore.getNome2stanza().get("N10");
		Stanza n11 = caricatore.getNome2stanza().get("N11");
		Stanza LaboratorioCampus = caricatore.getNome2stanza().get("Laboratorio Campus");
		
		assertNotNull(n10.getPersonaggio());
		assertNotNull(n11.getPersonaggio());
		assertNotNull(LaboratorioCampus.getPersonaggio());
	}

	@Test
	public void testLeggiEImpostaUscite() throws Exception {
		caricatore.leggiECreaStanze();
		caricatore.leggiECreaStanzeBuie();
		caricatore.leggiECreaStanzeMagiche();
		caricatore.leggiECreaStanzeBloccate();
		caricatore.leggiInizialeEvincente();
		caricatore.leggiECollocaAttrezzi();
		caricatore.leggiEAggiungiPersonaggio();
		caricatore.leggiEImpostaUscite();

		Stanza atrio = caricatore.getNome2stanza().get("atrio");

		assertEquals("N10", atrio.getStanzaAdiacente(Direzione.SUD).getNome());
		assertEquals("N11", atrio.getStanzaAdiacente(Direzione.EST).getNome());
		assertEquals("Laboratorio Campus", atrio.getStanzaAdiacente(Direzione.OVEST).getNome());
	}
	
	
}

