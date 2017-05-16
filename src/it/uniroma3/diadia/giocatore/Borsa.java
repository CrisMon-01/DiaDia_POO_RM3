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
	//CAMPI
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Map <String, Attrezzo> attrezzi;
	private int pesoMax;
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	/**
	 * costruttore della Borsa
	 * @param pesoMax
	 */
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new HashMap<>(); 
	}
	/**
	 * metodo che tenta di aggiungere l' attrezzo passato come parametro
	 * alla borsa corrente tramite la chiave (nome dell' attrezzo) e il
	 * valore che è l' attrezzo vero e proprio
	 * @param attrezzo
	 * @return true se l' attrezzo è stato aggiunto alla borsa
	 */
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
	/**
	 * peso max è posto come una costante
	 * @return il peso max della borsa
	 */
	public int getPesoMax() {	 	//rimuovo peso max
		return pesoMax;
	}
	/**
	 * tramite la stringa del nome attrezzo cerco tra le chiavi se quell' 
	 * attrezzo è presente tra le chiavi
	 * @param nomeAttrezzo
	 * @return un Attrezzo se presente nella borsa
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.get(nomeAttrezzo);
	}
	/**
	 * scorro la lista di attrezzi e aggiungo al tot il
	 * peso dell' ultimo attrezzo
	 * @return peso tot
	 */
	public int getPeso() {
		int peso = 0;
		Iterator<Attrezzo> iteratore = this.attrezzi.values().iterator();
		while(iteratore.hasNext())
			peso += iteratore.next().getPeso();
		return peso;
	}
	/**
	 * 
	 * @return true se è vuota
	 */
	public boolean isEmpty() {
		return this.attrezzi.isEmpty();
	}
	/**
	 * cerco tra la collezioni di attrezzi ce ne è uno con 
	 * una determinata chiave passata come parametro
	 * @param nomeAttrezzo
	 * @return true se nella borsa c' è un attrezzo cercato
	 * 
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.containsKey(nomeAttrezzo);
	}
	/**
	 * cerco tramite la chiave nomeAttrezzo se è presente un oggetto
	 * se presente nella collezione lo rimuovo e lo ritorno all' 
	 * esterno del metodo
	 * @param nomeAttrezzo
	 * @return Attrezzo
	 */
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = this.attrezzi.get(nomeAttrezzo);
		if(this.attrezzi.remove(nomeAttrezzo, a)){
			System.out.println("l' attrezzo "+nomeAttrezzo+" è stato rimosso dalla borsa");
			return a;
		}
		else System.out.println("l' attrezzo non è nella borsa");
		return null;
	}
	/**
	 * descrizione del contenuto della borsa
	 */
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