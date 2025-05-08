package it.uniroma3.diadia;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandi;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

class IOSimulatorTest {
	
	private IOSimulator io;
	private Partita partita;
	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";

	@BeforeEach
	void setUp() throws Exception {
		String[] input1 = {"vai nord","vai sud", "guarda", "prendi lanterna", "guarda", "vai nord", "prendi osso", "prendi lancia", "prendi scudo",
				"vai est", "prendi chiave", "vai ovest", "vai nord", "posa chiave", "guarda", "vai nord"};
		this.io = new IOSimulator(input1);
		this.partita = new Partita();
	}
	
	public void gioca() {
		String istruzione; 


		io.mostraMessaggio(MESSAGGIO_BENVENUTO);      
		do      
			istruzione = io.leggiRiga();
		while (!processaIstruzione(istruzione));
	}   

	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */

	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire;
		FabbricaDiComandi factory = new FabbricaDiComandiFisarmonica();
		comandoDaEseguire = factory.costruisciComando(istruzione);
		comandoDaEseguire.esegui(this.partita, this.io);
		if (this.partita.vinta())

			io.mostraMessaggio("Hai vinto!");
		if (!this.partita.getGiocatore().giocatoreIsVivo() && !this.partita.vinta())

			io.mostraMessaggio("Hai esaurito i CFU...\nGrazie di aver giocato!");

		//forse dovresti mettere setFinita()
		return this.partita.isFinita();
	}

	@Test
	void test() {
		System.out.println("PARTITA 1 (per provare stanzaBloccata e stanzaBuia)\n");
		this.gioca();
		
		
		String[] input2 = {"prendi lancia", "vai est", "prendi chiave", "vai est", "posa lancia", "prendi lancia", "posa lancia", "prendi lancia",
				"posa lancia", "prendi lancia", "posa lancia", "prendi lancia", "prendi aicnal", "posa chiave", "prendi chiave", "prendi evaihc",
				"posa evaihc", "prendi chiave", "posa aicnal", "guarda", "prendi chiave", "vai est", "posa chiave", "vai nord"};
		this.io = new IOSimulator(input2);
		this.partita = new Partita();
		System.out.println("\n\n\nPARTITA 2 (per provare StanzaMagica)\n");
		this.gioca();
		
		String[] input3= {"aiuto", "", "vai", "vai nordEst", "prendi lancia", "prendi scudo", "prendi lanterna", "prendi", "posa lancia", "posa scudo", "fine"};
		this.io = new IOSimulator(input3);
		this.partita = new Partita();
		System.out.println("\n\n\nPARTITA 3 (per provare gli altri comandi)\n");
		this.gioca();
	}

}
