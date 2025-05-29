package it.uniroma3.diadia.giocatore;

import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.attrezzi.Attrezzo;


/**
 * la classe borsa si occupa di raggruppare tutti gli oggetti del giocatore
 * 
 * una Borsa ha una capienza massima data dal peso max, è un array che contiene attrezzi
 */

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Map<String, Attrezzo> nome2attrezzo;
	private int pesoMax;
	private int pesoAttuale;

	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.nome2attrezzo = new HashMap<>();
		this.pesoAttuale = 0;
	}

	/**
	 * aggiunge l'attrezzo alla borsa
	 * @param attrezzo
	 * @return boolean
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(this.getPeso() + attrezzo.getPeso() > this.pesoMax) {
			return false;
		}
		nome2attrezzo.put(attrezzo.getNome(), attrezzo);
		this.pesoAttuale = this.pesoAttuale + attrezzo.getPeso();
		return true;
	}

	/**
	 * @return pesoMax
	 */
	public int getPesoMax() {
		return pesoMax;
	}

	/**
	 * cerca un attrezzo nella borsa con il nome che viene dato come parametro
	 * @param nomeAttrezzo
	 * @return un riferimento a quell' attrezzo, oppure null
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		return nome2attrezzo.get(nomeAttrezzo);
	}

	/**
	 * somma tutti i pesi di tutti gli attrezzi nella borsa
	 * @return la somma di tutti i pesi nella borsa
	 */
	public int getPeso() {
		return this.pesoAttuale;
	}

	/**
	 * @return true se il numero degli attrezzi in borsa è 0
	 */
	public boolean isEmpty() {
		return this.nome2attrezzo.isEmpty();
	}

	/**
	 * @param nomeAttrezzo
	 * @return true se nella borsa c'è l'attrezzo con la stringa data in parametro
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}

	/**
	 * rimuove l'attrezzo dalla borsa
	 * @param nomeAttrezzo
	 * @return l'attrezzo rimosso dalla borsa se trovato, altrimenti null
	 */
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		if(nome2attrezzo.containsKey(nomeAttrezzo)) {
			this.pesoAttuale = this.pesoAttuale - this.nome2attrezzo.get(nomeAttrezzo).getPeso();
		}
		return nome2attrezzo.remove(nomeAttrezzo);
	}

	/**
	 * aggiunge alla scritta contenuto borsa (se non vuota) tutti gli attrezzi e i loro
	 * rispettivi pesi, altrimenti se la borsa è vuota scrive "borsa vuota"
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		if(!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for (Attrezzo attrezzo : this.nome2attrezzo.values()) {
				s.append(attrezzo.toString()+" ");
			}
		}
		else
			s.append("Borsa vuota");
		return s.toString();

	}

}