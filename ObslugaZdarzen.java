/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfejs;

import wirtualnySwiat.Swiat;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author admin
 */
 public class ObslugaZdarzen implements KeyListener
   {
     private final Swiat swiat;
     final int WIELKOSC_PLANSZY = 2022;
     private Ramka ramka;
    // public KeyEvent event;
     
     ObslugaZdarzen(Swiat swiat, Ramka ramka) {
         this.swiat = swiat;
         this.ramka = ramka;
     }
     
        @Override
        public void keyPressed(KeyEvent przycisk) {
            
            ramka =(Ramka)przycisk.getSource();
        
            switch (przycisk.getKeyCode()) {
            
                case KeyEvent.VK_ESCAPE:
                    ramka.dispose();
                    return;
                
                case KeyEvent.VK_UP:
                    if(swiat.podajCzyCzlowiekZywy()) {
                        swiat.wykonajTure(przycisk);
                        
                         if(!swiat.podajCzyCzlowiekZywy()) {
                            ramka.dodajPrzyciskTury();
                        }
                    }
                   
                   // father.getWorldManager().executeTurn(new Coords(0,-1));
                    break;
                
                case KeyEvent.VK_DOWN:
                    if(swiat.podajCzyCzlowiekZywy()) {
                        swiat.wykonajTure(przycisk);
                        
                         if(!swiat.podajCzyCzlowiekZywy()) {
                            ramka.dodajPrzyciskTury();
                        }
                    }
                    break;
                
                case KeyEvent.VK_LEFT:
                    if(swiat.podajCzyCzlowiekZywy()) {
                        swiat.wykonajTure(przycisk);
                        
                         if(!swiat.podajCzyCzlowiekZywy()) {
                            ramka.dodajPrzyciskTury();
                        }
                    }
                    break;
                
                case KeyEvent.VK_RIGHT:
                    if(swiat.podajCzyCzlowiekZywy()) {
                        swiat.wykonajTure(przycisk);
                        
                         if(!swiat.podajCzyCzlowiekZywy()) {
                            ramka.dodajPrzyciskTury();
                        }
                    }
                    break;
                
                case KeyEvent.VK_X:  // SPECJALNA UMIEJETNOSC
                    if (swiat.organizmy[WIELKOSC_PLANSZY] != null) {
                        if (swiat.organizmy[WIELKOSC_PLANSZY].podajCzyMoznaWlSpecjUm()) {
                            swiat.organizmy[WIELKOSC_PLANSZY].ustawCzySzybkAntylopyON(true);
                        }
                    }
                    
                    break;
                
                case KeyEvent.VK_S:
                {
                    try 
                    {
                        swiat.zapisz();
                    } catch (FileNotFoundException wyjatek) 
                        {
                            Logger.getLogger(ObslugaZdarzen.class.getName()).log(Level.SEVERE, null, wyjatek);
                        }
                }
                    break;
                
                case KeyEvent.VK_L:
                {
                    try 
                    {
                        swiat.wczytaj();
                    } catch (FileNotFoundException wyjatek) {
                        Logger.getLogger(ObslugaZdarzen.class.getName()).log(Level.SEVERE, null, wyjatek);
                    }
                }
                    break;
            }


        }
    
        @Override
        public void keyReleased(KeyEvent event)
        {
        
        }
    
        @Override
        public void keyTyped(KeyEvent event)
        {
        
        }
   }
