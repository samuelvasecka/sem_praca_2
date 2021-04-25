/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hrac;

/**
 * Tato trieda umoznuje pracovat s textovym suborom, v ktorom
 * su zaznamenane vysledky hracov, ktory vyhrali hru a pocet hracov,
 * ktorych vysledky su zapisane.
 * 
 * @author Samuel Vasecka 
 * @version 2019.05.14
 */
import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class TopSkore {
    
    public TopSkore() {
    }
    
    /**
     * Metoda vlozDoSuboru zapise do suboru cislo 0, v pripade,
     * ze je subor prazdny.
     */
    public static void vlozDoSuboru() throws IOException {
        File subor = new File("TopSkore");
        PrintWriter writer = new PrintWriter(subor);

        writer.print(0);

        writer.close();
    }
    
    /**
     * Metoda vlozDoSuboru1 zapise do suboru cisla, ktore obsahuje
     * pole typu int, ktore predstavuje parameter. Tieto cisla
     * predstavuju vysledky hracov.
     * @param zoznam predstavuje zoznam cisel, ktore sa do suboru zapisu.
     */
    public static void vlozDoSuboru1(int[] zoznam) throws IOException {
        File subor = new File("TopSkore");        
        PrintWriter writer = new PrintWriter(subor);
        int[] pole = zoznam;

        writer.println(pole[0] + "\n");

        for (int i = 1; i < pole[0] + 1; i++) {
            writer.print(pole[i] + " ");
        }

        writer.close();
    }

    /**
     * Metoda vyberZoSuboru precita cisla v subore, vyhodnoti ich
     * a vrati retazec, ktory hovori o tom, na akej celkovej priecke
     * sa hrac umiestnil a od kolko percent hracov je lepsi.
     * @param cislo predstavuje hodnotenie hraca.
     * @param hrac predstavuje hraca, ktory vyhral
     */
    public static String vyberZoSuboru1(int cislo, Hrac hrac) throws IOException {
        File subor = new File("TopSkore");

        if (subor.length() == 0) {
            TopSkore.vlozDoSuboru();   
        }       

        Scanner reader = new Scanner(subor);        

        int pocet = reader.nextInt();
        int[] zoznam = new int[pocet + 2]; 

        for (int i = 1; i < pocet + 1; i++) {
            int skore = reader.nextInt();
            zoznam[i] = skore;
        }

        zoznam[0] = pocet + 1;
        zoznam[pocet + 1] = cislo;

        Double sucet = 0.0;
        int sucet1 = 0;
        for (int i = 1; i < pocet + 1; i++) {
            if (zoznam[i] <= cislo) {
                sucet += 1;
                sucet1 += 1;
            }
        }

        double hodnotenie = (sucet / pocet * 100);     

        String string = "";

        if (pocet == 0) {
            string = hrac.toString() + " je lepsi ako 100% hracov" + "\n";
        } else {
            string = hrac.toString() + " je lepsi ako " + hodnotenie + "% hracov" + "\n";
        }

        string += "    Umiestnenie " + (pocet - sucet1 + 1) + " zo " + (pocet + 1);
        JOptionPane.showMessageDialog(null, string);
       
        TopSkore.vlozDoSuboru1(zoznam);
        reader.close();
        return string;
    }
}
 
