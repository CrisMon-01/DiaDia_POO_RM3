package EserGen;

public class Animale {
	private int zampe;
	private String verso;
	private String pelo;
	public Animale(int zampe, String verso, String pelo) {
		this.zampe = zampe;
		this.verso = verso;
		this.pelo = pelo;
	}
	public int getZampe() {
		return zampe;
	}
	public void setZampe(int zampe) {
		this.zampe = zampe;
	}
	public String getVerso() {
		return verso;
	}
	public void setVerso(String verso) {
		this.verso = verso;
	}
	public String getPelo() {
		return pelo;
	}
	public void setPelo(String pelo) {
		this.pelo = pelo;
	}
	@Override
	public String toString(){
		return this.getVerso()+" "+this.getZampe()+" "+this.getPelo();
	}
}
