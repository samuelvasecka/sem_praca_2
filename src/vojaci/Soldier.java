/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vojaci;

import prostredieHerne.Mapa;
import prostredieHerne.Obdlznik;
import nastavenia.Nastavovanie;
import java.awt.Dimension;
import java.awt.Toolkit;
import static java.lang.Math.round;
import static java.lang.Math.sin;
import javax.swing.JOptionPane;

/**
 * Trieda modeluje univerzalnu vojensku jednotku, ktorej potomkami su
 * ostatne jednotky.
 * 
 * 
 * @author Samuel Vasecka
 * @version 2019.05.14
 */
public class Soldier implements ISoldier {

    private int sila;
    private int dosah;
    private final int dostrel;
    private double obrana;
    private double pocet;
    private double pocetPomocny;
    private double moralka;
    private final int cena;
    private boolean pripravenaObrana;
    private boolean jeVBoji;   
    private int polohaX;
    private int polohaY;
    private final int code;
    private final double moralCode;
    private int strana;
    private boolean uzBojoval;

    /**
     * Konstruktor vytvori vojensku jednotku s danymi atributami.
     * @param sila predstavuje utocnu silu jednotky.
     * @param dosah predstavuje ako daleko sa jednotka moze pohnut.
     * @param dostrel predstavuje ako daleko je maximalny dostrel jednotky.
     * @param obrana predstavuje hodnotu obrany jednotky.
     * @param pocet predstavuje pocet vojakov vo vojenskej jednotke.
     * @param cena predstavuje kolko jednotka stoji.
     * @param poziciaX predstavuje x-ovu poziciu jednotky na mape.
     * @param poziciaY predstavuje y-ovu poziciu jednotky na mape.
     * @param code predstavuje ktoremu hracov jednotka patri.
     * @param moralCode predstavuje ako silnu moralku bude mat jednotka.
     */
    public Soldier(int sila, int dosah, int dostrel, double obrana, double pocet, int cena, int poziciaX, int poziciaY, int code, double moralCode) {
        this.sila = sila;
        this.dosah = dosah;
        this.dostrel = dostrel;
        this.obrana = obrana;
        this.pocet = pocet;
        this.pocetPomocny = 500;
        this.moralCode = moralCode;
        this.moralka = 100;

        this.cena = cena;
        this.pripravenaObrana = false;
        this.jeVBoji = false;

        this.polohaX = poziciaX;
        this.polohaY = poziciaY;
        this.code = code;
        this.uzBojoval = false;

        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension d = t.getScreenSize();

        this.strana = d.width / 33 - 1;
    }

    /**
     * Metoda isUzBojoval vrati boolean hodnotu, ktora predstavuje ci objekt Soldier, 
     * uz bojoval.
     * @return uzBojoval (ci uz dany objekt Soldier bojoval).
     */
    public boolean isUzBojoval() {
        return this.uzBojoval;
    }
    
    /**
     * Metoda setUzBojoval zmeni boolean hodnotu atributu uzBojoval.
     * @param uzBojoval, zmeni hodnotu atributu uzBojoval na svoju hodnotu.
     */
    public void setUzBojoval(boolean uzBojoval) {
        this.uzBojoval = uzBojoval;
    }

    /**
     * Metoda getSila vrati int hodnotu atributu Sila.
     * @return sila (int hodnota atributu sila).
     */
    public int getSila() {
        return this.sila;
    }

    /**
     * Metoda setSila 3-nasobne zvacsi int hodnotu atibutu sila.
     * 
     */
    public void setSila() {
        this.sila = this.sila * 3;
    }

    /**
     * Metoda getDosah vrati int hodnotu atributu dosah.
     * @return dosah (int hodnota atributu dosah).
     */
    public int getDosah() {
        return this.dosah;
    }

    /**
     * Metoda setDosah zmensi int hodnotu atributu dosah o jeden.
     */
    public void setDosah() {
        this.dosah = this.dosah - 1;
    }

    /**
     * Metoda getDostrel vrati int hodnotu atributu dostrel
     * @ return dostrel (int hodnota atributu dostrel).
     */
    public int getDostrel() {
        return this.dostrel;
    }

