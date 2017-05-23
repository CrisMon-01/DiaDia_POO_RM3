package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza{
	//CAMPI
//	private String nome;
	private String direzionebloccata;
	private String sbloccante;
	//COSTRUTTORE
	public StanzaBloccata(String nome,String direzionebloccata,String sbloccante) {
		super(nome);
		this.direzionebloccata = direzionebloccata;
		this.sbloccante = sbloccante;
	}
	/**
	 * getStanzaAdiacente è diverso dalla superclasse
	 */
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		// TODO Auto-generated method stub
	if(!this.hasAttrezzo(sbloccante))
		return this;
	else
		return super.getStanzaAdiacente(direzione);
	}
	/**
	 * getDescrizione è modificato
	 */
	@Override
	public String getDescrizione() {
		// TODO Auto-generated method stub
		if(!this.hasAttrezzo(sbloccante)){
			String s = "Stanza Bloccata ti servirà un: "+sbloccante+" per andare verso: "+direzionebloccata;
			return s;
		}
		else
			return super.getDescrizione();
	}

}
