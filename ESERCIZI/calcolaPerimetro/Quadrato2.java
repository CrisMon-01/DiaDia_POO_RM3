package calcolaPerimetro;

public class Quadrato2 implements Forma2{
private float lato;
public Quadrato2(float lato){
	this.lato = lato;
}
public float getLato(){
	return this.lato;
}
	@Override
	public float accetta(calcolap p) {
		// TODO Auto-generated method stub
		return p.calcola(this);
	}
	public void setLato(int k){
		this.lato=k;
	}

}
