package it.uniroma3.diadia;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class BorsaTest {
	private Borsa borsaVuota, borsaPiena;
	private Attrezzo possibile;
	private Attrezzo pesante;
	private Attrezzo leggero1, leggero2;
	@Before
	public void setUp() {
		borsaVuota=new Borsa();
		borsaPiena=new Borsa(30);
		borsaPiena.addAttrezzo(new Attrezzo("piombo", 10));
		borsaPiena.addAttrezzo(new Attrezzo("ps", 5));
		borsaPiena.addAttrezzo(new Attrezzo("piuma", 1));
		borsaPiena.addAttrezzo(new Attrezzo("libro", 5));
		possibile = new Attrezzo("possibile",3);
		pesante = new Attrezzo("pesante",30);
		leggero1 = new Attrezzo("leggero1", 1);
		leggero2 = new Attrezzo("leggero2", 1);
	}
	//addattrezzo
	@Test
	public void testAddAttrezzoNullo() {
		assertFalse(borsaVuota.addAttrezzo(null));
	}
	@Test 
	public void testAddAttrezzoSingolo(){
		assertTrue(borsaVuota.addAttrezzo(possibile));
	}
	@Test 
	public void testAddAttrezzoTroppi(){
		for(int i =0;i<10;i++)
			borsaVuota.addAttrezzo(possibile);
		assertFalse(borsaVuota.addAttrezzo(possibile));
	}
	@Test 
	public void testAddAttrezzoTroppoPeso(){
		assertFalse(borsaVuota.addAttrezzo(pesante));
	}
	//getPesoMax
	@Test
	public void testGetPesoMax(){
		assertEquals(10,borsaVuota.getPesoMax());
	}
	//getPeso
	@Test
	public void testGetPesoVuota(){
		assertEquals(0,borsaVuota.getPeso());
	}
	@Test
	public void testGetPesoNonVuota(){
		borsaVuota.addAttrezzo(possibile);
		assertEquals(3,borsaVuota.getPeso());
	}
	//getAttrezzo
	@Test
	public void testGetAttrezzoStringaNulla(){
		assertNull(borsaVuota.getAttrezzo(""));
	}
	@Test
	public void testGetAttrezzoNonPresente(){
		assertNull(borsaVuota.getAttrezzo("oggettononpresente"));
	}
	@Test
	public void testGetAttrezzoPresente(){
		borsaVuota.addAttrezzo(possibile);
		assertEquals(possibile, borsaVuota.getAttrezzo("possibile"));
	}
	//isEmpty
	@Test
	public void testIsEmptyVuota(){
		assertTrue(borsaVuota.isEmpty());
	}
	@Test
	public void testIsEmptyNonVuota(){
		borsaVuota.addAttrezzo(possibile);
		assertFalse(borsaVuota.isEmpty());
	}
	//hasattrezzo
	@Test
	public void testHasAttrezzoNull(){
		assertFalse(borsaVuota.hasAttrezzo(null));
	}
	@Test
	public void testHasAttrezzoOK(){
		borsaVuota.addAttrezzo(possibile);
		assertTrue(borsaVuota.hasAttrezzo("possibile"));
	}
	@Test
	public void testHasAttrezzoFalso(){
		assertFalse(borsaVuota.hasAttrezzo("possibile"));
	}
	//removeattrezzo
	@Test
	public void testRemoveAttrezzoNullo(){
		assertNull(borsaVuota.removeAttrezzo(null));
	}
	@Test
	public void testRemoveAttrezzoNonPresente(){
		assertNull(borsaVuota.removeAttrezzo("nonpresente"));
	}
	@Test
	public void testRemoveAttrezzoPresente(){
		borsaVuota.addAttrezzo(possibile);
		assertEquals(possibile, borsaVuota.removeAttrezzo("possibile"));
	}
	//toString
	@Test
	public void testToStringVuota(){
		assertEquals("Borsa vuota", borsaVuota.toString());
	}
	@Test
	public void testToStringNonVuota(){
		borsaVuota.addAttrezzo(possibile);
		assertEquals("Contenuto borsa (3kg/10kg): [possibile (3kg)] ",borsaVuota.toString());
	}
	//getContenutoOrdinatoPerPeso
	@Test
	public void testGetContenutoOrdinatoPerPeso(){
		assertEquals("[piuma (1kg), libro (5kg), ps (5kg), piombo (10kg)]",borsaPiena.getContenutoOrdinatoPerPeso().toString());
	}
	//getContenutoOrdinatoPerNome
	@Test
	public void getContenutoOrdinatoPerNome(){
		assertEquals("[libro (5kg), piombo (10kg), piuma (1kg), ps (5kg)]",borsaPiena.getContenutoOrdinatoPerNome().toString());
		//classcastexception
	}
	//getContenutoRaggruppatoPerPeso
	@Test
	public void getContenutoRaggruppatoPerPesoConPesoUguale(){
		assertEquals("{1=[piuma (1kg)], 5=[libro (5kg), ps (5kg)], 10=[piombo (10kg)]}",borsaPiena.getContenutoRaggruppatoPerPeso().toString());
	}
	//getSortedSetOrdinatoPerPeso
	@Test
	public void getSortedSetOrdinatoPerPeso(){	
		assertNotNull(borsaPiena.getSortedSetOrdinatoPerPeso());
		assertEquals("[piuma (1kg), libro (5kg), ps (5kg), piombo (10kg)]", borsaPiena.getSortedSetOrdinatoPerPeso());
		
	}
	
	
	
	
}
