package it.uniroma3.diadia.giocatore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatoreAttrezziPerNome;
import it.uniroma3.diadia.attrezzi.ComparatoreAttrezziPerPeso;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Map <String, Attrezzo> attrezzi;
	private int pesoMax;
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new HashMap<>(); 
	}
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (attrezzo != null) {
			if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
				return false;
			if (!this.attrezzi.containsKey(attrezzo.getNome())) {
				this.attrezzi.put(attrezzo.getNome(), attrezzo);
				return true;
			}
		}
		return false;
	}
	public int getPesoMax() {	 	//rimuovo peso max
		return pesoMax;
	}
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.get(nomeAttrezzo);
	}

	public int getPeso() {
		int peso = 0;
		Iterator<Attrezzo> iteratore = this.attrezzi.values().iterator();
		while(iteratore.hasNext())
			peso += iteratore.next().getPeso();
		return peso;
	}
	public boolean isEmpty() {
		return this.attrezzi.isEmpty();
	}
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.containsKey(nomeAttrezzo);
	}
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = this.attrezzi.get(nomeAttrezzo);
		if(this.attrezzi.remove(nomeAttrezzo, a)){
			System.out.println("l' attrezzo "+nomeAttrezzo+" è stato rimosso dalla borsa");
			return a;
		}
		else System.out.println("l' attrezzo non è nella borsa");
		return null;
		
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa (" + this.getPeso() + "kg/" + this.getPesoMax() + "kg): ");
			s.append(this.getContenutoOrdinatoPerPeso().toString()+ " ");
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
	/**
	 * restituisce la lista degli attrezzi nella borsa ordinati per peso e
	 * quindi, a parità di peso, per nome
	 */
	public List<Attrezzo> getContenutoOrdinatoPerPeso(){
		ComparatoreAttrezziPerPeso comparatore = new ComparatoreAttrezziPerPeso();
		List<Attrezzo> lista = new ArrayList<>(attrezzi.values());
		Collections.sort(lista, comparatore);
		return lista;
	}
	/**
	 * restituisce l'insieme degli attrezzi nella borsa ordinati per nome
	 */
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
		SortedSet<Attrezzo> s = new TreeSet<>(new ComparatoreAttrezziPerNome());
		List<Attrezzo> lista = new ArrayList<>(attrezzi.values());
		s.addAll(lista);
		return s;
	}
	
	/**
	 * restituisce una mappa che associa un intero (rappresentante un
	 * peso) con l’insieme (comunque non vuoto) degli attrezzi di tale
	 * peso: tutti gli attrezzi dell'insieme che figura come valore hanno lo
	 * stesso peso pari all'intero che figura come chiave
	 */
	public Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		Map<Integer, Set<Attrezzo>> mappa = new HashMap<>();
		Iterator<Attrezzo> iteratore = this.attrezzi.values().iterator();
		while(iteratore.hasNext()){
			Attrezzo a = iteratore.next();
			if(mappa.containsKey(a.getPeso()))
				mappa.get(a.getPeso()).add(a);
			else{
				Set<Attrezzo> s = new HashSet<>();
				s.add(a);
				mappa.put(a.getPeso(),s);
			}
		}
		return mappa;
	}
	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
		SortedSet<Attrezzo> s = new TreeSet<>(new ComparatoreAttrezziPerPeso());
		List<Attrezzo> lista = new ArrayList<>(attrezzi.values());
		s.addAll(lista);
		return s;
	}
	
}