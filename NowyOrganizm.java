/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfejs;

import wirtualnySwiat.Swiat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author admin
 */
public class NowyOrganizm implements ActionListener {
    private final String znak;
    
    private final int x;
    
    private final int y;
    
    private final Swiat swiat;
    

        public NowyOrganizm(Swiat swiat, int x, int y,  String znak)
        {
            this.swiat = swiat;
            this.znak = znak;
            this.x=x;
            this.y=y;
        }
    
        
        @Override
        public void actionPerformed(ActionEvent event)
                {
                    swiat.dodajOrganizm(x , y, znak);
                    swiat.rysujOrganizmy();
                }
}
