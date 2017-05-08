/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wirtualnySwiat;

import Interfejs.Ramka;

/**
 *
 * @author admin
 */
class Guarana extends Roslina {
     Guarana(int x, int y, int sila, int inicjatywa, String znaczek) {
        this.x = x;
        this.y = y;
        this.sila = sila;
        this.inicjatywa = inicjatywa;
        this.znak = znaczek;
        this.wiek = 1;
    }
     
     
    @Override
    void kolizja(Ramka ramka, Swiat swiat, boolean czyRozmnazac) {
       for (int i = 0; i < WIELKOSC_PLANSZY + 1; i++) {
           if (swiat.organizmy[i] != null) {
               if (!this.podajZnak().equals(swiat.organizmy[i].podajZnak()) && !swiat.organizmy[i].podajZnak().equals("Trawa") && !swiat.organizmy[i].podajZnak().equals("Mlecz") && !swiat.organizmy[i].podajZnak().equals("WilczeJagody")) {
                   if (this.x == swiat.organizmy[i].x && this.y == swiat.organizmy[i].y) {
                       ramka.wyswietlajRezultatyJedzenia(swiat.organizmy[i], this);
                       usunOrganizm(this);
                       // swiat.organizmy[i].zwiekszSile(3);
                   }
               }
           }
       }
    }
}
