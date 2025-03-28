package it.uniroma3.diadia;


import java.util.Scanner;


import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre e anche luigi
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";

	static final private String[] elencoComandi = {"vai", "aiuto" , "fine" , "prendi", "posa"};

	private Partita partita;


	public DiaDia() {
		this.partita = new Partita();
	}

	public void gioca() {
		String istruzione; 
		Scanner scannerDiLinee;

		System.out.println(MESSAGGIO_BENVENUTO);
		scannerDiLinee = new Scanner(System.in);        
		do      
			istruzione = scannerDiLinee.nextLine();
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);
		if(comandoDaEseguire.getNome()!=null) {
			if (comandoDaEseguire.getNome().equals("fine")) {
				this.fine(); 
				return true;
			} else if (comandoDaEseguire.getNome().equals("vai"))
				this.vai(comandoDaEseguire.getParametro());
			else if (comandoDaEseguire.getNome().equals("aiuto"))
				this.aiuto();
			else if (comandoDaEseguire.getNome().equals("prendi"))
				this.prendi(comandoDaEseguire.getParametro());
			else if	(comandoDaEseguire.getNome().equals("posa"))
				this.posa(comandoDaEseguire.getParametro());
			else
				System.out.println("Comando sconosciuto");
		}
		if(this.partita.isFinita()) {
			if (this.partita.vinta()) {
				System.out.println("Hai vinto!");
				return true;
			} else {
				System.out.println("Hai finito le vite... Hai perso!");
				this.fine();
				return false;
			}
		}
		return false;
	}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			System.out.print(elencoComandi[i]+" ");
		System.out.println();
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null)
			System.out.println("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			System.out.println("Direzione inesistente");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCfu();
			this.partita.getGiocatore().setCfu(cfu-1);
		}
		//System.out.println(partita.getStanzaCorrente().getDescrizione());
		
		//stampa la stanza in cui ti trovi, le direzioni, gli attrezzi nella stanza e i cfu
		System.out.println(partita);
	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		System.out.println("Grazie di aver giocato!");  // si desidera smettere
	}

	/**
	 * comando prendi
	 * 
	 * serve per prendere un oggetto dalla stanza corrente e metterlo nella borsa
	 */
	private void prendi(String NomeAttrezzo) {
		if(NomeAttrezzo!=null) {
			//controlla se l'attrezzo nomeAttrezzo é presente nella stanza
			if(this.partita.getStanzaCorrente().getAttrezzo(NomeAttrezzo)!=null) {
				//mi salvo l'attrezzo nella variabile AttrezzoDaCancellare
				Attrezzo AttrezzoDaCancellare = this.partita.getStanzaCorrente().getAttrezzo(NomeAttrezzo);
				//se riesco ad aggiungere l'oggetto in borsa
				if(this.partita.getGiocatore().getBorsa().addAttrezzo(AttrezzoDaCancellare)) {
					//lo rimuovo dalla stanza
					this.partita.getStanzaCorrente().removeAttrezzo(AttrezzoDaCancellare);
					System.out.println("oggetto preso");
				}
				else
					System.out.println("borsa piena");
			}
			else
				System.out.println("oggetto non trovato nella stanza");
		}
		else
			System.out.println("comando inesistente");

	}
	
	
	private void posa(String NomeAttrezzo) {
		if(NomeAttrezzo!=null) {
//			//se è presente l'attrezzo NomeAttrezzo in borsa
			if(this.partita.getGiocatore().getBorsa().getAttrezzo(NomeAttrezzo)!=null) {
				//mi salvo l'attrezzo nella variabile attrezzoDaPosare
				Attrezzo attrezzoDaPosare = this.partita.getGiocatore().getBorsa().getAttrezzo(NomeAttrezzo);
				//se riesco a posare l'attrezzo nella stanza perchè non piena
				if(this.partita.getStanzaCorrente().addAttrezzo(attrezzoDaPosare)) {
					//rimuovo allora l'oggetto dalla borsa
					this.partita.getGiocatore().getBorsa().removeAttrezzo(NomeAttrezzo);
					System.out.println("oggetto posato");
				}
				else
					System.out.println("la stanza è piena di oggetti");
			}
			else
				System.out.println("oggetto non presente in borsa");
		}
	}


	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}
}