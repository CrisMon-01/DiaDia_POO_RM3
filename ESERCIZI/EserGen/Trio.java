package EserGen;

public class Trio <T>{	//parametrico
	private T primo;
	private T secondo;
	private T terzo;
	public Trio(){
	}
	public Trio(T primo, T secondo, T terzo){
		super();
		this.primo = primo;
		this.secondo = secondo;
		this.terzo = terzo;
	}
	public T getPrimo() {
		return primo;
	}
	public void setPrimo(T primo) {
		this.primo = primo;
	}
	public T getSecondo() {
		return secondo;
	}
	public void setSecondo(T secondo) {
		this.secondo = secondo;
	}
	public T getTerzo() {
		return terzo;
	}
	public void setTerzo(T terzo) {
		this.terzo = terzo;
	}
	
	
}
