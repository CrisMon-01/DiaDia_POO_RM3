import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OrdinatoreTest {
	private Orario[] o;
	private Orario o0;
	private Orario o1;
	private Orario o2;
	private Orario o3;
	private Orario o4;
	@Before
	public void setUp() throws Exception {
		o0 = new Orario(12,30);
		o1 = new Orario(21,40);
		o2 = new Orario(9,20);
		o3 = new Orario(4,00);
		o4 = new Orario(1,35);
		o = new Orario[]{o0,o1,o2,o3,o4};
	}

	@Test
	public void testOrdina(){
		Orario[] ordinatigià=new Orario[]{o4,o3,o2,o0,o1};
		Ordinatore.ordina(o);
		//o ora è cambiato
		assertArrayEquals(ordinatigià,o);
	}

}
