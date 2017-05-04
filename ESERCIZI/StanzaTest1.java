import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stanza bar = new Stanza("bar");
		Stanza mensa = new Stanza("mensa");
		bar.impostaStanzaAdiacente("nord", mensa);
		mensa.impostaStanzaAdiacente("sud", bar);
		System.out.println(bar.getStanzaAdiacente("nord").getDescrizione());
		System.out.println(mensa.getStanzaAdiacente("sud").getDescrizione());
		Attrezzo tazzina = new Attrezzo("tazzina",1);
		Attrezzo piatto = new Attrezzo("piatto", 1);
		mensa.addAttrezzo(piatto);
		bar.addAttrezzo(tazzina);
		for(int i =0; i < mensa.getStanzaAdiacente("sud").getAttrezzi().length; i++)
			if(mensa.getStanzaAdiacente("sud").getAttrezzi()[i]!=null)
				System.out.println(mensa.getStanzaAdiacente("sud").getAttrezzi()[i].toString());
		for(int i =0; i < bar.getStanzaAdiacente("nord").getAttrezzi().length; i++)
			if(bar.getStanzaAdiacente("nord").getAttrezzi()[i]!=null)
				System.out.println(bar.getStanzaAdiacente("nord").getAttrezzi()[i].toString());
	}

}
