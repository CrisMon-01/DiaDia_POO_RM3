package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class PartitaTest {
	private Partita partita1;
	private Stanza Atrio;
	Stanza biblioteca;
	@Before
	public void setUp(){
		partita1 = new Partita();
		Atrio = new Stanza("Atrio");
		biblioteca = new Stanza("Biblioteca");
	}
	//getstanzacorrente
	@Test
	public void testGetSTnazaCorrente() {
		assertEquals(Atrio.getNome(), partita1.getStanzaCorrente().getNome());
	}
	//vinta
	@Test
	public void testVintaNo(){
		assertFalse(partita1.vinta());
	}
	@Test
	public void testVintaSi(){
		partita1.setStanzaCorrente(partita1.getLabirinto().getStanzaVincente());
		assertTrue(partita1.vinta());
	}
	//get
	@Test
	public void testGetCfu(){
		assertEquals(20, this.partita1.getGiocatore().getCfu());
	}
	@Test
	public void testGetLabirinto(){
		assertEquals("Atrio",partita1.getLabirinto().getStanzaIn().getNome());
		assertEquals("Biblioteca",partita1.getLabirinto().getStanzaVincente().getNome());
	}
	//isfinita
	@Test
	public void testIsFinitaNo(){
		assertFalse(partita1.isFinita());
	}
	@Test
	public void testIsFinitaSiFinita(){
		partita1.setFinita();
		assertTrue(partita1.isFinita());
	}
	@Test
	public void testIsFinitaSiCfu(){
		partita1.getGiocatore().setCfu(0);
		assertTrue(partita1.isFinita());
	}
}
