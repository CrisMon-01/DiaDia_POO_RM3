import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PersoneTest {
	private Persone p;
	@Before
	public void setUp() {
		p = new Persone(3);
		p.aggiungiNome(0, "omonimo");
		p.aggiungiNome(1, "omonimo");
		p.aggiungiNome(2, "nonomo");
	}

	@Test
	public void testContaomonimiNoName() {
		assertEquals(0, p.contaOmonimiDi(""));
	}
	@Test
	public void testContaomonimiNome() {
		assertEquals(2, p.contaOmonimiDi("omonimo"));
	}

}
