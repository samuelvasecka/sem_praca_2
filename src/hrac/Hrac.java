/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hrac;

import java.io.IOException;

/**
 * Trieda modeluje osobu hrac, a ponuka metody
 * suvisiace s hracom.
 * 
 * @version 2019.05.14
 * @author T440p
 */
public class Hrac {
    private static int posledneId = 100;
    private int id;
    private String nickName;
    private int cislo; 
    
    /**
     * Konstruktor vytvori hraca.
     * @param nickName predstavuje meno hraca.
     * @param cisloId vyuzije svoju metodu na ziskanie identifikacneho cisla posledneho hraca.
     */
    public Hrac(String nickName, PosledneId cisloId) throws IOException {
        this.cislo = cisloId.vyberZoSuboru();

        this.posledneId = this.cislo; 
        this.id = this.posledneId;

        this.nickName = nickName; 
    }
    
    /**
     * Metoda getNickName vrati meno hraca.
     * @return nickName (meno hraca).
     */
    public String getNickName() {
        return this.nickName;
    }
    
    /**
     * Metoda getId vrati identifikacne cislo hraca.
     * @return id (identifikacne cislo hraca).
     */
    public int getId() {
        return this.id;
    }
    
    /**
     * Metoda toString vrati zakladne udaje o hracovi.
     * @return string.
     */
    public String toString() {
        return "    Hrac: " + this.getNickName() + " " + this.getId();
    }
    
    /**
     * Metoda vysledok vrati pole stringov, ktore predstavuju jeho zakladne 
     * udaje a dosiahnuty vysledok.
     * @return vysledok (pole stringov).
     */
    public String[] vysledok(int cislo) {
        String[] vysledok = {this.getNickName(), "" + this.getId(), "" + cislo};
        return vysledok;
    }
}
