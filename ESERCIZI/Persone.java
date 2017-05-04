public class Persone {
	private String[] nomi;

	public Persone(int n) {
		this.nomi = new String[n];
	}

	public int contaOmonimiDi(String nome) {
		// metodo da scrivere
		int cont=0;
		if(nome == null)
			return 0;
		for(int i = 0; i<nomi.length;i++){
			if(nome.equals(nomi[i]))
				cont++;
		}
		return cont;
	}

	public void aggiungiNome(int indice, String nome) {
		this.nomi[indice] = nome;
	}
}