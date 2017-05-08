/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfejs;

import wirtualnySwiat.Swiat;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author admin
 */
public class MenuPrawyPrzycisk extends MouseAdapter {
    private final int x;
    private final int y;
    
    private final Swiat swiat;
    
    
    MenuPrawyPrzycisk(Swiat swiat, int x, int y) {
        this.swiat = swiat;
        this.x = x;
        this.y = y;
    }
    
    
    @Override
    public void mouseClicked(MouseEvent event)
    {
        if(MouseEvent.BUTTON3 == event.getButton())
        {
            PrawyPrzyciskMyszy prawyPrzyciskMyszy = new PrawyPrzyciskMyszy(swiat, x, y);
            prawyPrzyciskMyszy.show(event.getComponent(),event.getX(),event.getY());
        }
    }
    
    
}
