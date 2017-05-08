/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfejs;

import wirtualnySwiat.Swiat;
import wirtualnySwiat.Organizm;
import javax.swing.*;
import java.awt.GridLayout;

/**
 *
 * @author admin
 */
public class Krata  extends JPanel
{
    private final PanelSwiata[][] tab;
    
    final int WIELKOSC_PLANSZY = 225; 
    private final int rozmiarX;
    private final int rozmiarY;
    
    public Krata(Swiat swiat, int szerokosc, int wysokosc)
    {
        swiat.ustawWymiarySwiata(szerokosc, wysokosc);
        
        rozmiarX = szerokosc;
        rozmiarY = wysokosc;
        
        setLayout(new GridLayout(szerokosc, wysokosc, 2, 2));
        this.tab= new PanelSwiata[szerokosc][wysokosc];
        
        for(int y=0; y<wysokosc; y++)
        {
            for(int x=0; x<szerokosc; x++)
            {
                tab[x][y]=new PanelSwiata(swiat, x,y);
                add(tab[x][y]);
            }
        }
    }
    
    
    public void ustawPoleTekstowe(String znak, int x, int y) {
        tab[x][y].ustawIkone(znak);
    }
    
    
    public void wyczyscKrate(Swiat swiat) {
        for(int y=0; y<rozmiarY; y++) {
            for(int x=0; x<rozmiarX; x++) {
                tab[x][y].wyczyscPole();
            }
        }
    }
    
    
    public int podajSzerokoscKraty()
    {
        return rozmiarX;
    }
    
    public int podajWysokoscKraty()
    {
        return rozmiarY;
    }
}
