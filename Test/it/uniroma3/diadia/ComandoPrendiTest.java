package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.AbstractComando;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoPrendi;
import it.uniroma3.diadia.giocatore.Borsa;

/**
 * @author CM
 * @version Homewrok 2
 */
public class ComandoPrendiTest {
	
	private Partita partita;
	private Borsa borsa;
	private Attrezzo attrezzo;
	private Attrezzo attrezzo2;
	private Stanza stanza;
	private AbstractComando comando;
	
	@Before
	public void setUp() throws Exception {
		this.partita=new Partita();
		this.borsa=partita.getGiocatore().getBorsa();
		this.attrezzo=new Attrezzo("attrezzo",5);
		this.attrezzo2=new Attrezzo("attrezzo2",5);
		this.stanza =this.partita.getStanzaCorrente();
		this.comando=new ComandoPrendi();
	}
	
	@Test
	public void testSetParametro() {
		String parametro="prova";
		AbstractComando comando=new ComandoPrendi();
		comando.setParametro(parametro);
		assertSame(parametro,comando.getParametro());
			
	}

	@Test
	public void testEseguiConParametroNullo() {
		this.stanza.addAttrezzo(attrezzo);
		comando.setParametro(null);
		comando.esegui(partita);
		assertTrue(this.borsa.isEmpty());
		assertTrue(stanza.hasAttrezzo(attrezzo.getNome()));
	}
	
	@Test
	public void testEseguiOggettoNonPresenteNellaStanza() {
		this.stanza.addAttrezzo(attrezzo);
		comando.setParametro("penna");
		comando.esegui(partita);
		assertTrue(this.borsa.isEmpty());
		assertTrue(stanza.hasAttrezzo(attrezzo.getNome()));
	}
	
	@Test
	public void testEseguiPrendiOggetto() {
		this.stanza.addAttrezzo(attrezzo);
		System.out.println(stanza.toString());
		comando.setParametro("attrezzo");
		comando.esegui(partita);
		
		assertTrue(this.borsa.hasAttrezzo(attrezzo.getNome()));
		assertFalse(stanza.hasAttrezzo(attrezzo.getNome()));
	}
	
	@Test
	public void testEseguiBorsaPiena() {
		this.borsa.addAttrezzo(attrezzo);
		this.borsa.addAttrezzo(attrezzo);
		this.stanza.addAttrezzo(attrezzo2);
		comando.setParametro("attrezzo2");
		comando.esegui(partita);
		//non ho più il limite attr
		assertFalse(this.stanza.hasAttrezzo(attrezzo2.getNome()));
		assertTrue(this.borsa.hasAttrezzo(attrezzo2.getNome()));
	}

	

}
