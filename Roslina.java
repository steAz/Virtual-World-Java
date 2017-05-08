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
class Roslina extends Organizm {
    Kierunek kierunek;
    
    
    
    boolean czyZnalezionyOrganizmOtychWspol(Swiat swiat, Organizm sprawdzanyOrganizm, int dx, int dy) {
        for (int i = 0; i < WIELKOSC_PLANSZY + 1; i++) {
            if (swiat.organizmy[i] != null && sprawdzanyOrganizm != swiat.organizmy[i]) {
                if (sprawdzanyOrganizm.x + dx == swiat.organizmy[i].x && sprawdzanyOrganizm.y + dy == swiat.organizmy[i].y) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    
    @Override
    void akcja(Swiat swiat, Kierunek kierunek) {
        Random generator = new Random();
        
        int procent = generator.nextInt(100);
        int prawdopodobienstwo = generator.nextInt(15);
        
        if (procent < prawdopodobienstwo) {  
        int losuj = generator.nextInt(8);
        
        int dx;
        int dy;
        
        switch (losuj) {
            case 0:
                dx = -1;
                dy = 0;
                
                    if(!czyZnalezionyOrganizmOtychWspol(swiat, this, dx, dy) && !czySciana(swiat, this.x + dx, this.y + dy)) {
                    swiat.dodajOrganizm(this.x + dx, this.y + dy, this.podajZnak());
                    }
                
                break;
                
            case 1:
                dx = -1;
                dy = -1;
                
                if(!czyZnalezionyOrganizmOtychWspol(swiat, this, dx, dy) && !czySciana(swiat, this.x + dx, this.y + dy)) {
                swiat.dodajOrganizm(this.x + dx, this.y + dy, this.podajZnak());
                }
                
                break;
                
            case 2:
                dx = 0;
                dy = -1;
                
                if(!czyZnalezionyOrganizmOtychWspol(swiat, this, dx, dy) && !czySciana(swiat, this.x + dx, this.y + dy)) {
                swiat.dodajOrganizm(this.x + dx, this.y + dy, this.podajZnak());
                }
                
                break;
                
            case 3:
                dx = 1;
                dy = -1;
                
                if(!czyZnalezionyOrganizmOtychWspol(swiat, this, dx, dy) && !czySciana(swiat, this.x + dx, this.y + dy)) {
                swiat.dodajOrganizm(this.x + dx, this.y + dy, this.podajZnak());
                }
                
                break;
                
            case 4:
                dx = 1;
                dy = 0;
                
                if(!czyZnalezionyOrganizmOtychWspol(swiat, this, dx, dy) && !czySciana(swiat, this.x + dx, this.y + dy)) {
                swiat.dodajOrganizm(this.x + dx, this.y + dy, this.podajZnak());
                }
                
                break;
                
            case 5:
                dx = 1;
                dy = 1;
                
                if(!czyZnalezionyOrganizmOtychWspol(swiat, this, dx, dy) && !czySciana(swiat, this.x + dx, this.y + dy)) {
                swiat.dodajOrganizm(this.x + dx, this.y + dy, this.podajZnak());
                }
                
                break;
                
            case 6:
                dx = 0;
                dy = 1;
                
                if(!czyZnalezionyOrganizmOtychWspol(swiat, this, dx, dy) && !czySciana(swiat, this.x + dx, this.y + dy)) {
                swiat.dodajOrganizm(this.x + dx, this.y + dy, this.podajZnak());
                }
                
                break;
                
            case 7:
                dx = -1;
                dy = 1;
                
                if(!czyZnalezionyOrganizmOtychWspol(swiat, this, dx, dy) && !czySciana(swiat, this.x + dx, this.y + dy)) {
                swiat.dodajOrganizm(this.x + dx, this.y + dy, this.podajZnak());
                }
                
                break;
        }
      
        }
    }

    
    @Override
    void kolizja(Ramka ramka, Swiat swiat, boolean czyRozmnazac) {
       
    }
    
    
    
}
