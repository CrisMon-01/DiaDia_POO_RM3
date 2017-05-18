import java.util.Comparator;

public class ComparatorePagine implements Comparator<LibroGenerics>{

	@Override
	public int compare(LibroGenerics l1, LibroGenerics l2) {
		// TODO Auto-generated method stub
		return l1.getPagine()-l2.getPagine();
	}
}
