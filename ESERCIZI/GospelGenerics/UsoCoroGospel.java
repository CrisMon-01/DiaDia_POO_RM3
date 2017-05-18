package GospelGenerics;

public  class UsoCoroGospel {
	public static <T> void riempimentoCoro(CoroGospel<? super T> c, T e){
		c.setPrimo(e);
		c.setSecondo(e);
		c.setTerzo(e);
		c.setQuarto(e);
	}

	public static <T> void stampaSuono(CoroGospel<T> t){
	String s1 = t.getPrimo().toString();
	String s2 = t.getSecondo().toString();
	String s3 = t.getTerzo().toString();
	String s4 = t.getQuarto().toString();
	System.out.println(s1+" "+s2+" "+s3+" "+s4);
	}
	
	public static void main(String[] args) {
		CoroGospel<ParteDelCoro> a = new CoroGospel<>();
		a.setPrimo(new PianoGospel("gianni", "piano"));
		a.setSecondo(new VoceGospel("giorgio","voce"));
		a.setTerzo(new BassoGospel("antonio","basso"));
		a.setQuarto(new VoceGospel("sara","secondavoce"));
		stampaSuono(a);
	}
}
