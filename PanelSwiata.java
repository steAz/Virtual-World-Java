/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfejs;

import java.awt.*;
import javax.swing.*;
import wirtualnySwiat.Swiat;

/**
 *
 * @author admin
 */
public class PanelSwiata extends JPanel
{
    private JLabel text;
    private JLabel thumb;
    
     public PanelSwiata(Swiat swiat, int x, int y) {
        setBackground(Color.darkGray);
        
        MenuPrawyPrzycisk menuPrawyPrzycisk = new MenuPrawyPrzycisk(swiat, x, y);
        addMouseListener(menuPrawyPrzycisk);
        
        text = new JLabel();
        //add(text);
        
        thumb = new JLabel();
        add(thumb);
       

    }
     
     public void ustawIkone(String znak) {
       // text.setText(znak);
       // Image image=GenerateImage.toImage(true);  //this generates an image file
        
        ImageIcon icon;
         
        if("Czlowiek".equals(znak)) {
            icon = new ImageIcon("Images/stark.png"); 
            thumb.setIcon(icon);
            text.setText("Czlowiek");
        }
        
        if("Wilk".equals(znak)) {
            icon = new ImageIcon("Images/wilk.jpg"); 
            thumb.setIcon(icon);
            text.setText("Wilk");
        }
        
        if("Antylopa".equals(znak)) {
            icon = new ImageIcon("Images/antylopa.jpg");
            thumb.setIcon(icon);
            text.setText("Antylopa");
        }
        
        if("Owca".equals(znak)) {
            icon = new ImageIcon("Images/owca.jpg");
            thumb.setIcon(icon);
            text.setText("Owca");
        }
        
        if("Lis".equals(znak)) {
            icon = new ImageIcon("Images/lis.jpg");
            thumb.setIcon(icon);
            text.setText("Lis");
        }
        
        if("Zolw".equals(znak)) {
            icon = new ImageIcon("Images/zolw.png");
            thumb.setIcon(icon);
            text.setText("Zolw");
        }
        
        if("Trawa".equals(znak)) {
            icon = new ImageIcon("Images/trawa.jpg");
            thumb.setIcon(icon);
            text.setText("Trawa");
        }
        
        if("Mlecz".equals(znak)) {
            icon = new ImageIcon("Images/mlecz.jpg");
            thumb.setIcon(icon);
            text.setText("Mlecz");
        }
        
        if("Guarana".equals(znak)) {
            icon = new ImageIcon("Images/guarana.jpg");
            thumb.setIcon(icon);
            text.setText("Guarana");
        }
        
        if("WilczeJagody".equals(znak)) {
            icon = new ImageIcon("Images/wilczejagody.jpg");
            thumb.setIcon(icon);
            text.setText("WilczeJagody");
        }
    }
     
     public void wyczyscPole() {
       
            thumb.setIcon(null);
            setBackground(Color.darkGray);
       
        
    }
}
