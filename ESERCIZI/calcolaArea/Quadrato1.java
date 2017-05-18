package calcolaArea;

public class Quadrato1 implements Forma1 {
	private int lato;

	public Quadrato1(int l) {
		this.lato = l;
	}

	public int getLato() {
		return this.lato;
	}

	@Override
	public float accetta(Calcolatore c) {
		// N.B. il tipo statico di this è quello della classe ospitante, qui
		// Cerchio
		return c.calcola(this);
	}
}