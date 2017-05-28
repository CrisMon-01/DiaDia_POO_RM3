package it.uniroma3.diadia;

import java.util.Scanner;

import it.uniroma3.diadia.comandi.AbstractComando;
import it.uniroma3.diadia.comandi.FabbricaDiComandiRiflessiva;

public class InterfacciaUtenteConsole implements InterfacciaUtente {



	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	private Partita partita;

	public InterfacciaUtenteConsole() {
		this.partita = new Partita();
	}

	@Override
	public void mostraMessaggio(String messaggio) throws Exception {			
		FabbricaDiComandiRiflessiva factory = new FabbricaDiComandiRiflessiva();
		AbstractComando comandoDaEseguire = factory.costruisciComando(messaggio);
		System.out.println(comandoDaEseguire.esegui(this.partita));
		if (this.partita.vinta())
			System.out.println("Hai vinto!");
		if (!this.partita.giocatoreIsVivo())
			System.out.println("Hai esaurito i CFU...");
	}

	@Override
	public String prendiIstruzione() throws Exception {
		String istruzione; 
		Scanner scannerDiLinee;
		scannerDiLinee = new Scanner(System.in);		
		
		do{	
			istruzione = scannerDiLinee.nextLine();
			mostraMessaggio(istruzione);
		}
		while (scannerDiLinee.hasNext() && !this.partita.isFinita());

		scannerDiLinee.close();
		return "";
	}

	public String getMessaggioBenvenuto() {
		return MESSAGGIO_BENVENUTO;
	}

}