package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoFine extends AbstractComando {

	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		System.out.println("Grazie di aver giocato!");  // si desidera smettere
		partita.setFinita();
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "fine";
	}
//	@Override
//	public void setParametro(String parametro) {
//		// TODO Auto-generated method stub
//
//	}
//	@Override
//	public Object getParametro() {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
