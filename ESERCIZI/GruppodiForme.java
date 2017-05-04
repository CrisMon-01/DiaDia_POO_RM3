
public class GruppodiForme implements Forma{
	private Forma[] forme;
	private int numeroForme;
	public GruppodiForme (){
		this.forme = new Forma[10];
		this.numeroForme=0;
	}

	public void trasla(int deltax,int deltay){
		for(int i = 0; i<numeroForme;i++)
			forme[i].trasla(deltax, deltay);

	}
	public void aggiungiForma(Forma forma){
		if(numeroForme<10){
			this.forme[numeroForme] = forma;
			numeroForme++;
		}
		else System.out.println("non puoi aggiungere");
	}
}
