package it.uniroma3.diadia;


import java.io.FileNotFoundException;

import java.io.FileReader;
import java.util.Properties;

import it.uniroma3.diadia.ambienti.Labirinto;


import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandi;
import it.uniroma3.diadia.comandi.FabbricaDiComandiRiflessiva;

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


	private Partita partita;
	private IO io;


	public DiaDia(IO io, Labirinto labirinto) {
		this.partita = new Partita(labirinto);
		this.io = io; 
	}

	public void gioca() {
		String istruzione; 


		io.mostraMessaggio(MESSAGGIO_BENVENUTO);      
		do {     
			istruzione = io.leggiRiga();
		}
		while (!processaIstruzione(istruzione));

		//chiude lo scanner
		if(io.getClass()==IOConsole.class) { //(io instanceof IOConsole) potevo anche scrivere
			IOConsole console = (IOConsole)io;
			console.close();
		}

		//		if(io instanceof IOConsole) {
		//			((IOConsole) io).close();
		//		}
	}   

	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */

	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire;
		FabbricaDiComandi factory = new FabbricaDiComandiRiflessiva();
		comandoDaEseguire = factory.costruisciComando(istruzione);
		comandoDaEseguire.esegui(this.partita, this.io);
		if (this.partita.vinta())

			io.mostraMessaggio("Hai vinto!");
		if (!this.partita.getGiocatore().giocatoreIsVivo() && !this.partita.vinta())

			io.mostraMessaggio("Hai esaurito i CFU...\nGrazie di aver giocato!");

		return this.partita.isFinita();
	}



	public static void main(String[] argc) {
		IO io = new IOConsole();
		Labirinto labirinto = null;
		DiaDia gioco = null;
		
		Properties props = new Properties();
		//con le properties
		try {
			props.load(new FileReader("config/configuration.properties"));
			gioco = new DiaDia(io, loadProps(props));
			gioco.gioca();
		} catch (Exception e) {
			try {	//se non funziona carico direttamente dal file
				CaricatoreLabirinto car = new CaricatoreLabirinto("livelli/livello1.txt");
				car.carica();
				Labirinto.LabirintoBuilder builder = new Labirinto.LabirintoBuilder(car);
				labirinto = builder.getLabirinto();
				io.mostraMessaggio("caricato correttamente il livello dal file\n");
				gioco = new DiaDia(io, labirinto);
				gioco.gioca();
				
			} catch (Exception ee) {	//se non funziona creo il labirinto base
				io.mostraMessaggio("Non è stato costruito il labirinto usando il file\n");
				Labirinto.LabirintoBuilder builder = new Labirinto.LabirintoBuilder();
				labirinto = builder.buildBase().getLabirinto();
				gioco = new DiaDia(io, labirinto);
				gioco.gioca();
			}
		}
	}
	
	
	private static Labirinto loadProps(Properties props) {
		CFU_INIZIALI = parseInt(props.getProperty("starting-cfu"), 7);
		MAX_PESO_BORSA = parseInt(props.getProperty("max-bag-weight"), 10);
		MAX_ATTREZZI = parseInt(props.getProperty("max-tools-amount"), 10);
		SOGLIA_STANZA_MAGICA = parseInt(props.getProperty("default-magic-room-threshold"), 10);

		MESSAGGIO_DONO_MAGO = props.getProperty("wizard-gift-message", "Sei un vero simpaticone, con una mia magica azione, troverai un nuovo oggetto per il tuo borsone!");
		MESSAGGIO_SCUSE_MAGO = props.getProperty("wizard-apologize-message", "Mi spiace, ma non ho piu' nulla...");

		String mazePath = props.getProperty("maze-configuration-path", "livelli/livello1.txt");
		CaricatoreLabirinto loader = null;
		try {
			loader = new CaricatoreLabirinto(mazePath);
			loader.carica();
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
			
		} catch (FormatoFileNonValidoException e) {
			e.printStackTrace();
		}

		return Labirinto.fromLoader(loader);
	}



	private static int parseInt(String s, int def) {
		if (s == null) return def;

		try {
			return Integer.parseInt(s.trim());
		} catch (Exception e) {
			return def;
		}
	}

	private static int CFU_INIZIALI = 7;
	private static int MAX_PESO_BORSA = 10;
	private static int MAX_ATTREZZI = 10;
	private static int SOGLIA_STANZA_MAGICA = 3;
	private static String MESSAGGIO_DONO_MAGO;
	private static String MESSAGGIO_SCUSE_MAGO;
	

	public static int getCfuIniziali() {
		return CFU_INIZIALI;
	}

	public static int getMaxPesoBorsa() {
		return MAX_PESO_BORSA;
	}

	public static int getMaxAttrezzi() {
		return MAX_ATTREZZI;
	}

	public static int getSogliaStanzaMagica() {
		return SOGLIA_STANZA_MAGICA;
	}
	
	public static String getMESSAGGIO_DONO_MAGO() {
		return MESSAGGIO_DONO_MAGO;
	}
	
	public static String getMESSAGGIO_SCUSE_MAGO() {
		return MESSAGGIO_SCUSE_MAGO;
	}
}