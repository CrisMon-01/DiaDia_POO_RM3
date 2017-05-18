public class LibroGenerics implements Comparable<LibroGenerics> {
	private String titolo;
	private int pagine;
	public LibroGenerics(String titolo, int pagine) {
		this.titolo = titolo;
		this.pagine = pagine;
	}
	public String getTitolo() {
		return this.titolo;
	}
	public int getPagine() {
		return this.pagine;
	}
	@Override
	public int compareTo(LibroGenerics libro) {
		return this.getTitolo().compareTo(libro.getTitolo());
	}
}