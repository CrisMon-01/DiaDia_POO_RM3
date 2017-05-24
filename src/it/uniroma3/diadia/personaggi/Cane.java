package it.uniroma3.diadia.personaggi;

import org.omg.Messaging.SyncScopeHelper;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Giocatore;

public class Cane extends AbstractPersonaggio{
	//CAMPI
	private Attrezzo ciboPreferito;
	private Attrezzo regalo;
	public Cane(String nome, String presentaz, Attrezzo cibo, Attrezzo regalo) {
		super(nome, presentaz);
		// TODO Auto-generated constructor stub
		this.ciboPreferito = cibo;
		this.regalo=regalo;
	}

	@Override
	public String agisci(Partita partita) {
		// TODO Auto-generated method stub
		String s = "il cane ti ha morso! i tuoi CFU sono diminuiti";
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		return s;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		if(!attrezzo.getNome().equals(ciboPreferito.getNome())){
			partita.getStanzaCorrente().addAttrezzo(attrezzo);
			return "il cane non vuole il tuo attrezzo e lo lascia cadere nella stanza";
		}
		else	partita.getStanzaCorrente().addAttrezzo(this.regalo);
			return "il cane ha accettato il tuo dono e te ne ha fatto un'altro. ora nella stanza c'è un nuovo attrezzo: "+regalo.getNome();
	}

}
