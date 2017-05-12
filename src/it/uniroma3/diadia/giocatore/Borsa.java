package it.uniroma3.diadia.giocatore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {
	public final static int PESO_MAX_BORSA = 10;
	private List<Attrezzo> attrezzi;	//lista di attrezzi
	private int pesoMax;
	public Borsa() {
		this(PESO_MAX_BORSA);
	}
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new ArrayList<>(); //Trasformo in lista
	}
	public boolean addAttrezzo(Attrezzo attrezzo) {	
		if(attrezzo!=null){
			if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
				return false;
			if (this.attrezzi.size() == 10)
				return false;
			attrezzi.add(attrezzo);
			return true;
		}
		else return false;
	}
	public int getPesoMax() {	 	//rimuovo peso max
		return pesoMax;
	}
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Iterator<Attrezzo> iteratore = this.attrezzi.iterator();
		while(iteratore.hasNext()){
			Attrezzo a = iteratore.next();
			if(a.getNome().equals(nomeAttrezzo))
				return a;
		}
		return null;
	}
	public int getPeso() {
		int peso = 0;
		for(Attrezzo a : this.attrezzi)
			peso += a.getPeso();
		return peso;

	}
	public boolean isEmpty() {
		return this.attrezzi.isEmpty();
	}
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo) != null;
	}
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		boolean trovato = false;
		Iterator<Attrezzo> iteratore = this.attrezzi.iterator();
		while(iteratore.hasNext()){
			a = iteratore.next();
			if(a.getNome().equals(nomeAttrezzo)){
				iteratore.remove();
				trovato = true;
			}
		}
		if(trovato == true)
			System.out.println("l'attrezzo "+nomeAttrezzo+" è stato rimosso dalla borsa");
		else System.out.println("l'attrezzo non è nella borsa");
		return a;

	}
	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa (" + this.getPeso() + "kg/" + this.getPesoMax() + "kg): ");
			for(Attrezzo a : this.attrezzi)
				s.append(a.toString());
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
	public List<Attrezzo> getContenutoOrdinatoPerPeso(){
		Collections.sort(attrezzi, new ComparatorePesoENome());
		return attrezzi;
	}
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
	Collections.sort(attrezzi, new ComparatoreSoloNome());
	SortedSet<Attrezzo> s = new TreeSet<>();
	s.addAll(attrezzi);
	return s;
	}
}