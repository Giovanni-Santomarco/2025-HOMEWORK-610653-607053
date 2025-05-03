package it.uniroma3.diadia;

public class ComandoGuarda implements Comando {

	@Override
	public void esegui(Partita partita, IOConsole console) {
		console.mostraMessaggio(partita.toString());
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
