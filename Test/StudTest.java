import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StudTest {

	

	@Test
	public void testOrdinamento() {
		Stud s1 = new Stud("stud",14);
		Stud s2 = new Stud("stud",13);
		Stud s3 = new Stud("stud",12);
		Stud s4 = new Stud("stud",11);
		Stud[] s = new Stud[] {s1,s2,s3,s4};
		Stud [] s5 = new Stud[]{s4,s3,s2,s1}; 
		Ordinatore.ordina(s);
		assertArrayEquals(s,s5);
	}

}
