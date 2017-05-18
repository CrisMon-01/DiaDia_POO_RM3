import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class Biblioteca {
	private List<LibroGenerics> elenco;
	public Biblioteca() {
		this.elenco = new ArrayList<>();
	}
	public void aggiungiLibro(LibroGenerics libro) {
		this.elenco.add(libro);
	}
	public List<LibroGenerics> elencoOrdinatoPerPagine(){
		Comparator<LibroGenerics> c=new ComparatorePagine();
		Collections.sort(this.elenco, c);
		return this.elenco;
	}
}