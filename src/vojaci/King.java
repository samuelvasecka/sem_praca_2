/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vojaci;

/**
 * Trieda King predstavuje vojensku jenotku Kral,
 * ktora moze byt pouzivana na hracej ploche.
 * 
 * @author Samuel Vasecka
 * @version 2019.05.14
 */
public class King extends Soldier implements ISoldier {
    
    /**
     * Konstruktor vytvori vojensku jednotku Kral s danymi atributami.
     * @param poziciaX predstavuje x-ovu poziciu jednotky na mape.
     * @param poziciaY predstavuje y-ovu poziciu jednotky na mape.
     * @param code predstavuje ktoremu hracov jednotka patri.
     */
    public King(int poziciaX, int poziciaY, int code) {
        super(130, 6, 0, 0.8, 500, 0, poziciaX, poziciaY, 4 * code, 1.2);
    }
    
    /**
     * Metoda toString vrati retazec so zakladnymi udajmi o jednotke.
     * @return retazec.
     */
    public String toString() {
        return "KRAL \n" + super.toString();
    }
    /**
     * Metoda toString vrati retazec so zakladnymi udajmi o jednotke po boji.
     * @return retazec.
     */
    public String dajPois() {
        return "KRAL \n" + super.dajPopis() + "\n";
    }
}
