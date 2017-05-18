package MezzoInter;

import java.lang.reflect.GenericArrayType;

public class Ferrari extends Auto{
private int cavalli;
	public Ferrari(String posizioneSterzo, int targa,int cavalli) {
		super(posizioneSterzo, targa);
		// TODO Auto-generated constructor stub
		this.cavalli = cavalli;
	}

	public int getCavalli() {
		return cavalli;
	}

	@Override
		public void impostaPosizionesterzo(String ciao) {
			// TODO Auto-generated method stub
			super.impostaPosizionesterzo("destra");
		}
	@Override
	public String getPosizioneSterzo(){
		return super.getPosizioneSterzo();
	}
	
	@Override
		public int targa() {
			// TODO Auto-generated method stub
			return 1;
		}
	

}
