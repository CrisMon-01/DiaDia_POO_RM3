package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPosa implements Comando {
	private String nomeAttezzo;
	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		if(nomeAttezzo==null)
			System.out.println("specificare l' oggetto");
		else{
			Borsa borsa = partita.getGiocatore().getBorsa();
			Attrezzo attrezzoDaPosare = borsa.removeAttrezzo(this.nomeAttezzo);
			if(attrezzoDaPosare!=null) {
				Stanza stanzaCorrente = partita.getStanzaCorrente();
				if (stanzaCorrente.addAttrezzo(attrezzoDaPosare))
					System.out.println(nomeAttezzo + " posato in " + stanzaCorrente.getNome());
				else{
					System.out.println("non sono riuscito a posare " + nomeAttezzo);
					borsa.addAttrezzo(attrezzoDaPosare);
				}
			}
		}
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		this.nomeAttezzo = parametro;
	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return this.nomeAttezzo;
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "posa";
	}

}
