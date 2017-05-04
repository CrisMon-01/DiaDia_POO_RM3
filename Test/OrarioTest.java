import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OrarioTest {
	private Orario orariominore;
	private Orario orariomaggiore;
	
	@Before
	public void setUp(){
		orariominore = new Orario(0, 00);
		orariomaggiore = new Orario(11, 30);
		
	}

	@Test
	public void testGetOrario() {
		assertEquals(0, orariominore.getOre());
		assertEquals(11,orariomaggiore.getOre());
	}
	@Test 
	public void testGetMinuti(){
		assertEquals(30, orariomaggiore.getMinuti());
		assertEquals(00,orariominore.getMinuti());
	}
	@Test
	public void testminoreDiOK(){
		assertFalse(orariomaggiore.minoreDi(orariominore));
	}
	@Test
	public void testCompara(){
		assertEquals(-11,orariominore.compara(orariomaggiore));
	}
}
