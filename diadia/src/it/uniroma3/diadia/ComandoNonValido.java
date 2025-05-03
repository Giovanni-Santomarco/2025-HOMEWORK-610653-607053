package it.uniroma3.diadia;

public class ComandoNonValido implements Comando {

	@Override
	public void esegui(Partita partita, IOConsole console) {
		console.mostraMessaggio("comando non valido");
	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}

}
