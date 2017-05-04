import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CoppiaTest {

	@Test
	public void testCoppiaDiPersone() {
		Coppia<Persona> coppia;
		Persona p1 = new Persona("Stanlio");
		Persona p2 = new Persona("Olio");
		coppia = new Coppia<Persona>(p1,p2);
		assertSame(p1, coppia.getPrimo());
		assertSame(p2, coppia.getSecondo());
	}

}
