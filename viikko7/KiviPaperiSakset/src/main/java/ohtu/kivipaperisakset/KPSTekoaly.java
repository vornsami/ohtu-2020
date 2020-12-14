package ohtu.kivipaperisakset;


public class KPSTekoaly extends KPSPohja {
    
    private Tekoaly tekoaly = new Tekoaly();
    
    @Override
    protected String toisenSiirto() {
        String siirto = tekoaly.annaSiirto();
        
        System.out.println("Tietokone siirsi " + siirto);
        
        return siirto;
    }
}