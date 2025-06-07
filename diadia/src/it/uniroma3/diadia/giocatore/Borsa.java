package it.uniroma3.diadia.giocatore;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.attrezzi.Attrezzo;


/**
 * la classe borsa si occupa di raggruppare tutti gli oggetti del giocatore
 * 
 * una Borsa ha una capienza massima data dal peso max, è un array che contiene attrezzi
 */

public class Borsa {
//	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Map<String, Attrezzo> nome2attrezzo;
	private int pesoMax;
	private int pesoAttuale;

	public Borsa() {
		this(DiaDia.getMaxPesoBorsa());
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
//			for (Attrezzo attrezzo : this.nome2attrezzo.values()) {
//				s.append(attrezzo.toString()+" ");
//			}
			s.append(this.nome2attrezzo.values().toString());
		}
		else
			s.append("Borsa vuota");
		return s.toString();

	}
	
	/**
	 * restituisce la lista degli attrezzi nella borsa ordinati per peso e quindi, a parità di peso, per nome
	 */
	public List<Attrezzo> getContenutoOrdinatoPerPeso(){
		
		List<Attrezzo> listaAttrezzi = new LinkedList<Attrezzo>(this.nome2attrezzo.values());
		Collections.sort(listaAttrezzi, new ComparatorePerPeso());
		return listaAttrezzi;
	}
	
	/*
	 * restituisce l'insieme degli attrezzi nella borsa ordinati per nome
	 */
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
		
		SortedSet<Attrezzo> SortedAttrezzi = new TreeSet<>(new ComparatorePerNome());
		SortedAttrezzi.addAll(this.nome2attrezzo.values());
		
		return SortedAttrezzi;
	}
	
	/*
	 *restituisce una mappa che associa un intero (rappresentante un
	 *peso) con l’insieme (comunque non vuoto) degli attrezzi di tale peso:
	 *tutti gli attrezzi dell'insieme che figura come valore hanno lo stesso
	 *peso pari all'intero che figura come chiave
	 */
	public Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		
		Map<Integer,Set<Attrezzo>> mappa = new HashMap<>();
		Set<Attrezzo> tmp;
		
		for(Attrezzo attrezzo : this.nome2attrezzo.values()) {
			if(mappa.containsKey(attrezzo.getPeso())) {
				tmp = mappa.get(attrezzo.getPeso());
				tmp.add(attrezzo);
			}
			else {
				tmp = new HashSet<Attrezzo>();
				tmp.add(attrezzo);
				mappa.put(attrezzo.getPeso(), tmp);
			}
		}
		return mappa;
	}
	
	/*
	 * restituisce l'insieme gli attrezzi nella borsa ordinati
	 * per peso e quindi, a parità di peso, per nome
	 */
	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
		
		SortedSet<Attrezzo> sortedSet = new TreeSet<>(new ComparatorePerPeso());
		sortedSet.addAll(this.nome2attrezzo.values());
		
		return sortedSet;
	}
	
	
	
	
	
	
}