package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBloccata;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {
	private Attrezzo chiave;
private StanzaBloccata bloccata;
	private Stanza stanza1;
	private Stanza stanza2;
	@Before
	public void setUp() throws Exception {
		bloccata = new StanzaBloccata("bloccata", "nord", "chiave");
		bloccata.impostaStanzaAdiacente("nord", stanza1);
		bloccata.impostaStanzaAdiacente("sud", stanza2);
		stanza1 = new Stanza("stanza1");
		chiave = new Attrezzo("chiave",1);
	}

	@Test
	public void testGetStanzaAdiacenteBloccata(){
		bloccata.impostaStanzaAdiacente("nord", stanza1);
		assertSame(bloccata, bloccata.getStanzaAdiacente("nord"));
	}
	@Test 
	public void testGetStanzaAdiacenteSBloccata(){
		bloccata.addAttrezzo(chiave);
		bloccata.impostaStanzaAdiacente("nord", stanza1);
		assertEquals(stanza1, bloccata.getStanzaAdiacente("nord"));
	}
	@Test
	public void testGetDescrizioneSenzaChiave(){
		assertEquals("Stanza Bloccata ti servirà un: "+"chiave"+" per andare verso: "+"nord",bloccata.getDescrizione());
	}
	@Test
	public void testGetDescrizioneConChiave(){
		bloccata.addAttrezzo(chiave);
		assertEquals(bloccata.toString(),bloccata.getDescrizione());
	}
	

}
