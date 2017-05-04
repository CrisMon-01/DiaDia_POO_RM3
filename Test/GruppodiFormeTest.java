import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GruppodiFormeTest {
	private GruppodiForme forme;
	private Rettangolo r1;
	private Rettangolo r2;
	private Cerchio c;
	private Forma f;
	private Punto p1;
	private Punto p2;
	private Punto origin;
	@Before
	public void setUp() {
		origin = new Punto(0,0);
		p1 = new Punto(1,2);
		p2 = new Punto(3,4);
		f = new Cerchio(p1,0);
		r1 = new Rettangolo(p1,2,5);
		r2 = new Rettangolo(p2,3,3);
		c = new Cerchio(origin, 2);
		forme = new GruppodiForme();
		forme.aggiungiForma(r1);
	}
	

	@Test
	public void testTrasla() {
		forme.trasla(2,2);
		Punto finale = new Punto(3,4);
		assertEquals(finale, r1.getVertice());
	}

}
