/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wirtualnySwiat;

import Interfejs.Ramka;
import java.util.Random;

/**
 *
 * @author admin
 */
class Antylopa extends Zwierze {
    Antylopa(int x, int y, int sila, int inicjatywa, String znaczek) {
        this.x = x;
        this.y = y;
        this.sila = sila;
        this.inicjatywa = inicjatywa;
        this.znak = znaczek;
        this.wiek = 1;
    }
    
    
    @Override
    void idz(Swiat swiat, Kierunek kierunek, int dx, int dy) {
        this.kierunek = kierunek;
        
        switch(kierunek) {
            case UP:
                dy = -2;
                break;
                
            case DOWN:
                dy = 2;
                break;
                
            case RIGHT:
                dx = 2;
                break;
                
            case LEFT:
                dx = -2;
                break;
        }
        
        if(czyMozeIsc(swiat, dx, dy)) {
            if(!czySciana(swiat, this.x + dx, this.y + dy))
            {
                this.poprzednieX = x;
                this.poprzednieY = y;
                
                this.czyRozmnazac = false;
                this.x += dx;
                this.y += dy;
            }
        }
        else if(!czyMozeIsc(swiat, dx ,dy)) {
            this.czyRozmnazac = true;
        }
        
    }
    
    
    @Override
    void akcja(Swiat swiat, Kierunek kierunek) {
        Random generator = new Random();
        int losuj = generator.nextInt(4);
        
        switch (losuj) {
            case 0:
                idz(swiat, Kierunek.UP, 0, 0);
                break;
                
            case 1:
                idz(swiat, Kierunek.DOWN, 0, 0);
                break;
                
            case 2:
                idz(swiat, Kierunek.RIGHT, 0, 0);
                break;
                
            case 3:
                idz(swiat, Kierunek.LEFT, 0, 0);
                break;
        }
    }
    
    
     @Override
    void kolizja(Ramka ramka, Swiat swiat, boolean czyRozmnazac) {
        if (this.czyRozmnazac) {
            int dx;
            int dy;
            
            int losuj = 0;
            
            if (losuj == 0) {
                dx = 1;
                dy = 0;
                
                if (!czyZnalezionyOrganizmOtychWspol(swiat, this, dx, dy) && !czySciana(swiat, this.x + dx, this.y + dy)) swiat.dodajOrganizm(this.x + dx, this.y + dy, this.podajZnak());
                else losuj++;
            }
            
            if (losuj == 1) {
                dx = 1;
                dy = -1;
                
                if (!czyZnalezionyOrganizmOtychWspol(swiat, this, dx, dy) && !czySciana(swiat, this.x + dx, this.y + dy)) swiat.dodajOrganizm(this.x + dx, this.y + dy, this.podajZnak());
                else losuj++;
            }
            
            if (losuj == 2) {
                dx = 0;
                dy = -1;
                
                if (!czyZnalezionyOrganizmOtychWspol(swiat, this, dx, dy) && !czySciana(swiat, this.x + dx, this.y + dy)) swiat.dodajOrganizm(this.x + dx, this.y + dy, this.podajZnak());
                else losuj++;
            }
            
            if (losuj == 3) {
                dx = -1;
                dy = -1;
                
                if (!czyZnalezionyOrganizmOtychWspol(swiat, this, dx, dy) && !czySciana(swiat, this.x + dx, this.y + dy)) swiat.dodajOrganizm(this.x + dx, this.y + dy, this.podajZnak());
                else losuj++;
            }
            
            if (losuj == 4) {
                dx = -1;
                dy = 0;
                
                if (!czyZnalezionyOrganizmOtychWspol(swiat, this, dx, dy) && !czySciana(swiat, this.x + dx, this.y + dy)) swiat.dodajOrganizm(this.x + dx, this.y + dy, this.podajZnak());
                else losuj++;
            }
            
            if (losuj == 5) {
                dx = -1;
                dy = 1;
                
                if (!czyZnalezionyOrganizmOtychWspol(swiat, this, dx, dy) && !czySciana(swiat, this.x + dx, this.y + dy)) swiat.dodajOrganizm(this.x + dx, this.y + dy, this.podajZnak());
                else losuj++;
            }
            
            if (losuj == 6) {
                dx = 0;
                dy = 1;
                
                if (!czyZnalezionyOrganizmOtychWspol(swiat, this, dx, dy) && !czySciana(swiat, this.x + dx, this.y + dy)) swiat.dodajOrganizm(this.x + dx, this.y + dy, this.podajZnak());
                else losuj++;
            }
            
            if (losuj == 7) {
                dx = 1;
                dy = 1;
                
                if (!czyZnalezionyOrganizmOtychWspol(swiat, this, dx, dy) && !czySciana(swiat, this.x + dx, this.y + dy)) swiat.dodajOrganizm(this.x + dx, this.y + dy, this.podajZnak());
            }
        }
            
        else if (!this.czyRozmnazac) {
            for (int i = 0; i < WIELKOSC_PLANSZY + 1; i++) {
                if (swiat.organizmy[i] != null) {
                    if (!this.podajZnak().equals(swiat.organizmy[i].podajZnak())) {
                        if (this.x == swiat.organizmy[i].x && this.y == swiat.organizmy[i].y) {
                            if (swiat.organizmy[i].podajZnak().equals("Guarana") || swiat.organizmy[i].podajZnak().equals("Trawa") || swiat.organizmy[i].podajZnak().equals("Mlecz") || swiat.organizmy[i].podajZnak().equals("WilczeJagody")) {
                                if (swiat.organizmy[i].podajZnak().equals("Guarana")) {
                                    this.zwiekszSile(3);
                                    ramka.wyswietlajRezultatyJedzenia(this, swiat.organizmy[i]); 
                                    swiat.organizmy[i] = null; // usun zjedzona rosline
                                }
                                else if (swiat.organizmy[i].podajZnak().equals("WilczeJagody")) {
                                    ramka.wyswietlajRezultatyJedzenia(this, swiat.organizmy[i]); 
                                    swiat.organizmy[i] = null;
                                    usunOrganizm(this);
                                }
                                else {
                                    ramka.wyswietlajRezultatyJedzenia(this, swiat.organizmy[i]);    
                                    swiat.organizmy[i] = null; // usun zjedzona rosline
                                }
                            }
                            
                            else {
                                Random generator = new Random();
                                int procent = generator.nextInt(100);
                                
                                if (procent < 50) {
                                    if (swiat.organizmy[i].podajZnak().equals("Zolw")) {
                                        if (this.podajSile() < 5) {
                                            this.x = this.poprzednieX;
                                            this.y = this.poprzednieY;
                                        }
                                        else if (this.podajSile() > swiat.organizmy[i].podajSile() && this.podajSile() >= 5) {
                                            ramka.wyswietlajRezultatyWalki(this, swiat.organizmy[i]);
                                            swiat.organizmy[i] = null;
                                        }
                                        else if (this.podajSile() < swiat.organizmy[i].podajSile()) {
                                            ramka.wyswietlajRezultatyWalki(swiat.organizmy[i], this);
                                            usunOrganizm(this);
                                        }
                                    }
                                    else if (this.podajSile() >= swiat.organizmy[i].podajSile()) {
                                        ramka.wyswietlajRezultatyWalki(this, swiat.organizmy[i]);
                                        swiat.organizmy[i] = null;
                                    }
                                    else if (this.podajSile() < swiat.organizmy[i].podajSile()) {
                                       ramka.wyswietlajRezultatyWalki(swiat.organizmy[i], this); 
                                       usunOrganizm(this);
                                    }
                                }
                                
                                else {
                                    int dx;
                                    int dy;
            
                                    int losuj = 0;
            
                                    if (losuj == 0) {
                                        dx = 1;
                                        dy = 0;
                
                                        if (!czyZnalezionyOrganizmOtychWspol(swiat, swiat.organizmy[i], dx, dy) && !czySciana(swiat, this.x + dx, this.y + dy)) {
                                            swiat.organizmy[i].x = swiat.organizmy[i].x + dx;
                                            swiat.organizmy[i].y = swiat.organizmy[i].y + dy;
                                        }else {
                                            losuj++;
                                        }
                                    }
            
                                    if (losuj == 1) {
                                        dx = 1;
                                        dy = -1;
                
                                        if (!czyZnalezionyOrganizmOtychWspol(swiat, swiat.organizmy[i], dx, dy) && !czySciana(swiat, this.x + dx, this.y + dy)) {
                                            swiat.organizmy[i].x = swiat.organizmy[i].x + dx;
                                            swiat.organizmy[i].y = swiat.organizmy[i].y + dy;
                                        }else {
                                            losuj++;
                                        }
                                    }
            
                                    if (losuj == 2) {
                                        dx = 0;
                                        dy = -1;
                
                                        if (!czyZnalezionyOrganizmOtychWspol(swiat, swiat.organizmy[i], dx, dy) && !czySciana(swiat, this.x + dx, this.y + dy)) {
                                            swiat.organizmy[i].x = swiat.organizmy[i].x + dx;
                                            swiat.organizmy[i].y = swiat.organizmy[i].y + dy;
                                        }else {
                                            losuj++;
                                        }
                                    }
            
                                    if (losuj == 3) {
                                        dx = -1;
                                        dy = -1;
                
                                        if (!czyZnalezionyOrganizmOtychWspol(swiat, swiat.organizmy[i], dx, dy) && !czySciana(swiat, this.x + dx, this.y + dy)) {
                                            swiat.organizmy[i].x = swiat.organizmy[i].x + dx;
                                            swiat.organizmy[i].y = swiat.organizmy[i].y + dy;
                                        }else {
                                            losuj++;
                                        }
                                    }
            
                                    if (losuj == 4) {
                                        dx = -1;
                                        dy = 0;
                
                                        if (!czyZnalezionyOrganizmOtychWspol(swiat, swiat.organizmy[i], dx, dy) && !czySciana(swiat, this.x + dx, this.y + dy)) {
                                            swiat.organizmy[i].x = swiat.organizmy[i].x + dx;
                                            swiat.organizmy[i].y = swiat.organizmy[i].y + dy;
                                        }else {
                                            losuj++;
                                        }
                                    }
            
                                    if (losuj == 5) {
                                        dx = -1;
                                        dy = 1;
                
                                        if (!czyZnalezionyOrganizmOtychWspol(swiat, swiat.organizmy[i], dx, dy) && !czySciana(swiat, this.x + dx, this.y + dy)) {
                                            swiat.organizmy[i].x = swiat.organizmy[i].x + dx;
                                            swiat.organizmy[i].y = swiat.organizmy[i].y + dy;
                                        }else {
                                            losuj++;
                                        }
                                    }
            
                                    if (losuj == 6) {
                                        dx = 0;
                                        dy = 1;
                
                                        if (!czyZnalezionyOrganizmOtychWspol(swiat, swiat.organizmy[i], dx, dy) && !czySciana(swiat, this.x + dx, this.y + dy)) {
                                            swiat.organizmy[i].x = swiat.organizmy[i].x + dx;
                                            swiat.organizmy[i].y = swiat.organizmy[i].y + dy;
                                        }else {
                                            losuj++;
                                        }
                                    }
            
                                    if (losuj == 7) {
                                        dx = 1;
                                        dy = 1;
                
                                        if (!czyZnalezionyOrganizmOtychWspol(swiat, swiat.organizmy[i], dx, dy) && !czySciana(swiat, this.x + dx, this.y + dy)) {
                                            swiat.organizmy[i].x = swiat.organizmy[i].x + dx;
                                            swiat.organizmy[i].y = swiat.organizmy[i].y + dy;
                                        }
                                    }
                                }
                            } 
                        }
                    }
                }
            }
        }
    }
}
