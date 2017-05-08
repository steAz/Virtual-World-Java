/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfejs;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import wirtualnySwiat.Swiat;

/**
 *
 * @author admin
 */
public class PrawyPrzyciskMyszy extends JPopupMenu {
    private final int dlugoscMenu;
    
    JMenuItem[] menu;
    
    public PrawyPrzyciskMyszy(Swiat swiat, int x, int y) {
        this.dlugoscMenu = 9;
        
        menu = new JMenuItem[dlugoscMenu];
        menu[0] = new JMenuItem("Antylopa");
        menu[1] = new JMenuItem("Lis");
        menu[2] = new JMenuItem("Owca");
        menu[3] = new JMenuItem("Zolw");
        menu[4] = new JMenuItem("Wilk");
        menu[5] = new JMenuItem("Trawa");
        menu[6] = new JMenuItem("Mlecz");
        menu[7] = new JMenuItem("WilczeJagody");
        menu[8] = new JMenuItem("Guarana");
        
        for(int i = 0; i < dlugoscMenu; i++) {
            add(menu[i]);
            menu[i].addActionListener(new NowyOrganizm(swiat, x, y, menu[i].getText()));
        }
    }
}
