/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wirtualnySwiat;

import Interfejs.Ramka;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import javax.swing.*;
import java.util.*;

/**
 *
 * @author admin
 */
public final class Swiat {
    Ramka ramka;
    
    private int szerokosc;
    private int wysokosc;
    final int WIELKOSC_PLANSZY = 2022;
    private int tura;
    boolean czyCzlowiekZywy;
    int licznik;
    
    public Organizm[] organizmy;
    
    
    Swiat()
    {
        this.tura = 0;
        this.organizmy = null;
        
        this.organizmy = new Organizm[WIELKOSC_PLANSZY + 1];
        
        for (int i = 0; i < WIELKOSC_PLANSZY + 1; i++) {
            this.organizmy[i] = null;
        }
        
       // this.dodajOrganizm(2, 2, "Owca");
        this.dodajOrganizm(5, 5, "Czlowiek");
        this.dodajOrganizm(5, 7, "Guarana");
        this.dodajOrganizm(7, 3, "Wilk");
        this.dodajOrganizm(8, 2, "Wilk");
        this.dodajOrganizm(8, 3, "Wilk");
        this.dodajOrganizm(1, 1, "Zolw");
         this.dodajOrganizm(18, 18, "WilczeJagody");
      
       // this.dodajOrganizm(19, 0, "Trawa");
        
        czyCzlowiekZywy = true;
    }
    
    
    boolean weryfikacja(int x, int y) {
        return !(x < 9 || y < 9);
    }
 
    void menu(int x, int y)
    {          
        try {
            if (!weryfikacja(x, y)) throw new ZlyRozmiarMapy("Probujesz ustawic rozmiar planszy o zlych rozmiarach");
                    
            ramka = new Ramka(this, x, y);
            }catch (ZlyRozmiarMapy zlyRozmiarMapy) {
                zlyRozmiarMapy.printStackTrace();
            }  
    }
    
    
    
