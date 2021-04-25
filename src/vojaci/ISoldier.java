/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vojaci;

import prostredieHerne.Mapa;

/**
 * Trieda ISoldier je interface vojenskych jednotiek.
 * 
 * @author Samuel Vasecka
 * @version 2019.05.14
 */
public interface ISoldier {

    int getCode();
    @Override
    String toString();
    void setJeVBoji(boolean jeVBoji);
    boolean isJeVBoji();
    int boj(int x, int y, Mapa mapa, boolean identifikator);
    String dajPopis();
    double getPocet();
    int setPocet(int pocet);
    int getDosah();
    double getMoralka();
    void setUzBojoval(boolean uzBojoval);
    boolean isUzBojoval();
    void setPolohaX(int polohaX);
    void setPolohaY(int polohaY);
    int getPolohaX();
    int getPolohaY();
    double getObrana();
    void setObrana(double obrana);
    void setPripravenaObrana(boolean pripravenaObrana);
    boolean isPripravenaObrana();
    void setDosah();    
}
