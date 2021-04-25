/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vojaci;

/**
 * Trieda FootSoldier predstavuje vojensku jenotku Pesiak,
 * ktora moze byt pouzivana na hracej ploche.
 * 
 * @author Samuel Vasecka
 * @version 2019.05.14
 */
public class FootSoldier extends Soldier implements ISoldier {
    
    /**
     * Konstruktor vytvori vojensku jednotku Pesiak s danymi atributami.
     * @param poziciaX predstavuje x-ovu poziciu jednotky na mape.
     * @param poziciaY predstavuje y-ovu poziciu jednotky na mape.
     * @param code predstavuje ktoremu hracov jednotka patri.
     */
    public FootSoldier(int poziciaX, int poziciaY, int code) {
        super(100, 6, 0, 1, 500, 2, poziciaX, poziciaY, 1 * code, 1);
    }
    
    /**
     * Metoda toString vrati retazec so zakladnymi udajmi o jednotke.
     * @return retazec.
     */
    public String toString() {
        return "PESIAK \n" + super.toString();
    }
    
    /**
     * Metoda toString vrati retazec so zakladnymi udajmi o jednotke po boji.
     * @return retazec.
     */
    public String dajPois() {
        return "PESIAK \n" + super.dajPopis() + "\n";
    }
}
