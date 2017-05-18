package GospelGenerics;

public class BassoGospel extends ParteDelCoro{

	public BassoGospel(){
		
	}
	public BassoGospel(String nome, String suono) {
		super(nome, suono);
		
	}

	@Override
	public String getSuono(){
		return "Suono Basso";
	}
	@Override
	public String toString(){
		return super.getNome()+this.getSuono();
	}
	
}
