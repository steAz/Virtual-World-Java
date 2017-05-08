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
class Mlecz extends Roslina {
     Mlecz(int x, int y, int sila, int inicjatywa, String znaczek) {
        this.x = x;
        this.y = y;
        this.sila = sila;
        this.inicjatywa = inicjatywa;
        this.znak = znaczek;
        this.wiek = 1;
    }
     
     
     @Override
    void akcja(Swiat swiat, Kierunek kierunek) {
        Random generator = new Random();
        
        for (int i = 0; i < 3; i++) {
            int procent = generator.nextInt(100);
            int prawdopodobienstwo = generator.nextInt(10);
        
            if (procent < prawdopodobienstwo) {  
                int losuj = generator.nextInt(8);
        
                int dx;
                int dy;
        
                switch (losuj) {
                    case 0:
                        dx = -1;
                        dy = 0;
                
                        if(!czySciana(swiat, this.x + dx, this.y + dy)) {
                        swiat.dodajOrganizm(this.x + dx, this.y + dy, this.podajZnak());
                        }
                
                        break;
                
                    case 1:
                        dx = -1;
                        dy = -1;
                
                        if(!czySciana(swiat, this.x + dx, this.y + dy)) {
                        swiat.dodajOrganizm(this.x + dx, this.y + dy, this.podajZnak());
                        }
                
                        break;
                
                    case 2:
                        dx = 0;
                        dy = -1;
                
                        if(!czySciana(swiat, this.x + dx, this.y + dy)) {
                        swiat.dodajOrganizm(this.x + dx, this.y + dy, this.podajZnak());
                        }
                
                        break;
                
                    case 3:
                        dx = 1;
                        dy = -1;
                
                        if(!czySciana(swiat, this.x + dx, this.y + dy)) {
                        swiat.dodajOrganizm(this.x + dx, this.y + dy, this.podajZnak());
                        }
                
                        break;
                
                    case 4:
                        dx = 1;
                        dy = 0;
                
                        if(!czySciana(swiat, this.x + dx, this.y + dy)) {
                        swiat.dodajOrganizm(this.x + dx, this.y + dy, this.podajZnak());
                        }
                
                        break;
                
                    case 5:
                        dx = 1;
                        dy = 1;
                
                        if(!czySciana(swiat, this.x + dx, this.y + dy)) {
                        swiat.dodajOrganizm(this.x + dx, this.y + dy, this.podajZnak());
                        }
                
                        break;
                
                    case 6:
                        dx = 0;
                        dy = 1;
                
                        if(!czySciana(swiat, this.x + dx, this.y + dy)) {
                        swiat.dodajOrganizm(this.x + dx, this.y + dy, this.podajZnak());
                        }
                
                        break;
                
                    case 7:
                        dx = -1;
                        dy = 1;
                
                        if(!czySciana(swiat, this.x + dx, this.y + dy)) {
                        swiat.dodajOrganizm(this.x + dx, this.y + dy, this.podajZnak());
                        }
                
                        break;
                }
            }
        }
    }
}
