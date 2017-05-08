package it.uniroma3.diadia.ambienti;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * 
 * @author docente di POO 
 * @see Attrezzo
 * @version base
 */

public class Stanza {

	//static final private int NUMERO_MASSIMO_DIREZIONI = 4;	//rende immodificabile il numero max di dir adiacenti
	//static final private int NUMERO_MASSIMO_ATTREZZI = 10;

	private String nome;
	private  List<Attrezzo> attrezzi;
	private int numeroAttrezzi;
	private List<Stanza> stanzeAdiacenti;
	private int numeroStanzeAdiacenti;
	private List<String> direzioni;

	/**
	 * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
	 * @param nome il nome della stanza
	 */
	public Stanza(String nome) {
		this.nome = nome;
		this.numeroStanzeAdiacenti = 0;
		this.numeroAttrezzi = 0;
		this.direzioni = new ArrayList<>();//String[NUMERO_MASSIMO_DIREZIONI];
		this.stanzeAdiacenti = new ArrayList<>();//Stanza[NUMERO_MASSIMO_DIREZIONI];
		this.attrezzi = new ArrayList<>();//Attrezzo[NUMERO_MASSIMO_ATTREZZI];
	}

	/**
	 * Imposta una stanza adiacente.
	 *
	 * @param direzione direzione in cui sara' posta la stanza adiacente.
	 * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
	 */
	public void impostaStanzaAdiacente(String direzione, Stanza stanza) {
		boolean aggiornato = false;
		Iterator<String> iteratore = this.direzioni.iterator();
		if(stanza!=null)
			while(iteratore.hasNext() && !aggiornato)
			if(direzione.equals(iteratore.next())){
				stanzeAdiacenti.add(stanza);
				aggiornato = true;
			}
			else{
				this.direzioni.add(direzione);
				this.stanzeAdiacenti.add(stanza);
				numeroStanzeAdiacenti++;
				aggiornato = true;
			}
				
		/*	for(int i=0; i<this.direzioni.length && !aggiornato; i++)
				if (direzione.equals(this.direzioni[i])) {
					this.stanzeAdiacenti[i] = stanza;
					aggiornato = true;
				}
		for(int i = 0; i<this.direzioni.length;i++)
			if (!aggiornato)	//sfrutto numeromaxdirezioni
				if (this.numeroStanzeAdiacenti < NUMERO_MASSIMO_DIREZIONI) {
					this.direzioni[numeroStanzeAdiacenti] = direzione;
					this.stanzeAdiacenti[numeroStanzeAdiacenti] = stanza;
					this.numeroStanzeAdiacenti++;
					aggiornato = true;
				}*/
	}

	/**
	 * Restituisce la stanza adiacente nella direzione specificata
	 * @param direzione
	 */
	public Stanza getStanzaAdiacente(String direzione) {
		Stanza stanza = null;
		int index = 0;
		boolean trovato = true;
		Iterator<String> iteratore = this.direzioni.iterator();
		while(iteratore.hasNext() && trovato){
			index++;
			if(direzione.equals(iteratore.next()))
				trovato = false;
		}
		return stanzeAdiacenti.get(index);	
		/*for(int i=0; i<this.numeroStanzeAdiacenti; i++)
			if (this.direzioni[i].equals(direzione))
				stanza = this.stanzeAdiacenti[i];
		return stanza;*/
	}

	/**
	 * Restituisce la nome della stanza.
	 * @return il nome della stanza
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Restituisce la descrizione della stanza.
	 * @return la descrizione della stanza
	 */
	public String getDescrizione() {
		return this.toString();
	}

	/**
	 * Restituisce la collezione di attrezzi presenti nella stanza.
	 * @return la collezione di attrezzi nella stanza.
	 */
	public List<Attrezzo> getAttrezzi() {
		return this.attrezzi;
	}

	/**
	 * Mette un attrezzo nella stanza.
	 * @param attrezzo l'attrezzo da mettere nella stanza.
	 * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(attrezzo != null){
			attrezzi.add(attrezzo);
			numeroAttrezzi++;
			return true;
		}
		else return false;
		/*if (attrezzo!= null && this.numeroAttrezzi < NUMERO_MASSIMO_ATTREZZI) {
			this.attrezzi[numeroAttrezzi] = attrezzo;
			this.numeroAttrezzi++;
			return true;
		}
		else {
			return false;
		}*/
	}

	/**
	 * Restituisce una rappresentazione stringa di questa stanza,
	 * stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	 * @return la rappresentazione stringa
	 */
	public String toString() {
		StringBuilder risultato = new StringBuilder();
		risultato.append(this.nome);
		risultato.append("\nUscite: ");
		for (String direzione : this.direzioni)
			if (direzione!=null)
				risultato.append(" " + direzione);
		risultato.append("\nAttrezzi nella stanza: ");
		for (Attrezzo attrezzo : this.attrezzi) {
			if(attrezzo != null)
				risultato.append(attrezzo.toString()+" ");
		}
		return risultato.toString();
	}

	/**
	 * Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	 * @return true se l'attrezzo esiste nella stanza, false altrimenti.
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {
		boolean trovato;
		trovato = false;
		for (Attrezzo attrezzo : this.attrezzi) {
			if (attrezzo !=null && attrezzo.getNome().equals(nomeAttrezzo))
				trovato = true;
		}
		return trovato;
	}

	/**
	 * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
	 * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo attrezzoCercato = null;
		Iterator<Attrezzo> iteratore = this.attrezzi.iterator();
		while(iteratore.hasNext()){
			attrezzoCercato = iteratore.next();
					if(nomeAttrezzo.equals(iteratore.next().getNome()))
						return attrezzoCercato;
		}
		if(attrezzoCercato==null)
			System.out.println("l' oggetto non è nella stanza");
		return attrezzoCercato;
		
		/*for (int i = 0;attrezzi[i]!= null && i<attrezzi.length;i++) {
			if(nomeAttrezzo.equals(attrezzi[i].getNome()))
				attrezzoCercato = attrezzi[i];
		}
		if(attrezzoCercato==null)
			System.out.println("l' oggetto non è nella stanza");
		return attrezzoCercato;*/
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		// TODO da implementare
		boolean trovato = false;
		if(attrezzi.remove(attrezzo))
			return true;
		else{
			System.out.println("l' oggetto non è nella stanza");
			return false;
		}
		/*
		if(attrezzo!= null)
			for(int i = 0; i<this.attrezzi.length && !trovato;i++)
				if(attrezzi[i]!=null)
					if(attrezzo.getNome().equals(attrezzi[i].getNome())){
						attrezzi[i] = attrezzi[numeroAttrezzi-1];
						attrezzi[numeroAttrezzi-1]= null;
						numeroAttrezzi--;
						trovato = true;				
					}
		if(!trovato){
			System.out.println("questo attrezzo non è nella stanza");
			return trovato;
		}
		else 
			return trovato;	*/	
	}


	public List<String> getDirezioni() {
		/*String[] direzioni = new String[this.numeroStanzeAdiacenti];
		for(int i=0; i<this.numeroStanzeAdiacenti; i++)
			direzioni[i] = this.direzioni[i];*/
		return direzioni;
	}

}