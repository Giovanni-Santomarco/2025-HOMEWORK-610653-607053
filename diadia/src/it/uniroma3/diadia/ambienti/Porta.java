package it.uniroma3.diadia.ambienti;


public class Porta {
	
	private String nome;
	private boolean statoPorta;
	private String chiaveAssociata;
	
	public Porta() {
		this.nome = "nessuna porta";
		this.statoPorta = true;		//true sta per aperto
	}
	
	public String getNomePorta() {
		return this.nome;
	}
	
	public void setNomePorta(String nomePorta) {
		this.nome = nomePorta;
	}
	
	public boolean getStatoPorta() {
		return this.statoPorta;
	}
	
	public boolean setStatoPorta(boolean statoPorta) {
		return this.statoPorta=statoPorta;
	}
	
	public void setChiaveAssociata(String chiaveAssociata) {
		this.chiaveAssociata = chiaveAssociata;
	}
	
	public String getChiaveAssociata() {
		return this.chiaveAssociata;
	}
}

