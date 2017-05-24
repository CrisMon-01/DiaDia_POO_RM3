package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoAiuto extends AbstractComando {

	static final private String[] elencoComandi = {"vai", "aiuto", "fine","prendi","posa","guarda","regala","interagisci","saluta"};
	
	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		{
			for(int i=0; i< elencoComandi.length; i++) 
				System.out.print(elencoComandi[i]+" ");
			System.out.println();
		}
	}
	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "aiuto";
	}

//	@Override
//	public void setParametro(String parametro) {
//		// TODO Auto-generated method stub
//	}
//
//	@Override
//	public Object getParametro() {
//		// TODO Auto-generated method stub
//		return null;
//	}


}
