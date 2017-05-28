package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoRegala extends AbstractComando {
	String nomeAttrezzo;

	@Override
	public String esegui(Partita partita) {
		if(nomeAttrezzo==null)
			return "specificare l' oggetto";
		Attrezzo regalato = partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
		if(regalato.getNome() != null)
			return partita.getStanzaCorrente().getPersonaggio().riceviRegalo(regalato, partita);
		return "non è stato trovato l' attrezzo da regalare";
	}

	@Override
	public String getNome() {
		return "regala";
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo=parametro;
	}
}
