
public class Stud implements Comparabile{
	private String nome;
	private int eta;
	public Stud(String nome,int eta){
		this.nome = nome;
		this.eta = eta;
	}
	
	
	public int getEta(){
		return this.eta;
	}
	@Override
	public boolean minoreDi(Comparabile c) {
		// TODO Auto-generated method stub
		Stud ss = (Stud)c; 
		if(ss.getEta()>this.getEta())
			return true;
		else
			return false;
	}


	@Override
	public int compara(Comparabile c) {
		// TODO Auto-generated method stub
		int delta;
		Stud s;
		s=(Stud) c;
		delta= this.getEta() - s.getEta();
		return delta;
	}

}
