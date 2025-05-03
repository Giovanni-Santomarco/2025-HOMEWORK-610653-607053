package it.uniroma3.diadia;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando {

	private String NomeAttrezzo;
	
	@Override
	public void esegui(Partita partita, IOConsole console) {
		if(NomeAttrezzo!=null) {
			//se è presente l'attrezzo NomeAttrezzo in borsa
			if(partita.getGiocatore().getBorsa().getAttrezzo(NomeAttrezzo)!=null) {
				//mi salvo l'attrezzo nella variabile attrezzoDaPosare
				Attrezzo attrezzoDaPosare = partita.getGiocatore().getBorsa().getAttrezzo(NomeAttrezzo);
				//se riesco a posare l'attrezzo nella stanza perchè non piena
				if(partita.getStanzaCorrente().addAttrezzo(attrezzoDaPosare)) {
					//rimuovo allora l'oggetto dalla borsa
					partita.getGiocatore().getBorsa().removeAttrezzo(NomeAttrezzo);
					console.mostraMessaggio("oggetto posato");
				}
				else
					console.mostraMessaggio("la stanza è piena di oggetti");
			}
			else
				console.mostraMessaggio("oggetto non presente in borsa");
		}
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
		this.NomeAttrezzo=parametro;
	}

}
