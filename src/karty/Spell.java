/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karty;

import prostredieHerne.Mapa;
import javax.swing.JOptionPane;

/**
 * Trieda Spell predstavuje kartu kuzlo,
 * ktora moze byt pouzivana na hracej ploche.
 * 
 * @author Samuel Vasecka
 * @version 2019.05.14
 */
public class Spell extends Card {

    public Spell() {
    }

    /**
     * Metoda akcia jednej vybratej jednotke 3-nasobne zvysi silu.
     * @param pocetPolicokX predstavuje pocet x-ovych policok na hracej ploche.
     * @param pocetPolicokX predstavuje pocet x-ovych policok hracej plochy.
     * @param pocetpolicokY predstavuje pocet y-ovych policok hracej plochy.
     * @param mapa predstavuje kde sa metoda vykona.
     * @param code urcuje o ktoreho hraca ide.
     * @return pole (zaciatok a koniec prekreslenia).
     */
    public int[] akcia(int pocetPolicokX, int pocetPolicokY, Mapa mapa, int code) {
        boolean a = true;
        while (a) {
            int x = Integer.parseInt(JOptionPane.showInputDialog(null, "Zadaj suradnicu X jednotky ktoru chces posilnit kuzlom: "));
            int y = Integer.parseInt(JOptionPane.showInputDialog(null, "Zadaj suradnicu Y jednotky ktoru chces posilnit kuzlom: "));

            if (mapa.getMapa(x - 1, y - 1) != null) {

                mapa.getMapa(x - 1, y - 1).setSila();
                a = false;

            } else {
                JOptionPane.showMessageDialog(null, "NA TOMTO MIESTE SA NENACHAZDA ZIADNA JEDNOTKA!", "CHYBA", JOptionPane.WARNING_MESSAGE);
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
        return super.dajPopis() + "KUZLO \nJedna tebou vybrata jednotka ziska 3-nasobnu silu";
    }
}
