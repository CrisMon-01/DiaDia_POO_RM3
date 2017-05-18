package EserGen;

import java.util.StringTokenizer;

public class TrioO {
	public static <T> void riempidi(Trio<? super T> c,T e){
		
		c.setPrimo(e);
		c.setSecondo(e);
		c.setTerzo(e);
		
	}
	public static <T> void stampaverso(Trio<T> t){
		StringTokenizer st1 = new StringTokenizer(t.getPrimo().toString());
		StringTokenizer st2 = new StringTokenizer(t.getSecondo().toString());
		StringTokenizer st3 = new StringTokenizer(t.getTerzo().toString());
		
		String s1 = st1.nextToken();
		String s2 = st2.nextToken();
		String s3 = st3.nextToken();
		System.out.println(s1+s2+s3);
	}
	public static void main(String[] args){
		
		Trio<Animale> t = new Trio<>();
		Animale gatto = new Animale(4,"miao", "corto");
		Animale cane = new Animale(4,"bau","medio");
		Animale cavallo = new Animale(4, "hihihi","corto");
		TrioO.riempidi(t, gatto);
		System.out.println(t.getPrimo().toString()+" "+t.getSecondo().toString());
	
		Trio<Animale> s = new Trio<>();
		Animale g = new Animale(4,"miao", "corto");
		Animale can = new Cane(4,"bau","medio",2);
		Animale cav = new Animale(4, "hihihi","corto");
		TrioO.riempidi(s, can);
		System.out.println(t.getPrimo().toString()+" "+t.getTerzo().toString());
		
		Trio<Animale> k = new Trio<>();
		k.setPrimo(gatto);
		k.setSecondo(cane);
		k.setTerzo(cavallo);
		TrioO.stampaverso(k);
		
	}
	
}



