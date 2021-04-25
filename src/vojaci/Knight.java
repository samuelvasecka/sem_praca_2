/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vojaci;

/**
 * Trieda Knight predstavuje vojensku jenotku Rytier,
 * ktora moze byt pouzivana na hracej ploche.
 * 
 * @author Samuel Vasecka
 * @version 2019.05.14
 */
public class Knight extends Soldier implements ISoldier {
    
    /**
     * Konstruktor vytvori vojensku jednotku Rytier s danymi atributami.
     * @param poziciaX predstavuje x-ovu poziciu jednotky na mape.
     * @param poziciaY predstavuje y-ovu poziciu jednotky na mape.
     * @param code predstavuje ktoremu hracov jednotka patri.
     */ 
    public Knight(int poziciaX, int poziciaY, int code) {
        super(150, 5, 0, 1, 500, 3, poziciaX, poziciaY, 3 * code, 1.1);
    }
    
    /**
     * Metoda toString vrati retazec so zakladnymi udajmi o jednotke.
     * @return retazec.
     */
    public String toString() {
        return "RYTIER \n" + super.toString();
    }
    
    /**
     * Metoda toString vrati retazec so zakladnymi udajmi o jednotke po boji.
     * @return retazec.
     */
    public String dajPois() {
        return "RYTIER \n" + super.dajPopis() + "\n";
    }
}
