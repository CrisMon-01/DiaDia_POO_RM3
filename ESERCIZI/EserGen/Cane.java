package EserGen;

public class Cane extends Animale{
	private int coda;
	public Cane(int zampe, String verso,String pelo, int coda) {
		super(zampe, verso, pelo);
		this.coda=coda;
	}
	public int getCoda() {
		return coda;
	}
	public void setCoda(int coda) {
		this.coda = coda;
	}
	@Override
	public String toString(){
		return super.toString()+" "+this.getCoda();
	}

}
