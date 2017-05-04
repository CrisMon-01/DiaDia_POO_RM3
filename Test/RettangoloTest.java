import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RettangoloTest {
	private Rettangolo rettangolo;
	private Punto origine;
	@Before
	public void setUp(){
	origine = new Punto(0,0);
	rettangolo = new Rettangolo(origine, 3,3);
	}
	@Test
	public void testGet(){
		assertEquals(3,rettangolo.getBase());
		assertEquals(3,rettangolo.getAltezza());
	}
	@Test
	public void testGetVertice(){
		assertEquals(origine, rettangolo.getVertice());
	}
}
