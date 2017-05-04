
public class Coppias {
	public static <T> void revenerse(Coppia<T> c){
		T tmp;
		
		tmp = c.getPrimo();
		c.setPrimo(c.getSecondo());
		c.setSecondo(tmp);
	}
	
}
