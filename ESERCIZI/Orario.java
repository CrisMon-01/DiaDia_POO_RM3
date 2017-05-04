
public class Orario implements Comparabile {
	private int ore;
	private int minuti;
	public Orario(int ore, int minuti) {
		this.ore = ore;
		this.minuti = minuti;
	}
	public int getOre() {
		return this.ore;
	}
	public int getMinuti() {
		return this.minuti;
	}
	public boolean minoreDi(Comparabile c) {
		Orario o;
		o=(Orario) c;
		if (this.getOre() > o.getOre())
			return false;
		if (this.getOre() == o.getOre())
			return (this.getMinuti() < o.getMinuti());
		return true;
	}
	public String toString() {
		return this.getOre() + ":" + this.getMinuti();
	}
	@Override
	public int compara(Comparabile c) {
		// TODO Auto-generated method stub
		int delta;
		Orario o;
		o=(Orario) c;
		delta = this.getOre()- o.getOre();
		return delta;
	}
}