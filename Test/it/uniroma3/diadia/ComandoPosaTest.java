package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.AbstractComando;
import it.uniroma3.diadia.comandi.ComandoPosa;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPosaTest {
	private Partita partita;
	private Borsa borsa;
	private Attrezzo attrezzo;
	private AbstractComando comando;
	private Stanza stanza;
	
	@Before
	public void setUp(){

		this.partita=new Partita();
		this.borsa=partita.getGiocatore().getBorsa();
		this.attrezzo=new Attrezzo("attrezzo",5);
		this.comando=new ComandoPosa();
		this.stanza =this.partita.getStanzaCorrente();

	}
	
	@Test
	public void testSetParametro() {
		
		String parametro="prova";
		AbstractComando comando=new ComandoPosa();
		comando.setParametro(parametro);
		assertSame(parametro,comando.getParametro());
		
		
	}
	

	@Test
	public void testEseguiValido() {
		borsa.addAttrezzo(attrezzo);
		assertFalse(borsa.isEmpty());
		comando.setParametro("attrezzo");
		comando.esegui(partita);
		assertTrue(borsa.isEmpty());
		assertTrue(stanza.hasAttrezzo(attrezzo.getNome()));
	}
	
	@Test
	public void testEseguiOggettoNonPresenteInBorsa() {
		borsa.addAttrezzo(attrezzo);
		comando.setParametro("nonoggetto");
		comando.esegui(partita);
		assertFalse(borsa.isEmpty());
		assertFalse(stanza.hasAttrezzo(attrezzo.getNome()));
		assertTrue(borsa.hasAttrezzo(attrezzo.getNome()));
	}
	@Test
	public void testEseguiParametroNullo() {
		borsa.addAttrezzo(attrezzo);
		comando.setParametro(null);
		comando.esegui(partita);
		assertFalse(borsa.isEmpty());
		assertFalse(stanza.hasAttrezzo(attrezzo.getNome()));
	}
	@Test
	public void testEseguiStanzaPiena(){
		borsa.addAttrezzo(attrezzo);
		for(int i=0;i<9;i++){ //osso già presente
			stanza.addAttrezzo(attrezzo);
		}
		comando.setParametro("attrezzo");
		comando.esegui(partita);
		assertTrue(borsa.hasAttrezzo(attrezzo.getNome()));
		
	}
	

}
