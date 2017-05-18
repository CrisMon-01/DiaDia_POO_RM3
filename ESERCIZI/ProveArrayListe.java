import java.util.*;
public class ProveArrayListe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> listina = new ArrayList<>();
		listina.add("primo");
		listina.add("secondo");
		listina.add("terzo");
		System.out.println(listina.remove("secondo"));
		System.out.println(listina.size());
		Iterator<String> it=listina.iterator();
		System.out.println(it.next());
		System.out.println(it.next());
	}
}
