package MezzoInter;

public class Auto implements Guida{
	private String posizioneSterzo;
	private int targa;
	public Auto(String posizioneSterzo, int targa){
		this.posizioneSterzo = posizioneSterzo;
		this.targa = targa;
	}
	@Override
	public String sterzo() {
		// TODO Auto-generated method stub
		return "volante";
	}

	@Override
	public String nomeMezzo() {
		// TODO Auto-generated method stub
		return "auto";
	}
	@Override
	public int numeroRuote() {
		// TODO Auto-generated method stub
		return 4;
	}
	@Override
	public int targa() {
		// TODO Auto-generated method stub
		return 0000;
	}

	public String getPosizioneSterzo(){
		return this.posizioneSterzo;
	}
	public void impostaPosizionesterzo(String lato){
		this.posizioneSterzo = lato;
	}

	public void immatricola(int matricola) {
		// TODO Auto-generated method stub
		this.targa = matricola;
	}

}
