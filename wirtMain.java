/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wirtualnySwiat;

import Interfejs.Ramka;

//import java.util.*;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author admin
 */
public class wirtMain 
{
    public static void main(String[] args)
    {
        Swiat swiat = new Swiat();
        
        EventQueue.invokeLater(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        swiat.menu(20, 20);
                        swiat.rysujOrganizmy();
                    }
                    
                });
    }
}
