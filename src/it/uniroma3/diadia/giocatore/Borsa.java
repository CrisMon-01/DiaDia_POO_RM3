package it.uniroma3.diadia.giocatore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {
	public final static int PESO_MAX_BORSA = 10;
	private Map<String, Attrezzo> attrezzi;	//lista di attrezzi
	private int pesoMax;
	public Borsa() {
		this(PESO_MAX_BORSA);
	}
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new HashMap<>(); //Trasformo in mappa	
	}

	public boolean addAttrezzo(Attrezzo attrezzo) {	
		if(attrezzo!=null){
			if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
				return false;	
			if(!this.attrezzi.containsKey(attrezzo.getNome())){
				this.attrezzi.put(attrezzo.getNome(),attrezzo);
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
			Iterator<Attrezzo> it = this.attrezzi.values().iterator();
			while(it.hasNext())
				peso += it.next().getPeso();
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
			if(this.attrezzi.remove(nomeAttrezzo, this.attrezzi.get(nomeAttrezzo))){
				System.out.println("l' attrezzo"+nomeAttrezzo+" è stato rimosso");
				return a;
			}
			else System.out.println("l' attrezzo non è nella borsa");
			return null;
		}
		public String toString() {
			StringBuilder s = new StringBuilder();
			Iterator<Attrezzo> it = this.getContenutoOrdinatoPerPeso().iterator();
			if (!this.isEmpty()) {
				s.append("Contenuto borsa (" + this.getPeso() + "kg/" + this.getPesoMax() + "kg): ");
				s.append(this.getContenutoOrdinatoPerPeso().toString()+" ");
			}
			else
				s.append("Borsa vuota");
			return s.toString();
		}

		public List<Attrezzo> getContenutoOrdinatoPerPeso(){
			List<Attrezzo> lista = new ArrayList<>(attrezzi.values());
			Collections.sort(lista, new ComparatorePesoENome());
			return lista;
		}

		public SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
			SortedSet<Attrezzo> s = new TreeSet<>();
			List<Attrezzo> lista = new ArrayList<>(attrezzi.values());
			Collections.sort(lista, new ComparatoreSoloNome());
			s.addAll(lista);
			return s;
		}

		public Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
			Map<Integer, Set<Attrezzo>> m = new HashMap<>();
			Iterator<Attrezzo> it = attrezzi.values().iterator();
			Attrezzo a = it.next();
			while(it.hasNext())
				if(m.containsKey(a.getPeso()))
					m.get(a.getPeso()).add(a);
				else{ 
					Set<Attrezzo> s = new HashSet<>();
					s.add(a);
					m.put(a.getPeso(), s);
				}
			return m;
		}
		public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
			SortedSet<Attrezzo> s = new TreeSet<>();
			List<Attrezzo> lista = new ArrayList<>(attrezzi.values());
			Collections.sort(lista, new ComparatorePesoENome());
			s.addAll(lista);
			return s;
		}

	}