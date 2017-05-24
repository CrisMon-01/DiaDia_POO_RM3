package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.comandi.AbstractComando;
import it.uniroma3.diadia.comandi.ComandoVai;

	public class ComandoVaiTest {
	private Partita partita;
	private AbstractComando comando;
	

	@Before
	public void setUp() throws Exception {
		this.partita=new Partita();
		this.comando=new ComandoVai();
	}

	@Test
	public void testEseguiDirezioneValida() {
	comando.setParametro("sud");
	comando.esegui(this.partita);
	assertEquals("Biblioteca",partita.getStanzaCorrente().getNome());
	}
	
	@Test
	public void testEseguiNullo() {
	comando.setParametro(null);
	comando.esegui(this.partita);
	assertEquals("Atrio",this.partita.getStanzaCorrente().getNome());
	}
	
	@Test
	public void testEseguiDirezioneNonValida() {
		comando.setParametro("est");
		comando.esegui(this.partita);
		comando.setParametro("sud");
		comando.esegui(this.partita);
		assertEquals("Laboratorio Campus",this.partita.getStanzaCorrente().getNome());
	}

}
