
public class Coppia <T>{
	private T primo;
	private T secondo;
	public Coppia() {
	}
	public Coppia(T primo, T secondo) {
		this.primo = primo;
		this.secondo = secondo;
	}
	public T getPrimo() {
		return this.primo;
	}
	public T getSecondo() {
		return this.secondo;
	}
	/*public void copyall(Coppia<? extends T> c){
		this.setPrimo(coppia.getPrimo());
		this.setSecondo(coppia.getSecondo());
	}*/
	public void setPrimo(T primo) {
		this.primo = primo;
	}
	public void setSecondo(T secondo) {
		this.secondo = secondo;
	}
}