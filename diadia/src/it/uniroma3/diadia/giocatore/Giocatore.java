package it.uniroma3.diadia.giocatore;


/**
 * classe che si occupa dei cfu (delle vite che il giocatore ha)
 * 
 * ogni giocatore ha 20 cfu_iniziali
 * e una borsa che contiene i suoi oggetti
 */

public class Giocatore {
    static final private int CFU_INIZIALI = 7;
    private int cfu;
    private Borsa borsa;
    
    public Giocatore() {
        this.cfu = CFU_INIZIALI;
        this.borsa = new Borsa();
    }
    
    public int getCfu() {
        return this.cfu;
    }

    public void setCfu(int cfu) {
        this.cfu = cfu;     
    }
    
    public Borsa getBorsa() {
    	return this.borsa;
    }
    
    public boolean giocatoreIsVivo() {
    	return this.cfu>0;
    }
    
    public String toString() {
    	return this.cfu +"\n"+ this.borsa.toString();
    }
}