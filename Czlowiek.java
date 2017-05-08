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
class Czlowiek extends Zwierze
{ 
    Czlowiek(int x, int y, int sila, int inicjatywa, String znaczek)
	{
            this.x = x;
            this.y = y;
            this.znak = znaczek;
            this.sila = sila;
            this.inicjatywa = inicjatywa;
            this.wiek = 1;
            this.ustawCzySzybkAntylopyON(false);
            this.ustawCzyMoznaWlSpecjUm(true);
            this.ustawIloscTurOdSpecjUm(0);
	}
    
    
    @Override
    void akcja(Swiat swiat, Kierunek kierunek) {
        idz(swiat, kierunek, 0, 0);
    }
    
    
    @Override
    void idz(Swiat swiat, Kierunek kierunek, int dx, int dy) {
        Random generator = new Random(); 
	int procent = generator.nextInt(100);
        
        this.kierunek = kierunek;
        switch (kierunek) {
		case UP:
                    dy = -1;

                    if (this.podajCzySzybkoscAntylopyON()) {
                            dy = -2;

                            if (this.podajIloscTurOdSpecjUm() >= 3) {
				if (procent < 50) {
                                    dy = -1;
				}
                                else {
                                    dy = -2;
                                }
                            }
                    }
                    break;
                    
                case DOWN:
                    dy = 1;
                    
                    if(this.podajCzySzybkoscAntylopyON()) {
                        dy = 2;
                        
                        if(this.podajIloscTurOdSpecjUm() >= 3) {
                            if(procent < 50) {
                                dy = 1;
                            }
                            else {
                                dy = 2;
                            }
                        }
                    }
                    
                    break;
                    
                case RIGHT:
                      dx = 1;
                    
                    if(this.podajCzySzybkoscAntylopyON()) {
                        dx = 2;
                        
                        if(this.podajIloscTurOdSpecjUm() >= 3) {
                            if(procent < 50) {
                                dx = 1;
                            }
                            else {
                                dx = 2;
                            }
                        }
                    }
                    
                    break;
                    
                case LEFT:
                    dx = -1;
                    
                    if(this.podajCzySzybkoscAntylopyON()) {
                        dx = -2;
                        
                        if(this.podajIloscTurOdSpecjUm() >= 3) {
                            if(procent < 50) {
                                dx = -1;
                            }
                            else {
                                dx = -2;
                            }
                        }
                    }

                    break;
        }
	
        if(!czySciana(swiat, this.x + dx, this.y + dy)) {
            this.poprzednieX = x;
            this.poprzednieY = y;
                
            this.czyRozmnazac = false;
            this.x += dx;
            this.y += dy;
        }
    }
}

