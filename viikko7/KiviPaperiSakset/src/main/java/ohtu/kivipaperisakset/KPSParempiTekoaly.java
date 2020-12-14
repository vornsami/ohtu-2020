package ohtu.kivipaperisakset;


// Kivi-Paperi-Sakset, jossa voidaan valita pelataanko vastustajaa
// vastaan vai ei
public class KPSParempiTekoaly extends KPSPohja {
    private TekoalyParannettu tekoaly = new TekoalyParannettu(20);
    

    @Override
    protected String toisenSiirto() {
        String siirto = tekoaly.annaSiirto();
        
        System.out.println("Tietokone siirsi " + siirto);
        
        return siirto;
    }

}
