package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.StanzaBuia;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzBuiaTest {
	private StanzaBuia con;
	private StanzaBuia senza;
	private Attrezzo luce;
	@Before
	public void setUp() throws Exception {
		luce = new Attrezzo("luce", 1);
		con = new StanzaBuia("con", "luce");
		senza = new StanzaBuia("senza", "nonpresente");
	}

	@Test
	public void testgetDescrizioneConLuce() {
		con.addAttrezzo(luce);
		assertEquals(con.toString(), con.getDescrizione());
	}
	@Test
	public void testgetDescrizioneSenzaLuce() {
		assertEquals("Qui c' è buio pesto", senza.getDescrizione());
	}

}
