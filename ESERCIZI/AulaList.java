import java.util.HashSet;
import java.util.Set;

public class AulaList {
	private Set<Studente> studenti;
	public AulaList() { 
		this.studenti = new HashSet<>();
	}
	public boolean addStudente(Studente studente) {
		return this.studenti.add(studente);
	}
}