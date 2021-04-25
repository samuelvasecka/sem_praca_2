/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nastavenia;

import prostredieHerne.Mapa;
import prostredieHerne.Obdlznik;
import vojaci.Archer;
import vojaci.FootSoldier;
import vojaci.King;
import vojaci.Knight;
import java.awt.Dimension;
import java.awt.Toolkit;
import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 * Trieda pomocou inputu, zaznamenava poziadavky od hraca,
 * a nasledne ich podla pravidiel hry kontroluje a vykonava.
 * 
 * @author Samuel Vasecka
 * @version 2019.05.14
 */
public class Nastavovanie {

    private int pocetBodov;
    private int strana;

    /**
     * Konstruktor vytvori podmienky na vkladanie jednotiek na mapu.
     * @param pocetBodov1 urcuje kolko bodov bude mat hrac na utratenie za vojenske jednotky.
     */
    public Nastavovanie(int pocetBodov1) {
        this.pocetBodov = pocetBodov1;
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension d = t.getScreenSize();

        this.strana = d.width / 33 - 1;

    }

    /**
     * Metoda uvo na zaciatok hry otvori uvodne okno.
     */
    public void uvod() {
        JOptionPane.showMessageDialog(null, "---HISTORIC WAR SIMULATOR--- \n   Press OK to continue");
    }

