
public class PersonaS {
	private String nome;
	private int eta;
	
	PersonaS(int eta, String nome){
		this.nome = nome;
		this.eta = eta;
	}
	public int getEta(){
		return this.eta;
	}
	public String getNome(){
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setEta(int eta) {
		this.eta = eta;
	}

	@Override
	public String toString(){
		return this.getNome() +" "+ this.getEta();
	}
}
