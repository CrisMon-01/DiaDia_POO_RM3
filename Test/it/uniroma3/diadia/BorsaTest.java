package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class BorsaTest {
	private Borsa borsa;
	private Attrezzo possibile;
	private Attrezzo pesante;
	@Before
	public void setUp() {
		borsa=new Borsa();
		possibile = new Attrezzo("possibile",3);
		pesante = new Attrezzo("pesante",30);
	}
	//addattrezzo
	@Test
	public void testAddAttrezzoNullo() {
		assertFalse(borsa.addAttrezzo(null));
	}
	@Test 
	public void testAddAttrezzoSingolo(){
		assertTrue(borsa.addAttrezzo(possibile));
	}
	@Test 
	public void testAddAttrezzoTroppi(){
		for(int i =0;i<10;i++)
			borsa.addAttrezzo(possibile);
			assertFalse(borsa.addAttrezzo(possibile));
	}
	@Test 
	public void testAddAttrezzoTroppoPeso(){
		assertFalse(borsa.addAttrezzo(pesante));
	}
	//getPesoMax
	@Test
	public void testGetPesoMax(){
		assertEquals(10,borsa.getPesoMax());
	}
	//getPeso
	@Test
	public void testGetPesoVuota(){
		assertEquals(0,borsa.getPeso());
	}
	@Test
	public void testGetPesoNonVuota(){
		borsa.addAttrezzo(possibile);
		assertEquals(3,borsa.getPeso());
	}
	//getAttrezzo
	@Test
	public void testGetAttrezzoStringaNulla(){
		assertNull(borsa.getAttrezzo(""));
	}
	@Test
	public void testGetAttrzzoNonPresente(){
		assertNull(borsa.getAttrezzo("oggettononpresente"));
	}
	@Test
	public void testGetAttrezzoPresente(){
		borsa.addAttrezzo(possibile);
		assertEquals(possibile, borsa.getAttrezzo("possibile"));
	}
	//isEmpty
	@Test
	public void testIsEmptyVuota(){
		assertTrue(borsa.isEmpty());
	}
	@Test
	public void testIsEmptyNonVuota(){
		borsa.addAttrezzo(possibile);
		assertFalse(borsa.isEmpty());
	}
	//hasattrezzo
	@Test
	public void testHasAttrezzoNull(){
		assertFalse(borsa.hasAttrezzo(null));
	}
	@Test
	public void testHasAttrezzoOK(){
		borsa.addAttrezzo(possibile);
		assertTrue(borsa.hasAttrezzo("possibile"));
	}
	@Test
	public void testHasAttrezzoFalso(){
		assertFalse(borsa.hasAttrezzo("possibile"));
	}
	//removeattrezzo
	@Test
	public void testRemoveAttrezzoNullo(){
		assertNull(borsa.removeAttrezzo(null));
	}
	@Test
	public void testRemoveAttrezzoNonPresente(){
		assertNull(borsa.removeAttrezzo("nonpresente"));
	}
	@Test
	public void testRemoveAttrezzoPresente(){
		borsa.addAttrezzo(possibile);
		assertEquals(possibile, borsa.removeAttrezzo("possibile"));
	}
	//toString
	@Test
	public void testToStringVuota(){
		assertEquals("Borsa vuota", borsa.toString());
	}
	@Test
	public void testToStringNonVuota(){
		borsa.addAttrezzo(possibile);
		assertEquals("Contenuto borsa (3kg/10kg): possibile (3kg)",borsa.toString());
	}
}
