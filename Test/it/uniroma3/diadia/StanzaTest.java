package it.uniroma3.diadia;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {
	private Stanza stanzaSola;
	private Stanza stanzaCollegata1;
	private Stanza stanzaCollegata2;
	private Attrezzo spada;
	private Map<String, Attrezzo> l1;
	@Before
	public void setUp(){
		stanzaSola=new Stanza("stanzaSola");
		stanzaCollegata1 = new Stanza("stanzaCollegata1");
		stanzaCollegata2 = new Stanza("stanzaCollegata2");
		stanzaCollegata1.impostaStanzaAdiacente("sud", stanzaCollegata2);
		stanzaCollegata2.impostaStanzaAdiacente("nord", stanzaCollegata1);
		spada = new Attrezzo("spada",5);
		l1 = new HashMap<>();
	}
	//getStanza
	@Test
	public void testgetStanzaAdiacenteDIRNULLA() {
		assertNull(stanzaSola.getStanzaAdiacente(""));
	}
	@Test 
	public void testgetStanzaAdiacenteSTANZASOLA(){
		assertNull(stanzaSola.getStanzaAdiacente("nord"));
	}
	@Test
	public void testGetStanzaAdiacenteCollegate(){
		assertEquals(stanzaCollegata2, stanzaCollegata1.getStanzaAdiacente("sud"));
	}
	//getNome
	@Test
	public void testGetNome(){
		assertEquals("stanzaSola",stanzaSola.getNome());
	}
	//getDescrizione
	@Test
	public void testGetDescrizione(){
		assertEquals(stanzaSola.toString(),stanzaSola.getDescrizione());
	}
	//getAttrezzi
	@Test
	public void testGetAttrezziSenzaAttrezzi(){ 
		assertEquals(l1, stanzaCollegata1.getAttrezzi());
	}
	@Test
	public void testGetAttrezziConAttr(){
		l1.put("spada", spada);
		stanzaSola.addAttrezzo(spada);
		assertEquals(l1,stanzaSola.getAttrezzi());
	}
	//addAttrezzo
	@Test
	public void testAddAttrezzoStanzaVuota(){
		assertTrue(stanzaSola.addAttrezzo(spada));
	}
	@Test
	public void testAddAttrezzoStanzaPiena(){
		stanzaSola.addAttrezzo(spada);
		assertFalse(stanzaSola.addAttrezzo(spada));
	}
	//hasAttrezzo
	@Test
	public void testHasAttrezzoStringaNulla(){
		assertFalse(stanzaSola.hasAttrezzo(null));
	}
	@Test
	public void testHasAttrezzoNonPresente(){
		assertFalse(stanzaSola.hasAttrezzo("nonpresente"));
	}
	@Test
	public void testHasAttrezzoPresente(){
		Attrezzo presente = new Attrezzo("presente",3);
		stanzaSola.addAttrezzo(presente);
		assertTrue(stanzaSola.hasAttrezzo("presente"));
	}
	//getAttrezzo
	@Test
	public void testGetAttrezzoNullo(){
		assertNull(stanzaSola.getAttrezzo(null));
	}
	@Test 
	public void testGetAttrezzoNonPresente(){
		assertNull(stanzaSola.getAttrezzo("non presente"));
	}
	@Test
	public void testGetAttrezzoPresente(){
		stanzaSola.addAttrezzo(spada);
		assertEquals(spada,stanzaSola.getAttrezzo("spada"));
	}
	//removeAttrezzo
	@Test
	public void testRemoveAttrezzoNullo(){
		assertFalse(stanzaSola.removeAttrezzo(null));
	}
	@Test
	public void testRemoveAttrezzoNonPresente(){
		Attrezzo nonpresente = new Attrezzo("stringa",1);
		assertFalse(stanzaSola.removeAttrezzo(nonpresente ));
	}
	@Test
	public void testRemoveAttrezzoPresente(){
		Attrezzo presente=new Attrezzo("presente",3);
		stanzaSola.addAttrezzo(presente);
		assertTrue(stanzaSola.removeAttrezzo(presente));
	}
	
}




