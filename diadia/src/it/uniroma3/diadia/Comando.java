package it.uniroma3.diadia;

public interface Comando {
	public void esegui(Partita partita, IOConsole console);
	public String getParametro();
	public String getNome();
	public void setParametro(String parametro);
}

