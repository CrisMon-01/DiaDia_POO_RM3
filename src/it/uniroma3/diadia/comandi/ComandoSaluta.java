package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoSaluta extends AbstractComando{

	@Override
	public String esegui(Partita partita) {
		// TODO Auto-generated method stub
		AbstractPersonaggio personaggio = partita.getStanzaCorrente().getPersonaggio();
		return personaggio.saluta();
		//personaggio.setHaSalutato(true);
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "saluta";
	}

}
