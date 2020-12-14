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
public class Pelaaja implements Siirtava {
    
    Scanner scanner = new Scanner(System.in);

    public String annaSiirto() {
        return scanner.nextLine();
    }

    public void asetaSiirto(String ekanSiirto) {
        System.out.println("Vastustaja valitsi: " + ekanSiirto + "!");
    }
    
    public void tulostaOhje(){
        System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
                
    }
    
}
