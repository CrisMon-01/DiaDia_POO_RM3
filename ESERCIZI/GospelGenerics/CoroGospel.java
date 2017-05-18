package GospelGenerics;

public class CoroGospel<T>{
	private T primo;
	private T secondo;
	private T terzo;
	private T quarto;
	public CoroGospel(){
	}
	
	public CoroGospel(T primo, T secondo, T terzo, T quarto) {
		super();
		this.primo = primo;
		this.secondo = secondo;
		this.terzo = terzo;
		this.quarto = quarto;
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
	public T getQuarto() {
		return quarto;
	}
	public void setQuarto(T quarto) {
		this.quarto = quarto;
	}


}
