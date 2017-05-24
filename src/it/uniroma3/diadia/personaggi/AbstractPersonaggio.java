package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public abstract class AbstractPersonaggio {
	private String nome;
	private String presentazione;
	private boolean haSalutato;

	public AbstractPersonaggio(String nome, String presentaz) {
		this.nome = nome;
		this.presentazione = presentaz;
		this.haSalutato = false;		//vedere il super.
	}

	public String getNome() {
		return this.nome;
	}

	public boolean haSalutato() {
		return this.haSalutato;
	}
	public String saluta() {
		StringBuilder risposta = new StringBuilder("Ciao, io sono ");
		risposta.append(this.getNome()+".");
		if (!haSalutato) risposta.append(this.presentazione); 
		else 
			risposta.append("Ci siamo gia' presentati!");
		this.haSalutato = true; 
		return risposta.toString();
	}
	
	public void setHaSalutato(boolean b){
		this.haSalutato=b;
	}
	public boolean getHasalutato(){
		return this.haSalutato;
	}
	
	@Override 
	public String toString() {
		return this.getNome(); 
	}
	abstract public String agisci(Partita partita); 
	
	public abstract String riceviRegalo(Attrezzo attrezzo, Partita partita);
} 
