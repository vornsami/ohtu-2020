/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

import java.util.Scanner;

/**
 *
 * @author Sami
 */
public class KPSPohja {
    
    private Siirtava pelaaja1;
    private Siirtava pelaaja2;
    
    public KPSPohja(Siirtava p1, Siirtava p2){
        pelaaja1 = p1;
        pelaaja2 = p2;
    }
    
    
    public void pelaa() {
        pelaaja2.tulostaOhje();
        Tuomari tuomari = new Tuomari();

        System.out.println("Ensimmäisen pelaajan siirto: ");
        String ekanSiirto = pelaaja1.annaSiirto();
        String tokanSiirto = pelaaja2.annaSiirto();
        System.out.println("Tietokone valitsi: " + tokanSiirto);


        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();

            System.out.println("Ensimmäisen pelaajan siirto: ");
            ekanSiirto = pelaaja1.annaSiirto();

            tokanSiirto = pelaaja2.annaSiirto();
            System.out.println("Tietokone valitsi: " + tokanSiirto);
            pelaaja2.asetaSiirto(ekanSiirto);

        }

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }

    private static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
}
