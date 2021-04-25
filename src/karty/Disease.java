/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karty;

import prostredieHerne.Mapa;

/**
 * Trieda Disease predstavuje kartu choroba,
 * ktora moze byt pouzivana na hracej ploche.
 * 
 * @author Samuel Vasecka
 * @version 2019.05.14
 */
public class Disease extends Card {

    public Disease() {
    }

    /**
     * Metoda akcia vsetkym tvojim jednotkam skrati dosah o jeden.
     * @param pocetPolicokX predstavuje pocet x-ovych policok hracej plochy.
     * @param pocetpolicokY predstavuje pocet y-ovych policok hracej plochy.
     * @param mapa predstavuje kde sa metoda vykona.
     * @param code urcuje o ktoreho hraca ide.
     * @return pole (zaciatok a koniec prekreslenia).
     */
    public int[] akcia(int pocetPolicokX, int pocetPolicokY, Mapa mapa, int code) {
        for (int i = 0; i < pocetPolicokY; i++) {
            for (int j = 0; j < pocetPolicokX; j++) {
                if (code == 1) {
                    if (mapa.getMapa(j, i) != null) {
                        if (mapa.getMapa(j, i).getCode() > 0) {
                            mapa.getMapa(j, i).setDosah();
                        }
                    }
                } else {
                    if (mapa.getMapa(j, i) != null) {
                        if (mapa.getMapa(j, i).getCode() < 0) {
                            mapa.getMapa(j, i).setDosah();
                        }
                    }
                }
            }
        }
        int[] pole = new int[]{0, 1};
        return pole;

    }

    /**
     * Metoda dajPopis vrati popis tejto karty.
     * @return string.
     */
    public String dajPopis() {
        return super.dajPopis() + "CHOROBA \nTvoje jednotky su oslabene a maju o jeden mensi pohyb";
    }
}
