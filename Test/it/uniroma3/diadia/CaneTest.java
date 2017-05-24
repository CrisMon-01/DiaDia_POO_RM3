package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Giocatore;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;
import it.uniroma3.diadia.personaggi.Cane;

public class CaneTest {
	private Partita partita;
	private Giocatore giocatore;
	private Attrezzo attrezzo, cibo, regalo;
	private AbstractPersonaggio cane;
	@Before
	public void setUp(){
		partita=new Partita();
		attrezzo = new Attrezzo("attrezzo", 4);
		cibo = new Attrezzo("ossicino", 2);
		regalo = new Attrezzo("gift", 3);
		cane = new Cane("cane","",cibo,regalo);
		giocatore=partita.getGiocatore();
		giocatore.setCfu(1);
	}
	@Test
	public void testAgisci() {
		assertFalse(partita.isFinita());
		assertEquals("il cane ti ha morso! i tuoi CFU sono diminuiti",cane.agisci(partita));
		assertTrue(partita.isFinita());
	}
	@Test
	public void testRiceviRegaloNonPreferito(){
		assertEquals("il cane non vuole il tuo attrezzo e lo lascia cadere nella stanza",cane.riceviRegalo(attrezzo, partita));
		assertTrue(partita.getStanzaCorrente().hasAttrezzo(attrezzo.getNome()));
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo(attrezzo.getNome()));
		assertFalse(partita.getStanzaCorrente().hasAttrezzo(regalo.getNome()));
	}
	@Test
	public void testRiceviRegaloPreferito(){
		assertEquals("il cane ha accettato il tuo dono e te ne ha fatto un'altro. ora nella stanza c'è un nuovo attrezzo: "+regalo.getNome(),cane.riceviRegalo(cibo, partita));
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo(cibo.getNome()));
		assertFalse(partita.getStanzaCorrente().hasAttrezzo(cibo.getNome()));
		assertTrue(partita.getStanzaCorrente().hasAttrezzo(regalo.getNome()));
	}
}