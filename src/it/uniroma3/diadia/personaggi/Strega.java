package it.uniroma3.diadia.personaggi;

import java.util.Collections;
import java.util.List;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.ComparatoreStanzePerNumeroAttrezzi;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Strega  extends AbstractPersonaggio{
	private final static String MESSAGGIO_PIU_ATTREZZI="Ti ho spostato dove ci sono + attrezzi";
	private final static String MESSAGGIO_MENO_ATTREZZI="Ti ho spostato dove ci sono - attrezzi";
	private final static String RISPOSTA =  "hahahahahahaha";
	
	public Strega(String nome, String presentaz) {
		super(nome, presentaz);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String agisci(Partita partita) {
		List<Stanza> stanzeOrdinate = partita.getStanzaCorrente().getListOrdinataPerNumeroAttrezzi();
		ComparatoreStanzePerNumeroAttrezzi comp = new ComparatoreStanzePerNumeroAttrezzi();
		if(!haSalutato()){
			partita.setStanzaCorrente(Collections.max(stanzeOrdinate,comp));
			return MESSAGGIO_PIU_ATTREZZI;
		}
		else
			partita.setStanzaCorrente(Collections.min(stanzeOrdinate,comp));	
			return MESSAGGIO_MENO_ATTREZZI;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		return RISPOSTA;
	}

}
