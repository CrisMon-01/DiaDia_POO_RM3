package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {
	private Stanza stanzaCorrente;
	private boolean finita;
	private Labirinto labirinto1;
	private Giocatore giocatore;
	
	public Partita(){
		this.labirinto1= new Labirinto();
		this.stanzaCorrente = labirinto1.getStanzaIn();
		this.finita = false;
		this.giocatore = new Giocatore();
	}
   
	/**
	 * modifica il camoi stanzacorrente
	 * @param stanzaCorrente
	 */
	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}
	/**
	 * 
	 * @return StanzaCorrente
	 */
	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.getStanzaCorrente()== labirinto1.getStanzaVincente();
	}
	
	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (this.getGiocatore().getCfu() == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}
	/**
	 * 
	 * @return labirinto in cui si svolge la partita
	 */
	public Labirinto getLabirinto(){
		return this.labirinto1;
	}
	/**
	 * 
	 * @return giocatore corrente
	 */
	public Giocatore getGiocatore() {
		return this.giocatore;
	}
	/**
	 * @return true se ho ancora CFU
	 */
	public boolean giocatoreIsVivo() {
		// TODO Auto-generated method stub
		if(this.giocatore.getCfu()>0)
			return true;
		return false;
	}
}
