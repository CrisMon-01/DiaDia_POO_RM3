import java.util.Set;
import java.util.TreeSet;

public class AulaContenentecomp {
	private Set<StudenteList> student;
	public AulaContenentecomp(){
		this.student = new TreeSet<StudenteList>();
	}
	public boolean addStud(StudenteList st){
		return this.student.add(st);
	}
}
