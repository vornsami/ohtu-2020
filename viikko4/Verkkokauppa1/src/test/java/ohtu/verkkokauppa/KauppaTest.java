/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sami
 */

package ohtu.verkkokauppa;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class KauppaTest {
    Pankki pankki;
    Viitegeneraattori viite;
    Varasto varasto;
    Kauppa k;

    @Before
    public void setUp() {
        pankki = mock(Pankki.class);
        viite = mock(Viitegeneraattori.class);
        when(viite.uusi()).thenReturn(42);
        
        varasto = mock(Varasto.class);
        
        when(varasto.saldo(1)).thenReturn(10); 
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        
        k = new Kauppa(varasto, pankki, viite);    
    }

    @Test
    public void ostoksenPaaytyttyaPankinMetodiaTilisiirtoKutsutaan() {

        // tehd‰‰n ostokset
        k.aloitaAsiointi();
        k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        k.tilimaksu("pekka", "12345");

        // sitten suoritetaan varmistus, ett‰ pankin metodia tilisiirto on kutsuttu
        verify(pankki).tilisiirto(anyString(), anyInt(), anyString(), anyString(),anyInt());   
        // toistaiseksi ei v‰litetty kutsussa k‰ytetyist‰ parametreista
    }
    
    @Test
    public void tilisiirtoKutsutaanOstostenPaatteeksiOikeillaArvoilla(){
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.tilimaksu("pekka", "12345");
        verify(pankki).tilisiirto(eq("pekka"), eq(42), anyString(), anyString(),eq(5));
    }
    
    @Test
    public void tilisiirtoKutsutaanOstostenPaatteeksiOikeillaArvoillaKunUseaEriTuote(){
        
        when(varasto.saldo(2)).thenReturn(10); 
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "liha", 7));
              
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(2);
        k.tilimaksu("pekka", "12345");
        verify(pankki).tilisiirto(eq("pekka"), eq(42), anyString(), anyString(),eq(12));
    }
    @Test
    public void tilisiirtoKutsutaanOstostenPaatteeksiOikeillaArvoillaKunUseaSamaTuote(){
        
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(1);
        k.tilimaksu("pekka", "12345");
        verify(pankki).tilisiirto(eq("pekka"), eq(42), anyString(), anyString(),eq(10));
    }
    @Test
    public void tilisiirtoKutsutaanOstostenPaatteeksiOikeillaArvoillaKunTuoteOnLoppu(){

        when(varasto.saldo(2)).thenReturn(0); 
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "liha", 7));

        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(2);
        k.tilimaksu("pekka", "12345");
        verify(pankki).tilisiirto(eq("pekka"), eq(42), anyString(), anyString(),eq(5));
    }
    @Test
    public void tarkastaEttaAloitaAsiointiNollaaKauppalistan(){
        
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.tilimaksu("pekka", "12345");
        verify(pankki, times(1)).tilisiirto(eq("pekka"), eq(42), anyString(), anyString(),eq(5));
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.tilimaksu("pekka", "12345");
        verify(pankki, times(2)).tilisiirto(eq("pekka"), eq(42), anyString(), anyString(),eq(5));
        
    }
    @Test
    public void tarkastaKauppaPyytaaUudenViitenumeron(){
        when(viite.uusi()).thenReturn(42).thenReturn(55);
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.tilimaksu("pekka", "12345");
        verify(pankki, times(1)).tilisiirto(eq("pekka"), eq(42), anyString(), anyString(),eq(5));
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.tilimaksu("jonne", "54321");
        verify(pankki, times(1)).tilisiirto(eq("jonne"), eq(55), anyString(), anyString(),eq(5));
        
    }
    @Test
    public void tuotteidenPoistoOstoskoristaToimii(){
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(1);
        k.poistaKorista(1);
        k.tilimaksu("pekka", "12345");
        verify(pankki).tilisiirto(eq("pekka"), eq(42), anyString(), anyString(),eq(5));
    }
}