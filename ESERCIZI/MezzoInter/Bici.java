package MezzoInter;

public class Bici implements Guida{
	private int targa;
	public Bici(int targa) {
		this.targa = targa;
	}

	@Override
	public String sterzo() {
		// TODO Auto-generated method stub
		return "sterzo bicicletta";
	}

	@Override
	public String nomeMezzo() {
		// TODO Auto-generated method stub
		return "Bici";
	}

	@Override
	public int numeroRuote() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public int targa() {
		// TODO Auto-generated method stub
		return this.targa;
	}


}
