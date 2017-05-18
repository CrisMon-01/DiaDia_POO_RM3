import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class IteratorTest {

	private List<String> empty;
	private List<String> singleton;
	private String solitario;
	
	@Before
	public void setUp(){
		this.empty = new ArrayList<>();
		this.singleton = new ArrayList<String>();	//<String> = <>
		this.solitario = new String("Solo");
		this.singleton.add(this.solitario);
	}
	@Test
	public void testHasNext_noOverEmpty(){
		Iterator<String> it = this.empty.iterator(); //creo un iterator sulla lista
		assertNotNull(it);
		assertFalse(it.hasNext());
	}
	@Test
	public void testNext_singleton(){
		Iterator<String> it = this.singleton.iterator();
		assertNotNull(it);
		assertTrue(it.hasNext());
		assertSame(this.solitario,it.next());
	}
	@Test
	public void testNext_overTwoElements(){
		List<String> doubleton = new ArrayList<>();
		
		doubleton.add("primo");
		doubleton.add("secondo");
		Iterator<String> it = doubleton.iterator();
		assertNotNull(it);
		assertTrue(it.hasNext());
		assertEquals("primo", it.next());
		assertTrue(it.hasNext());
		assertEquals("secondo", it.next());
		assertFalse(it.hasNext());
	}
}
