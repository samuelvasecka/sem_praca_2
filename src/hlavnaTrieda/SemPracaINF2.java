/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hlavnaTrieda;

import karty.Card;
import karty.CardsKatalog;
import prostredieHerne.Mapa;
import prostredieHerne.Obdlznik;
import hrac.Hrac;
import hrac.NacitanieHracov;
import hrac.Top3Skore;
import hrac.TopSkore;
import nastavenia.Nastavovanie;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Main kombinuje vsetky triedy.
 *
 *
 * @author Samuel Vasecka
 * @version 2019.05.14
 */
public class SemPracaINF2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {

        Mapa mapa = new Mapa(30, 5);

        mapa.vykresleniePlochy();
        int[] udaje2 = new int[]{8, 1, 8, 2, 8, 4, 8, 5, 7, 1, 7, 3, 7, 5, 7, 2, 7, 4, 6, 3};
        int[] udaje3 = new int[]{23, 1, 23, 2, 23, 4, 23, 5, 24, 1, 24, 3, 24, 5, 24, 2, 24, 4, 25, 3};
        int[] udaje4 = null;
        int[] udaje5 = null;
        if (JOptionPane.showConfirmDialog(null, "Chces kratku verziu na odprezentovanie", "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
            udaje4 = new int[]{1, 1, 0};
            udaje5 = new int[]{0, 0, 1};
        } else {
            udaje4 = new int[]{4, 3, 2};
            udaje5 = new int[]{4, 3, 2};
        }

        /**
         * try { Thread.sleep(3000); } catch (InterruptedException ex) {
         * Thread.currentThread().interrupt(); }
         */
        try {
            Nastavovanie nastavovanie = new Nastavovanie(0);
            nastavovanie.uvod();
            NacitanieHracov nH = new NacitanieHracov();

            Hrac hrac1 = nH.nastavenie(1);

            Hrac hrac2 = null;

            boolean d = true;
            while (d) {
                try {
                    hrac2 = nH.nastavenie(2);
                    if (hrac1.getNickName().equals(hrac2.getNickName())) {
                        throw new MySpecialException();
                    } else {
                        d = false;
                    }
                } catch (MySpecialException msex) {
                    d = true;
                    JOptionPane.showMessageDialog(null, msex);
                }
            }
            mapa.vyznaceneMiesto(1);

            if (JOptionPane.showConfirmDialog(null, "Chces automaticky vygenerovanu armadu?", hrac1.getNickName(), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                mapa.automatickePozicieVojska(udaje4, udaje2, 1);
            } else {
                int[] udaje = nastavovanie.nastavenieArmady(hrac1.getNickName());
                mapa.pozicieVojska(udaje, 1);
            }

            mapa.prekresleniePlochy(0, 8);
            Obdlznik o1 = mapa.kryciaPlocha(1);

            mapa.vyznaceneMiesto(-1);
            if (JOptionPane.showConfirmDialog(null, "Chces automaticky vygenerovanu armadu?", hrac2.getNickName(), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                mapa.automatickePozicieVojska(udaje5, udaje3, -1);
            } else {
                int[] udaje1 = nastavovanie.nastavenieArmady(hrac2.getNickName());
                mapa.pozicieVojska(udaje1, -1);
            }

            o1.skry();
            mapa.prekresleniePlochy(22, 30);

            boolean a = true;
            double[] pole = mapa.stavPoTahu(hrac1.getNickName(), hrac2.getNickName());
            double pocet1 = pole[1];
            double pocet2 = pole[2];
            System.out.println(pocet1 + " " + pocet2);
            int pomoc = 0;
            int pomoc1 = 0;
            CardsKatalog<Card> katalog = new CardsKatalog<>();
            katalog.vlozVsetky();

            TopSkore skore = new TopSkore();
            Top3Skore skore1 = new Top3Skore();

            while (a) {
                ArrayList<String> list = nastavovanie.nastavovac(mapa, 1, hrac1.getNickName(), hrac2.getNickName());
                nastavovanie.skrytieZltej(list, mapa);

                ArrayList<String> list1 = nastavovanie.nastavovac(mapa, -1, hrac2.getNickName(), hrac1.getNickName());
                nastavovanie.skrytieZltej(list1, mapa);

                nastavovanie.striedavyNastavovac(list, list1, mapa, nastavovanie, hrac1.getNickName(), hrac2.getNickName());
                System.out.println("stal sa prebiehaBoj");
                mapa.prebiehaBoj();
                mapa.utek(hrac1.getNickName(), hrac2.getNickName());
                pole = mapa.stavPoTahu(hrac1.getNickName(), hrac2.getNickName());

                if (pole[0] == 0) {
                    a = true;
                } else {
                    if (pole[2] <= 0) {
                        JOptionPane.showMessageDialog(null, "Vyhral hrac: " + hrac1.getNickName());
                        
                        System.out.println(pocet1);
                        System.out.println(pole[1]);
                        skore1.vyberZoSuboru1((int)(pole[1] / pocet1 * 100), hrac1);
                        skore.vyberZoSuboru1((int)(pole[1] / pocet1 * 100), hrac1);
                        a = false;
                    } else if (pole[1] <= 0) {
                        JOptionPane.showMessageDialog(null, "Vyhral hrac: " + hrac2.getNickName());
                        
                        System.out.println(pocet2);
                        System.out.println(pole[2]);
                        skore1.vyberZoSuboru1((int)(pole[2] / pocet1 * 100), hrac2);
                        skore.vyberZoSuboru1((int)(pole[2] / pocet1 * 100), hrac2);
                        a = false;
                    }
                    a = false;
                }

                if (pole[1] <= pocet1 / 2 && pomoc == 0) {
                    int cislo = katalog.nahodneCislo();

                    if (JOptionPane.showConfirmDialog(null, "Ziskal si bonus... \nMoze byt vsak pozitivny ale aj negativny! \nChces ho pouzit?", hrac2.getNickName(), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {

                        Card ca = (Card)katalog.vyber(cislo);
                        JOptionPane.showMessageDialog(null, ca.dajPopis());
                        int[] pole1 = ca.akcia(30, 5, mapa, 0);
                        mapa.prekresleniePlochy(pole1[0], pole1[1]);
                        pomoc = 1;
                    }
                }
                if (pole[2] <= pocet2 / 2 && pomoc1 == 0) {
                    int cislo = katalog.nahodneCislo();

                    if (JOptionPane.showConfirmDialog(null, "Ziskal si bonus... \nMoze byt vsak pozitivny ale aj negativny! \nChces ho pouzit?", hrac1.getNickName(), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {

                        Card ca = (Card)katalog.vyber(cislo);
                        JOptionPane.showMessageDialog(null, ca.dajPopis());
                        int[] pole1 = ca.akcia(30, 5, mapa, 1);
                        mapa.prekresleniePlochy(pole1[0], pole1[1]);
                        pomoc1 = 1;
                    }
                }
                nastavovanie.akciaKoniec();
            }

            nastavovanie.akciaKoniec();
        } catch (Exception ex) {
            System.out.println(ex);
            System.exit(0);
        }

        //System.exit(0);
    }

}
