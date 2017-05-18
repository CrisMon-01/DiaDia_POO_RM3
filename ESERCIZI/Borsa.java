import java.util.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private List<Attrezzo> attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new ArrayList<>(); // speriamo che bastino...
		this.numeroAttrezzi = 0;
	}
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(attrezzo!=null){
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		if (this.attrezzi.size()==10)
			return false;
		this.attrezzi.add(attrezzo);
		return true;
		}
		else return false;
	}
	public int getPesoMax() {
		return pesoMax;
	}
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
/*		for (int i = 0; i < this.numeroAttrezzi; i++)
			if (this.attrezzi[i].getNome().equals(nomeAttrezzo))
				a = attrezzi[i];
		return a;
*/
		for(Attrezzo attr : attrezzi)
			if(attr.getNome().equals(nomeAttrezzo))
				a=attr;
		return a;
	}
	public int getPeso() {
		int peso = 0;
		for (Attrezzo attr : attrezzi)
			peso += attr.getPeso();
		return peso;
	}
	
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo) != null;
	}
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		// ---> TODO (implementare questo metodo) <---
		if(!this.hasAttrezzo(nomeAttrezzo))
			System.out.println("L'oggetto no....");
		else{
			a=this.getAttrezzo(nomeAttrezzo);
			attrezzi.remove(a);
			System.out.println("l'attrezzo è stato totlo");
			
		}
		return a;
	}
	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!attrezzi.isEmpty()) {
			s.append("Contenuto borsa (" + this.getPeso() + "kg/" + this.getPesoMax() + "kg): ");
			for (Attrezzo attr : attrezzi)
				s.append(attr.toString() + " ");
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
}