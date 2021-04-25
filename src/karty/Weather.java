/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karty;

import prostredieHerne.Mapa;
import java.util.Random;

/**
 * Trieda Weather predstavuje kartu pad asteroidu,
 * ktora moze byt pouzivana na hracej ploche.
 * 
 * @author Samuel Vasecka
 * @version 2019.05.14
 */
public class Weather extends Card {
    private Random random;

    /**
     * Konstruktor vytvori podmienky na spustanie metod.
     */
    public Weather() {
        this.random = new Random();
    }
    
    /**
     * Metoda akcia vykona nahodne vybuch na hracej ploche  a vrati od kial po kial 
     * sa ma hracia plocha nasledne prekreslit.
     * @param pocetPolicokX predstavuje pocet x-ovych policok hracej plochy.
     * @param pocetpolicokY predstavuje pocet y-ovych policok hracej plochy.
     * @param mapa predstavuje kde sa metoda vykona.
     * @param code urcuje o ktoreho hraca ide.
     * @return pole (zaciatok a koniec prekreslenia).
     */
    public int[] akcia(int pocetPolicokX, int pocetPolicokY, Mapa mapa, int code) {
        int rand = this.random.nextInt(19) + 6;
        int[] pole = mapa.dosah(rand, 3, true);
        return pole;
    }
    
    /**
     * Metoda dajPopis vrati popis tejto karty.
     * @return string.
     */
    public String dajPopis() {
        return super.dajPopis() + "ASTEROID \nMapu na nahodnom mieste zasiahne asteroid";
    }
}
