/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karty;

import prostredieHerne.Mapa;

/**
 * Trieda Healer predstavuje kartu doplnenie zivota,
 * ktora moze byt pouzivana na hracej ploche.
 * 
 * @author Samuel Vasecka
 * @version 2019.05.14
 */
public class Healer extends Card {

    public Healer() {
    }

    /**
     * Metoda akcia doplni zivot vsetkym tvojim jednotkam podla zadaneho pravidla.
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
                            if (mapa.getMapa(j, i).getPocet() < 150) {
                                mapa.getMapa(j, i).setPocet(-50);
                            }
                        }
                    }
                } else {
                    if (mapa.getMapa(j, i) != null) {
                        if (mapa.getMapa(j, i).getCode() < 0) {
                            if (mapa.getMapa(j, i).getPocet() < 150) {
                                mapa.getMapa(j, i).setPocet(-50);
                            }
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
        return super.dajPopis() + "DOPLNENIE ZIVOTA \nTvoje jednotky, ktore mali menej ako 150 vojakov dostali 50 vojakov naviac";
    }
}
