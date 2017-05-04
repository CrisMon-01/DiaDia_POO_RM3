import static org.junit.Assert.*;

import org.junit.Test;

public class CoppiaSenzaGenericsTest {
	@Test
	public void testCheCompilaEdEsegue() {
		Coppia coppia = new Coppia();
		String pippo = new String("Pippo");
		String pluto = new String("Pluto");
		Persona p1 = new Persona(pippo);
		coppia.setPrimo(p1);
		Persona p2 = new Persona (pluto);
		coppia.setSecondo(p2);
		Persona persona = (Persona)coppia.getPrimo();
		assertSame(pippo, persona.getNome());
	}
	@Test
	public void testCheCompilaEdEsegue2() {
		Coppia coppia = new Coppia();
		String pippo = new String("Pippo");
		String pluto = new String("Pluto");
		Persona p1 = new Persona(pippo);
		coppia.setPrimo(p1);
		Persona p2 = new Persona (pluto);
		coppia.setSecondo(p2);
		Persona persona = (Persona)coppia.getPrimo();
		assertSame(pippo, persona.getNome());
	}
}