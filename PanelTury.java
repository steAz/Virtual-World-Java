/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfejs;
import wirtualnySwiat.Swiat;

import javax.swing.*;
/**
 *
 * @author admin
 */
public class PanelTury extends JPanel {
    Swiat swiat;
    
    PanelTury(Swiat swiat) {
        JButton przycisk = new JButton("Nowa tura");
        this.swiat = swiat;
        
        AkcjaWykonaniaTury przyciskAction = new AkcjaWykonaniaTury(this, swiat);
        przycisk.addActionListener(przyciskAction);
            add(przycisk);
       
    }
}
