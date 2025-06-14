package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

    private Labirinto labirinto;
    private Stanza stanzaCorrente;
    private boolean finita;
    private Giocatore giocatore;
    
    public Partita(Labirinto labirinto){
        this.labirinto = labirinto;
        this.finita = false;
        stanzaCorrente = this.labirinto.getStanzaIniziale();
        this.giocatore = new Giocatore();
    }

    public void setStanzaCorrente(Stanza stanzaCorrente) {
        this.stanzaCorrente = stanzaCorrente;
    }

    public Stanza getStanzaCorrente() {
        return this.stanzaCorrente;
    }
    
    /**
     * Restituisce vero se e solo se la partita e' stata vinta
     * @return vero se partita vinta
     */
    public boolean vinta() {
        return this.getStanzaCorrente() == labirinto.getStanzaFinale();
    }

    /**
     * Restituisce vero se e solo se la partita e' finita
     * @return vero se partita finita
     */
    public boolean isFinita() {
        return finita || vinta() || (giocatore.getCfu() == 0);
    }

    /**
     * Imposta la partita come finita
     */
    public void setFinita() {
        this.finita = true;
    }
    
    public Giocatore getGiocatore() {
        return this.giocatore;
    }
    
    public String toString() {
    	return (this.stanzaCorrente.getDescrizione()+"\ncfu: "+this.giocatore.toString());
    }
    
    public Labirinto getLabirinto() {
    	return this.labirinto;
    }
    
}