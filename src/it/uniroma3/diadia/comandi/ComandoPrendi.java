package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPrendi implements Comando {
	private String nomeAttrezzo;
	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		if(nomeAttrezzo==null)
			System.out.println("specificare il nome dell oggetto");
		else{
			Attrezzo a = partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
			if(a == null)
				System.out.println("L' attrezzo non è presente nella stanza");
			else{
				Borsa b = partita.getGiocatore().getBorsa();
				if(!b.addAttrezzo(a))
					System.out.println("non puoi metter "+a.getNome()+" nella stanza");
				else{
					partita.getStanzaCorrente().removeAttrezzo(a);
					System.out.println("l' attrezzo è stato preso");
				}
			}
		}
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		this.nomeAttrezzo = parametro;
	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return nomeAttrezzo;
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "prendi";
	}

}
