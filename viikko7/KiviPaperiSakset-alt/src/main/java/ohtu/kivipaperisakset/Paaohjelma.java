package ohtu.kivipaperisakset;

import java.util.HashMap;
import java.util.Scanner;

public class Paaohjelma {

    private static final Scanner scanner = new Scanner(System.in);
    private static HashMap<String, Siirtava> vastukset = new HashMap();
    
    public static void main(String[] args) {
        
        vastukset.put("a", new Pelaaja());
        vastukset.put("b", new Tekoaly());
        vastukset.put("c", new TekoalyParannettu(20));
        
        while (true) {
            System.out.println("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");

            String vastaus = scanner.nextLine();
            
            if (!vastukset.containsKey(vastaus)) {
                break;
            } 
            KPSPohja kps = new KPSPohja(new Pelaaja(), vastukset.get(vastaus));
            kps.pelaa();

        }

    }
}
