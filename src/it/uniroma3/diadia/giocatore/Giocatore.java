package it.uniroma3.diadia.giocatore;
/**
 * modello il giocatore che avrà una sua borsa e 
 * i CFU
 * @author Cristian Monti
 *
 */
public class Giocatore {
	//CAMPI
	static final private int CFU_INIZIALI = 20;
	private int cfu;
	private Borsa borsa;
	//COSTRUTTORE
	public Giocatore(){
		this.cfu = CFU_INIZIALI;
		this.borsa=new Borsa();
	}
	/**
	 * 
	 * @return CFU attuali
	 */
	public int getCfu() {
		return this.cfu;
	}
	/**
	 * modifico i CFU del giocatore attuale
	 * @param cfu
	 */
	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}
	/**
	 * 
	 * @return la borsa, variabile del giocatore
	 */
	public Borsa getBorsa() {
		return this.borsa;
	}
	/**
	 * posso assegnare una determianta borsa al giocatore 
	 * quando invoco il metodo
	 * @param borsa
	 */
	public void setBorsa(Borsa borsa) {
		this.borsa = borsa;		
	}
	
}
