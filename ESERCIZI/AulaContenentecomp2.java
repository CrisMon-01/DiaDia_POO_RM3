import java.util.Set;
import java.util.TreeSet;

public class AulaContenentecomp2 {
	private Set<StudenteList> student;
	public AulaContenentecomp2(){
		this.student = new TreeSet<StudenteList>();
	}
	public boolean addStud(StudenteList st){
		return this.student.add(st);
	}
}
