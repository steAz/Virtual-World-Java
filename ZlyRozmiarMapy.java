/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wirtualnySwiat;

/**
 *
 * @author admin
 */
class ZlyRozmiarMapy extends Exception {
    private final String tekst;
    
    ZlyRozmiarMapy(String tekst) {
        super(tekst);
        this.tekst = tekst;
    }
}
