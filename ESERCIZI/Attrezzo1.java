public class Attrezzo1 {
	private String nome;
	private int peso;
	public Attrezzo1(String nome, int peso) {
		this.peso = peso;
		this.nome = nome;
	}
	public String getNome() {
		return this.nome;
	}
	public int getPeso() {
		return this.peso;
	}
	public String toString() {
		return this.getNome()+" ("+this.getPeso()+"kg)";
	}
}