    /**
     * Metoda getObrana vrati double hodnotu atributu obrana.
     * @return obrana (double hodnota atributu obrana).
     */
    public double getObrana() {
        return this.obrana;
    }

    /**
     * Metoda getPocet vrati double hodnotu atributu pocet.
     * @return pocet (double hodnota atributu pocet).
     */
    public double getPocet() {
        return this.pocet;
    }

    /**
     * Metoda getMoralka vrati double hodnotu atributu moralka, pricom kontoluje
     * aby moralka nebola vyssia ako 100%.
     * @return moralka (double hodnota atributu moralka).
     */
    public double getMoralka() {
        if ((this.pocet / 5) * this.moralCode > 100) {
            this.moralka = ((this.pocet / 5) * this.moralCode) - (((this.pocet / 5) * this.moralCode) % 100);
        } else {
            this.moralka = (this.pocet / 5) * this.moralCode;
        }
        return this.moralka;
    }

    /**
     * Metoda getCena vrati int hodnotu atributu cena.
     * @return cena (int hodnota atributu cena).
     */
    public int getCena() {
        return this.cena;
    }

    /**
     * Metoda getPolohaX vrati int hodnotu atributu polohaX.
     * @return polohaX (int hodnota atributu polohaX).
     */
    public int getPolohaX() {
        return this.polohaX;
    }

    /**
     * Metoda getPolohaY vrati int hodnotu atributu polohaX.
     * @return polohaY (int hodnota atributu polohaX).
     */
    public int getPolohaY() {
        return this.polohaY;
    }

    /**
     * Metoda getCode vrati int hodnotu atributu code.
     * @return code (int hodnota atributu code).
     */
    public int getCode() {
        return this.code;
    }

    /**
     * Metoda getPocetPomocny vrati int hodnotu atributu pocetPomocny.
     * @return pocetPomocny (int hodnota atributu pocetPomocny).
     */
    public double getPocetPomocny() {
        return this.pocetPomocny;
    }

    /**
     * Metoda setPocetPomocny zmeni double hodnotu atributu pocetPomocny, 
     * pricom pocetPomocny nemoze byt mensi ako 0.
     * @param pocetPomocny1 predstavuje double hodnotu o ktoru sa zmensi hodnota 
     * atributu pocetPomocny.
     */
    public void setPocetPomocny(double pocetPomocny1) {
        if ((this.pocetPomocny - pocetPomocny1) < 0) {
            this.pocetPomocny = 0;
        } else {
            this.pocetPomocny -= pocetPomocny1;
        }
    }

    /**
     * Metoda isPripravenaObrana vrati boolean hodnotu atributut pripravenHodnota.
     * @return pripravenaObrana (boolean hodnota atributu pripravenaObrana).
     */
    public boolean isPripravenaObrana() {
        return this.pripravenaObrana;
    }

    /**
     * Metoda isJeVBoji vrati boolean hodnotu atributu jeVBoji.
     * @return jeVBoji (boolean hodnota atributu jeVBoji).
     */
    public boolean isJeVBoji() {
        return this.jeVBoji;
    }

    /**
     * Metoda setPocet zmeni int hodnotu atributu pocet, 
     * pricom pocet nemoze byt mensi ako 0.
     * @param pocet predstavuje double hodnotu o ktoru sa zmensi hodnota 
     * atributu pocet.
     * @return pocet.
     */
    public int setPocet(int pocet1) {
        if ((this.pocet - pocet1) < 0) {
            this.pocet = 0;
        } else {
            this.pocet -= pocet1;
        }
        return pocet1;
    }

    /**
     * Metoda setObrana vydeli double hodnotu atributu obrana parametrom obrana.
     * @param obrana predstavuje double hodnotu ktorou sa vydeli double hodnota atributu obrana.
     */
    public void setObrana(double obrana) {
        this.obrana = (this.obrana / obrana);
    }

    /**
     * Metoda setPripravenaObrana zmeni boolean hodnotu atributu pripavenaObrana, 
     * @param pripravenaObrana predstavuje boolean hodnotu na ktoru sa zmensi hodnota 
     * atributu pripravenaObrana.
     */
    public void setPripravenaObrana(boolean pripravenaObrana) {
        this.pripravenaObrana = pripravenaObrana;
    }

