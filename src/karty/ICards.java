/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karty;

import prostredieHerne.Mapa;

/**
 * Trieda ICard je interface ostatnych kariet.
 * 
 * @author Samuel Vasecka
 * @version 2019.05.14
 */
public interface ICards {
    String dajPopis();
    int[] akcia (int pocetPolicokX, int pocetPolicokY, Mapa mapa, int code);
}
