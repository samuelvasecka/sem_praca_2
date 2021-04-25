/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prostredieHerne;

import nastavenia.Nastavovanie;
import vojaci.Archer;
import vojaci.FootSoldier;
import vojaci.ISoldier;
import vojaci.King;
import vojaci.Knight;
import vojaci.Soldier;
import java.awt.Dimension;
import java.awt.Toolkit;
import static java.lang.Math.abs;
import javax.swing.JOptionPane;

/**
 * Trieda mapa modeluje hraciu plochu, ktoru predstavuje dvojrozmerne pole, a
 * zaroven vytvara platno, ktore toto pole graficky predstavuje.
 *
 * @version 2019.05.14
 * @author Samuel Vasecka
 */
public class Mapa {

    private final int pocetPolicokX;
    private final int pocetPolicokY;
    private final ISoldier[][] mapa;
    private final int strana;
    private Soldier pomoc;

    /**
     * Konstrukto vytvori dvojrozmerne pole predstavujuce mapu, a vykreli ho na
     * platno v podobe farebnych stvorcekov.
     *
     * @param pocetPolicokX predstavuje pocet x-ovych policok na mape.
     * @param pocetPolicokY predstavuje pocet y-ovych policok na mape.
     */
    public Mapa(int pocetPolicokX, int pocetPolicokY) {
        this.pocetPolicokX = pocetPolicokX;
        this.pocetPolicokY = pocetPolicokY;
        this.mapa = new ISoldier[pocetPolicokY][pocetPolicokX];
        this.pomoc = null;
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension d = t.getScreenSize();

        this.strana = d.width / 33 - 1;
    }

