public class Sequenza {
	private int[] sequenza;
	public Sequenza(int n) {
		sequenza = new int[n];
	}
	public int massimo() {
		// scrivere il codice di questo metodo:
		// deve restituire il valore piu' grande
		// presente nell'array sequenza
		int max = sequenza[0];
		for(int i =1; i < sequenza.length; i++){
			if(sequenza[i]>max)
				max=sequenza[i];
		}
		return max;
	}
	public void setElemento(int indice, int valore) {
		sequenza[indice] = valore;
	}
}