    /**
     * Metoda setJeVBoji zmeni boolean hodnotu atributu jeVBoji, 
     * @param jeVBoji predstavuje boolean hodnotu na ktoru sa zmensi hodnota 
     * atributu jeVBoji.
     */
    public void setJeVBoji(boolean jeVBoji) {
        this.jeVBoji = jeVBoji;
    }
    
    /**
     * Metoda setPolohaX zmeni int hodnotu atributu polohaX, 
     * @param polohaX predstavuje int hodnotu na ktoru sa zmensi hodnota 
     * atributu polohaX.
     */
    public void setPolohaX(int polohaX) {
        this.polohaX = polohaX;
    }

    /**
     * Metoda setPolohaY zmeni int hodnotu atributu polohaY, 
     * @param polohaY predstavuje int hodnotu na ktoru sa zmensi hodnota 
     * atributu polohaY.
     */
    public void setPolohaY(int polohaY) {
        this.polohaY = polohaY;
    }

    /**
     * Metoda toString vrati retazec so zakladnymi udajmi o jednotke.
     * @return retazec.
     */
    public String toString() {
        String string = "";
        if (this.isPripravenaObrana()) {
            string = "ano";
        } else {
            string = "nie";
        }
        
        return "Pozicia: " + (this.getPolohaX() + 1) + ", " + (this.getPolohaY() + 1) + "\nMax pohyb: " + this.getDosah() + "\nPocet vojakov: " + this.getPocet() + "\nMoralka: " + this.getMoralka() + "%" + "\nObranna pozicia: " + string + "\n";
    }
    
    /**
     * Metoda dajPopis vrati retazec so zakladnymi udajmi o jednotke po boji.
     * @return retazec.
     */
    public String dajPopis() {
        double pocetKontrola = 0;
        double zomrety = 0;
        double moralkaPomocna = 0;
        if (this.getPocet() <= 0) {
            pocetKontrola = 0;
            zomrety = this.getPocetPomocny();
            moralkaPomocna = 0;
        } else {
            pocetKontrola = this.getPocet();
            zomrety = (this.getPocetPomocny() - this.getPocet());
            moralkaPomocna = this.getMoralka();
        }
        return "Pozicia: " + (this.getPolohaX() + 1) + ", " + (this.getPolohaY() + 1) + "\nPocet vojakov: " + pocetKontrola + "\nZomrelo: " + zomrety + "\nMoralka: " + moralkaPomocna + "%";
    }

    /**
     * Metoda nastavenieVystrelu vrati vzdialenost do akej lukostrelci dostrelia,
     * pri konkretnej rychlosti a uhle vystrelu, pricom ak su udaje zle, vrati vzdialenost 0.
     * @param uhol predstavuje int hodnotu pod akym uhlom budu lukostrelci strielat.
     * @param rychlost predstavuje int hodnotu akou rychlostou budu lukostrelci strielat.
     * @return vzdialenost.
     */
    public int nastavenieVystrelu(int uhol, int rychlost) {
        int vzdialenost = 0;
        double radians = Math.toRadians(uhol);
        if (uhol >= 0 || uhol <= 180 || rychlost > 0 || rychlost < 8) {
            vzdialenost = (int)round((((rychlost * rychlost) / 10.0) * sin(2 * radians)) * (this.getDostrel() / 4.9));
            return vzdialenost;
        } else {
            return 0;
        }
    }

