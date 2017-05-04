package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.giocatore.Giocatore;

public class GiocatoreTest {
	private Giocatore g;
	private Borsa borsa;

	@Before
	public void setUp() throws Exception {
		g = new Giocatore();
		borsa = new Borsa();
	}

	@Test
	public void testGetCfu() {
		assertEquals(20,g.getCfu());
	}
	@Test
	public void testCambioCFU(){
		g.setCfu(10);
		assertEquals(10,g.getCfu());
	}
	@Test
	public void testGetBorsa(){
		g.setBorsa(borsa);
		assertEquals(borsa,g.getBorsa());
	}

}
