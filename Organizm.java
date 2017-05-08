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
abstract public class Organizm {
    Ramka ramka;
    private int iloscTurOdSpecjUm;
    private boolean czyMoznaWlSpecjUm;
    private boolean szybkoscAntylopyON;
    
    protected final int WIELKOSC_PLANSZY = 2022;
    protected int sila;
    protected int wiek;
    protected String znak;
    protected int inicjatywa;
    protected int numerOrganizmu;
    protected int x;
    protected int y;
    protected int poprzednieX;
    protected int poprzednieY;
    protected boolean czyRozmnazac;
    
    protected enum Kierunek
    {
        UP,
        DOWN,
        LEFT,
        RIGHT,
        LOSOWY
    }
    
    
    abstract void akcja(Swiat swiat, Kierunek kierunek);
    abstract void kolizja(Ramka ramka, Swiat swiat, boolean czyRozmnazac);
    
    
    boolean czySciana(Swiat swiat, int x, int y)
    {
        if (x < 0 || x > swiat.podajSzerokosc() - 1) return true;
        
        if(y < 0 || y > swiat.podajWysokosc() - 1) return true;
        
        return false;
    }
    
    
    void ustawNumerOrganizmu(int nrOrganizmu)
    {
	this.numerOrganizmu = nrOrganizmu;
    }
    
    
    int podajNumerOrganizmu()
    {
	return this.numerOrganizmu;
    }
    
    
    void usunOrganizm(Organizm organizm) {
        organizm = null;
    }
    
    
    void zwiekszSile(int sila) {
        this.sila += sila;
    }
    
    void ustawWiek(int wiek)
    {
	this.wiek = wiek;
    }
    
    
    public String podajZnak()
    {
        return this.znak;
    }
    
    
    public void ustawCzySzybkAntylopyON(boolean szybkoscAntylopyON)
    {
	this.szybkoscAntylopyON = szybkoscAntylopyON;
    }
    
    
    void ustawInicjatywe(int inicjatywa)
    {
	this.inicjatywa = inicjatywa;
    }
    
    
    void ustawSile(int sil)
    {
	this.inicjatywa = sila;
    }


    void ustawCzyMoznaWlSpecjUm(boolean czyMoznaWlSpecjUm)
    {
	this.czyMoznaWlSpecjUm = czyMoznaWlSpecjUm;
    }
    
    
    boolean podajCzySzybkoscAntylopyON()
    {
	return this.szybkoscAntylopyON;
    }

    
    void dodajIloscTurOdSpecjUm() {
        this.iloscTurOdSpecjUm += 1;
    }

    public boolean podajCzyMoznaWlSpecjUm()
    {
        return this.czyMoznaWlSpecjUm;
    }
    
    
    int podajIloscTurOdSpecjUm()
    {
	return this.iloscTurOdSpecjUm;
    }
    
    
    void ustawIloscTurOdSpecjUm(int iloscTurOdSpecjUm)
    {
	this.iloscTurOdSpecjUm = iloscTurOdSpecjUm;
    }
    
    
    int podajInicjatywe() {
        return this.inicjatywa;
    }
    
    
    public int podajSile() {
        return this.sila;
    }
    
    
    int podajWiek() {
        return this.wiek;
    }
    
    
    void dodajWiek() {
        this.wiek += 1;
    }
}
