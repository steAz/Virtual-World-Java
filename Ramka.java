/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfejs;

import java.awt.*;
import javax.swing.*;
import wirtualnySwiat.Swiat;
import wirtualnySwiat.Organizm;

/**
 *
 * @author Olek
 */
public class Ramka extends JFrame {
    private final Swiat swiat;
    private final Krata krata; 
    private final  JLabel rezultat;
    private final  JLabel sila;
    
    private JLabel rezultatWalki;
    private JLabel rezultatJedzenia;
    
    private final int WIELKOSC_PLANSZY = 2022;
    
    private JPanel panelTury;
    
    private static final int SZEROKOSC_RAMKI = 1250;
    private static final int WYSOKOSC_RAMKI = 820;
    
     
    
     
    public Ramka(Swiat swiat, int x, int y) {
        this.swiat = swiat;
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); // NIE MOZNA ZMIENIAC ROZMIARU
        setSize(SZEROKOSC_RAMKI, WYSOKOSC_RAMKI);
        setVisible(true);
        setTitle("Michał Kazanowski 160512");
        
    
        ObslugaZdarzen obsluga = new ObslugaZdarzen(swiat, this);
        addKeyListener(obsluga);
      
        krata = new Krata(swiat, x, y);
        add(krata, BorderLayout.WEST);  // polozenie kraty - LEWO
        krata.setBackground(Color.GREEN);
        krata.setPreferredSize(new Dimension(1000,1000));
        
        rezultat = new JLabel();
        rezultat.setFont(new Font("Serif", Font.ITALIC, 35));
        rezultat.setForeground(Color.BLUE);
        add(rezultat, BorderLayout.SOUTH);
        
        sila = new JLabel();
        sila.setFont(new Font("Helvetica", Font.ITALIC, 25));
        sila.setForeground(Color.RED);
        add(sila, BorderLayout.NORTH);

    }
    
    public void ustawPoleKratki(String text, int x, int y) {
        krata.ustawPoleTekstowe(text, x, y);
    }
    
    
    public void wyczyscPlansze() {
        krata.wyczyscKrate(swiat);
    }
    
    
    public void wyswietlajRezultaty() {
        rezultat.setText("AKTUALNA TURA: "  + String.valueOf(swiat.podajTure()));
        if (swiat.organizmy[WIELKOSC_PLANSZY] != null) {
            sila.setText("Sila czlowieka: " + String.valueOf(swiat.organizmy[WIELKOSC_PLANSZY].podajSile()));
        }else {
            remove(sila);
        }
    }
    
    
    public void wyswietlajRezultatyWalki(Organizm orgI, Organizm orgII) {
        
         if (rezultatWalki != null) {
            remove(rezultatWalki);
        }
         
        rezultatWalki = new JLabel();
        rezultatWalki.setFont(new Font("MongoSpaced", Font.ITALIC, 10));
        rezultatWalki.setForeground(Color.RED);
        rezultatWalki.setText(orgI.podajZnak() + " " + "zabil" + " " + orgII.podajZnak());
        add(rezultatWalki, BorderLayout.EAST); 
        
    }
    
    
    public void wyswietlajRezultatyJedzenia(Organizm orgI, Organizm orgII) {
        
        if (rezultatJedzenia != null) {
            remove(rezultatJedzenia);
        }
        
        rezultatJedzenia = new JLabel();
        rezultatJedzenia.setFont(new Font("MongoSpaced", Font.ITALIC, 10));
        rezultatJedzenia.setForeground(Color.DARK_GRAY);
        rezultatJedzenia.setText(String.valueOf(orgI.podajZnak()) + " " + "zjadl" + " " + String.valueOf(orgII.podajZnak()));
        rezultatJedzenia.setLocation(1300, 400);
        add(rezultatJedzenia); 
    }
    
    public void dodajPrzyciskTury() {
        panelTury = new PanelTury(swiat);
        add(panelTury, BorderLayout.NORTH);
    }

}

