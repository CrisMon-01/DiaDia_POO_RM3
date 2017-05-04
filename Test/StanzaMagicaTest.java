
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.StanzaMagicaProtected;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaTest {
	private StanzaMagicaProtected stanzatre;
	private Attrezzo attrezzouno;
	private Attrezzo attrezzodue;
	private Attrezzo attrezzotre;
	private Attrezzo att4;
	@Before
	public void setUp() throws Exception {
		stanzatre = new StanzaMagicaProtected("stanza", 3);
		attrezzouno = new Attrezzo("attrezzo1", 5);
		attrezzodue = new Attrezzo("attrezzo2", 4);
		attrezzotre = new Attrezzo("attrezzo3", 3);
		att4 = new Attrezzo("a4",2); 
	}

	@Test
	public void testAddNonModifica() {
		stanzatre.addAttrezzo(attrezzouno);
		assertEquals(attrezzouno, stanzatre.getAttrezzo("attrezzo1"));
	}
	@Test
	public void testAddAttrezzoModificato(){
		stanzatre.addAttrezzo(attrezzouno);
		stanzatre.addAttrezzo(attrezzodue);
		stanzatre.addAttrezzo(attrezzotre);
		stanzatre.addAttrezzo(att4);
		assertNotNull(stanzatre.getAttrezzo("4a"));
		assertNotEquals(att4, stanzatre.getAttrezzo("4a"));
	}
	
}
