/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karty;

import prostredieHerne.Mapa;

/**
 * Trieda Card predstavuje univerzalnu kartu, ktorej potomkami 
 * su ostatne karty.
 * 
 * @author Samuel Vasecka
 * @version 2019.05.14
 */
public abstract class Card implements ICards {

    public Card() {
    }
    
    /**
     * Metoda dajPopis vrati popis karty.
     * @return string.
     */
    public String dajPopis() {
        return "Pouzil si kartu: ";
    }

    /**
     * Metoda akcia je abstraktna.
     * 
     * @param pocetPolicokX
     * @param pocetPolicokY
     * @param mapa
     * @param code
     * @return pole.
     */
    public  abstract int[] akcia(int pocetPolicokX, int pocetPolicokY, Mapa mapa, int code);
}