    public void zapisz() throws FileNotFoundException
    {
        PrintWriter plik = new PrintWriter("zapisany.txt");
        
        plik.print(this.podajTure() + String.format("%n"));
        
        for (int i = 0; i < WIELKOSC_PLANSZY + 1; i++) {
            if (this.organizmy[i] != null) {
                plik.print(this.organizmy[i].podajZnak() + " " + this.organizmy[i].podajWiek() + " " + this.organizmy[i].podajSile() + " " + this.organizmy[i].podajInicjatywe() + " " + this.organizmy[i].x + " " + this.organizmy[i].y + " ");
                
                if(this.organizmy[i] instanceof Czlowiek) {
                    plik.print(this.organizmy[i].podajIloscTurOdSpecjUm());
                }
                
                plik.print(String.format("%n"));
            }else {
                plik.print("X" + String.format("%n"));
            }
        }
        
        plik.close();
    }
    
    
   public void wczytaj() throws FileNotFoundException {
        File plik = new File("zapisany.txt");
        Scanner scanner;
        
        try {
            scanner = new Scanner(plik);
        } catch(FileNotFoundException wyjatek) {
            wyjatek.printStackTrace();
            return;
        }
       
        this.organizmy = null;
        this.organizmy = new Organizm[WIELKOSC_PLANSZY + 1];
        
        for (int i = 0; i < WIELKOSC_PLANSZY + 1; i++) {
            this.organizmy[i] = null;
        }
        
        String znak;
        int x, y, wiek, inicjatywa, sila, iloscTurOdSpecjUm;
        
        this.tura = scanner.nextInt();
        
        for (int i = 0; i < WIELKOSC_PLANSZY + 1; i++) {
            znak = scanner.next();
            
            if (znak.equals("Czlowiek")) {
                wiek = scanner.nextInt();
                sila = scanner.nextInt();
                inicjatywa = scanner.nextInt();
                x = scanner.nextInt();
                y = scanner.nextInt();
                iloscTurOdSpecjUm = scanner.nextInt();
                dodajOrganizm(x, y, znak);
                organizmy[WIELKOSC_PLANSZY].ustawInicjatywe(inicjatywa);
                organizmy[WIELKOSC_PLANSZY].ustawWiek(wiek);
                organizmy[WIELKOSC_PLANSZY].ustawSile(sila);
                organizmy[WIELKOSC_PLANSZY].ustawIloscTurOdSpecjUm(iloscTurOdSpecjUm);
            }
            else if(!znak.equals("Czlowiek") && !znak.equals("X")) {
                wiek = scanner.nextInt();
                sila = scanner.nextInt();
                inicjatywa = scanner.nextInt();
                x = scanner.nextInt();
                y = scanner.nextInt();
                dodajOrganizm(x, y, znak);
                int nrOrganizmu = (x * 100) + y;
                organizmy[nrOrganizmu].ustawInicjatywe(inicjatywa);
		organizmy[nrOrganizmu].ustawWiek(wiek);
		organizmy[nrOrganizmu].ustawSile(sila);
            }
            else {
                
            }
        }
        
        ramka.wyczyscPlansze();
        this.rysujOrganizmy();
    }
    
    
    public boolean podajCzyCzlowiekZywy() {
        return czyCzlowiekZywy;
    }
    
    
   public void rysujOrganizmy() {  
        for(int i = 0; i < WIELKOSC_PLANSZY + 1; i++) {
            if (organizmy[i] != null) {
                ramka.ustawPoleKratki(organizmy[i].podajZnak(), organizmy[i].x, organizmy[i].y);
            }
        }
    }
    
   
    int podajWysokosc() {
        return this.wysokosc;
    }
    
    
    int podajSzerokosc() {
        return this.szerokosc;
    }
    
    
    public Organizm dodajOrganizm(int x, int y, String znak) {
        int nrOrganizmu = (x * 100) + y;
        
        Organizm organizm;
        organizm = null;
        
        try {
            switch(znak) {
                case "Czlowiek":
                    organizm = new Czlowiek(x, y, 5, 4, "Czlowiek");
                    break;
            
                case "Wilk":
                    organizm = new Wilk(x, y, 9, 5, "Wilk");
                    break;
                    
                case "Antylopa":
                    organizm = new Antylopa(x, y, 4, 4, "Antylopa");
                    break;
                    
                case "Owca":
                    organizm = new Owca(x, y, 4, 4, "Owca");
                    break;
                    
                case "Lis":
                    organizm = new Lis(x, y, 3, 7, "Lis");
                    break;
                    
                case "Zolw":
                    organizm = new Zolw(x, y, 2, 1, "Zolw");
                    break;
                    
                case "Trawa":
                    organizm = new Trawa(x, y, 0, 0, "Trawa");
                    break;
                    
                case "Mlecz":
                    organizm = new Mlecz(x, y, 0, 0, "Mlecz");
                    break;    
                    
                case "Guarana":
                    organizm = new Guarana(x, y, 0, 0, "Guarana");
                    break;  
                    
                case "WilczeJagody":
                    organizm = new WilczeJagody(x, y, 99, 0, "WilczeJagody");
                    break;  
                   
                default:
                    throw new ZlyZnakWyjatek("Probujesz dodac organizm o nieprawidlowym znaku");  
            }
        }catch (ZlyZnakWyjatek zlyZnak) {
            zlyZnak.printStackTrace();
            return null;
        }
        
        if(znak.equals("Czlowiek")) organizm.ustawNumerOrganizmu(WIELKOSC_PLANSZY);
        else organizm.ustawNumerOrganizmu(nrOrganizmu);
        
            
        this.organizmy[organizm.podajNumerOrganizmu()] = organizm;
        this.organizmy[organizm.podajNumerOrganizmu()].ustawWiek(1);
        
        return organizm;
    }
    
    
    int podajNajwiekszaInicjatywe() {
        int najwiekszaInicjatywa = 1;
        boolean czyPierwszaZnalezionaInicjatywa = true;
        
        for (int i = 0; i < WIELKOSC_PLANSZY + 1; i++) {
            if (organizmy[i] != null) {
                if (czyPierwszaZnalezionaInicjatywa) {
                    najwiekszaInicjatywa = organizmy[i].podajInicjatywe();
                    czyPierwszaZnalezionaInicjatywa = false;
                }
                
                if (organizmy[i].podajInicjatywe() > najwiekszaInicjatywa) {
                    najwiekszaInicjatywa = organizmy[i].podajInicjatywe();
                }
            }
        }
        
        return najwiekszaInicjatywa;
    }
    
    
    int podajNajstarszyWiek() {
         int najstarszyWiek = 1;
        boolean czyPierwszyZnalezionyWiek = true;
        
        for (int i = 0; i < WIELKOSC_PLANSZY + 1; i++) {
            if (organizmy[i] != null) {
                if (czyPierwszyZnalezionyWiek ) {
                    najstarszyWiek = organizmy[i].podajWiek();
                    czyPierwszyZnalezionyWiek  = false;
                }
                
                if (organizmy[i].podajWiek() > najstarszyWiek) {
                    najstarszyWiek = organizmy[i].podajWiek();
                }
            }
        }
        
        return najstarszyWiek;
    }
    
    
    Organizm organizmOtejSamejInicjatywie(Organizm sprawdzanyOrganizm) {
        for (int i = 0; i < WIELKOSC_PLANSZY + 1; i++) {
            if (organizmy[i] != null && !organizmy[i].podajZnak().equals(sprawdzanyOrganizm.podajZnak()) &&  !organizmy[i].podajZnak().equals("Czlowiek")) { //nie trzeba sprawdzac org o tym samym typie i nie moze to byc czlowiek, bo przy znalezeniu tego o tej samej inicjatywie bedzie sie zle poruszal
                if (organizmy[i].podajInicjatywe() == sprawdzanyOrganizm.podajInicjatywe()) {
                    return organizmy[i];
                }
            }
        }
        return null;
    }
    
    
    void dodajWiek() {
        for (int i = 0; i < WIELKOSC_PLANSZY + 1; i++) {
            if (organizmy[i] != null) {
                this.organizmy[i].dodajWiek();
            }
        }
    }
    
    
    void dodajTure() {
        this.tura += 1;
    }
    
    
    public int podajTure() {
        return this.tura;
    }
    
    
    private void wykonajKolizje() {
        for (int i = 0; i < WIELKOSC_PLANSZY + 1; i++) {
            if(organizmy[i] != null) {
                if (organizmy[i].czyRozmnazac == true) {
                    organizmy[i].kolizja(ramka, this, true);
                }
                else {
                    organizmy[i].kolizja(ramka, this, false);
                }
            }
        }
    }
    
    
   public void wykonajTure(KeyEvent przycisk) {
        Organizm.Kierunek kierunekCzlowieka;
       
        
       switch (przycisk.getKeyCode()) {
           case KeyEvent.VK_UP:
               kierunekCzlowieka = Organizm.Kierunek.UP;
               break;
               
            case KeyEvent.VK_DOWN:
               kierunekCzlowieka = Organizm.Kierunek.DOWN;
               break;
               
            case KeyEvent.VK_LEFT:
               kierunekCzlowieka = Organizm.Kierunek.LEFT;
               break;
               
            case KeyEvent.VK_RIGHT:
               kierunekCzlowieka = Organizm.Kierunek.RIGHT;
               break;
               
            default:
                kierunekCzlowieka = null;
                break;
       }
       
        
        
       int najwiekszaInicjatywa = podajNajwiekszaInicjatywe();
        
         for (int i = 0; i < WIELKOSC_PLANSZY + 1; i++) {
             Organizm organizm = null;
             
            if (organizmy[i] != null) {
                if (najwiekszaInicjatywa == organizmy[i].podajInicjatywe()) {
                    if (organizmOtejSamejInicjatywie(organizmy[i]) != null) {
                        organizm = organizmOtejSamejInicjatywie(organizmy[i]);
                        
                        if (organizm.podajWiek() > organizmy[i].podajWiek()) {
                            if (organizm instanceof Czlowiek) {
                                if(czyCzlowiekZywy) {
                                    organizm.akcja(this, kierunekCzlowieka); // pierwszy rusza sie ten z wiekszym wiekiem
                                    organizmy[i].akcja(this, Organizm.Kierunek.LOSOWY);
                                }
                            }else {
                                organizm.akcja(this, Organizm.Kierunek.LOSOWY); // pierwszy rusza sie ten z wiekszym wiekiem
                                organizmy[i].akcja(this, Organizm.Kierunek.LOSOWY);
                            }
                        }else {
                            if(organizmy[i] instanceof Czlowiek) {
                                if(czyCzlowiekZywy) {
                                    organizmy[WIELKOSC_PLANSZY].akcja(this, kierunekCzlowieka);
                                }
                            }else {
                                organizmy[i].akcja(this, Organizm.Kierunek.LOSOWY);
                            }
                        }
                    }
                    
                    else if(organizmOtejSamejInicjatywie(organizmy[i]) == null) {
                        if (organizmy[i] instanceof Czlowiek) {
                            if(czyCzlowiekZywy) {
                                organizmy[WIELKOSC_PLANSZY].akcja(this, kierunekCzlowieka);
                            }
                        }else {
                            organizmy[i].akcja(this, Organizm.Kierunek.LOSOWY);
                        } 
                    }
                }
            }
            
            if (i == WIELKOSC_PLANSZY) {
                najwiekszaInicjatywa -= 1;
                
                if (najwiekszaInicjatywa != -1) { // algorytm powtarza petle(zmieniamy 'i' na 0, gdy 'i' bedzie rowne wartosci ostatniej iteracji petli) i zmniejsza inicjatywe do czasu, gdy inicjatywa osiagnie wartosc 0 (wtedy nie ma juz czego sprawdzac)
                    i = 0;
                }
            }
         }
        
        
         dodajWiek();
         
         
         wykonajKolizje();
         
         if (organizmy[WIELKOSC_PLANSZY] != null) {
             if(organizmy[WIELKOSC_PLANSZY].podajCzySzybkoscAntylopyON()) {
                 organizmy[WIELKOSC_PLANSZY].dodajIloscTurOdSpecjUm();
                 
                 if (organizmy[WIELKOSC_PLANSZY].podajIloscTurOdSpecjUm() >= 5) {
                     organizmy[WIELKOSC_PLANSZY].ustawCzyMoznaWlSpecjUm(false);
                     organizmy[WIELKOSC_PLANSZY].ustawCzySzybkAntylopyON(false);
                     organizmy[WIELKOSC_PLANSZY].ustawIloscTurOdSpecjUm(0);
                 }
             }
             
             else if (!organizmy[WIELKOSC_PLANSZY].podajCzySzybkoscAntylopyON() && !organizmy[WIELKOSC_PLANSZY].podajCzyMoznaWlSpecjUm()) {
                 organizmy[WIELKOSC_PLANSZY].dodajIloscTurOdSpecjUm();
                 
                 if(organizmy[WIELKOSC_PLANSZY].podajIloscTurOdSpecjUm() >= 5) {
                     organizmy[WIELKOSC_PLANSZY].ustawCzyMoznaWlSpecjUm(true);
                     organizmy[WIELKOSC_PLANSZY].ustawIloscTurOdSpecjUm(0);
                 }
             }
         }
         
         ramka.wyczyscPlansze();
         
         dodajTure();
         ramka.wyswietlajRezultaty(); 
         
         rysujOrganizmy();
   }
   
   
   public void wykonajTureBezCzlowieka(ActionEvent event) {
        Organizm.Kierunek kierunekCzlowieka = null;
       
        
       
       int najwiekszaInicjatywa = podajNajwiekszaInicjatywe();
        
         for (int i = 0; i < WIELKOSC_PLANSZY + 1; i++) {
             Organizm organizm = null;
             
            if (organizmy[i] != null) {
                if (najwiekszaInicjatywa == organizmy[i].podajInicjatywe()) {
                    if (organizmOtejSamejInicjatywie(organizmy[i]) != null) {
                        organizm = organizmOtejSamejInicjatywie(organizmy[i]);
                        
                        if (organizm.podajWiek() > organizmy[i].podajWiek()) {
                            if (organizm instanceof Czlowiek) {
                                if(czyCzlowiekZywy) {
                                    organizm.akcja(this, kierunekCzlowieka); // pierwszy rusza sie ten z wiekszym wiekiem
                                    organizmy[i].akcja(this, Organizm.Kierunek.LOSOWY);
                                }
                            }else {
                                organizm.akcja(this, Organizm.Kierunek.LOSOWY); // pierwszy rusza sie ten z wiekszym wiekiem
                                organizmy[i].akcja(this, Organizm.Kierunek.LOSOWY);
                            }
                        }else {
                            if(organizmy[i] instanceof Czlowiek) {
                                if(czyCzlowiekZywy) {
                                    organizmy[WIELKOSC_PLANSZY].akcja(this, kierunekCzlowieka);
                                }
                            }else {
                                organizmy[i].akcja(this, Organizm.Kierunek.LOSOWY);
                            }
                        }
                    }
                    
                    else if(organizmOtejSamejInicjatywie(organizmy[i]) == null) {
                        if (organizmy[i] instanceof Czlowiek) {
                            if(czyCzlowiekZywy) {
                                organizmy[WIELKOSC_PLANSZY].akcja(this, kierunekCzlowieka);
                            }
                        }else {
                            organizmy[i].akcja(this, Organizm.Kierunek.LOSOWY);
                        } 
                    }
                }
            }
            
            if (i == WIELKOSC_PLANSZY) {
                najwiekszaInicjatywa -= 1;
                
                if (najwiekszaInicjatywa != -1) { // algorytm powtarza petle(zmieniamy 'i' na 0, gdy 'i' bedzie rowne wartosci ostatniej iteracji petli) i zmniejsza inicjatywe do czasu, gdy inicjatywa osiagnie wartosc 0 (wtedy nie ma juz czego sprawdzac)
                    i = 0;
                }
            }
         }
         

       /*
       for(int i = 0; i < WIELKOSC_PLANSZY + 1; i++) {
             Organizm organizm;
             
            if (organizmy[i] != null) {
                if(organizmy[i] instanceof Czlowiek) {
                    organizmy[i].akcja(this, organizmy[i], kierunekCzlowieka);
                }else {
                organizmy[i].akcja(this, organizmy[i], Organizm.Kierunek.LOSOWY);
                }
            }
       }
*/
         
         
        ramka.wyczyscPlansze();
        ramka.wyswietlajRezultaty(); 
        
         dodajWiek();
         wykonajKolizje();
         
         ramka.wyczyscPlansze();
         
         dodajTure();
         rysujOrganizmy();
   }
   
   
   
   public void ustawWymiarySwiata(int szerokosc, int wysokosc) {
       this.szerokosc = szerokosc;
       this.wysokosc = wysokosc;
   }
  
}


