package it.uniroma3.diadia;

public class ComandoAiuto implements Comando {
	static final private String[] elencoComandi = {"vai", "aiuto" , "fine" , "prendi", "posa"};
	
	@Override
	public void esegui(Partita partita, IOConsole console) {
		for(int i=0; i< elencoComandi.length; i++) 
			console.mostraMessaggio(elencoComandi[i]+" ");
		console.mostraMessaggio("");
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
