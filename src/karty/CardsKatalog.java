/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karty;

import java.util.ArrayList;
import java.util.Random;

/**
 * Trieda CardsKatalog je genericka trieda, vyuzivana
 * ako katalog kariet.
 * 
 * @author Samuel Vasecka
 * @version 2019.05.14
 */
public class CardsKatalog<E extends ICards> {
    private ArrayList<E> zoznam;

    /**
     * Konstruktor vytvori ArrayList na vkladanie kariet.
     */
    public CardsKatalog() {
        this.zoznam = new ArrayList<>();
    }
    
    /**
     * Metoda vloz vklada objekt do katalogu.
     * @param objekt (vklada sa do zoznamu).
     */
    public void vloz(E objekt) {
        this.zoznam.add(objekt);
    }
    
    /**
     * Metoda vlozVsetky vlozi do katalogu vsetky karty.
     */
    public void vlozVsetky() {
        this.vloz((E)new Weather());
        this.vloz((E)new Spell());
        this.vloz((E)new Healer());
        this.vloz((E)new Disease());
    }
    
    /**
     * Metoda vrati nahodne vygenerovane cislo.
     * @return rand (vygenerovane cislo).
     */
    public int nahodneCislo() {
        Random random = new Random();
        int rand = random.nextInt(4);
        return rand;
    }
    
    /**
     * Metoda vyber vyberie z katalogu kartu na zadanom indexe.
     * @return ICards (vybrana karta).
     */
    public ICards vyber(int cislo) {
        return this.zoznam.get(cislo);
    }
    
}
