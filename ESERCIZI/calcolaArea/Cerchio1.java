package calcolaArea;

public class Cerchio1 implements Forma1 {
	private int raggio;
	public Cerchio1(int r) { this.raggio = r; }
	public int getRaggio() { return this.raggio; }
	@Override
	public float accetta(Calcolatore c) {
	// N.B. il tipo statico di this è quello della classe ospitante, qui Cerchio
	return c.calcola(this);
	}
}