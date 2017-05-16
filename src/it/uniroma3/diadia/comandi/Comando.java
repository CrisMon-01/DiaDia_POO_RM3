package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
/**
 * interfaccia per la gestione dei comandi
 * contiene metodi utili per la creazione di nuovi comandi
 * @author Cristian Monti
 *
 */
public interface Comando {
	public void esegui(Partita partita);
	public void setParametro(String parametro);
	public Object getParametro();
	public Object getNome();
}
