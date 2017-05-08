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
class KontenerOrg {
    
    final int WIELKOSC_PLANSZY = 2022;
    private int iloscOrganizmow;
    private Organizm[] organizmy;
    
    void dodajOrganizmy(Swiat swiat) {
        int licznik = 0;
        
        for (int i = 0; i < WIELKOSC_PLANSZY + 1; i++) {
            if (swiat.organizmy[i] != null) {
                licznik++;
               }
        }

	this.organizmy = new Organizm[licznik];
	this.iloscOrganizmow = licznik;

	int j = 0;
        for (int i = 0; i < licznik; i++) {
            if (organizmy[i] != null) {
		this.organizmy[j] = swiat.organizmy[i];
                j++;
            }
        }
    }
    
    void usunOrganizmy(Swiat swiat) {
        for (int i = 0; i < iloscOrganizmow; i++) {
            this.organizmy[i] = null;
        }
     }

}
