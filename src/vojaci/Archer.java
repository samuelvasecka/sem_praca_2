/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vojaci;

/**
 * Trieda Archer predstavuje vojensku jenotku Lukostrelec,
 * ktora moze byt pouzivana na hracej ploche.
 * 
 * @author Samuel Vasecka
 * @version 2019.05.14
 */
public class Archer extends Soldier implements ISoldier {

    /**
     * Konstruktor vytvori vojensku jednotku Lukostrelec s danymi atributami.
     * @param poziciaX predstavuje x-ovu poziciu jednotky na mape.
     * @param poziciaY predstavuje y-ovu poziciu jednotky na mape.
     * @param code predstavuje ktoremu hracov jednotka patri.
     */
    public Archer(int poziciaX, int poziciaY, int code) {
        super(30, 3, 20, 2, 500, 2, poziciaX, poziciaY, 2 * code, 0.9);
    }
    
    /**
     * Metoda toString vrati retazec so zakladnymi udajmi o jednotke.
     * @return retazec.
     */
    public String toString() {
        return "LUKOSTRELEC \n" + super.toString() + "Dostrel: " + super.getDostrel();
    }
    
    /**
     * Metoda toString vrati retazec so zakladnymi udajmi o jednotke po boji.
     * @return retazec.
     */
    public String dajPois() {
        return "LUKOSTRELEC \n" + super.dajPopis() + "\n";
    }
}
