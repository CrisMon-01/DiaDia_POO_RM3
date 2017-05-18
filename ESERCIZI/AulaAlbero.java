import java.util.Set;
import java.util.TreeSet;

public class AulaAlbero {
	private Set<StudenteList> stud;
	public AulaAlbero(){
		this.stud = new TreeSet<>(new ComparatoreStudentiAlb());
	}
	public boolean addStudente(StudenteList studentes){
		return this.addStudente(studentes);
	}
	
}
