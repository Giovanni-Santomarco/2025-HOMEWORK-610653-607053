package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;


/**
 * la classe borsa si occupa di raggruppare tutti gli oggetti del giocatore
 * 
 * una Borsa ha una capienza massima data dal peso max, è un array che contiene attrezzi
 */

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Attrezzo[] attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;

	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new Attrezzo[10];  //speriamo bastino
		this.numeroAttrezzi = 0;
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
		if(this.numeroAttrezzi == 10) {
			return false;
		}
		this.attrezzi[this.numeroAttrezzi] = attrezzo;
		this.numeroAttrezzi++;
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
		Attrezzo a = null;
		for(int i=0; i<this.numeroAttrezzi; i++) {
			if(this.attrezzi[i]!=null) {
				if(this.attrezzi[i].getNome().equals(nomeAttrezzo)) {
					a=attrezzi[i];
				}
			}
		}
		return a;
	}

	/**
	 * somma tutti i pesi di tutti gli attrezzi nella borsa
	 * @return la somma di tutti i pesi nella borsa
	 */
	public int getPeso() {
		int peso=0;
		for(int i=0; i<this.numeroAttrezzi; i++) {
			if(this.attrezzi[i]!=null) {
				peso = peso + this.attrezzi[i].getPeso();
			}
		}
		return peso;
	}

	/**
	 * @return true se il numero degli attrezzi in borsa è 0
	 */
	public boolean isEmpty() {
		return this.numeroAttrezzi==0;
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
		Attrezzo a = null;
		if(this.numeroAttrezzi==0) {
			System.out.println("non ci sono attrezzi nella borsa");
		}
		else {
			for(int i=0; i<this.numeroAttrezzi; i++) {
				if(this.attrezzi[i]!=null) {
					if(this.attrezzi[i].getNome().equals(nomeAttrezzo)) {
						a=attrezzi[i];
						//se tolgliessi il primo elemento o non l'ultimo
						if(i<numeroAttrezzi-1){
							for(int j=i; i<numeroAttrezzi; j++) {
								attrezzi[j]=attrezzi[j+1];
							}
						}
						//se è l'ultimo attrezzo ad essere rimosso
						if(i==numeroAttrezzi-1) {
							attrezzi[i]=null;
						}
					}
				}
			}
			this.numeroAttrezzi--;
		}
		
		return a;
	}

	/**
	 * aggiunge alla scritta contenuto borsa (se non vuota) tutti gli attrezzi e i loro
	 * rispettivi pesi, altrimenti se la borsa è vuota scrive "borsa vuota"
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		if(!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for (int i= 0; i<this.numeroAttrezzi; i++)
				s.append(attrezzi[i].toString()+" ");
		}
		else
			s.append("Borsa vuota");
		return s.toString();

	}

}
