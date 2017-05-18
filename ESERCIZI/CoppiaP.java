
public class CoppiaP<T> {
	private T primo;
	private T secondo;
	
	public CoppiaP(){
		
	}
	
	public CoppiaP(T primo, T secondo) {
		super();
		this.primo = primo;
		this.secondo = secondo;
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
	

}
