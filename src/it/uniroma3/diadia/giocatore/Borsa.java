package it.uniroma3.diadia.giocatore;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Attrezzo[] attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new Attrezzo[10]; //Trasformo in lista
		this.numeroAttrezzi = 0;
	}
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(attrezzo!=null){
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		if (this.numeroAttrezzi == 10)
			return false;
		this.attrezzi[this.numeroAttrezzi] = attrezzo;
		this.numeroAttrezzi++;
		return true;
		}
		else return false;
	}
	public int getPesoMax() {	 	//rimuovo peso max
		return pesoMax;
	}
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		for (int i = 0; i < this.numeroAttrezzi; i++)
			if (this.attrezzi[i].getNome().equals(nomeAttrezzo))
				a = attrezzi[i];
		return a;
	}
	public int getPeso() {
		int peso = 0;
		/*Iterator<Attrezzo> iteratore = this.attrezzi.iterator();
		while(iteratore.hasNext()){
			Attrezzo a = iteratore.next();
			peso += a.getPeso();
		for(Attrezzo a : this.attrezzi)
			peso += a.getPeso();
		return peso;*/
		for (int i = 0; i < this.numeroAttrezzi; i++)
			peso += this.attrezzi[i].getPeso();
		return peso;
	}
	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo) != null;
	}
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		// ---> TODO (implementare questo metodo) <---
		boolean trovato=false;
		for(int i = 0;!trovato && i<attrezzi.length;i++){
			if(attrezzi[i]!=null)
				if(nomeAttrezzo.equals(attrezzi[i].getNome())){
					trovato = true;
					numeroAttrezzi--;
					a=attrezzi[i];
					attrezzi[i]=attrezzi[numeroAttrezzi];
					attrezzi[numeroAttrezzi]=null;
				}
		}
		if(trovato == true)
			System.out.println("l' attrezzo "+nomeAttrezzo+" è stato rimosso dalla borsa");
		else System.out.println("l' attrezzo non è nella borsa");
		return a;
	}
	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa (" + this.getPeso() + "kg/" + this.getPesoMax() + "kg): ");
			for (int i = 0; i < this.numeroAttrezzi; i++)
				s.append(attrezzi[i].toString() + " ");
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
}