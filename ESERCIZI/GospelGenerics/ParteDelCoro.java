package GospelGenerics;

public class ParteDelCoro {
	private String nome;
	private String suono;
	public ParteDelCoro(){
		
	}
	public ParteDelCoro(String nome, String suono) {
		this.nome = nome;
		this.suono = suono;
	}
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSuono() {
		return this.suono;
	}
	public void setSuono(String suono) {
		this.suono = suono;
	}
	
	@Override
	public String toString(){
		return this.suono;
	}
	
}
