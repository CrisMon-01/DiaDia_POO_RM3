public class Studente {
	private String nome;
	private String cognome;
	private String matricola;

	public Studente(String matricola) {
		this(null, null, matricola);
	}

	public Studente(String nome, String cognome) {
		this(nome, cognome, null);
	}

	// pi� completo, faccio gli altri in funz. del pi� ampio
	public Studente(String nome, String cognome, String matricola) {
		this.nome = nome;
		this.cognome = cognome;
		this.matricola = matricola;
	}
}