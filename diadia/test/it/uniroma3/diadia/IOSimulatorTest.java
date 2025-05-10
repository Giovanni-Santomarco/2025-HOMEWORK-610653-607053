package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class IOSimulatorTest {

	@Test
	void testPartita1() {
		String[] input1 = {"vai nord","vai sud", "guarda", "prendi lanterna", "guarda", "vai nord", "prendi osso", "prendi lancia", "prendi scudo",
				"vai est", "prendi chiave", "vai ovest", "vai nord", "posa chiave", "guarda", "vai nord"};
		IOSimulator io = new IOSimulator(input1);
		DiaDia gioco = new DiaDia(io);
		System.out.println("PARTITA 1 (per provare stanzaBloccata e stanzaBuia)\n");
		gioco.gioca();

		String[] expected = {"messaggioIniziale",
				"Atrio\n" + "Uscite:  nord est sud ovest\n" + "Attrezzi nella stanza: osso (1kg) lancia (4kg) scudo (7kg) \n" + "la porta a nord è chiusa e per aprirla serve chiave\n" + "cfu: 7\n" + "Borsa vuota",
				"Aula N10\n" + "Uscite:  nord est ovest\n" + "Attrezzi nella stanza: lanterna (3kg) \n" + "cfu: 6\n" + "Borsa vuota",
				"Aula N10\n" + "Uscite:  nord est ovest\n" + "Attrezzi nella stanza: lanterna (3kg) \n" + "cfu: 6\n" + "Borsa vuota",
				"oggetto preso",
				"qui c'è buio pesto\n" + "cfu: 6\n" + "Contenuto borsa (3kg/10kg): lanterna (3kg) ",
				"Atrio\n" + "Uscite:  nord est sud ovest\n" + "Attrezzi nella stanza: osso (1kg) lancia (4kg) scudo (7kg) \n" + "la porta a nord è chiusa e per aprirla serve chiave\n" + "cfu: 5\n" + "Contenuto borsa (3kg/10kg): lanterna (3kg) ",
				"oggetto preso",
				"oggetto preso",
				"borsa piena",
				"Aula N11\n" + "Uscite:  est ovest\n" + "Attrezzi nella stanza: chiave (1kg) \n" + "cfu: 4\n" + "Contenuto borsa (8kg/10kg): lanterna (3kg) osso (1kg) lancia (4kg) ",
				"oggetto preso",
				"Atrio\n" + "Uscite:  nord est sud ovest\n" + "Attrezzi nella stanza: scudo (7kg) \n" + "la porta a nord è chiusa e per aprirla serve chiave\n" + "cfu: 3\n" + "Contenuto borsa (9kg/10kg): lanterna (3kg) osso (1kg) lancia (4kg) chiave (1kg) ",
				"Atrio\n" + "Uscite:  nord est sud ovest\n" + "Attrezzi nella stanza: scudo (7kg) \n" + "la porta a nord è chiusa e per aprirla serve chiave\n" + "cfu: 3\n" + "Contenuto borsa (9kg/10kg): lanterna (3kg) osso (1kg) lancia (4kg) chiave (1kg) ",
				"oggetto posato",
				"Atrio\n" + "Uscite:  nord est sud ovest\n" + "Attrezzi nella stanza: scudo (7kg) chiave (1kg) \n" + "la porta a nord è chiusa e per aprirla serve chiave\n" + "cfu: 3\n" + "Contenuto borsa (8kg/10kg): lanterna (3kg) osso (1kg) lancia (4kg) ",
				"Biblioteca\n" + "Uscite:  sud\n" + "Attrezzi nella stanza: \n" + "cfu: 2\n" + "Contenuto borsa (8kg/10kg): lanterna (3kg) osso (1kg) lancia (4kg) ",
		"Hai vinto!"};

		String[] output = io.getOutput();
		int i=1;
		while(i<output.length && i<expected.length && expected[i]!=null && output[i]!=null) {
			assertEquals(expected[i], output[i]);
			i++;
		}
	}

	
	@Test
	void testPartita2() {
		String[] input2 = {"prendi lancia", "vai est", "prendi chiave", "vai est", "posa lancia", "prendi lancia", "posa lancia", "prendi lancia",
				"posa lancia", "prendi lancia", "posa lancia", "prendi lancia", "prendi aicnal", "posa chiave", "prendi chiave", "prendi evaihc",
				"posa evaihc", "prendi chiave", "posa aicnal", "guarda", "prendi chiave", "vai est", "posa chiave", "vai nord"};
		IOSimulator io = new IOSimulator(input2);
		DiaDia gioco = new DiaDia(io);
		System.out.println("\n\n\nPARTITA 2 (per provare StanzaMagica)\n");
		gioco.gioca();


		String[] expected = {"messaggioIniziale",
				"oggetto preso",
				"Aula N11\n" + "Uscite:  est ovest\n" + "Attrezzi nella stanza: chiave (1kg) \n" + "cfu: 6\n" + "Contenuto borsa (4kg/10kg): lancia (4kg) ",
				"oggetto preso",
				"Laboratorio Campus\n" + "Uscite:  est ovest\n" + "Attrezzi nella stanza: \n" + "cfu: 5\n" + "Contenuto borsa (5kg/10kg): lancia (4kg) chiave (1kg) ",
				"oggetto posato",
				"oggetto preso",
				"oggetto posato",
				"oggetto preso",
				"oggetto posato",
				"oggetto preso",
				"oggetto posato",
				"oggetto non trovato nella stanza",
				"oggetto preso",
				"oggetto posato",
				"oggetto non trovato nella stanza",
				"oggetto preso",
				"oggetto posato",
				"borsa piena",
				"oggetto posato",
				"Laboratorio Campus\n" + "Uscite:  est ovest\n" + "Attrezzi nella stanza: chiave (4kg) lancia (16kg) \n" + "cfu: 5\n" + "Borsa vuota",
				"oggetto preso",
				"Atrio\n" + "Uscite:  nord est sud ovest\n" + "Attrezzi nella stanza: osso (1kg) scudo (7kg) \n" + "la porta a nord è chiusa e per aprirla serve chiave\n" + "cfu: 4\n" + "Contenuto borsa (4kg/10kg): chiave (4kg) ",
				"oggetto posato",
				"Biblioteca\n" + "Uscite:  sud\n" + "Attrezzi nella stanza: \n" + "cfu: 3\n" + "Borsa vuota",
				"Hai vinto!"};

		String[] output = io.getOutput();
		int i=1;
		while(i<output.length && i<expected.length && expected[i]!=null && output[i]!=null) {
			assertEquals(expected[i], output[i]);
			i++;
		}
	}
	
	@Test
	void testPartita3() {
		String[] input3= {"aiuto", "", "vai", "vai nordEst", "prendi lancia", "prendi scudo", "prendi lanterna", "prendi", "posa lancia", "posa scudo", "fine"};
		IOSimulator io = new IOSimulator(input3);
		DiaDia gioco = new DiaDia(io);
		System.out.println("\n\n\nPARTITA 3 (per provare gli altri comandi)\n");
		gioco.gioca();
		
		String[] expected = {"messaggioIniziale",
				"vai\n" + "aiuto\n" + "fine\n" + "prendi\n" + "posa\n" + "guarda\n",
				"comando non valido",
				"Dove vuoi andare?\nDevi specificare una direzione",
				"Direzione inesistente",
				"oggetto preso",
				"borsa piena",
				"oggetto non trovato nella stanza",
				"devi scegliere un oggetto da prendere",
				"oggetto posato",
				"oggetto non presente in borsa",
				"Grazie di aver giocato!"};
		
		String[] output = io.getOutput();
		int i=1;
		while(i<output.length && i<expected.length && expected[i]!=null && output[i]!=null) {
			assertEquals(expected[i], output[i]);
			i++;
		}
	}

}
