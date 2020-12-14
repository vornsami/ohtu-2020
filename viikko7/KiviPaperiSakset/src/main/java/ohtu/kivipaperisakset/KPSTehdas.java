/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

/**
 *
 * @author Sami
 */
public class KPSTehdas {
    
    public static KPSPohja haePeli(String syote){
        if(syote.equals("a")){
            return new KPSPelaajaVsPelaaja();
        } else if(syote.equals("b")){
            return new KPSTekoaly();
        } else if (syote.equals("c")){
            return new KPSParempiTekoaly();
        } 
        return null;
        
    }
}
