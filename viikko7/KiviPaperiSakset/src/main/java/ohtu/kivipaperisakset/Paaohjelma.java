package ohtu.kivipaperisakset;

import java.util.Scanner;

public class Paaohjelma {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");

            String vastaus = scanner.nextLine();
            if(!(vastaus.equals("a") || vastaus.equals("b") || vastaus.equals("c"))) {
                break;
            }
            KPSTehdas.haePeli(vastaus).pelaa();
            
        }
    }
}