    /**
     * Metoda vystrel zmesi pocty jenotiek vzdialenych o parameter vzdialenost.
     * @param vzdialenost udava kam lukostrelci dostrelia.
     * @param x udava x poziciu na mape.
     * @param y udava y poziciu na mape.
     * @param mapa urcuje kde sa bude vykonovat akcia vystrel.
     */
    public void vystrel(int vzdialenost, int x, int y, Mapa mapa) {
        int[] pole = new int[]{10, 20, 50, 20, 10};
        Nastavovanie nastavovanie = new Nastavovanie(20);
        String string = "";

        for (int i = 0; i < 5; i++) {
            if (mapa.getMapa(x + vzdialenost - 2 + i, y) != null) {
                mapa.getMapa(x + vzdialenost - 2 + i, y).setPocet((int)(pole[i] * mapa.getMapa(x + vzdialenost - 2 + i, y).getObrana()));
                string += nastavovanie.rozoznaj(x + vzdialenost - 1 + i, y + 1, mapa) + "\n" + mapa.getMapa(x + vzdialenost - 2 + i, y).dajPopis() + "\n \n";
                mapa.getMapa(x + vzdialenost - 2 + i, y).setPocetPomocny((pole[i] * mapa.getMapa(x + vzdialenost - 2 + i, y).getObrana()));
                if (mapa.getMapa(x + vzdialenost - 2 + i, y).getPocet() <= 0) {
                    mapa.setMapa(x + vzdialenost - 2 + i, y, null);

                    Obdlznik obdlznik = new Obdlznik();
                    obdlznik.zmenStrany(this.strana, this.strana);
                    obdlznik.zmenPolohu((x + vzdialenost + i) * (this.strana + 1), (y + 2) * (this.strana + 1));
                    obdlznik.zmenFarbu("green");
                    obdlznik.zobraz();
                }
            }
        }

        if (vzdialenost > 0) {
            for (int i = 0; i < vzdialenost + 3; i++) {

                if (i > vzdialenost - 3) {
                    Obdlznik obdlznik1 = new Obdlznik();
                    obdlznik1.zmenStrany(this.strana, this.strana);
                    obdlznik1.zmenPolohu((x + 2 + i) * (this.strana + 1), (y + 2) * (this.strana + 1));
                    obdlznik1.zmenFarbu("orange");
                    obdlznik1.zobraz();

                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                    obdlznik1.skry();
                } else {

                    Obdlznik obdlznik = new Obdlznik();
                    obdlznik.zmenStrany(this.strana - (this.strana / 5), this.strana / 5);
                    obdlznik.zmenPolohu((x + 2 + i) * (this.strana + 1) + (this.strana / 10), (y + 2) * (this.strana + 1) + (this.strana - this.strana / 5) / 2);
                    obdlznik.zmenFarbu("white");
                    obdlznik.zobraz();

                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                    obdlznik.skry();
                }

            }
        } else {
            for (int i = 0; i > vzdialenost - 3; i--) {

                if (i < vzdialenost + 3) {
                    Obdlznik obdlznik1 = new Obdlznik();
                    obdlznik1.zmenStrany(this.strana, this.strana);
                    obdlznik1.zmenPolohu((x + 2 + i) * (this.strana + 1), (y + 2) * (this.strana + 1));
                    obdlznik1.zmenFarbu("orange");
                    obdlznik1.zobraz();

                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                    obdlznik1.skry();
                } else {

                    Obdlznik obdlznik = new Obdlznik();
                    obdlznik.zmenStrany(this.strana - (this.strana / 5), this.strana / 5);
                    obdlznik.zmenPolohu((x + 2 + i) * (this.strana + 1) + (this.strana / 10), (y + 2) * (this.strana + 1) + (this.strana - this.strana / 5) / 2);
                    obdlznik.zmenFarbu("white");
                    obdlznik.zobraz();
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                    obdlznik.skry();
                }
            }
        }

        if (string.equals(
                "")) {
            JOptionPane.showMessageDialog(null, "Nezasiahol si nikoho! \n Musis lepsie mierit!", "Alert", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Stav jednotiek po Vystrele: \n" + string);
        }

        for (int i = 0;
                i < 5; i++) {
            if (mapa.getMapa(x + vzdialenost - 2 + i, y) != null) {
                mapa.getMapa(x + vzdialenost - 2 + i, y).setPocetPomocny(pole[i]);
                if (mapa.getMapa(x + vzdialenost - 2 + i, y).getPocet() <= 0) {
                    mapa.setMapa(x + vzdialenost - 2 + i, y, null);
                    Obdlznik obdlznik = new Obdlznik();
                    obdlznik.zmenStrany(this.strana, this.strana);
                    obdlznik.zmenPolohu((x + vzdialenost - 1 + i) * (this.strana + 1), (y + 1) * (this.strana + 1));
                    obdlznik.zmenFarbu("green");
                    obdlznik.zobraz();
                }
            }
        }
    }

    /**
     * Metoda boj zisti, ci jednodnotka po pohybe nestoji vedla nepriatelskej jednotky, 
     * a ak ano obidvom znizi pocet vojakov podla nastavenych pravidiel.
     * @param x udava x poziciu na mape.
     * @param y udava y poziciu na mape.
     * @param mapa urcuje kde sa bude vykonovat akcia vystrel.
     * @param identifikator urcuje ci hrac utocil z vacsej vzdialenosti ako 2, a tym sa urci sila utoku.
     * @return pomoc (urcuje ci boj prebehol alebo neprebehol).
     */
    public int boj(int x, int y, Mapa mapa, boolean identifikator) {
        Nastavovanie nastavovanie = new Nastavovanie(20);
        int pomoc = 0;
        try {
            if (mapa.getMapa(x - 2, y - 1) == null || mapa.getMapa(x, y - 1) == null) {
                if (mapa.getMapa(x - 2, y - 1) == null && mapa.getMapa(x, y - 1) == null) {
                    pomoc = 0;
                } else {
                    if (mapa.getMapa(x - 2, y - 1) == null) {
                        pomoc = 1;
                        if ((mapa.getMapa(x - 1, y - 1).getCode() < 0 && mapa.getMapa(x, y - 1).getCode() > 0) || (mapa.getMapa(x - 1, y - 1).getCode() > 0 && mapa.getMapa(x, y - 1).getCode() < 0)) {
                            if (identifikator) {                              
                                double pocet1 = mapa.getMapa(x - 1, y - 1).setPocet((int)((mapa.getMapa(x, y - 1).getSila() * mapa.getMapa(x - 1, y - 1).getObrana() * (mapa.getMapa(x, y - 1).getPocetPomocny() / 500))));
                                double pocet2 = mapa.getMapa(x, y - 1).setPocet((int)(1.5 * (mapa.getMapa(x - 1, y - 1).getSila() * mapa.getMapa(x, y - 1).getObrana() * (mapa.getMapa(x - 1, y - 1).getPocetPomocny() / 500))));
                                JOptionPane.showMessageDialog(null, "Stav jednotiek po boji: \n" + nastavovanie.rozoznaj(x, y, mapa) + " SILNEJSI UTOK" + "\n" + mapa.getMapa(x - 1, y - 1).dajPopis() + "\n \n" + nastavovanie.rozoznaj(x + 1, y, mapa) + "\n" + mapa.getMapa(x, y - 1).dajPopis());
                                mapa.getMapa(x - 1, y - 1).setPocetPomocny(pocet1);
                                mapa.getMapa(x, y - 1).setPocetPomocny(pocet2);
                            } else {
                                double pocet1 = mapa.getMapa(x - 1, y - 1).setPocet((int)(mapa.getMapa(x, y - 1).getSila() * mapa.getMapa(x - 1, y - 1).getObrana() * (mapa.getMapa(x, y - 1).getPocetPomocny() / 500)));
                                double pocet2 = mapa.getMapa(x, y - 1).setPocet((int)(mapa.getMapa(x - 1, y - 1).getSila() * mapa.getMapa(x, y - 1).getObrana() * (mapa.getMapa(x - 1, y - 1).getPocetPomocny() / 500)));
                                JOptionPane.showMessageDialog(null, "Stav jednotiek po boji: \n" + nastavovanie.rozoznaj(x, y, mapa) + "\n" + mapa.getMapa(x - 1, y - 1).dajPopis() + "\n \n" + nastavovanie.rozoznaj(x + 1, y, mapa) + "\n" + mapa.getMapa(x, y - 1).dajPopis());
                                mapa.getMapa(x - 1, y - 1).setPocetPomocny(pocet1);
                                mapa.getMapa(x, y - 1).setPocetPomocny(pocet2);
                            }
                        }
                        if (mapa.getMapa(x - 1, y - 1).getPocet() <= 0) {
                            mapa.setMapa(x - 1, y - 1, null);

                            Obdlznik obdlznik = new Obdlznik();
                            obdlznik.zmenStrany(this.strana, this.strana);
                            obdlznik.zmenPolohu((x + 1) * (this.strana + 1), (y + 1) * (this.strana + 1));
                            obdlznik.zmenFarbu("green");
                            obdlznik.zobraz();
                        }
                        if (mapa.getMapa(x, y - 1).getPocet() <= 0) {
                            mapa.setMapa(x, y - 1, null);
                            Obdlznik obdlznik = new Obdlznik();
                            obdlznik.zmenStrany(this.strana, this.strana);
                            obdlznik.zmenPolohu((x + 2) * (this.strana + 1), (y + 1) * (this.strana + 1));
                            obdlznik.zmenFarbu("green");
                            obdlznik.zobraz();
                        }

                    } else {
                        pomoc = 1;
                        if ((mapa.getMapa(x - 1, y - 1).getCode() < 0 && mapa.getMapa(x - 2, y - 1).getCode() > 0) || (mapa.getMapa(x - 1, y - 1).getCode() > 0 && mapa.getMapa(x - 2, y - 1).getCode() < 0)) {
                            if (identifikator) {
                                System.out.println("Vydarilo sa 3");
                                double pocet1 = mapa.getMapa(x - 1, y - 1).setPocet((int)(mapa.getMapa(x - 2, y - 1).getSila() * mapa.getMapa(x - 1, y - 1).getObrana() * (mapa.getMapa(x - 2, y - 1).getPocetPomocny() / 500)));
                                double pocet2 = mapa.getMapa(x - 2, y - 1).setPocet((int)(1.5 * mapa.getMapa(x - 1, y - 1).getSila() * mapa.getMapa(x - 2, y - 1).getObrana() * (mapa.getMapa(x - 1, y - 1).getPocetPomocny() / 500)));
                                JOptionPane.showMessageDialog(null, "Stav jednotiek po boji: \n" + nastavovanie.rozoznaj(x, y, mapa) + " SILNEJSI UTOK" + "\n" + mapa.getMapa(x - 1, y - 1).dajPopis() + "\n \n" + nastavovanie.rozoznaj(x - 1, y, mapa) + "\n" + mapa.getMapa(x - 2, y - 1).dajPopis());
                                mapa.getMapa(x - 1, y - 1).setPocetPomocny(pocet1);
                                mapa.getMapa(x - 2, y - 1).setPocetPomocny(pocet2);
                            } else {
                                System.out.println("Vydarilo sa 3");
                                double pocet1 = mapa.getMapa(x - 1, y - 1).setPocet((int)(mapa.getMapa(x - 2, y - 1).getSila() * mapa.getMapa(x - 1, y - 1).getObrana() * (mapa.getMapa(x - 2, y - 1).getPocetPomocny() / 500)));
                                double pocet2 = mapa.getMapa(x - 2, y - 1).setPocet((int)(mapa.getMapa(x - 1, y - 1).getSila() * mapa.getMapa(x - 2, y - 1).getObrana() * (mapa.getMapa(x - 1, y - 1).getPocetPomocny() / 500)));
                                JOptionPane.showMessageDialog(null, "Stav jednotiek po boji: \n" + nastavovanie.rozoznaj(x, y, mapa) + "\n" + mapa.getMapa(x - 1, y - 1).dajPopis() + "\n \n" + nastavovanie.rozoznaj(x - 1, y, mapa) + "\n" + mapa.getMapa(x - 2, y - 1).dajPopis());
                                mapa.getMapa(x - 1, y - 1).setPocetPomocny(pocet1);
                                mapa.getMapa(x - 2, y - 1).setPocetPomocny(pocet2);
                            }
                        }
                        if (mapa.getMapa(x - 1, y - 1).getPocet() <= 0) {
                            mapa.setMapa(x - 1, y - 1, null);
                            Obdlznik obdlznik = new Obdlznik();
                            obdlznik.zmenStrany(this.strana, this.strana);
                            obdlznik.zmenPolohu((x + 1) * (this.strana + 1), (y + 1) * (this.strana + 1));
                            obdlznik.zmenFarbu("green");
                            obdlznik.zobraz();
                        }
                        if (mapa.getMapa(x - 2, y - 1).getPocet() <= 0) {
                            mapa.setMapa(x - 2, y - 1, null);
                            Obdlznik obdlznik = new Obdlznik();
                            obdlznik.zmenStrany(this.strana, this.strana);
                            obdlznik.zmenPolohu((x) * (this.strana + 1), (y + 1) * (this.strana + 1));
                            obdlznik.zmenFarbu("green");
                            obdlznik.zobraz();
                        }
                    }
                }
            }
        } catch (NullPointerException npex) {

        }
        return pomoc;

    }
}
