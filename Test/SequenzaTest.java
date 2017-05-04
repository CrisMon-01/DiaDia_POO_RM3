import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SequenzaTest {
	private Sequenza seq;
	
	@Before
	public void setUp(){
		seq = new Sequenza(2);
		seq.setElemento(0,1);
		seq.setElemento(1,5);
	}
	@Test
	public void massimotest() {
		assertEquals(5, this.seq.massimo());
	}
}
