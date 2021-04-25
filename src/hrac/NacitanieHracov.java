/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hrac;

import java.io.IOException;
import javax.swing.JOptionPane;

/**
 * Trieda vytvara input, pomocou ktoreho su hraci vytvoreny.
 *
 * @version 2019.05.14
 * @author T440p
 */
public class NacitanieHracov {

    private PosledneId posledneId;

    /**
     * Konstruktor priparavy prostriedky na zsikanie udajov hraca.
     */
    public NacitanieHracov() {
        this.posledneId = new PosledneId();
    }

    /**
     * Metoda nastavenie ziska z inputu meno hraca.
     *
     * @param i predstavuje ci ide o prveho alebo druheho hraca.
     */
    public Hrac nastavenie(int i) throws IOException {
        PosledneId posledneId1 = new PosledneId();
        String nick = "";
        boolean a = true;
        while (a) {
            try {
                if (i == 1) {
                    nick = JOptionPane.showInputDialog(null, "Zadaj svoje meno: (Hrac " + i + " nalavo) ");
                } else {
                    nick = JOptionPane.showInputDialog(null, "Zadaj svoje meno: (Hrac " + i + " napravo) ");
                }
                a = false;
            } catch (NullPointerException npex) {
                a = true;
            }
        }

        Hrac hrac = new Hrac(nick, posledneId1);
        return hrac;
    }

}
