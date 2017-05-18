package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuia extends Stanza{
	private String nome;
	private String nomeAttrezzo;
	public StanzaBuia(String nome, String nomeAttrezzo) {
		super(nome);
		this.nomeAttrezzo=nomeAttrezzo;
	}
	/**
	 * getDescrizione è modellata in base alle richiesta
	 */
	@Override
	public String getDescrizione(){
		if(this.hasAttrezzo(nomeAttrezzo))
			return super.getDescrizione();
		else return "Qui c' è buio pesto";
	}
	

}
