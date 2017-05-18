package MezzoInter;

public class officina {
	public static void main (String [] args){

		Auto a = new Auto("500", 500);
		Bici b = new Bici(20);
		Ferrari f = new Ferrari("sinistra", 100, 900);
		Auto ff = new Ferrari("destra" , 101, 750);
		
		f.impostaPosizionesterzo(" sterzo ");	//TIPO DINAMICO FERRARI
		ff.impostaPosizionesterzo("sinistra");	//TIPO DINAMICO FERRARI
		System.out.println(a.getPosizioneSterzo());
		System.out.println(f.getPosizioneSterzo());
		System.out.println(ff.getPosizioneSterzo());
		System.out.println(b.targa());
		System.out.println(f.targa());
		System.out.println(ff.targa());
	}
}
