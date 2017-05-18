import java.util.Comparator;

public class ComparatoreStudentiAlb2 implements Comparator<StudenteList>{

	@Override
	public int compare(StudenteList arg0, StudenteList arg1) {
		// TODO Auto-generated method stub
		return arg0.getNome().compareTo(arg1.getNome());
	}

	
}
