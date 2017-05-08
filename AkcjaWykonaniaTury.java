/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfejs;
import wirtualnySwiat.Swiat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author admin
 */
public class AkcjaWykonaniaTury implements ActionListener {
    private final Swiat swiat;

    
    private JPanel panelTury;
    
    AkcjaWykonaniaTury(JPanel panelTury, Swiat swiat) {
        this.swiat = swiat;
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
            swiat.wykonajTureBezCzlowieka(event);
    }
    
}
