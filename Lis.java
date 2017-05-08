/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wirtualnySwiat;

import java.util.Random;

/**
 *
 * @author admin
 */
class Lis extends Zwierze {
    Lis(int x, int y, int sila, int inicjatywa, String znaczek) {
        this.x = x;
        this.y = y;
        this.sila = sila;
        this.inicjatywa = inicjatywa;
        this.znak = znaczek;
        this.wiek = 1;
    }
    
    
    boolean czyObokSilniejszyPrzeciwnik(Swiat swiat, Kierunek kierunek, int dx, int dy) {
        for (int i = 0; i < WIELKOSC_PLANSZY + 1; i++) {
            if (swiat.organizmy[i] != null) {
                if (this.podajSile() < swiat.organizmy[i].podajSile()) {
                    if((this.x + dx == swiat.organizmy[i].x) && (this.y + dy == swiat.organizmy[i].y)) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    
    @Override
    void idz(Swiat swiat, Kierunek kierunek, int dx, int dy) {
        this.kierunek = kierunek;
        
        if(czyMozeIsc(swiat, dx, dy)) {
            if(!czySciana(swiat, this.x + dx, this.y + dy)) {
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
                if(!czyObokSilniejszyPrzeciwnik(swiat, kierunek, 0, -1)) idz(swiat, Kierunek.UP, 0, -1);
                break;
                
            case 1:
                if(!czyObokSilniejszyPrzeciwnik(swiat, kierunek, 0, 1)) idz(swiat, Kierunek.UP, 0, 1);
                break;
                
            case 2:
                if(!czyObokSilniejszyPrzeciwnik(swiat, kierunek, 1, 0)) idz(swiat, Kierunek.UP, 1, 0);
                break;
                
            case 3:
                if(!czyObokSilniejszyPrzeciwnik(swiat, kierunek, -1, 0)) idz(swiat, Kierunek.UP, -1, 0);
                break;
        }
    }
}