    /**
     * Metoda suradnice vykresli nad grafiskym znazornenim mapy x-ove a y-ove
     * suradnice.
     */
    public void suradnice() {
        Obdlznik ob = new Obdlznik();
        ob.zmenStrany(this.strana + 1, this.strana + 1);
        ob.zmenPolohu((1) * (this.strana - 2), (1) * (this.strana - 2));
        ob.zmenFarbu("white");
        ob.zobraz();

        for (int i = 0; i < this.pocetPolicokY; i++) {
            Obdlznik obdlznik = new Obdlznik();
            obdlznik.zmenStrany(this.strana, this.strana);
            obdlznik.zmenPolohu((1) * (this.strana + 1), (i + 2) * (this.strana + 1));
            obdlznik.zmenFarbu("white");
            obdlznik.zobraz();
            switch (i) {
                case 0:
                    Obdlznik obdlznik0 = new Obdlznik();
                    obdlznik0.zmenStrany(this.strana / 6, this.strana - (this.strana / 6));
                    obdlznik0.zmenPolohu((1) * (this.strana + 1) + ((this.strana - this.strana / 6) / 2), (i + 2) * (this.strana + 1) + (this.strana / 12));
                    obdlznik0.zmenFarbu("black");
                    obdlznik0.zobraz();

                    break;
                case 1:
                    Obdlznik obdlznik1 = new Obdlznik();
                    obdlznik1.zmenStrany((this.strana / 6) * 3, this.strana - (this.strana / 6));
                    obdlznik1.zmenPolohu((1) * (this.strana + 1) + ((this.strana - this.strana / 6 * 3) / 2), (i + 2) * (this.strana + 1) + (this.strana / 12));
                    obdlznik1.zmenFarbu("black");
                    obdlznik1.zobraz();

                    Obdlznik obdlznik12 = new Obdlznik();
                    obdlznik12.zmenStrany((this.strana / 6) * 2, this.strana / 6);
                    obdlznik12.zmenPolohu((1) * (this.strana + 1) + ((this.strana - this.strana / 6 * 3) / 2), (i + 2) * (this.strana + 1) + (this.strana / 4));
                    obdlznik12.zmenFarbu("white");
                    obdlznik12.zobraz();

                    Obdlznik obdlznik13 = new Obdlznik();
                    obdlznik13.zmenStrany((this.strana / 6) * 2, this.strana / 6);
                    obdlznik13.zmenPolohu((1) * (this.strana + 1) + ((this.strana - this.strana / 6) / 2), (i + 2) * (this.strana + 1) + (this.strana / 12 * 9));
                    obdlznik13.zmenFarbu("white");
                    obdlznik13.zobraz();
                    break;
                case 2:
                    Obdlznik obdlznik2 = new Obdlznik();
                    obdlznik2.zmenStrany((this.strana / 6) * 3, this.strana - (this.strana / 6));
                    obdlznik2.zmenPolohu((1) * (this.strana + 1) + ((this.strana - this.strana / 6 * 3) / 2), (i + 2) * (this.strana + 1) + (this.strana / 12));
                    obdlznik2.zmenFarbu("black");
                    obdlznik2.zobraz();

                    Obdlznik obdlznik22 = new Obdlznik();
                    obdlznik22.zmenStrany((this.strana / 6) * 2, this.strana / 6);
                    obdlznik22.zmenPolohu((1) * (this.strana + 1) + ((this.strana - this.strana / 6 * 3) / 2), (i + 2) * (this.strana + 1) + (this.strana / 4));
                    obdlznik22.zmenFarbu("white");
                    obdlznik22.zobraz();

                    Obdlznik obdlznik23 = new Obdlznik();
                    obdlznik23.zmenStrany((this.strana / 6) * 2, this.strana / 6);
                    obdlznik23.zmenPolohu((1) * (this.strana + 1) + ((this.strana - this.strana / 6 * 3) / 2), (i + 2) * (this.strana + 1) + (this.strana / 12 * 9));
                    obdlznik23.zmenFarbu("white");
                    obdlznik23.zobraz();
                    break;
                case 3:
                    Obdlznik obdlznik3 = new Obdlznik();
                    obdlznik3.zmenStrany(this.strana / 6, this.strana - (this.strana / 2));
                    obdlznik3.zmenPolohu((1) * (this.strana + 1) + ((this.strana - this.strana / 6 * 3) / 2), (i + 2) * (this.strana + 1) + (this.strana / 12));
                    obdlznik3.zmenFarbu("black");
                    obdlznik3.zobraz();

                    Obdlznik obdlznik32 = new Obdlznik();
                    obdlznik32.zmenStrany((this.strana / 6) * 3, this.strana / 6);
                    obdlznik32.zmenPolohu((1) * (this.strana + 1) + ((this.strana - this.strana / 6 * 3) / 2), (i + 2) * (this.strana + 1) + (this.strana / 12 * 7));
                    obdlznik32.zmenFarbu("black");
                    obdlznik32.zobraz();

                    Obdlznik obdlznik33 = new Obdlznik();
                    obdlznik33.zmenStrany(this.strana / 6, this.strana - (this.strana / 6));
                    obdlznik33.zmenPolohu((1) * (this.strana + 1) + ((this.strana - this.strana / 2)), (i + 2) * (this.strana + 1) + (this.strana / 12));
                    obdlznik33.zmenFarbu("black");
                    obdlznik33.zobraz();

                    break;
                case 4:
                    Obdlznik obdlznik4 = new Obdlznik();
                    obdlznik4.zmenStrany((this.strana / 6) * 3, this.strana - (this.strana / 6));
                    obdlznik4.zmenPolohu((1) * (this.strana + 1) + ((this.strana - this.strana / 6 * 3) / 2), (i + 2) * (this.strana + 1) + (this.strana / 12));
                    obdlznik4.zmenFarbu("black");
                    obdlznik4.zobraz();

                    Obdlznik obdlznik42 = new Obdlznik();
                    obdlznik42.zmenStrany((this.strana / 6) * 2, this.strana / 6);
                    obdlznik42.zmenPolohu((1) * (this.strana + 1) + ((this.strana - this.strana / 6) / 2), (i + 2) * (this.strana + 1) + (this.strana / 4));
                    obdlznik42.zmenFarbu("white");
                    obdlznik42.zobraz();

                    Obdlznik obdlznik43 = new Obdlznik();
                    obdlznik43.zmenStrany((this.strana / 6) * 2, this.strana / 6);
                    obdlznik43.zmenPolohu((1) * (this.strana + 1) + ((this.strana - this.strana / 6 * 3) / 2), (i + 2) * (this.strana + 1) + (this.strana / 12 * 9));
                    obdlznik43.zmenFarbu("white");
                    obdlznik43.zobraz();
                    break;
                case 5:
                    Obdlznik obdlznik5 = new Obdlznik();
                    obdlznik5.zmenStrany((this.strana / 6) * 3, this.strana - (this.strana / 6));
                    obdlznik5.zmenPolohu((1) * (this.strana + 1) + ((this.strana - this.strana / 6 * 3) / 2), (i + 2) * (this.strana + 1) + (this.strana / 12));
                    obdlznik5.zmenFarbu("black");
                    obdlznik5.zobraz();

                    Obdlznik obdlznik52 = new Obdlznik();
                    obdlznik52.zmenStrany((this.strana / 6) * 2, this.strana / 6);
                    obdlznik52.zmenPolohu((1) * (this.strana + 1) + ((this.strana - this.strana / 6) / 2), (i + 2) * (this.strana + 1) + (this.strana / 4));
                    obdlznik52.zmenFarbu("white");
                    obdlznik52.zobraz();

                    Obdlznik obdlznik53 = new Obdlznik();
                    obdlznik53.zmenStrany((this.strana / 6), this.strana / 6);
                    obdlznik53.zmenPolohu((1) * (this.strana + 1) + ((this.strana - this.strana / 6) / 2), (i + 2) * (this.strana + 1) + (this.strana / 12 * 9));
                    obdlznik53.zmenFarbu("white");
                    obdlznik53.zobraz();
                    break;
            }
        }
        for (int j = 0; j < this.pocetPolicokX; j++) {

            Obdlznik obdlznik = new Obdlznik();
            obdlznik.zmenStrany(this.strana, this.strana);
            obdlznik.zmenPolohu((j + 2) * (this.strana + 1), (1) * (this.strana + 1));
            obdlznik.zmenFarbu("white");
            obdlznik.zobraz();

            switch (j % 10) {
                case 0:
                    Obdlznik obdlznik0 = new Obdlznik();
                    obdlznik0.zmenStrany(this.strana / 6, this.strana - (this.strana / 6));
                    obdlznik0.zmenPolohu((j + 2) * (this.strana + 1) + ((this.strana - this.strana / 6) / 2), (1) * (this.strana + 1) + (this.strana / 12));
                    obdlznik0.zmenFarbu("black");
                    obdlznik0.zobraz();

                    break;
                case 1:
                    Obdlznik obdlznik1 = new Obdlznik();
                    obdlznik1.zmenStrany((this.strana / 6) * 3, this.strana - (this.strana / 6));
                    obdlznik1.zmenPolohu((j + 2) * (this.strana + 1) + ((this.strana - this.strana / 6 * 3) / 2), (1) * (this.strana + 1) + (this.strana / 12));
                    obdlznik1.zmenFarbu("black");
                    obdlznik1.zobraz();

                    Obdlznik obdlznik12 = new Obdlznik();
                    obdlznik12.zmenStrany((this.strana / 6) * 2, this.strana / 6);
                    obdlznik12.zmenPolohu((j + 2) * (this.strana + 1) + ((this.strana - this.strana / 6 * 3) / 2), (1) * (this.strana + 1) + (this.strana / 4));
                    obdlznik12.zmenFarbu("white");
                    obdlznik12.zobraz();

                    Obdlznik obdlznik13 = new Obdlznik();
                    obdlznik13.zmenStrany((this.strana / 6) * 2, this.strana / 6);
                    obdlznik13.zmenPolohu((j + 2) * (this.strana + 1) + ((this.strana - this.strana / 6) / 2), (1) * (this.strana + 1) + (this.strana / 12 * 9));
                    obdlznik13.zmenFarbu("white");
                    obdlznik13.zobraz();
                    break;
                case 2:
                    Obdlznik obdlznik2 = new Obdlznik();
                    obdlznik2.zmenStrany((this.strana / 6) * 3, this.strana - (this.strana / 6));
                    obdlznik2.zmenPolohu((j + 2) * (this.strana + 1) + ((this.strana - this.strana / 6 * 3) / 2), (1) * (this.strana + 1) + (this.strana / 12));
                    obdlznik2.zmenFarbu("black");
                    obdlznik2.zobraz();

                    Obdlznik obdlznik22 = new Obdlznik();
                    obdlznik22.zmenStrany((this.strana / 6) * 2, this.strana / 6);
                    obdlznik22.zmenPolohu((j + 2) * (this.strana + 1) + ((this.strana - this.strana / 6 * 3) / 2), (1) * (this.strana + 1) + (this.strana / 4));
                    obdlznik22.zmenFarbu("white");
                    obdlznik22.zobraz();

                    Obdlznik obdlznik23 = new Obdlznik();
                    obdlznik23.zmenStrany((this.strana / 6) * 2, this.strana / 6);
                    obdlznik23.zmenPolohu((j + 2) * (this.strana + 1) + ((this.strana - this.strana / 6 * 3) / 2), (1) * (this.strana + 1) + (this.strana / 12 * 9));
                    obdlznik23.zmenFarbu("white");
                    obdlznik23.zobraz();
                    break;
                case 3:
                    Obdlznik obdlznik3 = new Obdlznik();
                    obdlznik3.zmenStrany(this.strana / 6, this.strana - (this.strana / 2));
                    obdlznik3.zmenPolohu((j + 2) * (this.strana + 1) + ((this.strana - this.strana / 6 * 3) / 2), (1) * (this.strana + 1) + (this.strana / 12));
                    obdlznik3.zmenFarbu("black");
                    obdlznik3.zobraz();

                    Obdlznik obdlznik32 = new Obdlznik();
                    obdlznik32.zmenStrany((this.strana / 6) * 3, this.strana / 6);
                    obdlznik32.zmenPolohu((j + 2) * (this.strana + 1) + ((this.strana - this.strana / 6 * 3) / 2), (1) * (this.strana + 1) + (this.strana / 12 * 7));
                    obdlznik32.zmenFarbu("black");
                    obdlznik32.zobraz();

                    Obdlznik obdlznik33 = new Obdlznik();
                    obdlznik33.zmenStrany(this.strana / 6, this.strana - (this.strana / 6));
                    obdlznik33.zmenPolohu((j + 2) * (this.strana + 1) + ((this.strana - this.strana / 2)), (1) * (this.strana + 1) + (this.strana / 12));
                    obdlznik33.zmenFarbu("black");
                    obdlznik33.zobraz();

                    break;
                case 4:
                    Obdlznik obdlznik4 = new Obdlznik();
                    obdlznik4.zmenStrany((this.strana / 6) * 3, this.strana - (this.strana / 6));
                    obdlznik4.zmenPolohu((j + 2) * (this.strana + 1) + ((this.strana - this.strana / 6 * 3) / 2), (1) * (this.strana + 1) + (this.strana / 12));
                    obdlznik4.zmenFarbu("black");
                    obdlznik4.zobraz();

                    Obdlznik obdlznik42 = new Obdlznik();
                    obdlznik42.zmenStrany((this.strana / 6) * 2, this.strana / 6);
                    obdlznik42.zmenPolohu((j + 2) * (this.strana + 1) + ((this.strana - this.strana / 6) / 2), (1) * (this.strana + 1) + (this.strana / 4));
                    obdlznik42.zmenFarbu("white");
                    obdlznik42.zobraz();

                    Obdlznik obdlznik43 = new Obdlznik();
                    obdlznik43.zmenStrany((this.strana / 6) * 2, this.strana / 6);
                    obdlznik43.zmenPolohu((j + 2) * (this.strana + 1) + ((this.strana - this.strana / 6 * 3) / 2), (1) * (this.strana + 1) + (this.strana / 12 * 9));
                    obdlznik43.zmenFarbu("white");
                    obdlznik43.zobraz();
                    break;
                case 5:
                    Obdlznik obdlznik5 = new Obdlznik();
                    obdlznik5.zmenStrany((this.strana / 6) * 3, this.strana - (this.strana / 6));
                    obdlznik5.zmenPolohu((j + 2) * (this.strana + 1) + ((this.strana - this.strana / 6 * 3) / 2), (1) * (this.strana + 1) + (this.strana / 12));
                    obdlznik5.zmenFarbu("black");
                    obdlznik5.zobraz();

                    Obdlznik obdlznik52 = new Obdlznik();
                    obdlznik52.zmenStrany((this.strana / 6) * 2, this.strana / 6);
                    obdlznik52.zmenPolohu((j + 2) * (this.strana + 1) + ((this.strana - this.strana / 6) / 2), (1) * (this.strana + 1) + (this.strana / 4));
                    obdlznik52.zmenFarbu("white");
                    obdlznik52.zobraz();

                    Obdlznik obdlznik53 = new Obdlznik();
                    obdlznik53.zmenStrany((this.strana / 6), this.strana / 6);
                    obdlznik53.zmenPolohu((j + 2) * (this.strana + 1) + ((this.strana - this.strana / 6) / 2), (1) * (this.strana + 1) + (this.strana / 12 * 9));
                    obdlznik53.zmenFarbu("white");
                    obdlznik53.zobraz();
                    break;
                case 6:
                    Obdlznik obdlznik6 = new Obdlznik();
                    obdlznik6.zmenStrany(this.strana / 6, this.strana - (this.strana / 6));
                    obdlznik6.zmenPolohu((j + 2) * (this.strana + 1) + ((this.strana - this.strana / 2 / 2 / 2 * 4)), (1) * (this.strana + 1) + (this.strana / 12));
                    obdlznik6.zmenFarbu("black");
                    obdlznik6.zobraz();

                    Obdlznik obdlznik62 = new Obdlznik();
                    obdlznik62.zmenStrany((this.strana / 6) * 3, this.strana / 6);
                    obdlznik62.zmenPolohu((j + 2) * (this.strana + 1) + ((this.strana - this.strana / 6 * 3) / 2), (1) * (this.strana + 1) + (this.strana / 12));
                    obdlznik62.zmenFarbu("black");
                    obdlznik62.zobraz();
                    break;
                case 7:
                    Obdlznik obdlznik7 = new Obdlznik();
                    obdlznik7.zmenStrany((this.strana / 6) * 3, this.strana - (this.strana / 6));
                    obdlznik7.zmenPolohu((j + 2) * (this.strana + 1) + ((this.strana - this.strana / 6 * 3) / 2), (1) * (this.strana + 1) + (this.strana / 12));
                    obdlznik7.zmenFarbu("black");
                    obdlznik7.zobraz();

                    Obdlznik obdlznik72 = new Obdlznik();
                    obdlznik72.zmenStrany((this.strana / 6), this.strana / 6);
                    obdlznik72.zmenPolohu((j + 2) * (this.strana + 1) + ((this.strana - this.strana / 6) / 2), (1) * (this.strana + 1) + (this.strana / 4));
                    obdlznik72.zmenFarbu("white");
                    obdlznik72.zobraz();

                    Obdlznik obdlznik73 = new Obdlznik();
                    obdlznik73.zmenStrany((this.strana / 6), this.strana / 6);
                    obdlznik73.zmenPolohu((j + 2) * (this.strana + 1) + ((this.strana - this.strana / 6) / 2), (1) * (this.strana + 1) + (this.strana / 12 * 9));
                    obdlznik73.zmenFarbu("white");
                    obdlznik73.zobraz();
                    break;
                case 8:
                    Obdlznik obdlznik8 = new Obdlznik();
                    obdlznik8.zmenStrany((this.strana / 6) * 3, this.strana - (this.strana / 6));
                    obdlznik8.zmenPolohu((j + 2) * (this.strana + 1) + ((this.strana - this.strana / 6 * 3) / 2), (1) * (this.strana + 1) + (this.strana / 12));
                    obdlznik8.zmenFarbu("black");
                    obdlznik8.zobraz();

                    Obdlznik obdlznik82 = new Obdlznik();
                    obdlznik82.zmenStrany((this.strana / 6), this.strana / 6);
                    obdlznik82.zmenPolohu((j + 2) * (this.strana + 1) + ((this.strana - this.strana / 6) / 2), (1) * (this.strana + 1) + (this.strana / 4));
                    obdlznik82.zmenFarbu("white");
                    obdlznik82.zobraz();

                    Obdlznik obdlznik83 = new Obdlznik();
                    obdlznik83.zmenStrany((this.strana / 6) * 2, this.strana / 6);
                    obdlznik83.zmenPolohu((j + 2) * (this.strana + 1) + ((this.strana - this.strana / 6 * 3) / 2), (1) * (this.strana + 1) + (this.strana / 12 * 9));
                    obdlznik83.zmenFarbu("white");
                    obdlznik83.zobraz();
                    break;
                case 9:
                    Obdlznik obdlznik9 = new Obdlznik();
                    obdlznik9.zmenStrany(this.strana - (this.strana / 5), this.strana - (this.strana / 5));
                    obdlznik9.zmenPolohu(((j + 2) * (this.strana + 1)) + (this.strana / 10), ((1) * (this.strana + 1)) + (this.strana / 10));
                    obdlznik9.zmenFarbu("black");
                    obdlznik9.zobraz();
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * Metoda dosah vykresli okolo zvolenej jednotky policka na ktore sa moze
     * pohnut a vrati zaciatok a koniec aby sa tato oblast nasledne dala
     * prekreslit.
     *
     * @param x predstavuje x-ovu suradnicu jednotky.
     * @param y predstavuje y-ovu suradnicu jednotky.
     * @param code urcuje ci ide o jednotku alebo o asteroid.
     * @return pole (zaciatok a koniec pre prekreslovanie).
     */
    public int[] dosah(int x, int y, boolean code) {
        int dosah = 0;
        if (code) {
            dosah = 2;
        } else {
            dosah = this.mapa[y - 1][x - 1].getDosah();
        }

        int zaciatok = x - 1 - dosah;
        int koniec = x + dosah;

        if (zaciatok < 0) {
            zaciatok = 0;
        }
        if (koniec > 30) {
            koniec = 30;
        }

        String string = "Stav jednotiek po zasahu asteroidu: \n \n";

        if (code) {

            for (int i = 0; i < 5; i++) {
                for (int j = zaciatok; j < koniec; j++) {
                    if ((abs(x - 1 - j) + abs(y - 1 - i)) <= dosah) {
                        if (this.mapa[i][j] == null) {
                            Obdlznik obdlznik = new Obdlznik();
                            obdlznik.zmenStrany(this.strana, this.strana);
                            obdlznik.zmenPolohu((j + 2) * (this.strana + 1), (i + 2) * (this.strana + 1));
                            obdlznik.zmenFarbu("orange");
                            obdlznik.zobraz();
                        } else {

                            this.mapa[i][j].setPocet(150);
                            string += this.mapa[i][j].dajPopis() + "\n \n";
                            if (this.mapa[i][j].getPocet() <= 0) {
                                this.mapa[i][j] = null;

                                Obdlznik obdlznik = new Obdlznik();
                                obdlznik.zmenStrany(this.strana, this.strana);
                                obdlznik.zmenPolohu((j + 2) * (this.strana + 1), (i + 2) * (this.strana + 1));
                                obdlznik.zmenFarbu("green");
                                obdlznik.zobraz();
                            }

                        }
                    }
                }
            }
            JOptionPane.showMessageDialog(null, string);
        } else {
            for (int i = 0; i < 5; i++) {
                for (int j = zaciatok; j < koniec; j++) {
                    if ((abs(x - 1 - j) + abs(y - 1 - i)) <= dosah) {
                        if (this.mapa[i][j] == null) {
                            Obdlznik obdlznik = new Obdlznik();
                            obdlznik.zmenStrany(this.strana, this.strana);
                            obdlznik.zmenPolohu((j + 2) * (this.strana + 1), (i + 2) * (this.strana + 1));
                            obdlznik.zmenFarbu("yellow");
                            obdlznik.zobraz();
                        }
                    }
                }
            }
        }

        int[] pole = new int[]{zaciatok, koniec};
        return pole;
    }

    /**
     * Metoda stav po tahu prejde celym polom zrata pocty vojakov v jednotkach a
     * ich moralku a vrati celkove hodnoty.
     *
     * @param hrac1 predstavuje meno prveho hraca.
     * @param hrac2 predstavuje meno druheho hraca.
     * @return pole (celkove hodnoty poctov a moralky).
     */
    public double[] stavPoTahu(String hrac1, String hrac2) {
        double[] pole = new double[3];
        double pocet1 = 0;
        double pocet2 = 0;
        double moralka1 = 0;
        double moralka2 = 0;
        int pocetJednotiek1 = 0;
        int pocetJednotiek2 = 0;
        for (int i = 0; i < this.pocetPolicokY; i++) {
            for (int j = 0; j < this.pocetPolicokX; j++) {
                if (this.mapa[i][j] != null) {
                    if (this.mapa[i][j].getCode() > 0) {
                        pocet1 += this.mapa[i][j].getPocet();
                        moralka1 += this.mapa[i][j].getMoralka();
                        pocetJednotiek1 += 1;
                        if (this.mapa[i][j].isPripravenaObrana()) {
                            this.mapa[i][j].setObrana(0.5);
                            this.mapa[i][j].setPripravenaObrana(false);
                        }
                    } else {
                        pocet2 += this.mapa[i][j].getPocet();
                        moralka2 += this.mapa[i][j].getMoralka();
                        pocetJednotiek2 += 1;
                        if (this.mapa[i][j].isPripravenaObrana()) {
                            this.mapa[i][j].setObrana(0.5);
                            this.mapa[i][j].setPripravenaObrana(false);
                        }
                    }
                }
            }
        }
        pole[1] = pocet1;
        pole[2] = pocet2;
        JOptionPane.showMessageDialog(null, "CELKOVY STAV \n \nVojsko hraca " + hrac1 + ": " + pocet1 + "\nMoralka: " + (moralka1 / pocetJednotiek1) + "%" + "\n \nVojsko hraca " + hrac2 + ": " + pocet2 + "\nMoralka: " + (moralka2 / pocetJednotiek2) + "%");
        if (pocet1 <= 0 || pocet2 <= 0) {
            pole[0] = 1;
        } else {
            pole[0] = 0;
        }
        return pole;
    }

    /**
     * Metoda vykresleniePlochy vykresli hraciu plochu.
     *
     * @throws java.lang.InterruptedException
     */
    public void vykresleniePlochy() throws InterruptedException {

        Obdlznik pozadie = new Obdlznik();
        pozadie.zmenStrany(this.strana * 31 + 36, this.strana * 6 + 11);
        pozadie.zmenPolohu(this.strana - 2, this.strana - 2);
        pozadie.zmenFarbu("black");
        pozadie.zobraz();

        this.suradnice();

        for (int i = 0; i < this.pocetPolicokY; i++) {
            for (int j = 0; j < this.pocetPolicokX; j++) {

                this.mapa[i][j] = null;

                Obdlznik obdlznik = new Obdlznik();
                obdlznik.zmenStrany(this.strana, this.strana);
                obdlznik.zmenPolohu((j + 2) * (this.strana + 1), (i + 2) * (this.strana + 1));
                obdlznik.zmenFarbu("green");
                obdlznik.zobraz();

            }
        }
    }

    /**
     * Metoda prekreslenie plochy, prekresli policka plochy od zadaneho zaciatku
     * az po zadany koniec.
     *
     * @param x predstavuje zaciatok prekreslenia.
     * @param x1 predstavuje koniec prekreslenia.
     */
    public void prekresleniePlochy(int x, int x1) {
        for (int i = 0; i < this.pocetPolicokY; i++) {
            for (int j = x; j < x1; j++) {

                if (this.mapa[i][j] == null) {
                    Obdlznik obdlznik = new Obdlznik();
                    obdlznik.zmenStrany(this.strana, this.strana);
                    obdlznik.zmenPolohu((j + 2) * (this.strana + 1), (i + 2) * (this.strana + 1));
                    obdlznik.zmenFarbu("green");
                    obdlznik.zobraz();
                }
            }
        }
    }

    /**
     * Metoda prebiehaBoj prejde celu hraciu plochu a skontroluje ci sa vedla
     * seba nenachadzaju dve nepriatelske jednotky, a ak ano zmeni ich hodnoty
     * uzBojoval na true.
     */
    public void prebiehaBoj() {
        for (int i = 0; i < this.pocetPolicokY; i++) {
            for (int j = 0; j < this.pocetPolicokX; j++) {
                if (this.mapa[i][j] != null) {
                    if (this.mapa[i][j].isJeVBoji() && this.mapa[i][j].isUzBojoval() == false) {
                        this.mapa[i][j].boj(j + 1, i + 1, this, false);
                        if (this.mapa[i][j + 1] != null) {
                            this.mapa[i][j + 1].setUzBojoval(true);
                        }
                        if (this.mapa[i][j - 1] != null) {
                            this.mapa[i][j - 1].setUzBojoval(true);
                        }                       
                    } else {
                        this.mapa[i][j].setUzBojoval(false);
                    }
                }
            }
        }
    }

    /**
     * Metoda vyznaceneMiesto vykresli policka na ktorych moze hrac umiestnovat
     * svoju armadu.
     *
     * @param code urcuje o ktoreho hraca ide a o miesto kde moze svoju armadu
     * umiestnit.
     */
    public void vyznaceneMiesto(int code) {
        int zaciatok = 0;
        if (code == 1) {
            zaciatok = 0;
        } else {
            zaciatok = 22;
        }

        for (int i = 0; i < this.pocetPolicokY; i++) {
            for (int j = zaciatok; j < zaciatok + 8; j++) {

                if (this.mapa[i][j] == null) {
                    Obdlznik obdlznik = new Obdlznik();
                    obdlznik.zmenStrany(this.strana, this.strana);
                    obdlznik.zmenPolohu((j + 2) * (this.strana + 1), (i + 2) * (this.strana + 1));
                    obdlznik.zmenFarbu("yellow");
                    obdlznik.zobraz();
                }
            }
        }
    }

    /**
     * Metoda kryciaPlocha prekresli armadu prveho hraca aby pri nastavovani
     * svojej armady druhy hrac nemal vyhodu. Metoda dany obdlznik vrati aby
     * mohol byt neskor odstraneny.
     *
     * @param code urcuje o ktoreho hraca ide.
     * @return obdlznik.
     */
    public Obdlznik kryciaPlocha(int code) {
        Obdlznik obdlznik = new Obdlznik();
        obdlznik.zmenStrany(8 * (this.strana + 1), 5 * (this.strana + 1));
        if (code == 1) {
            obdlznik.zmenPolohu((2) * (this.strana + 1), (2) * (this.strana + 1));
        } else {
            obdlznik.zmenPolohu((24) * (this.strana + 1), (2) * (this.strana + 1));
        }
        obdlznik.zmenFarbu("black");
        obdlznik.zobraz();

        return obdlznik;
    }

    /**
     * Metoda kontrola miesta prejde buducu trasu jednotky, a ak by mala mat
     * prekazky skrati trasu pred prekazku vrati nove suradnice trasy.
     *
     * @param aktualneX urcuje aktualnu x-ovu poziciu jednotky.
     * @param aktualneY urcuje aktualnu y-ovu poziciu jednotky.
     * @param x urcuje x-ovu poziciu konca trasy.
     * @param y urcuje y-ovu poziciu konca trasy.
     * @param smer urcuje ci ma ist trasa severnou cestou alebo juznou.
     * @return pole (pole s novymi suradnicami konca trasy).
     */
    public int[] kontrolaMiesta(int aktualneX, int aktualneY, int x, int y, int smer) {
        boolean a = true;

        if (this.mapa[y - 1][x - 1] == null) {
            a = false;
        }

        while (a) {
            switch (smer) {
                case 0:
                    if (x == aktualneX) {
                        if (y != aktualneY) {
                            if (y < aktualneY) {
                                y += 1;
                            } else {
                                y -= 1;
                            }
                        } else {
                            a = false;
                        }
                    } else {
                        if (x != aktualneX) {
                            if (x < aktualneX) {
                                x += 1;
                            } else {
                                x -= 1;
                            }
                        } else {
                            a = false;
                        }
                    }

                    if (this.mapa[y - 1][x - 1] == null) {
                        a = false;
                    }

                    break;
                case 1:
                    if (y < aktualneY) {
                        if (x == aktualneX && y == aktualneY) {
                            a = false;
                        } else {
                            if (x != aktualneX) {
                                if (x < aktualneX) {
                                    x += 1;
                                } else {
                                    x -= 1;
                                }
                            } else {
                                if (y < aktualneY) {
                                    y += 1;
                                } else {
                                    y -= 1;
                                }
                            }
                        }
                    } else {
                        if (x == aktualneX && y == aktualneY) {
                            a = false;
                        } else {
                            if (y != aktualneY) {
                                if (y < aktualneY) {
                                    y += 1;
                                } else {
                                    y -= 1;
                                }
                            } else {
                                if (x < aktualneX) {
                                    x += 1;
                                } else {
                                    x -= 1;
                                }
                            }
                        }
                    }

                    if (this.mapa[y - 1][x - 1] == null) {
                        a = false;
                    }

                    break;
                case 2:
                    if (y > aktualneY) {
                        if (x == aktualneX && y == aktualneY) {
                            a = false;
                        } else {
                            if (x != aktualneX) {
                                if (x < aktualneX) {
                                    x += 1;
                                } else {
                                    x -= 1;
                                }
                            } else {
                                if (y < aktualneY) {
                                    y += 1;
                                } else {
                                    y -= 1;
                                }
                            }
                        }
                    } else {
                        if (x == aktualneX && y == aktualneY) {
                            a = false;
                        } else {
                            if (y != aktualneY) {
                                if (y < aktualneY) {
                                    y += 1;
                                } else {
                                    y -= 1;
                                }
                            } else {
                                if (x < aktualneX) {
                                    x += 1;
                                } else {
                                    x -= 1;
                                }
                            }
                        }
                    }

                    if (this.mapa[y - 1][x - 1] == null) {
                        a = false;
                    }

                    break;
            }
        }

        int[] pole = new int[2];
        pole[0] = x;
        pole[1] = y;

        return pole;
    }

    /**
     * Metoda getMapa vrati zadane policko na mape a vrati jednotku, ktora sa
     * tam nachadza.
     *
     * @param x urcuje x-ovu suradnicu policka.
     * @param y urcuje y-ovu suradnicu policka.
     * @return Soldier (jednotka na danej pozicii).
     */
    public Soldier getMapa(int x, int y) {
        return (Soldier)this.mapa[y][x];
    }

    /**
     * Metoda setMapa zmeni zadane policko na zadane policko.
     *
     * @param x predstavuje x-ovu suradnicu policka.
     * @param y predstavjue y-ovu suradnicu policka.
     * @param z predstavuje zadane policko.
     */
    public void setMapa(int x, int y, Soldier z) {
        this.mapa[y][x] = (ISoldier)z;
    }

    /**
     * Metoda utek prejde celu hraciu plochu a jednotky ktorych moralka je
     * mensia ako 15% necha utiect a vymaze ich.
     *
     * @param hrac1 predstavuje meno prveho hraca.
     * @param hrac2 predstavuje meno druheho hraca.
     */
    public void utek(String hrac1, String hrac2) {
        System.out.println("stal sa utek");
        for (int i = 0; i < this.pocetPolicokY; i++) {
            for (int j = 0; j < this.pocetPolicokX; j++) {
                if (this.mapa[i][j] != null) {
                    System.out.println(i + " " + j);
                    if (this.mapa[i][j].getCode() > 0) {
                        if (this.mapa[i][j].getMoralka() < 15) {
                            /**int[] pole = this.kontrolaMiesta(j + 1, i + 1, 1, i + 1, 0);
                            int x = pole[0];
                            int y = pole[1];
                            int[] pole1 = this.basicMove(j + 1, i + 1, x, y, 0);*/
                            this.mapa[i][j] = null;

                            Obdlznik obdlznik = new Obdlznik();
                            obdlznik.zmenStrany(this.strana, this.strana);
                            obdlznik.zmenPolohu((j + 2) * (this.strana + 1), (i + 2) * (this.strana + 1));
                            obdlznik.zmenFarbu("green");
                            obdlznik.zobraz();
                            JOptionPane.showMessageDialog(null, "TVOJA JEDNOTKA UTIEKLA Z BOJA", hrac1, JOptionPane.WARNING_MESSAGE);

                        }
                    } else {
                        if (this.mapa[i][j].getMoralka() < 15) {
                            /**int[] pole = this.kontrolaMiesta(j + 1, i + 1, 30, i + 1, 0);
                            int x = pole[0];
                            int y = pole[1];
                            int[] pole1 = this.basicMove(j + 1, i + 1, x, y, 0);*/
                            this.mapa[i][j] = null;

                            Obdlznik obdlznik = new Obdlznik();
                            obdlznik.zmenStrany(this.strana, this.strana);
                            obdlznik.zmenPolohu((j + 2) * (this.strana + 1), (i + 2) * (this.strana + 1));
                            obdlznik.zmenFarbu("green");
                            obdlznik.zobraz();
                            JOptionPane.showMessageDialog(null, "TVOJA JEDNOTKA UTIEKLA Z BOJA", hrac2, JOptionPane.WARNING_MESSAGE);

                        }
                    }
                }
            }
        }
    }

    /**
     * Metoda basicMove spravy pohyb jednotky z aktualneho policka na zadane
     * policko, ale iba pohybom rovnobeznym, bud s x-ovou osou alebo y-osou.
     * Metoda na konci vrati pole s aktualnou x-ovou a y-ovou surandicou.
     *
     * @param aktualneX predstavuje aktualnu x-ovu suradnicu jednotky.
     * @param aktualneY predstavuje aktualnu y-ovu suradnicu jednotky.
     * @param x predstavuje x-ovu suradnicu, kam sa ma jednotka dostat.
     * @param y predstavuje y-ovu suradnicu, kam sa ma jednotka dostat.
     * @param identifikator urcuje o ktoreho hraca ide.
     * @return pole (akualne suradnice v poli).
     */
    public int[] basicMove(int aktualneX, int aktualneY, int x, int y, int identifikator) {
        System.out.println("stal sa pohyb");
        Soldier pomoc0 = null;
        Soldier pomoc1 = null;

        if (this.pomoc != null) {
            pomoc0 = this.pomoc;
            this.pomoc = null;
        }

        this.mapa[aktualneY - 1][aktualneX - 1].setJeVBoji(false);

        try {
            if (y == aktualneY) {
                //System.out.println("if");
                
                for (int i = 0; i < abs(aktualneX - x); i++) {
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }

                    if (pomoc1 == null) {
                        if (pomoc0 == null) {
                            if (aktualneX < x) {
                                if (this.mapa[aktualneY - 1][aktualneX + i] == null) {
                                    this.mapa[aktualneY - 1][aktualneX + i] = this.mapa[aktualneY - 1][aktualneX - 1 + i];
                                    this.mapa[aktualneY - 1][aktualneX - 1 + i] = null;
                                    this.vykreslenieVojakov(aktualneX + 1 + i, aktualneY);

                                    Obdlznik obdlznik = new Obdlznik();
                                    obdlznik.zmenStrany(this.strana, this.strana);
                                    obdlznik.zmenPolohu((aktualneX + i + 1) * (this.strana + 1), (aktualneY + 1) * (this.strana + 1));
                                    obdlznik.zmenFarbu("green");
                                    obdlznik.zobraz();
                                } else {
                                    if (this.mapa[aktualneY - 1][aktualneX - 1 + i].getCode() > 0 && this.mapa[aktualneY - 1][aktualneX + i].getCode() < 0) {
                                        this.mapa[aktualneY - 1][aktualneX - 1 + i].setJeVBoji(true);
                                        x = aktualneX + i;
                                        i = abs(aktualneX - x);
                                    } else if (this.mapa[aktualneY - 1][aktualneX - 1 + i].getCode() < 0 && this.mapa[aktualneY - 1][aktualneX + i].getCode() > 0) {
                                        this.mapa[aktualneY - 1][aktualneX - 1 + i].setJeVBoji(true);
                                        x = aktualneX + i;
                                        i = abs(aktualneX - x);
                                    } else {
                                        pomoc0 = (Soldier)this.mapa[aktualneY - 1][aktualneX + i];
                                        this.mapa[aktualneY - 1][aktualneX + i] = this.mapa[aktualneY - 1][aktualneX - 1 + i];
                                        this.mapa[aktualneY - 1][aktualneX - 1 + i] = null;
                                        this.vykreslenieVojakov(aktualneX + 1 + i, aktualneY);

                                        Obdlznik obdlznik = new Obdlznik();
                                        obdlznik.zmenStrany(this.strana, this.strana);
                                        obdlznik.zmenPolohu((aktualneX + i + 1) * (this.strana + 1), (aktualneY + 1) * (this.strana + 1));
                                        obdlznik.zmenFarbu("green");
                                        obdlznik.zobraz();
                                    }
                                }
                            } else {
                                if (this.mapa[aktualneY - 1][aktualneX - 2 - i] == null) {
                                    this.mapa[aktualneY - 1][aktualneX - 2 - i] = this.mapa[aktualneY - 1][aktualneX - 1 - i];
                                    this.mapa[aktualneY - 1][aktualneX - 1 - i] = null;
                                    this.vykreslenieVojakov(aktualneX - 1 - i, aktualneY);

                                    Obdlznik obdlznik = new Obdlznik();
                                    obdlznik.zmenStrany(this.strana, this.strana);
                                    obdlznik.zmenPolohu((aktualneX - i + 1) * (this.strana + 1), (aktualneY + 1) * (this.strana + 1));
                                    obdlznik.zmenFarbu("green");
                                    obdlznik.zobraz();
                                } else {
                                    if (this.mapa[aktualneY - 1][aktualneX - 1 - i].getCode() > 0 && this.mapa[aktualneY - 1][aktualneX - 2 - i].getCode() < 0) {
                                        this.mapa[aktualneY - 1][aktualneX - 1 - i].setJeVBoji(true);
                                        x = aktualneX - i;
                                        i = abs(aktualneX - x);
                                    } else if (this.mapa[aktualneY - 1][aktualneX - 1 - i].getCode() < 0 && this.mapa[aktualneY - 1][aktualneX - 2 - i].getCode() > 0) {
                                        this.mapa[aktualneY - 1][aktualneX - 1 - i].setJeVBoji(true);
                                        x = aktualneX - i;
                                        i = abs(aktualneX - x);
                                    } else {
                                        pomoc0 = (Soldier)this.mapa[aktualneY - 1][aktualneX - 2 - i];
                                        this.mapa[aktualneY - 1][aktualneX - 2 - i] = this.mapa[aktualneY - 1][aktualneX - 1 - i];
                                        this.mapa[aktualneY - 1][aktualneX - 1 - i] = null;
                                        this.vykreslenieVojakov(aktualneX - 1 - i, aktualneY);

                                        Obdlznik obdlznik = new Obdlznik();
                                        obdlznik.zmenStrany(this.strana, this.strana);
                                        obdlznik.zmenPolohu((aktualneX - i + 1) * (this.strana + 1), (aktualneY + 1) * (this.strana + 1));
                                        obdlznik.zmenFarbu("green");
                                        obdlznik.zobraz();
                                    }
                                }
                            }

                        } else {
                            if (aktualneX < x) {
                                if (this.mapa[aktualneY - 1][aktualneX + i] == null) {
                                    this.mapa[aktualneY - 1][aktualneX + i] = this.mapa[aktualneY - 1][aktualneX - 1 + i];
                                    this.mapa[aktualneY - 1][aktualneX - 1 + i] = pomoc0;
                                    this.vykreslenieVojakov(aktualneX + i, aktualneY);
                                    this.vykreslenieVojakov(aktualneX + 1 + i, aktualneY);
                                } else {
                                    if (this.mapa[aktualneY - 1][aktualneX - 1 + i].getCode() > 0 && this.mapa[aktualneY - 1][aktualneX + i].getCode() < 0) {
                                        this.mapa[aktualneY - 1][aktualneX - 1 + i].setJeVBoji(true);
                                        x = aktualneX + i;
                                        i = abs(aktualneX - x);
                                    } else if (this.mapa[aktualneY - 1][aktualneX - 1 + i].getCode() < 0 && this.mapa[aktualneY - 1][aktualneX + i].getCode() > 0) {
                                        this.mapa[aktualneY - 1][aktualneX - 1 + i].setJeVBoji(true);
                                        x = aktualneX + i;
                                        i = abs(aktualneX - x);
                                    } else {
                                        pomoc1 = (Soldier)this.mapa[aktualneY - 1][aktualneX + i];
                                        this.mapa[aktualneY - 1][aktualneX + i] = this.mapa[aktualneY - 1][aktualneX - 1 + i];
                                        this.mapa[aktualneY - 1][aktualneX - 1 + i] = pomoc0;
                                        this.vykreslenieVojakov(aktualneX + i, aktualneY);
                                        this.vykreslenieVojakov(aktualneX + 1 + i, aktualneY);
                                    }
                                }
                            } else {
                                if (this.mapa[aktualneY - 1][aktualneX - 2 - i] == null) {
                                    this.mapa[aktualneY - 1][aktualneX - 2 - i] = this.mapa[aktualneY - 1][aktualneX - 1 - i];
                                    this.mapa[aktualneY - 1][aktualneX - 1 - i] = pomoc0;
                                    this.vykreslenieVojakov(aktualneX - i, aktualneY);
                                    this.vykreslenieVojakov(aktualneX - 1 - i, aktualneY);
                                } else {
                                    if (this.mapa[aktualneY - 1][aktualneX - 1 - i].getCode() > 0 && this.mapa[aktualneY - 1][aktualneX - 2 - i].getCode() < 0) {
                                        this.mapa[aktualneY - 1][aktualneX - 1 - i].setJeVBoji(true);
                                        x = aktualneX - i;
                                        i = abs(aktualneX - x);
                                    } else if (this.mapa[aktualneY - 1][aktualneX - 1 - i].getCode() < 0 && this.mapa[aktualneY - 1][aktualneX - 2 - i].getCode() > 0) {
                                        this.mapa[aktualneY - 1][aktualneX - 1 - i].setJeVBoji(true);
                                        x = aktualneX - i;
                                        i = abs(aktualneX - x);
                                    } else {
                                        pomoc1 = (Soldier)this.mapa[aktualneY - 1][aktualneX - 2 - i];
                                        this.mapa[aktualneY - 1][aktualneX - 2 - i] = this.mapa[aktualneY - 1][aktualneX - 1 - i];
                                        this.mapa[aktualneY - 1][aktualneX - 1 - i] = pomoc0;
                                        this.vykreslenieVojakov(aktualneX - i, aktualneY);
                                        this.vykreslenieVojakov(aktualneX - 1 - i, aktualneY);
                                    }
                                }
                            }
                            pomoc0 = null;
                        }
                    } else {
                        if (pomoc0 == null) {
                            if (aktualneX < x) {
                                if (this.mapa[aktualneY - 1][aktualneX + i] == null) {
                                    this.mapa[aktualneY - 1][aktualneX + i] = this.mapa[aktualneY - 1][aktualneX - 1 + i];
                                    this.mapa[aktualneY - 1][aktualneX - 1 + i] = pomoc1;
                                    this.vykreslenieVojakov(aktualneX + i, aktualneY);
                                    this.vykreslenieVojakov(aktualneX + 1 + i, aktualneY);

                                } else {
                                    if (this.mapa[aktualneY - 1][aktualneX - 1 + i].getCode() > 0 && this.mapa[aktualneY - 1][aktualneX + i].getCode() < 0) {
                                        this.mapa[aktualneY - 1][aktualneX - 1 + i].setJeVBoji(true);
                                        x = aktualneX + i;
                                        i = abs(aktualneX - x);
                                    } else if (this.mapa[aktualneY - 1][aktualneX - 1 + i].getCode() < 0 && this.mapa[aktualneY - 1][aktualneX + i].getCode() > 0) {
                                        this.mapa[aktualneY - 1][aktualneX - 1 + i].setJeVBoji(true);
                                        x = aktualneX + i;
                                        i = abs(aktualneX - x);
                                    } else {
                                        pomoc0 = (Soldier)this.mapa[aktualneY - 1][aktualneX + i];
                                        this.mapa[aktualneY - 1][aktualneX + i] = this.mapa[aktualneY - 1][aktualneX - 1 + i];
                                        this.mapa[aktualneY - 1][aktualneX - 1 + i] = pomoc1;
                                        this.vykreslenieVojakov(aktualneX + i, aktualneY);
                                        this.vykreslenieVojakov(aktualneX + 1 + i, aktualneY);
                                    }
                                }
                            } else {
                                if (this.mapa[aktualneY - 1][aktualneX - 2 - i] == null) {
                                    this.mapa[aktualneY - 1][aktualneX - 2 - i] = this.mapa[aktualneY - 1][aktualneX - 1 - i];
                                    this.mapa[aktualneY - 1][aktualneX - 1 - i] = pomoc1;
                                    this.vykreslenieVojakov(aktualneX - i, aktualneY);
                                    this.vykreslenieVojakov(aktualneX - 1 - i, aktualneY);
                                } else {
                                    if (this.mapa[aktualneY - 1][aktualneX - 1 - i].getCode() > 0 && this.mapa[aktualneY - 1][aktualneX - 2 - i].getCode() < 0) {
                                        this.mapa[aktualneY - 1][aktualneX - 1 - i].setJeVBoji(true);
                                        x = aktualneX - i;
                                        i = abs(aktualneX - x);
                                    } else if (this.mapa[aktualneY - 1][aktualneX - 1 - i].getCode() < 0 && this.mapa[aktualneY - 1][aktualneX - 2 - i].getCode() > 0) {
                                        this.mapa[aktualneY - 1][aktualneX - 1 - i].setJeVBoji(true);
                                        x = aktualneX - i;
                                        i = abs(aktualneX - x);
                                    } else {
                                        pomoc0 = (Soldier)this.mapa[aktualneY - 1][aktualneX - 2 - i];
                                        this.mapa[aktualneY - 1][aktualneX - 2 - i] = this.mapa[aktualneY - 1][aktualneX - 1 - i];
                                        this.mapa[aktualneY - 1][aktualneX - 1 - i] = pomoc1;
                                        this.vykreslenieVojakov(aktualneX - i, aktualneY);
                                        this.vykreslenieVojakov(aktualneX - 1 - i, aktualneY);
                                    }
                                }
                            }
                            pomoc1 = null;

                        } else {
                            if (aktualneX < x) {
                                if (this.mapa[aktualneY - 1][aktualneX + i] == null) {
                                    this.mapa[aktualneY - 1][aktualneX + i] = this.mapa[aktualneY - 1][aktualneX - 1 + i];
                                    this.mapa[aktualneY - 1][aktualneX - 1 + i] = pomoc1;
                                    this.vykreslenieVojakov(aktualneX + i, aktualneY);
                                    this.vykreslenieVojakov(aktualneX + 1 + i, aktualneY);
                                } else {
                                    if (this.mapa[aktualneY - 1][aktualneX - 1 + i].getCode() > 0 && this.mapa[aktualneY - 1][aktualneX + i].getCode() < 0) {
                                        this.mapa[aktualneY - 1][aktualneX - 1 + i].setJeVBoji(true);
                                        x = aktualneX + i;
                                        i = abs(aktualneX - x);
                                    } else if (this.mapa[aktualneY - 1][aktualneX - 1 + i].getCode() < 0 && this.mapa[aktualneY - 1][aktualneX + i].getCode() > 0) {
                                        this.mapa[aktualneY - 1][aktualneX - 1 + i].setJeVBoji(true);
                                        x = aktualneX + i;
                                        i = abs(aktualneX - x);
                                    } else {
                                        pomoc0 = (Soldier)this.mapa[aktualneY - 1][aktualneX + i];
                                        this.mapa[aktualneY - 1][aktualneX + i] = this.mapa[aktualneY - 1][aktualneX - 1 + i];
                                        this.mapa[aktualneY - 1][aktualneX - 1 + i] = pomoc1;
                                        this.vykreslenieVojakov(aktualneX + i, aktualneY);
                                        this.vykreslenieVojakov(aktualneX + 1 + i, aktualneY);
                                    }
                                }
                            } else {
                                if (this.mapa[aktualneY - 1][aktualneX - 2 - i] == null) {
                                    this.mapa[aktualneY - 1][aktualneX - 2 - i] = this.mapa[aktualneY - 1][aktualneX - 1 - i];
                                    this.mapa[aktualneY - 1][aktualneX - 1 - i] = pomoc1;
                                    this.vykreslenieVojakov(aktualneX - i, aktualneY);
                                    this.vykreslenieVojakov(aktualneX - 1 - i, aktualneY);
                                } else {
                                    if (this.mapa[aktualneY - 1][aktualneX - 1 - i].getCode() > 0 && this.mapa[aktualneY - 1][aktualneX - 2 - i].getCode() < 0) {
                                        this.mapa[aktualneY - 1][aktualneX - 1 - i].setJeVBoji(true);
                                        x = aktualneX - i;
                                        i = abs(aktualneX - x);
                                    } else if (this.mapa[aktualneY - 1][aktualneX - 1 - i].getCode() < 0 && this.mapa[aktualneY - 1][aktualneX - 2 - i].getCode() > 0) {
                                        this.mapa[aktualneY - 1][aktualneX - 1 - i].setJeVBoji(true);
                                        x = aktualneX - i;
                                        i = abs(aktualneX - x);
                                    } else {
                                        pomoc0 = (Soldier)this.mapa[aktualneY - 1][aktualneX - 2 - i];
                                        this.mapa[aktualneY - 1][aktualneX - 2 - i] = this.mapa[aktualneY - 1][aktualneX - 1 - i];
                                        this.mapa[aktualneY - 1][aktualneX - 1 - i] = pomoc1;
                                        this.vykreslenieVojakov(aktualneX - i, aktualneY);
                                        this.vykreslenieVojakov(aktualneX - 1 - i, aktualneY);
                                    }
                                }
                            }
                            pomoc1 = null;
                        }
                    }
                    if (i == (abs(aktualneX - x) - 1) && (pomoc0 != null || pomoc1 != null)) {
                        System.out.println("okej");
                        if (pomoc0 != null) {
                            this.pomoc = pomoc0;
                        } else {
                            this.pomoc = pomoc1;
                        }
                    }
                    //i++;
                }
            } else {
                //System.out.println("else");
                
                for (int i = 0; i < abs(aktualneY - y); i++) {
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                    if (pomoc1 == null) {
                        if (pomoc0 == null) {
                            if (aktualneY < y) {
                                if (this.mapa[aktualneY + i][aktualneX - 1] == null) {
                                    this.mapa[aktualneY + i][aktualneX - 1] = this.mapa[aktualneY - 1 + i][aktualneX - 1];
                                    this.mapa[aktualneY - 1 + i][aktualneX - 1] = null;
                                    this.vykreslenieVojakov(aktualneX, aktualneY + 1 + i);

                                    Obdlznik obdlznik = new Obdlznik();
                                    obdlznik.zmenStrany(this.strana, this.strana);
                                    obdlznik.zmenPolohu((aktualneX + 1) * (this.strana + 1), (aktualneY + i + 1) * (this.strana + 1));
                                    obdlznik.zmenFarbu("green");
                                    obdlznik.zobraz();
                                } else {
                                    if (this.mapa[aktualneY - 1 + i][aktualneX - 1].getCode() > 0 && this.mapa[aktualneY + i][aktualneX - 1].getCode() < 0) {
                                        this.mapa[aktualneY - 1 + i][aktualneX - 1].setJeVBoji(true);
                                        y = aktualneY + i;
                                        i = abs(aktualneY - y);
                                    } else if (this.mapa[aktualneY - 1 + i][aktualneX - 1].getCode() < 0 && this.mapa[aktualneY + i][aktualneX - 1].getCode() > 0) {
                                        this.mapa[aktualneY - 1 + i][aktualneX - 1].setJeVBoji(true);
                                        y = aktualneY + i;
                                        i = abs(aktualneY - y);
                                    } else {
                                        pomoc0 = (Soldier)this.mapa[aktualneY + i][aktualneX - 1];
                                        this.mapa[aktualneY + i][aktualneX - 1] = this.mapa[aktualneY - 1 + i][aktualneX - 1];
                                        this.mapa[aktualneY - 1 + i][aktualneX - 1] = null;
                                        this.vykreslenieVojakov(aktualneX, aktualneY + 1 + i);

                                        Obdlznik obdlznik = new Obdlznik();
                                        obdlznik.zmenStrany(this.strana, this.strana);
                                        obdlznik.zmenPolohu((aktualneX + 1) * (this.strana + 1), (aktualneY + i + 1) * (this.strana + 1));
                                        obdlznik.zmenFarbu("green");
                                        obdlznik.zobraz();
                                    }
                                }
                            } else {
                                if (this.mapa[aktualneY - 2 - i][aktualneX - 1] == null) {
                                    this.mapa[aktualneY - 2 - i][aktualneX - 1] = this.mapa[aktualneY - 1 - i][aktualneX - 1];
                                    this.mapa[aktualneY - 1 - i][aktualneX - 1] = null;
                                    this.vykreslenieVojakov(aktualneX, aktualneY - 1 - i);

                                    Obdlznik obdlznik = new Obdlznik();
                                    obdlznik.zmenStrany(this.strana, this.strana);
                                    obdlznik.zmenPolohu((aktualneX + 1) * (this.strana + 1), (aktualneY - i + 1) * (this.strana + 1));
                                    obdlznik.zmenFarbu("green");
                                    obdlznik.zobraz();
                                } else {
                                    if (this.mapa[aktualneY - 1 - i][aktualneX - 1].getCode() > 0 && this.mapa[aktualneY - 2 - i][aktualneX - 1].getCode() < 0) {
                                        this.mapa[aktualneY - 1 - i][aktualneX - 1].setJeVBoji(true);
                                        y = aktualneY - i;
                                        i = abs(aktualneY - y);
                                    } else if (this.mapa[aktualneY - 1 - i][aktualneX - 1].getCode() < 0 && this.mapa[aktualneY - 2 - i][aktualneX - 1].getCode() > 0) {
                                        this.mapa[aktualneY - 1 - i][aktualneX - 1].setJeVBoji(true);
                                        y = aktualneY - i;
                                        i = abs(aktualneY - y);
                                    } else {
                                        pomoc0 = (Soldier)this.mapa[aktualneY - 2 - i][aktualneX - 1];
                                        this.mapa[aktualneY - 2 - i][aktualneX - 1] = this.mapa[aktualneY - 1 - i][aktualneX - 1];
                                        this.mapa[aktualneY - 1 - i][aktualneX - 1] = null;
                                        this.vykreslenieVojakov(aktualneX, aktualneY - 1 - i);

                                        Obdlznik obdlznik = new Obdlznik();
                                        obdlznik.zmenStrany(this.strana, this.strana);
                                        obdlznik.zmenPolohu((aktualneX + 1) * (this.strana + 1), (aktualneY - i + 1) * (this.strana + 1));
                                        obdlznik.zmenFarbu("green");
                                        obdlznik.zobraz();
                                    }
                                }
                            }

                        } else {
                            if (aktualneY < y) {
                                if (this.mapa[aktualneY + i][aktualneX - 1] == null) {
                                    this.mapa[aktualneY + i][aktualneX - 1] = this.mapa[aktualneY - 1 + i][aktualneX - 1];
                                    this.mapa[aktualneY - 1 + i][aktualneX - 1] = pomoc0;
                                    this.vykreslenieVojakov(aktualneX, aktualneY + i);
                                    this.vykreslenieVojakov(aktualneX, aktualneY + 1 + i);
                                } else {
                                    if (this.mapa[aktualneY - 1 + i][aktualneX - 1].getCode() > 0 && this.mapa[aktualneY + i][aktualneX - 1].getCode() < 0) {
                                        this.mapa[aktualneY - 1 + i][aktualneX - 1].setJeVBoji(true);
                                        y = aktualneY + i;
                                        i = abs(aktualneY - y);
                                    } else if (this.mapa[aktualneY - 1 + i][aktualneX - 1].getCode() < 0 && this.mapa[aktualneY + i][aktualneX - 1].getCode() > 0) {
                                        this.mapa[aktualneY - 1 + i][aktualneX - 1].setJeVBoji(true);
                                        y = aktualneY + i;
                                        i = abs(aktualneY - y);
                                    } else {
                                        pomoc1 = (Soldier)this.mapa[aktualneY + i][aktualneX - 1];
                                        this.mapa[aktualneY + i][aktualneX - 1] = this.mapa[aktualneY - 1 + i][aktualneX - 1];
                                        this.mapa[aktualneY - 1 + i][aktualneX - 1] = pomoc0;
                                        this.vykreslenieVojakov(aktualneX, aktualneY + i);
                                        this.vykreslenieVojakov(aktualneX, aktualneY + 1 + i);
                                    }
                                }
                            } else {
                                if (this.mapa[aktualneY - 2 - i][aktualneX - 1] == null) {
                                    this.mapa[aktualneY - 2 - i][aktualneX - 1] = this.mapa[aktualneY - 1 - i][aktualneX - 1];
                                    this.mapa[aktualneY - 1 - i][aktualneX - 1] = pomoc0;
                                    this.vykreslenieVojakov(aktualneX, aktualneY - i);
                                    this.vykreslenieVojakov(aktualneX, aktualneY - 1 - i);
                                } else {
                                    if (this.mapa[aktualneY - 1 - i][aktualneX - 1].getCode() > 0 && this.mapa[aktualneY - 2 - i][aktualneX - 1].getCode() < 0) {
                                        this.mapa[aktualneY - 1 - i][aktualneX - 1].setJeVBoji(true);
                                        y = aktualneY - i;
                                        i = abs(aktualneY - y);
                                    } else if (this.mapa[aktualneY - 1 - i][aktualneX - 1].getCode() < 0 && this.mapa[aktualneY - 2 - i][aktualneX - 1].getCode() > 0) {
                                        this.mapa[aktualneY - 1 - i][aktualneX - 1].setJeVBoji(true);
                                        y = aktualneY - i;
                                        i = abs(aktualneY - y);
                                    } else {
                                        pomoc1 = (Soldier)this.mapa[aktualneY - 2 - i][aktualneX - 1];
                                        this.mapa[aktualneY - 2 - i][aktualneX - 1] = this.mapa[aktualneY - 1 - i][aktualneX - 1];
                                        this.mapa[aktualneY - 1 - i][aktualneX - 1] = pomoc0;
                                        this.vykreslenieVojakov(aktualneX, aktualneY - i);
                                        this.vykreslenieVojakov(aktualneX, aktualneY - 1 - i);
                                    }
                                }
                            }
                            pomoc0 = null;
                        }
                    } else {
                        if (pomoc0 == null) {
                            if (aktualneY < y) {
                                if (this.mapa[aktualneY + i][aktualneX - 1] == null) {
                                    this.mapa[aktualneY + i][aktualneX - 1] = this.mapa[aktualneY - 1 + i][aktualneX - 1];
                                    this.mapa[aktualneY - 1 + i][aktualneX - 1] = pomoc1;
                                    this.vykreslenieVojakov(aktualneX, aktualneY + i);
                                    this.vykreslenieVojakov(aktualneX, aktualneY + 1 + i);

                                } else {
                                    if (this.mapa[aktualneY - 1 + i][aktualneX - 1].getCode() > 0 && this.mapa[aktualneY + i][aktualneX - 1].getCode() < 0) {
                                        this.mapa[aktualneY - 1 + i][aktualneX - 1].setJeVBoji(true);
                                        y = aktualneY + i;
                                        i = abs(aktualneY - y);
                                    } else if (this.mapa[aktualneY - 1 + i][aktualneX - 1].getCode() < 0 && this.mapa[aktualneY + i][aktualneX - 1].getCode() > 0) {
                                        this.mapa[aktualneY - 1 + i][aktualneX - 1].setJeVBoji(true);
                                        y = aktualneY + i;
                                        i = abs(aktualneY - y);
                                    } else {
                                        pomoc0 = (Soldier)this.mapa[aktualneY + i][aktualneX - 1];
                                        this.mapa[aktualneY + i][aktualneX - 1] = this.mapa[aktualneY - 1 + i][aktualneX - 1];
                                        this.mapa[aktualneY - 1 + i][aktualneX - 1] = pomoc1;
                                        this.vykreslenieVojakov(aktualneX, aktualneY + i);
                                        this.vykreslenieVojakov(aktualneX, aktualneY + 1 + i);
                                    }
                                }
                            } else {
                                if (this.mapa[aktualneY - 2 - i][aktualneX - 1] == null) {
                                    this.mapa[aktualneY - 2 - i][aktualneX - 1] = this.mapa[aktualneY - 1 - i][aktualneX - 1];
                                    this.mapa[aktualneY - 1 - i][aktualneX - 1] = pomoc1;
                                    this.vykreslenieVojakov(aktualneX, aktualneY - i);
                                    this.vykreslenieVojakov(aktualneX, aktualneY - 1 - i);

                                } else {
                                    if (this.mapa[aktualneY - 1 - i][aktualneX - 1].getCode() > 0 && this.mapa[aktualneY - 2 - i][aktualneX - 1].getCode() < 0) {
                                        this.mapa[aktualneY - 1 - i][aktualneX - 1].setJeVBoji(true);
                                        y = aktualneY - i;
                                        i = abs(aktualneY - y);
                                    } else if (this.mapa[aktualneY - 1 - i][aktualneX - 1].getCode() < 0 && this.mapa[aktualneY - 2 - i][aktualneX - 1].getCode() > 0) {
                                        this.mapa[aktualneY - 1 - i][aktualneX - 1].setJeVBoji(true);
                                        y = aktualneY - i;
                                        i = abs(aktualneY - y);
                                    } else {
                                        pomoc0 = (Soldier)this.mapa[aktualneY - 2 - i][aktualneX - 1];
                                        this.mapa[aktualneY - 2 - i][aktualneX - 1] = this.mapa[aktualneY - 1 - i][aktualneX - 1];
                                        this.mapa[aktualneY - 1 - i][aktualneX - 1] = pomoc1;
                                        this.vykreslenieVojakov(aktualneX, aktualneY - i);
                                        this.vykreslenieVojakov(aktualneX, aktualneY - 1 - i);
                                    }
                                }
                            }
                            pomoc1 = null;

                        } else {
                            if (aktualneY < y) {
                                if (this.mapa[aktualneY + i][aktualneX - 1] == null) {
                                    this.mapa[aktualneY + i][aktualneX - 1] = this.mapa[aktualneY - 1 + i][aktualneX - 1];
                                    this.mapa[aktualneY - 1 + i][aktualneX - 1] = pomoc1;
                                    this.vykreslenieVojakov(aktualneX, aktualneY + i);
                                    this.vykreslenieVojakov(aktualneX, aktualneY + 1 + i);
                                } else {
                                    if (this.mapa[aktualneY - 1 + i][aktualneX - 1].getCode() > 0 && this.mapa[aktualneY + i][aktualneX - 1].getCode() < 0) {
                                        this.mapa[aktualneY - 1 + i][aktualneX - 1].setJeVBoji(true);
                                        y = aktualneY + i;
                                        i = abs(aktualneY - y);
                                    } else if (this.mapa[aktualneY - 1 + i][aktualneX - 1].getCode() < 0 && this.mapa[aktualneY + i][aktualneX - 1].getCode() > 0) {
                                        this.mapa[aktualneY - 1 + i][aktualneX - 1].setJeVBoji(true);
                                        y = aktualneY + i;
                                        i = abs(aktualneY - y);
                                    } else {
                                        pomoc0 = (Soldier)this.mapa[aktualneY + i][aktualneX - 1];
                                        this.mapa[aktualneY + i][aktualneX - 1] = this.mapa[aktualneY - 1 + i][aktualneX - 1];
                                        this.mapa[aktualneY - 1 + i][aktualneX - 1] = pomoc1;
                                        this.vykreslenieVojakov(aktualneX, aktualneY + i);
                                        this.vykreslenieVojakov(aktualneX, aktualneY + 1 + i);
                                    }
                                }
                            } else {
                                if (this.mapa[aktualneY - 2 - i][aktualneX - 1] == null) {
                                    this.mapa[aktualneY - 2 - i][aktualneX - 1] = this.mapa[aktualneY - 1 - i][aktualneX - 1];
                                    this.mapa[aktualneY - 1 - i][aktualneX - 1] = pomoc1;
                                    this.vykreslenieVojakov(aktualneX, aktualneY - i);
                                    this.vykreslenieVojakov(aktualneX, aktualneY - 1 - i);
                                } else {
                                    if (this.mapa[aktualneY - 1 - i][aktualneX - 1].getCode() > 0 && this.mapa[aktualneY - 2 - i][aktualneX - 1].getCode() < 0) {
                                        this.mapa[aktualneY - 1 - i][aktualneX - 1].setJeVBoji(true);
                                        y = aktualneY - i;
                                        i = abs(aktualneY - y);
                                    } else if (this.mapa[aktualneY - 1 - i][aktualneX - 1].getCode() < 0 && this.mapa[aktualneY - 2 - i][aktualneX - 1].getCode() > 0) {
                                        this.mapa[aktualneY - 1 - i][aktualneX - 1].setJeVBoji(true);
                                        y = aktualneY - i;
                                        i = abs(aktualneY - y);
                                    } else {
                                        pomoc0 = (Soldier)this.mapa[aktualneY - 2 - i][aktualneX - 1];
                                        this.mapa[aktualneY - 2 - i][aktualneX - 1] = this.mapa[aktualneY - 1 - i][aktualneX - 1];
                                        this.mapa[aktualneY - 1 - i][aktualneX - 1] = pomoc1;
                                        this.vykreslenieVojakov(aktualneX, aktualneY - i);
                                        this.vykreslenieVojakov(aktualneX, aktualneY - 1 - i);
                                    }
                                }
                            }
                            pomoc1 = null;
                        }
                    }

                    if (i == (abs(aktualneY - y) - 1) && (pomoc0 != null || pomoc1 != null)) {
                        System.out.println("okej");
                        if (pomoc0 != null) {
                            this.pomoc = pomoc0;
                        } else {
                            this.pomoc = pomoc1;
                        }
                    }
                    //i++;
                }
            }
        } catch (NullPointerException npex) {

        }
        if (identifikator == 0) {
            int[] pole = new int[]{x, y};
            return pole;
        } else {
            JOptionPane.showMessageDialog(null, "Tvoja jednotka sa presunula na poziciu " + x + ", " + y);
            int[] pole = new int[]{x, y};
            return pole;
        }

    }

    /**
     * Metoda move kombinuje jeden alebo dva basicMove.
     *
     * @param aktualneX predstavuje aktualnu x-ovu suradnicu jednotky.
     * @param aktualneY predstavuje aktualnu y-ovu suradnicu jednotky.
     * @param x predstavuje x-ovu suradnicu, kam sa ma jednotka dostat.
     * @param y predstavuje y-ovu suradnicu, kam sa ma jednotka dostat.
     * @param smer urcuje ci ma ist jednotka severnou alebo juznou cestou.
     */
    public void move(int aktualneX, int aktualneY, int x, int y, int smer) {

        try {
            if ((y == aktualneY) || (x == aktualneX)) {
                int[] pole = this.kontrolaMiesta(aktualneX, aktualneY, x, y, 0);
                x = pole[0];
                y = pole[1];

                int[] pole1 = this.basicMove(aktualneX, aktualneY, x, y, 1);
                this.mapa[pole1[1] - 1][pole1[0] - 1].setPolohaX(pole1[0] - 1);
                this.mapa[pole1[1] - 1][pole1[0] - 1].setPolohaY(pole1[1] - 1);

                int i = 0;
                if (this.mapa[pole1[1] - 1][pole1[0] - 1].isUzBojoval()) {
                    int nic = 0;
                } else {
                    if ((abs(aktualneX - 1 - (pole1[0] - 1)) > 2)) {
                        i = this.mapa[pole1[1] - 1][pole1[0] - 1].boj(pole1[0], pole1[1], this, true);
                    } else {
                        i = this.mapa[pole1[1] - 1][pole1[0] - 1].boj(pole1[0], pole1[1], this, false);
                    }
                }
                if (i == 1) {
                    this.mapa[pole1[1] - 1][pole1[0] - 1].setJeVBoji(true);
                    this.mapa[pole1[1] - 1][pole1[0] - 1].setUzBojoval(true);
                    if (this.mapa[pole1[1] - 1][pole1[0]] != null) {
                        this.mapa[pole1[1] - 1][pole1[0]].setUzBojoval(true);
                    }
                    if (this.mapa[pole1[1] - 1][pole1[0] - 2] != null) {
                        this.mapa[pole1[1] - 1][pole1[0] - 2].setUzBojoval(true);
                    }
                }

            } else {
                int[] pole2 = new int[2];
                if (smer == 1) {

                    int[] pole = this.kontrolaMiesta(aktualneX, aktualneY, x, y, 1);
                    x = pole[0];
                    y = pole[1];

                    if (y > aktualneY) {
                        System.out.println("1");

                        pole2 = this.basicMove(aktualneX, aktualneY, x, aktualneY, 0);
                        if (this.mapa[pole2[1] - 1][pole2[0] - 1].isJeVBoji()) {
                            System.out.println("koniec");
                        } else {
                            System.out.println("2");
                            int[] pole3 = this.basicMove(x, aktualneY, x, y, 1);
                            pole2[0] = pole3[0];
                            pole2[1] = pole3[1];
                        }

                    } else {
                        System.out.println("1");
                        pole2 = this.basicMove(aktualneX, aktualneY, aktualneX, y, 0);
                        if (this.mapa[pole2[1] - 1][pole2[0] - 1].isJeVBoji()) {
                            System.out.println("koniec");
                        } else {
                            System.out.println("2");
                            int[] pole3 = this.basicMove(aktualneX, y, x, y, 1);
                            pole2[0] = pole3[0];
                            pole2[1] = pole3[1];
                        }
                    }
                    //JOptionPane.showMessageDialog(null, "Tvoja jednotka sa presunula SEVERNOU cestou " + x + ", " + y);

                } else {
                    int[] pole = this.kontrolaMiesta(aktualneX, aktualneY, x, y, 2);
                    x = pole[0];
                    y = pole[1];

                    if (y > aktualneY) {
                        System.out.println("1");
                        pole2 = this.basicMove(aktualneX, aktualneY, aktualneX, y, 0);
                        if (this.mapa[pole2[1] - 1][pole2[0] - 1].isJeVBoji()) {
                            System.out.println("koniec");
                        } else {
                            System.out.println("2");
                            int[] pole3 = this.basicMove(aktualneX, y, x, y, 1);
                            pole2[0] = pole3[0];
                            pole2[1] = pole3[1];
                        }
                    } else {
                        System.out.println("1");
                        pole2 = this.basicMove(aktualneX, aktualneY, x, aktualneY, 0);
                        if (this.mapa[pole2[1] - 1][pole2[0] - 1].isJeVBoji()) {
                            System.out.println("koniec");
                        } else {
                            System.out.println("2");
                            int[] pole3 = this.basicMove(x, aktualneY, x, y, 1);
                            pole2[0] = pole3[0];
                            pole2[1] = pole3[1];
                        }
                    }
                    //JOptionPane.showMessageDialog(null, "Tvoja jednotka sa presunula JUZNOU cestou " + x + ", " + y);
                }
                this.mapa[pole2[1] - 1][pole2[0] - 1].setPolohaX(pole2[0] - 1);
                this.mapa[pole2[1] - 1][pole2[0] - 1].setPolohaY(pole2[1] - 1);
                int i = 0;
                if (this.mapa[pole2[1] - 1][pole2[0] - 1].isUzBojoval()) {
                    int nic = 0;
                } else {
                    i = this.mapa[pole2[1] - 1][pole2[0] - 1].boj(pole2[0], pole2[1], this, false);
                }
                if (i == 1) {
                    this.mapa[pole2[1] - 1][pole2[0] - 1].setJeVBoji(true);
                    this.mapa[pole2[1] - 1][pole2[0] - 1].setUzBojoval(true);
                    if (this.mapa[pole2[1] - 1][pole2[0]] != null) {
                        this.mapa[pole2[1] - 1][pole2[0]].setUzBojoval(true);
                    }
                    if (this.mapa[pole2[1] - 1][pole2[0] - 2] != null) {
                        this.mapa[pole2[1] - 1][pole2[0] - 2].setUzBojoval(true);
                    }
                }

                /**
                 * this.mapa[y - 1][x - 1] = this.mapa[aktualneY - 1][aktualneX
                 * - 1]; this.mapa[aktualneY - 1][aktualneX - 1] = null;
                 * this.vykreslenieVojakov(strana);
                 *
                 * Obdlznik obdlznik = new Obdlznik();
                 * obdlznik.zmenStrany(strana, strana);
                 * obdlznik.zmenPolohu((aktualneX) * (strana + 1), (aktualneY) *
                 * (strana + 1)); obdlznik.zmenFarbu("green");
                 * obdlznik.zobraz();
                 */
            }
        } catch (NullPointerException npex) {

        }
    }

    /**
     * Metoda vykreslenieVojakov vykresli na zadane miesto znak konkretnej
     * jednotky.
     *
     * @param x predstavuje x-ovu suradnicu jednotky.
     * @param y predstavuje y-ovu suradnicu jednotky.
     */
    public void vykreslenieVojakov(int x, int y) {
        //for (int i = 0; i < this.pocetPolicokY; i++) {
        //for (int j = 0; j < this.pocetPolicokX; j++) {
        try {
            switch (abs(this.mapa[y - 1][x - 1].getCode())) {
                case 1:
                    Obdlznik obdlznik0 = new Obdlznik();
                    obdlznik0.zmenStrany(this.strana, this.strana);
                    obdlznik0.zmenPolohu((x + 1) * (this.strana + 1), (y + 1) * (this.strana + 1));
                    if (this.mapa[y - 1][x - 1].getCode() > 0) {
                        obdlznik0.zmenFarbu("red");
                    } else {
                        obdlznik0.zmenFarbu("blue");
                    }
                    obdlznik0.zobraz();
                    break;
                case 2:
                    Obdlznik obdlznik1 = new Obdlznik();
                    obdlznik1.zmenStrany(this.strana, this.strana);
                    obdlznik1.zmenPolohu((x + 1) * (this.strana + 1), (y + 1) * (this.strana + 1));
                    if (this.mapa[y - 1][x - 1].getCode() > 0) {
                        obdlznik1.zmenFarbu("red");
                    } else {
                        obdlznik1.zmenFarbu("blue");
                    }
                    obdlznik1.zobraz();

                    Obdlznik obdlznik11 = new Obdlznik();
                    obdlznik11.zmenStrany(this.strana - (this.strana / 5), this.strana / 5);
                    obdlznik11.zmenPolohu(((x + 1) * (this.strana + 1)) + (this.strana / 10), ((y + 1) * (this.strana + 1)) + (this.strana - this.strana / 5) / 2);
                    obdlznik11.zmenFarbu("black");
                    obdlznik11.zobraz();
                    break;
                case 3:
                    Obdlznik obdlznik2 = new Obdlznik();
                    obdlznik2.zmenStrany(this.strana, this.strana);
                    obdlznik2.zmenPolohu((x + 1) * (this.strana + 1), (y + 1) * (this.strana + 1));
                    if (this.mapa[y - 1][x - 1].getCode() > 0) {
                        obdlznik2.zmenFarbu("red");
                    } else {
                        obdlznik2.zmenFarbu("blue");
                    }
                    obdlznik2.zobraz();

                    Obdlznik obdlznik12 = new Obdlznik();
                    obdlznik12.zmenStrany(this.strana - (this.strana / 5), this.strana - (this.strana / 5));
                    obdlznik12.zmenPolohu(((x + 1) * (this.strana + 1)) + (this.strana / 10), ((y + 1) * (this.strana + 1)) + (this.strana / 10));
                    obdlznik12.zmenFarbu("black");
                    obdlznik12.zobraz();
                    break;
                case 4:
                    Obdlznik obdlznik3 = new Obdlznik();
                    obdlznik3.zmenStrany(this.strana, this.strana);
                    obdlznik3.zmenPolohu((x + 1) * (this.strana + 1), (y + 1) * (this.strana + 1));
                    if (this.mapa[y - 1][x - 1].getCode() > 0) {
                        obdlznik3.zmenFarbu("red");
                    } else {
                        obdlznik3.zmenFarbu("blue");
                    }
                    obdlznik3.zobraz();

                    Obdlznik obdlznik13 = new Obdlznik();
                    obdlznik13.zmenStrany(this.strana - (this.strana / 5), this.strana - (this.strana / 5));
                    obdlznik13.zmenPolohu(((x + 1) * (this.strana + 1)) + (this.strana / 10), ((y + 1) * (this.strana + 1)) + (this.strana / 10));
                    obdlznik13.zmenFarbu("black");
                    obdlznik13.zobraz();

                    Obdlznik obdlznik23 = new Obdlznik();
                    obdlznik23.zmenStrany(this.strana - (this.strana / 2), this.strana - (this.strana / 2));
                    obdlznik23.zmenPolohu(((x + 1) * (this.strana + 1)) + (this.strana / 4), ((y + 1) * (this.strana + 1)) + (this.strana / 4));
                    if (this.mapa[y - 1][x - 1].getCode() > 0) {
                        obdlznik23.zmenFarbu("red");
                    } else {
                        obdlznik23.zmenFarbu("blue");
                    }
                    obdlznik23.zobraz();
                    break;
                default:
                    break;

            }
        } catch (NullPointerException npex) {

        }
        //}
        //}
    }

    /**
     * Metoda automatickePozicieVojska pouklada jednotky na predvolene policka.
     *
     * @param poctyJednotiek predstavuje predvolene pocty jednotlivych
     * jednotiek.
     * @param udaje predstavuje predvolene suradnice jednotiek.
     * @param code urcuje o ktoreho hraca ide.
     */
    public void automatickePozicieVojska(int[] poctyJednotiek, int[] udaje, int code) {

        for (int i = 0; i < poctyJednotiek[0]; i++) {
            FootSoldier fs = new FootSoldier(udaje[i * 2] - 1, udaje[i * 2 + 1] - 1, code);
            this.setMapa(udaje[i * 2] - 1, udaje[i * 2 + 1] - 1, fs);
            this.vykreslenieVojakov(udaje[i * 2], udaje[i * 2 + 1]);
        }

        for (int i = poctyJednotiek[0]; i < poctyJednotiek[0] + poctyJednotiek[1]; i++) {
            Archer ar = new Archer(udaje[i * 2] - 1, udaje[i * 2 + 1] - 1, code);
            this.setMapa(udaje[i * 2] - 1, udaje[i * 2 + 1] - 1, ar);
            this.vykreslenieVojakov(udaje[i * 2], udaje[i * 2 + 1]);
        }

        for (int i = poctyJednotiek[0] + poctyJednotiek[1]; i < poctyJednotiek[0] + poctyJednotiek[1] + poctyJednotiek[2]; i++) {
            Knight kn = new Knight(udaje[i * 2] - 1, udaje[i * 2 + 1] - 1, code);
            this.setMapa(udaje[i * 2] - 1, udaje[i * 2 + 1] - 1, kn);
            this.vykreslenieVojakov(udaje[i * 2], udaje[i * 2 + 1]);
        }

        King ki = new King(udaje[(poctyJednotiek[0] + poctyJednotiek[1] + poctyJednotiek[2]) * 2] - 1, udaje[(poctyJednotiek[0] + poctyJednotiek[1] + poctyJednotiek[2]) * 2 + 1], code);
        this.setMapa(udaje[(poctyJednotiek[0] + poctyJednotiek[1] + poctyJednotiek[2]) * 2] - 1, udaje[(poctyJednotiek[0] + poctyJednotiek[1] + poctyJednotiek[2]) * 2 + 1] - 1, ki);
        this.vykreslenieVojakov(udaje[(poctyJednotiek[0] + poctyJednotiek[1] + poctyJednotiek[2]) * 2], udaje[(poctyJednotiek[0] + poctyJednotiek[1] + poctyJednotiek[2]) * 2 + 1]);

    }

    /**
     * Metoda pozicieVojska pouklada jednotky na zadane policka.
     *
     * @param poctyJednotiek predstavuje pocty jednotlivych jednotiek.
     * @param code urcuje o ktoreho hraca ide.
     */
    public void pozicieVojska(int[] poctyJednotiek, int code) {
        boolean b = true;
        boolean c = true;
        for (int i = 0; i < poctyJednotiek[0]; i++) {
            int poziciaX = 0;
            int poziciaY = 0;
            c = true;
            while (c) {
                b = true;
                while (b) {
                    poziciaX = Integer.parseInt(JOptionPane.showInputDialog(null, "Zadaj suradnicu X PESIAKA"));
                    if (code == 1) {
                        if (poziciaX > 8 || poziciaX < 1) {
                            JOptionPane.showMessageDialog(null, "ZADAL SI ZLE CISLO!", "Alert", JOptionPane.WARNING_MESSAGE);
                            b = true;
                        } else {
                            b = false;
                        }
                    } else {
                        if (poziciaX > 30 || poziciaX < 23) {
                            JOptionPane.showMessageDialog(null, "ZADAL SI ZLE CISLO!", "Alert", JOptionPane.WARNING_MESSAGE);
                            b = true;
                        } else {
                            b = false;
                        }
                    }

                }

                b = true;
                while (b) {
                    poziciaY = Integer.parseInt(JOptionPane.showInputDialog(null, "Zadaj suradnicu Y PESIAKA"));
                    if (poziciaY > 5 || poziciaY < 1) {
                        JOptionPane.showMessageDialog(null, "ZADAL SI ZLE CISLO!", "Alert", JOptionPane.WARNING_MESSAGE);
                        b = true;
                    } else {
                        b = false;
                    }
                }

                Nastavovanie nastavovanie = new Nastavovanie(20);
                if (this.getMapa(poziciaX - 1, poziciaY - 1) != null) {
                    JOptionPane.showMessageDialog(null, "NA TOMTO MIESTE SA UZ NACHADZA JEDNOTKA " + nastavovanie.rozoznaj(poziciaX, poziciaY, this), "Alert", JOptionPane.WARNING_MESSAGE);
                    c = true;
                } else {
                    c = false;
                }
            }
            System.out.print(poziciaX + ", " + poziciaY + ", ");
            FootSoldier fs = new FootSoldier(poziciaX, poziciaY, code);
            this.setMapa(poziciaX - 1, poziciaY - 1, fs);
            this.vykreslenieVojakov(poziciaX, poziciaY);

        }

        for (int i = 0; i < poctyJednotiek[1]; i++) {
            int poziciaX = 0;
            int poziciaY = 0;
            c = true;
            while (c) {
                b = true;
                while (b) {
                    poziciaX = Integer.parseInt(JOptionPane.showInputDialog(null, "Zadaj suradnicu X LUKOSTRELCA"));
                    if (code == 1) {
                        if (poziciaX > 8 || poziciaX < 1) {
                            JOptionPane.showMessageDialog(null, "ZADAL SI ZLE CISLO!", "Alert", JOptionPane.WARNING_MESSAGE);
                            b = true;
                        } else {
                            b = false;
                        }
                    } else {
                        if (poziciaX > 30 || poziciaX < 23) {
                            JOptionPane.showMessageDialog(null, "ZADAL SI ZLE CISLO!", "Alert", JOptionPane.WARNING_MESSAGE);
                            b = true;
                        } else {
                            b = false;
                        }
                    }
                }

                b = true;
                while (b) {
                    poziciaY = Integer.parseInt(JOptionPane.showInputDialog(null, "Zadaj suradnicu Y LUKOSTRELCA"));
                    if (poziciaY > 5 || poziciaY < 1) {
                        JOptionPane.showMessageDialog(null, "ZADAL SI ZLE CISLO!", "Alert", JOptionPane.WARNING_MESSAGE);
                        b = true;
                    } else {
                        b = false;
                    }
                }

                Nastavovanie nastavovanie = new Nastavovanie(20);
                if (this.getMapa(poziciaX - 1, poziciaY - 1) != null) {
                    JOptionPane.showMessageDialog(null, "NA TOMTO MIESTE SA UZ NACHADZA JEDNOTKA " + nastavovanie.rozoznaj(poziciaX, poziciaY, this), "Alert", JOptionPane.WARNING_MESSAGE);
                    c = true;
                } else {
                    c = false;
                }
            }
            System.out.print(poziciaX + ", " + poziciaY + ", ");
            Archer ar = new Archer(poziciaX, poziciaY, code);
            this.setMapa(poziciaX - 1, poziciaY - 1, ar);
            this.vykreslenieVojakov(poziciaX, poziciaY);
        }

        for (int i = 0; i < poctyJednotiek[2]; i++) {
            int poziciaX = 0;
            int poziciaY = 0;
            c = true;
            while (c) {
                b = true;
                while (b) {
                    poziciaX = Integer.parseInt(JOptionPane.showInputDialog(null, "Zadaj suradnicu X RYTIERA"));
                    if (code == 1) {
                        if (poziciaX > 8 || poziciaX < 1) {
                            JOptionPane.showMessageDialog(null, "ZADAL SI ZLE CISLO!", "Alert", JOptionPane.WARNING_MESSAGE);
                            b = true;
                        } else {
                            b = false;
                        }
                    } else {
                        if (poziciaX > 30 || poziciaX < 23) {
                            JOptionPane.showMessageDialog(null, "ZADAL SI ZLE CISLO!", "Alert", JOptionPane.WARNING_MESSAGE);
                            b = true;
                        } else {
                            b = false;
                        }
                    }
                }

                b = true;
                while (b) {
                    poziciaY = Integer.parseInt(JOptionPane.showInputDialog(null, "Zadaj suradnicu Y RYTIERA"));
                    if (poziciaY > 5 || poziciaY < 1) {
                        JOptionPane.showMessageDialog(null, "ZADAL SI ZLE CISLO!", "Alert", JOptionPane.WARNING_MESSAGE);
                        b = true;
                    } else {
                        b = false;
                    }
                }

                Nastavovanie nastavovanie = new Nastavovanie(20);
                if (this.getMapa(poziciaX - 1, poziciaY - 1) != null) {
                    JOptionPane.showMessageDialog(null, "NA TOMTO MIESTE SA UZ NACHADZA JEDNOTKA " + nastavovanie.rozoznaj(poziciaX, poziciaY, this), "Alert", JOptionPane.WARNING_MESSAGE);
                    c = true;
                } else {
                    c = false;
                }
            }
            System.out.print(poziciaX + ", " + poziciaY + ", ");
            Knight kn = new Knight(poziciaX, poziciaY, code);
            this.setMapa(poziciaX - 1, poziciaY - 1, kn);
            this.vykreslenieVojakov(poziciaX, poziciaY);
        }

        int poziciaX = 0;
        int poziciaY = 0;
        c = true;
        while (c) {
            b = true;
            while (b) {
                poziciaX = Integer.parseInt(JOptionPane.showInputDialog(null, "Zadaj suradnicu X KRALA"));
                if (code == 1) {
                    if (poziciaX > 8 || poziciaX < 1) {
                        JOptionPane.showMessageDialog(null, "ZADAL SI ZLE CISLO!", "Alert", JOptionPane.WARNING_MESSAGE);
                        b = true;
                    } else {
                        b = false;
                    }
                } else {
                    if (poziciaX > 30 || poziciaX < 23) {
                        JOptionPane.showMessageDialog(null, "ZADAL SI ZLE CISLO!", "Alert", JOptionPane.WARNING_MESSAGE);
                        b = true;
                    } else {
                        b = false;
                    }
                }
            }

            b = true;
            while (b) {
                poziciaY = Integer.parseInt(JOptionPane.showInputDialog(null, "Zadaj suradnicu Y KRALA"));
                if (poziciaY > 5 || poziciaY < 1) {
                    JOptionPane.showMessageDialog(null, "ZADAL SI ZLE CISLO!", "Alert", JOptionPane.WARNING_MESSAGE);
                    b = true;
                } else {
                    b = false;
                }
            }

            Nastavovanie nastavovanie = new Nastavovanie(20);
            if (this.getMapa(poziciaX - 1, poziciaY - 1) != null) {
                JOptionPane.showMessageDialog(null, "NA TOMTO MIESTE SA UZ NACHADZA JEDNOTKA " + nastavovanie.rozoznaj(poziciaX, poziciaY, this), "Alert", JOptionPane.WARNING_MESSAGE);
                c = true;
            } else {
                c = false;
            }
        }
        System.out.print(poziciaX + ", " + poziciaY + ", ");
        King ki = new King(poziciaX, poziciaY, code);
        this.setMapa(poziciaX - 1, poziciaY - 1, ki);
        this.vykreslenieVojakov(poziciaX, poziciaY);

    }
}