    /**
     * Metoda akciaKoniec po potvrdeni vypne a zatvori celu hru.
     */
    public void akciaKoniec() {
        if (JOptionPane.showConfirmDialog(null, "Chces skutocne skoncit hru", "Ukoncenie", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    /**
     * Metoda rozoznaj po vlozeni konkretnej jednotky zisti o aky typ ide a vrati
     * v retazci jeho nazov.
     * @param x urcuje x-ovu poziciu na mape.
     * @param y urcuje y-ovu poziciu na mape.
     * @param mapa urcuje kde sa bude dana metoda vykonavat.
     * @return string (Nazov jednotky).
     */
    public String rozoznaj(int x, int y, Mapa mapa) {
        String string = "";
        if (mapa.getMapa(x - 1, y - 1) instanceof FootSoldier) {
            string += "PESIAK";
        }
        if (mapa.getMapa(x - 1, y - 1) instanceof Archer) {
            string += "LUKOSTRELEC";
        }
        if (mapa.getMapa(x - 1, y - 1) instanceof Knight) {
            string += "RYTIER";
        }
        if (mapa.getMapa(x - 1, y - 1) instanceof King) {
            string += "KRAL";
        }
        return string;
    }

    /**
     * Metoda striedavyNastavovac nahodne vyberie hraca, ktory bude v danom tahu zacinat 
     * a nasledne na striedacku vykonava hracami nastavene akcie.
     * @param list obsahuje akcie prveho hraca.
     * @param list1 obsahuje akcie druheho hraca.
     * @param mapa urcuje kde sa bude metoda vykonavat.
     * @param nastavovanie pomaha spustaniu akcii daneho hraca.
     * @param hrac1 predstavuje meno prveho hraca.
     * @param hrac2 predstavuje meno druheho hraca.
     * 
     */
    public void striedavyNastavovac(ArrayList<String> list, ArrayList<String> list1, Mapa mapa, Nastavovanie nastavovanie, String hrac1, String hrac2) {
        int pocitadlo = Integer.parseInt(list.get(0)) / 6;
        int pocitadlo1 = Integer.parseInt(list1.get(0)) / 6;

        Random random = new Random();
        int rand = random.nextInt(2);

        for (int i = 1; i <= ((Integer.parseInt(list.get(0)) / 6) + (Integer.parseInt(list1.get(0)) / 6)); i++) {

            if (pocitadlo > pocitadlo1) {
                if (i <= pocitadlo1 * 2) {
                    if (i % 2 == 1) {
                        if (rand == 0) {
                            nastavovanie.spustacAkcii(list, mapa, (i + 1) / 2, hrac1);
                        } else {
                            nastavovanie.spustacAkcii(list1, mapa, (i + 1) / 2, hrac2);
                        }

                    } else {
                        if (rand == 0) {
                            nastavovanie.spustacAkcii(list1, mapa, i / 2, hrac2);
                        } else {
                            nastavovanie.spustacAkcii(list, mapa, i / 2, hrac1);
                        }
                    }
                } else {
                    nastavovanie.spustacAkcii(list, mapa, i - pocitadlo1, hrac1);
                }
            }
            if (pocitadlo == pocitadlo1) {
                if (i % 2 == 1) {
                    if (rand == 0) {
                        nastavovanie.spustacAkcii(list, mapa, (i + 1) / 2, hrac1);
                    } else {
                        nastavovanie.spustacAkcii(list1, mapa, (i + 1) / 2, hrac2);
                    }
                } else {
                    if (rand == 0) {
                        nastavovanie.spustacAkcii(list1, mapa, i / 2, hrac2);
                    } else {
                        nastavovanie.spustacAkcii(list, mapa, i / 2, hrac1);
                    }
                }
            }
            if (pocitadlo < pocitadlo1) {
                if (i <= pocitadlo * 2) {
                    if (i % 2 == 1) {
                        if (rand == 0) {
                            nastavovanie.spustacAkcii(list, mapa, (i + 1) / 2, hrac1);
                        } else {
                            nastavovanie.spustacAkcii(list1, mapa, (i + 1) / 2, hrac2);
                        }
                    } else {
                        if (rand == 0) {
                            nastavovanie.spustacAkcii(list1, mapa, i / 2, hrac2);
                        } else {
                            nastavovanie.spustacAkcii(list, mapa, i / 2, hrac1);
                        }
                    }
                } else {
                    nastavovanie.spustacAkcii(list1, mapa, i - pocitadlo, hrac2);
                }
            }
        }
    }

    /**
     * Metoda skrytieZltej skryje na platne obdlznicky zltej farby tak,
     * ze ich prekresli zelenym obdlznikom.
     * @param list predstavuje akcie hraca, a teda aj miesta kde sa zlty obdlznik nachadza.
     * @param mapa predstavuje kde sa metoda bude vykonavat.
     */
    public void skrytieZltej(ArrayList<String> list, Mapa mapa) {
        for (int i = 1; i <= (Integer.parseInt(list.get(0))) / 6; i++) {
            switch (Integer.parseInt(list.get((i * 6) - 3))) {
                case 1:
                    int x = Integer.parseInt(list.get((i * 6) - 2));
                    int y = Integer.parseInt(list.get((i * 6) - 1));
                    if (mapa.getMapa(x - 1, y - 1) == null) {
                        Obdlznik obdlznik = new Obdlznik();
                        obdlznik.zmenStrany(this.strana, this.strana);
                        obdlznik.zmenPolohu((x + 1) * (this.strana + 1), (y + 1) * (this.strana + 1));
                        obdlznik.zmenFarbu("green");
                        obdlznik.zobraz();
                    }

                    break;
                default:
                    break;
            }
        }
    }

    /**
     * Metoda nastavovac zapisuje do ArrayListov akcie hraca.
     * @param mapa predstavuje kde sa bude metoda vykonavat.
     * @param code urcuje o ktoreho hraca ide.
     * @param hrac1 predstavuje meno prveho hraca.
     * @param hrac2 predstavuje meno druheho hraca.
     * @return list (ArrayList so zapisanymi akciami hraca).
     */
    public ArrayList<String> nastavovac(Mapa mapa, int code, String hrac1, String hrac2) {
        boolean a = true;
        boolean b = true;
        boolean c = true;
        int pocitadlo = 0;
        int aktualneX = 0;
        int aktualneY = 0;

        ArrayList<String> zoznam;
        zoznam = new ArrayList<String>();
        ArrayList<String> list;
        list = new ArrayList<String>();
        String akcie = "";
        String string1 = "";
        int pomocNaPozeranie = 0;
        int pomoc = 0;

        while (a) {
            c = true;
            while (c) {
                b = true;
                while (b) {
                    try {
                        aktualneX = Integer.parseInt(JOptionPane.showInputDialog(null, hrac1 + "\nZadaj suradnicu X jednotky s ktorou chces vykonat akciu"));
                        if (aktualneX > 30 || aktualneX < 1) {
                            JOptionPane.showMessageDialog(null, "ZADAL SI ZLE CISLO!", hrac1, JOptionPane.WARNING_MESSAGE);
                            b = true;
                        } else {
                            b = false;
                        }
                    } catch (NumberFormatException nfex) {
                        JOptionPane.showMessageDialog(null, "ZADAL SI ZLE CISLO!", hrac1, JOptionPane.WARNING_MESSAGE);
                        b = true;
                    }
                }

                b = true;
                while (b) {
                    try {
                        aktualneY = Integer.parseInt(JOptionPane.showInputDialog(null, hrac1 + "\nZadaj suradnicu Y jednotky s ktorou chces vykonat akciu"));
                        if (aktualneY > 5 || aktualneY < 1) {
                            JOptionPane.showMessageDialog(null, "ZADAL SI ZLE CISLO!", hrac1, JOptionPane.WARNING_MESSAGE);
                            b = true;
                        } else {
                            b = false;
                        }
                    } catch (NumberFormatException nfex) {
                        JOptionPane.showMessageDialog(null, "ZADAL SI ZLE CISLO!", hrac1, JOptionPane.WARNING_MESSAGE);
                        b = true;
                    }
                }

                if (mapa.getMapa(aktualneX - 1, aktualneY - 1) == null) {
                    JOptionPane.showMessageDialog(null, "NA TOMTO MIESTE SA NENACHADZAJU ZIADNY VOJACI!", hrac1, JOptionPane.WARNING_MESSAGE);
                    c = true;
                } else {
                    if (mapa.getMapa(aktualneX - 1, aktualneY - 1).getCode() == code * abs(mapa.getMapa(aktualneX - 1, aktualneY - 1).getCode())) {

                        string1 = aktualneX + " " + aktualneY;

                        for (String string : zoznam) {
                            if (string.equals(string1)) {
                                pomoc = 1;
                            }
                        }
                        if (pomoc == 1) {
                            JOptionPane.showMessageDialog(null, "S TOUTO JEDNOTKOU SI UZ VYKONAL AKCIU!", hrac1, JOptionPane.WARNING_MESSAGE);
                            pomocNaPozeranie = 1;
                            c = false;
                        } else {
                            c = false;
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "TATO JEDNOTKA PATRI HRACOVI " + hrac2, hrac1, JOptionPane.WARNING_MESSAGE);
                        c = true;
                    }
                }
            }

            list.add("" + aktualneX);
            list.add("" + aktualneY);
            pocitadlo += 2;

            String string = this.rozoznaj(aktualneX, aktualneY, mapa);
            akcie += "\n" + string;
            int index = 0;
            if (pomocNaPozeranie == 1) {
                index = 4;
                pomocNaPozeranie = 0;
            } else {
                boolean d = true;
                while (d) {
                    try {
                        index = Integer.parseInt(JOptionPane.showInputDialog(null, hrac1 + "\nJednotka: " + string + "\n Vyber si aku akciu chces vykonat \n 1. Pohyb \n 2. Strelba \n 3. Obrana \n 4. Zisti stav \n 5. Ukonci hru"));
                        if (index > 0 && index < 6) {
                            d = false;
                        } else {
                            d = true;
                        }
                    } catch (NumberFormatException nfex) {
                        JOptionPane.showMessageDialog(null, "ZADAL SI ZLE CISLO!" + hrac2, hrac1, JOptionPane.WARNING_MESSAGE);
                        d = true;
                    }
                }
            }

            Obdlznik obdlznik1 = new Obdlznik();
            Obdlznik obdlznik = new Obdlznik();
            switch (index) {
                case 1:
                    zoznam.add(string1);
                    int x = 0;
                    int y = 0;

                    c = true;
                    while (c) {
                        int[] pole = mapa.dosah(aktualneX, aktualneY, false);
                        b = true;
                        while (b) {
                            try {
                                x = Integer.parseInt(JOptionPane.showInputDialog(null, hrac1 + "\nZadaj suradnicu X na ktoru chces jednotku presunut \nTvoj dosah je maximalne " + mapa.getMapa(aktualneX - 1, aktualneY - 1).getDosah() + " policok"));
                                if (x > 30 || x < 1) {
                                    JOptionPane.showMessageDialog(null, "ZADAL SI ZLE CISLO!", hrac1, JOptionPane.WARNING_MESSAGE);
                                    b = true;
                                } else {
                                    b = false;
                                }
                            } catch (NumberFormatException nfex) {
                                JOptionPane.showMessageDialog(null, "ZADAL SI ZLE CISLO!", hrac1, JOptionPane.WARNING_MESSAGE);
                                b = true;
                            }
                        }

                        b = true;
                        while (b) {
                            try {
                                y = Integer.parseInt(JOptionPane.showInputDialog(null, hrac1 + "\nZadaj suradnicu Y na ktoru chces jednotku presunut \nTvoj dosah je maximalne " + mapa.getMapa(aktualneX - 1, aktualneY - 1).getDosah() + " policok"));
                                if (y > 5 || y < 1) {
                                    JOptionPane.showMessageDialog(null, "ZADAL SI ZLE CISLO!", hrac1, JOptionPane.WARNING_MESSAGE);
                                    b = true;
                                } else {
                                    b = false;
                                }
                            } catch (NumberFormatException nfex) {
                                JOptionPane.showMessageDialog(null, "ZADAL SI ZLE CISLO!", hrac1, JOptionPane.WARNING_MESSAGE);
                                b = true;
                            }

                        }
                        if ((abs(aktualneX - x) + abs(aktualneY - y)) > mapa.getMapa(aktualneX - 1, aktualneY - 1).getDosah()) {
                            JOptionPane.showMessageDialog(null, "SNAZIS SA DOSTAT MOC DALEKO \nTvoj dosah je maximalne " + mapa.getMapa(aktualneX - 1, aktualneY - 1).getDosah() + " policok", hrac1, JOptionPane.WARNING_MESSAGE);
                            c = true;
                        } else {
                            c = false;
                            mapa.prekresleniePlochy(pole[0], pole[1]);
                        }
                    }

                    list.add("" + 1);
                    list.add("" + x);
                    list.add("" + y);
                    akcie += " - pohyb " + x + ", " + y;
                    if (aktualneX == x || aktualneY == y) {
                        list.add("" + 0);
                    } else {
                        if (JOptionPane.showConfirmDialog(null, "Chces ist severnou cestou?", hrac1, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                            list.add("" + 1);
                        } else {
                            list.add("" + 0);
                        }
                    }

                    if (mapa.getMapa(x - 1, y - 1) == null) {

                        obdlznik.zmenStrany(this.strana, this.strana);
                        obdlznik.zmenPolohu((x + 1) * (this.strana + 1), (y + 1) * (this.strana + 1));
                        obdlznik.zmenFarbu("yellow");
                        obdlznik.zobraz();
                    }

                    pocitadlo += 4;
                    break;
                case 2:

                    obdlznik1.zmenStrany(this.strana, this.strana);
                    if (code == 1) {
                        obdlznik1.zmenPolohu((aktualneX + 21) * (this.strana + 1), (aktualneY + 1) * (this.strana + 1));
                    } else {
                        obdlznik1.zmenPolohu((aktualneX - 19) * (this.strana + 1), (aktualneY + 1) * (this.strana + 1));
                    }
                    obdlznik1.zmenFarbu("yellow");
                    obdlznik1.zobraz();

                    if (mapa.getMapa(aktualneX - 1, aktualneY - 1) instanceof Archer) {
                        zoznam.add(string1);
                        list.add("" + 2);
                        list.add("" + 0);
                        list.add("" + 0);
                        list.add("" + 0);
                        akcie += " - strelba";
                        pocitadlo += 4;
                    } else {
                        JOptionPane.showMessageDialog(null, "INA JEDNOTKA AKO LUKOSTRELEC \n NEMOZE STRIELAT!", hrac1, JOptionPane.WARNING_MESSAGE);
                        list.remove(pocitadlo - 1);
                        list.remove(pocitadlo - 2);
                        pocitadlo -= 2;
                    }
                    break;
                case 3:
                    zoznam.add(string1);
                    akcie += " - obrana";
                    mapa.getMapa(aktualneX - 1, aktualneY - 1).setObrana(2);
                    mapa.getMapa(aktualneX - 1, aktualneY - 1).setPripravenaObrana(true);
                    list.remove(pocitadlo - 1);
                    list.remove(pocitadlo - 2);
                    pocitadlo -= 2;
                    JOptionPane.showMessageDialog(null, "NASTAVIL SI OBRANU!    ");
                    break;
                case 4:

                    JOptionPane.showMessageDialog(null, mapa.getMapa(aktualneX - 1, aktualneY - 1).toString());
                    list.remove(pocitadlo - 1);
                    list.remove(pocitadlo - 2);
                    pocitadlo -= 2;
                    break;
                case 5:
                    this.akciaKoniec();
                    list.remove(pocitadlo - 1);
                    list.remove(pocitadlo - 2);
                    pocitadlo -= 2;
                    break;
                default:
                    list.remove(pocitadlo - 1);
                    list.remove(pocitadlo - 2);
                    pocitadlo -= 2;
                    break;
            }

            if (JOptionPane.showConfirmDialog(null, "Chces uskutocnit akciu s dalsou jednotkou?", hrac1, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                a = true;
            } else {
                if (JOptionPane.showConfirmDialog(null, "Chces uskutocnit akcie ktore si zadal? \n" + akcie, hrac1, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                    a = false;
                } else {
                    a = true;
                    akcie = "";
                    pomoc = 0;
                    string1 = "";
                    zoznam.removeAll(zoznam);
                    for (int i = 0; i < pocitadlo; i++) {
                        list.remove(0);
                    }
                    pocitadlo = 0;
                }
            }
            obdlznik.skry();
            obdlznik1.skry();
        }
        list.add(0, "" + pocitadlo);
        return list;
    }

    /**
     * Metoda spustacAkcii vykona akcie zadane v metode nastavovac.
     * @param list predstavuje zoznam akcii ktore si hrac navolil.
     * @param mapa predstavuje kde sa bude metoda vykonavat.
     * @param i predstavuje na akej pozicii v liste treba aktualne hladat.
     * @param hrac predstavuje meno hraca.
     */
    public void spustacAkcii(ArrayList<String> list, Mapa mapa, int i, String hrac) {
        //System.out.println("spustac sa spustil");
        //for (int i = 1; i <= (Integer.parseInt(list.get(0)) / 6); i++) {
        switch (Integer.parseInt(list.get((i * 6) - 3))) {
            case 1:
                //System.out.println("spustac1");
                mapa.move(Integer.parseInt(list.get(i * 6 - 5)), Integer.parseInt(list.get(i * 6 - 4)), Integer.parseInt(list.get(i * 6 - 2)), Integer.parseInt(list.get(i * 6 - 1)), Integer.parseInt(list.get(i * 6)));
                break;
            case 2:
                int uhol = 0;
                int sila = 0;

                boolean b = true;
                while (b) {
                    try {
                        uhol = Integer.parseInt(JOptionPane.showInputDialog(null, hrac + "\nZadaj uhol pod akym maju lukostrelci strielat \n (0° - 180°)"));
                        if (uhol > 180 || uhol < 0) {
                            JOptionPane.showMessageDialog(null, "ZADAL SI ZLE CISLO!", hrac, JOptionPane.WARNING_MESSAGE);
                            b = true;
                        } else {
                            b = false;
                        }
                    } catch (NumberFormatException nfex) {
                        JOptionPane.showMessageDialog(null, "ZADAL SI ZLE CISLO!", hrac, JOptionPane.WARNING_MESSAGE);
                        b = true;
                    }

                }

                b = true;
                while (b) {
                    try {
                        sila = Integer.parseInt(JOptionPane.showInputDialog(null, hrac + "\nZadaj silu akou maju lukostrelci strielat \n (1 - 7)"));
                        if (sila > 7 || sila < 1) {
                            JOptionPane.showMessageDialog(null, "ZADAL SI ZLE CISLO!", hrac, JOptionPane.WARNING_MESSAGE);
                            b = true;
                        } else {
                            b = false;
                        }
                    } catch (NumberFormatException nfex) {
                        JOptionPane.showMessageDialog(null, "ZADAL SI ZLE CISLO!", hrac, JOptionPane.WARNING_MESSAGE);
                        b = true;
                    }

                }

                if (mapa.getMapa(Integer.parseInt(list.get(i * 6 - 5)) - 1, Integer.parseInt(list.get(i * 6 - 4)) - 1) instanceof Archer) {
                    if (mapa.getMapa(Integer.parseInt(list.get(i * 6 - 5)) - 1, Integer.parseInt(list.get(i * 6 - 4)) - 1).getCode() < 0) {
                        uhol = 180 - uhol;
                    }
                    mapa.getMapa(Integer.parseInt(list.get(i * 6 - 5)) - 1, Integer.parseInt(list.get(i * 6 - 4)) - 1).vystrel(mapa.getMapa(Integer.parseInt(list.get(i * 6 - 5)) - 1, Integer.parseInt(list.get(i * 6 - 4)) - 1).nastavenieVystrelu(uhol, sila), Integer.parseInt(list.get(i * 6 - 5)) - 1, Integer.parseInt(list.get(i * 6 - 4)) - 1, mapa);
                }
                break;
            case 3:
                break;
            default:
                break;
        }
    }

    /**
     * Metoda nastavenieArmady zapise do pola pocty z kazdej jednotky, podla toho kolko si ich hrac navoli.
     * @param hrac predstavuje meno hraca.
     * @return pole (obsahuje pocty jednotiek).
     */
    public int[] nastavenieArmady(String hrac) {
        FootSoldier fs = new FootSoldier(0, 0, 1);
        Archer ar = new Archer(0, 0, 1);
        Knight kn = new Knight(0, 0, 1);
        int pocetBodov1 = this.pocetBodov;
        int pocetFootSoldier = 0;
        int pocetArcher = 0;
        int pocetKnight = 0;
        int pocet0 = 0;
        int pocet1 = 0;
        int pocet2 = 0;
        int[] pole = new int[3];
        boolean a = true;
        boolean b = true;
        String string = "";

        while (a) {
            b = true;
            while (b) {
                try {
                    pocet0 = Integer.parseInt(JOptionPane.showInputDialog(null, hrac + "\nZadaj pocet PESIAKOV \n Mozes ich mat maximalne: " + pocetBodov1 / fs.getCena()));
                    if (pocet0 > pocetBodov1 / fs.getCena() || pocet0 < 0) {
                        JOptionPane.showMessageDialog(null, "ZADAL SI ZLE CISLO!", hrac, JOptionPane.WARNING_MESSAGE);
                        b = true;
                    } else {
                        b = false;
                    }
                } catch (NumberFormatException nfex) {
                    JOptionPane.showMessageDialog(null, "ZADAL SI ZLE CISLO!", hrac, JOptionPane.WARNING_MESSAGE);
                    b = true;
                }

            }
            pocetFootSoldier += pocet0;
            pocetBodov1 -= pocet0 * 2;
            if (pocetBodov1 > 1) {
                pole[0] = pocetFootSoldier;
                string += "" + pole[0];
                b = true;
                while (b) {
                    try {
                        pocet1 = Integer.parseInt(JOptionPane.showInputDialog(null, hrac + "\nZadaj pocet LUKOSTRELCOV \n Mozes ich mat maximalne: " + pocetBodov1 / ar.getCena()));
                        if (pocet1 > pocetBodov1 / ar.getCena() || pocet0 < 0) {
                            JOptionPane.showMessageDialog(null, "ZADAL SI ZLE CISLO!", hrac, JOptionPane.WARNING_MESSAGE);
                            b = true;
                        } else {
                            b = false;
                        }
                    } catch (NumberFormatException nfex) {
                        JOptionPane.showMessageDialog(null, "ZADAL SI ZLE CISLO!", hrac, JOptionPane.WARNING_MESSAGE);
                        b = true;
                    }

                }
                pocetArcher += pocet1;
                pocetBodov1 -= pocet1 * 2;
                if (pocetBodov1 > 1) {
                    pole[1] = pocetArcher;
                    string += " " + pole[1];
                    b = true;
                    while (b) {
                        try {
                            pocet2 = Integer.parseInt(JOptionPane.showInputDialog(null, hrac + "\nZadaj pocet RYTIEROV \n Mozes ich mat maximalne: " + pocetBodov1 / kn.getCena()));
                            if (pocet2 > pocetBodov1 / kn.getCena() || pocet0 < 0) {
                                JOptionPane.showMessageDialog(null, "ZADAL SI ZLE CISLO!", hrac, JOptionPane.WARNING_MESSAGE);
                                b = true;
                            } else {
                                b = false;
                            }
                        } catch (NumberFormatException nfex) {
                            JOptionPane.showMessageDialog(null, "ZADAL SI ZLE CISLO!", hrac, JOptionPane.WARNING_MESSAGE);
                            b = true;
                        }

                    }
                    pocetKnight += pocet2;
                    pocetBodov1 -= pocet2 * 3;
                    if (pocetBodov1 > 1) {
                        pole[2] = pocetKnight;
                        string += " " + pole[2];
                        a = true;
                    } else {
                        if (JOptionPane.showConfirmDialog(null, "Chces aby tvoja armada vyzerala nasledovne: \n " + pocetFootSoldier + "X Pesiak \n " + pocetArcher + "X Lukostrelec \n " + pocetKnight + "X Rytier", hrac, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                            pole[2] = pocetKnight;
                            string += " " + pole[2];
                            a = false;
                        } else {
                            JOptionPane.showMessageDialog(null, hrac + "\nZadavas armadu znova!");
                            pocetFootSoldier = 0;
                            pocetArcher = 0;
                            pocetKnight = 0;
                            pocetBodov1 = 20;
                            a = true;
                            string = null;
                        }
                    }
                } else {
                    if (JOptionPane.showConfirmDialog(null, "Chces aby tvoja armada vyzerala nasledovne: \n " + pocetFootSoldier + "X Pesiak \n " + pocetArcher + "X Lukostrelec \n " + pocetKnight + "X Rytier", hrac, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                        a = false;
                        pole[1] = pocetArcher;
                        string += " " + pole[1];
                    } else {
                        JOptionPane.showMessageDialog(null, hrac + "\nZadavas armadu znova!");
                        pocetFootSoldier = 0;
                        pocetArcher = 0;
                        pocetKnight = 0;
                        pocetBodov1 = 20;
                        a = true;
                    }
                }
            } else {
                if (JOptionPane.showConfirmDialog(null, "Chces aby tvoja armada vyzerala nasledovne: \n " + pocetFootSoldier + "X Pesiak \n " + pocetArcher + "X Lukostrelec \n " + pocetKnight + "X Rytier", hrac, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                    a = false;
                    pole[0] = pocetFootSoldier;
                    string += " " + pole[0];
                } else {
                    JOptionPane.showMessageDialog(null, hrac + "\nZadavas armadu znova!");
                    pocetFootSoldier = 0;
                    pocetArcher = 0;
                    pocetKnight = 0;
                    pocetBodov1 = 20;
                    a = true;
                }
            }
        }
        return pole;

    }
}
