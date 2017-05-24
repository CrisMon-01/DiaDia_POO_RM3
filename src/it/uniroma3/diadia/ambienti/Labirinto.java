package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;
import it.uniroma3.diadia.personaggi.Mago;
import it.uniroma3.diadia.personaggi.Strega;
import it.uniroma3.diadia.personaggi.Cane;

public class Labirinto {
	// CAMPI
	private Stanza stanzaIn;
	private Stanza stanzaVincente;
	// COSTRUTTORE
	public Labirinto(){
		init();
	}
	/**
	 * Crea tutte le stanze e le porte di collegamento
	 */
	public void init() {
		/* crea gli attrezzi */
		Attrezzo lanterna = new Attrezzo("lanterna", 3);
		Attrezzo osso = new Attrezzo("osso", 1);
		Attrezzo spada = new Attrezzo("spada", 10);
		Attrezzo tazzina = new Attrezzo("tazzina",2);
		Attrezzo laptop = new Attrezzo("laptop", 5);
		Attrezzo cartaigienica = new Attrezzo("cartaigienica", 2);
		Attrezzo risma = new Attrezzo ("risma", 6);
		Attrezzo macchinetta = new Attrezzo("macchinette", 100);
		Attrezzo chiave = new Attrezzo("chiave",1);
		Attrezzo latte = new Attrezzo("latte",1);
		Attrezzo caffe = new Attrezzo("caffe",1);
		/* crea stanze del labirinto */
		Stanza atrio = new Stanza("Atrio");
		Stanza aulaN11 = new Stanza("Aula N11");
		Stanza aulaN10 = new StanzaBloccata("AulaN10", "nord", "risma");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");
		Stanza corridoio2 = new Stanza("Corridoio2");
		Stanza mensa = new Stanza("Mensa");
		Stanza bar = new Stanza("bar");
		Stanza giardino = new StanzaMagica("giardino");
		Stanza corridoio1 = new StanzaBloccata("corridoio1", "nord", "chiave");
		/* collega le stanze */
		atrio.impostaStanzaAdiacente("est",laboratorio);
		atrio.impostaStanzaAdiacente("ovest", aulaN11);
		atrio.impostaStanzaAdiacente("nord", corridoio1);
		aulaN11.impostaStanzaAdiacente("est", atrio);
		aulaN11.impostaStanzaAdiacente("nord", aulaN10);
		aulaN10.impostaStanzaAdiacente("sud", aulaN11);
		aulaN10.impostaStanzaAdiacente("est", corridoio1);
		aulaN10.impostaStanzaAdiacente("ovest", bar);
		bar.impostaStanzaAdiacente("nord", mensa);
		bar.impostaStanzaAdiacente("est", aulaN10);
		mensa.impostaStanzaAdiacente("sud", bar);
		mensa.impostaStanzaAdiacente("est", corridoio2);
		corridoio2.impostaStanzaAdiacente("ovest", mensa);
		corridoio2.impostaStanzaAdiacente("est", biblioteca);
		laboratorio.impostaStanzaAdiacente("est", giardino);
		laboratorio.impostaStanzaAdiacente("ovest", atrio);
		giardino.impostaStanzaAdiacente("ovest", laboratorio);
		corridoio1.impostaStanzaAdiacente("sud", atrio);
		corridoio1.impostaStanzaAdiacente("nord", biblioteca);
		corridoio1.impostaStanzaAdiacente("ovest", aulaN10);
		biblioteca.impostaStanzaAdiacente("ovest", corridoio2);
		biblioteca.impostaStanzaAdiacente("sud", corridoio1);
		atrio.impostaStanzaAdiacente("sud", biblioteca);
		//creo personaggi
		AbstractPersonaggio m = new Mago("mago", "",cartaigienica);
		AbstractPersonaggio c = new Cane("cane","", osso, spada);
		AbstractPersonaggio s = new Strega("strega", "");
		
		aulaN10.setPersonaggio(s);
		corridoio2.setPersonaggio(c);
		laboratorio.setPersonaggio(m);
		
		/* pone gli attrezzi nelle stanze */
		aulaN10.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);
		bar.addAttrezzo(tazzina);
		bar.addAttrezzo(latte);
		bar.addAttrezzo(caffe);
		corridoio2.addAttrezzo(macchinetta);
		giardino.addAttrezzo(chiave);
		laboratorio.addAttrezzo(laptop);
		aulaN11.addAttrezzo(risma);
		corridoio1.addAttrezzo(spada);
		
		// il gioco comincia nell'atrio
		stanzaVincente = biblioteca;
		stanzaIn = atrio;
	}
	/**
	 * @return la stanza Vincente
	 */
	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}
	/**
	 * @return la stanza iniziale del labirinto
	 */
	public Stanza getStanzaIn(){
		return this.stanzaIn;
	}

}
