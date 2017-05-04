import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CerchioTest {

	private Cerchio cerchioUnitario;
	private Punto origine;
	@Before
	public void setUp(){
		origine = new Punto(0,0);
		cerchioUnitario= new Cerchio(origine, 1);
		
	}

	@Test
	public void testGetCentro(){
		assertEquals(0, cerchioUnitario.getCentro().getX());
		assertEquals(0, cerchioUnitario.getCentro().getY());
		assertEquals(origine, cerchioUnitario.getCentro());
	}
	@Test
	public void testGetRaggio(){
		assertEquals(1, cerchioUnitario.getRaggio());
	}

}
