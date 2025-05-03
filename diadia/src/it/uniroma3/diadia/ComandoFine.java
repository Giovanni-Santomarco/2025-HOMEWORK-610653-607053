package it.uniroma3.diadia;

public class ComandoFine implements Comando {

	@Override
	public void esegui(Partita partita, IOConsole console) {
		console.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

	@Override
	public String getParametro() {
		return null;
	}

	@Override
	public String getNome() {
		return null;
	}

	@Override
	public void setParametro(String parametro) {

	}

}
