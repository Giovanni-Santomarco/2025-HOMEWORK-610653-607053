package it.uniroma3.diadia.giocatore;


/**
 * classe che si occupa dei cfu (delle vite che il giocatore ha)
 * 
 * ogni giocatore ha 20 cfu_iniziali
 * e una borsa che contiene i suoi oggetti
 */

public class Giocatore {
    static final private int CFU_INIZIALI = 20;
    private int cfu;
    private Borsa borsa;
    
    public Giocatore() {
        this.cfu = CFU_INIZIALI;
    }
    
    public int getCfu() {
        return this.cfu;
    }

    public void setCfu(int cfu) {
        this.cfu = cfu;     
    }   
}
