/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hrac;

import javax.swing.JOptionPane;

/**
 *
 * @author T440p
 */

/**
 * Tato trieda vytvara tabulku v ktorej sa nachadzaju udaje
 * o troch najlepsich hracoch a udaje aktualneho hraca.
 * 
 * @author Samuel Vasecka 
 * @version 2019.05.14
 */
public class Tabulka {

    public Tabulka() {
    }
    
    /**
     * Metoda tabulka do terminalu vypise, tabulku, ktora
     * obsahuje identifikacne cislo a vysledok prvych troch hracov
     * a tiez meno, identifikacne cislo a vysledok aktualneho hraca.
     * @param topSkore predstavuje top skore prvych troch hracov.
     * @param hrac predstavuje vitazneho hraca.
     * @param cislo predstavuje hracovo hodnotenie.
     */
    public void tabulka(int[] topSkore, Hrac hrac, int cislo) {
        String string = "";
        string += String.format("%11s %11s %11s", "poradie", "cislo", "body" ) + "\n";
        for (int i = 0; i < 9; i++) {
            if ((i - 2) % 3 == 0) {
                string += String.format("%11s", topSkore[i]) + "\n";
            } else {
                string += String.format("%11s", topSkore[i]);
            }
        }
        
        string += String.format("%11s%11s%11s", hrac.getNickName(), hrac.getId(), cislo );
        JOptionPane.showMessageDialog(null, string);

    }
}

