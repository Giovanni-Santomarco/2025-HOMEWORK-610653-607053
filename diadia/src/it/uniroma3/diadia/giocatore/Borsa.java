package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;

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
	
	public int getPesoMax() {
		return pesoMax;
	}
	
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		for(int i=0; i<this.numeroAttrezzi; i++) {
			if(this.attrezzi[i].getNome().equals(nomeAttrezzo)) {
				a=attrezzi[i];
			}
		}
		return a;
	}
	
	public int getPeso() {
		int peso=0;
		for(int i=0; i<this.numeroAttrezzi; i++) {
			peso = peso + this.attrezzi[i].getPeso();
		}
		return peso;
	}
	
	public boolean isEmpty() {
		return this.numeroAttrezzi==0;
	}
	
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}
	
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		if(this.numeroAttrezzi==0) {
			System.out.println("non ci sono attrezzi nella borsa");
		}
		else {
			boolean trovato=false;
			for(int i=0; i<this.numeroAttrezzi; i++) {
				if(this.attrezzi[i].getNome().equals(nomeAttrezzo)) {
					trovato=true;
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
			if(trovato==false) {
				System.out.println("non c'è questo oggetto nella borsa del giocatore");
			}
		}
		
		return a;
	}
	
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
