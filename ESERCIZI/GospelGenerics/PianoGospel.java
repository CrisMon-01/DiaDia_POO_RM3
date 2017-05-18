package GospelGenerics;

public class PianoGospel extends ParteDelCoro{

	public PianoGospel(){
		
	}
	public PianoGospel(String nome, String suono) {
		super(nome, suono);
		
	}
	@Override
	public String getSuono(){
		return "Suono del piano";
	}
	@Override 
	public String toString(){
		return super.getNome()+ this.getSuono();
	}


}
