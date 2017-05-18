package GospelGenerics;

public class VoceGospel extends ParteDelCoro {

	public VoceGospel(){
		
	}
	public VoceGospel(String nome, String suono) {
		super(nome, suono);
		
	}
	@Override 
	public String getSuono(){
		return "Voce del coro";
	}

	@Override
	public String toString(){
		return super.getNome()+this.getSuono();
	}

}
