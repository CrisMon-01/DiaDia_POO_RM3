import java.util.HashSet;
import java.util.Set;

public class AulaList2 {
	private Set<Studente> studenti;
	public AulaList2() { 
		this.studenti = new HashSet<>();
	}
	public boolean addStudente(Studente studente) {
		return this.studenti.add(studente);
	}
}