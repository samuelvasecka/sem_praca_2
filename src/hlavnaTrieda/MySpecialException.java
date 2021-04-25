/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hlavnaTrieda;

/**
 * Trieda predstavuje vlastnu vynimku.
 * 
 * 
 * @author Samuel Vasecka
 * @version 2019.05.14
 */
public class MySpecialException extends Exception {

    public MySpecialException() {
        super("TVOJE MENO SA NEMOZE ZHODOVAT S MENOM HRACA1!");
    }
    
}
