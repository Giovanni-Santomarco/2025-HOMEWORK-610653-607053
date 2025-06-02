package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Direzione;

class DirezioniTest {

	@Test
    void testGradi() {
        assertEquals(0, Direzione.NORD.getGradi());
        assertEquals(180, Direzione.SUD.getGradi());
        assertEquals(90, Direzione.EST.getGradi());
        assertEquals(270, Direzione.OVEST.getGradi());
    }

    @Test
    void testOposta() {
        assertEquals(Direzione.SUD, Direzione.NORD.opposta());
        assertEquals(Direzione.NORD, Direzione.SUD.opposta());
        assertEquals(Direzione.OVEST, Direzione.EST.opposta());
        assertEquals(Direzione.EST, Direzione.OVEST.opposta());
    }
    
    
    //nota bene che il test fallisce se cambio l'ordine di dichiarazione nell'enum
    @Test
    void testOrdinal() {
        assertEquals(0, Direzione.NORD.ordinal());
        assertEquals(1, Direzione.SUD.ordinal());
        assertEquals(2, Direzione.EST.ordinal());
        assertEquals(3, Direzione.OVEST.ordinal());
    }
    
    @Test
    void testToString() {
    	assertEquals(Direzione.NORD.toString(), "NORD");
    }

}
