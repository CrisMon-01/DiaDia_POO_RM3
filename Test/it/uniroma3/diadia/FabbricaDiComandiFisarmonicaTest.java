package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

public class FabbricaDiComandiFisarmonicaTest {

	private Comando comando;
	private FabbricaDiComandiFisarmonica factory;

	@Before
	public void setUp(){
		this.factory= new FabbricaDiComandiFisarmonica();
	}

	@Test
	public void testComandoNonValido() {
		comando=factory.costruisciComando("  "); 
		assertNull(comando.getNome());
		assertNull(comando.getParametro());
	}

	@Test
	public void testComandoVaiValido(){
		comando=factory.costruisciComando("vai sud"); 
		assertEquals("vai",comando.getNome());
		assertEquals("sud",comando.getParametro());
	}
	@Test
	public void testComandoVaiParametroNullo(){
		comando=factory.costruisciComando("vai");
		assertEquals("vai",comando.getNome());
		assertNull(comando.getParametro());
	}
	@Test
	public void testComandoPrendi(){
		comando=factory.costruisciComando("prendi attrezzo"); 
		assertEquals("prendi",comando.getNome());
		assertEquals("attrezzo",comando.getParametro());
	}
	@Test
	public void testComandoPrendiParametroNullo(){
		comando=factory.costruisciComando("prendi");
		assertEquals("prendi",comando.getNome());
		assertNull(comando.getParametro());
	}
	@Test
	public void testComandoPosa(){
		comando=factory.costruisciComando("posa attrezzo"); 
		assertEquals("posa",comando.getNome());
		assertEquals("attrezzo",comando.getParametro());
	}
	@Test
	public void testComandoPosaParametroNullo(){
		comando=factory.costruisciComando("posa");
		assertEquals("posa",comando.getNome());
		assertNull(comando.getParametro());
	}
	@Test
	public void testComandoAiuto(){
		comando=factory.costruisciComando("aiuto"); 
		assertEquals("aiuto",comando.getNome());
		assertNull(comando.getParametro());
	}
	@Test
	public void testComandoFine(){
		comando=factory.costruisciComando("fine"); 
		assertEquals("fine",comando.getNome());
		assertNull(comando.getParametro());
	}
	@Test
	public void testComandoGuarda(){
		comando=factory.costruisciComando("guarda"); 
		assertEquals("guarda",comando.getNome());
		assertNull(comando.getParametro());
	}
}

