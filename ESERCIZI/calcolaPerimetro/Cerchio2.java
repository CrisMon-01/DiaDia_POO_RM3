package calcolaPerimetro;

public class Cerchio2 implements Forma2{
	private float raggio;
	public Cerchio2(float raggio){
		this.raggio = raggio;
	}
	
	public float getRaggio(){
		return this.raggio;
	}
	@Override
	public float accetta(calcolap p) {
		// TODO Auto-generated method stub
		return p.calcola(this);
	}
	public void setRaggio(int k){
		this.raggio = k;
	}
}
