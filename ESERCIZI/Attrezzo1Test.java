
public class Attrezzo1Test {
	public static void main (String[]args){
		Attrezzo1 scudo= new Attrezzo1("scudo",10);
		Attrezzo1 cacciavite= new Attrezzo1("cacciavite",1);

		System.out.println(scudo.getPeso()+cacciavite.getPeso());
		if(scudo.getPeso()>cacciavite.getPeso())
			System.out.println("scudo + pesante");
		else
			System.out.println("cacciavite + pesante");
		Attrezzo1 a = new Attrezzo1("spada", 40);
		Attrezzo1 b = new Attrezzo1("scudo", 30);
		Attrezzo1 c = new Attrezzo1("lancia", 10);
		System.out.println(a.toString()+ b.toString());
		a = b;
		System.out.println(a.toString());
		Attrezzo1[] attrezzi;
		attrezzi = new Attrezzo1[5];
		Attrezzo1 d = new Attrezzo1("spada", 40);
		Attrezzo1 e = new Attrezzo1("scudo", 30);
		attrezzi[0] = d;
		attrezzi[1] = e;
		System.out.println(attrezzi[0]);
		d = e;
		System.out.println(attrezzi[0]);
	}
}
