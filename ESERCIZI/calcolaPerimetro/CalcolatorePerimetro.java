package calcolaPerimetro;

public class CalcolatorePerimetro implements calcolap{

	@Override
	public float calcola(Cerchio2 c) {
		// TODO Auto-generated method stub
		return 2*3.14f *c.getRaggio() ;
	}

	@Override
	public float calcola(Quadrato2 q) {
		// TODO Auto-generated method stub
		return 4*q.getLato();
	}
	
}
